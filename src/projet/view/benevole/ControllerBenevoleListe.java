package projet.view.benevole;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.dao.DaoBenevole;
import projet.data.Benevole;
import projet.view.EnumView;


public class ControllerBenevoleListe {
	
	
	// Composants de la vue

	@FXML
	private ListView<Benevole>	listView;
	@FXML
	private Button	buttonAttribuerUneTache;
	@FXML
	private Button	buttonSupprimer;
	@FXML
	private Button	buttonImprimer;
	@FXML
	private Button	buttonVoirBenevole;
	@FXML
	private TextArea affichInfo;
	@FXML
	private TextArea affichTache;


	// Autres champs
	
	@Inject
	private IManagerGui			managerGui;
	@Inject
	private ModelBenevole		modelBenevole;
	
	
	// Initialisation du Controller

	@FXML
	private void initialize() {

		// Data binding
		listView.setItems( modelBenevole.getListe() );
		
		listView.setCellFactory(  UtilFX.cellFactory( item -> item.getNom() ));
		
		// Configuraiton des boutons
		listView.getSelectionModel().selectedItemProperty().addListener(
				(obs, oldVal, newVal) -> {
					configurerBoutons();
		});
		configurerBoutons();

	}
	
	public void refresh() {
		modelBenevole.actualiserListe();
		UtilFX.selectInListView( listView, modelBenevole.getCourant() );
		listView.requestFocus();
	}

	
	// Actions
	
	@FXML
	private void doAttribuerUneTache() {
		modelBenevole.preparerAttribution();;
		managerGui.showView( EnumView.AffectationTacheForm );
	}

	@FXML
	private void doImprimer() {
		System.out.println("ici impression de la liste des bénévoles");
		//List<Benevole> item = listView.getSelectionModel().getSelectedItem();
//		if ( item == null ) {
//			managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
//		} else {
//			modelBenevole.preparerImpression(item);
//			managerGui.showView( EnumView.AffectationTacheForm );
//		}
	}

	@FXML
	private void doSupprimer() {
		Benevole item = listView.getSelectionModel().getSelectedItem();
		if ( item == null ) {
			managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
		} else {
			boolean reponse = managerGui.showDialogConfirm( "Confirmez-vous la suppresion ?" );
			if ( reponse ) {
				modelBenevole.supprimer( item );
				refresh();
			}
		}
	}
	
	@FXML
	private void doVoirBenevole() {
		Benevole item = listView.getSelectionModel().getSelectedItem();
		Boolean permis=DaoBenevole.affich(item).isPermisConduire();
		String p="oui";
		if(permis==true)
			p="oui";
		else
			p="non";
		
		if ( item == null ) {
			managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
		} else {
				modelBenevole.afficher( item );
				affichInfo.setText("\t\tInformations personnelles\n\nNom :\t "+DaoBenevole.affich(item).getPrenom()+"\nPrenom :\t "+DaoBenevole.affich(item).getNom()+"\nDate de naissance :  "+DaoBenevole.affich(item).getDateNaiss()+"\nAdresse : "+DaoBenevole.affich(item).getAdresse()+"\nTel : "+DaoBenevole.affich(item).getTelephone()+"\nEmail :  "+DaoBenevole.affich(item).getEmail()+"\nPermis de conduire :  "+p+"\nCommentaires & souhaits du benevole : \n\t\t"+DaoBenevole.affich(item).getCommentaire());
				affichTache.setText("Poste :\t"+"\nTaches : \t");
				refresh();
		}
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
					if(event.getButton().equals(buttonAttribuerUneTache))
						doAttribuerUneTache();
					if(event.getButton().equals(buttonSupprimer))
						doSupprimer();
				}
			}
		}
	}

	
	// Méthodes auxiliaires
	
	private void configurerBoutons() {
		
    	if( listView.getSelectionModel().getSelectedItems().isEmpty() ) {
			buttonAttribuerUneTache.setDisable(true);
			buttonSupprimer.setDisable(true);
			buttonVoirBenevole.setDisable(true);
		} else {
			buttonAttribuerUneTache.setDisable(false);
			buttonSupprimer.setDisable(false);
			buttonVoirBenevole.setDisable(false);
		}
	}

}
