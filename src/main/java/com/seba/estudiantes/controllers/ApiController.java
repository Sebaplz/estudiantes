package com.seba.estudiantes.controllers;

import com.seba.estudiantes.models.Contact;
import com.seba.estudiantes.models.Student;
import com.seba.estudiantes.services.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/students/create")
    public Student newStudent(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName,
                              @RequestParam(value = "age") Integer age) {
        Student student = new Student(firstName, lastName, age);
        return apiService.createStudent(student);
    }

    @PostMapping("/contacts/create")
    public Contact newContact(@RequestParam(value = "student") Long id, @RequestParam(value = "address") String address,
                              @RequestParam(value = "city") String city, @RequestParam(value = "state") String state) {
        Student student = apiService.findStudent(id);
        Contact contact = new Contact(address, city, state, student);
        return apiService.createContact(contact);
    }
}
