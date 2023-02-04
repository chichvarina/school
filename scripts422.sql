/*
 Описание структуры: у каждого человека есть машина.
 Причем несколько человек могут пользоваться одной машиной.
 У каждого человека есть имя, возраст и признак того,
 что у него есть права (или их нет).
 У каждой машины есть марка, модель и стоимость.
 Также не забудьте добавить таблицам первичные ключи и связать их.
 */

 create table car (
   id integer primary key,
   brand text not null default '',
   model text not null default '',
   price integer not null default 0
 );

create table man (
    id integer primary key,
    name text not null default '',
    age integer not null default 20,
    driver_license boolean not null default false,
    id_auto integer,
    CONSTRAINT fk_car FOREIGN KEY(id_auto) REFERENCES car(id)
);

