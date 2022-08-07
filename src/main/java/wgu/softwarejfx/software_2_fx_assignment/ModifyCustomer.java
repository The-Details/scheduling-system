package wgu.softwarejfx.software_2_fx_assignment;

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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_2_fx_assignment.Customers.lookupCustomerById;
import static wgu.softwarejfx.software_2_fx_assignment.Customers.updateCustomer;
import static wgu.softwarejfx.software_2_fx_assignment.LoginController.currentUser;

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
    ComboBox<FirstLevelDivisions> modifyCustomerStateProvince;
    @FXML
    ComboBox<Countries> modifyCustomerCountry;
    @FXML
    TextField modifyCustomerZipCode;
    @FXML
    Button saveModifiedCustomerButton;
    @FXML
    Button cancelModifiedCustomerButton;

    public static Customers currentlySelectedCustomer;

    public void customerDataToModifyFieldSetup(){

        try {
            int customerId = currentlySelectedCustomer.getCustomerId();

            Customers dataToModify = lookupCustomerById(customerId);

            String fullAddress = dataToModify.getAddress();

            String[] splitFullAddress = fullAddress.split(",", 4);

            String streetAddress;
            String optionalBorough;
            String city;
            String stateProvince;
            String country;


            if (splitFullAddress[1] == null){
                streetAddress = splitFullAddress[0];
                city = splitFullAddress[2];
                stateProvince = splitFullAddress[3];
                country = splitFullAddress[4];

                if (currentlySelectedCustomer != null) {
                    modifyCustomerId.setDisable(true);
                    modifyCustomerId.setPromptText(String.valueOf(dataToModify.getCustomerId()));
                    modifyCustomerName.setText(dataToModify.getCustomerName());
                    modifyCustomerPhone.setText(dataToModify.getPhoneNumber());
                    modifyCustomerAddress.setText(streetAddress);
                    modifyCustomerCity.setText(city);
                    modifyCustomerStateProvince.setValue(FirstLevelDivisions.firstDivisionLookup(stateProvince));
                    modifyCustomerCountry.setValue(Countries.countryLookupByName(country));
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
                stateProvince = splitFullAddress[3];
                country = splitFullAddress[4];

                if (currentlySelectedCustomer != null) {
                    modifyCustomerId.setDisable(true);
                    modifyCustomerId.setPromptText(String.valueOf(dataToModify.getCustomerId()));
                    modifyCustomerName.setText(dataToModify.getCustomerName());
                    modifyCustomerPhone.setText(dataToModify.getPhoneNumber());
                    modifyCustomerAddress.setText(streetAddress);
                    modifyCustomerBorough.setValue(optionalBorough);
                    modifyCustomerCity.setText(city);
                    modifyCustomerStateProvince.setValue(FirstLevelDivisions.firstDivisionLookup(stateProvince));
                    modifyCustomerCountry.setValue(Countries.countryLookupByName(country));
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



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void modifiedCustomerRecords(){

        try {
            SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());

            if (modifyCustomerName.getText().isEmpty()) {
                System.out.println("Error: Customer Name is Empty");
            } else if (modifyCustomerPhone.getText().isEmpty()) {
                System.out.println("Error: Phone Number is Empty");
            } else if (modifyCustomerAddress.getText().isEmpty()) {
                System.out.println("Error: Address is Empty");
            } else if (modifyCustomerStateProvince.getValue() == null) {
                System.out.println("Error: State/Province is Empty");
            } else if (modifyCustomerCountry.getValue() == null) {
                System.out.println("Error: Country is Empty");
            } else if (modifyCustomerZipCode.getText().isEmpty()) {
                System.out.println("Error: Zipcode is Empty");
            } else {
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
                modifiedCustomer.setAddress(modifyCustomerAddress.getText() + "," + modifyCustomerStateProvince.getValue() + "," + modifyCustomerCountry.getValue());
                modifiedCustomer.setZipCode(modifyCustomerZipCode.getText());
                modifiedCustomer.setPhoneNumber(modifyCustomerPhone.getText());
                modifiedCustomer.setLastUpdate(LocalDateTime.parse(dateTimeFormatter.format(date)));
                modifiedCustomer.setLastUpdateBy(currentUser);

                updateCustomer(Integer.parseInt(modifyCustomerId.getText()), modifiedCustomer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
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
