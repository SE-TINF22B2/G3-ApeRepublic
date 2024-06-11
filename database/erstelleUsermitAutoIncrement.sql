drop table user;

create Table User(
	idUser integer Primary key auto_increment,
    username varchar(32) not null,
    firstName varchar(32) not null,
    lastName varchar(32) not null,
    passwort varchar(32) not null,
    email varchar(32) not null,
    birthday date not null
);


insert into aperepublic.User (username, firstName, lastName, passwort, email, birthday)
Values("anisa", "Anisa", "Aburass", "passwort", "a.a@a.com", "2004-07-18");