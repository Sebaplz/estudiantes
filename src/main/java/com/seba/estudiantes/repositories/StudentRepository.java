package com.seba.estudiantes.repositories;

import com.seba.estudiantes.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAll();

    @Query(value="SELECT s.* FROM students s LEFT OUTER JOIN contacts c ON s.id = c.student_id WHERE c.id IS NULL;", nativeQuery = true)
    List<Student> findByNoContact();

    @Query(value="SELECT s.* FROM students s LEFT OUTER JOIN dormitory d ON s.dormitory_id = d.id WHERE d.id IS NULL;", nativeQuery = true)
    List<Student> findByNoDormitory();
    //Trae todos los usuarios que no tengan asignado un dormitorio
}
