
DROP TABLE IF EXISTS ACCOUNT;

CREATE TABLE ACCOUNT (
  account_number bigint NOT NULL,
  pin int NOT NULL,
  opening_balance int,
  over_draft int,
  PRIMARY KEY (account_number),
  UNIQUE (account_number)
);

DROP TABLE IF EXISTS ATM;

CREATE TABLE ATM (
  id int NOT NULL,
  total_amount int NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (id)
);
DROP TABLE IF EXISTS CURRENCY;

CREATE TABLE CURRENCY (
  id int NOT NULL,
  amount int NOT NULL,
  count int,
  PRIMARY KEY (id),
  UNIQUE (id)
);

insert into ACCOUNT(account_number,pin,opening_balance,over_draft) values(123456789,1234,800,200);
insert into ACCOUNT(account_number,pin,opening_balance,over_draft) values(987654321,4321,1230,150);

insert into ATM(id,total_amount) values(1,1500);


insert into CURRENCY(id,amount,count) values(1,50,10);
insert into CURRENCY(id,amount,count) values(2,20,30);
insert into Currency(id,amount,count) values(3,10,30);
insert into Currency(id,amount,count) values(4,5,20);
