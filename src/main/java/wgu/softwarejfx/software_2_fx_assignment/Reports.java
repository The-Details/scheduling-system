package wgu.softwarejfx.software_2_fx_assignment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static wgu.softwarejfx.software_2_fx_assignment.Appointments.*;
import static wgu.softwarejfx.software_2_fx_assignment.Report.generateReportData;


public class Reports implements Initializable {

    @FXML
    TableView<Report> contactAssociatedAppointmentsTableView;
    @FXML
    TableColumn<Report, Integer> contactIdCol;
    @FXML
    TableColumn<Report, String> contactNameCol;
    @FXML
    TableColumn<Report, String> contactEmailCol;
    @FXML
    TableColumn<Report, Integer> contactAppointmentCountCol;
    @FXML
    TableColumn<Report, Integer> contactAssociatedAppointmentCol;
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
//
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reportSetup();
    }

}
