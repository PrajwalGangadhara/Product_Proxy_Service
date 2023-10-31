package com.project.productservice_proxy.Inheritanceexample.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="JT_TA")
@PrimaryKeyJoinColumn(name="User_Id")
public class TA extends User {
    private double rating;
}
