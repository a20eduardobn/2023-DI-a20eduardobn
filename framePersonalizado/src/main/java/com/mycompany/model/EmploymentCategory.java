package com.mycompany.model;


public enum EmploymentCategory{
    EMPLOYED("Employed"), SELFEMPLOYED("Self Employed"), UNEMPLOYED("Unemployed"), OTHER("Other");

    private final String name;

    EmploymentCategory(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }
}
