-- 建立测试数据库
DROP DATABASE IF EXISTS test_db;
create database test_db DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;; 
use test_db;

-- ----------------------------
-- 建立测试表并插入数据: test_table
-- ----------------------------
DROP TABLE IF EXISTS `test_table`;  
CREATE TABLE `test_table` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `test_user_name` varchar(40) NOT NULL,  
  `test_password` varchar(255) NOT NULL,  
  `test_age` int(4) NOT NULL,  
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;  
  
/*Data for the table `test_table` */    
insert  into `test_table`(`test_user_name`,`test_password`,`test_age`) values ('ssm测试用户','123456',24);