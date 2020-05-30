package projet.view.participant;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.dao.DaoEquipe;
import projet.dao.DaoParticipant;
import projet.data.Equipe;
import projet.data.Participant;


public class ControllerParticipantListe {
	
	
	// Composants de la vue

	@FXML
	private ListView<Participant>	listView;
	@FXML
	private Button	buttonjustif;
	@FXML
	private Button	buttonSupprimer;
	@FXML
	private Button	buttonImprimer;
	@FXML
	private Button	buttonVoirParticipant;
	@FXML
	private TextArea affichInfo;
	@FXML
	private TextArea affichEq;


	// Autres champs
	
	@Inject
	private IManagerGui			managerGui;
	@Inject
	private ModelParticipant		modelParticipant;
	
	
	// Initialisation du Controller

	@FXML
	private void initialize() {

		// Data binding
		listView.setItems( modelParticipant.getListe() );
		
		listView.setCellFactory(  UtilFX.cellFactory( item -> item.getNom() ));
		
		// Configuraiton des boutons
		listView.getSelectionModel().selectedItemProperty().addListener(
				(obs, oldVal, newVal) -> {
					configurerBoutons();
		});
		configurerBoutons();

	}
	
	public void refresh() {
		modelParticipant.actualiserListe();
		UtilFX.selectInListView( listView, modelParticipant.getCourant() );
		listView.requestFocus();
	}

	
	// Actions
	
	@FXML
	private void doJustif() {
		//modelParticipant.preparerAttribution();;
		//managerGui.showView( EnumView.AffectationTacheForm );
	}

	@FXML
	private void doImprimer() {
		System.out.println("ici impression de la liste des participants");
		//List<Participant> item = listView.getSelectionModel().getSelectedItem();
//		if ( item == null ) {
//			managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
//		} else {
//			modelParticipant.preparerImpression(item);
//			managerGui.showView( EnumView.AffectationTacheForm );
//		}
	}

	@FXML
	private void doSupprimer() {
		Participant item = listView.getSelectionModel().getSelectedItem();
		if ( item == null ) {
			managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
		} else {
			boolean reponse = managerGui.showDialogConfirm( "Confirmez-vous la suppresion ?" );
			if ( reponse ) {
				modelParticipant.supprimer( item );
				refresh();
			}
		}
	}
	
	@FXML
	private void doVoirParticipant() {
		Participant item = listView.getSelectionModel().getSelectedItem();
		Equipe eq=new Equipe();
		Equipe eq1=new Equipe();
		//boolean p=true;
		eq=DaoEquipe.affich(item, eq1);
		
		String paye="oui";
		if(eq.isPaye())
			paye="Oui";
		else
			paye="Non";
		
		//boolean v=DaoEquipe.affich(item,eq).equals(eq.getValide());
		String valide="oui";
		if(eq.getValide())
			valide="Oui";
		else
			valide="Non";
		
		if ( item == null ) {
			managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
		} else {
				modelParticipant.afficher( item );
				affichInfo.setText("\t\tInformations personnelles\n\nNom :\t "+DaoParticipant.affich(item).getNom()+"\nPrenom :\t "+DaoParticipant.affich(item).getPrenom()+"\nDate de naissance :  "+DaoParticipant.affich(item).getDateNaiss()+"\nAdresse : "+DaoParticipant.affich(item).getAdresse()+"\nTel : "+DaoParticipant.affich(item).getTelephone()+"\nEmail :  "+DaoParticipant.affich(item).getEmail()+"\nClub :  "+DaoParticipant.affich(item).getClub()+"\nJustificatifs : "+DaoParticipant.affich(item).getJustificatifs()+"\nCommentaires : \n\t\t"+DaoParticipant.affich(item).getCommentaire());
				affichEq.setText("Nom Equipe :\t"+DaoEquipe.affich(item,eq).getNomEq()+"\nEtat : \n\tPayé : "+paye+"\n\tValide : "+valide+"\n\tNombre repas : "+DaoEquipe.affich(item,eq).getNbr_Repas());
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
					if(event.getButton().equals(buttonjustif))
						doJustif();
					if(event.getButton().equals(buttonSupprimer))
						doSupprimer();
				}
			}
		}
	}

	
	// Méthodes auxiliaires
	
	private void configurerBoutons() {
		
    	if( listView.getSelectionModel().getSelectedItems().isEmpty() ) {
			buttonjustif.setDisable(true);
			buttonSupprimer.setDisable(true);
			buttonVoirParticipant.setDisable(true);
		} else {
			buttonjustif.setDisable(false);
			buttonSupprimer.setDisable(false);
			buttonVoirParticipant.setDisable(false);
		}
	}

}
