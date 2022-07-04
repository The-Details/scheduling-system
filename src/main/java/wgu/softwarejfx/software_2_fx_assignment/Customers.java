package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

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

    public void addCustomer(Customers newCustomer){
        allCustomers.add(newCustomer);
    }

    public void updateCustomer(int customerId, Customers customerToUpdate){
        for(Customers waitingRoom : allCustomers){
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
    }

    public void deleteCustomer(Customers selectedCustomer){
        allCustomers.remove(selectedCustomer);
    }

    public ObservableList<Customers> lookupCustomerByName(String customerName){
        ObservableList<Customers> crossHairs = FXCollections.observableArrayList();
        for(Customers spyGlass : allCustomers){
            if(spyGlass.getCustomerName().equals(customerName)){
                crossHairs.add(spyGlass);
            }
        }
        return crossHairs;
    }

    public static Customers lookupCustomerById(int customerId){
        Customers crossHairs = null;
        for(Customers spyGlass : allCustomers){
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

    public ObservableList<Customers> getAllCustomers(){
        return allCustomers;
    }
}
