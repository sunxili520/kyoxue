USE `test`;

DROP TABLE IF EXISTS `t_test`;
-- 注意DEFAULT CHARSET utf8 COLLATE utf8_general_ci 是之前老版sql的写法。
-- mysql8使用DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_0900_ai_ci
CREATE TABLE `t_test` (
  `id` INT AUTO_INCREMENT  NOT NULL PRIMARY KEY COMMENT 'primary key',
  `createDatetime` DATETIME NULL COMMENT 'create time',
  `remark` VARCHAR(500) NULL  COMMENT 'remark',
  KEY(createDatetime)
 ) ENGINE=INNODB DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT='test table';
 
 USE `order`;

DROP TABLE IF EXISTS `t_order`;
-- 注意DEFAULT CHARSET utf8 COLLATE utf8_general_ci 是之前老版sql的写法。
-- mysql8使用DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_0900_ai_ci
CREATE TABLE `t_order` (
  `id` BIGINT auto_increment  not null primary key comment 'primary key',
  `createDatetime` datetime null comment 'create time',
  `orderNo` varchar(25) not null  comment 'order no',
  key(`orderNo`)
 ) ENGINE=innodb DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT='order table';