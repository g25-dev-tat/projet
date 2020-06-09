//package projet.view.competition;
//
//import javax.inject.Inject;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.ListView;
//import javafx.scene.control.SelectionMode;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.MouseButton;
//import javafx.scene.input.MouseEvent;
//import jfox.javafx.view.IManagerGui;
//import projet.data.AdminAppli;
//
//
//public class ControllerMemoAjoutPersonnes {
//	
//	
//	// Composants de la vue
//
//	@FXML
//	private ListView<AdminAppli>	listView;
//	@FXML
//	private Button				buttonAjouter;
//
//
//	// Autres champs
//	
//	@Inject
//	private IManagerGui			managerGui;
//	@Inject
//	private ModelMemo			modelMemo;
//	
//	
//	// Initialisation du Controller
//
//	@FXML
//	private void initialize() {
//
//		// Data binding
//		listView.setItems( modelMemo.getPersonnesPourDialogAjout() );
//		
//		// Configuraiton des boutons
//		listView.getSelectionModel().selectedItemProperty().addListener(
//				(obs, oldVal, newVal) -> {
//					configurerBoutons();
//		});
//		configurerBoutons();
//
//		listView.getSelectionModel().setSelectionMode( SelectionMode.MULTIPLE );
//	}
//	
//	public void refresh() {
//		modelMemo.actualiserListePersonnesPourDialogAjout();;
//		listView.requestFocus();
//	}
//
//	
//	// Actions
//	
//	@FXML
//	private void doFermer() {
//		managerGui.closeStage();
//	}
//	
//	@FXML
//	private void doAjouter() {
////	    Personne itemChoisi = listView.getSelectionModel().getSelectedItem();
////	    if ( itemChoisi != null  ) {
////	        modelMemo.ajouterPersonne( itemChoisi );
////	        managerGui.closeStage();
////	    }
//		for ( AdminAppli item : listView.getSelectionModel().getSelectedItems() ) {
//			modelMemo.ajouterPersonne( item );
//		}
//		managerGui.closeStage();	
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
//					doAjouter();
//				}
//			}
//		}
//	}
//	
//	// Appui d'une touche sur la liste
//	@FXML
//	private void gererToucheSurListe( KeyEvent event ) {
//		// Si échap ferme la boîte de dialogue 
//		if ( event.getCharacter().charAt(0) == 27 )  {
//			doFermer();;
//		}
//	}
//
//	
//	// Méthodes auxiliaires
//	
//	private void configurerBoutons() {
//		
//    	if( listView.getSelectionModel().getSelectedItems().isEmpty() ) {
//			buttonAjouter.setDisable(true);
//		} else {
//			buttonAjouter.setDisable(false);
//		}
//	}
//
//}
