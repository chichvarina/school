/*
Возраст студента не может быть меньше 16 лет.
Пара “значение названия” - “цвет факультета” должна быть уникальной.
При создании студента без возраста ему автоматически
должно присваиваться 20 лет.
*/

ALTER TABLE student add constraint check_age check (age >= 16);

ALTER TABLE faculty add constraint name_color_unique UNIQUE(name, color);

ALTER TABLE student alter column age set default 20;

