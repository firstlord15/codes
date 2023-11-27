-- Заполнение таблицы Courses
INSERT INTO Courses (Driving_Category, Tariff_Rate)
VALUES
  ('B', 1000.00),
  ('BE', 1200.00),
  ('C', 1500.00),
  ('CE', 1800.00),
  ('D', 2000.00);

INSERT INTO Courses (Driving_Category, Tariff_Rate)
VALUES
  ('M', 4000.00);

-- Заполнение таблицы Training_Groups
INSERT INTO Training_Groups (Course_ID, Schedule, Minimum_Participants, Opening_Date)
VALUES
  (1, 'График 1', 10, '2023-01-01'),
  (2, 'График 2', 12, '2023-02-01'),
  (3, 'График 3', 15, '2023-03-01'),
  (4, 'График 4', 11, '2023-04-01'),
  (5, 'График 5', 14, '2023-05-01');

-- Заполнение таблицы Students
INSERT INTO Students (Training_Groups_ID, Passport_Data, Address, Phone, Insurance_Policy_Details, Additional_City_Lessons, Additional_Platform_Lessons, Instructor_Mark)
VALUES
  (1, 'Паспортные данные 1', 'Адрес 1', '+7(123)456-7890', 'Полис 1', 1, 2, 'Зачет'),
  (2, 'Паспортные данные 2', 'Адрес 2', '+7(987)654-3210', 'Полис 2', 0, 3, 'Незачет'),
  (3, 'Паспортные данные 3', 'Адрес 3', '+7(111)222-3333', 'Полис 3', 2, 1, 'Зачет'),
  (4, 'Паспортные данные 4', 'Адрес 4', '+7(444)555-6666', 'Полис 4', 3, 0, 'Зачет'),
  (5, 'Паспортные данные 5', 'Адрес 5', '+7(777)888-9999', 'Полис 5', 1, 1, 'Незачет');

-- Заполнение таблицы Cars
INSERT INTO Cars (Characteristics, Reception_Date, Write_off_Date, Service_Life)
VALUES
  ('Характеристики 1', '2022-01-01', '2025-01-01', 3),
  ('Характеристики 2', '2022-02-01', '2025-02-01', 3),
  ('Характеристики 3', '2022-03-01', '2025-03-01', 3),
  ('Характеристики 4', '2022-04-01', '2025-04-01', 3),
  ('Характеристики 5', '2022-05-01', '2025-05-01', 3);

-- Заполнение таблицы Instructors
INSERT INTO Instructors (training_groups_id, Car_ID)
VALUES
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4),
  (5, 5);

-- Заполнение таблицы Practical_Training_Organizations
INSERT INTO Practical_Training_Organizations (Car_ID, Transportation_Provision_Officer)
VALUES
  (1, 'Ответственное лицо 1'),
  (2, 'Ответственное лицо 2'),
  (3, 'Ответственное лицо 3'),
  (4, 'Ответственное лицо 4'),
  (5, 'Ответственное лицо 5');

-- Заполнение таблицы Outings_History
INSERT INTO Outings_History (Student_ID, Instructor_ID, Outing_Date, Outing_Location)
VALUES
  (1, 1, '2023-04-01', 'Город'),
  (2, 2, '2023-04-02', 'Площадка'),
  (3, 3, '2023-04-03', 'Город'),
  (4, 4, '2023-04-04', 'Площадка'),
  (5, 5, '2023-04-05', 'Город');
