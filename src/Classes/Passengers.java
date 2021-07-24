/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author Elkin David Valencia
 */
public class Passengers implements Serializable{
    private String name;
    private String lastName;
    private String contact;
    private String eMail;
    private String typeId;
    private String id;
    private String gender;
   
    public Passengers(String name, String lastName, String typeId, String id, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.typeId = typeId;
        this.id = id;
        this.gender = gender;
    }

    public Passengers(String name, String lastName, String contact, String eMail, String typeId, String id, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.contact = contact;
        this.eMail = eMail;
        this.typeId = typeId;
        this.id = id;
        this.gender = gender;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }
    /**
     * @return the eMail
     */
    public String geteMail() {
        return eMail;
    }
    /**
     * @return the typeId
     */
    public String getTypeId() {
        return typeId;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }
}
