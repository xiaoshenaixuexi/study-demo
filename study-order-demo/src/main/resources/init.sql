CREATE DATABASE /*!32312 IF NOT EXISTS*/`order_demo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `order_demo`;

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `order_code` varchar(128) NOT NULL,
                           `customer` varchar(256) NOT NULL,
                           `product_id` bigint NOT NULL,
                           `product_name` varchar(256) DEFAULT NULL,
                           `quantity` int NOT NULL,
                           `order_status` tinyint NOT NULL DEFAULT '0' COMMENT '0-待打包 1-待发货 2-已取消',
                           `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           `deleted` tinyint NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_order` */

/*Table structure for table `t_product` */

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `name` varchar(256) NOT NULL,
                             `quantity` int NOT NULL,
                             `price` decimal(10,2) NOT NULL,
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             `deleted` tinyint NOT NULL DEFAULT '0',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_product` */

insert  into `t_product`(`id`,`name`,`quantity`,`price`,`create_time`,`update_time`,`deleted`) values
    (1,'手机',20,198.88,'2025-05-12 17:38:19','2025-05-12 17:38:19',0);