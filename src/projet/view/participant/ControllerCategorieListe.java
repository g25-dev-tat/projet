//package projet.view.participant;
//
//import javax.inject.Inject;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.ListView;
//import javafx.scene.input.MouseButton;
//import javafx.scene.input.MouseEvent;
//import jfox.javafx.util.UtilFX;
//import jfox.javafx.view.IManagerGui;
//import projet.data.Benevole;
//import projet.view.EnumView;
//
//
//public class ControllerCategorieListe {
//	
//	
//	// Composants de la vue
//
//	@FXML
//	private ListView<Benevole>	listView;
//	@FXML
//	private Button				buttonModifier;
//	@FXML
//	private Button				buttonSupprimer;
//
//
//	// Autres champs
//	
//	@Inject
//	private IManagerGui			managerGui;
//	@Inject
//	private ModelEquipe		modelCategorie;
//	
//	
//	// Initialisation du Controller
//
//	@FXML
//	private void initialize() {
//
//		// Data binding
//		listView.setItems( modelCategorie.getListe() );
//		
//		// Configuraiton des boutons
//		listView.getSelectionModel().selectedItemProperty().addListener(
//				(obs, oldVal, newVal) -> {
//					configurerBoutons();
//		});
//		configurerBoutons();
//		
//	}
//	
//	public void refresh() {
//		modelCategorie.actualiserListe();
//		UtilFX.selectInListView( listView, modelCategorie.getCourant() );
//		listView.requestFocus();
//	}
//
//	
//	// Actions
//	
//	@FXML
//	private void doAjouter() {
//		modelCategorie.preparerAjouter();;
//		managerGui.showView( EnumView.CategorieForm );
//	}
//
//	@FXML
//	private void doModifier() {
//		modelCategorie.preparerModifier( listView.getSelectionModel().getSelectedItem() );
//		managerGui.showView( EnumView.CategorieForm );
//	}
//
//	@FXML
//	private void doSupprimer() {
//		if ( managerGui.showDialogConfirm( "Confirmez-vous la suppresion ?" ) ) {
//			modelCategorie.supprimer( listView.getSelectionModel().getSelectedItem() );
//			refresh();
//		}
//	}
//	
//	
//	// Gestion des évènements
//
//	// Clic sur la liste
//	@FXML
//	private void gererClicSurListe( MouseEvent event ) {
//		if (event.getButton().equals(MouseButton.PRIMARY)) {
//			if (event.getClickCount() == 2) {
//				if ( listView.getSelectionModel().getSelectedIndex() == -1 ) {
//					managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
//				} else {
//					doModifier();
//				}
//			}
//		}
//	}
//
//	
//	// Méthodes auxiliaires
//	
//	private void configurerBoutons() {
//		
//    	if( listView.getSelectionModel().getSelectedItems().isEmpty() ) {
//			buttonModifier.setDisable(true);
//			buttonSupprimer.setDisable(true);
//		} else {
//			buttonModifier.setDisable(false);
//			buttonSupprimer.setDisable(false);
//		}
//	}
//
//}
