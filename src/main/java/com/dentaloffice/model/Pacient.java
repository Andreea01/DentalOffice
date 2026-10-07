package com.dentaloffice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pacients")
public class Pacient {

    @Id
    @Column(name = "cnp")
    private String cnp;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "pacient")
    private Set<CorespDoctorPacient> corespDoctorPacient =  new HashSet<>();


}
