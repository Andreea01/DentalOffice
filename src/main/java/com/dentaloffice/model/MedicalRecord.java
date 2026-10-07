package com.dentaloffice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "medical_records")
public class MedicalRecord {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "pacient_cnp", referencedColumnName = "cnp")
    private Pacient medicalRecordPacient;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "treatment")
    private String treatment;

}
