/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datafile;

import Classes.Ticket;
import Model.ModelTicket;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Elkin David Valencia
 */
public class Database {
    private FileOutputStream fileOutTickets;
    private ObjectOutputStream myWriter;
    private FileInputStream fileInTickets;
    private ObjectInputStream myReader;
    private ModelTicket modelTicket;
    private ArrayList<Object> tickets = new ArrayList<>();
    private final String[][] ticketValue ={{"Cali","Manizales","50000","40000"},
                             {"Cali","Bogota","90000","70000"},
                             {"Bogota","Cali","90000","70000"},
                             {"Bogota","Manizales","80000","70000"},
                             {"Manizales","Bogota","80000","70000"},
                             {"Manizales","Cali","50000","40000"}};

        
    public String[][] getTicketValue() {
        return ticketValue;
    }

    public void saveObjectTicket(Ticket ticket) {
        try {
            fileInTickets = new FileInputStream("file_tickets.dat");
            myReader = new ObjectInputStream(fileInTickets);
            this.tickets = (ArrayList<Object>) myReader.readObject();
            myReader.close();
        }catch (IOException | ClassNotFoundException e) {
             System.out.println("File not found");
        }
        this.tickets.add(ticket);
        try {
            fileOutTickets = new FileOutputStream("file_tickets.dat");
            myWriter = new ObjectOutputStream(fileOutTickets);
            myWriter.writeObject(this.tickets);
            myWriter.close();
            }catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    /**
     * @param modelTicket the modelTicket to set
     */
    public void setModelTicket(ModelTicket modelTicket) {
        this.modelTicket = modelTicket;
    }
    
   
    
}
