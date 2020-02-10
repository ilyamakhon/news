CREATE TABLE users (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  login varchar(100) NOT NULL,
  role varchar(50) NOT NULL,
  password varchar(50) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_username (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;