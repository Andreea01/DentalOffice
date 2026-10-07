package com.dentaloffice.dao;

import com.dentaloffice.model.CorespDoctorSpecialty;
import org.springframework.data.repository.CrudRepository;

public interface CorespDoctorSpecialtyDao  extends CrudRepository<CorespDoctorSpecialty, String> {

     CorespDoctorSpecialty save(CorespDoctorSpecialty corespDoctorSpecialty);
}
