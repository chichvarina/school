/*
 Составить первый JOIN-запрос,
 чтобы получить информацию обо всех студентах
 (достаточно получить только имя и возраст студента)
 школы Хогвартс вместе с названиями факультетов.

Составить второй JOIN-запрос,
 чтобы получить только тех студентов, у которых есть аватарки.
 */

select student.name, student.age, faculty.name
from student INNER JOIN faculty on student.faculty_id = faculty.id;

select student.name, student.age
from avatar INNER JOIN student on avatar.student_id = student.id;



