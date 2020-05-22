package projet.view.systeme;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import jfox.commun.exception.ExceptionValidation;
import projet.dao.DaoCompte2;
import projet.data.AdminAppli;
import projet.data.Participant;


public class ModelConnexion {
	
	// Logger
	public static final Logger logger = Logger.getLogger( ModelConnexion.class.getName() );
	
	
	// Données observables 
	
	// Vue connexion
	private final AdminAppli courant = new AdminAppli();

	// Compte connecté
	private final Property<AdminAppli>	compteActif = new SimpleObjectProperty<>();

	
	// Autres champs
	@Inject
	private DaoCompte2	daoCompte;
	

	// Getters 
	
	public AdminAppli getCourant() {
		return courant;
	}
	
	public Property<AdminAppli> compteActifProperty() {
		return compteActif;
	}
	
	public AdminAppli getCompteActif() {
		return compteActif.getValue();
	}
	
	
	// Initialisation
	
	@PostConstruct
	public void init() {
		courant.setLogin( "Whitley" );
		courant.setPass( "Rogan54321" );
		
		//courant.setLogin( "Rivers" );
		//courant.setPass( "Reed654321" );
	}
	
	
	// Actions


	public void ouvrirSessionUtilisateur() {

		AdminAppli compte = daoCompte.validerAuthentification(
					courant.loginProperty().getValue(), courant.passProperty().getValue() );
		
		if( compte == null ) {
			throw new ExceptionValidation( "Pseudo ou mot de passe invalide." );
		} else {
			Platform.runLater( () -> compteActif.setValue(compte) );
		}
	}
	

	public void fermerSessionUtilisateur() {
		compteActif.setValue( null );
	}

}
