drop database assignment1;
create database assignment1;
use assignment1;
create table customer(customer_id varchar(10) primary key,
customer_name varchar(10),gender varchar(1),
dob date, mobile_no int);

create table category(category_code varchar(10) primary key,
category_name varchar(10));

create table sales(sales_id varchar(10) primary key,
sales_name varchar(10),gender varchar(1),
dob date, mobile_no int,location_code varchar(10));

create table location(location_code varchar(10) primary key,
location_name varchar(10));

create table product(product_code varchar(10) primary key,
product_name varchar(10),unit_price int,
category_code varchar(10));

create table sells(category_code varchar(10),
sales_id varchar(10));

create table purchases(product_code varchar(10),customer_id varchar(10),
units int,dop date); 

insert into customer values(1,'lakshay','M','1998-08-14',1234);
insert into customer values(2,'kashish','M','1998-08-19',5678);

insert into category values(1,'tea');
insert into category values(2,'coffee');
insert into category values(3,'milk');

insert into sales values(1,'uppal','M','1998-12-30',8347,1);
insert into sales values(2,'walia','M','1998-11-17',5757,2);

insert into location values(1,'assam');
insert into location values(2,'hp');

insert into product values(1,'redlabel',20,1);
insert into product values(2,'nescafe',30,2);
insert into product values(3,'amul',50,3);

insert into sells values(1,1);
insert into sells values(2,2);
insert into sells values(3,2);

insert into purchases values(2,1,1,'2021-01-07');
insert into purchases values(2,2,3,'2021-01-07');
insert into purchases values(3,2,5,'2021-01-07');
insert into purchases values(3,2,5,'2020-12-30');
insert into purchases values(2,2,3,'2021-01-06');
insert into purchases values(3,2,1,'2021-01-06');




select product.product_name,purchases.dop from product 
inner join purchases on purchases.product_code=product.product_code
inner join category on product.category_code=category.category_code 
inner join sells on category.category_code=sells.category_code
inner join sales on sells.sales_id=sales.sales_id
inner join location on sales.location_code=location.location_code where location.location_name ='hp' group by
dop having dop>curdate()-interval 7 day  and max(purchases.units) in
(select max(purchases.units) from purchases group by dop having dop>curdate()-interval 7 day );






