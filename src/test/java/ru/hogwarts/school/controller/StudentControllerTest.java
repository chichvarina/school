package ru.hogwarts.school.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.model.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }


    @Test
    public void getStudentTest() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/1", String.class))
                .contains("\"id\":1");
    }

    @Test
    public void filterByAgeTest() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/filter/%7Bage%7D?age=33", String.class))
                .contains("\"age\":33");
    }

    @Test
    public void findByAgeBetweenTest() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/?min=22&max=33", String.class))
                .contains("\"age\":22");
    }

    @Test
    public void createStudentTest() throws Exception {
        Student student = new Student(0L, "Иванов", 25);
        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
                .isNotNull();
    }

}
