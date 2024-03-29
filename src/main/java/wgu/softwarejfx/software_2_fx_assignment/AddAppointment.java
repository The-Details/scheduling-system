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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_2_fx_assignment.Appointments.*;
import static wgu.softwarejfx.software_2_fx_assignment.Contacts.*;
import static wgu.softwarejfx.software_2_fx_assignment.LoginController.currentUser;
import static wgu.softwarejfx.software_2_fx_assignment.LoginController.currentUserId;
import static wgu.softwarejfx.software_2_fx_assignment.ModifyCustomer.currentlySelectedCustomer;

/**
 * This class manipulates new appointment data
 */
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
    ComboBox<String> addAppointmentStartTime;
    @FXML
    ComboBox<String> addAppointmentEndTime;
    @FXML
    ComboBox<String> addAppointmentContactName;
    @FXML
    ComboBox<String> addAppointmentContactEmail;
    @FXML
    TextArea addAppointmentDescription;
    @FXML
    Button saveNewAppointmentButton;
    @FXML
    Button cancelNewAppointmentButton;


    /**
     * This method set up the appointment form to collect new data
     */
    public void appointmentFieldSetup(){
        addAppointmentId.setDisable(true);
        addAppointmentId.setPromptText("Auto Generated");
        setAppointmentTimes();
        addAppointmentStartTime.setItems(appointmentTimes);
        addAppointmentEndTime.setItems(appointmentTimes);
        addAppointmentContactName.setItems(getAllContactNames());
        addAppointmentContactEmail.setItems(getAllContactEmails());

        addAppointmentContactName.getEditor().textProperty().addListener((obs, oldText, newText) -> addAppointmentContactName.setValue(newText));

        addAppointmentContactEmail.getEditor().textProperty().addListener((obs, oldText, newText) -> addAppointmentContactEmail.setValue(newText));
    }

    /**
     * This method collects new appointment data and spots errors in the data on submission
     */
    public void appointmentNewData(){

        try {

            LocalDateTime appointmentStart = LocalDateTime.of(addAppointmentStart.getValue(), LocalTime.parse(appointmentTimeConvertor(addAppointmentStartTime.getValue()).toString()));
            LocalDateTime appointmentEnd = LocalDateTime.of(addAppointmentEnd.getValue(), LocalTime.parse(appointmentTimeConvertor(addAppointmentEndTime.getValue()).toString()));

            if (addAppointmentTitle.getText().isEmpty()) {
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
            } else if (addAppointmentType.getText().isEmpty()) {
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
            } else if (addAppointmentLocation.getText().isEmpty()) {
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
            } else if (addAppointmentStart.getValue() == null) {
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
            } else if (addAppointmentEnd.getValue() == null) {
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
            } else if (addAppointmentStartTime.getValue() == null ||
                    addAppointmentEndTime.getValue() == null) {
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
            } else if (addAppointmentContactName.getValue().isEmpty() || addAppointmentContactEmail.getValue().isEmpty()) {
                System.out.println("Error: Contact is Empty");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Contact is Empty");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Error");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            } else if (addAppointmentDescription.getText().isEmpty()) {
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
            } else if (appointmentConflictChecker(addAppointmentStart.getValue(), addAppointmentEnd.getValue(),
                    LocalTime.parse(appointmentTimeConvertor(addAppointmentStartTime.getValue()).toString()), LocalTime.parse(appointmentTimeConvertor(addAppointmentEndTime.getValue()).toString()))) {

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

            } else if (LocalTime.parse(appointmentTimeConvertor(addAppointmentStartTime.getValue()).toString()).getHour() < 8
                    || LocalTime.parse(appointmentTimeConvertor(addAppointmentEndTime.getValue()).toString()).getHour() > 22) {

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
                Appointments newAppointment = new Appointments(
                        allAppointments.size() + 1,
                        addAppointmentTitle.getText(),
                        addAppointmentDescription.getText(),
                        addAppointmentLocation.getText(),
                        addAppointmentType.getText(),
                        appointmentStart,
                        appointmentEnd,
                        LocalDateTime.now(),
                        currentUser,
                        LocalDateTime.now(),
                        currentUser,
                        currentlySelectedCustomer.getCustomerId(),
                        currentUserId,
                        contactExistenceChecker(addAppointmentContactName.getValue(), addAppointmentContactEmail.getValue()).contactId
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
