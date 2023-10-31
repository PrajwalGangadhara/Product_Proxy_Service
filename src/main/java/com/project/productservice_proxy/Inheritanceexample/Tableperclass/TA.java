package com.project.productservice_proxy.Inheritanceexample.Tableperclass;

import jakarta.persistence.Entity;

@Entity(name="TPC_TA")
public class TA extends User{
    private double rating;
}
