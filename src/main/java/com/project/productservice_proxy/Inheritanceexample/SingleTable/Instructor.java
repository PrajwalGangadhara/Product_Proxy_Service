package com.project.productservice_proxy.Inheritanceexample.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="SC_Instructor")
@DiscriminatorValue("3")
public class Instructor extends User {
    private String company;
}
