package com.project.productservice_proxy.Inheritanceexample.Tableperclass;

import jakarta.persistence.Entity;

@Entity(name="TPC_Instructor")
public class Instructor extends User{
    private String company;
}
