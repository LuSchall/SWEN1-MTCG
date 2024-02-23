--CREATE DATABASE mymtcgdb;
--DROP DATABASE mymtcgdb;

--\c mymtcgdb;

--### "default case-insensitive" but still...

DROP TABLE users;

CREATE TABLE IF NOT EXISTS users (
    Username VARCHAR(255) PRIMARY KEY,
    Password VARCHAR(255) NOT NULL,
    Points INT DEFAULT 100,
    Elo INT DEFAULT 20,
    Name VARCHAR(255) DEFAULT NULL,
    Bio VARCHAR(255) DEFAULT NULL,
    Image VARCHAR(255) DEFAULT NULL
);

CREATE TYPE CardElement AS ENUM (
    'Normal',
    'Fire',
    'Water',
    'Godlike'
    );

CREATE TYPE CardType AS ENUM (
    'Spell',    -- activates ELEMENT &&& IF WATER wins vs KNIGHTS &&& loses vs KRAKENS
    'Goblin',   -- loses vs DRAGONS
    'Dragon',   -- loses vs FIRE-ELVES &&& wins vs GOBLINS
    'Wizard',   -- wins vs ORKS
    'Ork',      -- loses vs WIZARDS
    'Knight',   -- loses vs WATER-SPELL
    'Kraken',   -- wins vs SPELLS
    'Elve',     -- IF FIRE wins vs DRAGONS
    'Troll'
    );

CREATE TABLE IF NOT EXISTS cards (
    Id VARCHAR(255) PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    CardElement CardElement NOT NULL,
    CardType CardType NOT NULL,
    Damage INT NOT NULL
);