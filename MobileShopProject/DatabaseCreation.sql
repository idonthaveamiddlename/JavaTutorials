DROP DATABASE devank;
CREATE DATABASE devank;
USE devank;

CREATE TABLE CUSTOMER(
	customer_id INTEGER PRIMARY KEY,
	cust_name VARCHAR(40),
	email_id varchar(20),
	mob_number varchar(15)
);

CREATE TABLE MOBILE_PHONE(
	serial_number INTEGER PRIMARY KEY,
	brand varchar(20),
	model varchar(20),
	stock_in_hand INTEGER,
	cost_in_rupees INTEGER
);

CREATE TABLE PURCHASE(
	purchase_id INTEGER PRIMARY KEY,
	cust_id INTEGER,
	model_id INTEGER,
	date_of_purchase DATE,
	FOREIGN KEY (cust_id) REFERENCES CUSTOMER(customer_id),
	FOREIGN KEY (model_id) REFERENCES MOBILE_PHONE(serial_number)
);

INSERT INTO MOBILE_PHONE VALUES(101,'Apple','iPhone X',5,64000);
INSERT INTO MOBILE_PHONE VALUES(102,'Samsung','Galaxy S9',3,84000);
INSERT INTO MOBILE_PHONE VALUES(201,'HTC','U11+',6,32000);
INSERT INTO MOBILE_PHONE VALUES(301,'Google','Pixel 3',1,79000);
INSERT INTO MOBILE_PHONE VALUES(302,'Mi','Mix 2',8,28500);