/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelPassenger;
import Model.ModelTicket;
import View.FormTicket;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author mayra
 */
public class Controller {
    private ModelPassenger modelPassenger;
    private ModelTicket modelTicket;
    private FormTicket formTicket;
    
    public void setModelPassenger(ModelPassenger modelPassenger) {
        this.modelPassenger = modelPassenger;
    }

    public void setModelTicket(ModelTicket modelTicket) {
        this.modelTicket = modelTicket;
    }

    public void setFormTicket(FormTicket formTicket) {
        this.formTicket = formTicket;
    }

    public double getTotalAmount(int typeTicket, String from, String to, int adults, int children){
        double ticketAmount = 0;
        if (typeTicket == 2){
            ticketAmount = getTicketPriceAdults(from,to)*(double)adults + getTicketPriceChildren(from,to)*(double)children;
        }else if(typeTicket == 1){
            ticketAmount = (getTicketPriceAdults(from,to)*(double)adults + getTicketPriceChildren(from,to)*(double)children) + (getTicketPriceAdults(to,from)*(double)adults + getTicketPriceChildren(to,from)*(double)children);
        }
        return ticketAmount;
    }

    private double getTicketPriceAdults(String from, String to) {
        double ticketPrice = modelTicket.getTicketPriceAdults(from,to);
        return ticketPrice;         
    }

    private double getTicketPriceChildren(String from, String to) {
        double ticketPrice = modelTicket.getTicketPriceChildren(from,to);
        return ticketPrice;
    }
    
    public ArrayList getCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        ArrayList<Integer> currentDate = new ArrayList<>();
        currentDate.add(calendar.get(Calendar.DATE));
        currentDate.add(calendar.get(Calendar.MONTH)+1);
        currentDate.add(calendar.get(Calendar.YEAR));
        currentDate.add(calendar.get(Calendar.HOUR_OF_DAY));
        if(calendar.get(Calendar.MINUTE)%10 <= 5){
            currentDate.add(((calendar.get(Calendar.MINUTE)/10)*10)+5);
        }else{
            currentDate.add((((calendar.get(Calendar.MINUTE)/10)+1)*10));
            
        }
        return currentDate;
    } 

    public boolean createPassenger(String name, String lastName, String contact, String eMail, String typeId, String id, String gender) {
        if(name.isEmpty()||lastName.isEmpty()||contact.isEmpty()||eMail.isEmpty()||typeId.isEmpty()||id.isEmpty()||gender.isEmpty()){
            return false;
        }
        return modelPassenger.createPassenger(name,lastName,contact,eMail,typeId,id,gender);
    }
    
    public boolean createPassenger(String name, String lastName, String typeId, String id, String gender) {
        if(name.isEmpty()||lastName.isEmpty()||typeId.isEmpty()||id.isEmpty()||gender.isEmpty()){
            return false;
        }
        return modelPassenger.createPassenger(name,lastName,typeId,id,gender);
    }

    public boolean createTicket(boolean isAdult,int typeTicket, String from, String to, int dayDeparture, int monthDeparture, int yearDeparture, int hourDeparture, int minuteDeparture, int dayReturn, int monthReturn, int yearReturn, int hourReturn, int minuteReturn) {
        String dateDeparture,dateReturn;
        dateDeparture = dayDeparture+"/"+monthDeparture+"/"+yearDeparture+" - "+"Hora: "+hourDeparture+":"+minuteDeparture;
        dateReturn = +dayReturn+"/"+monthReturn+"/"+yearReturn+" - "+"Hora: "+hourReturn+":"+minuteReturn;
        return modelTicket.createTicket(isAdult,typeTicket,from,to,dateDeparture,dateReturn,modelPassenger.getPassenger());
    }

    public String getPrintedTicket(int typeTicket) {
        return modelTicket.getPrintedTicket(typeTicket); 
    }
}
