package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public Faculty read(long id){
        return facultyRepository.findById(id).get();
    }

    public Faculty update(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public void delete(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> readAll() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> filterByColor(String color) {
        return facultyRepository.findAll().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }

}
