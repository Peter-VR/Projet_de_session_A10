-- SEQUENCEs ------------------------------------------------------
DROP SEQUENCE hibernate_sequence;
CREATE SEQUENCE hibernate_sequence START WITH 100;

-- TABLEs ------------------------------------------------------
DROP TABLE OffreTravail_NatureTravail;
DROP TABLE NatureTravail;
DROP TABLE Soumission;
DROP TABLE Evaluation;
DROP TABLE OffreTravail;
DROP TABLE Message;
DROP TABLE Professionel;
DROP TABLE Utilisateur;
DROP TABLE Personne;

CREATE TABLE Personne
(
    idPersonne integer,
    nom        varchar(255) NOT NULL,
    prenom     varchar(255) NOT NULL,
    courriel   varchar(255) NOT NULL,
    motPasse   varchar(255) NOT NULL,
    PRIMARY KEY (idPersonne)
);

CREATE TABLE Message
(
    idMessage          integer,
    objet              varchar(255) NOT NULL,
    contenu            varchar(255) NOT NULL,
    dateMessage        date         NOT NULL,
    etatMessage        varchar(255) NOT NULL,
    idPersonneEnvoyer  integer,
    idPersonneRecevoir integer,
    PRIMARY KEY (idMessage),
    FOREIGN KEY (idPersonneEnvoyer) REFERENCES Personne (idPersonne),
    FOREIGN KEY (idPersonneRecevoir) REFERENCES Personne (idPersonne),
    CONSTRAINT CheckMessage CHECK (etatMessage IN ('lu', 'non_lu'))
);

CREATE TABLE Utilisateur
(
    PersonneidPersonne integer,
    adresse            varchar(255) NOT NULL,
    ville              varchar(255) NOT NULL,
    postalCode         varchar(10)  NOT NULL,
    province           varchar(10)  NOT NULL,
    PRIMARY KEY (PersonneidPersonne),
    FOREIGN KEY (PersonneidPersonne) REFERENCES Personne (idPersonne)
);

CREATE TABLE Professionel
(
    PersonneidPersonne integer,
    nomCompagnie       varchar(255) NOT NULL,
    PRIMARY KEY (PersonneidPersonne),
    FOREIGN KEY (PersonneidPersonne) REFERENCES Personne (idPersonne)
);

CREATE TABLE OffreTravail
(
    idOffreTravail                integer,
    nom                           varchar(255) NOT NULL,
    description                   varchar(255) NOT NULL,
    budget                        number(8, 2) NOT NULL,
    duree                         integer      NOT NULL CHECK (duree > 0),
    etatOffre                     varchar(255) NOT NULL,
    dateCreationOffre             date         NOT NULL,
    dateDernierModification       date         NOT NULL,
    UtilisateurPersonneidPersonne integer,
    PRIMARY KEY (idOffreTravail),
    FOREIGN KEY (UtilisateurPersonneidPersonne) REFERENCES Utilisateur (PersonneidPersonne),
    CONSTRAINT CheckEtatOffre CHECK (etatOffre IN ('attend', 'pris', 'complete', 'annule'))
);

CREATE TABLE Evaluation
(
    PersonneidPersonne         integer,
    OffreTravailidOffreTravail integer,
    rang                       integer      NOT NULL,
    commentaire                varchar(255) NOT NULL,
    dateEvaluation             date         NOT NULL,
    typeEvaluateur             varchar(255) NOT NULL,
    PRIMARY KEY (PersonneidPersonne, OffreTravailidOffreTravail),
    FOREIGN KEY (PersonneidPersonne) REFERENCES Personne (idPersonne),
    FOREIGN KEY (OffreTravailidOffreTravail) REFERENCES OffreTravail (idOffreTravail),
    CONSTRAINT CheckRang CHECK (rang >= 1 AND rang <= 5),
    CONSTRAINT CheckEvaluateur CHECK (typeEvaluateur IN ('utilisateur', 'professionel'))
);

CREATE TABLE Soumission
(
    idSoumission                   integer,
    prix                           number(6, 2) NOT NULL,
    description                    varchar(255) NOT NULL,
    OffreTravailidOffreTravail     integer,
    ProfessionelPersonneidPersonne integer,
    etatSoumission                 varchar(255) NOT NULL,
    CHECK (etatSoumission in ('attend', 'accepte', 'refuse')),
    dateSoumission                 date         NOT NULL,
    PRIMARY KEY (idSoumission),
    FOREIGN KEY (OffreTravailidOffreTravail) references OffreTravail (idOffreTravail),
    FOREIGN KEY (ProfessionelPersonneidPersonne) references Professionel (PersonneidPersonne)
);

CREATE TABLE NatureTravail
(
    nom varchar(255),
    PRIMARY KEY (nom)
);

CREATE TABLE OffreTravail_NatureTravail
(
    OffreTravailidOffreTravail integer,
    NatureTravailnom           varchar(255),
    PRIMARY KEY (OffreTravailidOffreTravail, NatureTravailnom),
    FOREIGN KEY (OffreTravailidOffreTravail) references OffreTravail (idOffreTravail),
    FOREIGN KEY (NatureTravailnom) references NatureTravail (nom)
);

-- INSERTs ------------------------------------------------------
INSERT INTO Personne VALUES (3,'Personne 3 nom','Personne 3 prenom','p3@gmail.com','pw');
INSERT INTO Personne VALUES (4,'Personne 4','prenom','pers4@yahoo.com','pw');

INSERT INTO Utilisateur VALUES (3,'32 Fake Street3','Fake City3','H1H1H13','Province3');
INSERT INTO Utilisateur VALUES (4,'45 Street4','City4','H1H1H13','Province3');

INSERT INTO NatureTravail VALUES ('NatureTravail 1');
INSERT INTO NatureTravail VALUES ('NatureTravail 2');

INSERT INTO Message VALUES (1,'m1 from 3 to 4','content',SYSDATE,'non_lu',3,4);
INSERT INTO Message VALUES (2,'m2 from 4 to 3','c2',SYSDATE,'lu',4,3);
INSERT INTO Message VALUES (3,'m3 from 4 to 3','c3',SYSDATE,'non_lu',4,3);
INSERT INTO Message VALUES (4,'m4 from 4 to 3','c4',SYSDATE,'lu',4,3);
