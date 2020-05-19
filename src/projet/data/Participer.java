package projet.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Participer {
	
	private final StringProperty   		raid = new SimpleStringProperty();
	private final StringProperty   		typeCompet = new SimpleStringProperty();
	private final StringProperty   		categ = new SimpleStringProperty();
	
	public Participer(String raid, String typeCompet, String categ) {
		setRaid(raid);
		setTypeCompet(typeCompet);
		setCateg(categ);
	}
	public final StringProperty raidProperty() {
		return this.raid;
	}
	
	public final String getRaid() {
		return this.raidProperty().get();
	}
	
	public final void setRaid(final String raid) {
		this.raidProperty().set(raid);
	}
	
	public final StringProperty typeCompetProperty() {
		return this.typeCompet;
	}
	
	public final String getTypeCompet() {
		return this.typeCompetProperty().get();
	}
	
	public final void setTypeCompet(final String typeCompet) {
		this.typeCompetProperty().set(typeCompet);
	}
	
	public final StringProperty categProperty() {
		return this.categ;
	}
	
	public final String getCateg() {
		return this.categProperty().get();
	}
	
	public final void setCateg(final String categ) {
		this.categProperty().set(categ);
	}
	

}
