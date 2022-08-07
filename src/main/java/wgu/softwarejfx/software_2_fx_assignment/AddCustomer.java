package wgu.softwarejfx.software_2_fx_assignment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

import static wgu.softwarejfx.software_2_fx_assignment.Countries.allCountries;
import static wgu.softwarejfx.software_2_fx_assignment.Customers.addCustomer;
import static wgu.softwarejfx.software_2_fx_assignment.Customers.allCustomers;
import static wgu.softwarejfx.software_2_fx_assignment.FirstLevelDivisions.*;
import static wgu.softwarejfx.software_2_fx_assignment.LoginController.currentUser;
import static wgu.softwarejfx.software_2_fx_assignment.ModifyCustomer.currentlySelectedCustomer;

public class AddCustomer implements Initializable {

    @FXML
    TextField addCustomerId;
    @FXML
    TextField addCustomerName;
    @FXML
    TextField addCustomerPhone;
    @FXML
    TextField addCustomerAddress;
    @FXML
    ComboBox<String> addCustomerBorough;
    @FXML
    TextField addCustomerCity;
    @FXML
    ComboBox<FirstLevelDivisions> addCustomerStateProvince;
    @FXML
    ComboBox<Countries> addCustomerCountry;
    @FXML
    TextField addCustomerZipCode;
    @FXML
    Button saveNewCustomerButton;
    @FXML
    Button cancelNewCustomerButton;

    public void customerFieldSetup(){
        addCustomerId.setDisable(true);
        addCustomerId.setPromptText("Auto Generated");
        setAllBoroughs();
        firstDivisionFilter();
        addCustomerCountry.setItems(allCountries);
    }

    public void customerNewData(){

        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.now();

            if (addCustomerName.getText() == null) {
                System.out.println("Error: CustomerName is Empty");
            }
            else if ((addCustomerAddress.getText().isEmpty() || addCustomerCity.getText().isEmpty())) {
                System.out.println("Error: One or More Address Fields are Empty");
            }
            else if (addCustomerZipCode.getText().isEmpty()) {
                System.out.println("Error: Zipcode is Empty");
            }
            else if (addCustomerPhone.getText().isEmpty()) {
                System.out.println("Error: Phone Number is Empty");
            }
            else if (addCustomerBorough.getValue() == null){
                Customers newCustomer = new Customers(
                        allCustomers.size() + 1,
                        addCustomerName.getText(),
                        addCustomerAddress.getText() + ", "
                                + addCustomerCity.getText() + ", "
                                + addCustomerStateProvince.getValue().divisionName + ", "
                                + addCustomerCountry.getValue().countryName,
                        addCustomerZipCode.getText(),
                        addCustomerPhone.getText(),
                        dateTime,
                        currentUser,
                        dateTime,
                        currentUser,
                        addCustomerStateProvince.getValue().divisionId
                );

                addCustomer(newCustomer);
            }
            else {
                Customers newCustomer = new Customers(
                        allCustomers.size() + 1,
                        addCustomerName.getText(),
                        addCustomerAddress.getText() + ", "
                                + addCustomerBorough.getValue() + ", "
                                + addCustomerCity.getText() + ", "
                                + addCustomerStateProvince.getValue().divisionName + ", "
                                + addCustomerCountry.getValue().countryName,
                        addCustomerZipCode.getText(),
                        addCustomerPhone.getText(),
                        dateTime,
                        currentUser,
                        dateTime,
                        currentUser,
                        addCustomerStateProvince.getValue().divisionId
                );

                addCustomer(newCustomer);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @FXML
    public void countrySpecifier(){

        if(addCustomerCountry.getValue().toString().equals("United States")){
            addCustomerBorough.setVisible(false);
            addCustomerStateProvince.setItems(allUnitedStates);

        }
        else if(addCustomerCountry.getValue().toString().equals("Canada")){
            addCustomerBorough.setVisible(false);
            addCustomerStateProvince.setItems(allCanadianProvinces);

        }
        else if(addCustomerCountry.getValue().toString().equals("United Kingdom")){
            addCustomerBorough.setVisible(true);
            addCustomerStateProvince.setItems(allUnitedKingdomRegions);
            addCustomerBorough.setItems(allBoroughs);

        }
    }

    @FXML
    public void customerTableUpdating(MouseEvent event) throws IOException {
        customerNewData();
        saveButtonChangeScene(event);
    }

    public void saveButtonChangeScene(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(CustomerRecordsMainMenu.class.getResource("customer-records-main-menu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void cancelButtonChangeScene(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(CustomerRecordsMainMenu.class.getResource("customer-records-main-menu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerFieldSetup();
    }
}
