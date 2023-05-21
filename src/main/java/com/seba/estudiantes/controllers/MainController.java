package com.seba.estudiantes.controllers;

import com.seba.estudiantes.models.Contact;
import com.seba.estudiantes.models.Student;
import com.seba.estudiantes.services.ApiService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    private final ApiService apiService;

    public MainController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String index(Model model) {
        List<Student> allStudents = apiService.allStudents();
        model.addAttribute("allStudents", allStudents);
        model.addAttribute("allDormitories", apiService.allDormitories());
        return "index.jsp";
    }

    @GetMapping("/students/new")
    public String newStudent(@ModelAttribute("student") Student student) {
        return "newStudent.jsp";
    }

    @PostMapping("/students/new")
    public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "newStudent.jsp";
        } else {
            apiService.createStudent(student);
            return "redirect:/";
        }
    }

    @GetMapping("/contact/new")
    public String newContact(@ModelAttribute("contact") Contact contact, Model model) {
        List<Student> students = apiService.obtenerNoContact();
        model.addAttribute("students", students);
        return "newContact.jsp";
    }

    @PostMapping("/contact/new")
    public String createContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result){
        if (result.hasErrors()) {
            return "newContact.jsp";
        } else {
            apiService.createContact(contact);
            return "redirect:/";
        }
    }


}
