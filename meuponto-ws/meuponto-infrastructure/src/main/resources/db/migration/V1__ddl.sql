CREATE TABLE permissions(
    id BIGINT NOT NULL AUTO_INCREMENT,
    creationDate DATETIME NOT NULL,
    lastModification DATETIME NOT NULL,
    permission INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users(
    id BIGINT NOT NULL AUTO_INCREMENT,
    creationDate DATETIME NOT NULL,
    lastModification DATETIME NOT NULL,
	active BIT NOT NULL,
    email VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE userPermissions(
    userId BIGINT NOT NULL,
    permissionId BIGINT NOT NULL,
	FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (permissionId) REFERENCES permissions(id)
);




