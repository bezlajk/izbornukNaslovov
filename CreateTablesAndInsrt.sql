create table post (
	 id INT(255) PRIMARY KEY,
     name VARCHAR(300)
);

create table address (
    id INT(255) PRIMARY KEY,
    nameOfAddress VARCHAR(300),
    companyName VARCHAR(300),
    street VARCHAR(300),
    houseNumber INT(255),
    postId INT(255),
    city  VARCHAR(300),
    country VARCHAR(300),
    isDefault boolean,
	FOREIGN KEY (postId) REFERENCES post(id)
);

create table person (
    id INT(255) PRIMARY KEY,
    name VARCHAR(300),
    surname VARCHAR(300),
    defaultAddressId INT(255),
	FOREIGN KEY (defaultAddressId) REFERENCES address(id)
);

create table address_person (
     addressId INT(255),
     personId INT(255),
     PRIMARY KEY (addressId, personId),
     FOREIGN KEY (addressId) REFERENCES address(id),
     FOREIGN KEY (personId) REFERENCES person(id)
);

INSERT INTO POST (id, name) values (1000, 'Ljubljana');
INSERT INTO address (id, nameOfAddress, companyName, street, houseNumber, postId, city, country, isDefault)
 values (1, 'Naslov 1', 'Petrol d.d.','Dunajska cesta',50,1000,'Ljubljana','Slovenija',1
 );
 
 INSERT INTO person (id, name, surname) values (1, 'Janez', 'Novak');
 INSERT INTO address_person values (1,1);
 commit;
 
 CREATE TABLE sequence_address ( sequence_name VARCHAR(30), next_val INT NOT NULL);
 INSERT INTO sequence_address VALUES ('Address', 1);
 SET SQL_SAFE_UPDATES = 0;
 UPDATE sequence_address SET next_val=LAST_INSERT_ID(next_val+1);
 
 CREATE TABLE sequence_person ( sequence_name VARCHAR(30), next_val INT NOT NULL);
 INSERT INTO sequence_person VALUES ('Person', 1);
 UPDATE sequence_person SET next_val=LAST_INSERT_ID(next_val+1);
 


