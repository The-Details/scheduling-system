package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_2_fx_assignment.Customers.lookupCustomerById;

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
    static Statement insertAppointmentStmt;
    static String insertAppointmentQuery;
    static ResultSet insertAppointmentResultSet;
    static Statement updateAppointmentStmt;
    static String updateAppointmentQuery;
    static ResultSet updateAppointmentResultSet;
    static Statement deleteAppointmentStmt;
    static String deleteAppointmentQuery;
    static ResultSet deleteAppointmentResultSet;




    public static ObservableList<Appointments> allAppointments = FXCollections.observableArrayList();

    public static ObservableList<Appointments> januaryAppointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> januaryWeek1Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> januaryWeek2Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> januaryWeek3Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> januaryWeek4Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> februaryAppointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> februaryWeek1Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> februaryWeek2Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> februaryWeek3Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> februaryWeek4Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> marchAppointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> marchWeek1Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> marchWeek2Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> marchWeek3Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> marchWeek4Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> aprilAppointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> aprilWeek1Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> aprilWeek2Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> aprilWeek3Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> aprilWeek4Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> mayAppointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> mayWeek1Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> mayWeek2Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> mayWeek3Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> mayWeek4Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> juneAppointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> juneWeek1Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> juneWeek2Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> juneWeek3Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> juneWeek4Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> julyAppointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> julyWeek1Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> julyWeek2Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> julyWeek3Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> julyWeek4Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> augustAppointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> augustWeek1Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> augustWeek2Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> augustWeek3Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> augustWeek4Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> septemberAppointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> septemberWeek1Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> septemberWeek2Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> septemberWeek3Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> septemberWeek4Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> octoberAppointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> octoberWeek1Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> octoberWeek2Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> octoberWeek3Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> octoberWeek4Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> novemberAppointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> novemberWeek1Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> novemberWeek2Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> novemberWeek3Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> novemberWeek4Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> decemberAppointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> decemberWeek1Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> decemberWeek2Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> decemberWeek3Appointments = FXCollections.observableArrayList();
    public static ObservableList<Appointments> decemberWeek4Appointments = FXCollections.observableArrayList();
    public static ObservableList<String> appointmentTimes = FXCollections.observableArrayList();

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

    public static void setAppointmentTimes(){
        appointmentTimes.addAll("12:00",
                "01:00",
                "02:00",
                "03:00",
                "04:00",
                "05:00",
                "06:00",
                "07:00",
                "08:00",
                "09:00",
                "10:00",
                "11:00",
                "12:00",
                "01:00",
                "02:00",
                "03:00",
                "04:00",
                "05:00",
                "06:00",
                "07:00",
                "08:00",
                "09:00",
                "10:00",
                "11:00"
        );
    }

    public static void addAppointment(Appointments newAppointment) throws SQLException {
        allAppointments.add(newAppointment);

        insertAppointmentStmt = SchedulingSystem.connection.createStatement();
        insertAppointmentQuery = "Insert INTO appointments " + "values(" + newAppointment.appointmentId
                + ", " +newAppointment.appointmentId
                + ", " + newAppointment.title + ", " + newAppointment.description + ", " + newAppointment.location + ", " + newAppointment.type
                + ", " + newAppointment.start + ", " + newAppointment.end + ", " + newAppointment.createDate + ", " + newAppointment.createdBy
                + ", " + newAppointment.last_update + ", " + newAppointment.lastUpdateBy + ", " + newAppointment.customerId
                + ", " + newAppointment.userId + ", " + newAppointment.contactId + ")";
        insertAppointmentResultSet = insertAppointmentStmt.executeQuery(insertAppointmentQuery);

    }

    public static void updateAppointment(int appointmentId, Appointments selectedAppointment) throws SQLException {
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

        updateAppointmentStmt = SchedulingSystem.connection.createStatement();
        updateAppointmentQuery = "UPDATE appointments "
                + "SET Title = "
                + selectedAppointment.title
                + ", " + "Description = "
                + selectedAppointment.description
                + ", " + "Location = "
                + selectedAppointment.location
                + ", " + "Type = "
                +  selectedAppointment.type
                + ", " + "Start = "
                + selectedAppointment.start
                + ", " + "End = "
                + selectedAppointment.end
                + ", " + "Create_Date = "
                + selectedAppointment.createDate
                + ", " + "Created_By = "
                + selectedAppointment.createdBy
                + ", " + "Last_Update = "
                + selectedAppointment.last_update
                + ", " + "Title = "
                + selectedAppointment.lastUpdateBy
                + ", " + "Customer_ID = "
                + selectedAppointment.customerId
                + ", " + "User_ID = "
                + selectedAppointment.userId
                + ", " + "Contact_ID = "
                + selectedAppointment.contactId
                + "WHERE appointment_id = "
                + selectedAppointment.appointmentId;
        updateAppointmentResultSet = updateAppointmentStmt.executeQuery(updateAppointmentQuery);


    }

    public static void deleteAppointment(Appointments selectedAppointment){
        allAppointments.remove(selectedAppointment);
        januaryAppointments.remove(selectedAppointment);
        februaryAppointments.remove(selectedAppointment);
        marchAppointments.remove(selectedAppointment);
        aprilAppointments.remove(selectedAppointment);
        mayAppointments.remove(selectedAppointment);
        juneAppointments.remove(selectedAppointment);
        julyAppointments.remove(selectedAppointment);
        augustAppointments.remove(selectedAppointment);
        octoberAppointments.remove(selectedAppointment);
        novemberAppointments.remove(selectedAppointment);
        decemberAppointments.remove(selectedAppointment);


        try {
            deleteAppointmentStmt = SchedulingSystem.connection.createStatement();
            deleteAppointmentQuery = "DELETE FROM appointments" + "WHERE appointment_id = " + selectedAppointment.appointmentId;
            deleteAppointmentResultSet = deleteAppointmentStmt.executeQuery(deleteAppointmentQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ObservableList<Appointments> lookupAppointmentByCustomerId(int customerId){
        ObservableList<Appointments> verifiedAppointment = FXCollections.observableArrayList();
            for(Appointments screener : allAppointments){
                if(screener.getCustomerId() == customerId){
                    verifiedAppointment.add(screener);
                }
            }
            return verifiedAppointment;
    }

    public static Appointments lookupAppointmentById(int appointmentId){
        Appointments verifiedAppointment = null;
        for(Appointments screener : allAppointments){
            if(screener.getAppointmentId() == appointmentId){
                verifiedAppointment = screener;
            }
        }
        return verifiedAppointment;
    }
    public static ObservableList<Appointments> getAllAppointments(){
        return allAppointments;
    }

    public static void appointmentFilter(){

        for (Appointments monthFilter : getAllAppointments()){
            if(monthFilter.getStart().getMonthValue() == 1){
                januaryAppointments.add(monthFilter);

                for (Appointments weekFilter : januaryAppointments){
                    if (weekFilter.getStart().getDayOfMonth() <= 7){
                        januaryWeek1Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 14 && weekFilter.getStart().getDayOfMonth() >= 8) {
                        januaryWeek2Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 22 && weekFilter.getStart().getDayOfMonth() >= 15) {
                        januaryWeek3Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() >= 23) {
                        januaryWeek4Appointments.add(weekFilter);
                    }
                    else {
                        System.out.println("Error: Something went wrong with the appointment week filter");
                    }
                }
            }
            else if(monthFilter.getStart().getMonthValue() == 2){
                februaryAppointments.add(monthFilter);

                for (Appointments weekFilter : februaryAppointments){
                    if (weekFilter.getStart().getDayOfMonth() <= 7){
                        februaryWeek1Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 14 && weekFilter.getStart().getDayOfMonth() >= 8) {
                        februaryWeek2Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 22 && weekFilter.getStart().getDayOfMonth() >= 15) {
                        februaryWeek3Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() >= 23) {
                        februaryWeek4Appointments.add(weekFilter);
                    }
                    else {
                        System.out.println("Error: Something went wrong with the appointment week filter");
                    }
                }
            }
            else if(monthFilter.getStart().getMonthValue() == 3){
                marchAppointments.add(monthFilter);

                for (Appointments weekFilter : marchAppointments){
                    if (weekFilter.getStart().getDayOfMonth() <= 7){
                        marchWeek1Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 14 && weekFilter.getStart().getDayOfMonth() >= 8) {
                        marchWeek2Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 22 && weekFilter.getStart().getDayOfMonth() >= 15) {
                        marchWeek3Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() >= 23) {
                        marchWeek4Appointments.add(weekFilter);
                    }
                    else {
                        System.out.println("Error: Something went wrong with the appointment week filter");
                    }
                }
            }
            else if(monthFilter.getStart().getMonthValue() == 4){
                aprilAppointments.add(monthFilter);

                for (Appointments weekFilter : aprilAppointments){
                    if (weekFilter.getStart().getDayOfMonth() <= 7){
                        aprilWeek1Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 14 && weekFilter.getStart().getDayOfMonth() >= 8) {
                        aprilWeek2Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 22 && weekFilter.getStart().getDayOfMonth() >= 15) {
                        aprilWeek3Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() >= 23) {
                        aprilWeek4Appointments.add(weekFilter);
                    }
                    else {
                        System.out.println("Error: Something went wrong with the appointment week filter");
                    }
                }
            }
            else if(monthFilter.getStart().getMonthValue() == 5){
                mayAppointments.add(monthFilter);

                for (Appointments weekFilter : mayAppointments){
                    if (weekFilter.getStart().getDayOfMonth() <= 7){
                        mayWeek1Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 14 && weekFilter.getStart().getDayOfMonth() >= 8) {
                        mayWeek2Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 22 && weekFilter.getStart().getDayOfMonth() >= 15) {
                        mayWeek3Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() >= 23) {
                        mayWeek4Appointments.add(weekFilter);
                    }
                    else {
                        System.out.println("Error: Something went wrong with the appointment week filter");
                    }
                }
            }
            else if(monthFilter.getStart().getMonthValue() == 6){
                juneAppointments.add(monthFilter);

                for (Appointments weekFilter : juneAppointments){
                    if (weekFilter.getStart().getDayOfMonth() <= 7){
                        juneWeek1Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 14 && weekFilter.getStart().getDayOfMonth() >= 8) {
                        juneWeek2Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 22 && weekFilter.getStart().getDayOfMonth() >= 15) {
                        juneWeek3Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() >= 23) {
                        juneWeek4Appointments.add(weekFilter);
                    }
                    else {
                        System.out.println("Error: Something went wrong with the appointment week filter");
                    }
                }
            }
            else if(monthFilter.getStart().getMonthValue() == 7){
                julyAppointments.add(monthFilter);

                for (Appointments weekFilter : julyAppointments){
                    if (weekFilter.getStart().getDayOfMonth() <= 7){
                        julyWeek1Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 14 && weekFilter.getStart().getDayOfMonth() >= 8) {
                        julyWeek2Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 22 && weekFilter.getStart().getDayOfMonth() >= 15) {
                        julyWeek3Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() >= 23) {
                        julyWeek4Appointments.add(weekFilter);
                    }
                    else {
                        System.out.println("Error: Something went wrong with the appointment week filter");
                    }
                }
            }
            else if(monthFilter.getStart().getMonthValue() == 8){
                augustAppointments.add(monthFilter);

                for (Appointments weekFilter : augustAppointments){
                    if (weekFilter.getStart().getDayOfMonth() <= 7){
                        augustWeek1Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 14 && weekFilter.getStart().getDayOfMonth() >= 8) {
                        augustWeek2Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 22 && weekFilter.getStart().getDayOfMonth() >= 15) {
                        augustWeek3Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() >= 23) {
                        augustWeek4Appointments.add(weekFilter);
                    }
                    else {
                        System.out.println("Error: Something went wrong with the appointment week filter");
                    }
                }
            }
            else if(monthFilter.getStart().getMonthValue() == 9){
                septemberAppointments.add(monthFilter);

                for (Appointments weekFilter : septemberAppointments){
                    if (weekFilter.getStart().getDayOfMonth() <= 7){
                        septemberWeek1Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 14 && weekFilter.getStart().getDayOfMonth() >= 8) {
                        septemberWeek2Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 22 && weekFilter.getStart().getDayOfMonth() >= 15) {
                        septemberWeek3Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() >= 23) {
                        septemberWeek4Appointments.add(weekFilter);
                    }
                    else {
                        System.out.println("Error: Something went wrong with the appointment week filter");
                    }
                }
            }
            else if(monthFilter.getStart().getMonthValue() == 10){
                octoberAppointments.add(monthFilter);

                for (Appointments weekFilter : octoberAppointments){
                    if (weekFilter.getStart().getDayOfMonth() <= 7){
                        octoberWeek1Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 14 && weekFilter.getStart().getDayOfMonth() >= 8) {
                        octoberWeek2Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 22 && weekFilter.getStart().getDayOfMonth() >= 15) {
                        octoberWeek3Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() >= 23) {
                        octoberWeek4Appointments.add(weekFilter);
                    }
                    else {
                        System.out.println("Error: Something went wrong with the appointment week filter");
                    }
                }
            }
            else if(monthFilter.getStart().getMonthValue() == 11){
                novemberAppointments.add(monthFilter);

                for (Appointments weekFilter : novemberAppointments){
                    if (weekFilter.getStart().getDayOfMonth() <= 7){
                        novemberWeek1Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 14 && weekFilter.getStart().getDayOfMonth() >= 8) {
                        novemberWeek2Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 22 && weekFilter.getStart().getDayOfMonth() >= 15) {
                        novemberWeek3Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() >= 23) {
                        novemberWeek4Appointments.add(weekFilter);
                    }
                    else {
                        System.out.println("Error: Something went wrong with the appointment week filter");
                    }
                }
            }
            else if(monthFilter.getStart().getMonthValue() == 12){
                decemberAppointments.add(monthFilter);

                for (Appointments weekFilter : decemberAppointments){
                    if (weekFilter.getStart().getDayOfMonth() <= 7){
                        decemberWeek1Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 14 && weekFilter.getStart().getDayOfMonth() >= 8) {
                        decemberWeek2Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() <= 22 && weekFilter.getStart().getDayOfMonth() >= 15) {
                        decemberWeek3Appointments.add(weekFilter);
                    }
                    else if (weekFilter.getStart().getDayOfMonth() >= 23) {
                        decemberWeek4Appointments.add(weekFilter);
                    }
                    else {
                        System.out.println("Error: Something went wrong with the appointment week filter");
                    }
                }
            }
            else {
                System.out.println("Error: Something went wrong with the Appointment filter");
            }
        }
    }

    public static LocalTime appointmentTimeConvertor(String standardTime){
        LocalTime universalTime = null;

        CharSequence amCharacterCage = "AM";
        CharSequence pmCharacterCage = "PM";

//        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String[] standardTimeSplitter = standardTime.split(":", 2);

        if(standardTime.contains(amCharacterCage)){
            universalTime = LocalTime.of(Integer.parseInt(standardTimeSplitter[0]), 0);
        }
        else if (standardTime.contains(pmCharacterCage)){
            if (Integer.parseInt(standardTimeSplitter[0]) == 12){
                universalTime = LocalTime.of(Integer.parseInt(standardTimeSplitter[0]), 0);
            }
            else {
                universalTime = LocalTime.of(Integer.parseInt(standardTimeSplitter[0]) + 12, 0);
            }
        }

        return universalTime;
    }


    public static String appointmentTimeReverser(String utcTime){
        String[] utcTimeSplitter = utcTime.split(":", 2);

        int utcTimeCage = Integer.parseInt(utcTimeSplitter[0]);

        String reversedTime;

        if(utcTimeCage <= 12){
            reversedTime = utcTimeCage + ":00AM";
        }
        else {
            reversedTime = (utcTimeCage - 12) + ":00PM";
        }
        return reversedTime;
    }

    public static boolean appointmentConflictChecker(String appointmentId, LocalDate appointmentStartDate, LocalDate appointmentEndDate,
                                                  LocalTime appointmentStartTime, LocalTime appointmentEndTime){

        boolean isThereAConflict = false;

        try {

            int customerIdToCompare = lookupAppointmentById(Integer.parseInt(appointmentId)).customerId;

            for (Appointments appointmentToCompare : allAppointments) {
                if ((appointmentToCompare.getStart().toLocalDate() == appointmentStartDate) && (appointmentToCompare.getStart().toLocalTime().toString().equals(appointmentStartTime.toString()))) {

                    if(!(appointmentToCompare.appointmentId == Integer.parseInt(appointmentId))
                            && !(appointmentToCompare.customerId == customerIdToCompare)){
                        isThereAConflict = true;
                    }

                    GridPane conformation = new GridPane();
                    Text conformationInfo = new Text("Conflict on: " + appointmentStartDate + " at " + appointmentStartTime);
                    conformationInfo.setFont(new Font(20));
                    conformation.getChildren().add(conformationInfo);
                    GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                    Stage popUp = new Stage();
                    Scene conformationScene = new Scene(conformation);
                    popUp.setTitle("Error");
                    popUp.setScene(conformationScene);
                    popUp.sizeToScene();
                    popUp.show();
                }

                if ((appointmentToCompare.getEnd().toLocalDate() == appointmentEndDate) && (appointmentToCompare.getEnd().toLocalTime().toString().equals(appointmentEndTime.toString()))) {

                    if((appointmentToCompare.appointmentId != Integer.parseInt(appointmentId))
                            && (appointmentToCompare.customerId != customerIdToCompare)){
                        isThereAConflict = true;
                    }

                    GridPane conformation = new GridPane();
                    Text conformationInfo = new Text("Conflict on: " + appointmentEndDate);
                    conformationInfo.setFont(new Font(20));
                    conformation.getChildren().add(conformationInfo);
                    GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                    Stage popUp = new Stage();
                    Scene conformationScene = new Scene(conformation);
                    popUp.setTitle("Error");
                    popUp.setScene(conformationScene);
                    popUp.sizeToScene();
                    popUp.show();
                }

                if (appointmentStartDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) || appointmentStartDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {

                    if((appointmentToCompare.appointmentId != Integer.parseInt(appointmentId))
                            && (appointmentToCompare.customerId != customerIdToCompare)){
                        isThereAConflict = true;
                    }

                    GridPane conformation = new GridPane();
                    Text conformationInfo = new Text("Weekend Conflict on: " + appointmentStartDate);
                    conformationInfo.setFont(new Font(20));
                    conformation.getChildren().add(conformationInfo);
                    GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                    Stage popUp = new Stage();
                    Scene conformationScene = new Scene(conformation);
                    popUp.setTitle("Error");
                    popUp.setScene(conformationScene);
                    popUp.sizeToScene();
                    popUp.show();
                }
                if ((appointmentEndDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) || appointmentEndDate.getDayOfWeek().equals(DayOfWeek.SUNDAY))) {
                    if((appointmentToCompare.appointmentId != Integer.parseInt(appointmentId))
                            && (appointmentToCompare.customerId != customerIdToCompare)){
                        isThereAConflict = true;
                    }

                    GridPane conformation = new GridPane();
                    Text conformationInfo = new Text("Weekend Conflict on: " + appointmentEndDate);
                    conformationInfo.setFont(new Font(20));
                    conformation.getChildren().add(conformationInfo);
                    GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                    Stage popUp = new Stage();
                    Scene conformationScene = new Scene(conformation);
                    popUp.setTitle("Error");
                    popUp.setScene(conformationScene);
                    popUp.sizeToScene();
                    popUp.show();
                }

            }


        }catch (Exception e) {
            e.printStackTrace();
        }
        return isThereAConflict;
    }


    public static void appointmentReminder(){

        for(Appointments appointmentCage : getAllAppointments()){
            String[] startTimeSplitter = appointmentTimeReverser(appointmentCage.start.toLocalTime().toString()).split(":", 2);

            int startTimeJoin = Integer.parseInt(startTimeSplitter[0] + startTimeSplitter[1]);

            int startTimeFifteenMinTil = startTimeJoin - 15;

            String[] nowTimeSplitter = LocalTime.now().toString().split(":", 3);

            int nowTimeJoin = Integer.parseInt(nowTimeSplitter[0] + nowTimeSplitter[1]);

            int notTimeFifteenMinTil = nowTimeJoin - 15;

            if(startTimeFifteenMinTil == notTimeFifteenMinTil){
                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Appointment with: " + lookupCustomerById(appointmentCage.customerId).customerName + " coming up in 15 minutes.");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            }

        }

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
