package com.dentaloffice.service;

import com.dentaloffice.dao.SpecialtyDao;
import com.dentaloffice.model.Doctor;
import com.dentaloffice.model.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{

    @Autowired
    SpecialtyDao specialtyDao;

    @Override
    public List<Specialty> findAll() {
        return specialtyDao.findAll();
    }

    @Transactional
    public Specialty save(Specialty specialty){
        return specialtyDao.save(specialty);
    }
}
