package wgu.softwarejfx.software_2_fx_assignment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_2_fx_assignment.Appointments.appointmentFilter;
import static wgu.softwarejfx.software_2_fx_assignment.Appointments.updateAppointment;
import static wgu.softwarejfx.software_2_fx_assignment.LoginController.currentUser;

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
    DatePicker modifyAppointmentStart;
    @FXML
    DatePicker modifyAppointmentEnd;
    @FXML
    ComboBox<LocalTime> modifyAppointmentStartTime;
    @FXML
    ComboBox<LocalTime> modifyAppointmentEndTime;
    @FXML
    MenuButton modifyAppointmentContact;
    @FXML
    TextArea modifyAppointmentDescription;
    @FXML
    Button saveModifiedAppointmentButton;
    @FXML
    Button cancelModifiedAppointmentButton;

    public static Appointments currentlySelectedAppointment;
    public void appointmentDataToModifyFieldSetup(){
        if(currentlySelectedAppointment != null){
            modifyAppointmentId.setDisable(true);
            modifyAppointmentId.setPromptText(String.valueOf(currentlySelectedAppointment.getAppointmentId()));
            modifyAppointmentTitle.setText(currentlySelectedAppointment.getTitle());
            modifyAppointmentType.setText(currentlySelectedAppointment.getType());
            modifyAppointmentLocation.setText(currentlySelectedAppointment.getLocation());
            modifyAppointmentStart.setPromptText("");
            modifyAppointmentEnd.setPromptText("");
            modifyAppointmentStartTime.setPromptText("");
            modifyAppointmentEndTime.setPromptText("");
            modifyAppointmentContact.setText(String.valueOf(currentlySelectedAppointment.getContactId()));
            modifyAppointmentDescription.setText(currentlySelectedAppointment.getDescription());
        }
        else{
            GridPane conformation = new GridPane();
            Text conformationInfo = new Text("Appointment not selected");
            conformationInfo.setFont(new Font(20));
            conformation.getChildren().add(conformationInfo);
            GridPane.setConstraints(conformationInfo, 0,0,1,1,CENTER, VPos.CENTER, Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
            Stage popUp = new Stage();
            Scene conformationScene = new Scene(conformation);
            popUp.setTitle("Error");
            popUp.setScene(conformationScene);
            popUp.sizeToScene();
            popUp.show();
        }
    }

    public void modifiedAppointmentRecords(){

        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        if (modifyAppointmentTitle.getText().isEmpty()){
            System.out.println("Error: Title is Empty");
        }
        else if (modifyAppointmentType.getText().isEmpty()){
            System.out.println("Error: Type is Empty");
        }
        else if (modifyAppointmentLocation.getText().isEmpty()) {
            System.out.println("Error: Location is Empty");
        }
        else if (modifyAppointmentStart.getValue() == null) {
            System.out.println("Error: Start Date is Empty");
        }
        else if (modifyAppointmentEnd.getValue() == null){
            System.out.println("Error: End Date is Empty");
        }
        else if (modifyAppointmentStartTime == null ||
                modifyAppointmentEndTime.getValue() == null) {
            System.out.println("Error: Start and/or End Time is Empty");
        }
        else if (modifyAppointmentContact.getText().isEmpty()) {
            System.out.println("Error: Contact is Empty");
        }
        else if (modifyAppointmentDescription.getText().isEmpty()) {
            System.out.println("Error: Description is Empty");
        }
        else {

            Appointments selectedAppointment = new Appointments(
                    currentlySelectedAppointment.getAppointmentId(),
                    currentlySelectedAppointment.getTitle(),
                    currentlySelectedAppointment.getDescription(),
                    currentlySelectedAppointment.getLocation(),
                    currentlySelectedAppointment.getType(),
                    currentlySelectedAppointment.getStart(),
                    currentlySelectedAppointment.getEnd(),
                    currentlySelectedAppointment.getCreateDate(),
                    currentlySelectedAppointment.getCreatedBy(),
                    currentlySelectedAppointment.getLast_update(),
                    currentlySelectedAppointment.getLastUpdateBy(),
                    currentlySelectedAppointment.getCustomerId(),
                    currentlySelectedAppointment.getUserId(),
                    currentlySelectedAppointment.getContactId()
            );

                selectedAppointment.setTitle(modifyAppointmentTitle.getText());
                selectedAppointment.setDescription(modifyAppointmentDescription.getText());
                selectedAppointment.setLocation(modifyAppointmentLocation.getText());
                selectedAppointment.setType(modifyAppointmentType.getText());
                selectedAppointment.setStart(LocalDateTime.from(modifyAppointmentStart.getValue()));
                selectedAppointment.setEnd(LocalDateTime.from(modifyAppointmentEnd.getValue()));
                selectedAppointment.setLast_update(LocalDateTime.parse(dateTimeFormatter.format(date)));
                selectedAppointment.setLastUpdateBy(currentUser);
                selectedAppointment.setContactId(Integer.parseInt(modifyAppointmentContact.getText()));

            updateAppointment(Integer.parseInt(modifyAppointmentId.getText()), selectedAppointment);
            appointmentFilter();
        }
    }

    @FXML
    public void updateAppointmentRecords(MouseEvent event) throws IOException{
        modifiedAppointmentRecords();
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
appointmentDataToModifyFieldSetup();
    }
}
