CREATE TABLE Person (
id INTEGER NOT NULL,
name VARCHAR(255) NOT NULL,
location VARCHAR(255),
birth_date TIMESTAMP,
PRIMARY KEY(id)
);

INSERT INTO Person (id, name, location, birth_date)
VALUES
    (10001, 'Joe Mama', 'Country Road',  sysdate()),
    (10002, 'Bill Gates', 'Ligma',  sysdate()),
    (10003, 'John Doe', 'Lole', sysdate()),
    (10004, 'Joe Mama', 'Czechoslovakya',  sysdate())