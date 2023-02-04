/*
Возраст студента не может быть меньше 16 лет.
Пара “значение названия” - “цвет факультета” должна быть уникальной.
При создании студента без возраста ему автоматически
должно присваиваться 20 лет.
*/

create table student1
(
    name text not null unique,
    age integer not null default 20 check (age > 15)
);

create table faculty1
(
    name text not null,
    color text not null,
    CONSTRAINT name_color_unique UNIQUE(name, color)
);



