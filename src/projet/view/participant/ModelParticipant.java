package projet.view.participant;

import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoEquipe;
import projet.dao.DaoParticipant;
import projet.data.Equipe;
import projet.data.Participant;


public class ModelParticipant {
	
	
	// Données observables 
	
	private final ObservableList<Participant> liste = FXCollections.observableArrayList();
	
	private final Participant	courant = new Participant();
	
	
	// Autres champs
	
    @Inject
	private IMapper		        mapper;
    @Inject
	private DaoEquipe			daoEquipe;
	@Inject
    private ModelEquipe 		modelEquipe;
	
	
	// Getters 
	
	public ObservableList<Participant> getListe() {
		return liste;
	}
	
	public Participant getCourant() {
		return courant;
	}
	
	public ObservableList<Equipe> getEquipe() {
		return modelEquipe.getListe();
	}

	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( DaoParticipant.listerTout() );
	}

	
	// Actions
	

	public void supprimer( Participant item ) {
		DaoParticipant.supprimer( item.getId() );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
	}
	
	public Participant afficher(Participant item) {
		Participant p;
		p=DaoParticipant.affich(item);
		System.out.println(item);
		mapper.update( courant, item );
		return p;
		
	}
	
}
