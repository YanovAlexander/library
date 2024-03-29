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

ALTER TABLE book
    RENAME countPages TO count_pages;

ALTER TABLE book
    RENAME publicationYear TO publication_year;

ALTER TABLE journal
    RENAME countPages TO count_pages;

ALTER TABLE journal
    RENAME publicationYear TO publication_year;

ALTER TABLE journal
    RENAME genre TO journal_type;

ALTER TABLE journal
    RENAME publication_year TO year;

ALTER TABLE book
    DROP COLUMN author;

CREATE TABLE author(
id serial primary key,
first_name varchar(250) not null,
last_name varchar(250) not null,
gender varchar(50) not null,
birth_date date not null
);

CREATE TABLE author_book (
  author_id serial NOT NULL,
  book_id serial NOT NULL,
  PRIMARY KEY (author_id,book_id),
  CONSTRAINT author_id_fk
   FOREIGN KEY (author_id) REFERENCES author (id),
  CONSTRAINT book_id_fk
   FOREIGN KEY (book_id) REFERENCES book (id)
);

DROP TABLE author_book;

ALTER TABLE book
ADD COLUMN author_id int;

ALTER TABLE book
ADD CONSTRAINT author_id_fk
   FOREIGN KEY (author_id) REFERENCES author (id);

CREATE TABLE users (
  id serial NOT NULL PRIMARY KEY,
  first_name varchar(250) not null,
  last_name varchar(250) not null,
  email varchar(250) not null,
  user_role varchar(50) not null,
  user_status varchar(50) not null,
  password varchar(250) not null
);

ALTER TABLE users ADD CONSTRAINT email_unique UNIQUE (email);

ALTER TABLE journal
RENAME COLUMN number TO journal_number;