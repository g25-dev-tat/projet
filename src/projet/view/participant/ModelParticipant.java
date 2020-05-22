package projet.view.participant;

import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoEquipe;
import projet.data.Benevole;
import projet.data.AdminAppli;
import projet.data.Course;


public class ModelParticipant {
	
	
	// Données observables 
	
	private final ObservableList<AdminAppli> liste = FXCollections.observableArrayList();
	
	private final AdminAppli		courant = new AdminAppli();
	
	
	// Autres champs
	
    @Inject
	private IMapper		        mapper;
    @Inject
	private DaoEquipe			daoPersonne;
	@Inject
    private ModelEquipe 		modelCategorie;
	
	
	// Getters 
	
	public ObservableList<AdminAppli> getListe() {
		return liste;
	}
	
	public AdminAppli getCourant() {
		return courant;
	}
	
	public ObservableList<Benevole> getCategories() {
		return modelCategorie.getListe();
	}

	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoPersonne.listerTout() );
	}

	
	// Actions
	
	public void preparerAjouter() {
		modelCategorie.actualiserListe();
		mapper.update( courant, new AdminAppli() );
	}
	

	public void preparerModifier( AdminAppli item ) {
		modelCategorie.actualiserListe();
		mapper.update( courant, daoPersonne.retrouver( item.getId() ) );
	}
	

	public void validerMiseAJour() {

		// Vérifie la validité des données
		
		StringBuilder message = new StringBuilder();
		
		if( courant.getNom() == null || courant.getNom().isEmpty() ) {
			message.append( "\nLe nom ne doit pas être vide." );
		} else  if ( courant.getNom().length()> 25 ) {
			message.append( "\nLe nom est trop long." );
		}

		if( courant.getPrenom() == null || courant.getPrenom().isEmpty() ) {
			message.append( "\nLe prénom ne doit pas être vide." );
		} else if ( courant.getPrenom().length()> 25 ) {
			message.append( "\nLe prénom est trop long." );
		}

		if( courant.getCategorie() == null ) {
			message.append( "\nLe catégorie doit être indiquée." );
		}
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}

		
		// Effectue la mise à jour
		
		if ( courant.getId() == null ) {
			// Insertion
			courant.setId( daoPersonne.inserer( courant ) );
		} else {
			// modficiation
			daoPersonne.modifier( courant );
		}
	}
	

	public void supprimer( AdminAppli item ) {
		daoPersonne.supprimer( item.getId() );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
	}
	

	public void ajouterTelephone() {
		courant.getTelephones().add( new Course() );
	}
	

	public void supprimerTelephone( Course telephone )  {
		courant.getTelephones().remove( telephone );
	}
	
}
