import sqlite3
import pytest
from database import *

# Данные для тестов
BUYER_NAME = "John Doe"
KENNEL_NAME = "New Kennel Name"
DOG_NAME = "Dog's name"


@pytest.fixture(scope='session')
def start_db():
    connection = db_connection()
    print('Initializing Database')
    yield connection
    connection.close()
    print('Finalizing Database')



def test_db_connection(start_db):
    # Ваш тест с использованием подключения к базе данных
    cursor = start_db.cursor()
    cursor.execute("SELECT name FROM sqlite_master WHERE type='table';")
    tables = cursor.fetchall()

    # Проверка, что таблицы созданы
    assert ("Buyer",) in tables
    assert ("Kennel",) in tables
    assert ("Dog",) in tables


# Тесты по Insert, Select, Update, Delete 
@pytest.fixture(scope='function')
def setup_database():
    conn = sqlite3.connect(DB_NAME)
    create_tables(conn)
    yield conn
    conn.close()


def test_insert_operation(setup_database):
    cursor = setup_database.cursor()
    cursor.execute("INSERT INTO Buyer (name, dog_id) VALUES (?, ?)", (BUYER_NAME, 1))
    cursor.execute("INSERT INTO Kennel (name) VALUES (?)", (KENNEL_NAME,))
    cursor.execute("INSERT INTO Dog (name, kennel_id, buyer_id) VALUES (?, ?, ?)", (DOG_NAME, 1, None))
    cursor.execute("SELECT * FROM Buyer WHERE name=?", (BUYER_NAME,))
    
    setup_database.commit() # сохраним
    
    result = cursor.fetchone()
    
    assert result is not None
    assert result[1] == "John Doe"
    



def test_select_operation(setup_database):
    cursor = setup_database.cursor()
    cursor.execute("SELECT * FROM Dog")
    result = cursor.fetchall()
    
    assert len(result) > 0



def test_update_operation(setup_database):
    cursor = setup_database.cursor()
    cursor.execute("UPDATE Buyer SET name=? WHERE id=?", ("New Buyer Name", 1))
    cursor.execute("SELECT name FROM Buyer WHERE id=?", (1,))
    result = cursor.fetchone()
    assert result is not None


def test_delete_operation(setup_database):
    cursor = setup_database.cursor()
    cursor.execute("DELETE FROM Buyer WHERE name=?", (BUYER_NAME,))
    cursor.execute("SELECT * FROM Buyer WHERE name=?", (BUYER_NAME,))

    result = cursor.fetchone() 
    assert result is None

    
    cursor.execute("DELETE FROM Dog WHERE name=?", (DOG_NAME,))
    cursor.execute("SELECT * FROM Dog WHERE name=?", (DOG_NAME,))

    result = cursor.fetchone() 
    assert result is None

    cursor.execute("DELETE FROM Kennel WHERE name=?", (KENNEL_NAME,))
    cursor.execute("SELECT * FROM Kennel WHERE name=?", (KENNEL_NAME,))

    setup_database.commit() # сохраним

    result = cursor.fetchone() 
    assert result is None
