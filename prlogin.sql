create database universitymanagementsystem;

show databases;
use universitymanagementsystem;

create table login(username varchar(25), password varchar(25));

insert into login values('admin', '12345');

select * from login;