package com.seba.estudiantes.services;

import com.seba.estudiantes.models.Contact;
import com.seba.estudiantes.models.Student;
import com.seba.estudiantes.repositories.ContactRepository;
import com.seba.estudiantes.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService {

    private final StudentRepository studentRepository;
    private final ContactRepository contactRepository;

    public ApiService(StudentRepository studentRepository, ContactRepository contactRepository) {
        this.studentRepository = studentRepository;
        this.contactRepository = contactRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    public Contact createContact( Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> allContact() {
        return contactRepository.findAll();
    }

    public List<Student> obtenerNoContact(){
        return studentRepository.findByNoContact();
    }
}
