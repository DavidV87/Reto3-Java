/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.*;
import Controller.Controller;
import Datafile.Database;
/**
 *
 * @author Elkin David Valencia
 */
public class ModelTicket {
    private Ticket ticket;
    private Controller controller;
    private Database myData;
    
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setDataBase(Database myData) {
        this.myData = myData;
    }

    public double getTicketPriceAdults(String from, String to) {
        String[][] ticketValue = myData.getTicketValue();
        for (String[] ticketValue1 : ticketValue) {
            if (ticketValue1[0].equals(from)) {
                if (ticketValue1[1].equals(to)) {
                    return Double.parseDouble(ticketValue1[2]);
                }
            }
        }
        return 0;
    }

    public double getTicketPriceChildren(String from, String to) {
        String[][] ticketValue = myData.getTicketValue();
        for (String[] ticketValue1 : ticketValue) {
            if (ticketValue1[0].equals(from)) {
                if (ticketValue1[1].equals(to)) {
                    return Double.parseDouble(ticketValue1[3]);
                }
            }
        }
        return 0;
    }

    public boolean createTicket(boolean isAdult,int typeTicket, String from, String to, String dateDeparture, String dateReturn,Passengers passenger) {
        if(typeTicket == 1){
            if(isAdult){
                ticket = new Ticket(from, to, typeTicket, dateDeparture, dateReturn, getTicketPriceAdults(from, to) , passenger);
            }
            else{
                ticket = new Ticket(from, to, typeTicket, dateDeparture, dateReturn, getTicketPriceChildren(from, to) , passenger);
                
            }
            return true;
        }else if(typeTicket == 2){
            if(isAdult){
                ticket = new Ticket(from, to, typeTicket, dateDeparture, dateReturn, getTicketPriceAdults(from, to) , passenger);
            }
            else{
                ticket = new Ticket(from, to, typeTicket, dateDeparture, dateReturn, getTicketPriceChildren(from, to) , passenger);
            }
            return true;
        }
        return false;
    }

    
    public String getPrintedTicket(int typeTicket) {
        String ticketInformation;
        myData.saveObjectTicket(ticket);
        ticketInformation = "Ticket Empresa de transporte\n"+
                            "------ INFORMACION TIQUETE DE IDA ------\n"+        
                            "Origen: "+ticket.getFrom()+"\n"+
                            "Destino: "+ticket.getTo()+"\n"+
                            "Fecha de salida: "+ticket.getDepartureDate()+"\n"+
                            "Valor trayecto: $"+ticket.getTicketPrice()+"\n";
        if (typeTicket==1){
            ticketInformation +="----- INFORMACION TIQUETE DE REGRESO ----\n"+        
                                "Origen: "+ticket.getTo()+"\n"+
                                "Destino: "+ticket.getFrom()+"\n"+
                                "Fecha de salida: "+ticket.getReturnDate()+"\n"+
                                "Valor trayecto: $"+ticket.getTicketPrice()+"\n";
        }    
        ticketInformation +="------- INFORMACION DEL PASAJERO -------\n"+
                            "Nombre: "+ticket.getPassenger().getName()+" "+ticket.getPassenger().getLastName()+"\n"+
                            "Identificacion: "+ticket.getPassenger().getTypeId()+" - "+ticket.getPassenger().getId()+"\n"+
                            "Genero: "+ticket.getPassenger().getGender()+"\n"+
                            "Contacto: "+ticket.getPassenger().getContact()+"\n"+
                            "E-mail: "+ticket.getPassenger().geteMail()+"\n"+
                            "GRACIAS POR UTLIZAR NUESTRO SERVICIO - BUEN VIAJE";
        return ticketInformation;
    }
}
