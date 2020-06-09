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


--Equipe
INSERT INTO "equipe"(Id, nomeq, paye, valide, commentaire, nbrerepas)
VALUES (1, 'NZUMGUENG.TCHEA',true,true,'Ok',2),(2, 'TOCHE.KOWA',true,true,'Ok',4),(3, 'THIBAUT.KUATE',false,true,'Ok',5);


--Participant
  INSERT INTO "participant" (Id, Nom, Prenom, telephone, email, adresse, justificatifs, commentaire, datenaiss, club, id_equipe) 
VALUES (1, 'NZUMGUENG', 'Samson', 0642279765, 'nzumges@3il.fr', 'rue deverrine, 87000, limoges', 'justificatif-capitaine.pdf', 'Capitaine', '12-12-2020','3iL',1),
(2, 'TCHEA', 'Jordan', 0642279765, 'tcheaj@3il.fr', 'avenue albert thomas, 87000, limoges', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',1),
(3, 'TOCHE', 'Harry', 0642279765, 'harry@3il.fr', '01 rue gustave nadaud, 87000, limoges', 'justificatif-capitaine.pdf', 'Capitaine', '12-12-2020','3iL',2),
(4, 'KOWA', 'Daniel', 0642279765, 'kowad@3il.fr', '12 places des faeinciers, 76100, Rouen', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',2),
(5, 'THIBAUT', 'Ron', 0642279765, 'thibaut@3il.fr', '1 place Winston churchill, 87000, limoges', 'justificatif-capitaine.pdf', 'Capitaine', '12-12-2020','3iL',3),
(6, 'KUATE', 'Fabrice', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3);

