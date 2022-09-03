package wgu.softwarejfx.software_2_fx_assignment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.ResourceBundle;

import static wgu.softwarejfx.software_2_fx_assignment.Appointments.*;
import static wgu.softwarejfx.software_2_fx_assignment.Contacts.contactExistenceChecker;
import static wgu.softwarejfx.software_2_fx_assignment.Contacts.findAssociatedAppointments;



public class Reports implements Initializable {


    @FXML
    ComboBox<String> contactName;
    @FXML
    ComboBox<String> contactEmail;
    @FXML
    TextField contactId;
    @FXML
    TableView<Appointments> contactAssociatedAppointmentsTableView;
    @FXML
    TableColumn<Appointments, Integer> appointmentId;
    @FXML
    TableColumn<Appointments, String> appointmentTitle;
    @FXML
    TableColumn<Appointments, String> appointmentType;
    @FXML
    TableColumn<Appointments, String> appointmentDescription;
    @FXML
    TableColumn<Appointments, LocalDateTime> appointmentStart;
    @FXML
    TableColumn<Appointments, LocalDateTime> appointmentEnd;
    @FXML
    TableColumn<Appointments, Integer> appointmentCustomerId;


    @FXML
    Label janTypes;
    @FXML
    Label febTypes;
    @FXML
    Label marTypes;
    @FXML
    Label aprTypes;
    @FXML
    Label mayTypes;
    @FXML
    Label junTypes;
    @FXML
    Label julTypes;
    @FXML
    Label augTypes;
    @FXML
    Label sepTypes;
    @FXML
    Label octTypes;
    @FXML
    Label novTypes;
    @FXML
    Label decTypes;
    @FXML
    Label janCount;
    @FXML
    Label febCount;
    @FXML
    Label marCount;
    @FXML
    Label aprCount;
    @FXML
    Label mayCount;
    @FXML
    Label junCount;
    @FXML
    Label julCount;
    @FXML
    Label augCount;
    @FXML
    Label sepCount;
    @FXML
    Label octCount;
    @FXML
    Label novCount;
    @FXML
    Label decCount;


    public void reportSetup() throws SQLException {

        contactName.getEditor().textProperty().addListener((obs, oldText, newText) -> contactName.setValue(newText));

        contactEmail.getEditor().textProperty().addListener((obs, oldText, newText) -> contactEmail.setValue(newText));

        contactId.setDisable(true);
        contactId.setText(String.valueOf(contactExistenceChecker(contactName.getValue(), contactEmail.getValue()).contactId));

        contactAssociatedAppointmentsTableView.setItems(findAssociatedAppointments(contactExistenceChecker(contactName.getValue(), contactEmail.getValue())));
        appointmentTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        appointmentType.setCellValueFactory(new PropertyValueFactory<>("type"));
        appointmentDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        appointmentStart.setCellValueFactory(new PropertyValueFactory<>("start"));
        appointmentEnd.setCellValueFactory(new PropertyValueFactory<>("end"));
        appointmentCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));


        appointmentTotalDataByMonth();

        janTypes.setText(janTypesList.toString());
        febTypes.setText(febTypesList.toString());
        marTypes.setText(marTypesList.toString());
        aprTypes.setText(aprTypesList.toString());
        mayTypes.setText(mayTypesList.toString());
        junTypes.setText(junTypesList.toString());
        julTypes.setText(julTypesList.toString());
        augTypes.setText(augTypesList.toString());
        sepTypes.setText(sepTypesList.toString());
        octTypes.setText(octTypesList.toString());
        novTypes.setText(novTypesList.toString());
        decTypes.setText(decTypesList.toString());

        janCount.setText(String.valueOf(januaryAppointments.size()));
        febCount.setText(String.valueOf(februaryAppointments.size()));
        marCount.setText(String.valueOf(marchAppointments.size()));
        aprCount.setText(String.valueOf(aprilAppointments.size()));
        mayCount.setText(String.valueOf(mayAppointments.size()));
        junCount.setText(String.valueOf(juneAppointments.size()));
        julCount.setText(String.valueOf(julyAppointments.size()));
        augCount.setText(String.valueOf(augustAppointments.size()));
        sepCount.setText(String.valueOf(septemberAppointments.size()));
        octCount.setText(String.valueOf(octoberAppointments.size()));
        novCount.setText(String.valueOf(novemberAppointments.size()));
        decCount.setText(String.valueOf(decemberAppointments.size()));

    }


    @FXML
    public void backButtonChangeScene(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(CustomerRecordsMainMenu.class.getResource("customer-records-main-menu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            reportSetup();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
