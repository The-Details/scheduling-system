package wgu.softwarejfx.software_2_fx_assignment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

import static wgu.softwarejfx.software_2_fx_assignment.Appointments.*;
import static wgu.softwarejfx.software_2_fx_assignment.LoginController.currentUser;

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
    DatePicker addAppointmentStart;
    @FXML
    DatePicker addAppointmentEnd;
    @FXML
    ComboBox<LocalTime> addAppointmentStartTime;
    @FXML
    ComboBox<LocalTime> addAppointmentEndTime;
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

        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        LocalDateTime appointmentStart = LocalDateTime.of(addAppointmentStart.getValue(), addAppointmentStartTime.getValue());
        LocalDateTime appointmentEnd = LocalDateTime.of(addAppointmentEnd.getValue(), addAppointmentEndTime.getValue());

        if (addAppointmentTitle.getText().isEmpty()){
            System.out.println("Error: Title is Empty");
        }
        else if (addAppointmentType.getText().isEmpty()){
            System.out.println("Error: Type is Empty");
        }
        else if (addAppointmentLocation.getText().isEmpty()) {
            System.out.println("Error: Location is Empty");
        }
        else if (addAppointmentStart.getValue() == null) {
            System.out.println("Error: Start Date is Empty");
        }
        else if (addAppointmentEnd.getValue() == null){
            System.out.println("Error: End Date is Empty");
        }
        else if (addAppointmentStartTime.getValue() == null ||
                addAppointmentEndTime.getValue() == null) {
            System.out.println("Error: Start and/or End Time is Empty");
        }
        else if (addAppointmentContact.getText().isEmpty()) {
            System.out.println("Error: Contact is Empty");
        }
        else if (addAppointmentDescription.getText().isEmpty()) {
            System.out.println("Error: Description is Empty");
        }
        else {
            Appointments newAppointment = new Appointments(
                 allAppointments.size() + 1,
                    addAppointmentTitle.getText(),
                    addAppointmentDescription.getText(),
                    addAppointmentLocation.getText(),
                    addAppointmentType.getText(),
                    appointmentStart,
                    appointmentEnd,
                    LocalDateTime.parse(dateTimeFormatter.format(date)),
                    currentUser,
                    LocalDateTime.parse(dateTimeFormatter.format(date)),
                    currentUser,
                    0,
                    0,
                    0
            );

            addAppointment(newAppointment);
            appointmentFilter();
        }
    }

    @FXML
    public void customerRecordUpdating(MouseEvent event) throws IOException {
        appointmentNewData();
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
        appointmentFieldSetup();
    }
}
