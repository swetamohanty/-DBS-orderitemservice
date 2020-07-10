DROP TABLE IF EXISTS orderitemdetails;  
create table orderitemdetails
(
   orderid integer not null,
   productcode varchar(255) not null,
   productname varchar(255) not null,
   quantity integer not null
);
