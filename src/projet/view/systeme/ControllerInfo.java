package projet.view.systeme;

import javax.inject.Inject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import jfox.javafx.view.IManagerGui;
import projet.view.EnumView;


public class ControllerInfo {
	
	
	// Composants de la vue
	
	@FXML
	private TextField tfSearch;
	
	@FXML
	private Button profil;
	
	@FXML
	private Button Benevole;
	
	@FXML
	private Button Participant;
	
	@FXML
	private Button Competition;
	
	@FXML
	private Button ContactAdmin;
	
	@FXML
	private ImageView Search;
	
	@FXML
	private ImageView Help;
	
	@FXML
	private ImageView Deconnect;

	
	// Autres champs
	
	@Inject
	private ModelInfo	modelInfo;
	
	@Inject
	private IManagerGui		managerGui;
	
	
	// Initialisation
	
	@FXML
	private void initialize() {
		System.out.println("Initialisation");
		// Data binding
		//labelTitre.textProperty().bind( modelInfo.titreProperty() );
		//labelMessage.textProperty().bind( modelInfo.messageProperty() );
		
	}
	
	
	@FXML
	private void Benevole(ActionEvent ev) {
		System.out.println("Bénévole");
		managerGui.showView(EnumView.BenevoleListe);
	}
	
	@FXML
	private void Participant(ActionEvent ev) {
		System.out.println("Participant");
	}
	
	@FXML
	private void Competition(ActionEvent ev) {
		System.out.println("Compétition");
	}
	
	@FXML
	private void contacterAdmin(ActionEvent ev) {
		System.out.println("Besoin de l'admin ?");
	}
	
	@FXML
	private void Profil(ActionEvent ev) {
		System.out.println("Mon profil");
	}
	@FXML
	private void search(ActionEvent ev) {
		System.out.println("Rechercher le participant ou le bénévole nommé "+tfSearch.getText());
	}

}
