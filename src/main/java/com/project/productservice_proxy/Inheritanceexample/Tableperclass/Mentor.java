package com.project.productservice_proxy.Inheritanceexample.Tableperclass;

import jakarta.persistence.Entity;

@Entity(name="TPC_Mentor")
public class Mentor extends User{
    private int gradYear;
}
