package ru.hogwarts.school.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private Map<Long, Student> students = new HashMap<>();
    private long idCounter = 0;

    public Student create(Student student){
        idCounter++;
        student.setId(idCounter);
        students.put(idCounter, student);
        return student;
    }

    public Student read(long id){
        return students.get(id);
    }

    public Student update(Student student){
        if(students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }else {
            return null;
        }
    }

    public Student delete(long id){
        return students.remove(id);
    }

    public Collection<Student> readAll() {
        return students.values();
    }

    public Collection<Student> filterByAge(int age) {
        return students.values().stream().filter(student -> student.getAge()==age).collect(Collectors.toList());
    }
}
