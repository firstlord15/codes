CREATE TABLE user (
    id_user serial NOT NULL CONSTRAINT PK_User PRIMARY KEY,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    age int not null
)