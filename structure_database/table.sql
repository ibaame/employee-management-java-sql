create database employeeManagement;

use employeeManagement;

create table Employee(

EID varchar(25) not null,
firstname varchar(25),
lastname varchar(25),
jobTitle varchar(15),
city varchar(25),
BOD date,
phone varchar(10) unique,
email varchar(25) unique,
primary key(EID)

);