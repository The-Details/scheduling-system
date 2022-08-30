package wgu.softwarejfx.software_2_fx_assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_2_fx_assignment.Countries.*;
import static wgu.softwarejfx.software_2_fx_assignment.Customers.lookupCustomerById;
import static wgu.softwarejfx.software_2_fx_assignment.Customers.updateCustomer;
import static wgu.softwarejfx.software_2_fx_assignment.FirstLevelDivisions.*;
import static wgu.softwarejfx.software_2_fx_assignment.LoginController.currentUser;

/**
 * This class manipulates existing customer data
 */
public class ModifyCustomer implements Initializable {

    @FXML
    TextField modifyCustomerId;
    @FXML
    TextField modifyCustomerName;
    @FXML
    TextField modifyCustomerPhone;
    @FXML
    TextField modifyCustomerAddress;
    @FXML
    TextField modifyCustomerCity;
    @FXML
    ComboBox<String> modifyCustomerBorough;
    @FXML
    ComboBox<String> modifyCustomerStateProvince;
    @FXML
    ComboBox<String> modifyCustomerCountry;
    @FXML
    TextField modifyCustomerZipCode;
    @FXML
    Button saveModifiedCustomerButton;
    @FXML
    Button cancelModifiedCustomerButton;

    public static Customers currentlySelectedCustomer;

    /**
     * This method set up the customer form to update existing data
     */
    public void customerDataToModifyFieldSetup(){

        try {
            int customerId = currentlySelectedCustomer.getCustomerId();

            Customers dataToModify = lookupCustomerById(customerId);

            String fullAddress = dataToModify.getAddress();

            String[] splitFullAddress = fullAddress.split(",", 5);

            String streetAddress;
            String optionalBorough;
            String city;

            if (splitFullAddress.length == 1 ){
                streetAddress = splitFullAddress[0];

                if (customerId > 0) {
                    modifyCustomerId.setDisable(true);
                    modifyCustomerId.setText(String.valueOf(customerId));
                    modifyCustomerName.setText(dataToModify.getCustomerName());
                    modifyCustomerPhone.setText(dataToModify.getPhoneNumber());
                    modifyCustomerAddress.setText(streetAddress);
                    modifyCustomerZipCode.setText(dataToModify.getZipCode());
                } else {
                    GridPane conformation = new GridPane();
                    Text conformationInfo = new Text("Customer not selected");
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
            else if (splitFullAddress.length == 2){

                streetAddress = splitFullAddress[0];
                city = splitFullAddress[1];

                if (customerId > 0) {
                    modifyCustomerId.setDisable(true);
                    modifyCustomerId.setText(String.valueOf(customerId));
                    modifyCustomerName.setText(dataToModify.getCustomerName());
                    modifyCustomerPhone.setText(dataToModify.getPhoneNumber());
                    modifyCustomerAddress.setText(streetAddress);
                    modifyCustomerCity.setText(city);
                    modifyCustomerStateProvince.setValue(firstDivisionLookupById(dataToModify.getDivisionId()).divisionName);
                    modifyCustomerCountry.setValue(countryLookupById(firstDivisionLookupById(dataToModify.getDivisionId()).countryId).countryName);
                    modifyCustomerZipCode.setText(dataToModify.getZipCode());
                } else {
                    GridPane conformation = new GridPane();
                    Text conformationInfo = new Text("Customer not selected");
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
            else {
                streetAddress = splitFullAddress[0];
                optionalBorough = splitFullAddress[1];
                city = splitFullAddress[2];

                if (customerId > 0) {
                    modifyCustomerId.setDisable(true);
                    modifyCustomerId.setText(String.valueOf(customerId));
                    modifyCustomerName.setText(dataToModify.getCustomerName());
                    modifyCustomerPhone.setText(dataToModify.getPhoneNumber());
                    modifyCustomerAddress.setText(streetAddress);
                    modifyCustomerBorough.setValue(optionalBorough);
                    modifyCustomerCity.setText(city);
                    modifyCustomerStateProvince.setValue(firstDivisionLookupById(dataToModify.getDivisionId()).divisionName);
                    modifyCustomerCountry.setValue(countryLookupById(firstDivisionLookupById(dataToModify.getDivisionId()).countryId).countryName);
                    modifyCustomerZipCode.setText(dataToModify.getZipCode());
                } else {
                    GridPane conformation = new GridPane();
                    Text conformationInfo = new Text("Customer not selected");
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

            setAllBoroughs();
            firstDivisionFilter();
            countrySpecifier();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method collects updated customer data and spots errors in the data on submission
     */
    public void modifiedCustomerRecords(){

        try {

            if (modifyCustomerName.getText().isEmpty()) {
                System.out.println("Error: Customer Name is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Customer Name is Empty");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (modifyCustomerPhone.getText().isEmpty()) {
                System.out.println("Error: Phone Number is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Phone Number is Empty");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (modifyCustomerAddress.getText().isEmpty()) {
                System.out.println("Error: Address is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Address is Empty\");\n");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (modifyCustomerStateProvince.getValue() == null) {
                System.out.println("Error: State/Province is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("State/Province is Empty");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (modifyCustomerCountry.getValue() == null) {
                System.out.println("Error: Country is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Country is Empty");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (modifyCustomerZipCode.getText().isEmpty()) {
                System.out.println("Error: Zipcode is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Zipcode is Empty");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (modifyCustomerBorough.getValue() == null && !modifyCustomerCountry.getValue().equals("UK")){
                Customers modifiedCustomer = new Customers(
                        currentlySelectedCustomer.getCustomerId(),
                        currentlySelectedCustomer.getCustomerName(),
                        currentlySelectedCustomer.getAddress(),
                        currentlySelectedCustomer.getZipCode(),
                        currentlySelectedCustomer.getPhoneNumber(),
                        currentlySelectedCustomer.getCreateDate(),
                        currentlySelectedCustomer.getCreatedBy(),
                        currentlySelectedCustomer.getLastUpdate(),
                        currentlySelectedCustomer.getLastUpdateBy(),
                        currentlySelectedCustomer.getDivisionId());

                modifiedCustomer.setCustomerName(modifyCustomerName.getText());
                modifiedCustomer.setAddress(modifyCustomerAddress.getText() + ", "
                        + modifyCustomerCity.getText());
                modifiedCustomer.setZipCode(modifyCustomerZipCode.getText());
                modifiedCustomer.setPhoneNumber(modifyCustomerPhone.getText());
                modifiedCustomer.setLastUpdate(LocalDateTime.now());
                modifiedCustomer.setLastUpdateBy(currentUser);
                modifiedCustomer.setDivisionId(firstDivisionLookupName(modifyCustomerStateProvince.getValue()).divisionId);

                updateCustomer(Integer.parseInt(modifyCustomerId.getText()), modifiedCustomer);
            }
            else {
                Customers modifiedCustomer = new Customers(
                        currentlySelectedCustomer.getCustomerId(),
                        currentlySelectedCustomer.getCustomerName(),
                        currentlySelectedCustomer.getAddress(),
                        currentlySelectedCustomer.getZipCode(),
                        currentlySelectedCustomer.getPhoneNumber(),
                        currentlySelectedCustomer.getCreateDate(),
                        currentlySelectedCustomer.getCreatedBy(),
                        currentlySelectedCustomer.getLastUpdate(),
                        currentlySelectedCustomer.getLastUpdateBy(),
                        currentlySelectedCustomer.getDivisionId());

                modifiedCustomer.setCustomerName(modifyCustomerName.getText());
                modifiedCustomer.setAddress(modifyCustomerAddress.getText() + ", "
                        + modifyCustomerBorough.getValue() + ", "
                        + modifyCustomerCity.getText());
                modifiedCustomer.setZipCode(modifyCustomerZipCode.getText());
                modifiedCustomer.setPhoneNumber(modifyCustomerPhone.getText());
                modifiedCustomer.setLastUpdate(LocalDateTime.now());
                modifiedCustomer.setLastUpdateBy(currentUser);
                modifiedCustomer.setDivisionId(firstDivisionLookupName(modifyCustomerStateProvince.getValue()).divisionId);

                updateCustomer(Integer.parseInt(modifyCustomerId.getText()), modifiedCustomer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * LAMBDA JUSTIFICATION: The reason why a lambda expression is used in
     * this method is because it is unknown what the user will change and presenting every option available is not an option
     *
     * This method is used to determine which country in the add customer form has been selected to serve as the basis for the address
     *
     */
    public void countrySpecifier(){

        modifyCustomerCountry.setItems(getAllCountryNames());
        modifyCustomerBorough.setVisible(false);

        modifyCustomerCountry.addEventHandler(ActionEvent.ANY , e -> {

            switch (modifyCustomerCountry.getValue()) {
                case "U.S" -> {
                    modifyCustomerBorough.setVisible(false);
                    modifyCustomerStateProvince.setItems(getAllStateNames());
                }
                case "Canada" -> {
                    modifyCustomerBorough.setVisible(false);
                    modifyCustomerStateProvince.setItems(getAllCanadianProvinceNames());
                }
                case "UK" -> {
                    modifyCustomerBorough.setVisible(true);
                    modifyCustomerStateProvince.setItems(getAllUKRegionNames());
                    modifyCustomerBorough.setItems(allBoroughs);
                }
            }
        });

    }


    @FXML
    public void updateCustomerRecords(MouseEvent event) throws IOException{
        modifiedCustomerRecords();
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
        customerDataToModifyFieldSetup();
    }
}
