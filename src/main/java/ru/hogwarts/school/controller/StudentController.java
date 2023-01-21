package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RequestMapping("student")
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> read(@PathVariable Long id){
        Student student = studentService.read(id);
        if(student==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(student);
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> findByAgeBetween(
            @RequestParam(required = false) Integer min,
            @RequestParam(required = false) Integer max
    ){
        if(min != null && max !=null){
            return ResponseEntity.ok(studentService.findByAgeBetween(min, max));

        }else if(min != null && max == null){
            return ResponseEntity.ok(studentService.findByAgeBetween(min, Integer.MAX_VALUE));

        }else if(min == null && max != null){
            return ResponseEntity.ok(studentService.findByAgeBetween(0, max));
        }else{
            return ResponseEntity.ok(studentService.readAll());
        }
    }



    @GetMapping("/faculty/{studentId}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long studentId){
        //получить факультет студента
        return ResponseEntity.ok(studentService.read(studentId).getFaculty());
    }




    @GetMapping("/filter/{age}")
    public ResponseEntity<Collection<Student>> filterByAge(@PathVariable Integer age){
        return ResponseEntity.ok(studentService.filterByAge(age));
    }


    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student){
        Student updateStudent = studentService.update(student);
        if(updateStudent==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(updateStudent);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

}
