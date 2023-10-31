package com.project.productservice_proxy.Inheritanceexample.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="JT_Mentor")
@PrimaryKeyJoinColumn(name="User_Id")
public class Mentor extends User {
    private int gradYear;
}
