//package projet.view.compte;
//
//import javax.inject.Inject;
//
//import javafx.collections.ListChangeListener;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.ListCell;
//import javafx.scene.control.ListView;
//import javafx.scene.input.MouseButton;
//import javafx.scene.input.MouseEvent;
//import jfox.javafx.util.UtilFX;
//import jfox.javafx.view.IManagerGui;
//import projet.data.Participant;
//import projet.view.EnumView;
//
//
//public class ControllerCompteListe  {
//	
//	
//	// Composants de la vue
//
//	@FXML
//	private ListView<Participant>	listView;
//	@FXML
//	private Button				buttonModifier;
//	@FXML
//	private Button				buttonSupprimer;
//	@FXML
//	private Button				buttonMemos;
//
//	
//	// Autres champs
//	
//	@Inject
//	private IManagerGui			managerGui;
//	@Inject
//	private ModelCompte			modelCompte;
//	
//	
//	// Initialisation du Controller
//
//	@FXML
//	private void initialize() {
//		
//		// Configuration de l'objet ListView
//		
//		// Data binding
//		listView.setItems( modelCompte.getListe() );
//
//		// Affichage
//		listView.setCellFactory( (list) -> {
//		    return new ListCell<Participant>() {
//		        @Override
//		        protected void updateItem(Participant item, boolean empty) {
//		            super.updateItem(item, empty);
//		            if (item == null) {
//		                setText(null);
//		            } else {
//		                setText(item.loginProperty().getValue() );
//		            }
//		        }
//		    };
//		});		
//
//		// Comportement si modificaiton de la séleciton
//		listView.getSelectionModel().getSelectedItems().addListener( 
//				(ListChangeListener<Participant>) (c) -> {
//					 configurerBoutons();					
//		});
//		configurerBoutons();
//	}
//	
//	public void refresh() {
//		modelCompte.actualiserListe();
//		UtilFX.selectInListView(listView, modelCompte.getCourant() );
//		listView.requestFocus();
//	}
//
//	
//	// Actions
//
//	@FXML
//	private void doAjouter() {
//		modelCompte.preparerAjouter();
//		managerGui.showView( EnumView.CompteForm );
//	}
//
//	@FXML
//	private void doModifier() {
//		modelCompte.preparerModifier( listView.getSelectionModel().getSelectedItem() );
//		managerGui.showView( EnumView.CompteForm );
//	}
//
//	@FXML
//	private void doSupprimer() {
//		if ( managerGui.showDialogConfirm( "Confirmez-vous la suppresion ?" ) ) {
//			modelCompte.supprimer( listView.getSelectionModel().getSelectedItem() );
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
