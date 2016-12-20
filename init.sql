drop database if exists springJpaExample;
create database springJpaExample;
use springJpaExample;
create table user (id INT PRIMARY KEY AUTO_INCREMENT, first_name text NOT NULL, last_name text NOT NULL);
