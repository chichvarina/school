package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RequestMapping("/faculty")
@RestController
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty create(@RequestBody Faculty faculty){
        return facultyService.create(faculty);
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> read(@PathVariable Long id){
        Faculty faculty = facultyService.read(id);
        if(faculty==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(faculty);
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> findByNameOrColor(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color
    ){
        if((name==null || name.isBlank()) && (color==null || color.isBlank())){
            return ResponseEntity.ok(facultyService.readAll());
        }else {
            return ResponseEntity.ok(facultyService.findByNameOrColor(name, color));
        }
    }


    @GetMapping("/students/{facultyId}")
    public ResponseEntity<Collection<Student>> getStudents(@PathVariable Long facultyId){
        //Получить студентов факультета
        return ResponseEntity.ok(facultyService.read(facultyId).getStudents());
    }


    @GetMapping("/filter/{color}")
    public ResponseEntity<Collection<Faculty>> filterByColor(@PathVariable String color){
        return ResponseEntity.ok(facultyService.filterByColor(color));
    }

    @PutMapping
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty){
        Faculty updateFaculty = facultyService.update(faculty);
        if(updateFaculty==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(updateFaculty);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        facultyService.delete(id);
        return ResponseEntity.ok().build();
    }

}
