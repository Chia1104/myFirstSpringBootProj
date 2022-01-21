package com.example.spring_test.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class SpringBootJPATest {

    @NotNull
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long C_ID;
    @Column(nullable = false, unique=true)
    private String C_Email;
    @Column(nullable = false)
    private String C_Name;
    @Column(nullable = false)
    private String C_Password;

    public long getC_ID() {
        return C_ID;
    }

    public void setC_ID(long c_ID) {
        C_ID = c_ID;
    }

    public String getC_Email() {
        return C_Email;
    }

    public void setC_Email(String c_Email) {
        C_Email = c_Email;
    }

    public String getC_Name() {
        return C_Name;
    }

    public void setC_Name(String c_Name) {
        C_Name = c_Name;
    }

    public String getC_Password() {
        return C_Password;
    }

    public void setC_Password(String c_Password) {
        C_Password = c_Password;
    }
}
