CREATE DATABASE nutrition CHARSET utf8;

use nutrition;
CREATE TABLE coefs(
	value VARCHAR(20) PRIMARY KEY,
    men   DOUBLE      NOT NULL,
    women DOUBLE      NOT NULL
);

INSERT INTO coefs 
	VALUES('gender', 88.3962, 447.593),
          ('weight', 13.397,  9.247),
          ('height', 4.799,   3.098),
          ('age',    5.677,   4.330);
          
SELECT * FROM COEFS;
DROP TABLE food;
CREATE TABLE food(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    number INT NOT NULL,
    calories INT NOT NULL,
    proteins FLOAT NOT NULL,
    fats FLOAT NOT NULL,
    carbohydrates FLOAT NOT NULL
);

INSERT INTO food VALUES
    (NULL, 'boiled chicken egg', 100, 144, 12.7, 10.7, 0.8),
    (NULL, 'buckwheat', 100, 335, 12.6, 3.3, 68.0),
    (NULL, 'rice', 100, 330, 7.0, 1.0, 77.3),
    (NULL, 'semolina porridge', 100, 328, 10.3, 1.0, 73.3),
    (NULL, 'oatmeal', 100, 303, 11.0, 6.1, 65.4),
    (NULL, 'wheat', 100, 301, 13.0, 2.5, 66.6),
    (NULL, 'wheat bran', 100, 191, 15.1, 3.8, 33.5),
    (NULL, 'gercules', 100, 305, 11.0, 6.2, 65.7),
    (NULL, 'holland chese', 100, 352, 26.0, 26.8, 0.6),
    (NULL, 'cottage cheese', 100, 88, 18.0, 0.6, 1.8),
    (NULL, 'cow`s milk', 100, 64, 3.2, 3.6, 4.8),
    (NULL, 'mocarella', 100, 264, 21.2, 20.7, 0.7),
    (NULL, 'kefir not greasy', 100, 30, 3.0, 0.05, 3.8),
    (NULL, 'sour cream 10%', 100, 115, 3.0, 10.0, 2.9),
    (NULL, 'banana', 100, 89, 1.5, 0.1, 21.8),
    (NULL, 'water melon', 100, 38, 0.7, 0.2, 10.9),
    (NULL, 'apple', 100, 45, 0.4, 0.4, 11.8),
    (NULL, 'bird-cherry', 100, 50, 1.1, 0.4, 11.5),
    (NULL, 'cherry', 100, 52, 0.8, 0.5, 11.3),
    (NULL, 'pear', 100, 42, 0.4, 0.3, 10.9);
    
SELECT * FROM food;

CREATE TABLE clients(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender ENUM('M', 'F') NOT NULL,
    height FLOAT NOT NULL,
    weight FLOAT NOT NULL,
    lifestyle ENUM('M', 'L', 'A', 'H', 'E') NOT NULL
);

INSERT INTO clients VALUES
	(NULL, 'Bohdan', 'sudo ap-install mysqlworkbench', '2000-5-17', 'M', 165.9, 66.6, 'L'),
	(NULL, 'Sasha', '$n`t2ch', '2000-8-24', 'M', 178.9, 60.6, 'L'),
	(NULL, 'Nick', 'lukin4you', '2000-9-12', 'M', 180.0, 68.8, 'E'),
	(NULL, 'Bohdan', 'ooo|vosmiklasssnica|', '2000-9-21', 'M', 185.5, 64.3, 'M');
    
SELECT * FROM clients;

CREATE TABLE deflection_history(
	record_id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT NOT NULL,
    date DATE NOT NULL,
    calories FLOAT NOT NULL,
    proteins FLOAT NOT NULL,
    fats FLOAT NOT NULL,
    carbohydrates FLOAT NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE food_history(
	history_id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT NOT NULL,
    food_id INT NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(id),
    FOREIGN KEY (food_id) REFERENCES food(id)
);


SELECT * FROM coefs;
UPDATE coefs SET value=0 WHERE value="age";
UPDATE coefs SET value=1 WHERE value="gender";
UPDATE coefs SET value=2 WHERE value="height";
UPDATE coefs SET value=3 WHERE value="weight";

ALTER TABLE coefs
	MODIFY value TINYINT;
    
SELECT * FROM deflection_history;
ALTER TABLE deflection_history
	CHANGE COLUMN record_id id INT;