package projet.view.participant;

import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoParticipant;
import projet.dao.DaoCompetition;
import projet.dao.DaoEquipe;
import projet.data.Benevole;
import projet.data.Equipe;


public class ModelEquipe  {
	
	
	// Données observables 
	
	private final ObservableList<Benevole> liste = FXCollections.observableArrayList(); 
	
	private final Equipe	courant = new Equipe();

	
	// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoParticipant	daoCategorie;
    @Inject
    private DaoEquipe		daoPersonne;
    @Inject
    private DaoCompetition			daoMemo;
	
	
	// Getters 
	
	public ObservableList<Benevole> getListe() {
		return liste;
	}
	
	public Benevole getCourant() {
		return courant;
	}
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoCategorie.listerTout() );
 	}


	// Actions
	
	public void preparerAjouter() {
		mapper.update( courant, new Benevole() );
	}
	
	public void preparerModifier( Benevole item ) {
		mapper.update( courant, daoCategorie.retrouver( item.getId() ) );
	}
	
	
	public void validerMiseAJour() {

		// Vérifie la validité des données
		
		StringBuilder message = new StringBuilder();

		if( courant.getLibelle() == null || courant.getLibelle().isEmpty() ) {
			message.append( "\nLe libellé ne doit pas être vide." );
		} else  if ( courant.getLibelle().length()> 25 ) {
			message.append( "\nLe libellé est trop long : 25 maxi." );
		}
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}
		
		
		// Effectue la mise à jour
		
		if ( courant.getId() == null ) {
			// Insertion
			courant.setId( daoCategorie.inserer( courant ) );
		} else {
			// modficiation
			daoCategorie.modifier( courant );
		}
	}
	
	
	public void supprimer( Benevole item ) {
		
		// Vérifie l'abence de personnes rattachées à la catégorie
		if ( daoPersonne.compterPourCategorie( item.getId() ) != 0 ) {
			throw new ExceptionValidation( "Des personnes sont rattachées à cette catégorie.." ) ;
		}
		
		// Vérifie l'abence de mémos rattaches à la catégorie
		if ( daoMemo.compterPourCategorie( item.getId() ) != 0 ) {
			throw new ExceptionValidation( "Des mémos sont rattachés à cette catégorie.." ) ;
		}
		
		daoCategorie.supprimer( item.getId() );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
	}
	
}
