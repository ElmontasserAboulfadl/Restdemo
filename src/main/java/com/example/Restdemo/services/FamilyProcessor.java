package com.example.Restdemo.services;

import com.example.Restdemo.datalayer.entities.trans.Child;
import com.example.Restdemo.datalayer.entities.trans.Parent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FamilyProcessor {

    private static List<Parent> parentList= new ArrayList<>();
    private static List<Child> childrenList= new ArrayList<>();

    public FamilyProcessor() {
    }

    public Optional<Parent> getParent(String name) {
        return this.parentList.stream().filter(x -> x.getName().equals(name)).findAny();
    }
    public void createParent(Parent parent) {
        this.parentList.add(parent);
    }

    public void createChild(Child child) {
        this.childrenList.add(child);
    }
    public Optional<Child> getChild(String name) {
        return this.childrenList.stream().filter(x -> x.getName().equals(name)).findAny();
    }

    public List<Child> getChildren() {
        return this.childrenList;
    }

}
