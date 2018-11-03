CREATE TABLE `monitor_data` (
  `id`          int(11)     NOT NULL AUTO_INCREMENT,
  `device_id`   int(11)     NOT NULL,
  `fertility`   int(11)     NOT NULL,
  `air`         int(11)     NOT NULL,
  `intensity`   int(11)     NOT NULL,
  `moisture`    int(11)     NOT NULL,
  `touch`       int(11)     NOT NULL,
  `temp`        float       NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `device_id_index`(`device_id`) USING BTREE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;