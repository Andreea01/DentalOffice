package com.dentaloffice.service;

import com.dentaloffice.model.MedicalRecord;

import java.util.List;

public interface MedicalRecordsService {

    List<MedicalRecord> findAllRecordsByCNP(String cnp);

    MedicalRecord save(MedicalRecord medicalRecords);

    void deleteAllRecordsByCnp(String cnp);
}
