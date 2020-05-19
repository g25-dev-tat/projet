package projet.view.compte;


import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoCompte2;
import projet.data.Participant;


public class ModelCompte {
	
	
	// Données observables 
	
	private final ObservableList<Participant> liste = FXCollections.observableArrayList(); 
	
	private final Participant	courant = new Participant();
	
	
	// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoCompte2		daoCompte;
	
	
	// Getters
	
	public ObservableList<Participant> getListe() {
		return liste;
	}

	public Participant getCourant() {
		return courant;
	}
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoCompte.listerTout() );
 	}
	
	
	// Actions
	
	public void preparerAjouter() {
		mapper.update( courant, new Participant() );
	}

	
	public void preparerModifier( Participant item ) {
		mapper.update( courant, daoCompte.retrouver( item.getId() ) );
	}
	
	
	public void validerMiseAJour() {

		// Vérifie la validité des données
		
		StringBuilder message = new StringBuilder();
		
		if( courant.getLogin() == null || courant.getLogin().isEmpty() ) {
			message.append( "\nLe pseudo ne doit pas être vide." );
		} else 	if ( courant.getLogin().length() < 3 ) {
			message.append( "\nLe pseudo est trop court : 3 mini." );
		} else  if ( courant.getLogin().length()> 25 ) {
			message.append( "\nLe pseudo est trop long : 25 maxi." );
		} else 	if ( ! daoCompte.verifierUnicitePseudo( courant.getLogin(), courant.getId() ) ) {
			message.append( "\nLe pseudo " + courant.getLogin() + " est déjà utilisé." );
		}
		
		if( courant.getPass() == null || courant.getPass().isEmpty() ) {
			message.append( "\nLe mot de passe ne doit pas être vide." );
		} else  if ( courant.getPass().length()< 3 ) {
			message.append( "\nLe mot de passe est trop court : 3 mini." );
		} else  if ( courant.getPass().length()> 25 ) {
			message.append( "\nLe mot de passe est trop long : 25 maxi." );
		}
		
		if( courant.getEmail() == null || courant.getEmail().isEmpty() ) {
			message.append( "\nL'adresse e-mail ne doit pas être vide." );
		} else  if ( courant.getEmail().length()> 100 ) {
			message.append( "\nL'adresse e-mail est trop longue : 100 maxi." );
		}
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}
		
		
		// Effectue la mise à jour
		
		if ( courant.getId() == null ) {
			// Insertion
			courant.setId( daoCompte.inserer( courant ) );
		} else {
			// modficiation
			daoCompte.modifier( courant );
		}
	}
	
	
	public void supprimer( Participant item ) {
		daoCompte.supprimer( item.getId() );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
	}

}
