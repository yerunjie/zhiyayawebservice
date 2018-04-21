CREATE TABLE `monitor_data` (
  `id`          INT(11)  NOT NULL AUTO_INCREMENT,
  `device_id`   INT      NOT NULL,
  `weight`      DOUBLE   NOT NULL,
  `intensity`   INT(11)  NOT NULL,
  `moisture`    INT(11)  NOT NULL,
  `temp`        FLOAT    NOT NULL,
  `create_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `device_id_index` (`device_id`) USING BTREE
);