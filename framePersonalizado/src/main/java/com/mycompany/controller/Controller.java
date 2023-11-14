package com.mycompany.controller;

import com.mycompany.gui.StringEvent;
import com.mycompany.model.*;

public class Controller {
    private Database db = new Database();

    public void addPerson(StringEvent ev){
        String name = ev.getName();
        String occupation = ev.getOccupation();
        String genderCat = ev.getGendervalue();
        int ageCatId = ev.getIdIdade();
        String empCat = ev.getEmploymentStatus();
        AgeCategory ageCategory = null;
        switch (ageCatId){
            case 0:
                ageCategory = AgeCategory.CHILD;
                break;
            case 1:
                ageCategory = AgeCategory.ADULT;
            case 2:
                ageCategory = AgeCategory.SENIOR;
        }

        EmploymentCategory empCategory;
        if (empCat.equals("employed")){
            empCategory = EmploymentCategory.EMPLOYED;
        } else if (empCat.equals("self-employed")){
            empCategory = EmploymentCategory.SELFEMPLOYED;
        } else if (empCat.equals("unemployed")) {
            empCategory = EmploymentCategory.UNEMPLOYED;
        } else {
            empCategory = EmploymentCategory.OTHER;
        }

        Gender gender;
        if (ev.getGendervalue().equals("male")){
            gender=Gender.MALE;
        } else {
            gender=Gender.FEMALE;
        }

        Person person = new Person(name, occupation, ageCategory, empCategory, ev.getTaxId(), ev.isUs(), gender);
        System.out.println(person);
    }
}
