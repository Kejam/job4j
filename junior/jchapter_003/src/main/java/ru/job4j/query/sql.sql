create table product(
	id serial primary key,
	name varchar(2000),
	type_id int references type(id),
	expired_date timestamp,
	price int
);

create table type(
	id serial primary key,
	name varchar(2000)
);

insert into type (name) values ('chees');
insert into type (name) values ('milk');

insert into product (name, type_id, expired_date, price)
values ('belka', '1', '2001-02-16 20:38:40', 100);
insert into product (name, type_id, expired_date, price)
values ('yoga', '1', '2002-02-16 20:38:40', 200);
insert into product (name, type_id, expired_date, price)
values ('hom', '2', '2001-02-16 20:38:40', 50);
insert into product (name, type_id, expired_date, price)
values ('mot', '2', '2002-02-16 20:38:40', 65);

select * from product as pr where pr.type_id=1;

select * from product as pr where pr.name like '%a%';

select * from product as pr where pr.expired_date 
between '2001-02-16 20:38:40' and '2002-02-16 20:38:40';

select MAX(pr.price) from product as pr;

select count(*) from product as pr where pr.type_id = 1;

select * from product as pr where pr.type_id 
in (1,2);

alter table product add column value int;
select * from product as pr where pr.value < 10;

select * from product as pr inner join type as tp
on pr.type_id = tp.id;



