create table carBody (
	id serial primary key,
	name varchar(2000)
);

create table engine (
	id serial primary key,
	name varchar(2000)
);

create table transmission (
	id serial primary key,
	name varchar(2000)
);


create table car (
	id serial primary key,
	name varchar(2000),
	t_engine int references engine(id),
	t_carBody int references carBody(id),
	t_transmission int references transmission(id)
);

insert into carBody(name) values('sedan');
insert into carBody(name) values('hatchback');
insert into engine(name)  values('petrol');
insert into engine(name)  values('diesel');
insert into transmission(name)  values('auto');
insert into transmission(name)  values('manual');

insert into car(name, t_engine, t_carBody, t_transmission) 
values ('bmw', 1, 1, 1);
insert into car(name, t_engine, t_carBody, t_transmission) 
values ('bmw', 1, 2, 1);
insert into car(name, t_engine, t_carBody, t_transmission) 
values ('bmw', 2, 1, 1);
insert into car(name, t_engine, t_carBody, t_transmission) 
values ('bmw', 2, 1, 2);
insert into car(name, t_engine, t_carBody, t_transmission) 
values ('audi', 2, 1, 2);
insert into car(name, t_engine, t_carBody, t_transmission) 
values ('audi', 1, 1, 1);
insert into car(name, t_engine, t_carBody, t_transmission) 
values ('audi', 1, 2, 1);
insert into car(name, t_engine, t_carBody, t_transmission) 
values ('audi', 2, 1, 1);
insert into car(name, t_engine, t_carBody, t_transmission) 
values ('audi', 2, 2, 2);

select cr.name, e.name, cb.name, ts.name from car as cr 
left outer join engine as e on cr.t_engine = e.id 
left outer join carBody as cb on cr.t_carBody = cb.id
left outer join transmission as ts on cr.t_transmission = ts.id;

select cr.name, e.name, cb.name, ts.name from car as cr 
left outer join engine as e on cr.t_engine != e.id 
left outer join carBody as cb on cr.t_carBody != cb.id
left outer join transmission as ts on cr.t_transmission != ts.id;


