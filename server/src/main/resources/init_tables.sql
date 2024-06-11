-- Datenbankschema anlegen

create schema if not exists aperepublic;

USE aperepublic;

-- Tabelle 'User' anlegen

create table if not exists User(
	idUser integer auto_increment,
    username varchar(32),
    firstName varchar(32),
    lastName varchar(32),
    password varchar(32),
    email varchar(32),
    birthday date,
    Primary Key (idUser)
);

-- Tabelle 'Stock' anlegen

create table if not exists Stock(
	ISIN Varchar(12),
    symbol varchar(10),
    name varchar(45),
    description varchar(2048),
    Primary Key (ISIN)
);

-- Tabelle 'Trade' anlegen

create table if not exists Trade(
	idTrade integer auto_increment,
    price decimal(10,2),
    amount decimal(10,2),
    ISIN varchar(12),
    idUser integer,
    Primary Key (idTrade),
    Foreign Key (ISIN) references Stock(ISIN),
    Foreign Key (idUser) references User(idUser)
);

-- Tabelle 'Positions' anlegen

create table if not exists Positions(
	idUser integer not null,
    ISIN varchar(12) not null,
    amount decimal(10,2) not null,
    avgBuyPrice decimal(10,2) not null,
    Primary Key(idUser, ISIN),
    Foreign Key (ISIN) references Stock(ISIN),
    Foreign Key (idUser) references User(idUser)
);