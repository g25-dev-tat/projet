package projet.data;

import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AdminAppli {


	// Données observables
	
	private final Property<Integer>		id			= new SimpleObjectProperty<>();
	private final StringProperty		nom	 		= new SimpleStringProperty();
	private final StringProperty		prenom		= new SimpleStringProperty();
	private final  Property<Integer>		telephone	= new SimpleObjectProperty<>();
	private final StringProperty		email		= new SimpleStringProperty();
	private final StringProperty		adresse		= new SimpleStringProperty();
	private final StringProperty		login		= new SimpleStringProperty();
	private final StringProperty		pass		= new SimpleStringProperty();
	private final ObservableList<String> roles = FXCollections.observableArrayList();
	
	
	// Constructeurs
	
	public AdminAppli() {
	}
	
	public AdminAppli( int id, String nom, String prenom, int telephone, String email, String adresse, String login, String pass) {
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		setTelephone(telephone);
		setEmail(email);
		setAdresse(adresse);
		setLogin(login);
		setPass(pass);
		
	}
	
	
	// Getters & setters
	
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
	
	public final java.lang.String getNom() {
		return this.nomProperty().getValue();
	}
	
	public final void setNom(final java.lang.String nom) {
		this.nomProperty().setValue(nom);
	}
	
	public final StringProperty prenomProperty() {
		return this.prenom;
	}
	
	public final java.lang.String getPrenom() {
		return this.prenomProperty().getValue();
	}
	
	public final void setPrenom(final java.lang.String prenom) {
		this.prenomProperty().setValue(prenom);
	}


	
	// toString()
	
	@Override
	public String toString() {
		return getNom() + " " + getPrenom();
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
		AdminAppli other = (AdminAppli) obj;
		return Objects.equals(id.getValue(), other.id.getValue() );
	}

	public final Property<Integer> telephoneProperty() {
		return this.telephone;
	}
	

	public final Integer getTelephone() {
		return this.telephoneProperty().getValue();
	}
	

	public final void setTelephone(final Integer telephone) {
		this.telephoneProperty().setValue(telephone);
	}
	

	public final StringProperty emailProperty() {
		return this.email;
	}
	

	public final String getEmail() {
		return this.emailProperty().get();
	}
	

	public final void setEmail(final String email) {
		this.emailProperty().set(email);
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
	
	
}
