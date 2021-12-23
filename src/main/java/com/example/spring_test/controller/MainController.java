package com.example.spring_test.controller;


import com.example.spring_test.model.hw4_email;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {
    private final JavaMailSender mailSender;

    public MainController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

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
    public String HW2(){
        return "hw2";
    }

    @GetMapping("/hw3")
    public String HW3(){
        return "hw3";
    }

    @GetMapping("/hw4")
    public String HW4(Model model) {
        model.addAttribute("mail", new hw4_email());
        return "hw4";
    }

    @PostMapping("/hw4")
    public String HW4(@ModelAttribute("mail") hw4_email mail) {
//        m.sendMail(mail.getEmail(), mail.getTitle(), mail.getContent());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("b0744113@cgu.edu.tw");
        message.setTo(mail.getEmail());
        message.setSubject(mail.getTitle());
        message.setText(mail.getContent());
        mailSender.send(message);

        System.out.println("E-mail: " + mail.getEmail());
        System.out.println("Title: " + mail.getTitle());
        System.out.println("Content: " + mail.getContent());
        return "redirect:/hw4";
    }

    @GetMapping("/chiasweb")
    public String chiasweb(){
        return "chiasweb";
    }

}
