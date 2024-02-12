--CREATE DATABASE mymtcgdb;
--DROP DATABASE mymtcgdb;

--\c mymtcgdb;

CREATE TABLE IF NOT EXISTS task (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    done BOOLEAN
);

DROP TABLE task;