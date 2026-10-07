package com.dentaloffice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "account_type")
    private int accountType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id_doctor")
    private Doctor doctor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pacient_id", referencedColumnName = "cnp")
    private Pacient pacient;
}
