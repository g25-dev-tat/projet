package projet.view;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import jfox.javafx.view.IManagerGui;
import projet.commun.Roles;
import projet.data.AdminAppli;
import projet.report.EnumReport;
import projet.report.ManagerReport;
import projet.view.systeme.ModelConnexion;


public class MenuBarAppli extends MenuBar {

	
	// Champs
	
	private Menu	menuBenevole;
	private Menu	menuParticipant;
	private Menu	menuEq;
	private Menu	menuCompet;
	private Menu	menuSystem;
	private Menu	menuHelp;
	private Menu	menuUser;
	
	private MenuItem itemDeconnecter;

	private MenuItem itemCategories;
	private MenuItem itemComptes;
	
	@Inject
	private IManagerGui 	managerGui;
	@Inject
	private ManagerReport 	managerReport;
	@Inject
	private ModelConnexion	modelConnexion;	
	
	
	// Initialisation
	
	@PostConstruct
	public void init() {

		
		// Variables de travail
		Menu menu;
		MenuItem item;
		
		
		// Manu Système
		
		menu =  new Menu( "Système" );;
		this.getMenus().add(menu);
		menuSystem = menu;
		
		item = new MenuItem( "Se déconnecter" );
		item.setOnAction(  (e) -> managerGui.showView(EnumView.Connexion)  );
		menu.getItems().add(item);
		itemDeconnecter = item;
		
		item = new MenuItem( "Quitter" );
		item.setOnAction(  (e) -> managerGui.exit()  );
		menu.getItems().add( item );

		
		menu =  new Menu( "Gestion des Utilisateurs" );;
		this.getMenus().add(menu);
		menuUser = menu;
		
		
		// Manu Données
		
		menu =  new Menu( "Benevoles" );;
		this.getMenus().add(menu);
		menuBenevole = menu;
		
		item = new MenuItem( "Attribuer une tache" );
		item.setOnAction(  (e) -> managerGui.showView(EnumView.AffectationTacheForm)  );
		menu.getItems().add( item );
		
		item = new MenuItem( "Supprimer un bénévole" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.BenevoleListe )  );
		menu.getItems().add( item );
		
		item = new MenuItem( "Liste des Benevoles, Taches & Poste (PDF)" );
		item.setOnAction(  (e) ->  
				managerReport.openFilePdf( EnumReport.BenevoleListe, null ) );
		menu.getItems().add( item );
		
		item = new MenuItem( "Annuaire téléphonique" );
		item.setOnAction(  (e) ->  
//				managerReport.print( EnumReport.AnnuaireTelephone, null ) );
				managerReport.showViewer( EnumReport.AnnuaireTelephone, null ) );
		menu.getItems().add( item );
		
		item = new MenuItem( "Modifier une affectation" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.CategorieListe )  );
		menu.getItems().add( item );
		itemCategories = item;
		
		item = new MenuItem( "Supprimer une affectation" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.CompteListe )  );
		menu.getItems().add( item );
		itemComptes = item;

		
		// Manu Etats
		
		menu =  new Menu( "Participants" );;
		this.getMenus().add(menu);
		menuParticipant = menu;
		
		item = new MenuItem( "Liste des participants (PDF)" );
		item.setOnAction(  (e) ->  
				managerReport.openFilePdf( EnumReport.PersonnesListeSimple, null ) );
		menu.getItems().add( item );
		
		item = new MenuItem( "Liste des participants et justificatifs" );
		item.setOnAction(  (e) ->  
				managerReport.showViewer( EnumReport.PersonnesListeSimple, null ) );
		menu.getItems().add( item );
		
		item = new MenuItem( "Annuaire téléphonique" );
		item.setOnAction(  (e) ->  
//				managerReport.print( EnumReport.AnnuaireTelephone, null ) );
				managerReport.showViewer( EnumReport.AnnuaireTelephone, null ) );
		menu.getItems().add( item );
		
		
		
		menu =  new Menu( "Equipes" );;
		this.getMenus().add(menu);
		menuEq = menu;
		
		item = new MenuItem( "Liste des capitaines" );
		item.setOnAction(  (e) ->  
				managerGui.showDialog( EnumView.EtatPersonnesParCateogire1 ) );
		menu.getItems().add( item );
		
		item = new MenuItem( "Liste des equipiers" );
		item.setOnAction(  (e) ->  
				managerGui.showDialog( EnumView.EtatPersonnesParCateogire2 ) );
		menu.getItems().add( item );
		
		item = new MenuItem( "Liste des equipes" );
		item.setOnAction(  (e) ->  
//				managerReport.print( EnumReport.AnnuaireTelephone, null ) );
				managerReport.showViewer( EnumReport.AnnuaireTelephone, null ) );
		menu.getItems().add( item );

		
		// Manu Tests
		
		menu =  new Menu( "Competition" );;
		this.getMenus().add(menu);
		menuCompet= menu;
		
		item = new MenuItem( "Creer une nouvelle competition" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.TestDaoCategorie )  );
		menu.getItems().add( item );
		
		item = new MenuItem( "Voir les compétition precedentes" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.TestDaoMemo )  );
		menu.getItems().add( item );
		
		item = new MenuItem( "Resultats des compétitions precedentes" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.TestDaoService )  );
		menu.getItems().add( item );
		
		menu =  new Menu( "Help" );;
		this.getMenus().add(menu);
		menuHelp = menu;
		
		item = new MenuItem( "Contacter l'administrateur" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.TestDaoService )  );
		menu.getItems().add( item );
		
		item = new MenuItem( "Consulter la FAQ" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.TestDaoService )  );
		menu.getItems().add( item );
		


		// Configuration initiale du menu
		configurerMenu( modelConnexion.getCompteActif() );

		// Le changement du compte connecté modifie automatiquement le menu
		modelConnexion.compteActifProperty().addListener( (obs) -> {
					Platform.runLater( () -> configurerMenu( modelConnexion.getCompteActif() ) );
				}
			); 
		
	}

	
	// Méthodes auxiliaires
	
	private void configurerMenu(AdminAppli compteActif) {

		itemDeconnecter.setDisable(true);
		
		menuBenevole.setVisible(false);
		itemCategories.setVisible(false);
		itemComptes.setVisible(false);
		menuParticipant.setVisible(false);
		menuCompet.setVisible(false);
		menuHelp.setVisible(true);
		menuSystem.setVisible(true);
		menuUser.setVisible(false);
		menuEq.setVisible(false);
		
		if( compteActif != null ) {
			itemDeconnecter.setDisable(false);
			if( compteActif.isInRole( Roles.UTILISATEUR) ) {
				menuSystem.setVisible(true);
				menuParticipant.setVisible(true);
				menuBenevole.setVisible(true);
				menuCompet.setVisible(true);
				menuHelp.setVisible(true);
				menuUser.setVisible(false);
				menuEq.setVisible(true);
			}
			if( compteActif.isInRole( Roles.ADMINISTRATEUR ) ) {
				menuUser.setVisible(true);
				menuSystem.setVisible(true);
				menuBenevole.setVisible(true);
				itemCategories.setVisible(true);
				itemComptes.setVisible(true);
				menuHelp.setVisible(true);
				menuParticipant.setVisible(true);
				menuCompet.setVisible(true);
				menuUser.setVisible(true);
				menuEq.setVisible(true);
			}
		}
	}
	
}
