CREATE TABLE Personne (
   idPersonne integer,
   nom varchar(255) NOT NULL,
   prenom varchar(255) NOT NULL,
   courriel varchar(255) NOT NULL,
   motPasse varchar(255) NOT NULL,
   PRIMARY KEY (idPersonne) 
);



CREATE TABLE _Message (
    idMessage integer PRIMARY KEY,
    objet varchar(255) NOT NULL,
    contenu varchar(255) NOT NULL,
    dateMessage date NOT NULL,
    etatMessage varchar(255) NOT NULL,
    idPersonneEnvoyer integer,
    idPersonneRecevoir integer,
    FOREIGN KEY (idPersonneEnvoyer) REFERENCES Personne(idPersonne),
    FOREIGN KEY (idPersonneRecevoir) REFERENCES Personne(idPersonne),
    CONSTRAINT CheckMessage CHECK (etatMessage IN ('lu', 'non_lu'))
);

CREATE TABLE Utilisateur (
    PersonneidPersonne integer,
    adresse varchar(255) NOT NULL,
    ville varchar(255) NOT NULL,
    postalCode varchar(10) NOT NULL,
    province varchar(10) NOT NULL,
    PRIMARY KEY (PersonneidPersonne),
    FOREIGN KEY (PersonneidPersonne) REFERENCES Personne(idPersonne)
);


CREATE TABLE Professionel (
    PersonneidPersonne integer,
    nomCompagnie varchar(255) NOT NULL,
    PRIMARY KEY (PersonneidPersonne),
    FOREIGN KEY (PersonneidPersonne) REFERENCES Personne(idPersonne)
);



CREATE TABLE OffreTravail(
    idOffreTravail integer,
    nom varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    budget number(8,2) NOT NULL,
    duree integer NOT NULL CHECK (duree > 0),
    etatOffre varchar(255) NOT NULL,
    dateCreationOffre date NOT NULL,
    dateDernierModification date NOT NULL,
    UtilisateurPersonneidPersonne integer,
    PRIMARY KEY (idOffreTravail),
    FOREIGN KEY (UtilisateurPersonneidPersonne) REFERENCES Utilisateur(PersonneidPersonne),
    CONSTRAINT CheckEtatOffre CHECK (etatOffre IN ('attend', 'pris','complete', 'annule'))
);


CREATE TABLE Evaluation (
    PersonneidPersonne integer,
    OffreTravailidOffreTravail integer,
    rang integer NOT NULL,
    commentaire varchar(255) NOT NULL,
    dateEvaluation date NOT NULL,
    typeEvaluateur varchar(255) NOT NULL,
    PRIMARY KEY (PersonneidPersonne, OffreTravailidOffreTravail),
    FOREIGN KEY (PersonneidPersonne) REFERENCES Personne(idPersonne),
    FOREIGN KEY (OffreTravailidOffreTravail) REFERENCES OffreTravail(idOffreTravail),
    CONSTRAINT CheckRang CHECK (rang > 0 AND rang < 6),
    CONSTRAINT CheckEvaluateur CHECK (typeEvaluateur IN ('utilisateur', 'professionel'))
)

create table Soumission(
    idSoumission integer,
    prix number(6,2) NOT NULL,
    description varchar(255) NOT NULL,
    OffreTravailidOffreTravail integer,
    ProfessionelPersonneidPersonne integer,
    etatSoumission varchar(255) NOT NULL,
    CHECK(etatSoumission in('attend','accepte','refuse')),
    dateSoumission date NOT NULL,
 
    primary key(idSoumission),
    foreign key(OffreTravailidOffreTravail) references OffreTravail(idOffreTravail),
    foreign key(ProfessionelPersonneidPersonne) references Professionel(PersonneidPersonne)
);


create table NatureTravail(
    nom varchar(255),
    PRIMARY KEY (nom)
);

create table OffreTravail_NatureTravail(
    OffreTravailidOffreTravail integer,
    NatureTravailnom varchar(255),
 
    primary key(OffreTravailidOffreTravail, NatureTravailnom),
    foreign key(OffreTravailidOffreTravail) references OffreTravail(idOffreTravail),
    foreign key(NatureTravailnom) references NatureTravail(nom)
);
 

