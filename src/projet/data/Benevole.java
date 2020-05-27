package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.WritableBooleanValue;


public class Benevole  {
	

	// Données observables
	
	private final Property<Integer>		id			= new SimpleObjectProperty<>();
	private final StringProperty		nom	 		= new SimpleStringProperty();
	private final StringProperty		prenom		= new SimpleStringProperty();
	private final  Property<Integer>		telephone	= new SimpleObjectProperty<>();
	private final StringProperty		email		= new SimpleStringProperty();
	private final StringProperty		adresse		= new SimpleStringProperty();
	private final StringProperty		commentaire		= new SimpleStringProperty();
	private final Property<Boolean>		permisConduire		= new SimpleObjectProperty<>();
	private final Property<LocalDate> dateNaiss		= new SimpleObjectProperty<>();
	
	
	// Constructeurs
	
	public Benevole() {
	}

	public Benevole(int id, String nom, String prenom, int telephone, String email, String adresse, String commentaire, Boolean permisConduire, LocalDate dateNaiss) {
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		setTelephone(telephone);
		setEmail(email);
		setAdresse(adresse);
		setCommentaire(commentaire);
		setPermisConduire(permisConduire);
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

	
	// toString()
	
	@Override
	public String toString() {
		return getNom();
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
		Benevole other = (Benevole) obj;
		return Objects.equals(id.getValue(), other.id.getValue() );
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
	

	public final StringProperty commentaireProperty() {
		return this.commentaire;
	}
	

	public final String getCommentaire() {
		return this.commentaireProperty().get();
	}
	

	public final void setCommentaire(final String commentaire) {
		this.commentaireProperty().set(commentaire);
	}
	

	public final Property<Boolean> permisConduireProperty() {
		return this.permisConduire;
	}
	

	public final Boolean isPermisConduire() {
		return this.permisConduireProperty().getValue();
	}
	

	public final void setPermisConduire(final Boolean permisConduire) {
		this.permisConduireProperty().setValue(permisConduire);
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

	public Property<Boolean> PosteProperty() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

