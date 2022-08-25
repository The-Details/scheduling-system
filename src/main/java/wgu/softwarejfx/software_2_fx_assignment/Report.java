package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static wgu.softwarejfx.software_2_fx_assignment.Contacts.*;

public class Report {

    int contactId;
    String contactName;
    String contactEmail;
    int appointmentCount;
    ObservableList<Integer> associatedAppointments;

    public static ObservableList<Report> newContactReportData = FXCollections.observableArrayList();

    public Report(int contactId, String contactName, String contactEmail, int appointmentCount, ObservableList<Integer> associatedAppointments){
        this.contactId = contactId;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.appointmentCount = appointmentCount;
        this.associatedAppointments = associatedAppointments;
    }



    public static ObservableList<Report> generateReportData(){

        for(Contacts contactCage : allContacts){
            if(!newContactReportData.contains(new Report(contactCage.contactId,
                    contactCage.contactName, contactCage.email,
                    findAssociatedAppointments(contactCage).size(), findAssociatedAppointments(contactCage)))){

                newContactReportData.add(new Report(contactCage.contactId,
                        contactCage.contactName, contactCage.email,
                        findAssociatedAppointments(contactCage).size(), findAssociatedAppointments(contactCage)));
            }
        }

        return newContactReportData;
    }



    public void setContactId(int id){
        this.contactId = id;
    }

    public void setContactName(String name){
        this.contactName = name;
    }

    public void setContactEmail(String email){
        this.contactEmail = email;
    }

    public int getContactId(){
        return contactId;
    }

    public String getContactName(){
        return contactName;
    }

    public String getContactEmail(){
        return contactEmail;
    }

    public void setAppointmentCount(int appointmentCount){
        this.appointmentCount = appointmentCount;
    }

    public void setAssociatedAppointments(ObservableList<Integer> associatedAppointments){
        this.associatedAppointments = associatedAppointments;
    }
    public int getAppointmentCount(){
        return appointmentCount;
    }

    public ObservableList<Integer> getAssociatedAppointments(){
        return associatedAppointments;
    }


}
