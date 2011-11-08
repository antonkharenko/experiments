CREATE TABLE `spittle` (
  `spittle_id` bigint(20) NOT NULL auto_increment,
  `spitter_id` bigint(20) default NULL,
  `text` varchar(140) default NULL,
  `when` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`spittle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
