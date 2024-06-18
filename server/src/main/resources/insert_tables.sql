USE aperepublic;

-- Testtupel zu 'User' hinzufügen

insert into aperepublic.Users (username, firstName, lastName, password, email, birthday)
Values("anisa", "Anisa", "Aburass", "passwort", "a.a@a.com", "2004-07-18");

insert into aperepublic.Users (username, firstName, lastName, password, email, birthday)
Values("culmets", "Anisa", "Aburass", "passwort", "anisa.aburass@gmail.com", "2004-07-18");

-- Testtupel zu 'Stock' hinzufügen

insert into aperepublic.Stocks
Values("AAPL", "US0378331005", "Apple", "To The Moon");

-- Testtupel zu 'Trade' hinzufügen

insert into aperepublic.Trades
Values(4, 23.44, 100.4, "sysy", 1);

-- Testtupel zu 'Position' hinzufügen

insert into aperepublic.Positions
Values(2, "sysy", 1, 12784683.99);
