drop table Positions;

create table Positions(
	idUser integer not null,
    ISIN varchar(12) not null,
    amount decimal(10,2) not null,
    avgBuyPrice decimal(10,2) not null,
    Primary Key(idUser, ISIN),
    Foreign Key (ISIN) references Stock(ISIN),
    Foreign Key (idUser) references User(idUser)
);