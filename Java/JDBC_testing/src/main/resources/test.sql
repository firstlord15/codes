CREATE table persons(
    id_user serial NOT NULL CONSTRAINT PK_User PRIMARY KEY,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    age int not null
);

insert into persons (first_name, last_name, age) values
 ('Ratmir', 'Yuldasshev', 25);

UPDATE persons
SET last_name = 'Yuldashev'
WHERE last_name = 'Yuldasshev';
select * from persons;


CREATE table users(
    id_user serial NOT NULL CONSTRAINT PK_Users PRIMARY KEY,
    username varchar(255) not null,
    password varchar(255) not null
);

insert into users (username, password) values ('firstlord15', '0505');