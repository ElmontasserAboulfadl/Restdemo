package com.example.Restdemo.datalayer.entities.trans;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class Parent implements Comparator<Parent> , Serializable {

    @ApiModelProperty(notes = "Name of the Parent",name="name",required=true,value="test name")
    private String name;
    @ApiModelProperty(notes = "Birthdate of the Parent",name="birthdate",required=true)
    private Date birthdate;

    public Parent() {
    }

    public Parent(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public int compare(Parent parent, Parent t1) {
        return parent.getBirthdate().compareTo(t1.getBirthdate());
    }
}
