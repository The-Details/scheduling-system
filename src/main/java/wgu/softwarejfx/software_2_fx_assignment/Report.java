package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

import static wgu.softwarejfx.software_2_fx_assignment.Appointments.lookupAppointmentByContactId;
import static wgu.softwarejfx.software_2_fx_assignment.Appointments.lookupAppointmentById;
import static wgu.softwarejfx.software_2_fx_assignment.Contacts.*;

public class Report {

    int contactId;
    String contactName;
    String contactEmail;
    String title;
    String description;
    String type;
    LocalDateTime start;
    LocalDateTime end;
    int customerId;
    int appointmentCount;
    ObservableList<Integer> associatedAppointments;

    public static ObservableList<Report> newContactReportData = FXCollections.observableArrayList();

    public Report(int contactId, String contactName, String contactEmail, String title, String description, String type, LocalDateTime start,
                  LocalDateTime end, int customerId, int appointmentCount, ObservableList<Integer> associatedAppointments){
        this.contactId = contactId;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.title = title;
        this.description = description;
        this.type = type;
        this.start = start;
        this.end = end;
        this.customerId = customerId;
        this.appointmentCount = appointmentCount;
        this.associatedAppointments = associatedAppointments;
    }



    public static ObservableList<Report> generateReportData(){

        for(Contacts contactCage : allContacts){
            if(!newContactReportData.contains(new Report(contactCage.contactId,
                    contactCage.contactName, contactCage.email, lookupAppointmentByContactId(contactCage.contactId).title
                    , lookupAppointmentByContactId(contactCage.contactId).description,
                    lookupAppointmentByContactId(contactCage.contactId).type, lookupAppointmentByContactId(contactCage.contactId).start,
                    lookupAppointmentByContactId(contactCage.contactId).end, lookupAppointmentByContactId(contactCage.contactId).customerId,
                    findAssociatedAppointments(contactCage).size(), findAssociatedAppointments(contactCage)))){

                newContactReportData.add(new Report(contactCage.contactId,
                        contactCage.contactName, contactCage.email,lookupAppointmentByContactId(contactCage.contactId).title
                        , lookupAppointmentByContactId(contactCage.contactId).description,
                        lookupAppointmentByContactId(contactCage.contactId).type, lookupAppointmentByContactId(contactCage.contactId).start,
                        lookupAppointmentByContactId(contactCage.contactId).end, lookupAppointmentByContactId(contactCage.contactId).customerId,
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
