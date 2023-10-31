package com.project.productservice_proxy.Inheritanceexample.MappedSuperclass;

import jakarta.persistence.Entity;

@Entity(name="MSC_Instructor")
public class Instructor extends User {
    private String company;
}
