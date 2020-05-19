package projet.data;

import java.util.Objects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Participant  {

	
	// Données observables
	
	private final Property<Integer>	id			= new SimpleObjectProperty<>();
	private final StringProperty	nom		= new SimpleStringProperty();
	private final StringProperty	prenom	= new SimpleStringProperty();
	private final Property<Integer>	telephone	= new SimpleObjectProperty<>();
	private final StringProperty	adresse	= new SimpleStringProperty();
	private final StringProperty	email 		= new SimpleStringProperty();
	private final StringProperty	login 		= new SimpleStringProperty();
	private final StringProperty	pass 		= new SimpleStringProperty();
	private final ObservableList<String> roles = FXCollections.observableArrayList();
	
	
	// Constructeurs
	
	public Participant() {
	}

	public Participant(int id, String nom, String prenom, int telephone, String adresse, String email, String login, String pass) {
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		setTelephone(telephone);
		setAdresse(adresse);
		setEmail(email);
		setLogin(login);
		setPass(pass);
	}
	
	
	// Getters et Setters

	public final Property<Integer> idProperty() {
		return this.id;
	}

	public final Integer getId() {
		return this.idProperty().getValue();
	}

	public final void setId(final Integer id) {
		this.idProperty().setValue(id);
	}
	
	public final Property<Integer> telephoneProperty() {
		return this.telephone;
	}

	public final Integer getTelephone() {
		return this.idProperty().getValue();
	}

	public final void setTelephone(final Integer telephone) {
		this.telephoneProperty().setValue(telephone);
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
	

	public final StringProperty prenomProperty() {
		return this.prenom;
	}
	

	public final String getPrenom() {
		return this.prenomProperty().get();
	}
	

	public final void setPrenom(final String prenom) {
		this.prenomProperty().set(prenom);
	}
	

	public final StringProperty adresseProperty() {
		return this.adresse;
	}
	

	public final String getAdresse() {
		return this.adresseProperty().get();
	}
	

	public final void setAdresse(final String adresse) {
		this.adresseProperty().set(adresse);
	}
	

	public final StringProperty loginProperty() {
		return this.login;
	}
	

	public final String getLogin() {
		return this.loginProperty().get();
	}
	

	public final void setLogin(final String login) {
		this.loginProperty().set(login);
	}
	

	public final StringProperty passProperty() {
		return this.pass;
	}
	

	public final String getPass() {
		return this.passProperty().get();
	}
	

	public final void setPass(final String pass) {
		this.passProperty().set(pass);
	}


	public final StringProperty emailProperty() {
		return this.email;
	}

	public final String getEmail() {
		return this.emailProperty().getValue();
	}

	public final void setEmail(final String email) {
		this.emailProperty().setValue(email);
	}

	public final ObservableList<String> getRoles() {
		return this.roles;
	}

	
	public boolean isInRole( String role ) {
		
		if ( role != null ) {
			for ( String r : roles ) {
				if ( role.equals( r ) ) {
					return true;
				}
			}
		}
		return false;
	}

	
	// toString()
	
	@Override
	public String toString() {
		return getPrenom()+" "+getNom();
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
		Participant other = (Participant) obj;
		return Objects.equals(id.getValue(), other.id.getValue() );
	}
	
	
}
