-- Datenbankschema anlegen

create schema if not exists aperepublic;

USE aperepublic;

-- Tabelle 'Users' anlegen

create table if not exists Users(
    idUser integer auto_increment,
    username varchar(32),
    firstName varchar(32),
    lastName varchar(32),
    password varchar(32),
    email varchar(32),
    birthday date,
    Primary Key (idUser)
);

-- Tabelle 'Stocks' anlegen

create table if not exists Stocks(
    symbol varchar(10),
    ISIN Varchar(12),
    name varchar(45),
    description varchar(2048),
    Primary Key (symbol)
);

-- Tabelle 'Trades' anlegen

create table if not exists Trades(
    idTrade integer auto_increment,
    price decimal(10,2),
    amount decimal(10,2),
    symbol varchar(10),
    idUser integer,
    Primary Key (idTrade),
    Foreign Key (symbol) references Stock(symbol),
    Foreign Key (idUser) references User(idUser)
);

-- Tabelle 'Positions' anlegen

create table if not exists Positions(
    idUser integer not null,
    symbol varchar(10) not null,
    amount decimal(10,2) not null,
    avgBuyPrice decimal(10,2) not null,
    Primary Key(idUser, symbol),
    Foreign Key (symbol) references Stock(symbol),
    Foreign Key (idUser) references User(idUser)
);