/*CREATE TABLE Utente(
Id INT PRIMARY KEY,
Nome VARCHAR(30),
Cognome VARCHAR(45),
Data_Nascita DATE,
Numero INT UNIQUE
);*/

/*CREATE TABLE Elemento_Catalogo (
ID INT PRIMARY KEY,
ISBN INT UNIQUE,
Titolo VARCHAR(45),
Anno_Pubb DATE,
Num_Pag INT
);*/

/*CREATE TABLE libri (
    ID INT,
    FOREIGN KEY (ID) REFERENCES Elemento_Catalogo(ID),
    Autore VARCHAR(38),
    Genere VARCHAR(25)
);*/

/*CREATE TABLE Rivista (
    ID INT,
    FOREIGN KEY (ID) REFERENCES Elemento_Catalogo(ID),
    Periodicita VARCHAR(15),
);*/

/*CREATE TABLE PRESTITO (
ID INT PRIMARY KEY,
Data_inizio DATE,
Data_prevista DATE,
Data_effettiva DATE,
Utente_id INT,
Elemento_id INT,
FOREIGN KEY (Utente_id) REFERENCES utente(id),
FOREIGN KEY (Elemento_id) REFERENCES elemento_catalogo(ID)
)*/

