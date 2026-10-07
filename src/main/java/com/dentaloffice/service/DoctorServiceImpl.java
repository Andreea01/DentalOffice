package com.dentaloffice.service;

import com.dentaloffice.dao.CorespDoctorSpecialtyDao;
import com.dentaloffice.dao.DoctorDao;
import com.dentaloffice.dao.UserDao;
import com.dentaloffice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private CorespDoctorSpecialtyDao corespDoctorSpecialtyDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private EmailService emailService;
    @Autowired
    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public List<Doctor> findAll() {
        return doctorDao.findAll();
    }

    @Override
    @Transactional
    public Doctor save(Doctor doctor){
        return  doctorDao.save(doctor);
    }

    @Transactional
    public void saveDoctorWithSpecialties(Doctor doctor,  List<Specialty> specialties, User newUser){
        doctorDao.save(doctor);

        for(Specialty specialty : specialties) {
            CorespDoctorSpecialty corespDoctorSpecialty = new CorespDoctorSpecialty();
            corespDoctorSpecialty.setDoctor(doctor);
            corespDoctorSpecialty.setSpecialty(specialty);
            corespDoctorSpecialtyDao.save(corespDoctorSpecialty);
        }

        EmailDetails emailDetails = new EmailDetails(newUser.getUsername(), "Contul dumneavoastra a fost " +
                "activat cu parola " + newUser.getPassword(), "Cont activat", null);
        emailService.sendSimpleMail(emailDetails);

        newUser.setAccountType(2);
        newUser.setDoctor(doctor);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userDao.save(newUser);

    }

    @Override
    public Map<Doctor, Specialty> findAllDoctorsWithTheirSpecialty() {
        Map<Doctor, Specialty> map = new HashMap<>();

        List<Doctor> allDoctors = findAll();

        for(Doctor doctor :  allDoctors){
            Specialty specialty = doctorDao.getSpecialtyByDoctor(doctor.getId());
            map.put(doctor, specialty);
        }

        return map;
    }

}
