CREATE TABLE Book (
    ID_Book SERIAL PRIMARY KEY,
    Title VARCHAR(255) UNIQUE,
    Authors VARCHAR(255),
    Genres VARCHAR(255),
    Publishers VARCHAR(255),
    Publication_Year INT,
    Brief_Plot VARCHAR(1000),
    Num_Pages INT,
    Num_Copies INT,
    Literature_Type VARCHAR(255)
);

CREATE TABLE Client (
    ID_Client SERIAL PRIMARY KEY,
    Full_Name VARCHAR(255) NOT NULL,
    Passport VARCHAR(255) UNIQUE,
    Bank_Card_Details VARCHAR(255)
);

CREATE TABLE Employee (
    ID_Employee SERIAL PRIMARY KEY,
    Full_Name VARCHAR(255) NOT NULL,
    Pass_ID VARCHAR(255) UNIQUE
);

CREATE TABLE Issuance (
    ID_Issuance SERIAL PRIMARY KEY,
    Issue_Date DATE,
    ID_Client INT REFERENCES Client(ID_Client),
    ID_Book INT REFERENCES Book(ID_Book),
    ID_Employee INT REFERENCES Employee(ID_Employee)
);

CREATE TABLE Hall (
    ID_Hall SERIAL PRIMARY KEY,
    Hall_Name VARCHAR(255) UNIQUE,
    Hall_Number INT UNIQUE
);

CREATE TABLE Sector (
    ID_Sector SERIAL PRIMARY KEY,
    Sector_Name VARCHAR(255) UNIQUE,
    Sector_Number INT UNIQUE,
    ID_Hall INT REFERENCES Hall(ID_Hall)
);

CREATE TABLE Shelves (
    ID_Shelves SERIAL PRIMARY KEY,
    Shelves_Name VARCHAR(255) UNIQUE,
    Shelves_Number INT UNIQUE,
    ID_Sector INT REFERENCES Sector(ID_Sector)
);
