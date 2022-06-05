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

public class ModifyAppointment implements Initializable {

    @FXML
    TextField modifyAppointmentId;
    @FXML
    TextField modifyAppointmentTitle;
    @FXML
    TextField modifyAppointmentType;
    @FXML
    TextField modifyAppointmentLocation;
    @FXML
    TextField modifyAppointmentStart;
    @FXML
    TextField modifyAppointmentEnd;
    @FXML
    TextField modifyAppointmentTime;
    @FXML
    MenuButton modifyAppointmentContact;
    @FXML
    TextArea modifyAppointmentDescription;
    @FXML
    Button saveModifiedAppointmentButton;
    @FXML
    Button cancelModifiedAppointmentButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void appointmentDataToModifyFieldSetup(){

    }

    public void modifiedAppointmentRecords(){

    }

    public void updateAppointmentRecords(){

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
}
