package com.dentaloffice.controller;

import com.dentaloffice.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    String login() {
        return "login-page";
    }


    @GetMapping("/process-login")
    String processLogin(@AuthenticationPrincipal CustomUserDetails user) {

        if(user.getUser().getAccountType() == 1) {
            return "redirect:/admin";
        }
        else {
            //I am a doctor
            if(user.getUser().getAccountType() == 2) {
                return "redirect:/pacients";
            }else
                return "redirect:/myPacientAccount";}
    }

}
