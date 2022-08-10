package wgu.softwarejfx.software_2_fx_assignment;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_2_fx_assignment.Countries.*;
import static wgu.softwarejfx.software_2_fx_assignment.CustomerRecordsMainMenu.addCustomerButton;
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
    ComboBox<String> addCustomerStateProvince;
    @FXML
    ComboBox<String> addCustomerCountry;
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
        countrySpecifier();
    }

    public void customerNewData(){

        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.now();

            if (addCustomerName.getText() == null) {
                System.out.println("Error: CustomerName is Empty");

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
            }
            else if ((addCustomerAddress.getText().isEmpty() || addCustomerCity.getText().isEmpty())) {
                System.out.println("Error: One or More Address Fields are Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("One or More Address Fields are Empty");
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
            else if (addCustomerZipCode.getText().isEmpty()) {
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
            }
            else if (addCustomerPhone.getText().isEmpty()) {
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
            }
            else if (addCustomerBorough.getValue() == null){
                Customers newCustomer = new Customers(
                        allCustomers.size() + 1,
                        addCustomerName.getText(),
                        addCustomerAddress.getText() + ", "
                                + addCustomerCity.getText() + ", "
                                + addCustomerStateProvince.getValue() + ", "
                                + addCustomerCountry.getValue(),
                        addCustomerZipCode.getText(),
                        addCustomerPhone.getText(),
                        dateTime,
                        currentUser,
                        dateTime,
                        currentUser,
                        firstDivisionLookup(addCustomerStateProvince.getValue()).divisionId
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
                                + addCustomerStateProvince.getValue() + ", "
                                + addCustomerCountry.getValue(),
                        addCustomerZipCode.getText(),
                        addCustomerPhone.getText(),
                        dateTime,
                        currentUser,
                        dateTime,
                        currentUser,
                        firstDivisionLookup(addCustomerStateProvince.getValue()).divisionId
                );

                addCustomer(newCustomer);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
//    @FXML
    public void countrySpecifier(){

        addCustomerCountry.setItems(getAllCountryNames());
        addCustomerBorough.setVisible(false);

        addCustomerCountry.onActionProperty().addListener((observableValue, oldValue, newValue) -> {

//            addCustomerCountry.getSelectionModel().getSelectedItem()
            switch (newValue.toString()) {
                case "US" -> {
                    addCustomerBorough.setVisible(false);
                    addCustomerStateProvince.setItems(allStateNames);
                }
                case "Canada" -> {
                    addCustomerBorough.setVisible(false);
                    addCustomerStateProvince.setItems(allCanadianProvinceNames);
                }
                case "UK" -> {
                    addCustomerBorough.setVisible(true);
                    addCustomerStateProvince.setItems(allUKRegionNames);
                    addCustomerBorough.setItems(allBoroughs);
                }
            }
        });

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
