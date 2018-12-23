create table tracker (
	id serial primary key,
	name varchar(2000),
	description text,
	timeCreate timestamp
);