create schema aperepublic;

USE aperepublic;

create Table User(
	idUser integer auto_increment,
    username varchar(32),
    firstName varchar(32),
    lastName varchar(32),
    password varchar(32),
    email varchar(32),
    birthday date,
    Primary Key (idUser)
);

create table Stock(
	ISIN Varchar(12),
    symbol varchar(10),
    name varchar(45),
    description varchar(2048),
    Primary Key (ISIN)
);

create table Trade(
	idTrade integer auto_increment,
    price decimal(10,2),
    amount decimal(10,2),
    ISIN varchar(12),
    idUser integer,
    Primary Key (idTrade),
    Foreign Key (ISIN) references Stock(ISIN),
    Foreign Key (idUser) references User(idUser)
);

create table Positions(
	idUser integer not null,
    ISIN varchar(12) not null,
    amount decimal(10,2) not null,
    avgBuyPrice decimal(10,2) not null,
    Primary Key(idUser, ISIN),
    Foreign Key (ISIN) references Stock(ISIN),
    Foreign Key (idUser) references User(idUser)
);