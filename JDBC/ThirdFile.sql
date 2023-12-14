-- Задание 10

-- 10.1
CREATE OR REPLACE PROCEDURE add_book(
    title VARCHAR(255),
    author VARCHAR(255),
    genres VARCHAR(255),
    publishers VARCHAR(255),
    publication_year INT,
    brief_plot VARCHAR(1000),
    num_pages INT,
    num_copies INT,
    literature_type VARCHAR(255)
)
AS
$$
BEGIN
    IF publication_year > 1800 THEN
        INSERT INTO Book (Title_Book, Author_Book, Genres_Book, Publishers_Book, Publication_Year_Book,
                         Brief_Plot_Book, Num_Pages_Book, Num_Copies_Book, Literature_Type_Book)
        VALUES (title, author, genres, publishers, publication_year,
                brief_plot, num_pages, num_copies, literature_type);
    ELSE
        RAISE EXCEPTION 'Invalid publication year';
    END IF;
END;
$$
LANGUAGE plpgsql;

-- Д
CREATE OR REPLACE PROCEDURE delete_shelves(shelves_id INT)
AS
$$
DECLARE
    shelf_id INT;
BEGIN
    FOR shelf_id IN (SELECT ID_Shelves FROM Shelves WHERE delete_shelves.shelves_id = Shelves.id_shelves) LOOP
        DELETE FROM Shelf WHERE ID_Shelf = shelf_id;
    END LOOP;
END;
$$
LANGUAGE plpgsql;

--
CREATE OR REPLACE PROCEDURE add_hall(hall_name VARCHAR(255), hall_number INT)
AS
$$
BEGIN
    INSERT INTO Hall (Hall_Name, Hall_Number)
    VALUES (add_hall.hall_name, add_hall.hall_number);
END;
$$
LANGUAGE plpgsql;

--
CREATE OR REPLACE PROCEDURE update_shelf(shelf_id INT, shelf_name VARCHAR(255), shelf_number INT)
AS
$$
BEGIN
    UPDATE Shelf
    SET Shelf_name = update_shelf.shelf_name, Shelf_number = update_shelf.shelf_number
    WHERE ID_Shelf = shelf_id;
END;
$$
LANGUAGE plpgsql;

--
CREATE OR REPLACE PROCEDURE delete_employee(employee_id INT)
AS
$$
BEGIN
    DELETE FROM Employee WHERE ID_Employee = employee_id;
END;
$$
LANGUAGE plpgsql;

--
CREATE OR REPLACE PROCEDURE add_issuance(issue_date DATE, client_id INT)
AS
$$
BEGIN
    INSERT INTO Issuance (Issue_Date_Issuance, Client_ID)
    VALUES (issue_date, add_issuance.client_id);
END;
$$
LANGUAGE plpgsql;



-- 10.1
CALL add_book('The Title', 'The Author', 'Fiction', 'The Publisher', 2023, 'A great story', 300, 50, 'Novel');
select * from book;
-- Д
CALL delete_shelves(1);
select * from sector;

CALL add_hall('Main Hall 2', 1);
select * from hall;
CALL update_shelf(1, 'Updated Shelf', 1);
select * from shelf;
CALL delete_employee(1);
select * from employee;
CALL add_issuance('2023-01-15', 1);
select * from issuance;

