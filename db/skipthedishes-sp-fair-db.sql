/*
SQLyog Ultimate v9.50 
MySQL - 5.5.5-10.1.13-MariaDB : Database - mydb
*********************************************************************
*//*!40101 SET NAMES utf8 */;
/*!40101 SET SQL_MODE=''*/;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`skipthedishes-sp-fair` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `skipthedishes-sp-fair`;

/*Table structure for table `customer` */
DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `creation`  DATETIME DEFAULT CURRENT_TIMESTAMP,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */
insert  into `customer`(`id`, `email`, `name`, `address`, `password`) values (1, 'fredericocerqueiraalves@gmail.com', 'Fred', 'SP Street, 234', 'admin');

/*Table structure for table `store` */
DROP TABLE IF EXISTS `store`;

create table store (
    `id` int(64) NOT NULL AUTO_INCREMENT,
    `address` varchar(200),
    `name` varchar(100),
    primary key (id)
)

insert  into `store` (`id`, `name`, `address`) values (1, 'Store 01', 'Address 01 Test');

/* Table structure for table `product` */
DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT null,
  `store_id` int(64)  DEFAULT null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `product` */
insert  into `product` (`id`, `name`, `description`, `price`, `store_id`) values (1, 'Product 01', 'Product 01 Test', 12.60, 1);

/* Table structure for table `order` */
DROP TABLE IF EXISTS `orders`;

create table orders (
     `id` int(64) NOT NULL AUTO_INCREMENT,
    `lastUpdate` datetime,
    `creation`  DATETIME,
    `deliveryAddress` varchar(200) not null,
    `contact` varchar(100),
    `status` varchar(100) not null,
    `customer_id` int(64) null,
    `store_id` int(64) not null,
    primary key (id)
);

insert  into `orders` (`id`, `deliveryAddress`, `contact`, `status`, `customer_id`, `store_id`) values (1, 'Street Test 01', 'fred', 'OK', 1, 1);

/* Table structure for table `order_item` */
DROP TABLE IF EXISTS `order_item`;

create table order_items (
    `id` int(64) NOT NULL AUTO_INCREMENT,
    `quantity` decimal(19,2),
    `price` decimal(19,2),
    `product_id` int(64) not null,
    `order_id` int(64) not null,
    primary key (id)
);

/*Data for the table `product` */
insert  into `order_items` (`id`, `quantity`, `price`, `product_id`, `order_id`) values (1, '10', '20.30', 1, 1);

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */
insert  into `hibernate_sequence`(`next_val`) values (1);
