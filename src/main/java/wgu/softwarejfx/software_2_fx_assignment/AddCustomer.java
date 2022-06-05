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
    TextField addCustomerStateProvince;
    @FXML
    TextField addCustomerCountry;
    @FXML
    TextField addCustomerZipCode;
    @FXML
    Button saveNewCustomerButton;
    @FXML
    Button cancelNewCustomerButton;

    public void customerFieldSetup(){
        addCustomerId.setDisable(true);
        addCustomerId.setPromptText("Auto Generated");
    }

    public void customerNewData(){

    }

    @FXML
    public void customerTableUpdating(MouseEvent event){

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
