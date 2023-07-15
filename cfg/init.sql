CREATE database bookmgr;
use bookmgr;
CREATE TABLE user(
  id INT PRIMARY KEY,
  name CHAR(64) NOT NULL,
  password CHAR(64),
  age INT,
  sex INT,
  email VARCHAR(128),
  role INT
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE book(
  id INT PRIMARY KEY,
  name VARCHAR(256) NOT NULL,
  author VARCHAR(256) NOT NULL,
  press VARCHAR(256) NOT NULL,
  public_time BIGINT(20) NOT NULL,
  category VARCHAR(612) DEFAULT "unknow",
  site VARCHAR(612) DEFAULT "unknow",
  reserve INT DEFAULT 0
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE borrow_record(
  id INT PRIMARY KEY,
  user_id INT NOT NULL,
  book_id INT NOT NULL,
  begin_time BIGINT(20) NOT NULL,
  borrow_time BIGINT(20) NOT NULL,
  return_time BIGINT(20),
  count INT NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table book modify column id int(11) NOT NULL AUTO_INCREMENT;
alter table borrow_record modify column id int(11) NOT NULL AUTO_INCREMENT;
alter table user modify column id int(11) NOT NULL AUTO_INCREMENT;
alter table user modify column role INT DEFAULT 2;
alter table user add adress char(64) DEFAULT "学校";
alter table book add rate INT(2) DEFAULT 0;
alter table book modify column rate DECIMAL(4,2) DEFAULT 0.00;