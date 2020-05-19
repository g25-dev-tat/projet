package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tache {
	
	private final Property<Integer>   		id = new SimpleObjectProperty<>();
	private final StringProperty   		nom = new SimpleStringProperty();
	private final Property<LocalDate>   		date = new SimpleObjectProperty<>();
	
	public Tache(int id, String nom, LocalDate date) {
		setId(id);
		setNom(nom);
		setDate(date);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tache other = (Tache) obj;
		return Objects.equals(id, other.id);
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
	
	public final StringProperty nomProperty() {
		return this.nom;
	}
	
	public final String getNom() {
		return this.nomProperty().get();
	}
	
	public final void setNom(final String nom) {
		this.nomProperty().set(nom);
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
	

}
