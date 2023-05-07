Exercise 1 (5 marks):
--------------------
Create a database schema for the online consultation and therapy website. The database should contain the following tables:-

Doctor table:- The table should contain the attributes such as id, name, specialization, etc.
Appointments table:- The table should contain information related to appointments set up by doctors and patients.
Patient table:- The table should contain information on patients.
Reviews table:- This table should contain reviews posted by patients.
NOTE:- Use proper constraints on the attributes such as primary key, not null and etc.


-- creating a database healthcare for online consultation and therapy website
CREATE DATABASE HEALTHCARE;

-- creating tables (doctor, appointments, patient, reviews) in the healthcare database. 
CREATE TABLE doctor (
    ID INT PRIMARY KEY,                      -- the id of doctor
    NAME VARCHAR(40) NOT NULL,               -- name of the doctor
    SPECIALIZATION VARCHAR(20) NOT NULL      -- specialization of the doctor
    );
    
CREATE TABLE APPOINTMENTS ( 
    APPOINT_ID INT PRIMARY KEY,
    PID INT ,                                      -- patient_id 
    PNAME VARCHAR(40) NOT NULL,                    -- patient name
    DOC_ID INT ,                                   -- doctor id
    DOC_NAME VARCHAR(40) NOT NULL,                 -- doctor name
    APPOINT_DATE DATE NOT NULL,                    -- the date of an appointment
    APPOINT_TIMINGS TIME NOT NULL,                 -- the time of an appointment
    APPOINT_DURATION VARCHAR(20) NOT NULL          -- time duration of an appointment
    );

CREATE TABLE PATIENTS (
    ID INT PRIMARY KEY,                         -- patient id
    PNAME VARCHAR(40) NOT NULL,                 -- patient name
    AGE INT NOT NULL,                           -- patient's age
    GENDER VARCHAR(10) NOT NULL,                -- patient's gender
    CONTACT INT NOT NULL,                       -- patient's contact
    PROBLEM VARCHAR(50)                         -- the problem faced by the patient
    );

CREATE TABLE REVIEWS (
    PID INT PRIMARY KEY,                       -- patient id
    PNAME VARCHAR(40) NOT NULL,                -- name of the patient
    DOC_ID INT NOT NULL,                       -- doctor id
    DOC_NAME VARCHAR(40) NOT NULL,             -- doctor name
    REVIEW VARCHAR(100) NOT NULL               -- the review column is mandatory in the reviews table as it helps to improve the service of online consultation and therapy
    );
_________________________________________________________________________________________________________________________________________________________________________________    
Exercise 2 (5 marks):
---------------------

Contact Table
==============

Id | Email |fname | lname |company |Active_flag |opt_out
123 |a@a.com |Kian |Seth  |ABC      |1           |1
133 |b@a.com |Neha |Seth  |ABC      |1           |0
234 |c@c.com |Puru |Malik |CDF      |0           |0
342 |d@d.com |Sid  |Maan  |TEG      |1           |0

QUESTIONS:
---------
-- creating the contact table having fields Id, Email, fname, lname, company, Active_flag, opt_out
	CREATE TABLE CONTACT (
		Id INT PRIMARY KEY,
		Email VARCHAR(40) NOT NULL,
		fname VARCHAR(10) NOT NULL,
                lname VARCHAR(10) NOT NULL,
		company VARCHAR(30) NOT NULL,
		Active_flag BOOL NOT NULL,
                opt_out BOOL NOT NULL
        );

-- inserting values into the contact table
INSERT INTO CONTACT VALUES (123,'a@a.com','Kian','Seth','ABC',1,1),(133,'b@a.com','Neha','Seth','ABC',1,0),
(234,'c@c.com','Puru','Malik','CDF',0,0),(342,'d@d.com','Sid','Maan','TEG',1,0);
SELECT * FROM CONTACT;

-- Select all columns from the contact table where the active flag is 1
SELECT * FROM CONTACT WHERE Active_flag = 1;
-- Deactivate contacts who are opted out 
UPDATE CONTACT SET Active_flag = 0 WHERE opt_out = 1;
-- Delete all the contacts who have the company name as ‘ABC’
DELETE FROM CONTACT WHERE company = 'ABC';
-- Insert a new row with id as 658, name as ‘mili’, email as ‘mili@gmail.com’, the company as ‘DGH’, active flag as 1, opt-out flag as 1
INSERT INTO CONTACT VALUES (658,"mili@gmail.com", "mili","Iyer","DGH", 1 ,1);
-- Pull out the unique values of the company column 
SELECT DISTINCT(COMPANY) FROM CONTACT;
-- Update name “mili” to “niti”.
UPDATE CONTACT SET fname = "niti" where fname = "mili";
____________________________________________________________________________________________________________________________________________________________________________

Exercise 3 (10 marks):
---------------------
Question:-
________
Write a SQL query to find those customers with a grade less than 100. It should return cust_name, customer city, grade, salesman, and salesman city. 
The result should be ordered by ascending customer_id.


Sample table: customer

customer_id |   cust_name    |    city    | grade | salesman_id 

-------------+----------------+------------+-------+-------------

        3002 | Nick Rimando   | New York   |   100 |        5001

        3007 | Brad Davis     | New York   |   200 |        5001

        3005 | Graham Zusi    | California |   200 |        5002

        3008 | Julian Green   | London     |   300 |        5002

        3004 | Fabian Johnson | Paris      |   300 |        5006

        3009 | Geoff Cameron  | Berlin     |   100 |        5003

        3003 | Jozy Altidor   | Moscow     |   200 |        5007

        3001 | Brad Guzan     | London     |       |        5005

-- creating customer table having attributes customer_id, cust_name, city, grade, salesman_id
CREATE TABLE CUSTOMER (
    customer_id INT PRIMARY KEY,
    cust_name VARCHAR(40) NOT NULL,
    city VARCHAR(30) NOT NULL,
    grade VARCHAR(5) ,
    salesman_id int NOT NULL
    );

-- Inserting values into the customer table
INSERT INTO CUSTOMER VALUES (3002, "Nick Rimando", "New York", 100, 5001), (3007, "Brad Davis", "New York", 200, 5001),
	(3005, "Graham Zusi", "California", 200, 5002), (3008, "Zulian Green", "London", 300, 5002),
    (3004, "Fabian Johnson", "Paris", 300, 5006), (3009, "Goeff Cameron", "Berlin", 100, 5003),
    (3003, "Jozy Altidor", "Moscow", 200, 5007), (3001, "Brad Guzan", "London",' ', 5005);
SELECT * FROM CUSTOMER;

Sample table: salesman

 salesman_id |    name    |   city   | commission 

-------------+------------+----------+------------

        5001 | James Hoog | New York |       0.15

        5002 | Nail Knite | Paris    |       0.13

        5005 | Pit Alex   | London   |       0.11

        5006 | Mc Lyon    | Paris    |       0.14

        5007 | Paul Adam  | Rome     |       0.13

        5003 | Lauson Hen | San Jose |       0.12

-- creating salesman table having attributes salesman_id, name, city, commission
CREATE TABLE SALESMAN (
    salesman_id INT PRIMARY KEY,
    NAME VARCHAR(30) NOT NULL,
    CITY VARCHAR(20) NOT NULL,
    COMMISION FLOAT NOT NULL
    );

-- inserting values into the salesman table
INSERT INTO SALESMAN VALUES (5001, "James Hoog", "New York", 0.15), 
(5002, "Nail Knite", "Paris", 0.13),(5005, "Pit Alex", "London", 0.11),
(5006, "Mc Lyon", "Paris", 0.14),(5007, "Paul Adam", "Rome", 0.13),
(5003, "Lauson Hen", "San Jose", 0.12);
SELECT * FROM SALESMAN;

--  A SQL query to find those customers with a grade less than 100. It should return cust_name, customer city, grade, salesman, and salesman city. The result should be 
ordered by ascending customer_id.
SELECT CUST_NAME, C.CITY, GRADE, S.NAME, S.CITY FROM CUSTOMER C, SALESMAN S 
WHERE C.SALESMAN_ID = S.SALESMAN_ID AND C.GRADE < 100
ORDER BY CUSTOMER_ID;

===============================================================================THE END==================================================================================================

