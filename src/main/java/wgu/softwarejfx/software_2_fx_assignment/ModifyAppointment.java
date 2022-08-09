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
    MenuButton modifyAppointmentContact;
    @FXML
    TextArea modifyAppointmentDescription;
    @FXML
    Button saveModifiedAppointmentButton;
    @FXML
    Button cancelModifiedAppointmentButton;

    public static Appointments currentlySelectedAppointment;
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

        try {
            if (currentlySelectedAppointment != null) {
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

    public void modifiedAppointmentRecords(){

        try {
            SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());

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
            } else if (modifyAppointmentContact.getText().isEmpty()) {
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
            } else if (Integer.parseInt(appointmentTimeConvertor(modifyAppointmentStartTime.getValue()).toString()) < 8 ||
                    Integer.parseInt(appointmentTimeConvertor(modifyAppointmentEndTime.getValue()).toString()) > 22) {
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
            }else if (appointmentConflictChecker(modifyAppointmentStart.getValue(), modifyAppointmentEnd.getValue(),
                    LocalTime.parse(modifyAppointmentStartTime.getValue()), LocalTime.parse(modifyAppointmentEndTime.getValue()))) {

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

            }else {

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
