package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Poste {
	private final Property<Integer>		id	= new SimpleObjectProperty<>();
	private final StringProperty   		poste = new SimpleStringProperty();
	private final Property<LocalDate>		planif	= new SimpleObjectProperty<>();
	
//		private final Property<Integer>		statut		= new SimpleObjectProperty<>(0);	
//		private final Property<Double>		budget		= new SimpleObjectProperty<>();
//		private final Property<Benevole>	categorie	= new SimpleObjectProperty<>();
//		private final ObservableList<AdminAppli> personnes = FXCollections.observableArrayList();
	
	
	public Poste(int id, String poste, LocalDate planif) {
		setId(id);
		setPoste(poste);
		setPlanif(planif);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id.getValue() );
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poste other = (Poste) obj;
		return Objects.equals(id.getValue(), other.id.getValue() );
	}

	public final Property<Integer> idProperty() {
		return this.id;
	}
	

	public final Integer getId() {
		return this.idProperty().getValue();
	}
	

	public final void setId(final Integer id) {
		this.idProperty().setValue(id);
	}
	

	public final StringProperty posteProperty() {
		return this.poste;
	}
	

	public final String getPoste() {
		return this.posteProperty().get();
	}
	

	public final void setPoste(final String poste) {
		this.posteProperty().set(poste);
	}
	

	public final Property<LocalDate> planifProperty() {
		return this.planif;
	}
	

	public final LocalDate getPlanif() {
		return this.planifProperty().getValue();
	}
	

	public final void setPlanif(final LocalDate planif) {
		this.planifProperty().setValue(planif);
	}
	
}
