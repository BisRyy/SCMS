<<<<<<< HEAD
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

=======
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

CREATE TABLE products (
  product_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  code VARCHAR(50) NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  unit VARCHAR(50),
  category VARCHAR(100),
  description VARCHAR(255),
  image VARCHAR(255),
  supplier_id INT
);

CREATE TABLE inventory (
  inventory_id INT PRIMARY KEY AUTO_INCREMENT,
  product_id INT NOT NULL,
  quantity INT NOT NULL,
  location VARCHAR(100),
  date_added DATE default CURRENT_TIMESTAMP,
  expiry_date DATE,
  FOREIGN KEY (product_id) REFERENCES products(product_id)
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
    user_name varchar(20),
    product_id int,
    product_name varchar(20),
    product_price int,
    order_quantity int,
    order_status varchar(25),
    date_and_time varchar(25),
    foreign key(user_id) references users(user_id),
    foreign key(product_id) references product(product_id)
);

ALTER TABLE products ADD FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id);


INSERT INTO products (name, code, price, unit, category, description, image, supplier_id) VALUES
('Product 1', 'P1', 10.00, 'Unit', 'Category', 'Description', 'Image', 1),
('Product 2', 'P2', 20.00, 'Unit', 'Category', 'Description', 'Image', 1),
('Product 3', 'P3', 30.00, 'Unit', 'Category', 'Description', 'Image', 2),
('Product 4', 'P4', 40.00, 'Unit', 'Category', 'Description', 'Image', 2);

INSERT INTO inventory (product_id, quantity, location, expiry_date) VALUES
(1, 50, 'Warehouse A', '2021-05-31'),
(2, 30, 'Warehouse B', '2023-05-31'),
(3, 20, 'Warehouse A', NULL),
(4, 40, 'Warehouse C', 2022-05-31);

INSERT INTO suppliers (supplier_name, supplier_address, supplier_phone, supplier_email) VALUES
('Supplier 1', 'Address 1', '1234567890', 'supplier@supply.me'),
('Supplier 2', 'Address 2', '0987654321', 'supplier2@supply.me');

INSERT INTO users (username, password, email, phone, address, role) VALUES
('admin', 'admin', 'admin', 'admin', 'admin', 'Administrator'),
('user', 'user', 'user', 'user', 'user', 'Employee');

>>>>>>> 6e96552e4d6a73943511cc511b210e97cf2fb5a5
