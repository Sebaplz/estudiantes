package com.seba.estudiantes.services;

import com.seba.estudiantes.models.Contact;
import com.seba.estudiantes.models.Dormitory;
import com.seba.estudiantes.models.Student;
import com.seba.estudiantes.repositories.ContactRepository;
import com.seba.estudiantes.repositories.DormitoryRepo;
import com.seba.estudiantes.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService {

    private final StudentRepository studentRepository;
    private final ContactRepository contactRepository;
    private final DormitoryRepo dormitoryRepo;

    public ApiService(StudentRepository studentRepository, ContactRepository contactRepository, DormitoryRepo dormitoryRepo) {
        this.studentRepository = studentRepository;
        this.contactRepository = contactRepository;
        this.dormitoryRepo = dormitoryRepo;
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

    public List<Student> obtenerNoContact(){
        return studentRepository.findByNoContact();
    }

    public List<Student> obtenerNoDormitory(){
        return studentRepository.findByNoDormitory();
    }

    public void updateStudent(Student student, Dormitory dormitory){
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if (optionalStudent.isPresent()){
            Student existingStudent = optionalStudent.get();
            existingStudent.setDormitory(dormitory);
            studentRepository.save(existingStudent);
        }else {
            // El estudiante no existe en la base de datos, manejar el caso según tus requisitos
            throw new IllegalArgumentException("No se encontró el estudiante con ID: " + student.getId());
        }
    }

    public Contact createContact( Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> allContact() {
        return contactRepository.findAll();
    }



    public Dormitory createDormitory(Dormitory dormitory){
        return dormitoryRepo.save(dormitory);
    }

    public List<Dormitory> allDormitories(){
        return dormitoryRepo.findAll();
    }

    public Dormitory findDormitory(Long id){
        Optional<Dormitory> optionalDormitory = dormitoryRepo.findById(id);
        return optionalDormitory.orElse(null);
    }
}
