CREATE TABLE permissions(
    id INT NOT NULL AUTO_INCREMENT,
    creationDate DATETIME NOT NULL,
    lastModification DATETIME NULL,
    permission INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT,
    creationDate DATETIME NOT NULL,
    lastModification DATETIME NULL,
	active BIT NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE userPermissions(
    userId INT NOT NULL,
    permissionId INT NOT NULL,
	FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (permissionId) REFERENCES permissions(id)
);

CREATE TABLE customers(
    id INT NOT NULL AUTO_INCREMENT,
    creationDate DATETIME NOT NULL,
    lastModification DATETIME  NULL,
    cnpj VARCHAR(14) NOT NULL UNIQUE,
    corporateName VARCHAR(120) NOT NULL,
    tradeName VARCHAR(120) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE collaborators(
    id INT NOT NULL AUTO_INCREMENT,
    creationDate DATETIME NOT NULL,
    lastModification DATETIME  NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    name VARCHAR(225) NOT NULL,
    registration VARCHAR(12) NOT NULL,
    dateOfBirth DATE NULL,
    admissionDate DATETIME NULL,
    email VARCHAR(255)  NOT NULL UNIQUE,
    PRIMARY KEY (id)
);



