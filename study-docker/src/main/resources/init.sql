CREATE DATABASE `order_demo` ;
USE `order_demo`;

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
                           `id` BIGINT NOT NULL AUTO_INCREMENT,
                           `order_code` VARCHAR(128) NOT NULL,
                           `customer` VARCHAR(256) NOT NULL,
                           `product_id` BIGINT NOT NULL,
                           `product_name` VARCHAR(256) DEFAULT NULL,
                           `quantity` INT NOT NULL,
                           `order_status` TINYINT NOT NULL DEFAULT '0' COMMENT '0-待打包 1-待发货 2-已取消',
                           `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           `deleted` TINYINT NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
                             `id` BIGINT NOT NULL AUTO_INCREMENT,
                             `name` VARCHAR(256) NOT NULL,
                             `quantity` INT NOT NULL,
                             `price` DECIMAL(10,2) NOT NULL,
                             `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             `deleted` TINYINT NOT NULL DEFAULT '0',
                             PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `t_product` */

INSERT  INTO `t_product`(`id`,`name`,`quantity`,`price`,`create_time`,`update_time`,`deleted`) VALUES
    (1,'手机',20,198.88,'2025-05-12 17:38:19','2025-05-12 17:38:19',0);