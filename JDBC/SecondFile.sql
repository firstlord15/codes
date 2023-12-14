-- Просто заполнил данными таблицы

INSERT INTO Book (Title_Book, Author_Book, Genres_Book, Publishers_Book, Publication_Year_Book, Brief_Plot_Book, Num_Pages_Book, Num_Copies_Book, Literature_Type_Book)
VALUES
  ('The Great Gatsby', 'F. Scott Fitzgerald', 'Classic', 'Scribner', 1925, 'A story of the Jazz Age in New York', 180, 100, 'Fiction'),
  ('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 'J.B. Lipoprotein & Co.', 1960, 'Racial injustice in the American South', 281, 80, 'Fiction'),
  ('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 'George Allen & Unwind', 1937, 'Bilbo Bagginess goes on an adventure', 310, 120, 'Fiction'),
  ('Sapiens: A Brief History of Humankind', 'Yuval Noah Harri', 'History', 'Harper', 2014, 'Human history from the Stone Age to the present', 443, 150, 'Non-fiction'),
  ('The Elements of Style', 'William Struck Jr. and E.B. White', 'Writing', 'Macmillan Publishers', 1918, 'Guide to English language usage', 105, 60, 'Non-fiction');

INSERT INTO Hall (Hall_Name, Hall_Number)
VALUES
  ('Main Hall', 101),
  ('Fiction Hall', 102),
  ('Non-fiction Hall', 103),
  ('History Hall', 104),
  ('Science Hall', 105);

INSERT INTO Employee (Full_Name_Employee, Pass_ID_Employee, hall_id)
VALUES
  ('Manager One', 'EMP123', 1),
  ('Manager Two', 'EMP456', 2),
  ('Librarian One', 'EMP789', 3),
  ('Librarian Two', 'EMP101', 4),
  ('Clerk One', 'EMP112', 5);

INSERT INTO Client (Full_Name_Client, Passport_Client, Bank_Card_Details_Client, book_id, employee_id)
VALUES
  ('John Doe', 'AB123456', '1234-5678-9101-1121', 1, 1),
  ('Jane Smith', 'CD789012', '2121-3456-7890-1011', 2, 2),
  ('Bob Johnson', 'EF456789', '3456-7890-1121-1213', 3, 3),
  ('Alice Brown', 'GH987654', '5678-9012-1213-1314', 4, 4),
  ('Charlie Wilson', 'IJ345678', '7890-1234-1415-1516', 5, 5);


INSERT INTO Issuance (Issue_Date_Issuance, Client_ID)
VALUES
  ('2023-01-01', 1),
  ('2023-02-01', 2),
  ('2023-03-01', 3),
  ('2023-04-01', 4),
  ('2023-05-01', 5);

INSERT INTO Sector (Sector_Name, Sector_Number, Hall_ID)
VALUES
  ('Sector A', 1, 1),
  ('Sector B', 2, 2),
  ('Sector C', 3, 3),
  ('Sector D', 4, 4),
  ('Sector E', 5, 5);

INSERT INTO Shelves (Shelves_Name, Shelves_Number, Sector_ID)
VALUES
  ('Shelves 1', 1, 1),
  ('Shelves 2', 2, 2),
  ('Shelves 3', 3, 3),
  ('Shelves 4', 4, 4),
  ('Shelves 5', 5, 5);

INSERT INTO Shelf (Shelf_name, Shelf_number, Shelves_ID)
VALUES
  ('Shelf A', 1, 1),
  ('Shelf B', 2, 2),
  ('Shelf C', 3, 3),
  ('Shelf D', 4, 4),
  ('Shelf E', 5, 5);


-- Выполнение заданий 9:

-- 1
INSERT INTO Book (Title_Book, Author_Book, Genres_Book, Publishers_Book, Publication_Year_Book, Brief_Plot_Book, Num_Pages_Book, Num_Copies_Book, Literature_Type_Book)
VALUES ('New Book', 'New Author', 'New Genre', 'New Publisher', 2023, 'New Plot', 200, 10, 'New Type');
SELECT * FROM book;

-- 2
INSERT INTO Client (Full_Name_Client, Passport_Client, Bank_Card_Details_Client, book_id, employee_id)
VALUES
  ('Client 1', 'AB123457', '1234-5678-9101-1122', 1, 2),
  ('Client 2', 'CD789013', '2121-3456-7890-1012', 1, 2);
SELECT * FROM client;

-- 3
UPDATE Book
SET Num_Copies_Book = 15
WHERE ID_Book = 1;
SELECT * FROM book;

-- 4
UPDATE Client
SET Full_Name_Client = 'Updated Name', Bank_Card_Details_Client = 'Updated Details'
WHERE ID_Client = 1;
SELECT * FROM client;

-- 5
UPDATE Client
SET Full_Name_Client = 'Updated Name', Bank_Card_Details_Client = 'Updated Details'
WHERE ID_Client IN (1, 2);
SELECT * FROM client;

-- 7
SELECT Full_Name_Client AS "Имя клиентов", Passport_Client AS "Паспорт клиентов" FROM Client;

-- 8
SELECT SUBSTRING(Full_Name_Client FROM 1 FOR 5) AS "Short name" FROM Client;

-- 9
SELECT Book.Title_Book, Client.Full_Name_Client
FROM Book
JOIN Client ON Book.id_book = Client.book_id;

-- 10
SELECT Book.Title_Book, Issuance.Issue_Date_Issuance, Client.Full_Name_Client
FROM Book
JOIN Client ON Book.id_book = Client.book_id
JOIN Issuance ON Client.id_client = Issuance.client_id
WHERE Issuance.Issue_Date_Issuance > '2023-01-01'
ORDER BY Issuance.Issue_Date_Issuance DESC;

-- Д
SELECT AVG(Num_Pages_Book) AS "Avg Pages", MAX(Num_Copies_Book) AS "Max Copies", Literature_Type_Book
FROM Book
GROUP BY Literature_Type_Book;




-- 6
DELETE FROM Employee WHERE ID_Employee = 1;

-- Д
DELETE FROM Employee WHERE ID_Employee IN (2, 3);
