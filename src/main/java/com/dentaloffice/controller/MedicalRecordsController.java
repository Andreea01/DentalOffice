package com.dentaloffice.controller;

import com.dentaloffice.model.MedicalRecord;
import com.dentaloffice.model.Pacient;
import com.dentaloffice.service.MedicalRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class MedicalRecordsController {

    @Autowired
    MedicalRecordsService medicalRecordsService;

    /* example for path variable */
//    @GetMapping("/pacients/medicalRecords/{recordsForCnp}")
//    public String getMedicalRecords(Model model, @PathVariable(value = "recordsForCnp") String recordsForCnp) {
//
//        model.addAttribute("medicalRecords",
//                medicalRecordsService.findAllRecordsByCNP(recordsForCnp));
//        return "medical-records";
//    }

    @GetMapping("/pacients/medicalRecords")
    public String getMedicalRecords(Model model, @RequestParam String recordsForCnp,
                                    @RequestParam String firstName, @RequestParam String lastName ) {

        model.addAttribute("medicalRecords",
                medicalRecordsService.findAllRecordsByCNP(recordsForCnp));
        model.addAttribute("recordsForCnp", recordsForCnp);
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        return "medical-records";
    }

    @GetMapping("/pacients/medicalRecords/addRecord")
    public String addRecord(Model model, @RequestParam String recordsForCnp, @RequestParam String firstName,
                            @RequestParam String lastName) {

        MedicalRecord medicalRecord = new MedicalRecord();
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("medicalRecord", medicalRecord);
        model.addAttribute("recordsForCnp", recordsForCnp);
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);

        return "add-medical-record";

    }

//    @PostMapping("/pacients/medicalRecords/saveRecord")
//    public String saveRecord(@ModelAttribute("medicalRecord")MedicalRecords medicalRecord, Model model, @RequestParam String recordsForCnp) {
//
//        MedicalRecords medicalRecord = new MedicalRecords();
//        model.addAttribute("medicalRecord", medicalRecord);
//        model.addAttribute("recordsForCnp", recordsForCnp);
//
//        return "add-medical-record";
//
//    }

    @PostMapping("/pacients/medicalRecords/saveRecord/{medicalRecordsForCnp}")
    public String saveMedicalRecord(@ModelAttribute("medicalRecords") MedicalRecord medicalRecords,
                                    @PathVariable(value = "medicalRecordsForCnp") String medicalRecordForCnp) {
        Pacient pacient  = new Pacient();
        pacient.setCnp(medicalRecordForCnp);
        medicalRecords.setMedicalRecordPacient(pacient);
        medicalRecordsService.save(medicalRecords);

        return "redirect:/pacients";
    }


}
