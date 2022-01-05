package com.example.spring_test.model.entity;

import com.example.spring_test.validation.annotation.EmailC;

import javax.validation.constraints.NotEmpty;

public class hw4_email {
    @NotEmpty(message = "From不可空白")
    @EmailC
    private String from;
    @NotEmpty(message = "To不可空白")
    @EmailC
    private String email;
    @NotEmpty(message = "Title不可空白")
    private String title;
    @NotEmpty(message = "Content不可空白")
    private String content;
    private String date;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
