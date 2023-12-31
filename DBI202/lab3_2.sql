CREATE DATABASE q2;
GO

USE q2;
GO

CREATE TABLE banks (
bankCode VARCHAR(15) NOT NULL PRIMARY KEY,
name VARCHAR(100) NOT NULL
);
GO

CREATE TABLE branches (
branchNo INT NOT NULL PRIMARY KEY IDENTITY(1,1),
name VARCHAR(50) NOT NULL,
address VARCHAR(50) NOT NULL,
bankCode VARCHAR(15) NOT NULL REFERENCES banks(bankCode)
);
GO

CREATE TABLE accounts (
accNo INT NOT NULL PRIMARY KEY IDENTITY(1,1),
type VARCHAR(50) NOT NULL,
balance DECIMAL(10,2) NOT NULL,
branchNo INT NOT NULL REFERENCES branches(branchNo)
);
GO

CREATE TABLE customers (
SSN INT NOT NULL PRIMARY KEY IDENTITY(1,1),
fullName VARCHAR(100) NOT NULL,
phone VARCHAR(20) NOT NULL,
address VARCHAR(255) NOT NULL
);
GO

CREATE TABLE customer_account (
SSN INT NOT NULL,
accNo INT NOT NULL,
roles VARCHAR(15) NOT NULL,
PRIMARY KEY (SSN, accNo),
FOREIGN KEY (SSN) REFERENCES customers(SSN),
FOREIGN KEY (accNo) REFERENCES accounts(accNo)
);
GO