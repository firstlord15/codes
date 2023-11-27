-- Задание 9.1
INSERT INTO Courses (Driving_Category, Tariff_Rate) VALUES ('M', 800.00);

-- Задание 9.2
INSERT INTO Training_Groups (Course_ID, Schedule, Minimum_Participants, Opening_Date) VALUES
  (1, 'График 3', 15, '2023-03-01'),
  (2, 'График 4', 18, '2023-04-01');

-- Задание 9.3
UPDATE Students SET Address = 'Новый адрес' WHERE ID_Student = 1;

-- Задание 9.4
UPDATE Cars SET Reception_Date = '2023-05-01', Write_off_Date = '2023-12-31' WHERE ID_Car = 1;

-- Задание 9.5
UPDATE Students SET Additional_City_Lessons = 3 WHERE ID_Student IN (1, 2);

-- Задание 9.6
DELETE FROM Instructors WHERE ID_Instructor = 1;

-- Задание 9.7
SELECT ID_Student AS StudentID, Passport_Data AS Passport FROM Students;

-- Задание 9.8:
SELECT SUBSTRING(Characteristics, 1, 10) AS ShortCharacteristics FROM Cars;

-- Задание 9.9
SELECT Students.ID_Student, Students.Address, Training_Groups.Schedule
    FROM Students
JOIN Training_Groups ON Students.Training_Groups_ID = Training_Groups.ID_Training_Groups;

-- Задание 9.10
SELECT Students.ID_Student, Students.Address, Training_Groups.Schedule
    FROM Students
    JOIN Training_Groups ON Students.Training_Groups_ID = Training_Groups.ID_Training_Groups
    WHERE Students.Instructor_Mark = 'Зачет' AND Training_Groups.Minimum_Participants > 10
ORDER BY Students.ID_Student;

-- Задание 9.11
SELECT AVG(Service_Life) AS AverageServiceLife, COUNT(*) AS CarCount FROM Cars;
