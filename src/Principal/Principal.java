/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Controller.Controller;
import Datafile.Database;
import Model.ModelPassenger;
import Model.ModelTicket;
import View.FormTicket;

/**
 *
 * @author Elkin David Valencia
 */
public class Principal {
    private static Controller controller;
    private static ModelPassenger modelPassenger; 
    private static ModelTicket modelTicket;
    private static FormTicket formTicket;
    private static Database myData;

    public static void main(String[] args) {
        controller = new Controller();
        modelPassenger = new ModelPassenger();
        modelTicket = new ModelTicket();
        formTicket = new FormTicket();
        myData = new Database();
        modelPassenger.setController(controller);
        modelTicket.setController(controller);
        formTicket.setController(controller);
        controller.setModelPassenger(modelPassenger);
        controller.setModelTicket(modelTicket);
        controller.setFormTicket(formTicket);
        modelTicket.setDataBase(myData);
        myData.setModelTicket(modelTicket);
        formTicket.setVisible(true);
    }
}
