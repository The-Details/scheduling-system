package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

public class Appointments {

    int appointmentId;
    String title;
    String description;
    String location;
    String type;
    LocalDateTime start;
    LocalDateTime end;
    LocalDateTime createDate;
    String createdBy;
    LocalDateTime last_update;
    String lastUpdateBy;
    int customerId;
    int userId;
    int contactId;


    public static ObservableList<Appointments> allAppointments = FXCollections.observableArrayList();

    ObservableList<Appointments> januaryAppointments = FXCollections.observableArrayList();
    ObservableList<Appointments> februaryAppointments = FXCollections.observableArrayList();
    ObservableList<Appointments> marchAppointments = FXCollections.observableArrayList();
    ObservableList<Appointments> aprilAppointments = FXCollections.observableArrayList();
    ObservableList<Appointments> mayAppointments = FXCollections.observableArrayList();
    ObservableList<Appointments> juneAppointments = FXCollections.observableArrayList();
    ObservableList<Appointments> julyAppointments = FXCollections.observableArrayList();
    ObservableList<Appointments> augustAppointments = FXCollections.observableArrayList();
    ObservableList<Appointments> septemberAppointments = FXCollections.observableArrayList();
    ObservableList<Appointments> octoberAppointments = FXCollections.observableArrayList();
    ObservableList<Appointments> novemberAppointments = FXCollections.observableArrayList();
    ObservableList<Appointments> decemberAppointments = FXCollections.observableArrayList();



    public Appointments(int appointmentId, String title, String description, String location, String type, LocalDateTime start,
                        LocalDateTime end, LocalDateTime createDate, String createdBy, LocalDateTime last_update,
                        String lastUpdateBy, int customerId, int userId, int contactId){
        this.appointmentId = appointmentId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.start = start;
        this.end = end;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.last_update = last_update;
        this.lastUpdateBy = lastUpdateBy;
        this.customerId = customerId;
        this.userId = userId;
        this.contactId = contactId;
    }

    public void addAppointment(Appointments newAppointment){
        allAppointments.add(newAppointment);
    }

    public void updateAppointment(int appointmentId, Appointments selectedAppointment){
        for(Appointments screener : allAppointments){
            if(screener.getAppointmentId() == appointmentId){
                screener.setTitle(selectedAppointment.getTitle());
                screener.setDescription(selectedAppointment.getDescription());
                screener.setLocation(selectedAppointment.getLocation());
                screener.setType(selectedAppointment.getType());
                screener.setStart(selectedAppointment.getStart());
                screener.setEnd(selectedAppointment.getEnd());
                screener.setCreateDate(selectedAppointment.getCreateDate());
                screener.setCreatedBy(selectedAppointment.getCreatedBy());
                screener.setLast_update(selectedAppointment.getLast_update());
                screener.setLastUpdateBy(selectedAppointment.getLastUpdateBy());
            }
        }
    }

    public void deleteAppointment(Appointments selectedAppointment){
        allAppointments.remove(selectedAppointment);
    }

    public ObservableList<Appointments> lookupAppointmentByCustomerId(int customerId){
        ObservableList<Appointments> verifiedAppointment = FXCollections.observableArrayList();
            for(Appointments screener : allAppointments){
                if(screener.getCustomerId() == customerId){
                    verifiedAppointment.add(screener);
                }
            }
            return verifiedAppointment;
    }

    public Appointments lookupAppointmentById(int appointmentId){
        Appointments verifiedAppointment = null;
        for(Appointments screener : allAppointments){
            if(screener.getAppointmentId() == appointmentId){
                verifiedAppointment = screener;
            }
        }
        return verifiedAppointment;
    }
    public ObservableList<Appointments> getAllAppointments(){
        return allAppointments;
    }

    public void appointmentFilter(){

    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getContactId() {
        return contactId;
    }
}
