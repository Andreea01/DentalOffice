package com.dentaloffice.controller;

import com.dentaloffice.model.Doctor;
import com.dentaloffice.model.Specialty;
import com.dentaloffice.model.User;
import com.dentaloffice.service.DoctorService;
import com.dentaloffice.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/admin")
    public String adminPage(Model model) {

        Map<Doctor, Specialty> map = doctorService.findAllDoctorsWithTheirSpecialty();
        model.addAttribute("map", map);

        return "admin-page";
    }

    @GetMapping("/admin/addSpecialty")
    public String addSpecialty(Model model) {

        Specialty specialty = new Specialty();
        model.addAttribute("specialty", specialty);

        return "add-specialty";

    }

    @PostMapping("/admin/saveSpecialty")
    public String saveSpecialty(@ModelAttribute("specialty")Specialty specialty) {

        specialtyService.save(specialty);

        return "redirect:/admin";
    }

    @GetMapping("/admin/addDoctor")
    public String addDoctor(Model model) {

        Doctor doctor = new Doctor();
        List<Specialty> specialtyList = specialtyService.findAll();
        model.addAttribute("specialtyList", specialtyList);
        model.addAttribute("doctor", doctor);

        User newUser = new User();
        model.addAttribute("newUser", newUser);

        return "add-doctor";

    }

    @PostMapping("/admin/saveDoctor")
    public String saveDoctor(@ModelAttribute("doctor") Doctor doctor,
                             @ModelAttribute("specialties") List<Specialty> specialties,
                             @ModelAttribute("user") User newUser) {

        doctorService.saveDoctorWithSpecialties(doctor, specialties, newUser);

        return "redirect:/admin";
    }
}
