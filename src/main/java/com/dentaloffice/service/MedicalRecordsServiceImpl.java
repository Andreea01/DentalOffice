package com.dentaloffice.service;

import com.dentaloffice.dao.MedicalRecordsDao;
import com.dentaloffice.model.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicalRecordsServiceImpl implements MedicalRecordsService{

    @Autowired
    MedicalRecordsDao medicalRecordsDao;

    @Override
    public List<MedicalRecord> findAllRecordsByCNP(String cnp) {

        return medicalRecordsDao.findAllByCnp(cnp);
    }
    @Override
    public MedicalRecord save(MedicalRecord medicalRecords){
        return medicalRecordsDao.save(medicalRecords);
    }

    @Override
    @Transactional
    public void deleteAllRecordsByCnp(String cnp) {
      medicalRecordsDao.deleteAllByCnp(cnp);
    }
}
