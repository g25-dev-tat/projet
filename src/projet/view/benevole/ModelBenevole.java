package projet.view.benevole;

import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoBenevole;
import projet.data.Benevole;


public class ModelBenevole  {
	
	
	// Données observables 
	
	private final ObservableList<Benevole> liste = FXCollections.observableArrayList(); 
	
	private final Benevole courant = new Benevole();

	
	// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoBenevole		daoBenevole;
	
	
	// Getters 
	
	public ObservableList<Benevole> getListe() {
		return liste;
	}
	
	public Benevole getCourant() {
		return courant;
	}
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoBenevole.listerBenevole() );
 	}


	// Actions
	
	public void preparerAttribution() {
		mapper.update( courant, new Benevole() );
	}
	
	public void preparerImpression( Benevole item ) {
		mapper.update( courant, daoBenevole.retrouver( item.getId() ) );
	}
	
	
	public void validerMiseAJour() {

		// Vérifie la validité des données
		
		StringBuilder message = new StringBuilder();

		if( courant.getNom() == null || courant.getNom().isEmpty() ) {
			message.append( "\nLe nom ne doit pas être vide." );
		} else  if ( courant.getNom().length()> 50 ) {
			message.append( "\nLe nom est trop long : 50 maxi." );
		}

//		if( courant.getAnneeCreation() != null ) {
//			if ( courant.getAnneeCreation() < 1900  
//					|| courant.getAnneeCreation() > 2100 ) {
//				message.append( "\nValeur incorrecte pour l'année de création." );
//			}
//		}
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}
		
		
		// Effectue la mise à jour
		
		if ( courant.getId() == null ) {
			// Insertion
			courant.setId( daoBenevole.insererUnBenevole(courant) );
		} else {
			// modficiation
			daoBenevole.modifier( courant );
		}
	}
	
	
	public void supprimer(Benevole item ) {
		
		daoBenevole.supprimer( item.getId() );
		System.out.println( UtilFX.findNext( liste, item ) );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
	}

	public Benevole afficher(Benevole item) {
		Benevole b;
		b=DaoBenevole.affich(item);
		System.out.println(item);
		mapper.update( courant, item );
		return b;
		
	}
	
}
