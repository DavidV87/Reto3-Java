/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.Passengers;
import Controller.Controller;
/**
 *
 * @author Elkin David Valencia
 */
public class ModelPassenger {
    private Passengers passenger;
    private Controller controller;
    
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public boolean createPassenger(String name, String lastName, String contact, String eMail, String typeId, String id, String gender) {
        try{
            passenger = new Passengers(name, lastName, contact, eMail, typeId, id, gender);
            return true;
        }catch(Exception e){
            System.out.println("Is not creating the passenger object");
        }
        return false;
    }
    
    public boolean createPassenger(String name, String lastName,  String typeId, String id, String gender) {
        try{
            passenger = new Passengers(name, lastName, typeId, id, gender);
            return true;
        }catch(Exception e){
            System.out.println("Is not creating the passenger object");
        }
        return false;
    }
    /**
     * @return the passenger
     */
    public Passengers getPassenger() {
        return passenger;
    }
   

    
    
}
