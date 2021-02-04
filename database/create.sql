CREATE DATABASE MobileShop;
USE MobileShop;

CREATE TABLE account (
	id int primary key auto_increment,
    username varchar(20) unique not null,
    password varchar(20) not null,
    name varchar(20) not null,
    email varchar(30) unique not null,
    phone varchar(15) not null,
    address varchar(255) not null,
    avatar varchar(255) not null,
    role int not null default 0
);

CREATE TABLE category (
	id int primary key auto_increment,
	category varchar(20) unique not null
);

CREATE TABLE product (
	id int primary key auto_increment,
    idcategory int not null,
	name varchar(20) unique not null,
    description text not null,
    thumbnail varchar(255) not null,
    code varchar(50) unique not null,
    price decimal(19, 1) not null,
    stock int not null
);

/* 
CREATE TABLE orders (
	id int primary key auto_increment,
    idaccount int not null,
    idproduct int not null
);

CREATE TABLE orders_detail (
	id int primary key auto_increment,
    idorders int not null,
    name_customer varchar(20) not null, 
    name_product varchar(20) not null,
    quantity int not null,
    code varchar(50) not null,
	price decimal(19, 2) not null
);
*/

ALTER TABLE product
ADD CONSTRAINT FK_ProductCategory
FOREIGN KEY (idcategory) REFERENCES category(id);