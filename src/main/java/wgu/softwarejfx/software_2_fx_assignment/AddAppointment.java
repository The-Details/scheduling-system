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
import static wgu.softwarejfx.software_2_fx_assignment.Contacts.newContact;
import static wgu.softwarejfx.software_2_fx_assignment.LoginController.currentUser;
import static wgu.softwarejfx.software_2_fx_assignment.LoginController.currentUserId;
import static wgu.softwarejfx.software_2_fx_assignment.ModifyCustomer.currentlySelectedCustomer;

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
    TextField addAppointmentContactName;
    @FXML
    TextField addAppointmentContactEmail;
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

        try {
            SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());

            LocalDateTime appointmentStart = LocalDateTime.of(addAppointmentStart.getValue(), addAppointmentStartTime.getValue());
            LocalDateTime appointmentEnd = LocalDateTime.of(addAppointmentEnd.getValue(), addAppointmentEndTime.getValue());

            if (addAppointmentTitle.getText().isEmpty()) {
                System.out.println("Error: Title is Empty");
            } else if (addAppointmentType.getText().isEmpty()) {
                System.out.println("Error: Type is Empty");
            } else if (addAppointmentLocation.getText().isEmpty()) {
                System.out.println("Error: Location is Empty");
            } else if (addAppointmentStart.getValue() == null) {
                System.out.println("Error: Start Date is Empty");
            } else if (addAppointmentEnd.getValue() == null) {
                System.out.println("Error: End Date is Empty");
            } else if (addAppointmentStartTime.getValue() == null ||
                    addAppointmentEndTime.getValue() == null) {
                System.out.println("Error: Start and/or End Time is Empty");
            } else if (addAppointmentContactName.getText().isEmpty() || addAppointmentContactEmail.getText().isEmpty()) {
                System.out.println("Error: Contact is Empty");
            } else if (addAppointmentDescription.getText().isEmpty()) {
                System.out.println("Error: Description is Empty");
            } else {
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
                        currentlySelectedCustomer.getCustomerId(),
                        currentUserId,
                        newContact(addAppointmentContactName.getText(), addAppointmentContactEmail.getText()).contactId
                );

                addAppointment(newAppointment);
                appointmentFilter();
            }
        }catch (Exception e){
            e.printStackTrace();
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
