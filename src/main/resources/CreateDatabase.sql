create schema market_place;
use market_place;
create table user_details
(
    id        int auto_increment unique not null primary key,
    user_name varchar(30) unique        not null,
    password  varchar(30)               not null,
    user_type varchar(30)               not null
);

create table product
(
    id           int auto_increment unique not null primary key,
    product_name varchar(30) unique        not null,
    price        double                    not null,
    quantity     int                       not null
);

create table `order`
(
    id      int auto_increment unique not null primary key,
    user_id int                       not null,
    constraint fk_user_id foreign key (user_id) references user_details (id)
);

create table order_product
(
    order_id   int not null,
    product_id int not null,
    constraint fk_order_id foreign key (order_id) references `order` (id),
    constraint fk_product_id foreign key (product_id) references product (id)

);

insert into user_details (user_name, password, user_type)
values ('Ionut', '123456', 'EMPLOYEE'),
       ('George', '654321', 'CUSTOMER'),
       ('Norocosul', '000000', 'LUCKYONE'),
       ('Marius', '123', 'CUSTOMER');

insert into product (product_name, price, quantity)
values ('TV LCD', 1500, 50),
       ('Smartphone ', 2500, 100),
       ('Laptop', 3500, 30),
       ('Microwave Owen', 300, 50),
       ('Washing Machine', 1500, 40),
       ('Refrigerator', 1200, 25),
       ('Tablet', 800, 200);

  # drop schema market_place;
#   drop table user_details;
#   drop table product;