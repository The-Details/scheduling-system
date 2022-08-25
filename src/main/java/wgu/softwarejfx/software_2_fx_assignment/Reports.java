package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static wgu.softwarejfx.software_2_fx_assignment.Appointments.*;
import static wgu.softwarejfx.software_2_fx_assignment.Contacts.allContacts;
import static wgu.softwarejfx.software_2_fx_assignment.Contacts.getAssociatedAppointments;

public class Reports implements Initializable {

    @FXML
    TableView<Reports> contactAssociatedAppointmentsTableView;
    @FXML
    TableColumn<Reports, Integer> contactIdCol;
    @FXML
    TableColumn<Reports, String> contactNameCol;
    @FXML
    TableColumn<Reports, String> contactEmailCol;
    @FXML
    TableColumn<Reports, Integer> contactAppointmentCountCol;
    @FXML
    TableColumn<Reports, Integer> contactAssociatedAppointmentCol;
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

    int contactId;
    String contactName;
    String contactEmail;
    int appointmentCount;
    ObservableList<Integer> associatedAppointments;


    Reports(int contactId, String contactName, String email, int appointmentCount, ObservableList<Integer> associatedAppointments){
        this.contactId = contactId;
        this.contactName = contactName;
        this.contactEmail = email;
        this.appointmentCount = appointmentCount;
        this.associatedAppointments = associatedAppointments;
    }


    public ObservableList<Reports> generateReportData(){

        ObservableList<Reports> newContactReportData = FXCollections.observableArrayList();

        for(Contacts contactCage : allContacts){
            if(!newContactReportData.contains(new Reports(contactCage.contactId,
                    contactCage.contactName, contactCage.email,
                    getAssociatedAppointments(contactCage).size(), getAssociatedAppointments(contactCage)))){

                newContactReportData.add(new Reports(contactCage.contactId,
                        contactCage.contactName, contactCage.email,
                        getAssociatedAppointments(contactCage).size(), getAssociatedAppointments(contactCage)));
            }
        }

        return newContactReportData;
    }


    public void reportSetup() {

        contactAssociatedAppointmentsTableView.setItems(generateReportData());
        contactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        contactNameCol.setCellValueFactory(new PropertyValueFactory<>("contactName"));
        contactEmailCol.setCellValueFactory(new PropertyValueFactory<>("contactEmail"));
        contactAppointmentCountCol.setCellValueFactory(new PropertyValueFactory<>("appointmentCount"));
        contactAssociatedAppointmentCol.setCellValueFactory(new PropertyValueFactory<>("associatedAppointments"));

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

        janCount.setText(janCustomerAppointments);
        febCount.setText(febCustomerAppointments);
        marCount.setText(marCustomerAppointments);
        aprCount.setText(aprCustomerAppointments);
        mayCount.setText(mayCustomerAppointments);
        junCount.setText(junCustomerAppointments);
        julCount.setText(julCustomerAppointments);
        augCount.setText(augCustomerAppointments);
        sepCount.setText(sepCustomerAppointments);
        octCount.setText(octCustomerAppointments);
        novCount.setText(novCustomerAppointments);
        decCount.setText(decCustomerAppointments);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reportSetup();
    }

}
