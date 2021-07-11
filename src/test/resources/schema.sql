-- TABLE SCHEMA
-- Customer table 
drop table if exists ABC_BANK_CUSTOMER_DETAILS;

CREATE TABLE ABC_BANK_CUSTOMER_DETAILS   (
		customer_id INT NOT NULL, 
        customer_name VARCHAR(50),
        customer_surname VARCHAR(50),
        customer_gender CHAR(10),
        customer_dob DATE,
        PRIMARY KEY (customer_id));
 
 -- Account table
 drop table if exists ABC_BANK_ACCOUNT_DETAILS;
 
CREATE TABLE ABC_BANK_ACCOUNT_DETAILS(
		account_number BIGINT NOT NULL,
		account_type CHAR(20) NOT NULL,
        created_timestamp TIMESTAMP,
        modified_timestamp TIMESTAMP,
		balance BIGINT ,
        customer_id INT NOT NULL,
        PRIMARY KEY (account_number)
        );
