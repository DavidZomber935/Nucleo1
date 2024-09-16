package com.nucleo1Ejercicio.gestionAcademica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("welcomeMessage", "Bienvenido al Sistema de Gestión Académica");
        return "home";
    }
}