package wgu.softwarejfx.software_2_fx_assignment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static wgu.softwarejfx.software_2_fx_assignment.Customers.lookupCustomerById;

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
    TextField modifyCustomerStateProvince;
    @FXML
    TextField modifyCustomerCountry;
    @FXML
    TextField modifyCustomerZipCode;
    @FXML
    Button saveModifiedCustomerButton;
    @FXML
    Button cancelModifiedCustomerButton;

    public void customerDataToModifyFieldSetup(int customerId){

        Customers dataToModify = lookupCustomerById(customerId);

        if(modifyCustomerId.getText() == null) {
            modifyCustomerId.setText("");
            modifyCustomerName.setText("");
            modifyCustomerPhone.setText("");
            modifyCustomerAddress.setText("");
            modifyCustomerStateProvince.setText("");
            modifyCustomerCountry.setText("");
            modifyCustomerZipCode.setText("");
        }
        else{
            modifyCustomerId.setText(String.valueOf(dataToModify.getCustomerId()));
            modifyCustomerName.setText(dataToModify.getCustomerName());
            modifyCustomerPhone.setText(dataToModify.getPhoneNumber());
            modifyCustomerAddress.setText(dataToModify.getAddress());
            modifyCustomerStateProvince.setText(dataToModify);
            modifyCustomerCountry.setText(dataToModify.get);
            modifyCustomerZipCode.setText(dataToModify.getZipCode());
        }
    }

    public void modifiedCustomerRecords(){

    }

    public void updateCustomerRecords(){

    }

    public void saveButtonChangeScene(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(CustomerRecordsMainMenu.class.getResource("customer-records-main-menu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void cancelButtonChangeScene(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(CustomerRecordsMainMenu.class.getResource("customer-records-main-menu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
