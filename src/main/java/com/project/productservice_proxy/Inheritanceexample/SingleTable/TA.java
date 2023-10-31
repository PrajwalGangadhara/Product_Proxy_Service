package com.project.productservice_proxy.Inheritanceexample.SingleTable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="SC_TA")
@DiscriminatorValue("1")
public class TA extends User {
    private double rating;
}
