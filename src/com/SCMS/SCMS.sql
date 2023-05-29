DROP DATABASE IF EXISTS SCMS;
CREATE DATABASE IF NOT EXISTS SCMS;
USE SCMS;

CREATE TABLE users(
    user_id int primary key auto_increment,
    username varchar(25) unique,
    password varchar(25),
    email varchar(25),
    phone varchar(25),
    address varchar(25),
    role varchar(25)
);

CREATE TABLE product(
    product_id int primary key auto_increment,
    product_name varchar(25),
    product_price int,
    product_description varchar(25),
    product_image varchar(25),
    product_category varchar(25),
    product_quantity int,
    product_status varchar(25)
);

CREATE TABLE inventory(
    inventory_id int primary key auto_increment,
    product_id int,
    product_quantity int,
    product_status varchar(25),
    foreign key(product_id) references product(product_id)
);

CREATE TABLE suppliers(
    supplier_id int primary key auto_increment,
    supplier_name varchar(25),
    supplier_address varchar(25),
    supplier_phone varchar(25),
    supplier_email varchar(25)
);

CREATE TABLE orders(
    order_id int primary key auto_increment,
    user_id int,
    product_id int,
    order_quantity int,
    order_status varchar(25),
    foreign key(user_id) references users(user_id),
    foreign key(product_id) references product(product_id)
);

