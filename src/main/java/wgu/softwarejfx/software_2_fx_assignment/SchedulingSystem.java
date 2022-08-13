package wgu.softwarejfx.software_2_fx_assignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static wgu.softwarejfx.software_2_fx_assignment.Appointments.allAppointments;
import static wgu.softwarejfx.software_2_fx_assignment.Appointments.appointmentFilter;
import static wgu.softwarejfx.software_2_fx_assignment.Contacts.allContacts;
import static wgu.softwarejfx.software_2_fx_assignment.Countries.allCountries;
import static wgu.softwarejfx.software_2_fx_assignment.Customers.allCustomers;
import static wgu.softwarejfx.software_2_fx_assignment.FirstLevelDivisions.allFirstLevelDivisions;
import static wgu.softwarejfx.software_2_fx_assignment.LoginController.logInFormText;
import static wgu.softwarejfx.software_2_fx_assignment.Users.allUsers;

public class SchedulingSystem extends Application {

    public static Connection connection;
    public static String divisionQuery;
    public static String customerQuery;
    public static String appointmentsQuery;
    public static String contactsQuery;
    public static String countriesQuery;
    public static String userQuery;

    public static Statement divisionStmt;
    public static Statement customerStmt;
    public static Statement appointmentStmt;
    public static Statement contactStmt;
    public static Statement countriesStmt;
    public static Statement userStmt;

    public static ResultSet divisionResultSet;
    public static ResultSet customerResultSet;
    public static ResultSet appointmentsResultSet;
    public static ResultSet contactsResultSet;
    public static ResultSet countriesResultSet;
    public static ResultSet userResultSet;

    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void constructConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/client_schedule?connectionTimeZone = SERVER", "sqlUser", "Passw0rd!");
            System.out.println("Connection open");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void closeConnection(){
        try{
            connection.close();
            System.out.println("Connection closed");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void userData() throws SQLException {
        userStmt = connection.createStatement();
        userQuery = "SELECT *" + "FROM users";
        userResultSet = userStmt.executeQuery(userQuery);

        while (userResultSet.next()){
        allUsers.add(new Users(Integer.parseInt(userResultSet.getString("user_id")),
                userResultSet.getString("user_name"),
                userResultSet.getString("password")));
        }
    }

    public static void divisionData() throws SQLException {
        divisionStmt = connection.createStatement();
        divisionQuery = "SELECT *" + "FROM first_level_divisions";
        divisionResultSet = divisionStmt.executeQuery(divisionQuery);

        while(divisionResultSet.next()){
        allFirstLevelDivisions.add(new FirstLevelDivisions(Integer.parseInt(divisionResultSet.getString("division_id")),
                divisionResultSet.getString("division"),
                LocalDateTime.parse(divisionResultSet.getString("create_date"), dateTimeFormatter),
                divisionResultSet.getString("created_by"),
                LocalDateTime.parse(divisionResultSet.getString("last_update"), dateTimeFormatter),
                divisionResultSet.getString("last_updated_by"),
                Integer.parseInt(divisionResultSet.getString("country_id"))));
        }

    }

    public static void appointment() throws SQLException {
        appointmentStmt = connection.createStatement();
        appointmentsQuery = "SELECT *" + "FROM appointments";
        appointmentsResultSet = divisionStmt.executeQuery(appointmentsQuery);

        while (appointmentsResultSet.next()){
        allAppointments.add(new Appointments(Integer.parseInt(appointmentsResultSet.getString("appointment_id")),
                appointmentsResultSet.getString("title"),
                appointmentsResultSet.getString("description"),
                appointmentsResultSet.getString("location"),
                appointmentsResultSet.getString("type"),
                LocalDateTime.parse(appointmentsResultSet.getString("start"), dateTimeFormatter),
                LocalDateTime.parse(appointmentsResultSet.getString("end"), dateTimeFormatter),
                LocalDateTime.parse(appointmentsResultSet.getString("create_date"), dateTimeFormatter),
                appointmentsResultSet.getString("created_by"),
                LocalDateTime.parse(appointmentsResultSet.getString("last_update"), dateTimeFormatter),
                appointmentsResultSet.getString("last_updated_by"),
                Integer.parseInt(appointmentsResultSet.getString("customer_id")),
                Integer.parseInt(appointmentsResultSet.getString("user_id")),
                Integer.parseInt(appointmentsResultSet.getString("contact_id"))));
        }
        appointmentFilter();
    }

    public static void customerData() throws SQLException {
        customerStmt = connection.createStatement();
        customerQuery = "SELECT *" + "FROM customers";
        customerResultSet = customerStmt.executeQuery(customerQuery);

        while (customerResultSet.next()){
        allCustomers.add(new Customers(Integer.parseInt(customerResultSet.getString("customer_id")),
                customerResultSet.getString("customer_name"),
                customerResultSet.getString("address"),
                customerResultSet.getString("postal_code"),
                customerResultSet.getString("phone"),
                LocalDateTime.parse(customerResultSet.getString("create_date"), dateTimeFormatter),
                customerResultSet.getString("created_by"),
                LocalDateTime.parse(customerResultSet.getString("last_update"), dateTimeFormatter),
                customerResultSet.getString("last_updated_by"),
                Integer.parseInt(customerResultSet.getString("division_id"))
            ));
        }
    }

    public static void contactData() throws SQLException {
        contactStmt = connection.createStatement();
        contactsQuery = "SELECT *" + "FROM contacts";
        contactsResultSet = contactStmt.executeQuery(contactsQuery);

        while(contactsResultSet.next()) {
            allContacts.add(new Contacts(Integer.parseInt(contactsResultSet.getString("contact_id")),
                    contactsResultSet.getString("contact_name"),
                    contactsResultSet.getString("email")
                    ));
        }
    }

    public static void countryData() throws SQLException{
        countriesStmt = connection.createStatement();
        countriesQuery = "SELECT *" + "FROM countries";
        countriesResultSet = countriesStmt.executeQuery(countriesQuery);

        while (countriesResultSet.next()){
            allCountries.add(new Countries(Integer.parseInt(countriesResultSet.getString("country_id")),
                    countriesResultSet.getString("country"),
                    LocalDateTime.parse(countriesResultSet.getString("create_date"), dateTimeFormatter),
                    countriesResultSet.getString("created_by"),
                    LocalDateTime.parse(countriesResultSet.getString("last_update"), dateTimeFormatter),
                    countriesResultSet.getString("last_updated_by")
                    ));
        }
    }

    public static void testDataStarterPack() {
        LocalDateTime localDateTime = LocalDateTime.now();

        allUsers.add(new Users(1, "admin","admin"));
        allCustomers.add(new Customers(1, "name", "address", "zipcode",
                "000-000-0000", localDateTime, "user", localDateTime, "user", 0));

        allAppointments.add(new Appointments(allAppointments.size() + 1, "title", "description",
                "location", "type", localDateTime, localDateTime, localDateTime, "user"
        , localDateTime, "user", 0, 0, 0));
        allCountries.add(new Countries(0,"country name", localDateTime, "user",
                localDateTime, "user"));
        allContacts.add(new Contacts(0, "contact name", "email@shit.paper"));
        allFirstLevelDivisions.add(new FirstLevelDivisions(0, "divisionName", localDateTime,
                "user", localDateTime, "user", 0));

    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SchedulingSystem.class.getResource("login-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(logInFormText.getString("windowTitle"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        constructConnection();
        userData();
        divisionData();
        appointment();
        customerData();
        contactData();
        countryData();

//        testDataStarterPack();

        launch();
    }
}