CREATE TABLE `spitter` (
  `spitter_id` bigint(20) NOT NULL auto_increment,
  `username` varchar(32) default NULL,
  `password` varchar(64) default NULL,
  `fullname` varchar(256) default NULL,
  PRIMARY KEY  (`spitter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
