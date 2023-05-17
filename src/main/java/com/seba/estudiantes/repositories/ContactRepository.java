package com.seba.estudiantes.repositories;

import com.seba.estudiantes.models.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findAll();
}
