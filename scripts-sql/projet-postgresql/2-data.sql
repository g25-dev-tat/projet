SET search_path TO projet;


-- Supprimer toutes les données

DELETE FROM Organiser;
DELETE FROM Participer;
DELETE FROM Contenir;
DELETE FROM Se_proposer;
DELETE FROM Effectuer;
DELETE FROM Etre_affecter;
DELETE FROM Competition;
DELETE FROM Participant;
DELETE FROM Equipe;
DELETE FROM Course;
DELETE FROM Tache;
DELETE FROM Poste;
DELETE FROM Benevole;
DELETE FROM Role;
DELETE FROM AdminAppli;

-- AdminAppli

INSERT INTO "adminappli" (Id, Nom, Prenom, Telephone, email, adresse, login, pass) 
VALUES (1,'Omar','Harper Mason',0643053491,'Duis.ac.arcu@tempordiamdictum.com','Ap #276-9815 Felis Avenue','Whitley','Rogan54321'),
(2,'Timon','Erich Stevenson',0733962250,'sed@enim.ca','P.O. Box 574, 4978 Odio Av.','Rivers','Reed654321'),
(3,'Zahir','Yolanda Charles',0619396697,'nunc@volutpat.co.uk','Ap #275-9232 A, Avenue','Herman','Yen7654321'),
(4,'Mason','Abel Joyner',0921174350,'vitae@natoquepenatibuset.co.uk','6707 Sem, Av.','Bartlett','Serina4321'),
(5,'Clark','Bruce Kim',0589019366,'fermentum@ametfaucibusut.net','Ap #536-354 Adipiscing Rd.','Nash','Teagan4321');
--ALTER TABLE "adminappli" ALTER COLUMN id RESTART WITH 6;



-- Role

INSERT INTO role (idadmin, role) VALUES 
  ( 1, 'ADMINISTRATEUR' ),
  ( 1, 'UTILISATEUR' ),
  ( 2, 'UTILISATEUR' ),
  ( 3, 'UTILISATEUR' ),
  ( 4, 'UTILISATEUR' ),
  ( 5, 'UTILISATEUR' );
  
  
 --Benevole
  INSERT INTO "benevole" (Id, Nom, Prenom, Telephone, email, adresse, commentaire, datenaiss, permisconduire) 
VALUES (1,'Samson','NZUMGUENG',0642279765,'nzumgues@3il.fr','9 rue deverrine, 87000, limoges','souhait poste : signaleur, photographe, ravi eau','12-12-2020',false),
(2,'Daniel','NZUMGUENG',0642279765,'nzumgued@3il.fr','9 rue deverrine, 87000, limoges','parking velo, parking voiture, ravitaillement, chrono','12-12-2020',true),
(3,'Fabrice','NZUMGUENG',0642279765,'nzumguef@3il.fr','9 rue deverrine, 87000, limoges','recuperer dossards/puces, moto (ouverture, fermeture), photographe','12-12-2020',true),
(4,'Frances','NZUMGUENG',0642279765,'nzumguefr@3il.fr','9 rue deverrine, 87000, limoges','buvette, repas, photographe','12-12-2020',true),
(5,'Joel','NZUMGUENG',0642279765,'nzumguej@3il.fr','9 rue deverrine, 87000, limoges','ravitaillement, secu eau, remise dossards','12-12-2020',true),
(6,'Danielle','NZUMGUENG',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true);


