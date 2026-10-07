package com.dentaloffice.dao;

import com.dentaloffice.model.Doctor;

import com.dentaloffice.model.Specialty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorDao extends CrudRepository<Doctor, String> {

    List<Doctor> findAll();

    Doctor save(Doctor pacient);

 //   void deleteByName(String firstName, String lastName);

    @Query(value = "SELECT sp FROM Specialty sp WHERE sp.id = (SELECT coresp.specialty.id " +
            "FROM CorespDoctorSpecialty coresp WHERE coresp.doctor.id = :doctorId)")
    Specialty getSpecialtyByDoctor(@Param("doctorId")int doctorId);

}
