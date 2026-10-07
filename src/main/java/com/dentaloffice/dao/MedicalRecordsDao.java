package com.dentaloffice.dao;

import com.dentaloffice.model.MedicalRecord;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicalRecordsDao extends CrudRepository<MedicalRecord, String> {

    @Query(value = "SELECT med FROM MedicalRecord med WHERE med.medicalRecordPacient.cnp = :cnp")
    List<MedicalRecord> findAllByCnp(
            @Param("cnp") String cnp);
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM MedicalRecord med WHERE med.medicalRecordPacient.cnp = :cnp")
    void deleteAllByCnp(@Param("cnp") String cnp);

}
