USE master;
GO

IF EXISTS (SELECT name FROM sys.databases WHERE name = N'lab3Q1')
    DROP DATABASE lab3Q1;

CREATE DATABASE lab3Q1;
GO

USE lab3Q1;
GO

CREATE TABLE employees (
    empID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    fullName VARCHAR(50) NOT NULL,
    DOB DATE NOT NULL,
    rollCode INT NOT NULL FOREIGN KEY REFERENCES roles(rollCode),
    storeID INT NOT NULL FOREIGN KEY REFERENCES stores(storeID)
);

CREATE TABLE stores (
    storeID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    address VARCHAR(50) NOT NULL
);

CREATE TABLE products (
    productID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    productName VARCHAR(50) NOT NULL,
    price INT NOT NULL
);

CREATE TABLE roles (
    rollCode INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE store_product (
    storeID INT NOT NULL,
    productID INT NOT NULL,
    quantity INT NOT NULL,  
    PRIMARY KEY (storeID, productID),
    FOREIGN KEY (storeID) REFERENCES stores(storeID),
    FOREIGN KEY (productID) REFERENCES products(productID)
);
