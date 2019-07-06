CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) NOT NULL,
  `passWord` varchar(50) NOT NULL,
  `realName` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
---------------------
作者：海岛拾贝
来源：CSDN
原文：https://blog.csdn.net/iku5200/article/details/82856621
版权声明：本文为博主原创文章，转载请附上博文链接！