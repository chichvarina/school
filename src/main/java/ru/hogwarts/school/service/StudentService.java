package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student student){
        return studentRepository.save(student);
    }

    public Student read(long id){
        return studentRepository.findById(id).get();
    }

    public Student update(Student student){
        return studentRepository.save(student);
    }

    public void delete(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> readAll() {
        return studentRepository.findAll();
    }

    public Collection<Student> filterByAge(int age) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getAge()==age)
                .collect(Collectors.toList());
    }

    public Collection<Student> findByAgeBetween(int min, int max ) {
        return studentRepository.findByAgeBetween(min, max);
    }

}
