package com.dentaloffice.dao;

import com.dentaloffice.model.Pacient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface PacientDao
            extends CrudRepository<Pacient, String> {
        List<Pacient> findAll();

        Pacient save(Pacient pacient);

        Optional<Pacient> findById(String cnp);

        void deleteById(String cnp);



}

