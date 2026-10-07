package com.dentaloffice.service;

import com.dentaloffice.dao.PacientDao;
import com.dentaloffice.model.Pacient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PacientServiceImpl implements PacientService{

    @Autowired
    private PacientDao pacientDao;

    @Override
    @Transactional
    public List<Pacient> findAll() {
        return pacientDao.findAll();
    }

    @Override
    @Transactional
    public Pacient save(Pacient pacient) {
        return pacientDao.save(pacient);
    }

    @Override
    @Transactional
    public Optional<Pacient> findById(String cnp) {
       return pacientDao.findById(cnp);
    }

    @Override
    @Transactional
    public void deleteById(String cnp) {
        pacientDao.deleteById(cnp);
    }
}
