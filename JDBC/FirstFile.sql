CREATE TABLE Book (
    ID_Book serial NOT NULL CONSTRAINT PK_Book PRIMARY KEY,
    Title_Book VARCHAR(255) UNIQUE,
    Author_Book VARCHAR(255),
    Genres_Book VARCHAR(255),
    Publishers_Book VARCHAR(255),
    Publication_Year_Book INT CHECK (Publication_Year_Book > 1800),
    Brief_Plot_Book VARCHAR(1000),
    Num_Pages_Book INT,
    Num_Copies_Book INT,
    Literature_Type_Book VARCHAR(255)
);

CREATE TABLE Hall (
    ID_Hall serial NOT NULL CONSTRAINT PK_Hall PRIMARY KEY,
    Hall_Name VARCHAR(255) UNIQUE,
    Hall_Number INT UNIQUE
);

CREATE TABLE Employee (
    ID_Employee serial NOT NULL CONSTRAINT PK_Employee PRIMARY KEY,
    Full_Name_Employee VARCHAR(255) NOT NULL,
    Pass_ID_Employee VARCHAR(255) UNIQUE CHECK (Pass_ID_Employee ~ '^[0-9A-Za-z]+$'),
    Hall_ID INT REFERENCES Hall(ID_Hall)
);

CREATE TABLE Client (
    ID_Client serial NOT NULL CONSTRAINT PK_Client PRIMARY KEY,
    Full_Name_Client VARCHAR(255) NOT NULL,
    Passport_Client VARCHAR(255) UNIQUE CHECK (Passport_Client ~ '^[0-9A-Za-z]+$'),
    Bank_Card_Details_Client VARCHAR(255),
    Book_ID INT REFERENCES Book(ID_Book),
    Employee_ID INT REFERENCES Employee(ID_Employee)
);


CREATE TABLE Issuance (
    ID_Issuance serial NOT NULL CONSTRAINT PK_Issuance PRIMARY KEY,
    Issue_Date_Issuance DATE CHECK (Issue_Date_Issuance <= CURRENT_DATE),
    Client_ID INT REFERENCES Client(ID_Client)
);


CREATE TABLE Sector (
    ID_Sector serial NOT NULL CONSTRAINT PK_Sector PRIMARY KEY,
    Sector_Name VARCHAR(255) UNIQUE,
    Sector_Number INT UNIQUE,
    Hall_ID INT REFERENCES Hall(ID_Hall)
);

CREATE TABLE Shelves (
    ID_Shelves serial NOT NULL CONSTRAINT PK_Shelves PRIMARY KEY,
    Shelves_Name VARCHAR(255) UNIQUE,
    Shelves_Number INT UNIQUE,
    Sector_ID INT REFERENCES Sector(ID_Sector)
);

CREATE TABLE Shelf (
    ID_Shelf serial NOT NULL CONSTRAINT PK_Shelf PRIMARY KEY,
    Shelf_name VARCHAR(255) UNIQUE,
    Shelf_number INT UNIQUE,
    Shelves_ID INT REFERENCES Shelves(ID_Shelves)
);