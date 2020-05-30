package projet.data;

import java.sql.Time;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Equipe {
	
	
	// Champs
	
	private final Property<Integer>		id				= new SimpleObjectProperty<>();
	private final StringProperty   	 	nomEq     	  	= new SimpleStringProperty();
	private final Property<Boolean>		paye			= new SimpleObjectProperty<>();
	private final Property<Boolean>		valide			= new SimpleObjectProperty<>();
	private final StringProperty   	 	commentaire   	  	= new SimpleStringProperty();
	private final Property<Integer>		nbr_Repas	= new SimpleObjectProperty<>();
	private final Property<Time>		temps_mis		= new SimpleObjectProperty<>();
	
	// Getters & setters

	public final Property<Integer> idProperty() {
		return this.id;
	}
	
	public final Integer getId() {
		return this.idProperty().getValue();
	}
	
	public final void setId(final Integer id) {
		this.idProperty().setValue(id);
	}
	
	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash(id.getValue());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipe other = (Equipe) obj;
		return Objects.equals(id.getValue(), other.id.getValue());
	}

	
	// toString()
	
	@Override
	public String toString() {
		return getNomEq();
	}

	public final StringProperty nomEqProperty() {
		return this.nomEq;
	}
	

	public final String getNomEq() {
		return this.nomEqProperty().get();
	}
	

	public final void setNomEq(final String nomEq) {
		this.nomEqProperty().set(nomEq);
	}
	

	public final Property<Boolean> payeProperty() {
		return this.paye;
	}
	
	public final Boolean isPaye() {
		return this.payeProperty().getValue();
	}
	
	public final Boolean isValide() {
		return this.valideProperty().getValue();
	}

	public final Boolean getPaye() {
		return this.payeProperty().getValue();
	}
	

	public final void setPaye(final Boolean paye) {
		this.payeProperty().setValue(paye);
	}
	

	public final Property<Boolean> valideProperty() {
		return this.valide;
	}
	

	public final Boolean getValide() {
		return this.valideProperty().getValue();
	}
	

	public final void setValide(final Boolean valide) {
		this.valideProperty().setValue(valide);
	}
	

	public final StringProperty commentaireProperty() {
		return this.commentaire;
	}
	

	public final String getCommentaire() {
		return this.commentaireProperty().get();
	}
	

	public final void setCommentaire(final String commentaire) {
		this.commentaireProperty().set(commentaire);
	}
	

	public final Property<Integer> nbr_RepasProperty() {
		return this.nbr_Repas;
	}
	

	public final Integer getNbr_Repas() {
		return this.nbr_RepasProperty().getValue();
	}
	

	public final void setNbr_Repas(final Integer nbr_Repas) {
		this.nbr_RepasProperty().setValue(nbr_Repas);
	}
	

	public final Property<Time> temps_misProperty() {
		return this.temps_mis;
	}
	

	public final Time getTemps_mis() {
		return this.temps_misProperty().getValue();
	}
	

	public final void setTemps_mis(final Time temps_mis) {
		this.temps_misProperty().setValue(temps_mis);
	}
	
	
}
