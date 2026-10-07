package com.dentaloffice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @Column(name = "id_doctor")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "doctor")
    private Set<CorespDoctorSpecialty> corespDoctorSpecialty =  new HashSet<>();

    @OneToMany(mappedBy = "doctor")
    private Set<CorespDoctorPacient> corespDoctorPacient =  new HashSet<>();

}
