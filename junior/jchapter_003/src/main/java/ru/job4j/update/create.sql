create database TEMP
create table users(
	id serial primary key,
	nameUser varchar(2000),
	aboutUser text
);
insert into users (nameUser, aboutUser) values ('Alex', 'Alex is cool boy');

