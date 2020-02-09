create table if not exists Humans (
  id identity,
  name varchar(250) not null,
  surname varchar(250) not null,
  gender varchar(10) not null,
  country varchar(250),
);