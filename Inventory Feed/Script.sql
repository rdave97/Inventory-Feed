create database product_db;
use product_db;
create table product_data(
	product_id varchar(40) primary key,
    quantity integer
);
insert into product_data values("abc", 23);
select * from product_data;
drop table product_data;

create table product_data(
	product_id varchar(40) primary key,
    quantity integer
);

