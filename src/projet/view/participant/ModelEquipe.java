package projet.view.participant;

import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoCompetition;
import projet.dao.DaoEquipe;
import projet.dao.DaoParticipant;
import projet.data.Equipe;
import projet.data.Participant;


public class ModelEquipe  {
	
	
	// Données observables 
	
	private final ObservableList<Equipe> liste = FXCollections.observableArrayList(); 
	
	private final Equipe	courant = new Equipe();

	
	// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoParticipant	daoParticipant;
    @Inject
    private DaoCompetition			daoCompet;
	
	
	// Getters 
	
	public ObservableList<Equipe> getListe() {
		return liste;
	}
	
	public Equipe getCourant() {
		return courant;
	}
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( DaoEquipe.listerTout() );
 	}


	// Actions
	
	
	public void supprimer( Equipe item ) {
		
//		 Vérifie l'abence de participants rattachés à l'equipe
//		if ( daoParticipant.compterPourParticipant( item.getId() ) != 0 ) {
//			throw new ExceptionValidation( "Des participants sont rattachés à cette équipe..." ) ;
//		}
//		
//		 Vérifie l'abence de mémos rattaches à la catégorie
//		if ( daoCompet.compterPourCompet( item.getId() ) != 0 ) {
//			throw new ExceptionValidation( "Cette equipe est rattachée à une ou plusieurs compétitions..." ) ;
//		}
		
		DaoEquipe.supprimer( item.getId() );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
	}
	
	
	public Equipe afficher(Participant item) {
		Equipe eq = null;
		eq=DaoEquipe.affich(item,eq);
		System.out.println(item);
		//mapper.update( courant, item );
		return eq;
		
	}
	
}
