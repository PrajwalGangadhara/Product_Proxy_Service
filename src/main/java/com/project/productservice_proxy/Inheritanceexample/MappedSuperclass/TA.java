package com.project.productservice_proxy.Inheritanceexample.MappedSuperclass;

import jakarta.persistence.Entity;

@Entity(name="MSC_TA")
public class TA extends User {
    private double rating;
}
