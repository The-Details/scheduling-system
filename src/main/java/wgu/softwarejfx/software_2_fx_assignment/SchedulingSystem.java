package wgu.softwarejfx.software_2_fx_assignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;

import static wgu.softwarejfx.software_2_fx_assignment.Appointments.allAppointments;
import static wgu.softwarejfx.software_2_fx_assignment.Contacts.allContacts;
import static wgu.softwarejfx.software_2_fx_assignment.Countries.allCountries;
import static wgu.softwarejfx.software_2_fx_assignment.Customers.allCustomers;
import static wgu.softwarejfx.software_2_fx_assignment.FirstLevelDivisions.allFirstLevelDivisions;
import static wgu.softwarejfx.software_2_fx_assignment.LoginController.logInFormText;
import static wgu.softwarejfx.software_2_fx_assignment.Users.allUsers;

public class SchedulingSystem extends Application {

    public Connection lan;
    public String divisionQuery;
    public String customerQuery;
    public String appointmentsQuery;
    public String contactsQuery;
    public String countriesQuery;
    public String userQuery;

    Statement divisionStmt;
    Statement customerStmt;
    Statement appointmentStmt;
    Statement contactStmt;
    Statement countriesStmt;
    Statement userStmt;

    ResultSet divisionResultSet;
    ResultSet customerResultSet;
    ResultSet appointmentsResultSet;
    ResultSet contactsResultSet;
    ResultSet countriesResultSet;
    ResultSet userResultSet;

    public void constructConnection(){
        try{
            this.lan = DriverManager.getConnection("jdbc:mysql://localhost:3306/web?useSSL=false", "sqlUser", "Passw0rd!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void userData() throws SQLException {
        userStmt = lan.createStatement();
        userQuery = "SELECT *" + "FROM users";
        userResultSet = userStmt.executeQuery(userQuery);

        while (userResultSet.next()){
        allUsers.add(new Users(Integer.parseInt(userResultSet.getString("user_id")),
                userResultSet.getString("user_name"),
                userResultSet.getString("password")));
        }
    }

    public void divisionData() throws SQLException {
        divisionStmt = lan.createStatement();
        divisionQuery = "SELECT *" + "FROM first_level_division";
        divisionResultSet = divisionStmt.executeQuery(divisionQuery);

        while(divisionResultSet.next()){
        allFirstLevelDivisions.add(new FirstLevelDivisions(Integer.parseInt(divisionResultSet.getString("division_id")),
                divisionResultSet.getString("division"),
                LocalDateTime.parse(divisionResultSet.getString("create_date")),
                divisionResultSet.getString("created_by"),
                LocalDateTime.parse(divisionResultSet.getString("last_update")),
                divisionResultSet.getString("last_updated_by"),
                Integer.parseInt(divisionResultSet.getString("country_id"))));
        }

    }

    public void appointment() throws SQLException {
        appointmentStmt = lan.createStatement();
        appointmentsQuery = "SELECT *" + "FROM appointments";
        appointmentsResultSet = divisionStmt.executeQuery(appointmentsQuery);

        while (appointmentsResultSet.next()){
        allAppointments.add(new Appointments(Integer.parseInt(appointmentsResultSet.getString("appointment_id")),
                appointmentsResultSet.getString("title"),
                appointmentsResultSet.getString("description"),
                appointmentsResultSet.getString("location"),
                appointmentsResultSet.getString("type"),
                LocalDateTime.parse(appointmentsResultSet.getString("start")),
                LocalDateTime.parse(appointmentsResultSet.getString("end")),
                LocalDateTime.parse(appointmentsResultSet.getString("create_date")),
                appointmentsResultSet.getString("create_by"),
                LocalDateTime.parse(appointmentsResultSet.getString("last_update")),
                appointmentsResultSet.getString("last_updated_by"),
                Integer.parseInt(appointmentsResultSet.getString("customer_id")),
                Integer.parseInt(appointmentsResultSet.getString("user_id")),
                Integer.parseInt(appointmentsResultSet.getString("contact_id"))));
        }
    }

    public void customerData() throws SQLException {
        customerStmt = lan.createStatement();
        customerQuery = "SELECT *" + "FROM customers";
        customerResultSet = customerStmt.executeQuery(customerQuery);

        while (customerResultSet.next()){
        allCustomers.add(new Customers(Integer.parseInt(customerResultSet.getString("customer_id")),
                customerResultSet.getString("customer_name"),
                customerResultSet.getString("address"),
                customerResultSet.getString("postal_code"),
                customerResultSet.getString("phone"),
                LocalDateTime.parse(customerResultSet.getString("create_date")),
                customerResultSet.getString("created_by"),
                LocalDateTime.parse(customerResultSet.getString("last_update")),
                customerResultSet.getString("last_updated_by"),
                Integer.parseInt(customerResultSet.getString("division_id"))
                ));
        }
    }

    public void contactData() throws SQLException {
        contactStmt = lan.createStatement();
        contactsQuery = "SELECT *" + "FROM contacts";
        contactsResultSet = contactStmt.executeQuery(contactsQuery);

        while(contactsResultSet.next()) {
            allContacts.add(new Contacts(Integer.parseInt(contactsResultSet.getString("contact_id")),
                    contactsResultSet.getString("contact_name"),
                    contactsResultSet.getString("email")
                    ));
        }
    }

    public void countryData() throws SQLException{
        countriesStmt = lan.createStatement();
        countriesQuery = "SELECT *" + "FROM countries";
        contactsResultSet = contactStmt.executeQuery(contactsQuery);

        while (countriesResultSet.next()){
            allCountries.add(new Countries(Integer.parseInt(contactsResultSet.getString("country_id")),
                    contactsResultSet.getString("country"),
                    LocalDateTime.parse(contactsResultSet.getString("create_date")),
                    contactsResultSet.getString("created_by"),
                    LocalDateTime.parse(contactsResultSet.getString("last_update")),
                    contactsResultSet.getString("last_updated_by")
                    ));
        }
    }

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        constructConnection();
        userData();
        divisionData();
        appointment();
        customerData();
        contactData();
        countryData();

        FXMLLoader fxmlLoader = new FXMLLoader(SchedulingSystem.class.getResource("login-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(logInFormText.getString("windowTitle"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}