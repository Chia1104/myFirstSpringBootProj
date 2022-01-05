package com.example.spring_test.model.entity;

import com.example.spring_test.validation.annotation.HW5Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class hw5_id {

    @NotEmpty(message = "ID不可空白")
    @Size(min=10, max=10, message = "ID長度不對")
    @HW5Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
