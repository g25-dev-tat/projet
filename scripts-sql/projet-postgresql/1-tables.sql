SET search_path TO projet;


-- Schéma

DROP SCHEMA IF EXISTS projet CASCADE;
CREATE SCHEMA projet AUTHORIZATION projet;
GRANT ALL PRIVILEGES ON SCHEMA projet TO projet;


------------------------------------------------------------
--  Création des Tables : Script Postgre 
------------------------------------------------------------


------------------------------------------------------------
-- Table: AdminAppli
------------------------------------------------------------
CREATE TABLE AdminAppli(
	Id          SERIAL NOT NULL ,
	Nom         VARCHAR (30) NOT NULL ,
	Prenom      VARCHAR (30) NOT NULL ,
	Telephone   INT  NOT NULL ,
	email       VARCHAR (50) NOT NULL ,
	adresse     VARCHAR (100) NOT NULL ,
	login       VARCHAR (20) NOT NULL ,
	pass        CHAR (10)  NOT NULL  ,
	CONSTRAINT AdminAppli_PK PRIMARY KEY (Id)
);

------------------------------------------------------------
-- Table: Role
------------------------------------------------------------

CREATE TABLE role (
	idadmin				INT				NOT NULL,
	role			VARCHAR(20)		NOT NULL,
	CHECK(Role IN ('ADMINISTRATEUR','UTILISATEUR')),	
	CONSTRAINT Role_PK PRIMARY KEY (idadmin, role),
	CONSTRAINT Role_AdminAppli_FK FOREIGN KEY (idadmin) REFERENCES AdminAppli (id)
);

------------------------------------------------------------
-- Table: Benevole
------------------------------------------------------------
CREATE TABLE Benevole(
	Id              SERIAL NOT NULL ,
	Nom             VARCHAR (20) NOT NULL ,
	Prenom          VARCHAR (20) NOT NULL ,
	Telephone       INT  NOT NULL ,
	email           VARCHAR (20) NOT NULL ,
	adresse         VARCHAR (100) NOT NULL ,
	Commentaire     VARCHAR (255) NOT NULL ,
	dateNaiss       DATE  NOT NULL ,
	PermisConduire 	BOOLEAN NOT NULL,
	Id_AdminAppli   INT    ,
	CONSTRAINT Benevole_PK PRIMARY KEY (Id)

	,CONSTRAINT Benevole_AdminAppli_FK FOREIGN KEY (Id_AdminAppli) REFERENCES AdminAppli(Id)
);


------------------------------------------------------------
-- Table: AdminSysteme
------------------------------------------------------------
--CREATE TABLE AdminSysteme(
--	Id          INT  NOT NULL ,
--	droits      VARCHAR (25) NOT NULL ,
--	Nom         VARCHAR (20) NOT NULL ,
--	Prenom      VARCHAR (20) NOT NULL ,
--	Telephone   INT  NOT NULL ,
--	email       VARCHAR (20) NOT NULL ,
--	adresse     VARCHAR (30) NOT NULL ,
--	login       VARCHAR (20) NOT NULL ,
--	pass        CHAR (255)  NOT NULL  ,
--	CONSTRAINT AdminSysteme_PK PRIMARY KEY (Id)

--	,CONSTRAINT AdminSysteme_AdminAppli_FK FOREIGN KEY (Id) REFERENCES AdminAppli(Id)
--);


------------------------------------------------------------
-- Table: Poste
------------------------------------------------------------
CREATE TABLE Poste(
	Id        SERIAL NOT NULL ,
	poste     VARCHAR (20) NOT NULL ,
	Plannif   DATE  NOT NULL  ,
	CONSTRAINT Poste_PK PRIMARY KEY (Id)
);


------------------------------------------------------------
-- Table: Tache
------------------------------------------------------------
CREATE TABLE Tache(
	Id         SERIAL NOT NULL ,
	nomTache   VARCHAR (20) NOT NULL ,
	date       DATE  NOT NULL ,
	Id_Poste   INT  NOT NULL  ,
	CONSTRAINT Tache_PK PRIMARY KEY (Id)

	,CONSTRAINT Tache_Poste_FK FOREIGN KEY (Id_Poste) REFERENCES Poste(Id)
);


------------------------------------------------------------
-- Table: Course
------------------------------------------------------------
CREATE TABLE Course(
	Id         SERIAL NOT NULL ,
	date       DATE  NOT NULL ,
	intitule   VARCHAR (20) NOT NULL ,
	depart     VARCHAR (20) NOT NULL ,
	arrivee    VARCHAR (20) NOT NULL ,
	tarif      DECIMAL (15,3) NOT NULL  ,
	CONSTRAINT Course_PK PRIMARY KEY (Id)
);


------------------------------------------------------------
-- Table: Equipe
------------------------------------------------------------
CREATE TABLE Equipe(
	Id              SERIAL NOT NULL ,
	NomEq           VARCHAR (50) NOT NULL ,
	Paye            BOOL  NOT NULL ,
	Valide          BOOL  NOT NULL ,
	Commentaire     VARCHAR (255) NOT NULL ,
	NbreRepas       INT  NOT NULL ,
	temps_mis       TIMETZ,
	Id_Course       INT,
	CONSTRAINT Equipe_PK PRIMARY KEY (Id)

	,CONSTRAINT Equipe_Course_FK FOREIGN KEY (Id_Course) REFERENCES Course(Id)
);


------------------------------------------------------------
-- Table: Participant
------------------------------------------------------------
CREATE TABLE Participant(
	Id              SERIAL NOT NULL ,
	Nom             VARCHAR (20) NOT NULL ,
	Prenom          VARCHAR (20) NOT NULL ,
	Telephone       INT  NOT NULL ,
	email           VARCHAR (20) NOT NULL ,
	adresse         VARCHAR (100) NOT NULL ,
	justificatifs   VARCHAR (255) NOT NULL ,
	Commentaire     VARCHAR (255) NOT NULL ,
	dateNaiss       DATE  NOT NULL ,
	club 			VARCHAR (50) NOT NULL,
	Id_Equipe       INT  NOT NULL  ,
	CONSTRAINT Participant_PK PRIMARY KEY (Id)

	,CONSTRAINT Participant_Equipe_FK FOREIGN KEY (Id_Equipe) REFERENCES Equipe(Id)
);


------------------------------------------------------------
-- Table: Competition
------------------------------------------------------------
CREATE TABLE Competition(
	Id         SERIAL NOT NULL ,
	echeanceDeb   DATE  NOT NULL ,
	echeanceFin   DATE  NOT NULL ,
	circuit    VARCHAR (255) NOT NULL  ,
	CONSTRAINT Competition_PK PRIMARY KEY (Id)
);


------------------------------------------------------------
-- Table: Effectuer
------------------------------------------------------------
CREATE TABLE Effectuer(
	Id            INT  NOT NULL ,
	Id_Benevole   INT  NOT NULL  ,
	CONSTRAINT Effectuer_PK PRIMARY KEY (Id,Id_Benevole)

	,CONSTRAINT Effectuer_Tache_FK FOREIGN KEY (Id) REFERENCES Tache(Id)
	,CONSTRAINT Effectuer_Benevole0_FK FOREIGN KEY (Id_Benevole) REFERENCES Benevole(Id)
);


------------------------------------------------------------
-- Table: Etre affecter
------------------------------------------------------------
CREATE TABLE Etre_affecter(
	Id            INT  NOT NULL ,
	Id_Benevole   INT  NOT NULL  ,
	CONSTRAINT Etre_affecter_PK PRIMARY KEY (Id,Id_Benevole)

	,CONSTRAINT Etre_affecter_Poste_FK FOREIGN KEY (Id) REFERENCES Poste(Id)
	,CONSTRAINT Etre_affecter_Benevole0_FK FOREIGN KEY (Id_Benevole) REFERENCES Benevole(Id)
);


------------------------------------------------------------
-- Table: Contenir
------------------------------------------------------------
CREATE TABLE Contenir(
	Id          INT  NOT NULL ,
	Id_Course   INT  NOT NULL  ,
	CONSTRAINT Contenir_PK PRIMARY KEY (Id,Id_Course)

	,CONSTRAINT Contenir_Competition_FK FOREIGN KEY (Id) REFERENCES Competition(Id)
	,CONSTRAINT Contenir_Course0_FK FOREIGN KEY (Id_Course) REFERENCES Course(Id)
);


------------------------------------------------------------
-- Table: Organiser
------------------------------------------------------------
CREATE TABLE Organiser(
	Id          INT  NOT NULL ,
	Id_Competition   INT  NOT NULL  ,
	CONSTRAINT Organiser_PK PRIMARY KEY (Id,Id_Competition)

	,CONSTRAINT Organiser_Competition_FK FOREIGN KEY (Id_Competition) REFERENCES Competition(Id)
	,CONSTRAINT Organiser_AdminAppli0_FK FOREIGN KEY (Id) REFERENCES AdminAppli(Id)
);


------------------------------------------------------------
-- Table:  Se proposer
------------------------------------------------------------
CREATE TABLE Se_proposer(
	Id          INT  NOT NULL ,
	Id_Competition   INT  NOT NULL  ,
	CONSTRAINT Se_proposer_PK PRIMARY KEY (Id,Id_Competition)

	,CONSTRAINT Se_proposer_Competition_FK FOREIGN KEY (Id_Competition) REFERENCES Competition(Id)
	,CONSTRAINT Se_proposer_Benevole0_FK FOREIGN KEY (Id) REFERENCES Benevole(Id)
);

------------------------------------------------------------
-- Table: Participer
------------------------------------------------------------
CREATE TABLE Participer(
	Id          INT  NOT NULL ,
	Id_Competition   INT  NOT NULL  ,
	raid VARCHAR (50) NOT NULL,
	typeCompet VARCHAR (50) NOT NULL,
	categ VARCHAR (50) NOT NULL,
	CHECK(raid IN ('Bol Air','Bol Eau')),	
	CHECK(typeCompet IN ('mini','grand')),	
	CHECK(categ IN ('Hommes','Femmes','Mixte','VAE')),	
	CONSTRAINT Participer_PK PRIMARY KEY (Id,Id_Competition)

	,CONSTRAINT Participer_Competition_FK FOREIGN KEY (Id_Competition) REFERENCES Competition(Id)
	,CONSTRAINT Participer_Equipe0_FK FOREIGN KEY (Id) REFERENCES Equipe(Id)
);
