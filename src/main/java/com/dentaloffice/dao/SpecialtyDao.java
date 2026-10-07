package com.dentaloffice.dao;

import com.dentaloffice.model.Doctor;
import com.dentaloffice.model.Specialty;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecialtyDao extends CrudRepository<Specialty, String> {

    List<Specialty> findAll();

    Specialty save(Specialty specialty);
}
