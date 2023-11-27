CREATE VIEW CombinedData AS
SELECT
  Students.ID_Student,
  Students.Passport_Data,
  Training_Groups.Schedule,
  Cars.Characteristics,
  Instructors.ID_Instructor
FROM Students
JOIN Training_Groups ON Students.Training_Groups_ID = Training_Groups.ID_Training_Groups
JOIN Instructors ON Students.Training_Groups_ID = Instructors.Training_Groups_ID
JOIN Cars ON Instructors.Car_ID = Cars.ID_Car;


SELECT * from CombinedData