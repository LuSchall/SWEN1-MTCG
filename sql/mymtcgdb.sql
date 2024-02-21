--CREATE DATABASE mymtcgdb;
--DROP DATABASE mymtcgdb;

--\c mymtcgdb;

--### I generally don't trust "default case-insensitive"!

DROP TABLE users;

CREATE TABLE IF NOT EXISTS users (
    Id VARCHAR(255) PRIMARY KEY,
    Username VARCHAR(255) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL,
    Points INT DEFAULT 100,
    Elo INT DEFAULT 20,
    Name VARCHAR(255) DEFAULT NULL,
    Bio VARCHAR(255) DEFAULT NULL,
    Image VARCHAR(255) DEFAULT NULL
);

