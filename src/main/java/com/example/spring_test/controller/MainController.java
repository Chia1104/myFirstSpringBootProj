package com.example.spring_test.controller;

import com.example.spring_test.model.dao.HW3DataDAO;
import com.example.spring_test.model.dao.SendEmail;
import com.example.spring_test.model.entity.hw2_info;
import com.example.spring_test.model.entity.hw4_email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    SendEmail sendEmail;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

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

    @GetMapping("/chiasweb")
    public String chiasweb(){
        return "chiasweb";
    }

}
