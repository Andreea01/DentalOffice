package com.dentaloffice.dao;

import com.dentaloffice.model.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentDao extends CrudRepository<Appointment, String> {

}
