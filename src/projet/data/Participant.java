package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Participant  {

	
	// Données observables
	
	private final Property<Integer>	id			= new SimpleObjectProperty<>();
	private final StringProperty	nom		= new SimpleStringProperty();
	private final StringProperty	prenom	= new SimpleStringProperty();
	private final Property<Integer>	telephone	= new SimpleObjectProperty<>();
	private final StringProperty	adresse	= new SimpleStringProperty();
	private final StringProperty	email 		= new SimpleStringProperty();
	private final StringProperty	justificatifs		= new SimpleStringProperty();
	private final StringProperty	commentaire 		= new SimpleStringProperty();
	private final StringProperty	club				= new SimpleStringProperty();
	private final Property<LocalDate>	dateNaiss		= new SimpleObjectProperty<>();
	
	
	// Constructeurs
	
	public Participant() {
	}

	public Participant(int id, String nom, String prenom, int telephone, String adresse, String email, String club, String justificatifs, String commentaire, LocalDate dateNaiss) {
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		setTelephone(telephone);
		setAdresse(adresse);
		setEmail(email);
		setClub(club);
		setJustificatifs(justificatifs);
		setCommentaire(commentaire);
		setDateNaiss(dateNaiss);
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
	

	public final StringProperty clubProperty() {
		return this.club;
	}
	

	public final String getClub() {
		return this.clubProperty().get();
	}
	

	public final void setClub(final String login) {
		this.clubProperty().set(login);
	}
	

	public final StringProperty justificatifsProperty() {
		return this.justificatifs;
	}
	

	public final String getJustificatifs() {
		return this.justificatifsProperty().get();
	}
	

	public final void setJustificatifs(final String pass) {
		this.justificatifsProperty().set(pass);
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

	public final StringProperty commentaireProperty() {
		return this.commentaire;
	}
	

	public final String getCommentaire() {
		return this.commentaireProperty().get();
	}
	

	public final void setCommentaire(final String commentaire) {
		this.commentaireProperty().set(commentaire);
	}
	

	public final Property<LocalDate> dateNaissProperty() {
		return this.dateNaiss;
	}
	

	public final LocalDate getDateNaiss() {
		return this.dateNaissProperty().getValue();
	}
	

	public final void setDateNaiss(final LocalDate dateNaiss) {
		this.dateNaissProperty().setValue(dateNaiss);
	}
	
	
	
}
