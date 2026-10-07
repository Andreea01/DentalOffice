package com.dentaloffice.service;

import com.dentaloffice.model.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment add(Appointment appointment);

    void delete(Appointment appointment);

    List<Appointment> viewAllAppointments();

}
