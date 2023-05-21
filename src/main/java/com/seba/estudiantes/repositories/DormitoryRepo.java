package com.seba.estudiantes.repositories;

import com.seba.estudiantes.models.Dormitory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DormitoryRepo extends CrudRepository<Dormitory, Long> {
    List<Dormitory> findAll();
}
