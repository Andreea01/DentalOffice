package com.dentaloffice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "specialties")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_specialty")
    private int id;

    @Column(name = "specialty_name")
    private String specialtyName;

    @OneToMany(mappedBy = "specialty")
    private Set<CorespDoctorSpecialty> corespDoctorSpecialty =  new HashSet<>();

}
