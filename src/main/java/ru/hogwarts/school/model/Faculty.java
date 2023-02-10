package ru.hogwarts.school.model;


import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Faculty {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String color;

    @OneToMany(mappedBy = "faculty")//faculty - это поле в классе Student
    private Collection<Student> students;

    public Faculty(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Faculty() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Collection<Student> getStudents() {
        return students;
    }


}
