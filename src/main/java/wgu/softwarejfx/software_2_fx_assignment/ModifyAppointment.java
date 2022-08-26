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
import static wgu.softwarejfx.software_2_fx_assignment.Appointments.*;
import static wgu.softwarejfx.software_2_fx_assignment.Appointments.appointmentTimes;
import static wgu.softwarejfx.software_2_fx_assignment.Contacts.*;
import static wgu.softwarejfx.software_2_fx_assignment.Contacts.getAllContactEmails;
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
    ComboBox<String> modifyAppointmentStartTime;
    @FXML
    ComboBox<String> modifyAppointmentEndTime;
    @FXML
    ComboBox<String> modifyAppointmentContactName;
    @FXML
    ComboBox<String> modifyAppointmentContactEmail;
    @FXML
    TextArea modifyAppointmentDescription;
    @FXML
    Button saveModifiedAppointmentButton;
    @FXML
    Button cancelModifiedAppointmentButton;

    /**
     * This class manipulates existing appointment data
     */
    public static Appointments currentlySelectedAppointment;

    /**
     * This method set up the appointment form to update existing data
     */
    public void appointmentDataToModifyFieldSetup(){

        appointmentTimes.addAll("12:00AM",
                "1:00AM",
                "2:00AM",
                "3:00AM",
                "4:00AM",
                "5:00AM",
                "6:00AM",
                "7:00AM",
                "8:00AM",
                "9:00AM",
                "10:00AM",
                "11:00AM",
                "12:00PM",
                "1:00PM",
                "2:00PM",
                "3:00PM",
                "4:00PM",
                "5:00PM",
                "6:00PM",
                "7:00PM",
                "8:00PM",
                "9:00PM",
                "10:00PM",
                "11:00PM"
        );
        modifyAppointmentStartTime.setItems(appointmentTimes);
        modifyAppointmentEndTime.setItems(appointmentTimes);
        modifyAppointmentContactName.setItems(getAllContactNames());
        modifyAppointmentContactEmail.setItems(getAllContactEmails());

        try {
            if (currentlySelectedAppointment != null) {
                modifyAppointmentId.setDisable(true);
                modifyAppointmentId.setText(String.valueOf(currentlySelectedAppointment.getAppointmentId()));
                modifyAppointmentTitle.setText(currentlySelectedAppointment.getTitle());
                modifyAppointmentType.setText(currentlySelectedAppointment.getType());
                modifyAppointmentLocation.setText(currentlySelectedAppointment.getLocation());
                modifyAppointmentStart.setValue(currentlySelectedAppointment.getStart().toLocalDate());
                modifyAppointmentEnd.setValue(currentlySelectedAppointment.getStart().toLocalDate());
                modifyAppointmentStartTime.setValue(appointmentTimeReverser(currentlySelectedAppointment.getStart().toLocalTime().toString()));
                modifyAppointmentEndTime.setValue(appointmentTimeReverser(currentlySelectedAppointment.getEnd().toLocalTime().toString()));
                modifyAppointmentContactName.setValue(lookupContactById(currentlySelectedAppointment.getContactId()).contactName);
                modifyAppointmentContactEmail.setValue(lookupContactById(currentlySelectedAppointment.getContactId()).email);
                modifyAppointmentDescription.setText(currentlySelectedAppointment.getDescription());
            } else {
                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Appointment not selected");
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
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method collects updated appointment data and spots errors in the data on submission
     */
    public void modifiedAppointmentRecords(){

        try {

            String[] startTimeSplitter = appointmentTimeConvertor(modifyAppointmentStartTime.getValue()).toString().split(":", 2);
            String[] endTimeSplitter = appointmentTimeConvertor(modifyAppointmentEndTime.getValue()).toString().split(":", 2);

            if (modifyAppointmentTitle.getText().isEmpty()) {
                System.out.println("Error: Title is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Title is Empty");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (modifyAppointmentType.getText().isEmpty()) {
                System.out.println("Error: Type is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Type is Empty");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (modifyAppointmentLocation.getText().isEmpty()) {
                System.out.println("Error: Location is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Location is Empty");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (modifyAppointmentStart.getValue() == null) {
                System.out.println("Error: Start Date is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Start Date is Empty");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (modifyAppointmentEnd.getValue() == null) {
                System.out.println("Error: End Date is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("End Date is Empty");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (modifyAppointmentStartTime.getValue() == null ||
                    modifyAppointmentEndTime.getValue() == null) {
                System.out.println("Error: Start and/or End Time is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Start and/or End Time is Empty");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (modifyAppointmentContactName.getEditor().getText().isEmpty() || modifyAppointmentContactEmail.getEditor().getText().isEmpty()) {
                System.out.println("Error: Contact Info is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Contact Info is Empty");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (modifyAppointmentDescription.getText().isEmpty()) {
                System.out.println("Error: Description is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Description is Empty");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (Integer.parseInt(startTimeSplitter[0]) < 8 ||
                    Integer.parseInt(endTimeSplitter[0]) > 22) {
                System.out.println("Error: Start and/or End Time is Outside of Applicable Range");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Start and/or End Time is Outside of Applicable Range");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            }else if (appointmentConflictChecker(modifyAppointmentId.getText(), modifyAppointmentStart.getValue(), modifyAppointmentEnd.getValue(),
                    appointmentTimeConvertor(modifyAppointmentStartTime.getValue()), appointmentTimeConvertor(modifyAppointmentEndTime.getValue()))) {

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Conflict with Appointment Scheduled Time");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();

            } else if (LocalTime.parse(appointmentTimeConvertor(modifyAppointmentStartTime.getValue()).toString()).getHour() < 8
                    || LocalTime.parse(appointmentTimeConvertor(modifyAppointmentEndTime.getValue()).toString()).getHour() > 22) {

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Conflict with Appointment Scheduled Outside of Business Hours: 8:00AM - 10:00PM");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();

            } else {

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
                selectedAppointment.setStart(LocalDateTime.of(modifyAppointmentStart.getValue(), appointmentTimeConvertor(modifyAppointmentStartTime.getValue())));
                selectedAppointment.setEnd(LocalDateTime.of(modifyAppointmentEnd.getValue(), appointmentTimeConvertor(modifyAppointmentEndTime.getValue())));
                selectedAppointment.setLast_update(LocalDateTime.now());
                selectedAppointment.setLastUpdateBy(currentUser);
                selectedAppointment.setContactId(lookupContactByName(modifyAppointmentContactName.getEditor().getText()).contactId);

                updateAppointment(Integer.parseInt(modifyAppointmentId.getText()), selectedAppointment);
            }
        }catch (Exception e){
            e.printStackTrace();
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
