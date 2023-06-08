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
    image_data VARCHAR(255),
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
    shipment_id int primary key auto_increment not null,
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

INSERT INTO `suppliers` (`supplier_id`, `supplier_name`, `supplier_address`, `supplier_phone`, `supplier_email`, `manager_name`) VALUES
(1, 'Apple Inc.', 'AMERICA', ' (800) 692–7753.', 'domain@apple.com', 'Apple'),
(2, 'Google', 'UNITED KINGDOM', '(020) 444-555', 'domain@google.com', 'Google');

INSERT INTO `users` (`user_id`, `username`, `password`, `fname`, `lname`, `email`, `phone`, `address`, `role`, `company_id`, `image_Data`) VALUES
(1, 'admin', 'admin', NULL, NULL, 'admin', 'admin', 'admin', 'Administrator', 1, NULL),
(2, 'Biruk_M', '12345', 'Biruk', 'Mesfin', 'birukmesfin@apple.com', '(800) 643-7542', 'AMERICA', 'Manager', 1, NULL),
(3, 'Bisry', '12345', 'Bisrat', 'Kebere', 'bisry@apple.com', '(020) 443-542', 'UNITED KINGDOM', 'Manager', 2, NULL);


INSERT INTO `categories` (`category_id`, `category_name`) VALUES
(3, 'Accessories'),
(2, 'Laptop and Wearables'),
(1, 'Phones'),
(4, 'Tablets and Audio Devices');


INSERT INTO `products` (`product_id`, `name`, `code`, `price`, `unit`, `category_id`, `description`, `image`, `supplier_id`) VALUES
(1, 'Apple iPhone Pro Max 12', 'I12', '1000.00', '$', 1, 'This is the all new iPhone 12 Pro Max with many new interesting features, Buy now and save yourself a discount of 20%.', 'lib/product.png', 1),
(2, 'Apple MacBook Pro ', 'MPO', '2000.00', '$', 2, 'MacBook, the best laptop any one could ever ask for with high efficiency and horse power no other laptop has ever equipped, Buy now and get a start up.', 'lib/product.png', 1),
(3, 'A Magic Keyboard Folio', 'P3', '250.00', '$', 3, 'A Magic Keyboard Folio for your iPad, make your life even more easier with typing and getting what you desire with clicks of a keyboard, or shall I say magical keyboard.', 'lib/product.png', 1),
(4, 'HomePod - Midnight', 'HPM', '300.00', '$', 4, 'Have at it with your Home Pod, quality audio, clear voice, voice cancellation, upgraded sound frequencies, and more.', 'lib/product.png', 1),
(5, 'Google Pixels', 'GP', '1100.00', '$', 1, 'The ultimate creation, Google Pixels to get to the top, with their high quality camera clearness, small amount size occupied and more.', 'lib/product.png', 2),
(6, 'Google Smart Watch', 'SW', '750.00', '$', 2, 'Your are running, maybe you are relaxing or waiting for planned alarm or just for fun, try our smart watches to add calendar and play as you like with the connection from your phone.', 'lib/product.png', 2),
(7, 'Google Virtual Reality Models', 'VR', '1000.00', '$', 3, 'In the world filled with your dreams and imagination but unable to come to life, Buy VR to not let them know we can still.', 'lib/product.png', 2),
(8, 'Google Android 13 Tablet', '13T', '1200.00', '$', 4, 'The newly improved android 13 tablet that lets you control all activities with one making you connect everywhere digitally and accessing all your accessories in one device, YOUR TABLET. ', 'lib/product.png', 2);

INSERT INTO `inventory` (`inventory_id`, `product_id`, `quantity`, `location`, `date_added`, `expiry_date`, `owner_id`, `info`) VALUES
(1, 1, 100, 'UNITED KINGDOM', '2023-06-07', '2021-01-01', 1, 'This is the all new iPhone 12 Pro Max with many new interesting features, Buy now and save yourself a discount of 20%.'),
(2, 2, 100, 'UNITED KINGDOM', '2023-06-07', '2021-02-02', 1, 'MacBook, the best laptop any one could ever ask for with high efficiency and horse power no other laptop has ever equipped, Buy now and get a start up.'),
(3, 3, 100, 'UNITED KINGDOM', '2023-06-07', '2021-03-03', 1, 'A Magic Keyboard Folio for your iPad, make your life even more easier with typing and getting what you desire with clicks of a keyboard, or shall I say magical keyboard.'),
(4, 4, 100, 'UNITED KINGDOM', '2023-06-07', '2021-04-04', 1, 'Have at it with your Home Pod, quality audio, clear voice, voice cancellation, upgraded sound frequencies, and more.'),
(5, 5, 100, 'AMERICA', '2023-06-07', '2021-05-05', 2, 'The ultimate creation, Google Pixels to get to the top, with their high quality camera clearness, small amount size occupied and more.'),
(6, 6, 100, 'AMERICA', '2023-06-07', '2021-06-06', 2, 'Your are running, maybe you are relaxing or waiting for planned alarm or just for fun, try our smart watches to add calendar and play as you like with the connection from your phone.'),
(7, 7, 100, 'AMERICA', '2023-06-07', '2021-07-07', 2, 'In the world filled with your dreams and imagination but unable to come to life, Buy VR to not let them know we can still.'),
(8, 8, 100, 'AMERICA', '2023-06-07', '2021-08-08', 2, 'The newly improved android 13 tablet that lets you control all activities with one making you connect everywhere digitally and accessing all your accessories in one device, YOUR TABLET. ');


INSERT INTO `orders` (`order_id`, `user_id`, `company_id`, `product_id`, `order_quantity`, `order_status`, `order_date`, `note`) VALUES
(1, 2, 1, 1, 10, 'Waiting', '2023-06-07', 'Provide It Very Soon Please'),
(2, 2, 1, 2, 20, 'Accepted', '2023-06-07', 'Provide It Very Soon Please'),
(3, 2, 1, 3, 30, 'Declined', '2023-06-07', 'Provide It Very Soon Please'),
(4, 2, 1, 4, 40, 'Waiting', '2023-06-07', 'Provide It Very Soon Please'),
(5, 2, 2, 5, 50, 'Accepted', '2023-06-07', 'Provide It Very Soon Please'),
(6, 2, 2, 6, 60, 'Accepted', '2023-06-07', 'Provide It Very Soon Please'),
(7, 2, 2, 7, 70, 'Waiting', '2023-06-07', 'Provide It Very Soon Please'),
(8, 2, 2, 8, 80, 'Declined', '2023-06-07', 'Provide It Very Soon Please');


