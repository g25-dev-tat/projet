package projet.view.benevole;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.converter.IntegerStringConverter;
import jfox.javafx.util.ConverterStringInteger;
import jfox.javafx.util.ListenerFocusValidation;
import jfox.javafx.view.IManagerGui;
import projet.data.Benevole;
import projet.data.Equipe;
import projet.view.EnumView;


public class ControllerAffectationTacheForm {

	
	// Composants de la vue
	
	@FXML
	private ComboBox<Postes>	Poste;
	@FXML
	private DatePicker	Date;
	@FXML
	private CheckBox Tache1; 
	@FXML
	private CheckBox Tache2;
	@FXML
	private CheckBox Tache3; 
	@FXML
	private CheckBox Tache4; 
	@FXML
	private CheckBox Tache5; 
	@FXML
	private CheckBox Tache6; 
	@FXML
	private CheckBox Tache7; 
	@FXML
	private CheckBox Tache8; 
	@FXML
	private CheckBox Tache9; 
	@FXML
	private CheckBox Tache10; 
	@FXML
	private CheckBox Tache11;
	@FXML
	private CheckBox Tache12;
	@FXML
	private Button buttonOK;
	@FXML
	private Button buttonAnnuler;

	
	// Autres champs
	
	@Inject
	private IManagerGui		managerGui;
	@Inject
	private ModelBenevole	modelBenevole;


	// Initialisation du Controller

	@FXML
	private void initialize() {

		// Data binding
		
		Benevole courant = modelBenevole.getCourant();

		Poste.textProperty().bindBidirectional( courant.PosteProperty(), new ConverterStringInteger()  );

		textFieldNom.textProperty().bindBidirectional( courant.nomProperty() );
		
		textFieldAnneeCreation.textProperty().bindBidirectional( courant.anneeCreationProperty(), new ConverterStringInteger( "###0" ) );
		textFieldAnneeCreation.focusedProperty().addListener( new ListenerFocusValidation( courant.anneeCreationProperty()  ));
		
		checkBoxSiege.selectedProperty().bindBidirectional( courant.flagSiegeProperty() );
		
	}
	
	
	// Actions
	
	@FXML
	private void doAnnuler() {
		managerGui.showView( EnumView.BenevoleListe );
	}
	
	@FXML
	private void doValider() {
		modelBenevole.validerMiseAJour();
		managerGui.showView( EnumView.BenevoleListe );
	}
	
}
