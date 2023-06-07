DROP DATABASE IF EXISTS SCMS;
CREATE DATABASE IF NOT EXISTS SCMS;
USE SCMS;

CREATE TABLE suppliers(
    supplier_id int primary key auto_increment,
    supplier_name varchar(25),
    supplier_address varchar(25),
    supplier_phone varchar(25),
    supplier_email varchar(25),
    manager_name varchar(25)
);

CREATE TABLE users(
    user_id int primary key auto_increment,
    username varchar(25) unique,
    password varchar(25),
    fname varchar(25),
    lname varchar(25),
    email varchar(25),
    phone varchar(25),
    address varchar(25),
    role varchar(25),
    company_id int,
    foreign key(company_id) references suppliers(supplier_id)
);

create TABLE categories(
    category_id int primary key auto_increment,
    category_name varchar(25) unique,
    deleted boolean default false
);

CREATE TABLE products (
  product_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  code VARCHAR(50),
  price DECIMAL(10, 2) NOT NULL,
  unit VARCHAR(50),
  category_id INT,
  description VARCHAR(255),
  image VARCHAR(255),
  supplier_id INT,
  deleted boolean default false,
  FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id),
  FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

CREATE TABLE inventory (
  inventory_id INT PRIMARY KEY AUTO_INCREMENT,
  product_id INT NOT NULL,
  quantity INT NOT NULL,
  location VARCHAR(100),
  date_added DATE default CURRENT_TIMESTAMP,
  expiry_date DATE default NULL,
  owner_id INT,
  info VARCHAR(255),
  FOREIGN KEY (product_id) REFERENCES products(product_id),
  FOREIGN KEY (owner_id) REFERENCES suppliers(supplier_id)
);

create table shipments(
    shipment_id int primary key auto_increment,
    order_id int,
    shipment_date date default CURRENT_TIMESTAMP,
    shipment_status varchar(25),
    starting_point varchar(25),
    destination varchar(25)   
);

CREATE TABLE orders(
    order_id int primary key auto_increment,
    user_id int,
    company_id int,
    product_id int,
    order_quantity int,
    order_status varchar(25),
    order_date date default CURRENT_TIMESTAMP,
    note varchar(255),
    shipment_id int,
    foreign key(product_id) references products(product_id),
    foreign key(company_id) references suppliers(supplier_id),
    foreign key(user_id) references users(user_id),
    foreign key(shipment_id) references shipments(shipment_id)
);


INSERT INTO suppliers (supplier_name, supplier_address, supplier_phone, supplier_email, manager_name) VALUES ('Supplier 1', 'Address 1', '1234567890', 'supplier@supply.me', "user"),
('Supplier 2', 'Address 2', '0987654321', 'supplier2@supply.me', 'user2');

INSERT INTO users (username, password, email, phone, address, role, company_id) VALUES
('admin', 'admin', 'admin', 'admin', 'admin', 'Administrator', 1),
('user', 'user', 'user', 'user', 'user', 'Manager', 1),
('user2', 'user2', 'user2', 'user2', 'user2', 'Employee', 2);

INSERT INTO categories (category_name) VALUES
('Category 1'),
('Category 2'),
('Category 3'),
('Category 4');

INSERT INTO products (name, code, price, unit, category_id, description, image, supplier_id) VALUES 
('Product 1', 'P1', 10, 'Unit', 1, 'Description 1', 'lib/product.png', 1),
('Product 2', 'P2', 20, 'Unit', 2, 'Description 2', 'lib/product.png', 1),
('Product 3', 'P3', 30, 'Unit', 3, 'Description 3', 'lib/product.png', 1),
('Product 4', 'P4', 40, 'Unit', 4, 'Description 4', 'lib/product.png', 1),
('Product 5', 'P5', 50, 'Unit', 1, 'Description 5', 'lib/product.png', 2),
('Product 6', 'P6', 60, 'Unit', 2, 'Description 6', 'lib/product.png', 2),
('Product 7', 'P7', 70, 'Unit', 3, 'Description 7', 'lib/product.png', 2),
('Product 8', 'P8', 80, 'Unit', 4, 'Description 8', 'lib/product.png', 2),
('Product 9', 'P9', 90, 'Unit', 1, 'Description 9', 'lib/product.png', 1),
('Product 10', 'P10', 100, 'Unit', 2, 'Description 10', 'lib/product.png', 1),
('Product 11', 'P11', 110, 'Unit', 3, 'Description 11', 'lib/product.png', 1),
('Product 12', 'P12', 120, 'Unit', 4, 'Description 12', 'lib/product.png', 1),
('Product 13', 'P13', 130, 'Unit', 1, 'Description 13', 'lib/product.png', 2),
('Product 14', 'P14', 140, 'Unit', 2, 'Description 14', 'lib/product.png', 2),
('Product 15', 'P15', 150, 'Unit', 3, 'Description 15', 'lib/product.png', 2),
('Product 16', 'P16', 160, 'Unit', 4, 'Description 16', 'lib/product.png', 2);

INSERT INTO inventory (product_id, quantity, location, expiry_date, owner_id, info) VALUES
(1, 10, 'Location 1', '2021-01-01', 1, 'Info 1'),
(2, 20, 'Location 2', '2021-02-02', 1, 'Info 2'),
(3, 30, 'Location 3', '2021-03-03', 1, 'Info 3'),
(4, 40, 'Location 4', '2021-04-04', 1, 'Info 4'),
(5, 50, 'Location 5', '2021-05-05', 2, 'Info 5'),
(6, 60, 'Location 6', '2021-06-06', 2, 'Info 6'),
(7, 70, 'Location 7', '2021-07-07', 2, 'Info 7'),
(8, 80, 'Location 8', '2021-08-08', 2, 'Info 8');


INSERT INTO orders(user_id, company_id, product_id, order_quantity, order_status, note) VALUES
(2, 1, 1, 10, 'Waiting', 'Note 1'),
(2, 1, 2, 20, 'Accepted', 'Note 2'),
(2, 1, 3, 30, 'Declined', 'Note 3'),
(2, 1, 4, 40, 'Waiting', 'Note 4'),
(2, 2, 5, 50, 'Accepted', 'Note 5'),
(2, 2, 6, 60, 'Accepted', 'Note 6'),
(2, 2, 7, 70, 'Waiting', 'Note 7'),
(2, 2, 8, 80, 'Declined', 'Note 8');


