package com.project.productservice_proxy.Inheritanceexample.MappedSuperclass;

import jakarta.persistence.Entity;

@Entity(name="MSC_Mentor")
public class Mentor extends User {
    private int gradYear;
}
