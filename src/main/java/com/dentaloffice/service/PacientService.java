package com.dentaloffice.service;

import com.dentaloffice.model.Pacient;

import java.util.List;
import java.util.Optional;

public interface PacientService{

    List<Pacient> findAll();
    Pacient save(Pacient pacient);

    Optional<Pacient> findById(String cnp);

    void deleteById(String cnp);

}
