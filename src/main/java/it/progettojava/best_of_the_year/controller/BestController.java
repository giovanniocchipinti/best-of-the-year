package it.progettojava.best_of_the_year.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping
public class BestController {
    @GetMapping("/")
    public String BestController(@RequestParam(required = false) String nome,
                                Model home) {
        nome = "Giovanni Occhipinti";
        home.addAttribute("nome", nome);
        
        return "home";
    }
    
}
