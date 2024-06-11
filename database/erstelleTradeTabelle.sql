drop table Trade;

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