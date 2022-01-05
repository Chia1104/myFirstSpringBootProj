package com.example.spring_test.controller;

import com.example.spring_test.repository.IDidentify;
import com.example.spring_test.service.SendEmail;
import com.example.spring_test.model.entity.hw2_info;
import com.example.spring_test.model.entity.hw4_email;
import com.example.spring_test.model.entity.hw5_id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class MainController {
    final
    SendEmail sendEmail;

    public MainController(SendEmail sendEmail) {

        this.sendEmail = sendEmail;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("today", new Date());
        model.addAttribute("welcome", "This is Spring Boot and Tomcat Homework");
        return "index";
    }

    @GetMapping("/hw1")
    public String HW1() {
        return "hw1";
    }

    @GetMapping("/hw2")
    public String HW2(Model model){
        hw2_info info = new hw2_info();
        model.addAttribute("info", info);
        return "hw2";
    }

    @PostMapping("/hw2_details")
    public String hw2Details(@ModelAttribute("info") hw2_info info) {
        return "hw2_details";
    }

    @GetMapping("/hw3")
    public String HW3(){
        return "hw3";
    }

    @PostMapping("/hw3_details")
    public String hw3Details() {
        return "hw3_details";
    }

    @GetMapping("/hw4")
    public String SHOWHW4(Model model) {
        model.addAttribute("mail", new hw4_email());
        return "hw4";
    }

    @PostMapping("/hw4")
    public String SENDHW4(@ModelAttribute("mail") @Valid hw4_email mail, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "hw4";
        }
        sendEmail.sendMail(mail.getFrom(), mail.getEmail(), mail.getTitle(), mail.getContent());
        return "redirect:/hw4";
    }

    @GetMapping("/hw5")
    public String SHOWHW5(Model model) {
        model.addAttribute("hw5id", new hw5_id());
        return "hw5";
    }

    @PostMapping("/hw5")
    public String CHECKHW5(@ModelAttribute("hw5id") @Valid hw5_id hw5id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "hw5";
        }
        return "redirect:/chiasweb";
    }

    @GetMapping("/chiasweb")
    public String chiasweb(){
        return "chiasweb";
    }

}
