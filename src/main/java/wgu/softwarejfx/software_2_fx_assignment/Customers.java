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
import java.time.LocalDateTime;

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_2_fx_assignment.Appointments.getAllAppointments;
import static wgu.softwarejfx.software_2_fx_assignment.Appointments.lookupAppointmentByCustomerId;

/**
 * This class serves as a basis for manipulating customer data
 */
public class Customers {

    int customerId;
    String customerName;
    String address;
    String zipCode;
    String phoneNumber;
    LocalDateTime createDate;
    String createdBy;
    LocalDateTime lastUpdate;
    String lastUpdateBy;
    int divisionId;
    static Statement insertCustomerStmt;
    static String insertCustomerUpdate;
    static int insertCustomerResultSet;
    static Statement updateCustomerStmt;
    static String updateCustomerUpdate;
    static int updateCustomerResultSet;
    static Statement deleteCustomerStmt;
    static String deleteCustomerUpdate;
    static int deleteCustomerResultSet;

    public static ObservableList<Customers> allCustomers = FXCollections.observableArrayList();

    public Customers(int customerId, String customerName, String address, String zipCode, String phoneNumber, LocalDateTime createDate, String createdBy, LocalDateTime lastUpdate, String lastUpdateBy, int divisionId){
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
        this.divisionId = divisionId;
    }

    /**
     *
     * @param newCustomer
     * This method adds new customer info to the database and the appropriate table
     * @throws SQLException
     */
    public static void addCustomer(Customers newCustomer) throws SQLException {
        getAllCustomers().add(newCustomer);

        insertCustomerStmt = SchedulingSystem.connection.createStatement();
        insertCustomerUpdate = "Insert INTO customers (customer_id, customer_name, address, postal_code, phone, create_date, created_by, last_update, last_updated_by, division_id) " + "values('" + newCustomer.customerId
                + "', '" + newCustomer.customerName + "', '" + newCustomer.address + "', '" + newCustomer.zipCode + "', '" + newCustomer.phoneNumber
                + "', '" + newCustomer.createDate + "', '" + newCustomer.createdBy
                + "', '" + newCustomer.lastUpdate + "', '" + newCustomer.lastUpdateBy + "', '" + newCustomer.divisionId + "')";
        insertCustomerResultSet = insertCustomerStmt.executeUpdate(insertCustomerUpdate);
    }

    /**
     *
     * @param customerId
     * This method takes the customerId and uses it to find the pre-existing matching customer to be updated.
     * @param customerToUpdate
     * The customerToUpdate is the updated data from the modify customer form to be useed to alter the pre-existing customer information.
     * @throws SQLException
     */
    public static void updateCustomer(int customerId, Customers customerToUpdate) throws SQLException {
        for(Customers waitingRoom : getAllCustomers()){
            if(waitingRoom.getCustomerId() == customerId){
                waitingRoom.setCustomerName(customerToUpdate.getCustomerName());
                waitingRoom.setAddress(customerToUpdate.getAddress());
                waitingRoom.setZipCode(customerToUpdate.getZipCode());
                waitingRoom.setPhoneNumber(customerToUpdate.getPhoneNumber());
                waitingRoom.setCreateDate(customerToUpdate.getCreateDate());
                waitingRoom.setCreatedBy(customerToUpdate.getCreatedBy());
                waitingRoom.setLastUpdate(customerToUpdate.getLastUpdate());
                waitingRoom.setLastUpdateBy(customerToUpdate.getLastUpdateBy());
                waitingRoom.setDivisionId(customerToUpdate.getDivisionId());
            }
        }

        updateCustomerStmt = SchedulingSystem.connection.createStatement();
        updateCustomerUpdate = "UPDATE customers "
                + "SET Customer_Name = '"
                + customerToUpdate.customerName
                + "', " + "Address = '"
                + customerToUpdate.address
                + "', " + "Postal_Code = '"
                + customerToUpdate.zipCode
                + "', " + "Create_Date = '"
                + customerToUpdate.createDate
                + "', " + "Created_By = '"
                + customerToUpdate.createdBy
                + "', " + "Last_Update = '"
                + customerToUpdate.lastUpdate
                + "', " + "Title = '"
                + customerToUpdate.lastUpdateBy
                + "', " + "Division_ID = '"
                + customerToUpdate.divisionId
                + "' WHERE customer_id = "
                + customerToUpdate.customerId;
        updateCustomerResultSet = updateCustomerStmt.executeUpdate(updateCustomerUpdate);
    }

    /**
     *
     * @param selectedCustomer
     * This method is used to delete the selected customer from the database along with all associated appointments
     */
    public static void deleteCustomer(Customers selectedCustomer){
        getAllCustomers().remove(selectedCustomer);

        for (Appointments appointmentToDelete : lookupAppointmentByCustomerId(selectedCustomer.getCustomerId())){
            getAllAppointments().remove(appointmentToDelete);
        }

        try {
            deleteCustomerStmt = SchedulingSystem.connection.createStatement();
            deleteCustomerUpdate = "DELETE FROM customers WHERE customer_id = " + selectedCustomer.customerId;
            deleteCustomerResultSet = deleteCustomerStmt.executeUpdate(deleteCustomerUpdate);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        GridPane conformation = new GridPane();
        Text conformationInfo = new Text("Customer: ID#: " + selectedCustomer.customerId + " has been deleted.");
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

    /**
     *
     * @param customerName
     * This method takes the customer's name and finds the matching record(s) with that name
     * @return
     * An array of customers is returned
     */
    public static ObservableList<Customers> lookupCustomerByName(String customerName){
        ObservableList<Customers> crossHairs = FXCollections.observableArrayList();
        for(Customers spyGlass : getAllCustomers()){
            if(spyGlass.getCustomerName().equals(customerName)){
                crossHairs.add(spyGlass);
            }
        }
        return crossHairs;
    }

    /**
     *
     * @param customerId
     * This method takes the customer's id and finds the matching record(s) with that id
     * @return
     * An array of customers is returned
     */
    public static Customers lookupCustomerById(int customerId){
        Customers crossHairs = null;
        for(Customers spyGlass : getAllCustomers()){
            if(spyGlass.customerId == customerId){
                crossHairs = spyGlass;
            }
        }
        return crossHairs;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public static ObservableList<Customers> getAllCustomers(){
        return allCustomers;
    }
}
