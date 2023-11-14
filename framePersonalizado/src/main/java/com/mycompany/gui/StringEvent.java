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
public class StringEvent extends EventObject {

    private String name;
    private String occupation;
    private int idIdade;
    private String employmentStatus;
    private String gendervalue;
    private String message;
    private String taxId;
    private boolean isUs;

    public StringEvent(Object source, String name, String occupation, int idIdade, String employmentStatus, String gendervalue, String taxId, boolean isUs) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.idIdade = idIdade;
        this.employmentStatus = employmentStatus;
        this.gendervalue = gendervalue;
        this.taxId = taxId;
        this.isUs = isUs;
    }

    public StringEvent(Object source) {
        super(source);
    }

    public StringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getIdIdade() {
        return idIdade;
    }

    public void setIdIdade(int idIdade) {
        this.idIdade = idIdade;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getGendervalue() {
        return gendervalue;
    }

    public void setGendervalue(String gendervalue) {
        this.gendervalue = gendervalue;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public boolean isUs() {
        return isUs;
    }

    public void setUs(boolean us) {
        isUs = us;
    }

    public String getText() {
        if (message==null) {
            return name + " : " + occupation + " : " + idIdade + " : " + employmentStatus + " : " + taxId + " : " + isUs + " : " + gendervalue+'\n';
        } else {
            return message+'\n';
        }
    }
}
