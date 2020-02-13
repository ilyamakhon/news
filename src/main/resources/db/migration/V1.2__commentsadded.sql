CREATE TABLE comments(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    user_id bigint(20) NOT NULL,
    comment_content varchar(255) NOT NULLб
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8