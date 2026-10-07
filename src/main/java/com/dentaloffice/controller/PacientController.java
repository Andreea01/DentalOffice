package com.dentaloffice.controller;

import com.dentaloffice.model.Pacient;
import com.dentaloffice.model.User;
import com.dentaloffice.service.MedicalRecordsService;
import com.dentaloffice.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class PacientController {

    @Autowired
    private PacientService pacientService;

    @Autowired
    private MedicalRecordsService medicalRecordsService;

    @GetMapping("/pacients")
    public String getPacients(Model model) {

        model.addAttribute("pacients", pacientService.findAll());
        return "list-pacients";
    }

    @GetMapping("/pacients/add")
    public String addPacient(Model model) {

        Pacient pacient = new Pacient();
        model.addAttribute("pacient", pacient);

        return "add-pacient";

    }

    @PostMapping("/pacients/save")
    public String savePacient(@ModelAttribute("pacient")Pacient pacient) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        user.getId();

        pacientService.save(pacient);

        return "redirect:/pacients";
    }

    @GetMapping("/pacients/delete/{cnpToBeDeleted}")
    public String deletePacient(@PathVariable(value = "cnpToBeDeleted") String cnpToBeDeleted) {

        medicalRecordsService.deleteAllRecordsByCnp(cnpToBeDeleted);
        pacientService.deleteById(cnpToBeDeleted);

        return "redirect:/pacients";
    }

    @GetMapping("/pacients/update/{cnpToBeUpdated}")
    public String updatePacient(Model model, @PathVariable(value = "cnpToBeUpdated") String cnpToBeUpdated) {

        Optional<Pacient> pacient = pacientService.findById(cnpToBeUpdated);
        model.addAttribute("pacient", pacient);

        return "update-pacient";

    }

    @PostMapping("/pacients/update")
    public String updateAndSavePacient(@ModelAttribute("pacient")Pacient pacient) {

        pacientService.save(pacient);

        return "redirect:/pacients";
    }

    @GetMapping("/pacients/search")
    public String searchPacient(Model model, @RequestParam String pacientCnp) {

        pacientService.findById(pacientCnp)
                .ifPresent(o -> model.addAttribute("pacients", o));

        return "list-pacients";

    }
}
