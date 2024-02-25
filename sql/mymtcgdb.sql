--CREATE DATABASE mymtcgdb;
--DROP DATABASE mymtcgdb;

--\c mymtcgdb;

--### "default case-insensitive" but still...

DROP TABLE users, cards, packages, decks;
--DROP stats
--DROP TYPE CardElement, CardType;

CREATE TABLE IF NOT EXISTS users (
    Username VARCHAR(255) PRIMARY KEY,
    Password VARCHAR(255) NOT NULL,
    Elo INT DEFAULT 100,
    Coins INT DEFAULT 20,
    ProfileName VARCHAR(255) DEFAULT NULL,
    Bio VARCHAR(255) DEFAULT NULL,
    Image VARCHAR(255) DEFAULT NULL,
    Wins int DEFAULT 0,
    Losses int DEFAULT 0
);
/*
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
*/
CREATE TABLE IF NOT EXISTS cards (
    c_Id VARCHAR(255) PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Damage INT NOT NULL,
    Owner VARCHAR(255)  REFERENCES users(Username) DEFAULT NULL,
    CardElement VARCHAR(255) DEFAULT NULL,
    CardType VARCHAR(255) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS packages (
    p_Id SERIAL PRIMARY KEY,
    p_cardId1 VARCHAR(255) REFERENCES cards(c_Id),
    p_cardId2 VARCHAR(255) REFERENCES cards(c_Id),
    p_cardId3 VARCHAR(255) REFERENCES cards(c_Id),
    p_cardId4 VARCHAR(255) REFERENCES cards(c_Id),
    p_cardId5 VARCHAR(255) REFERENCES cards(c_Id)
);

CREATE TABLE IF NOT EXISTS decks (
    Owner VARCHAR(255) REFERENCES users(Username) PRIMARY KEY,
    d_cardId1 VARCHAR(255) references cards(c_Id),
    d_cardId2 VARCHAR(255) references cards(c_Id),
    d_cardId3 VARCHAR(255) references cards(c_Id),
    d_cardId4 VARCHAR(255) references cards(c_Id)
);

-- ### GAME related
-- stats(from user(name, elo), wins, losses);
/*
CREATE TABLE IF NOT EXISTS stats (
    Owner VARCHAR(255) REFERENCES users(Username) PRIMARY KEY,
    Wins INT DEFAULT 0,
    Losses INT DEFAULT 0
);
 */
