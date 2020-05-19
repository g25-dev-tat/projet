package projet.view.systeme;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import jfox.commun.exception.ExceptionValidation;
import projet.dao.DaoCompte2;
import projet.data.Participant;


public class ModelConnexion {
	
	// Logger
	public static final Logger logger = Logger.getLogger( ModelConnexion.class.getName() );
	
	
	// Données observables 
	
	// Vue connexion
	private final Participant courant = new Participant();

	// Compte connecté
	private final Property<Participant>	compteActif = new SimpleObjectProperty<>();

	
	// Autres champs
	@Inject
	private DaoCompte2	daoCompte;
	

	// Getters 
	
	public Participant getCourant() {
		return courant;
	}
	
	public Property<Participant> compteActifProperty() {
		return compteActif;
	}
	
	public Participant getCompteActif() {
		return compteActif.getValue();
	}
	
	
	// Initialisation
	
	@PostConstruct
	public void init() {
		courant.setLogin( "Whitley" );
		courant.setPass( "Rogan54321" );
	}
	
	
	// Actions


	public void ouvrirSessionUtilisateur() {

		Participant compte = daoCompte.validerAuthentification(
					courant.loginProperty().getValue(), courant.passProperty().getValue() );
		
		if( compte == null ) {
			throw new ExceptionValidation( "Pseudo ou mot de passe invalide." );
		} else {
			Platform.runLater( () -> compteActif.setValue( compte ) );
		}
	}
	

	public void fermerSessionUtilisateur() {
		compteActif.setValue( null );
	}

}
