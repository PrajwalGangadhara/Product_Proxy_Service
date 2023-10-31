package com.project.productservice_proxy.Inheritanceexample.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="JT_Instructor")
@PrimaryKeyJoinColumn(name="User_Id")
public class Instructor extends User {
    private String company;
}
