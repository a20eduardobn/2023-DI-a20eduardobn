/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import java.util.EventObject;

/**
 *
 * @author a20eduardobn
 */
public class FormEvent extends EventObject {

    private String name;
    private String occupation;
    private int idIdade;
    private String employmentStatus;
    private String gendervalue;
    private String message;
    private String taxId;
    private boolean isUs;

    public FormEvent(Object source, String name, String occupation, int idIdade, String employmentStatus, String gendervalue, String taxId, boolean isUs) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.idIdade = idIdade;
        this.employmentStatus = employmentStatus;
        this.gendervalue = gendervalue;
        this.taxId = taxId;
        this.isUs = isUs;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public int getIdIdade() {
        return idIdade;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public String getGendervalue() {
        return gendervalue;
    }

    public String getTaxId() {
        return taxId;
    }

    public boolean isUs() {
        return isUs;
    }

    public String getText() {
        if (message==null) {
            return name + " : " + occupation + " : " + idIdade + " : " + employmentStatus + " : " + taxId + " : " + isUs + " : " + gendervalue+'\n';
        } else {
            return message+'\n';
        }
    }
}
