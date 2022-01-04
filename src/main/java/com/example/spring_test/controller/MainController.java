package com.example.spring_test.controller;

import com.example.spring_test.model.IDidentify;
import com.example.spring_test.model.dao.SendEmail;
import com.example.spring_test.model.entity.hw2_info;
import com.example.spring_test.model.entity.hw4_email;
import com.example.spring_test.model.entity.hw5_id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    final
    SendEmail sendEmail;
    private final IDidentify ididentify;

    public MainController(SendEmail sendEmail, IDidentify ididentify) {

        this.sendEmail = sendEmail;
        this.ididentify = ididentify;
    }

    @GetMapping("/")
    public String index(){
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
    public String HW4(Model model) {
        model.addAttribute("mail", new hw4_email());
        return "hw4";
    }

    @PostMapping("/hw4")
    public String HW4(@ModelAttribute("mail") hw4_email mail) {
        sendEmail.sendMail(mail.getFrom(), mail.getEmail(), mail.getTitle(), mail.getContent());
        return "redirect:/hw4";
    }

    @GetMapping("/hw5")
    public String HW5() {
        return "hw5";
    }

    @PostMapping("/hw5")
    public String HW5(@ModelAttribute("hw5id") hw5_id hw5id) {
        ididentify.identify(hw5id.getId());
        return "redirect:/hw5";
    }

    @GetMapping("/chiasweb")
    public String chiasweb(){
        return "chiasweb";
    }

}
