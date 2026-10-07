package com.dentaloffice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DoctorWithSpecialties {
    private Doctor doctor;
    private List<Specialty> specialties;
    private User user;
}
