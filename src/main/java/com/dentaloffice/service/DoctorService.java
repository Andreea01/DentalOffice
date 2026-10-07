package com.dentaloffice.service;

import com.dentaloffice.model.Doctor;
import com.dentaloffice.model.Specialty;
import com.dentaloffice.model.User;

import java.util.List;
import java.util.Map;

public interface DoctorService {

    List<Doctor> findAll();

    Doctor save(Doctor doctor);

    void saveDoctorWithSpecialties(Doctor doctor, List<Specialty> specialties, User newUser);

    Map<Doctor, Specialty> findAllDoctorsWithTheirSpecialty();
}
