package com.example.Restdemo.datalayer.entities.trans;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class Child implements Comparable<Child> , Serializable {

    @ApiModelProperty(notes = "Name of the Child",name="name",required=true,value="test name")
    private String name ;

    @ApiModelProperty(notes = "Birthdate of the Child",name="birthdate",required=true)
    private Date birthdate;

    @ApiModelProperty(notes = "Parent of the Child",name="parent",required=true)
    private Parent parent;

    public Child() {

    }

    public Child(String name, Date birthdate, Parent parent) {
        this.name = name;
        this.birthdate = birthdate;
        this.parent = parent;
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

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
    @Override
    public int compareTo(Child child) {
        return  this.birthdate.compareTo(child.birthdate);
    }
}
