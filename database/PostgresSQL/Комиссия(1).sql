-- Courses
CREATE TABLE Courses (
  ID_Course serial NOT NULL CONSTRAINT PK_Courses PRIMARY KEY,
  Driving_Category VARCHAR(2) CHECK (Driving_Category IN ('B', 'BE', 'C', 'CE', 'D', 'M')),
  Tariff_Rate DECIMAL(10, 2)
);

-- Training Groups
CREATE TABLE Training_Groups (
  ID_Training_Groups serial NOT NULL CONSTRAINT PK_Training_Groups PRIMARY KEY,
  Course_ID INT CONSTRAINT FK_Training_Groups_Courses REFERENCES Courses(ID_Course),
  Schedule VARCHAR(255),
  Minimum_Participants INT CHECK (Minimum_Participants > 0),
  Opening_Date DATE
);

-- Students
CREATE TABLE Students (
  ID_Student serial NOT NULL CONSTRAINT PK_Students PRIMARY KEY,
  Training_Groups_ID INT CONSTRAINT FK_Students_Training_Groups REFERENCES Training_Groups(ID_Training_Groups),
  Passport_Data VARCHAR(255) UNIQUE,
  Address VARCHAR(255),
  Phone VARCHAR(17),
  Insurance_Policy_Details VARCHAR(255),
  Additional_City_Lessons INT,
  Additional_Platform_Lessons INT,
  Instructor_Mark VARCHAR(10) CHECK (Instructor_Mark IN ('Зачет', 'Незачет'))
);

-- Cars
CREATE TABLE Cars (
  ID_Car serial NOT NULL CONSTRAINT PK_Cars PRIMARY KEY,
  Characteristics VARCHAR(255) UNIQUE,
  Reception_Date DATE,
  Write_off_Date DATE,
  Service_Life INT CHECK (Service_Life > 0)
);


-- Instructors
CREATE TABLE Instructors (
  ID_Instructor serial NOT NULL CONSTRAINT PK_Instructors PRIMARY KEY,
  Training_Groups_ID INT CONSTRAINT FK_Instructors_Training_Groups REFERENCES Training_Groups(ID_Training_Groups),
  Car_ID INT CONSTRAINT FK_Instructors_Cars REFERENCES Cars(ID_Car)
);

-- Practical Training Organizations
CREATE TABLE Practical_Training_Organizations (
  ID_Practical_Training_Organizations serial NOT NULL CONSTRAINT PK_Practical_Training_Organizations PRIMARY KEY,
  Car_ID INT CONSTRAINT FK_Practical_Training_Organizations_Cars REFERENCES Cars(ID_Car),
  Transportation_Provision_Officer VARCHAR(255)
);

-- Outings History
CREATE TABLE Outings_History (
  ID_Outings_History serial NOT NULL CONSTRAINT PK_Outings_History PRIMARY KEY,
  Student_ID INT CONSTRAINT FK_Outings_History_Students REFERENCES Students(ID_Student),
  Instructor_ID INT CONSTRAINT FK_Outings_History_Instructors REFERENCES Instructors(ID_Instructor),
  Outing_Date DATE,
  Outing_Location VARCHAR(50)
);


