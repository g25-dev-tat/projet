package projet.report;


public enum EnumReport implements IEnumReport {

	
	// Valeurs
	
	PersonnesParCategorie1	( "personne/ListeParCategorie1.jrxml" ),
	PersonnesParCategorie2	( "personne/ListeParCategorie2.jrxml" ),
	PersonnesListeSimple	( "personne/ListeSimple.jrxml" ),
	AnnuaireTelephone		( "personne/Annuaire.jrxml" ), 
	BenevoleListe("benevole/ViewBenevoleListe.jrxml"),
	;

	
	// Champs
	
	private String		path;

	
	// Constructeur 
	
	EnumReport( String path ) {
		this.path = path;
	}

	
	// Getters & setters

	@Override
	public String getPath() {
		return path;
	}

}
