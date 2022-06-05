package wgu.softwarejfx.software_2_fx_assignment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AddAppointment implements Initializable {

    @FXML
    TextField addAppointmentId;
    @FXML
    TextField addAppointmentTitle;
    @FXML
    TextField addAppointmentType;
    @FXML
    TextField addAppointmentLocation;
    @FXML
    TextField addAppointmentStart;
    @FXML
    TextField addAppointmentEnd;
    @FXML
    TextField addAppointmentTime;
    @FXML
    MenuButton addAppointmentContact;
    @FXML
    TextArea addAppointmentDescription;
    @FXML
    Button saveNewAppointmentButton;
    @FXML
    Button cancelNewAppointmentButton;


    public void appointmentFieldSetup(){
        addAppointmentId.setDisable(true);
        addAppointmentId.setPromptText("Auto Generated");
    }

    public void appointmentNewData(){

    }

    @FXML
    public void customerRecordUpdating(){

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
        appointmentFieldSetup();
    }
}
