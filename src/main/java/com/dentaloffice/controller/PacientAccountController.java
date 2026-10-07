package com.dentaloffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacientAccountController {

    @GetMapping("/myPacientAccount")
    public String getPacients(Model model) {

        return "my-pacient-account";
    }
}
