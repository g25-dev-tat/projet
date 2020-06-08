package labyrinthe;

import java.time.LocalDate;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class competition {
final Property <Integer> id= new SimpleObjectProperty();
final StringProperty   circuit= new SimpleStringProperty();
final Property<LocalDate>  datedebut = new SimpleObjectProperty();
final Property<LocalDate>  datefin = new SimpleObjectProperty();
public final StringProperty circuitProperty() {
	return this.circuit;
}

public final String getCircuit() {
	return this.circuitProperty().get();
}

public final void setCircuit(final String circuit) {
	this.circuitProperty().set(circuit);
}

public final Property<LocalDate> datedebutProperty() {
	return this.datedebut;
}

public final LocalDate getDatedebut() {
	return this.datedebutProperty().getValue();
}

public final void setDatedebut(final LocalDate datedebut) {
	this.datedebutProperty().setValue(datedebut);
}

public final Property<LocalDate> datefinProperty() {
	return this.datefin;
}

public final LocalDate getDatefin() {
	return this.datefinProperty().getValue();
}

public final void setDatefin(final LocalDate datefin) {
	this.datefinProperty().setValue(datefin);
}




}
