package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Competition {
	
	
	// Champs
	
	private final Property<Integer>		id			= new SimpleObjectProperty<>();
	private final StringProperty   	 	cricuit       = new SimpleStringProperty();
	private final Property<LocalDate>	echeance	= new SimpleObjectProperty<>();
	

	
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

	public final Property<LocalDate> echeanceProperty() {
		return this.echeance;
	}

	public final LocalDate getEcheance() {
		return this.echeanceProperty().getValue();
	}

	public final void setEcheance(final LocalDate echeance) {
		this.echeanceProperty().setValue(echeance);
	}

	
	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash( id.getValue() );
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competition other = (Competition) obj;
		return Objects.equals( id.getValue(), other.id.getValue() );
	}

	public final StringProperty cricuitProperty() {
		return this.cricuit;
	}
	

	public final String getCricuit() {
		return this.cricuitProperty().get();
	}
	

	public final void setCricuit(final String cricuit) {
		this.cricuitProperty().set(cricuit);
	}
	

}
