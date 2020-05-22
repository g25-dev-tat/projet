package projet.view.participant;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Benevole;
import projet.report.EnumReport;
import projet.report.ManagerReport;


public class ControllerEtatPersonnesParCategorie1 {
	
	
	// Composants de la vue

	@FXML
	private ListView<Benevole>	listView;
	@FXML
	private Button				buttonEtat;


	// Autres champs
	
	@Inject
	private IManagerGui			managerGui;
	@Inject
	private ManagerReport		managerReport;
	@Inject
	private ModelEquipe		modelCategorie;
	
	
	// Initialisation du Controller

	@FXML
	private void initialize() {

		// Data binding
		listView.setItems( modelCategorie.getListe() );
		
		// Configuraiton des boutons
		listView.getSelectionModel().selectedItemProperty().addListener(
				(obs, oldVal, newVal) -> {
					configurerBoutons();
		});
		configurerBoutons();
		
	}
	
	public void refresh() {
		modelCategorie.actualiserListe();
		UtilFX.selectInListView( listView, modelCategorie.getCourant() );
		listView.requestFocus();
	}

	
	// Actions
	
	@FXML
	private void doFermer() {
		managerGui.closeStage();
	}

	@FXML
	private void doEtat() {
		Map<String, Object> params = new HashMap<>();
		params.put( "idCategorie", listView.getSelectionModel().getSelectedItem().getId() );
		managerReport.showViewer( EnumReport.PersonnesParCategorie1, params);
	}
	
	
	// Gestion des évènements

	// Clic sur la liste
	@FXML
	private void gererClicSurListe( MouseEvent event ) {
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			if (event.getClickCount() == 2) {
				if ( listView.getSelectionModel().getSelectedIndex() == -1 ) {
					managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
				} else {
					doEtat();
				}
			}
		}
	}
	
	// Appui d'une touche sur la liste
	@FXML
	private void gererToucheSurListe( KeyEvent event ) {
		// Si échap ferme la boîte de dialogue 
		if ( event.getCharacter().charAt(0) == 27 )  {
			doFermer();;
		}
	}

	
	// Méthodes auxiliaires
	
	private void configurerBoutons() {
		
    	if( listView.getSelectionModel().getSelectedItems().isEmpty() ) {
			buttonEtat.setDisable(true);
		} else {
			buttonEtat.setDisable(false);
		}
	}

}