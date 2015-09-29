drop table if exists user;
create table user (
id bigint unsigned not null auto_increment,
email varchar(60) not null,
password varchar(32) not null,
firstname varchar(40) null,
lastname varchar(40) null,
birthdate date null,
primary key (id),
unique (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user (email, password) values ('email1@demo.com','kjhgkjbkmkj');

