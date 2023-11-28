CREATE OR REPLACE PROCEDURE UpdateStudentAddress(studentID INT, newAddress VARCHAR(255))
BEGIN
  UPDATE Students SET Address = newAddress WHERE ID_Student = studentID;
END;
