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
	private TextField	Poste;
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
	
	private String textTache=" ";
	@Inject
	private IManagerGui		managerGui;
	@Inject
	private ModelBenevole	modelBenevole;


	// Initialisation du Controller

	@FXML
	private void initialize() {

		// Data binding
		System.out.println("Initilisation de l'affectation des taches");
		
		Benevole courant = modelBenevole.getCourant();
		
	
//
//		Poste.textProperty().bindBidirectional( courant.PosteProperty(), new ConverterStringInteger()  );
//
//		textFieldNom.textProperty().bindBidirectional( courant.nomProperty() );
//		
//		textFieldAnneeCreation.textProperty().bindBidirectional( courant.anneeCreationProperty(), new ConverterStringInteger( "###0" ) );
//		textFieldAnneeCreation.focusedProperty().addListener( new ListenerFocusValidation( courant.anneeCreationProperty()  ));
//		
//		checkBoxSiege.selectedProperty().bindBidirectional( courant.flagSiegeProperty() );
		Taches();
		
	}
	
	
	// Actions
	
	@FXML
	private void doAnnuler() {
		managerGui.showView( EnumView.BenevoleListe );
		//textTache="";
	}
	
	@FXML
	private void doValider() {
		//modelBenevole.validerMiseAJour();
		System.out.println("Poste : "+Poste.getText()+"\nDate : "+Date.getValue()+"\nTaches : "+textTache);
		managerGui.showView( EnumView.BenevoleListe );
		//textTache="";
	}
	
	@FXML
	private String Taches() {
		if(Tache1.isSelected())
			textTache+=", dossards";
		if(Tache2.isSelected())
			textTache+=", Canoe";
		if(Tache3.isSelected())
			textTache+=", ravito eau";
		if(Tache4.isSelected())
			textTache+=", chrono";
		if(Tache5.isSelected())
			textTache+=", ouverture";
		if(Tache6.isSelected())
			textTache+=", fermeture";
		if(Tache7.isSelected())
			textTache+=", Buvette";
		if(Tache8.isSelected())
			textTache+=", check equipe au gué";
		if(Tache9.isSelected())
			textTache+=", verif gilet au gué";
		if(Tache10.isSelected())
			textTache+=", rangement gilet";
		if(Tache11.isSelected())
			textTache+=", respo gué de la roche";
		if(Tache12.isSelected())
			textTache+=", pagais et dingue";
		
		return textTache;
	}
	
}
