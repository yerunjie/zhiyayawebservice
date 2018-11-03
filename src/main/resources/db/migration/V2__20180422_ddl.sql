DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id`            int(11)      NOT NULL AUTO_INCREMENT,
  `phone`         varchar(20)  NOT NULL,
  `email`         varchar(255) NOT NULL,
  `nick_name`     varchar(40)  NOT NULL,
  `password`      varchar(255) NOT NULL,
  `real_name`     varchar(255) NOT NULL,
  `register_time` datetime(0)  NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
