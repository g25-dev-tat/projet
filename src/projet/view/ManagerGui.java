package projet.view;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import jfox.commun.context.IContext;
import jfox.javafx.view.ManagerGuiAbstract;


public class ManagerGui extends ManagerGuiAbstract {

	
	// Champs
	
	@Inject
	private IContext context;
	
	
	// Initialisation
	
	@PostConstruct
	public void init() {
		setFactoryController( context::getBeanNew );
		addRessourcesToClose( context );
	}

	
	// Actions

	@Override
	protected void configureStage()  {
		
		// Choisit la vue à afficher
		showView( EnumView.Connexion);
		
		// Configure le stage
		stage.setTitle( "Application de gestion des participants et des bénévoles" );
		stage.setWidth(800);
		stage.setHeight(600);
		stage.setMinWidth(400);
		stage.setMinHeight(300);
		stage.setResizable(false);
		stage.getIcons().add(new Image(getClass().getResource("05.png").toExternalForm()));
		
		// Configuration par défaut pour les boîtes de dialogue
		typeConfigDialogDefault = ConfigDialog.class;
	}

	
	@Override
	public Scene createScene( Parent root ) {
		BorderPane paneMenu = new BorderPane( root );
		paneMenu.setTop( context.getBeanNew( MenuBarAppli.class ) );
		//try {
		//	paneMenu=FXMLLoader.load(getClass().getResource("/view/systeme/ViewConnexion.fxml"));
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		Scene scene = new Scene( paneMenu );
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//scene.getStylesheets().add(getClass().getResource("/image/style.css").toExternalForm());
		return scene;
	}
	
}