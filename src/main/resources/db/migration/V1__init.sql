CREATE TABLE users (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  login varchar(100) NOT NULL,
  role varchar(50) NOT NULL,
  password varchar(50) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_username (login)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE news (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user_id bigint(20) NOT NULL,
  title varchar(100) NOT NULL,
  content varchar(255) NOT NULL,
  create_date timestamp(6) NOT NULL,
  pic_url varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;