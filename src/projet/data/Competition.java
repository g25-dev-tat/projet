package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Competition {
	
	
	// Champs
	
	private final Property<Integer>		id			= new SimpleObjectProperty<>();
	private final StringProperty   	 	cricuit       = new SimpleStringProperty();
	private final Property<LocalDate>	echeanceDeb	= new SimpleObjectProperty<>();
	private final Property<LocalDate>	echeanceFin	= new SimpleObjectProperty<>();
	

	
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

	public final Property<LocalDate> echeanceDebProperty() {
		return this.echeanceDeb;
	}

	public final LocalDate getEcheanceDeb() {
		return this.echeanceDebProperty().getValue();
	}

	public final void setEcheanceDeb(final LocalDate echeanceDeb) {
		this.echeanceDebProperty().setValue(echeanceDeb);
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

	public final Property<LocalDate> echeanceFinProperty() {
		return this.echeanceFin;
	}
	

	public final LocalDate getEcheanceFin() {
		return this.echeanceFinProperty().getValue();
	}
	

	public final void setEcheanceFin(final LocalDate echeanceFin) {
		this.echeanceFinProperty().setValue(echeanceFin);
	}
	
	

}
