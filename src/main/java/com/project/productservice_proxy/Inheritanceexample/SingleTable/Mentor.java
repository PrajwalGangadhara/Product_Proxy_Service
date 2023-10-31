package com.project.productservice_proxy.Inheritanceexample.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="SC_Mentor")
@DiscriminatorValue("2")
public class Mentor extends User {
    private int gradYear;
}
