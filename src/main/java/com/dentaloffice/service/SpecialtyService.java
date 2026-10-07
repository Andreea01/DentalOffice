package com.dentaloffice.service;

import com.dentaloffice.model.Doctor;
import com.dentaloffice.model.Specialty;

import java.util.List;

public interface SpecialtyService {

    List<Specialty> findAll();

    Specialty save(Specialty specialty);
}
