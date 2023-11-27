CREATE OR REPLACE PROCEDURE UpdateStudentAddress(IN studentID INT, IN newAddress VARCHAR(255))
BEGIN
  UPDATE Students SET Address = newAddress WHERE ID_Student = studentID;
END;