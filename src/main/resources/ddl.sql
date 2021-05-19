create database library_go_it with owner postgres;

create table book (
id serial primary key,
name varchar(250) not null,
countPages int not null,
publicationYear int not null,
author varchar (250) not null,
description text,
genre varchar(250) not null);

create table journal (
id serial primary key,
name varchar(250) not null,
countPages int not null,
publicationYear int not null,
number int not null,
description text,
genre varchar(250) not null);
