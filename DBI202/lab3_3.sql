
--4 Table: Employees , Contracts, ContractEmp, HourlyEmp
-- With ContractEmp and HourlyEmp as subclasses of Employees

CREATE TABLE Employees (
    empID INT NOT NULL,
    fullName VARCHAR(50) NOT NULL,
    DOB DATE NOT NULL,
    PRIMARY KEY (empID)
);

CREATE TABLE Contracts (
    contractID INT NOT NULL,
    salary FLOAT NOT NULL,
    role VARCHAR(100) NOT NULL,
    PRIMARY KEY (contractID)
);

CREATE TABLE ContractEmp (
    empID INT NOT NULL,
    DOB DATE NOT NULL,
    contractID INT NOT NULL,
    PRIMARY KEY (empID, contractID),
    FOREIGN KEY (empID) REFERENCES Employees(empID),
    FOREIGN KEY (contractID) REFERENCES Contracts(contractID)
);

CREATE TABLE HourlyEmp (
    empID INT NOT NULL,
    hourly_wages FLOAT NOT NULL,
    hours_worked INT NOT NULL,
    PRIMARY KEY (empID),
    FOREIGN KEY (empID) REFERENCES Employees(empID)
);

-- ContractEmp M-N Contracts
CREATE TABLE ContractEmp_Contracts (
    empID INT NOT NULL,
    contractID INT NOT NULL,
    PRIMARY KEY (empID, contractID),
    FOREIGN KEY (empID) REFERENCES ContractEmp(empID),
    FOREIGN KEY (contractID) REFERENCES Contracts(contractID)
);
