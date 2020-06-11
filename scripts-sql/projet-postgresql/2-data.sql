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
(7,'Danielle','NZUMGUENG',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, bordeaux','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(8,'Jordan','TCHEA',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true), 
(9,'Bill','TSOFACK',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(10,'Chloe','BACKERT',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 97080, paris','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(11,'Phoebe','THUNDERMAN',0642279765,'nzumgueda@3il.fr','19 rue jean la-mace, 87110, lyon','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(12,'Max','THUNDERMAN',0642279765,'nzumgueda@3il.fr','1 rue Marshall, 77000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(13,'Billy','THUNDERMAN',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(14,'Nora','THUNDERMAN',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(15,'Thierry','THUNDERMAN',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(16,'Chloe','THUNDERMAN',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(17,'Barb','THUNDERMAN',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(18,'Kenzie','NZUMGUENG',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(19,'Babe','NZUMGUENG',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(20,'Houston','NZUMGUENG',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(21,'Triple-G','NZUMGUENG',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(22,'Double-G','NZUMGUENG',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(23,'Kal','LIGHTMAN',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(24,'Penny','HOFSHTATER',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(25,'Howard','WOLOWITZ',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(26,'Raj','KOUTRAPALI',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(27,'Emmy','CORINE',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(28,'Amanda','TOCHE',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(29,'Amanda','CLARK',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true),
(30,'Amy','COOPER',0642279765,'nzumgueda@3il.fr','9 rue deverrine, 87000, limoges','signaleur, ravi eau, Chrono, remise dossards','12-12-2020',true);


--Equipe
INSERT INTO "equipe"(Id, nomeq, paye, valide, commentaire, nbrerepas)
VALUES (1, 'NZUMGUENG.TCHEA',true,true,'Ok',2),(2, 'TOCHE.KOWA',true,true,'Ok',4),(3, 'THIBAUT.KUATE',false,true,'Ok',5),(4, 'MAMNO.KENGNE',false,true,'Ok',4),(5, 'TAMOKOUE.DJUIKOM',false,true,'Ok',7);


--Participant
  INSERT INTO "participant" (Id, Nom, Prenom, telephone, email, adresse, justificatifs, commentaire, datenaiss, club, id_equipe) 
VALUES (1, 'NZUMGUENG', 'Samson', 0642279765, 'nzumges@3il.fr', 'rue deverrine, 87000, limoges', 'justificatif-capitaine.pdf', 'Capitaine', '12-12-2020','3iL',1),
(2, 'TCHEA', 'Jordan', 0642279765, 'tcheaj@3il.fr', 'avenue albert thomas, 87000, limoges', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',1),
(3, 'TOCHE', 'Harry', 0642279765, 'harry@3il.fr', '01 rue gustave nadaud, 87000, limoges', 'justificatif-capitaine.pdf', 'Capitaine', '12-12-2020','3iL',2),
(4, 'KOWA', 'Daniel', 0642279765, 'kowad@3il.fr', '12 places des faeinciers, 76100, Rouen', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',2),
(5, 'THIBAUT', 'Ron', 0642279765, 'thibaut@3il.fr', '1 place Winston churchill, 87000, limoges', 'justificatif-capitaine.pdf', 'Capitaine', '12-12-2020','3iL',3),
(6, 'KUATE', 'Fabrice', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(7, 'MAMNO', 'Danielle', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-capitaine', 'Capitaine', '12-12-2020','3iL',4),
(8, 'KENGNE', 'Frances', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-Capitaine.pdf', 'Capitaine', '12-12-2020','3iL',4),
(9, 'TAMOKOUE', 'Joel', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',5),
(10, 'DJUIKOM', 'Manuela', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',5),
(11, 'DJUKOM', 'Hilary', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(12, 'KAMNO', 'Lys', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(13, 'KAMDEM', 'Joel', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(14, 'HOFSHTATER','Leonard', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(15, 'COOPER', 'Sheldon', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(16, 'FARHA-FOLER', 'Emmy', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(17, 'SANTIAGO', 'Amy', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(18, 'PERALTHA', 'Jake', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(19, 'LIMOY', 'Arthur', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(20, 'LIGHTMAN', 'Emily', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(21, 'TORRES', 'Ria', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(22, 'MORNING-STAR', 'Lucifer', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(23, 'GRANGER', 'Hermione', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(24, 'WISLEY', 'Ronald', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(25, 'POTTER', 'Harry', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(26, 'WISLEY', 'Jenny', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(27, 'MALFOY', 'Drago', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(28, 'BELLE-DAME', 'Manon', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(29, 'DUBOIS', 'Claire-Helene', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(30, 'ASSOUKE', 'Sophia', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(31, 'TSOFACK', 'Bill', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(32, 'RETORY', 'Amanda', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(33, 'KAMENI', 'Donald', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(34, 'TONLEU', 'Gislain', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(35, 'WOFA', 'Paolyne', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3),
(36, 'MANKU', 'Heidi', 0642279765, 'kuatef@3il.fr', '1 boulevard e la republique, 91000, Paris', 'justificatif-equipier.pdf', 'Equipier', '12-12-2020','3iL',3);

