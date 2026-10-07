package com.dentaloffice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "coresp_doctor_pacient")
public class CorespDoctorPacient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "cnp_pacient")
    private Pacient pacient;
}
