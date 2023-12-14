CREATE TABLE "User" (
    id_user serial NOT NULL CONSTRAINT PK_User PRIMARY KEY,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    age int not null
);

insert into "User" (first_name, last_name, age) values
 ('Ratmir', 'Yuldasshev', 25);

UPDATE "User"
SET last_name = 'Yuldashev'
WHERE last_name = 'Yuldasshev';
select * from "User";