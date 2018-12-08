# miaosha
springboot+mybatis框架的整合 实现一个查询功能

开发环境 jdk1.8 + tomcat 8.x + mysql + maven3.5.3 +idea 2018.2.2


sql脚本 

CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `gender` tinyint(4) NOT NULL DEFAULT '0',
  `age` int(11) NOT NULL,
  `telphone` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `register_mode` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT ' ',
  `third_party_id` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT ' ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE `user_password` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `encrpt_password` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


