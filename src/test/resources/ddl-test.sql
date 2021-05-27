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

ALTER TABLE book ALTER COLUMN countPages
    RENAME TO count_pages;

ALTER TABLE book ALTER COLUMN  publicationYear
      RENAME TO publication_year;

ALTER TABLE journal ALTER COLUMN countPages
    RENAME  TO count_pages;

ALTER TABLE journal ALTER COLUMN publicationYear
    RENAME TO publication_year;