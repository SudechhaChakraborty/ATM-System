use atms;
show tables;
drop table sut;
create table sutwo(formno varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(20), pan varchar(20), aadhar varchar(20), seniorcitizen varchar(20), existingaccount varchar(20));
show tables;
select * from sutwo;
create table suthree(formno varchar(20), accountType varchar(40), cardnumber varchar(25), pin varchar(10), facility varchar(100)); 
create table login(formno varchar(20), cardnumber varchar(25), pin varchar(10));
show tables;
select * from suthree;
select * from login;
create table bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20));
select * from login;
select * from bank;
select * from login;
ALTER TABLE bank ADD COLUMN mode VARCHAR(255);
ALTER TABLE bank
DROP COLUMN mode;
select * from bank;
select * from login;

