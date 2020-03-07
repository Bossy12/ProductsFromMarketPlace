create table user_details
(
    id        int auto_increment unique not null primary key,
    user_name varchar(30)               not null,
    password  varchar(30)               not null,
    user_type varchar(30)               not null
);

create table product
(
    product_id   int auto_increment unique not null primary key,
    product_name varchar(30)               not null,
    price        double                    not null,
    quantity     int                       not null
);

insert into user_details (user_name, password, user_type)
values ('Ionut', '123456', 'employee'),
        ('George', '654321', 'costumer'),
        ('Marius', '142536', 'costumer');

insert into product (product_name, price, quantity)
values ('TV LCD',1500,50),
       ('Smartphone ', 2500, 100),
       ('Laptop', 3500, 30),
       ('Microwave Owen', 300, 50),
       ('Washing Machine',1500, 40),
       ('Refrigerator', 1200, 25),
       ('Tablet', 800, 200);


drop table user_details;
/*drop table product;
