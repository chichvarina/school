package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private Map<Long, Faculty> faculties = new HashMap<>();
    private long idCounter = 0;

    public Faculty create(Faculty faculty){
        idCounter++;
        faculty.setId(idCounter);
        faculties.put(idCounter, faculty);
        return faculty;
    }

    public Faculty read(long id){
        return faculties.get(id);
    }

    public Faculty update(Faculty faculty){
        if(faculties.containsKey(faculty.getId())) {
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }else {
            return null;
        }
    }

    public Faculty delete(long id){
        return faculties.remove(id);
    }

    public Collection<Faculty> readAll() {
        return faculties.values();
    }

    public Collection<Faculty> filterByColor(String color) {
        return faculties.values().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }

}
