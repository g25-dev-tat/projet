package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Course {
	

	// Données observables
	
	private final Property<Integer>	id		= new SimpleObjectProperty<>();
	private final Property<LocalDate>	date	= new SimpleObjectProperty<>();
	private final StringProperty	intitule	= new SimpleStringProperty();
	private final StringProperty	depart	= new SimpleStringProperty();
	private final StringProperty	arrivee	= new SimpleStringProperty();
	private final Property<Double>	tarif		= new SimpleObjectProperty<>();
	
	
	// Constructeurs
	
	public Course() {
	}
	
	public Course( int id, LocalDate date, String intitule, String depart, String arrivee, Double tarif) {
		setId(id);
		setDate(date);
		setIntitule(intitule);
		setDepart(depart);
		setArrivee(arrivee);
		setTarif(tarif);
	}
	
	
	// Getters & setters
	
	public final Property<Integer> idProperty() {
		return this.id;
	}

	public final Integer getId() {
		return this.idProperty().getValue();
	}

	public final void setId(final int id) {
		this.idProperty().setValue(id);
	}

	
	// toString()
	
	@Override
	public String toString() {
		return getIntitule();
	}
	
	
	// hashCode() & equals()

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
		Course other = (Course) obj;
		return Objects.equals(id.getValue(), other.id.getValue() );
	}

	public final Property<LocalDate> dateProperty() {
		return this.date;
	}
	

	public final LocalDate getDate() {
		return this.dateProperty().getValue();
	}
	

	public final void setDate(final LocalDate date) {
		this.dateProperty().setValue(date);
	}
	

	public final StringProperty intituleProperty() {
		return this.intitule;
	}
	

	public final String getIntitule() {
		return this.intituleProperty().get();
	}
	

	public final void setIntitule(final String intitule) {
		this.intituleProperty().set(intitule);
	}
	

	public final StringProperty departProperty() {
		return this.depart;
	}
	

	public final String getDepart() {
		return this.departProperty().get();
	}
	

	public final void setDepart(final String depart) {
		this.departProperty().set(depart);
	}
	

	public final StringProperty arriveeProperty() {
		return this.arrivee;
	}
	

	public final String getArrivee() {
		return this.arriveeProperty().get();
	}
	

	public final void setArrivee(final String arrivee) {
		this.arriveeProperty().set(arrivee);
	}
	

	public final Property<Double> tarifProperty() {
		return this.tarif;
	}
	

	public final Double getTarif() {
		return this.tarifProperty().getValue();
	}
	

	public final void setTarif(final Double tarif) {
		this.tarifProperty().setValue(tarif);
	}
	

}
