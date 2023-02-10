package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(int min, int max);
    Collection<Student> findByAge(int age);

    //Возможность получить количество всех студентов в школе. Эндпоинт должен вернуть число.
    @Query(value = "select count(*) from student", nativeQuery = true)
    int countAllStudets();

    //Возможность получить средний возраст студентов. Эндпоинт должен вернуть число.
    @Query(value = "select avg(age) from student", nativeQuery = true)
    float countAverageAge();

    //Возможность получать только пять последних студентов.
    // Последние студенты считаются теми, у кого идентификатор больше других.
    @Query(value = "select * from student order by id desc limit 5", nativeQuery = true)
    List<Student> getLastFive();


}
