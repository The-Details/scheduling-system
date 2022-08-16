package wgu.softwarejfx.software_2_fx_assignment;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_2_fx_assignment.Appointments.*;
import static wgu.softwarejfx.software_2_fx_assignment.Customers.allCustomers;
import static wgu.softwarejfx.software_2_fx_assignment.Customers.deleteCustomer;
import static wgu.softwarejfx.software_2_fx_assignment.ModifyAppointment.currentlySelectedAppointment;
import static wgu.softwarejfx.software_2_fx_assignment.ModifyCustomer.currentlySelectedCustomer;
import static wgu.softwarejfx.software_2_fx_assignment.SchedulingSystem.closeConnection;

public class CustomerRecordsMainMenu implements Initializable {

    @FXML
    TextField customerSearchBar;
    @FXML
    TextField appointmentSearchBar;

    @FXML
    Button addAppointmentButton;
    @FXML
    Button addCustomerButton;
    @FXML
    Button modifyCustomerButton;
    @FXML
    Button deleteCustomerButton;
    @FXML
    RadioButton appointmentsByMonthButton;
    @FXML
    RadioButton appointmentsByWeekButton;
    @FXML
    Button modifyAppointmentsButton;
    @FXML
    Button deleteAppointmentsButton;
    @FXML
    Button exitCustomerRecordsButton;

    @FXML
    Button appointmentTotalData;

    @FXML
    TableView<Customers> customersTableView;
    @FXML
    TableColumn<Customers, Integer> customersIdCol;
    @FXML
    TableColumn<Customers, String> customersNameCol;
    @FXML
    TableColumn<Customers, String> customersPhoneCol;
    @FXML
    TableColumn<Customers, String> customersAddressCol;
    @FXML
    TableColumn<Customers, String> customersZipCodeCol;

    @FXML
    TabPane appointmentsByMonthTabPane;

    @FXML
    Tab januaryTabByMonthTabPane;
    @FXML
    TableView<Appointments> januaryTabByMonthTableView;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentIdCol;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentCustomerIdCol;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentTypeCol;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentTitleCol;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentLocationCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> januaryAppointmentStartCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> januaryAppointmentEndCol;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentContactIdCol;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentUserIdCol;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentDescriptionCol;

    @FXML
    Tab februaryTabByMonthTabPane;
    @FXML
    TableView<Appointments> februaryTabByMonthTableView;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentIdCol;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentCustomerIdCol;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentTypeCol;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentTitleCol;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentLocationCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> februaryAppointmentStartCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> februaryAppointmentEndCol;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentContactIdCol;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentUserIdCol;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentDescriptionCol;

    @FXML
    Tab marchTabByMonthTabPane;
    @FXML
    TableView<Appointments> marchTabByMonthTableView;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentIdCol;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentCustomerIdCol;
    @FXML
    TableColumn<Appointments, String> marchAppointmentTypeCol;
    @FXML
    TableColumn<Appointments, String> marchAppointmentTitleCol;
    @FXML
    TableColumn<Appointments, String> marchAppointmentLocationCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> marchAppointmentStartCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> marchAppointmentEndCol;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentContactIdCol;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentUserIdCol;
    @FXML
    TableColumn<Appointments, String> marchAppointmentDescriptionCol;

    @FXML
    Tab aprilTabByMonthTabPane;
    @FXML
    TableView<Appointments> aprilTabByMonthTableView;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentIdCol;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentCustomerIdCol;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentTypeCol;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentTitleCol;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentLocationCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> aprilAppointmentStartCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> aprilAppointmentEndCol;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentContactIdCol;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentUserIdCol;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentDescriptionCol;

    @FXML
    Tab mayTabByMonthTabPane;
    @FXML
    TableView<Appointments> mayTabByMonthTableView;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentIdCol;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentCustomerIdCol;
    @FXML
    TableColumn<Appointments, String> mayAppointmentTypeCol;
    @FXML
    TableColumn<Appointments, String> mayAppointmentTitleCol;
    @FXML
    TableColumn<Appointments, String> mayAppointmentLocationCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> mayAppointmentStartCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> mayAppointmentEndCol;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentContactIdCol;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentUserIdCol;
    @FXML
    TableColumn<Appointments, String> mayAppointmentDescriptionCol;

    @FXML
    Tab juneTabByMonthTabPane;
    @FXML
    TableView<Appointments> juneTabByMonthTableView;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentIdCol;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentCustomerIdCol;
    @FXML
    TableColumn<Appointments, String> juneAppointmentTypeCol;
    @FXML
    TableColumn<Appointments, String> juneAppointmentTitleCol;
    @FXML
    TableColumn<Appointments, String> juneAppointmentLocationCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> juneAppointmentStartCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> juneAppointmentEndCol;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentContactIdCol;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentUserIdCol;
    @FXML
    TableColumn<Appointments, String> juneAppointmentDescriptionCol;

    @FXML
    Tab julyTabByMonthTabPane;
    @FXML
    TableView<Appointments> julyTabByMonthTableView;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentIdCol;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentCustomerIdCol;
    @FXML
    TableColumn<Appointments, String> julyAppointmentTypeCol;
    @FXML
    TableColumn<Appointments, String> julyAppointmentTitleCol;
    @FXML
    TableColumn<Appointments, String> julyAppointmentLocationCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> julyAppointmentStartCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> julyAppointmentEndCol;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentContactIdCol;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentUserIdCol;
    @FXML
    TableColumn<Appointments, String> julyAppointmentDescriptionCol;

    @FXML
    Tab augustTabByMonthTabPane;
    @FXML
    TableView<Appointments> augustTabByMonthTableView;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentIdCol;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentCustomerIdCol;
    @FXML
    TableColumn<Appointments, String> augustAppointmentTypeCol;
    @FXML
    TableColumn<Appointments, String> augustAppointmentTitleCol;
    @FXML
    TableColumn<Appointments, String> augustAppointmentLocationCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> augustAppointmentStartCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> augustAppointmentEndCol;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentContactIdCol;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentUserIdCol;
    @FXML
    TableColumn<Appointments, String> augustAppointmentDescriptionCol;

    @FXML
    Tab septemberTabByMonthTabPane;
    @FXML
    TableView<Appointments> septemberTabByMonthTableView;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentIdCol;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentCustomerIdCol;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentTypeCol;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentTitleCol;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentLocationCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> septemberAppointmentStartCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> septemberAppointmentEndCol;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentContactIdCol;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentUserIdCol;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentDescriptionCol;

    @FXML
    Tab octoberTabByMonthTabPane;
    @FXML
    TableView<Appointments> octoberTabByMonthTableView;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentIdCol;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentCustomerIdCol;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentTypeCol;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentTitleCol;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentLocationCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> octoberAppointmentStartCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> octoberAppointmentEndCol;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentContactIdCol;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentUserIdCol;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentDescriptionCol;

    @FXML
    Tab novemberTabByMonthTabPane;
    @FXML
    TableView<Appointments> novemberTabByMonthTableView;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentIdCol;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentCustomerIdCol;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentTypeCol;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentTitleCol;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentLocationCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> novemberAppointmentStartCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> novemberAppointmentEndCol;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentContactIdCol;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentUserIdCol;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentDescriptionCol;

    @FXML
    Tab decemberTabByMonthTabPane;
    @FXML
    TableView<Appointments> decemberTabByMonthTableView;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentIdCol;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentCustomerIdCol;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentTypeCol;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentTitleCol;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentLocationCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> decemberAppointmentStartCol;
    @FXML
    TableColumn<Appointments, LocalDateTime> decemberAppointmentEndCol;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentContactIdCol;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentUserIdCol;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentDescriptionCol;

    @FXML
    Accordion januaryAccordion;
    @FXML
    TitledPane januaryWeek1TitledPane;
    @FXML
    TableView<Appointments> januaryWeek1TableView;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentIdCol1;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentCustomerIdCol1;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentTypeCol1;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentTitleCol1;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentLocationCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> januaryAppointmentStartCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> januaryAppointmentEndCol1;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentContactIdCol1;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentUserIdCol1;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentDescriptionCol1;

    @FXML
    TitledPane januaryWeek2TitledPane;
    @FXML
    TableView<Appointments> januaryWeek2TableView;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentIdCol2;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentCustomerIdCol2;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentTypeCol2;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentTitleCol2;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentLocationCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> januaryAppointmentStartCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> januaryAppointmentEndCol2;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentContactIdCol2;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentUserIdCol2;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentDescriptionCol2;

    @FXML
    TitledPane januaryWeek3TitledPane;
    @FXML
    TableView<Appointments> januaryWeek3TableView;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentIdCol3;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentCustomerIdCol3;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentTypeCol3;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentTitleCol3;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentLocationCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> januaryAppointmentStartCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> januaryAppointmentEndCol3;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentContactIdCol3;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentUserIdCol3;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentDescriptionCol3;

    @FXML
    TitledPane januaryWeek4TitledPane;
    @FXML
    TableView<Appointments> januaryWeek4TableView;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentIdCol4;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentCustomerIdCol4;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentTypeCol4;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentTitleCol4;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentLocationCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> januaryAppointmentStartCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> januaryAppointmentEndCol4;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentContactIdCol4;
    @FXML
    TableColumn<Appointments, Integer> januaryAppointmentUserIdCol4;
    @FXML
    TableColumn<Appointments, String> januaryAppointmentDescriptionCol4;

    @FXML
    Accordion februaryAccordion;
    @FXML
    TitledPane februaryWeek1TitledPane;
    @FXML
    TableView<Appointments> februaryWeek1TableView;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentIdCol1;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentCustomerIdCol1;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentTypeCol1;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentTitleCol1;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentLocationCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> februaryAppointmentStartCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> februaryAppointmentEndCol1;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentContactIdCol1;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentUserIdCol1;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentDescriptionCol1;

    @FXML
    TitledPane februaryWeek2TitledPane;
    @FXML
    TableView<Appointments> februaryWeek2TableView;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentIdCol2;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentCustomerIdCol2;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentTypeCol2;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentTitleCol2;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentLocationCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> februaryAppointmentStartCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> februaryAppointmentEndCol2;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentContactIdCol2;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentUserIdCol2;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentDescriptionCol2;

    @FXML
    TitledPane februaryWeek3TitledPane;
    @FXML
    TableView<Appointments> februaryWeek3TableView;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentIdCol3;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentCustomerIdCol3;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentTypeCol3;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentTitleCol3;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentLocationCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> februaryAppointmentStartCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> februaryAppointmentEndCol3;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentContactIdCol3;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentUserIdCol3;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentDescriptionCol3;

    @FXML
    TitledPane februaryWeek4TitledPane;
    @FXML
    TableView<Appointments> februaryWeek4TableView;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentIdCol4;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentCustomerIdCol4;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentTypeCol4;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentTitleCol4;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentLocationCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> februaryAppointmentStartCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> februaryAppointmentEndCol4;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentContactIdCol4;
    @FXML
    TableColumn<Appointments, Integer> februaryAppointmentUserIdCol4;
    @FXML
    TableColumn<Appointments, String> februaryAppointmentDescriptionCol4;


    @FXML
    Accordion marchAccordion;
    @FXML
    TitledPane marchWeek1TitledPane;
    @FXML
    TableView<Appointments> marchWeek1TableView;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentIdCol1;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentCustomerIdCol1;
    @FXML
    TableColumn<Appointments, String> marchAppointmentTypeCol1;
    @FXML
    TableColumn<Appointments, String> marchAppointmentTitleCol1;
    @FXML
    TableColumn<Appointments, String> marchAppointmentLocationCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> marchAppointmentStartCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> marchAppointmentEndCol1;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentContactIdCol1;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentUserIdCol1;
    @FXML
    TableColumn<Appointments, String> marchAppointmentDescriptionCol1;

    @FXML
    TitledPane marchWeek2TitledPane;
    @FXML
    TableView<Appointments> marchWeek2TableView;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentIdCol2;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentCustomerIdCol2;
    @FXML
    TableColumn<Appointments, String> marchAppointmentTypeCol2;
    @FXML
    TableColumn<Appointments, String> marchAppointmentTitleCol2;
    @FXML
    TableColumn<Appointments, String> marchAppointmentLocationCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> marchAppointmentStartCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> marchAppointmentEndCol2;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentContactIdCol2;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentUserIdCol2;
    @FXML
    TableColumn<Appointments, String> marchAppointmentDescriptionCol2;

    @FXML
    TitledPane marchWeek3TitledPane;
    @FXML
    TableView<Appointments> marchWeek3TableView;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentIdCol3;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentCustomerIdCol3;
    @FXML
    TableColumn<Appointments, String> marchAppointmentTypeCol3;
    @FXML
    TableColumn<Appointments, String> marchAppointmentTitleCol3;
    @FXML
    TableColumn<Appointments, String> marchAppointmentLocationCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> marchAppointmentStartCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> marchAppointmentEndCol3;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentContactIdCol3;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentUserIdCol3;
    @FXML
    TableColumn<Appointments, String> marchAppointmentDescriptionCol3;

    @FXML
    TitledPane marchWeek4TitledPane;
    @FXML
    TableView<Appointments> marchWeek4TableView;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentIdCol4;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentCustomerIdCol4;
    @FXML
    TableColumn<Appointments, String> marchAppointmentTypeCol4;
    @FXML
    TableColumn<Appointments, String> marchAppointmentTitleCol4;
    @FXML
    TableColumn<Appointments, String> marchAppointmentLocationCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> marchAppointmentStartCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> marchAppointmentEndCol4;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentContactIdCol4;
    @FXML
    TableColumn<Appointments, Integer> marchAppointmentUserIdCol4;
    @FXML
    TableColumn<Appointments, String> marchAppointmentDescriptionCol4;


    @FXML
    Accordion aprilAccordion;
    @FXML
    TitledPane aprilWeek1TitledPane;
    @FXML
    TableView<Appointments> aprilWeek1TableView;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentIdCol1;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentCustomerIdCol1;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentTypeCol1;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentTitleCol1;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentLocationCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> aprilAppointmentStartCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> aprilAppointmentEndCol1;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentContactIdCol1;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentUserIdCol1;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentDescriptionCol1;

    @FXML
    TitledPane aprilWeek2TitledPane;
    @FXML
    TableView<Appointments> aprilWeek2TableView;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentIdCol2;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentCustomerIdCol2;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentTypeCol2;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentTitleCol2;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentLocationCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> aprilAppointmentStartCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> aprilAppointmentEndCol2;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentContactIdCol2;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentUserIdCol2;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentDescriptionCol2;

    @FXML
    TitledPane aprilWeek3TitledPane;
    @FXML
    TableView<Appointments> aprilWeek3TableView;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentIdCol3;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentCustomerIdCol3;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentTypeCol3;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentTitleCol3;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentLocationCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> aprilAppointmentStartCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> aprilAppointmentEndCol3;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentContactIdCol3;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentUserIdCol3;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentDescriptionCol3;
    @FXML
    TitledPane aprilWeek4TitledPane;
    @FXML
    TableView<Appointments> aprilWeek4TableView;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentIdCol4;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentCustomerIdCol4;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentTypeCol4;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentTitleCol4;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentLocationCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> aprilAppointmentStartCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> aprilAppointmentEndCol4;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentContactIdCol4;
    @FXML
    TableColumn<Appointments, Integer> aprilAppointmentUserIdCol4;
    @FXML
    TableColumn<Appointments, String> aprilAppointmentDescriptionCol4;

    @FXML
    Accordion mayAccordion;
    @FXML
    TitledPane mayWeek1TitledPane;
    @FXML
    TableView<Appointments> mayWeek1TableView;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentIdCol1;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentCustomerIdCol1;
    @FXML
    TableColumn<Appointments, String> mayAppointmentTypeCol1;
    @FXML
    TableColumn<Appointments, String> mayAppointmentTitleCol1;
    @FXML
    TableColumn<Appointments, String> mayAppointmentLocationCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> mayAppointmentStartCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> mayAppointmentEndCol1;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentContactIdCol1;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentUserIdCol1;
    @FXML
    TableColumn<Appointments, String> mayAppointmentDescriptionCol1;

    @FXML
    TitledPane mayWeek2TitledPane;
    @FXML
    TableView<Appointments> mayWeek2TableView;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentIdCol2;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentCustomerIdCol2;
    @FXML
    TableColumn<Appointments, String> mayAppointmentTypeCol2;
    @FXML
    TableColumn<Appointments, String> mayAppointmentTitleCol2;
    @FXML
    TableColumn<Appointments, String> mayAppointmentLocationCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> mayAppointmentStartCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> mayAppointmentEndCol2;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentContactIdCol2;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentUserIdCol2;
    @FXML
    TableColumn<Appointments, String> mayAppointmentDescriptionCol2;

    @FXML
    TitledPane mayWeek3TitledPane;
    @FXML
    TableView<Appointments> mayWeek3TableView;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentIdCol3;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentCustomerIdCol3;
    @FXML
    TableColumn<Appointments, String> mayAppointmentTypeCol3;
    @FXML
    TableColumn<Appointments, String> mayAppointmentTitleCol3;
    @FXML
    TableColumn<Appointments, String> mayAppointmentLocationCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> mayAppointmentStartCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> mayAppointmentEndCol3;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentContactIdCol3;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentUserIdCol3;
    @FXML
    TableColumn<Appointments, String> mayAppointmentDescriptionCol3;

    @FXML
    TitledPane mayWeek4TitledPane;
    @FXML
    TableView<Appointments> mayWeek4TableView;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentIdCol4;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentCustomerIdCol4;
    @FXML
    TableColumn<Appointments, String> mayAppointmentTypeCol4;
    @FXML
    TableColumn<Appointments, String> mayAppointmentTitleCol4;
    @FXML
    TableColumn<Appointments, String> mayAppointmentLocationCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> mayAppointmentStartCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> mayAppointmentEndCol4;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentContactIdCol4;
    @FXML
    TableColumn<Appointments, Integer> mayAppointmentUserIdCol4;
    @FXML
    TableColumn<Appointments, String> mayAppointmentDescriptionCol4;

    @FXML
    Accordion juneAccordion;
    @FXML
    TitledPane juneWeek1TitledPane;
    @FXML
    TableView<Appointments> juneWeek1TableView;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentIdCol1;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentCustomerIdCol1;
    @FXML
    TableColumn<Appointments, String> juneAppointmentTypeCol1;
    @FXML
    TableColumn<Appointments, String> juneAppointmentTitleCol1;
    @FXML
    TableColumn<Appointments, String> juneAppointmentLocationCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> juneAppointmentStartCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> juneAppointmentEndCol1;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentContactIdCol1;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentUserIdCol1;
    @FXML
    TableColumn<Appointments, String> juneAppointmentDescriptionCol1;

    @FXML
    TitledPane juneWeek2TitledPane;
    @FXML
    TableView<Appointments> juneWeek2TableView;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentIdCol2;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentCustomerIdCol2;
    @FXML
    TableColumn<Appointments, String> juneAppointmentTypeCol2;
    @FXML
    TableColumn<Appointments, String> juneAppointmentTitleCol2;
    @FXML
    TableColumn<Appointments, String> juneAppointmentLocationCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> juneAppointmentStartCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> juneAppointmentEndCol2;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentContactIdCol2;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentUserIdCol2;
    @FXML
    TableColumn<Appointments, String> juneAppointmentDescriptionCol2;

    @FXML
    TitledPane juneWeek3TitledPane;
    @FXML
    TableView<Appointments> juneWeek3TableView;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentIdCol3;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentCustomerIdCol3;
    @FXML
    TableColumn<Appointments, String> juneAppointmentTypeCol3;
    @FXML
    TableColumn<Appointments, String> juneAppointmentTitleCol3;
    @FXML
    TableColumn<Appointments, String> juneAppointmentLocationCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> juneAppointmentStartCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> juneAppointmentEndCol3;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentContactIdCol3;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentUserIdCol3;
    @FXML
    TableColumn<Appointments, String> juneAppointmentDescriptionCol3;

    @FXML
    TitledPane juneWeek4TitledPane;
    @FXML
    TableView<Appointments> juneWeek4TableView;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentIdCol4;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentCustomerIdCol4;
    @FXML
    TableColumn<Appointments, String> juneAppointmentTypeCol4;
    @FXML
    TableColumn<Appointments, String> juneAppointmentTitleCol4;
    @FXML
    TableColumn<Appointments, String> juneAppointmentLocationCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> juneAppointmentStartCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> juneAppointmentEndCol4;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentContactIdCol4;
    @FXML
    TableColumn<Appointments, Integer> juneAppointmentUserIdCol4;
    @FXML
    TableColumn<Appointments, String> juneAppointmentDescriptionCol4;

    @FXML
    Accordion julyAccordion;
    @FXML
    TitledPane julyWeek1TitledPane;
    @FXML
    TableView<Appointments> julyWeek1TableView;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentIdCol1;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentCustomerIdCol1;
    @FXML
    TableColumn<Appointments, String> julyAppointmentTypeCol1;
    @FXML
    TableColumn<Appointments, String> julyAppointmentTitleCol1;
    @FXML
    TableColumn<Appointments, String> julyAppointmentLocationCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> julyAppointmentStartCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> julyAppointmentEndCol1;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentContactIdCol1;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentUserIdCol1;
    @FXML
    TableColumn<Appointments, String> julyAppointmentDescriptionCol1;

    @FXML
    TitledPane julyWeek2TitledPane;
    @FXML
    TableView<Appointments> julyWeek2TableView;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentIdCol2;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentCustomerIdCol2;
    @FXML
    TableColumn<Appointments, String> julyAppointmentTypeCol2;
    @FXML
    TableColumn<Appointments, String> julyAppointmentTitleCol2;
    @FXML
    TableColumn<Appointments, String> julyAppointmentLocationCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> julyAppointmentStartCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> julyAppointmentEndCol2;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentContactIdCol2;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentUserIdCol2;
    @FXML
    TableColumn<Appointments, String> julyAppointmentDescriptionCol2;

    @FXML
    TitledPane julyWeek3TitledPane;
    @FXML
    TableView<Appointments> julyWeek3TableView;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentIdCol3;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentCustomerIdCol3;
    @FXML
    TableColumn<Appointments, String> julyAppointmentTypeCol3;
    @FXML
    TableColumn<Appointments, String> julyAppointmentTitleCol3;
    @FXML
    TableColumn<Appointments, String> julyAppointmentLocationCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> julyAppointmentStartCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> julyAppointmentEndCol3;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentContactIdCol3;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentUserIdCol3;
    @FXML
    TableColumn<Appointments, String> julyAppointmentDescriptionCol3;

    @FXML
    TitledPane julyWeek4TitledPane;
    @FXML
    TableView<Appointments> julyWeek4TableView;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentIdCol4;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentCustomerIdCol4;
    @FXML
    TableColumn<Appointments, String> julyAppointmentTypeCol4;
    @FXML
    TableColumn<Appointments, String> julyAppointmentTitleCol4;
    @FXML
    TableColumn<Appointments, String> julyAppointmentLocationCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> julyAppointmentStartCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> julyAppointmentEndCol4;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentContactIdCol4;
    @FXML
    TableColumn<Appointments, Integer> julyAppointmentUserIdCol4;
    @FXML
    TableColumn<Appointments, String> julyAppointmentDescriptionCol4;

    @FXML
    Accordion augustAccordion;
    @FXML
    TitledPane augustWeek1TitledPane;
    @FXML
    TableView<Appointments> augustWeek1TableView;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentIdCol1;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentCustomerIdCol1;
    @FXML
    TableColumn<Appointments, String> augustAppointmentTypeCol1;
    @FXML
    TableColumn<Appointments, String> augustAppointmentTitleCol1;
    @FXML
    TableColumn<Appointments, String> augustAppointmentLocationCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> augustAppointmentStartCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> augustAppointmentEndCol1;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentContactIdCol1;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentUserIdCol1;
    @FXML
    TableColumn<Appointments, String> augustAppointmentDescriptionCol1;

    @FXML
    TitledPane augustWeek2TitledPane;
    @FXML
    TableView<Appointments> augustWeek2TableView;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentIdCol2;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentCustomerIdCol2;
    @FXML
    TableColumn<Appointments, String> augustAppointmentTypeCol2;
    @FXML
    TableColumn<Appointments, String> augustAppointmentTitleCol2;
    @FXML
    TableColumn<Appointments, String> augustAppointmentLocationCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> augustAppointmentStartCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> augustAppointmentEndCol2;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentContactIdCol2;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentUserIdCol2;
    @FXML
    TableColumn<Appointments, String> augustAppointmentDescriptionCol2;

    @FXML
    TitledPane augustWeek3TitledPane;
    @FXML
    TableView<Appointments> augustWeek3TableView;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentIdCol3;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentCustomerIdCol3;
    @FXML
    TableColumn<Appointments, String> augustAppointmentTypeCol3;
    @FXML
    TableColumn<Appointments, String> augustAppointmentTitleCol3;
    @FXML
    TableColumn<Appointments, String> augustAppointmentLocationCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> augustAppointmentStartCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> augustAppointmentEndCol3;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentContactIdCol3;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentUserIdCol3;
    @FXML
    TableColumn<Appointments, String> augustAppointmentDescriptionCol3;

    @FXML
    TitledPane augustWeek4TitledPane;
    @FXML
    TableView<Appointments> augustWeek4TableView;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentIdCol4;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentCustomerIdCol4;
    @FXML
    TableColumn<Appointments, String> augustAppointmentTypeCol4;
    @FXML
    TableColumn<Appointments, String> augustAppointmentTitleCol4;
    @FXML
    TableColumn<Appointments, String> augustAppointmentLocationCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> augustAppointmentStartCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> augustAppointmentEndCol4;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentContactIdCol4;
    @FXML
    TableColumn<Appointments, Integer> augustAppointmentUserIdCol4;
    @FXML
    TableColumn<Appointments, String> augustAppointmentDescriptionCol4;

    @FXML
    Accordion septemberAccordion;
    @FXML
    TitledPane septemberWeek1TitledPane;
    @FXML
    TableView<Appointments> septemberWeek1TableView;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentIdCol1;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentCustomerIdCol1;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentTypeCol1;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentTitleCol1;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentLocationCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> septemberAppointmentStartCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> septemberAppointmentEndCol1;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentContactIdCol1;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentUserIdCol1;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentDescriptionCol1;

    @FXML
    TitledPane septemberWeek2TitledPane;
    @FXML
    TableView<Appointments> septemberWeek2TableView;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentIdCol2;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentCustomerIdCol2;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentTypeCol2;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentTitleCol2;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentLocationCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> septemberAppointmentStartCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> septemberAppointmentEndCol2;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentContactIdCol2;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentUserIdCol2;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentDescriptionCol2;

    @FXML
    TitledPane septemberWeek3TitledPane;
    @FXML
    TableView<Appointments> septemberWeek3TableView;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentIdCol3;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentCustomerIdCol3;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentTypeCol3;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentTitleCol3;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentLocationCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> septemberAppointmentStartCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> septemberAppointmentEndCol3;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentContactIdCol3;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentUserIdCol3;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentDescriptionCol3;

    @FXML
    TitledPane septemberWeek4TitledPane;
    @FXML
    TableView<Appointments> septemberWeek4TableView;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentIdCol4;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentCustomerIdCol4;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentTypeCol4;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentTitleCol4;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentLocationCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> septemberAppointmentStartCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> septemberAppointmentEndCol4;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentContactIdCol4;
    @FXML
    TableColumn<Appointments, Integer> septemberAppointmentUserIdCol4;
    @FXML
    TableColumn<Appointments, String> septemberAppointmentDescriptionCol4;

    @FXML
    Accordion octoberAccordion;
    @FXML
    TitledPane octoberWeek1TitledPane;
    @FXML
    TableView<Appointments> octoberWeek1TableView;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentIdCol1;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentCustomerIdCol1;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentTypeCol1;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentTitleCol1;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentLocationCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> octoberAppointmentStartCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> octoberAppointmentEndCol1;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentContactIdCol1;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentUserIdCol1;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentDescriptionCol1;

    @FXML
    TitledPane octoberWeek2TitledPane;
    @FXML
    TableView<Appointments> octoberWeek2TableView;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentIdCol2;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentCustomerIdCol2;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentTypeCol2;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentTitleCol2;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentLocationCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> octoberAppointmentStartCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> octoberAppointmentEndCol2;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentContactIdCol2;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentUserIdCol2;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentDescriptionCol2;

    @FXML
    TitledPane octoberWeek3TitledPane;
    @FXML
    TableView<Appointments> octoberWeek3TableView;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentIdCol3;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentCustomerIdCol3;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentTypeCol3;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentTitleCol3;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentLocationCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> octoberAppointmentStartCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> octoberAppointmentEndCol3;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentContactIdCol3;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentUserIdCol3;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentDescriptionCol3;

    @FXML
    TitledPane octoberWeek4TitledPane;
    @FXML
    TableView<Appointments> octoberWeek4TableView;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentIdCol4;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentCustomerIdCol4;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentTypeCol4;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentTitleCol4;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentLocationCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> octoberAppointmentStartCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> octoberAppointmentEndCol4;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentContactIdCol4;
    @FXML
    TableColumn<Appointments, Integer> octoberAppointmentUserIdCol4;
    @FXML
    TableColumn<Appointments, String> octoberAppointmentDescriptionCol4;

    @FXML
    Accordion novemberAccordion;
    @FXML
    TitledPane novemberWeek1TitledPane;
    @FXML
    TableView<Appointments> novemberWeek1TableView;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentIdCol1;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentCustomerIdCol1;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentTypeCol1;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentTitleCol1;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentLocationCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> novemberAppointmentStartCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> novemberAppointmentEndCol1;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentContactIdCol1;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentUserIdCol1;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentDescriptionCol1;


    @FXML
    TitledPane novemberWeek2TitledPane;
    @FXML
    TableView<Appointments> novemberWeek2TableView;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentIdCol2;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentCustomerIdCol2;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentTypeCol2;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentTitleCol2;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentLocationCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> novemberAppointmentStartCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> novemberAppointmentEndCol2;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentContactIdCol2;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentUserIdCol2;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentDescriptionCol2;


    @FXML
    TitledPane novemberWeek3TitledPane;
    @FXML
    TableView<Appointments> novemberWeek3TableView;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentIdCol3;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentCustomerIdCol3;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentTypeCol3;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentTitleCol3;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentLocationCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> novemberAppointmentStartCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> novemberAppointmentEndCol3;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentContactIdCol3;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentUserIdCol3;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentDescriptionCol3;


    @FXML
    TitledPane novemberWeek4TitledPane;
    @FXML
    TableView<Appointments> novemberWeek4TableView;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentIdCol4;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentCustomerIdCol4;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentTypeCol4;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentTitleCol4;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentLocationCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> novemberAppointmentStartCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> novemberAppointmentEndCol4;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentContactIdCol4;
    @FXML
    TableColumn<Appointments, Integer> novemberAppointmentUserIdCol4;
    @FXML
    TableColumn<Appointments, String> novemberAppointmentDescriptionCol4;


    @FXML
    Accordion decemberAccordion;
    @FXML
    TitledPane decemberWeek1TitledPane;
    @FXML
    TableView<Appointments> decemberWeek1TableView;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentIdCol1;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentCustomerIdCol1;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentTypeCol1;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentTitleCol1;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentLocationCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> decemberAppointmentStartCol1;
    @FXML
    TableColumn<Appointments, LocalDateTime> decemberAppointmentEndCol1;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentContactIdCol1;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentUserIdCol1;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentDescriptionCol1;

    @FXML
    TitledPane decemberWeek2TitledPane;
    @FXML
    TableView<Appointments> decemberWeek2TableView;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentIdCol2;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentCustomerIdCol2;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentTypeCol2;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentTitleCol2;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentLocationCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> decemberAppointmentStartCol2;
    @FXML
    TableColumn<Appointments, LocalDateTime> decemberAppointmentEndCol2;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentContactIdCol2;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentUserIdCol2;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentDescriptionCol2;

    @FXML
    TitledPane decemberWeek3TitledPane;
    @FXML
    TableView<Appointments> decemberWeek3TableView;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentIdCol3;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentCustomerIdCol3;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentTypeCol3;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentTitleCol3;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentLocationCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> decemberAppointmentStartCol3;
    @FXML
    TableColumn<Appointments, LocalDateTime> decemberAppointmentEndCol3;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentContactIdCol3;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentUserIdCol3;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentDescriptionCol3;

    @FXML
    TitledPane decemberWeek4TitledPane;
    @FXML
    TableView<Appointments> decemberWeek4TableView;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentIdCol4;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentCustomerIdCol4;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentTypeCol4;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentTitleCol4;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentLocationCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> decemberAppointmentStartCol4;
    @FXML
    TableColumn<Appointments, LocalDateTime> decemberAppointmentEndCol4;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentContactIdCol4;
    @FXML
    TableColumn<Appointments, Integer> decemberAppointmentUserIdCol4;
    @FXML
    TableColumn<Appointments, String> decemberAppointmentDescriptionCol4;

    /**
     * Lambda Justification: A lambda expression is used here to run an appointment reminder method everytime 5 minutes has passed
     */
    Timeline timeline = new Timeline(
        new KeyFrame(Duration.minutes(5), e -> appointmentReminder())
    );


    // setting up customer cols
    public void customerTableSetup (){
        customersIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        customersNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customersAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        customersPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        customersZipCodeCol.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        customersTableView.setItems(allCustomers);
    }

    // setting up appoint cols

    public void appointmentTableSetup() {
        appointmentsByMonthButton.setSelected(true);
        appointmentsByWeekButton.setSelected(false);

        //January Table Setup
        januaryTabByMonthTableView.setItems(januaryAppointments);
        januaryWeek1TableView.setItems(januaryWeek1Appointments);
        januaryWeek2TableView.setItems(januaryWeek2Appointments);
        januaryWeek3TableView.setItems(januaryWeek3Appointments);
        januaryWeek4TableView.setItems(januaryWeek4Appointments);
        januaryAppointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        januaryAppointmentIdCol1.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        januaryAppointmentIdCol2.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        januaryAppointmentIdCol3.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        januaryAppointmentIdCol4.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));

        januaryAppointmentTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        januaryAppointmentTitleCol1.setCellValueFactory(new PropertyValueFactory<>("title"));
        januaryAppointmentTitleCol2.setCellValueFactory(new PropertyValueFactory<>("title"));
        januaryAppointmentTitleCol3.setCellValueFactory(new PropertyValueFactory<>("title"));
        januaryAppointmentTitleCol4.setCellValueFactory(new PropertyValueFactory<>("title"));

        januaryAppointmentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        januaryAppointmentCustomerIdCol1.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        januaryAppointmentCustomerIdCol2.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        januaryAppointmentCustomerIdCol3.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        januaryAppointmentCustomerIdCol4.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        januaryAppointmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        januaryAppointmentTypeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));
        januaryAppointmentTypeCol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        januaryAppointmentTypeCol3.setCellValueFactory(new PropertyValueFactory<>("type"));
        januaryAppointmentTypeCol4.setCellValueFactory(new PropertyValueFactory<>("type"));

        januaryAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        januaryAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        januaryAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        januaryAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        januaryAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        januaryAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        januaryAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        januaryAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        januaryAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        januaryAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));

        januaryAppointmentEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        januaryAppointmentEndCol1.setCellValueFactory(new PropertyValueFactory<>("end"));
        januaryAppointmentEndCol2.setCellValueFactory(new PropertyValueFactory<>("end"));
        januaryAppointmentEndCol3.setCellValueFactory(new PropertyValueFactory<>("end"));
        januaryAppointmentEndCol4.setCellValueFactory(new PropertyValueFactory<>("end"));

        januaryAppointmentContactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        januaryAppointmentContactIdCol1.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        januaryAppointmentContactIdCol2.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        januaryAppointmentContactIdCol3.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        januaryAppointmentContactIdCol4.setCellValueFactory(new PropertyValueFactory<>("contactId"));

        januaryAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        januaryAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        januaryAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        januaryAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        januaryAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        januaryAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        januaryAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        januaryAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        januaryAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        januaryAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        //February Table Setup
        februaryTabByMonthTableView.setItems(februaryAppointments);
        februaryWeek1TableView.setItems(februaryWeek1Appointments);
        februaryWeek2TableView.setItems(februaryWeek2Appointments);
        februaryWeek3TableView.setItems(februaryWeek3Appointments);
        februaryWeek4TableView.setItems(februaryWeek4Appointments);
        februaryAppointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        februaryAppointmentIdCol1.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        februaryAppointmentIdCol2.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        februaryAppointmentIdCol3.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        februaryAppointmentIdCol4.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));

        februaryAppointmentTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        februaryAppointmentTitleCol1.setCellValueFactory(new PropertyValueFactory<>("title"));
        februaryAppointmentTitleCol2.setCellValueFactory(new PropertyValueFactory<>("title"));
        februaryAppointmentTitleCol3.setCellValueFactory(new PropertyValueFactory<>("title"));
        februaryAppointmentTitleCol4.setCellValueFactory(new PropertyValueFactory<>("title"));

        februaryAppointmentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        februaryAppointmentCustomerIdCol1.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        februaryAppointmentCustomerIdCol2.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        februaryAppointmentCustomerIdCol3.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        februaryAppointmentCustomerIdCol4.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        februaryAppointmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        februaryAppointmentTypeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));
        februaryAppointmentTypeCol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        februaryAppointmentTypeCol3.setCellValueFactory(new PropertyValueFactory<>("type"));
        februaryAppointmentTypeCol4.setCellValueFactory(new PropertyValueFactory<>("type"));

        februaryAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        februaryAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        februaryAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        februaryAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        februaryAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        februaryAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        februaryAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        februaryAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        februaryAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        februaryAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));

        februaryAppointmentEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        februaryAppointmentEndCol1.setCellValueFactory(new PropertyValueFactory<>("end"));
        februaryAppointmentEndCol2.setCellValueFactory(new PropertyValueFactory<>("end"));
        februaryAppointmentEndCol3.setCellValueFactory(new PropertyValueFactory<>("end"));
        februaryAppointmentEndCol4.setCellValueFactory(new PropertyValueFactory<>("end"));

        februaryAppointmentContactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        februaryAppointmentContactIdCol1.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        februaryAppointmentContactIdCol2.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        februaryAppointmentContactIdCol3.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        februaryAppointmentContactIdCol4.setCellValueFactory(new PropertyValueFactory<>("contactId"));

        februaryAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        februaryAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        februaryAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        februaryAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        februaryAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        februaryAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        februaryAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        februaryAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        februaryAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        februaryAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        //March Table Setup
        marchTabByMonthTableView.setItems(marchAppointments);
        marchWeek1TableView.setItems(marchWeek1Appointments);
        marchWeek2TableView.setItems(marchWeek2Appointments);
        marchWeek3TableView.setItems(marchWeek3Appointments);
        marchWeek4TableView.setItems(marchWeek4Appointments);
        marchAppointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        marchAppointmentIdCol1.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        marchAppointmentIdCol2.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        marchAppointmentIdCol3.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        marchAppointmentIdCol4.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));

        marchAppointmentTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        marchAppointmentTitleCol1.setCellValueFactory(new PropertyValueFactory<>("title"));
        marchAppointmentTitleCol2.setCellValueFactory(new PropertyValueFactory<>("title"));
        marchAppointmentTitleCol3.setCellValueFactory(new PropertyValueFactory<>("title"));
        marchAppointmentTitleCol4.setCellValueFactory(new PropertyValueFactory<>("title"));

        marchAppointmentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        marchAppointmentCustomerIdCol1.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        marchAppointmentCustomerIdCol2.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        marchAppointmentCustomerIdCol3.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        marchAppointmentCustomerIdCol4.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        marchAppointmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        marchAppointmentTypeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));
        marchAppointmentTypeCol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        marchAppointmentTypeCol3.setCellValueFactory(new PropertyValueFactory<>("type"));
        marchAppointmentTypeCol4.setCellValueFactory(new PropertyValueFactory<>("type"));

        marchAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        marchAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        marchAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        marchAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        marchAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        marchAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        marchAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        marchAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        marchAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        marchAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));

        marchAppointmentEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        marchAppointmentEndCol1.setCellValueFactory(new PropertyValueFactory<>("end"));
        marchAppointmentEndCol2.setCellValueFactory(new PropertyValueFactory<>("end"));
        marchAppointmentEndCol3.setCellValueFactory(new PropertyValueFactory<>("end"));
        marchAppointmentEndCol4.setCellValueFactory(new PropertyValueFactory<>("end"));

        marchAppointmentContactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        marchAppointmentContactIdCol1.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        marchAppointmentContactIdCol2.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        marchAppointmentContactIdCol3.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        marchAppointmentContactIdCol4.setCellValueFactory(new PropertyValueFactory<>("contactId"));

        marchAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        marchAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        marchAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        marchAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        marchAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        marchAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        marchAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        marchAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        marchAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        marchAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        //April Table Setup
        aprilTabByMonthTableView.setItems(aprilAppointments);
        aprilWeek1TableView.setItems(aprilWeek1Appointments);
        aprilWeek2TableView.setItems(aprilWeek2Appointments);
        aprilWeek3TableView.setItems(aprilWeek3Appointments);
        aprilWeek4TableView.setItems(aprilWeek4Appointments);
        aprilAppointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        aprilAppointmentIdCol1.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        aprilAppointmentIdCol2.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        aprilAppointmentIdCol3.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        aprilAppointmentIdCol4.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));

        aprilAppointmentTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        aprilAppointmentTitleCol1.setCellValueFactory(new PropertyValueFactory<>("title"));
        aprilAppointmentTitleCol2.setCellValueFactory(new PropertyValueFactory<>("title"));
        aprilAppointmentTitleCol3.setCellValueFactory(new PropertyValueFactory<>("title"));
        aprilAppointmentTitleCol4.setCellValueFactory(new PropertyValueFactory<>("title"));

        aprilAppointmentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        aprilAppointmentCustomerIdCol1.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        aprilAppointmentCustomerIdCol2.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        aprilAppointmentCustomerIdCol3.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        aprilAppointmentCustomerIdCol4.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        aprilAppointmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        aprilAppointmentTypeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));
        aprilAppointmentTypeCol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        aprilAppointmentTypeCol3.setCellValueFactory(new PropertyValueFactory<>("type"));
        aprilAppointmentTypeCol4.setCellValueFactory(new PropertyValueFactory<>("type"));

        aprilAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        aprilAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        aprilAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        aprilAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        aprilAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        aprilAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        aprilAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        aprilAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        aprilAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        aprilAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));

        aprilAppointmentEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        aprilAppointmentEndCol1.setCellValueFactory(new PropertyValueFactory<>("end"));
        aprilAppointmentEndCol2.setCellValueFactory(new PropertyValueFactory<>("end"));
        aprilAppointmentEndCol3.setCellValueFactory(new PropertyValueFactory<>("end"));
        aprilAppointmentEndCol4.setCellValueFactory(new PropertyValueFactory<>("end"));

        aprilAppointmentContactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        aprilAppointmentContactIdCol1.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        aprilAppointmentContactIdCol2.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        aprilAppointmentContactIdCol3.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        aprilAppointmentContactIdCol4.setCellValueFactory(new PropertyValueFactory<>("contactId"));

        aprilAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        aprilAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        aprilAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        aprilAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        aprilAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        aprilAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        aprilAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        aprilAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        aprilAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        aprilAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        //May Table Setup
        mayTabByMonthTableView.setItems(mayAppointments);
        mayWeek1TableView.setItems(mayWeek1Appointments);
        mayWeek2TableView.setItems(mayWeek2Appointments);
        mayWeek3TableView.setItems(mayWeek3Appointments);
        mayWeek4TableView.setItems(mayWeek4Appointments);
        mayAppointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        mayAppointmentIdCol1.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        mayAppointmentIdCol2.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        mayAppointmentIdCol3.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        mayAppointmentIdCol4.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));

        mayAppointmentTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        mayAppointmentTitleCol1.setCellValueFactory(new PropertyValueFactory<>("title"));
        mayAppointmentTitleCol2.setCellValueFactory(new PropertyValueFactory<>("title"));
        mayAppointmentTitleCol3.setCellValueFactory(new PropertyValueFactory<>("title"));
        mayAppointmentTitleCol4.setCellValueFactory(new PropertyValueFactory<>("title"));

        mayAppointmentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        mayAppointmentCustomerIdCol1.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        mayAppointmentCustomerIdCol2.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        mayAppointmentCustomerIdCol3.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        mayAppointmentCustomerIdCol4.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        mayAppointmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        mayAppointmentTypeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));
        mayAppointmentTypeCol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        mayAppointmentTypeCol3.setCellValueFactory(new PropertyValueFactory<>("type"));
        mayAppointmentTypeCol4.setCellValueFactory(new PropertyValueFactory<>("type"));

        mayAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        mayAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        mayAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        mayAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        mayAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        mayAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        mayAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        mayAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        mayAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        mayAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));

        mayAppointmentEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        mayAppointmentEndCol1.setCellValueFactory(new PropertyValueFactory<>("end"));
        mayAppointmentEndCol2.setCellValueFactory(new PropertyValueFactory<>("end"));
        mayAppointmentEndCol3.setCellValueFactory(new PropertyValueFactory<>("end"));
        mayAppointmentEndCol4.setCellValueFactory(new PropertyValueFactory<>("end"));

        mayAppointmentContactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        mayAppointmentContactIdCol1.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        mayAppointmentContactIdCol2.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        mayAppointmentContactIdCol3.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        mayAppointmentContactIdCol4.setCellValueFactory(new PropertyValueFactory<>("contactId"));

        mayAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        mayAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        mayAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        mayAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        mayAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        mayAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        mayAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        mayAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        mayAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        mayAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        //June Table Setup
        juneTabByMonthTableView.setItems(juneAppointments);
        juneWeek1TableView.setItems(juneWeek1Appointments);
        juneWeek2TableView.setItems(juneWeek2Appointments);
        juneWeek3TableView.setItems(juneWeek3Appointments);
        juneWeek4TableView.setItems(juneWeek4Appointments);
        juneAppointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        juneAppointmentIdCol1.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        juneAppointmentIdCol2.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        juneAppointmentIdCol3.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        juneAppointmentIdCol4.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));

        juneAppointmentTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        juneAppointmentTitleCol1.setCellValueFactory(new PropertyValueFactory<>("title"));
        juneAppointmentTitleCol2.setCellValueFactory(new PropertyValueFactory<>("title"));
        juneAppointmentTitleCol3.setCellValueFactory(new PropertyValueFactory<>("title"));
        juneAppointmentTitleCol4.setCellValueFactory(new PropertyValueFactory<>("title"));

        juneAppointmentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        juneAppointmentCustomerIdCol1.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        juneAppointmentCustomerIdCol2.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        juneAppointmentCustomerIdCol3.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        juneAppointmentCustomerIdCol4.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        juneAppointmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        juneAppointmentTypeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));
        juneAppointmentTypeCol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        juneAppointmentTypeCol3.setCellValueFactory(new PropertyValueFactory<>("type"));
        juneAppointmentTypeCol4.setCellValueFactory(new PropertyValueFactory<>("type"));

        juneAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        juneAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        juneAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        juneAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        juneAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        juneAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        juneAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        juneAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        juneAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        juneAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));

        juneAppointmentEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        juneAppointmentEndCol1.setCellValueFactory(new PropertyValueFactory<>("end"));
        juneAppointmentEndCol2.setCellValueFactory(new PropertyValueFactory<>("end"));
        juneAppointmentEndCol3.setCellValueFactory(new PropertyValueFactory<>("end"));
        juneAppointmentEndCol4.setCellValueFactory(new PropertyValueFactory<>("end"));

        juneAppointmentContactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        juneAppointmentContactIdCol1.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        juneAppointmentContactIdCol2.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        juneAppointmentContactIdCol3.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        juneAppointmentContactIdCol4.setCellValueFactory(new PropertyValueFactory<>("contactId"));

        juneAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        juneAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        juneAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        juneAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        juneAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        juneAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        juneAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        juneAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        juneAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        juneAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        //July Table Setup
        julyTabByMonthTableView.setItems(julyAppointments);
        julyWeek1TableView.setItems(julyWeek1Appointments);
        julyWeek2TableView.setItems(julyWeek2Appointments);
        julyWeek3TableView.setItems(julyWeek3Appointments);
        julyWeek4TableView.setItems(julyWeek4Appointments);
        julyAppointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        julyAppointmentIdCol1.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        julyAppointmentIdCol2.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        julyAppointmentIdCol3.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        julyAppointmentIdCol4.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));

        julyAppointmentTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        julyAppointmentTitleCol1.setCellValueFactory(new PropertyValueFactory<>("title"));
        julyAppointmentTitleCol2.setCellValueFactory(new PropertyValueFactory<>("title"));
        julyAppointmentTitleCol3.setCellValueFactory(new PropertyValueFactory<>("title"));
        julyAppointmentTitleCol4.setCellValueFactory(new PropertyValueFactory<>("title"));

        julyAppointmentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        julyAppointmentCustomerIdCol1.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        julyAppointmentCustomerIdCol2.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        julyAppointmentCustomerIdCol3.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        julyAppointmentCustomerIdCol4.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        julyAppointmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        julyAppointmentTypeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));
        julyAppointmentTypeCol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        julyAppointmentTypeCol3.setCellValueFactory(new PropertyValueFactory<>("type"));
        julyAppointmentTypeCol4.setCellValueFactory(new PropertyValueFactory<>("type"));

        julyAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        julyAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        julyAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        julyAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        julyAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        julyAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        julyAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        julyAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        julyAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        julyAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));

        julyAppointmentEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        julyAppointmentEndCol1.setCellValueFactory(new PropertyValueFactory<>("end"));
        julyAppointmentEndCol2.setCellValueFactory(new PropertyValueFactory<>("end"));
        julyAppointmentEndCol3.setCellValueFactory(new PropertyValueFactory<>("end"));
        julyAppointmentEndCol4.setCellValueFactory(new PropertyValueFactory<>("end"));

        julyAppointmentContactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        julyAppointmentContactIdCol1.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        julyAppointmentContactIdCol2.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        julyAppointmentContactIdCol3.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        julyAppointmentContactIdCol4.setCellValueFactory(new PropertyValueFactory<>("contactId"));

        julyAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        julyAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        julyAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        julyAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        julyAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        julyAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        julyAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        julyAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        julyAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        julyAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        //August Table Setup
        augustTabByMonthTableView.setItems(augustAppointments);
        augustWeek1TableView.setItems(augustWeek1Appointments);
        augustWeek2TableView.setItems(augustWeek2Appointments);
        augustWeek3TableView.setItems(augustWeek3Appointments);
        augustWeek4TableView.setItems(augustWeek4Appointments);
        augustAppointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        augustAppointmentIdCol1.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        augustAppointmentIdCol2.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        augustAppointmentIdCol3.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        augustAppointmentIdCol4.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));

        augustAppointmentTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        augustAppointmentTitleCol1.setCellValueFactory(new PropertyValueFactory<>("title"));
        augustAppointmentTitleCol2.setCellValueFactory(new PropertyValueFactory<>("title"));
        augustAppointmentTitleCol3.setCellValueFactory(new PropertyValueFactory<>("title"));
        augustAppointmentTitleCol4.setCellValueFactory(new PropertyValueFactory<>("title"));

        augustAppointmentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        augustAppointmentCustomerIdCol1.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        augustAppointmentCustomerIdCol2.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        augustAppointmentCustomerIdCol3.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        augustAppointmentCustomerIdCol4.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        augustAppointmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        augustAppointmentTypeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));
        augustAppointmentTypeCol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        augustAppointmentTypeCol3.setCellValueFactory(new PropertyValueFactory<>("type"));
        augustAppointmentTypeCol4.setCellValueFactory(new PropertyValueFactory<>("type"));

        augustAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        augustAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        augustAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        augustAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        augustAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        augustAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        augustAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        augustAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        augustAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        augustAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));

        augustAppointmentEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        augustAppointmentEndCol1.setCellValueFactory(new PropertyValueFactory<>("end"));
        augustAppointmentEndCol2.setCellValueFactory(new PropertyValueFactory<>("end"));
        augustAppointmentEndCol3.setCellValueFactory(new PropertyValueFactory<>("end"));
        augustAppointmentEndCol4.setCellValueFactory(new PropertyValueFactory<>("end"));

        augustAppointmentContactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        augustAppointmentContactIdCol1.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        augustAppointmentContactIdCol2.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        augustAppointmentContactIdCol3.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        augustAppointmentContactIdCol4.setCellValueFactory(new PropertyValueFactory<>("contactId"));

        augustAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        augustAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        augustAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        augustAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        augustAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        augustAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        augustAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        augustAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        augustAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        augustAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        //September Table Setup
        septemberTabByMonthTableView.setItems(septemberAppointments);
        septemberWeek1TableView.setItems(septemberWeek1Appointments);
        septemberWeek2TableView.setItems(septemberWeek2Appointments);
        septemberWeek3TableView.setItems(septemberWeek3Appointments);
        septemberWeek4TableView.setItems(septemberWeek4Appointments);
        septemberAppointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        septemberAppointmentIdCol1.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        septemberAppointmentIdCol2.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        septemberAppointmentIdCol3.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        septemberAppointmentIdCol4.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));

        septemberAppointmentTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        septemberAppointmentTitleCol1.setCellValueFactory(new PropertyValueFactory<>("title"));
        septemberAppointmentTitleCol2.setCellValueFactory(new PropertyValueFactory<>("title"));
        septemberAppointmentTitleCol3.setCellValueFactory(new PropertyValueFactory<>("title"));
        septemberAppointmentTitleCol4.setCellValueFactory(new PropertyValueFactory<>("title"));

        septemberAppointmentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        septemberAppointmentCustomerIdCol1.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        septemberAppointmentCustomerIdCol2.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        septemberAppointmentCustomerIdCol3.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        septemberAppointmentCustomerIdCol4.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        septemberAppointmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        septemberAppointmentTypeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));
        septemberAppointmentTypeCol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        septemberAppointmentTypeCol3.setCellValueFactory(new PropertyValueFactory<>("type"));
        septemberAppointmentTypeCol4.setCellValueFactory(new PropertyValueFactory<>("type"));

        septemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        septemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        septemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        septemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        septemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        septemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        septemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        septemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        septemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        septemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));

        septemberAppointmentEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        septemberAppointmentEndCol1.setCellValueFactory(new PropertyValueFactory<>("end"));
        septemberAppointmentEndCol2.setCellValueFactory(new PropertyValueFactory<>("end"));
        septemberAppointmentEndCol3.setCellValueFactory(new PropertyValueFactory<>("end"));
        septemberAppointmentEndCol4.setCellValueFactory(new PropertyValueFactory<>("end"));

        septemberAppointmentContactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        septemberAppointmentContactIdCol1.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        septemberAppointmentContactIdCol2.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        septemberAppointmentContactIdCol3.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        septemberAppointmentContactIdCol4.setCellValueFactory(new PropertyValueFactory<>("contactId"));

        septemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        septemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        septemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        septemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        septemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        septemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        septemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        septemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        septemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        septemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        //October Table Setup
        octoberTabByMonthTableView.setItems(octoberAppointments);
        octoberWeek1TableView.setItems(octoberWeek1Appointments);
        octoberWeek2TableView.setItems(octoberWeek2Appointments);
        octoberWeek3TableView.setItems(octoberWeek3Appointments);
        octoberWeek4TableView.setItems(octoberWeek4Appointments);
        octoberAppointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        octoberAppointmentIdCol1.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        octoberAppointmentIdCol2.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        octoberAppointmentIdCol3.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        octoberAppointmentIdCol4.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));

        octoberAppointmentTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        octoberAppointmentTitleCol1.setCellValueFactory(new PropertyValueFactory<>("title"));
        octoberAppointmentTitleCol2.setCellValueFactory(new PropertyValueFactory<>("title"));
        octoberAppointmentTitleCol3.setCellValueFactory(new PropertyValueFactory<>("title"));
        octoberAppointmentTitleCol4.setCellValueFactory(new PropertyValueFactory<>("title"));

        octoberAppointmentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        octoberAppointmentCustomerIdCol1.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        octoberAppointmentCustomerIdCol2.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        octoberAppointmentCustomerIdCol3.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        octoberAppointmentCustomerIdCol4.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        octoberAppointmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        octoberAppointmentTypeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));
        octoberAppointmentTypeCol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        octoberAppointmentTypeCol3.setCellValueFactory(new PropertyValueFactory<>("type"));
        octoberAppointmentTypeCol4.setCellValueFactory(new PropertyValueFactory<>("type"));

        octoberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        octoberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        octoberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        octoberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        octoberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        octoberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        octoberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        octoberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        octoberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        octoberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));

        octoberAppointmentEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        octoberAppointmentEndCol1.setCellValueFactory(new PropertyValueFactory<>("end"));
        octoberAppointmentEndCol2.setCellValueFactory(new PropertyValueFactory<>("end"));
        octoberAppointmentEndCol3.setCellValueFactory(new PropertyValueFactory<>("end"));
        octoberAppointmentEndCol4.setCellValueFactory(new PropertyValueFactory<>("end"));

        octoberAppointmentContactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        octoberAppointmentContactIdCol1.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        octoberAppointmentContactIdCol2.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        octoberAppointmentContactIdCol3.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        octoberAppointmentContactIdCol4.setCellValueFactory(new PropertyValueFactory<>("contactId"));

        octoberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        octoberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        octoberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        octoberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        octoberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        octoberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        octoberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        octoberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        octoberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        octoberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        //November Table Setup
        novemberTabByMonthTableView.setItems(novemberAppointments);
        novemberWeek1TableView.setItems(novemberWeek1Appointments);
        novemberWeek2TableView.setItems(novemberWeek2Appointments);
        novemberWeek3TableView.setItems(novemberWeek3Appointments);
        novemberWeek4TableView.setItems(novemberWeek4Appointments);
        novemberAppointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        novemberAppointmentIdCol1.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        novemberAppointmentIdCol2.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        novemberAppointmentIdCol3.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        novemberAppointmentIdCol4.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));

        novemberAppointmentTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        novemberAppointmentTitleCol1.setCellValueFactory(new PropertyValueFactory<>("title"));
        novemberAppointmentTitleCol2.setCellValueFactory(new PropertyValueFactory<>("title"));
        novemberAppointmentTitleCol3.setCellValueFactory(new PropertyValueFactory<>("title"));
        novemberAppointmentTitleCol4.setCellValueFactory(new PropertyValueFactory<>("title"));

        novemberAppointmentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        novemberAppointmentCustomerIdCol1.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        novemberAppointmentCustomerIdCol2.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        novemberAppointmentCustomerIdCol3.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        novemberAppointmentCustomerIdCol4.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        novemberAppointmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        novemberAppointmentTypeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));
        novemberAppointmentTypeCol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        novemberAppointmentTypeCol3.setCellValueFactory(new PropertyValueFactory<>("type"));
        novemberAppointmentTypeCol4.setCellValueFactory(new PropertyValueFactory<>("type"));

        novemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        novemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        novemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        novemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        novemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        novemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        novemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        novemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        novemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        novemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));

        novemberAppointmentEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        novemberAppointmentEndCol1.setCellValueFactory(new PropertyValueFactory<>("end"));
        novemberAppointmentEndCol2.setCellValueFactory(new PropertyValueFactory<>("end"));
        novemberAppointmentEndCol3.setCellValueFactory(new PropertyValueFactory<>("end"));
        novemberAppointmentEndCol4.setCellValueFactory(new PropertyValueFactory<>("end"));

        novemberAppointmentContactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        novemberAppointmentContactIdCol1.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        novemberAppointmentContactIdCol2.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        novemberAppointmentContactIdCol3.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        novemberAppointmentContactIdCol4.setCellValueFactory(new PropertyValueFactory<>("contactId"));

        novemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        novemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        novemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        novemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        novemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        novemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        novemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        novemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        novemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        novemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        //December Table Setup
        decemberTabByMonthTableView.setItems(decemberAppointments);
        decemberWeek1TableView.setItems(decemberWeek1Appointments);
        decemberWeek2TableView.setItems(decemberWeek2Appointments);
        decemberWeek3TableView.setItems(decemberWeek3Appointments);
        decemberWeek4TableView.setItems(decemberWeek4Appointments);
        decemberAppointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        decemberAppointmentIdCol1.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        decemberAppointmentIdCol2.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        decemberAppointmentIdCol3.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        decemberAppointmentIdCol4.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));

        decemberAppointmentTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        decemberAppointmentTitleCol1.setCellValueFactory(new PropertyValueFactory<>("title"));
        decemberAppointmentTitleCol2.setCellValueFactory(new PropertyValueFactory<>("title"));
        decemberAppointmentTitleCol3.setCellValueFactory(new PropertyValueFactory<>("title"));
        decemberAppointmentTitleCol4.setCellValueFactory(new PropertyValueFactory<>("title"));

        decemberAppointmentCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        decemberAppointmentCustomerIdCol1.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        decemberAppointmentCustomerIdCol2.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        decemberAppointmentCustomerIdCol3.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        decemberAppointmentCustomerIdCol4.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        decemberAppointmentTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        decemberAppointmentTypeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));
        decemberAppointmentTypeCol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        decemberAppointmentTypeCol3.setCellValueFactory(new PropertyValueFactory<>("type"));
        decemberAppointmentTypeCol4.setCellValueFactory(new PropertyValueFactory<>("type"));

        decemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        decemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        decemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        decemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        decemberAppointmentLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        decemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        decemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        decemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        decemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        decemberAppointmentStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));

        decemberAppointmentEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        decemberAppointmentEndCol1.setCellValueFactory(new PropertyValueFactory<>("end"));
        decemberAppointmentEndCol2.setCellValueFactory(new PropertyValueFactory<>("end"));
        decemberAppointmentEndCol3.setCellValueFactory(new PropertyValueFactory<>("end"));
        decemberAppointmentEndCol4.setCellValueFactory(new PropertyValueFactory<>("end"));

        decemberAppointmentContactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        decemberAppointmentContactIdCol1.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        decemberAppointmentContactIdCol2.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        decemberAppointmentContactIdCol3.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        decemberAppointmentContactIdCol4.setCellValueFactory(new PropertyValueFactory<>("contactId"));

        decemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        decemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        decemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        decemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        decemberAppointmentUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        decemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        decemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        decemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        decemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        decemberAppointmentDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

    }

    //import existing customer data method

    // add appointment method
    @FXML
    public void addAppointmentSceneChange(MouseEvent event) throws IOException {
        if(customersTableView.getSelectionModel().getSelectedItem() != null){
            currentlySelectedCustomer = customersTableView.getSelectionModel().getSelectedItem();
            Parent root = FXMLLoader.load(Objects.requireNonNull(CustomerRecordsMainMenu.class.getResource("add-appointment.fxml")));
            Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            GridPane conformation = new GridPane();
            Text conformationInfo = new Text("Customer not selected");
            conformationInfo.setFont(new Font(20));
            conformation.getChildren().add(conformationInfo);
            GridPane.setConstraints(conformationInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
            Stage popUp = new Stage();
            Scene conformationScene = new Scene(conformation);
            popUp.setTitle("Error");
            popUp.setScene(conformationScene);
            popUp.sizeToScene();
            popUp.show();
        }
    }

    // add customer method
    @FXML
    public void addCustomerSceneChange(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(CustomerRecordsMainMenu.class.getResource("add-customer.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // modify customer method
    @FXML
    public void modifyCustomerSceneChange(MouseEvent event) throws IOException {
        if(customersTableView.getSelectionModel().getSelectedItem() != null){
            currentlySelectedCustomer = customersTableView.getSelectionModel().getSelectedItem();
            Parent root = FXMLLoader.load(Objects.requireNonNull(CustomerRecordsMainMenu.class.getResource("modify-customer.fxml")));
            Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            GridPane conformation = new GridPane();
            Text conformationInfo = new Text("Customer not selected");
            conformationInfo.setFont(new Font(20));
            conformation.getChildren().add(conformationInfo);
            GridPane.setConstraints(conformationInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
            Stage popUp = new Stage();
            Scene conformationScene = new Scene(conformation);
            popUp.setTitle("Error");
            popUp.setScene(conformationScene);
            popUp.sizeToScene();
            popUp.show();
        }

    }

    // delete customer method
    @FXML
    public void deleteCustomerData(){
        deleteCustomer(customersTableView.getSelectionModel().getSelectedItem());
    }

    // appointments searchbar methods

    // customer searchbar methods

    @FXML
    public void appointmentTotalDataByMonthButton() {
        GridPane conformation = new GridPane();
        Text conformationInfo = new Text(appointmentTotalDataByMonth());
        conformationInfo.setFont(new Font(20));
        conformation.getChildren().add(conformationInfo);
        GridPane.setConstraints(conformationInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
        Stage popUp = new Stage();
        Scene conformationScene = new Scene(conformation);
        popUp.setTitle("Appointment Data");
        popUp.setScene(conformationScene);
        popUp.sizeToScene();
        popUp.show();
    }


    // view switching method <you're gonna be working with visibility of tables>
    @FXML
    public void changeAccordion() {

        appointmentsByMonthButton.setSelected(false);
        appointmentsByWeekButton.setSelected(true);

        januaryTabByMonthTableView.setVisible(false);
        februaryTabByMonthTableView.setVisible(false);
        marchTabByMonthTableView.setVisible(false);
        aprilTabByMonthTableView.setVisible(false);
        mayTabByMonthTableView.setVisible(false);
        juneTabByMonthTableView.setVisible(false);
        julyTabByMonthTableView.setVisible(false);
        augustTabByMonthTableView.setVisible(false);
        septemberTabByMonthTableView.setVisible(false);
        octoberTabByMonthTableView.setVisible(false);
        novemberTabByMonthTableView.setVisible(false);
        decemberTabByMonthTableView.setVisible(false);

        januaryAccordion.setVisible(true);
        februaryAccordion.setVisible(true);
        marchAccordion.setVisible(true);
        aprilAccordion.setVisible(true);
        mayAccordion.setVisible(true);
        juneAccordion.setVisible(true);
        julyAccordion.setVisible(true);
        augustAccordion.setVisible(true);
        septemberAccordion.setVisible(true);
        octoberAccordion.setVisible(true);
        novemberAccordion.setVisible(true);
        decemberAccordion.setVisible(true);
    }

    @FXML
    public void changeTableView() {

            appointmentsByMonthButton.setSelected(true);
            appointmentsByWeekButton.setSelected(false);

            januaryTabByMonthTableView.setVisible(true);
            februaryTabByMonthTableView.setVisible(true);
            marchTabByMonthTableView.setVisible(true);
            aprilTabByMonthTableView.setVisible(true);
            mayTabByMonthTableView.setVisible(true);
            juneTabByMonthTableView.setVisible(true);
            julyTabByMonthTableView.setVisible(true);
            augustTabByMonthTableView.setVisible(true);
            septemberTabByMonthTableView.setVisible(true);
            octoberTabByMonthTableView.setVisible(true);
            novemberTabByMonthTableView.setVisible(true);
            decemberTabByMonthTableView.setVisible(true);

            januaryAccordion.setVisible(false);
            februaryAccordion.setVisible(false);
            marchAccordion.setVisible(false);
            aprilAccordion.setVisible(false);
            mayAccordion.setVisible(false);
            juneAccordion.setVisible(false);
            julyAccordion.setVisible(false);
            augustAccordion.setVisible(false);
            septemberAccordion.setVisible(false);
            octoberAccordion.setVisible(false);
            novemberAccordion.setVisible(false);
            decemberAccordion.setVisible(false);
    }

    // modify appointment method
    @FXML
    public void modifyAppointmentSceneChange(MouseEvent event) throws IOException {
        if(
            (januaryTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                januaryWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                januaryWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                januaryWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                januaryWeek4TableView.getSelectionModel().getSelectedItem() != null )
                ||
            (februaryTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                februaryWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                februaryWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                februaryWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                februaryWeek4TableView.getSelectionModel().getSelectedItem() != null )
                ||
            (marchTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                marchWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                marchWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                marchWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                marchWeek4TableView.getSelectionModel().getSelectedItem() != null )
                ||
            (aprilTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                aprilWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                aprilWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                aprilWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                aprilWeek4TableView.getSelectionModel().getSelectedItem() != null )
                ||
            (mayTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                mayWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                mayWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                mayWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                mayWeek4TableView.getSelectionModel().getSelectedItem() != null )
                ||
            (juneTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                juneWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                juneWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                juneWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                juneWeek4TableView.getSelectionModel().getSelectedItem() != null )
                ||
            (julyTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                julyWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                julyWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                julyWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                julyWeek4TableView.getSelectionModel().getSelectedItem() != null )
                ||
            (augustTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                augustWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                augustWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                augustWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                augustWeek4TableView.getSelectionModel().getSelectedItem() != null )
                ||
            (septemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                septemberWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                septemberWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                septemberWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                septemberWeek4TableView.getSelectionModel().getSelectedItem() != null )
                ||
            (octoberTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                octoberWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                octoberWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                octoberWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                octoberWeek4TableView.getSelectionModel().getSelectedItem() != null )
                ||
            (novemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                novemberWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                novemberWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                novemberWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                novemberWeek4TableView.getSelectionModel().getSelectedItem() != null )
                ||
            (decemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                decemberWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                decemberWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                decemberWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                decemberWeek4TableView.getSelectionModel().getSelectedItem() != null )
        ){
            if (januaryTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                    januaryWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                    januaryWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                    januaryWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                    januaryWeek4TableView.getSelectionModel().getSelectedItem() != null){

                if(januaryTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = januaryTabByMonthTableView.getSelectionModel().getSelectedItem();
                }
                else if (januaryWeek1TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = januaryWeek1TableView.getSelectionModel().getSelectedItem();
                }
                else if (januaryWeek2TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = januaryWeek2TableView.getSelectionModel().getSelectedItem();
                }
                else if (januaryWeek3TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = januaryWeek3TableView.getSelectionModel().getSelectedItem();
                }
                else if (januaryWeek4TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = januaryWeek4TableView.getSelectionModel().getSelectedItem();
                }

            }
            else if (februaryTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                    februaryWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                    februaryWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                    februaryWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                    februaryWeek4TableView.getSelectionModel().getSelectedItem() != null ){

                if(februaryTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = februaryTabByMonthTableView.getSelectionModel().getSelectedItem();
                }
                else if (februaryWeek1TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = februaryWeek1TableView.getSelectionModel().getSelectedItem();
                }
                else if (februaryWeek2TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = februaryWeek2TableView.getSelectionModel().getSelectedItem();
                }
                else if (februaryWeek3TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = februaryWeek3TableView.getSelectionModel().getSelectedItem();
                }
                else if (februaryWeek4TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = februaryWeek4TableView.getSelectionModel().getSelectedItem();
                }
            }
            else if (marchTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                    marchWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                    marchWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                    marchWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                    marchWeek4TableView.getSelectionModel().getSelectedItem() != null ){
                if(marchTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = marchTabByMonthTableView.getSelectionModel().getSelectedItem();
                }
                else if (marchWeek1TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = marchWeek1TableView.getSelectionModel().getSelectedItem();
                }
                else if (marchWeek2TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = marchWeek2TableView.getSelectionModel().getSelectedItem();
                }
                else if (marchWeek3TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = marchWeek3TableView.getSelectionModel().getSelectedItem();
                }
                else if (marchWeek4TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = marchWeek4TableView.getSelectionModel().getSelectedItem();
                }
            }
            else if (aprilTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                    aprilWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                    aprilWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                    aprilWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                    aprilWeek4TableView.getSelectionModel().getSelectedItem() != null){
                if(aprilTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = aprilTabByMonthTableView.getSelectionModel().getSelectedItem();
                }
                else if (aprilWeek1TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = aprilWeek1TableView.getSelectionModel().getSelectedItem();
                }
                else if (aprilWeek2TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = aprilWeek2TableView.getSelectionModel().getSelectedItem();
                }
                else if (aprilWeek3TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = aprilWeek3TableView.getSelectionModel().getSelectedItem();
                }
                else if (aprilWeek4TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = aprilWeek4TableView.getSelectionModel().getSelectedItem();
                }
            }
            else if (mayTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                    mayWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                    mayWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                    mayWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                    mayWeek4TableView.getSelectionModel().getSelectedItem() != null ){
                if(mayTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = mayTabByMonthTableView.getSelectionModel().getSelectedItem();
                }
                else if (mayWeek1TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = mayWeek1TableView.getSelectionModel().getSelectedItem();
                }
                else if (mayWeek2TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = mayWeek2TableView.getSelectionModel().getSelectedItem();
                }
                else if (mayWeek3TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = mayWeek3TableView.getSelectionModel().getSelectedItem();
                }
                else if (mayWeek4TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = mayWeek4TableView.getSelectionModel().getSelectedItem();
                }
            }
            else if (juneTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                    juneWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                    juneWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                    juneWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                    juneWeek4TableView.getSelectionModel().getSelectedItem() != null ){
                if(juneTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = juneTabByMonthTableView.getSelectionModel().getSelectedItem();
                }
                else if (juneWeek1TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = juneWeek1TableView.getSelectionModel().getSelectedItem();
                }
                else if (juneWeek2TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = juneWeek2TableView.getSelectionModel().getSelectedItem();
                }
                else if (juneWeek3TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = juneWeek3TableView.getSelectionModel().getSelectedItem();
                }
                else if (juneWeek4TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = juneWeek4TableView.getSelectionModel().getSelectedItem();
                }
            }
            else if (julyTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                    julyWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                    julyWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                    julyWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                    julyWeek4TableView.getSelectionModel().getSelectedItem() != null){
                if(julyTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = julyTabByMonthTableView.getSelectionModel().getSelectedItem();
                }
                else if (julyWeek1TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = julyWeek1TableView.getSelectionModel().getSelectedItem();
                }
                else if (julyWeek2TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = julyWeek2TableView.getSelectionModel().getSelectedItem();
                }
                else if (julyWeek3TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = julyWeek3TableView.getSelectionModel().getSelectedItem();
                }
                else if (julyWeek4TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = julyWeek4TableView.getSelectionModel().getSelectedItem();
                }
            }
            else if (augustTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                    augustWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                    augustWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                    augustWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                    augustWeek4TableView.getSelectionModel().getSelectedItem() != null ){
                if(augustTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = augustTabByMonthTableView.getSelectionModel().getSelectedItem();
                }
                else if (augustWeek1TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = augustWeek1TableView.getSelectionModel().getSelectedItem();
                }
                else if (augustWeek2TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = augustWeek2TableView.getSelectionModel().getSelectedItem();
                }
                else if (augustWeek3TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = augustWeek3TableView.getSelectionModel().getSelectedItem();
                }
                else if (augustWeek4TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = augustWeek4TableView.getSelectionModel().getSelectedItem();
                }
            }
            else if (septemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                    septemberWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                    septemberWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                    septemberWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                    septemberWeek4TableView.getSelectionModel().getSelectedItem() != null ){
                if(septemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = januaryTabByMonthTableView.getSelectionModel().getSelectedItem();
                }
                else if (septemberWeek1TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = septemberWeek1TableView.getSelectionModel().getSelectedItem();
                }
                else if (septemberWeek2TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = septemberWeek2TableView.getSelectionModel().getSelectedItem();
                }
                else if (septemberWeek3TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = septemberWeek3TableView.getSelectionModel().getSelectedItem();
                }
                else if (septemberWeek4TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = septemberWeek4TableView.getSelectionModel().getSelectedItem();
                }
            }else if (octoberTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                    octoberWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                    octoberWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                    octoberWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                    octoberWeek4TableView.getSelectionModel().getSelectedItem() != null){
                if(octoberTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = octoberTabByMonthTableView.getSelectionModel().getSelectedItem();
                }
                else if (octoberWeek1TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = octoberWeek1TableView.getSelectionModel().getSelectedItem();
                }
                else if (octoberWeek2TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = octoberWeek2TableView.getSelectionModel().getSelectedItem();
                }
                else if (octoberWeek3TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = octoberWeek3TableView.getSelectionModel().getSelectedItem();
                }
                else if (octoberWeek4TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = octoberWeek4TableView.getSelectionModel().getSelectedItem();
                }
            }
            else if (novemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                    novemberWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                    novemberWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                    novemberWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                    novemberWeek4TableView.getSelectionModel().getSelectedItem() != null ){
                if(novemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = novemberTabByMonthTableView.getSelectionModel().getSelectedItem();
                }
                else if (novemberWeek1TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = novemberWeek1TableView.getSelectionModel().getSelectedItem();
                }
                else if (novemberWeek2TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = novemberWeek2TableView.getSelectionModel().getSelectedItem();
                }
                else if (novemberWeek3TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = novemberWeek3TableView.getSelectionModel().getSelectedItem();
                }
                else if (novemberWeek4TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = novemberWeek4TableView.getSelectionModel().getSelectedItem();
                }
            }
            else if (decemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                    decemberWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                    decemberWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                    decemberWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                    decemberWeek4TableView.getSelectionModel().getSelectedItem() != null){
                if(decemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = decemberTabByMonthTableView.getSelectionModel().getSelectedItem();
                }
                else if (decemberWeek1TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = decemberWeek1TableView.getSelectionModel().getSelectedItem();
                }
                else if (decemberWeek2TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = decemberWeek2TableView.getSelectionModel().getSelectedItem();
                }
                else if (decemberWeek3TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = decemberWeek3TableView.getSelectionModel().getSelectedItem();
                }
                else if (decemberWeek4TableView.getSelectionModel().getSelectedItem() != null){
                    currentlySelectedAppointment = decemberWeek4TableView.getSelectionModel().getSelectedItem();
                }
            }

            Parent root = FXMLLoader.load(Objects.requireNonNull(CustomerRecordsMainMenu.class.getResource("modify-appointment.fxml")));
            Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
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

    // delete appointment method
    @FXML
    public void deleteSelectedAppointment(){
        if(januaryTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                januaryWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                januaryWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                januaryWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                januaryWeek4TableView.getSelectionModel().getSelectedItem() != null ){

            if(januaryTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                deleteAppointment(januaryTabByMonthTableView.getSelectionModel().getSelectedItem());
            }
            else if (januaryWeek1TableView.getSelectionModel().getSelectedItem() != null ) {
                deleteAppointment(januaryWeek1TableView.getSelectionModel().getSelectedItem());
            }
            else if (januaryWeek2TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(januaryWeek2TableView.getSelectionModel().getSelectedItem());
            }
            else if (januaryWeek3TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(januaryWeek3TableView.getSelectionModel().getSelectedItem());
            }
            else if (januaryWeek4TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(januaryWeek4TableView.getSelectionModel().getSelectedItem());
            } else {
                System.out.println("Something went wrong print stack trace");
            }
        }
        else if (februaryTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                februaryWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                februaryWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                februaryWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                februaryWeek4TableView.getSelectionModel().getSelectedItem() != null ) {

            if(februaryTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                deleteAppointment(februaryTabByMonthTableView.getSelectionModel().getSelectedItem());
            }
            else if (februaryWeek1TableView.getSelectionModel().getSelectedItem() != null ) {
                deleteAppointment(februaryWeek1TableView.getSelectionModel().getSelectedItem());
            }
            else if (februaryWeek2TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(februaryWeek2TableView.getSelectionModel().getSelectedItem());
            }
            else if (februaryWeek3TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(februaryWeek3TableView.getSelectionModel().getSelectedItem());
            }
            else if (februaryWeek4TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(februaryWeek4TableView.getSelectionModel().getSelectedItem());
            } else {
                System.out.println("Something went wrong print stack trace");
            }
        }
        else if (marchTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                marchWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                marchWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                marchWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                marchWeek4TableView.getSelectionModel().getSelectedItem() != null  ) {

            if(marchTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                deleteAppointment(marchTabByMonthTableView.getSelectionModel().getSelectedItem());
            }
            else if (marchWeek1TableView.getSelectionModel().getSelectedItem() != null ) {
                deleteAppointment(marchWeek1TableView.getSelectionModel().getSelectedItem());
            }
            else if (marchWeek2TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(marchWeek2TableView.getSelectionModel().getSelectedItem());
            }
            else if (marchWeek3TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(marchWeek3TableView.getSelectionModel().getSelectedItem());
            }
            else if (marchWeek4TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(marchWeek4TableView.getSelectionModel().getSelectedItem());
            } else {
                System.out.println("Something went wrong print stack trace");
            }
        }
        else if (aprilTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                aprilWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                aprilWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                aprilWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                aprilWeek4TableView.getSelectionModel().getSelectedItem() != null) {

            if(aprilTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                deleteAppointment(aprilTabByMonthTableView.getSelectionModel().getSelectedItem());
            }
            else if (aprilWeek1TableView.getSelectionModel().getSelectedItem() != null ) {
                deleteAppointment(aprilWeek1TableView.getSelectionModel().getSelectedItem());
            }
            else if (aprilWeek2TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(aprilWeek2TableView.getSelectionModel().getSelectedItem());
            }
            else if (aprilWeek3TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(aprilWeek3TableView.getSelectionModel().getSelectedItem());
            }
            else if (aprilWeek4TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(aprilWeek4TableView.getSelectionModel().getSelectedItem());
            } else {
                System.out.println("Something went wrong print stack trace");
            }
        }
        else if (mayTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                mayWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                mayWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                mayWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                mayWeek4TableView.getSelectionModel().getSelectedItem() != null ) {

            if(mayTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                deleteAppointment(mayTabByMonthTableView.getSelectionModel().getSelectedItem());
            }
            else if (mayWeek1TableView.getSelectionModel().getSelectedItem() != null ) {
                deleteAppointment(mayWeek1TableView.getSelectionModel().getSelectedItem());
            }
            else if (mayWeek2TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(mayWeek2TableView.getSelectionModel().getSelectedItem());
            }
            else if (mayWeek3TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(mayWeek3TableView.getSelectionModel().getSelectedItem());
            }
            else if (mayWeek4TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(mayWeek4TableView.getSelectionModel().getSelectedItem());
            } else {
                System.out.println("Something went wrong print stack trace");
            }
        }
        else if (juneTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                juneWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                juneWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                juneWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                juneWeek4TableView.getSelectionModel().getSelectedItem() != null ) {

            if(juneTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                deleteAppointment(juneTabByMonthTableView.getSelectionModel().getSelectedItem());
            }
            else if (juneWeek1TableView.getSelectionModel().getSelectedItem() != null ) {
                deleteAppointment(juneWeek1TableView.getSelectionModel().getSelectedItem());
            }
            else if (juneWeek2TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(juneWeek2TableView.getSelectionModel().getSelectedItem());
            }
            else if (juneWeek3TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(juneWeek3TableView.getSelectionModel().getSelectedItem());
            }
            else if (juneWeek4TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(juneWeek4TableView.getSelectionModel().getSelectedItem());
            } else {
                System.out.println("Something went wrong print stack trace");
            }
        }
        else if (julyTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                julyWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                julyWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                julyWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                julyWeek4TableView.getSelectionModel().getSelectedItem() != null ) {

            if(julyTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                deleteAppointment(julyTabByMonthTableView.getSelectionModel().getSelectedItem());
            }
            else if (julyWeek1TableView.getSelectionModel().getSelectedItem() != null ) {
                deleteAppointment(julyWeek1TableView.getSelectionModel().getSelectedItem());
            }
            else if (julyWeek2TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(julyWeek2TableView.getSelectionModel().getSelectedItem());
            }
            else if (julyWeek3TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(julyWeek3TableView.getSelectionModel().getSelectedItem());
            }
            else if (julyWeek4TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(julyWeek4TableView.getSelectionModel().getSelectedItem());
            } else {
                System.out.println("Something went wrong print stack trace");
            }
        }
        else if (augustTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                augustWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                augustWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                augustWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                augustWeek4TableView.getSelectionModel().getSelectedItem() != null ) {

            if(augustTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                deleteAppointment(augustTabByMonthTableView.getSelectionModel().getSelectedItem());
            }
            else if (augustWeek1TableView.getSelectionModel().getSelectedItem() != null ) {
                deleteAppointment(augustWeek1TableView.getSelectionModel().getSelectedItem());
            }
            else if (augustWeek2TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(augustWeek2TableView.getSelectionModel().getSelectedItem());
            }
            else if (augustWeek3TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(augustWeek3TableView.getSelectionModel().getSelectedItem());
            }
            else if (augustWeek4TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(augustWeek4TableView.getSelectionModel().getSelectedItem());
            } else {
                System.out.println("Something went wrong print stack trace");
            }
        }
        else if (septemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                septemberWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                septemberWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                septemberWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                septemberWeek4TableView.getSelectionModel().getSelectedItem() != null  ) {

            if(septemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                deleteAppointment(septemberTabByMonthTableView.getSelectionModel().getSelectedItem());
            }
            else if (septemberWeek1TableView.getSelectionModel().getSelectedItem() != null ) {
                deleteAppointment(septemberWeek1TableView.getSelectionModel().getSelectedItem());
            }
            else if (septemberWeek2TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(septemberWeek2TableView.getSelectionModel().getSelectedItem());
            }
            else if (septemberWeek3TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(septemberWeek3TableView.getSelectionModel().getSelectedItem());
            }
            else if (septemberWeek4TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(septemberWeek4TableView.getSelectionModel().getSelectedItem());
            } else {
                System.out.println("Something went wrong print stack trace");
            }
        }
        else if (octoberTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                octoberWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                octoberWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                octoberWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                octoberWeek4TableView.getSelectionModel().getSelectedItem() != null ) {

            if(octoberTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                deleteAppointment(octoberTabByMonthTableView.getSelectionModel().getSelectedItem());
            }
            else if (octoberWeek1TableView.getSelectionModel().getSelectedItem() != null ) {
                deleteAppointment(octoberWeek1TableView.getSelectionModel().getSelectedItem());
            }
            else if (octoberWeek2TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(octoberWeek2TableView.getSelectionModel().getSelectedItem());
            }
            else if (octoberWeek3TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(octoberWeek3TableView.getSelectionModel().getSelectedItem());
            }
            else if (octoberWeek4TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(octoberWeek4TableView.getSelectionModel().getSelectedItem());
            } else {
                System.out.println("Something went wrong print stack trace");
            }
        }
        else if (novemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                novemberWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                novemberWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                novemberWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                novemberWeek4TableView.getSelectionModel().getSelectedItem() != null ) {

            if(novemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                deleteAppointment(novemberTabByMonthTableView.getSelectionModel().getSelectedItem());
            }
            else if (novemberWeek1TableView.getSelectionModel().getSelectedItem() != null ) {
                deleteAppointment(novemberWeek1TableView.getSelectionModel().getSelectedItem());
            }
            else if (novemberWeek2TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(novemberWeek2TableView.getSelectionModel().getSelectedItem());
            }
            else if (novemberWeek3TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(novemberWeek3TableView.getSelectionModel().getSelectedItem());
            }
            else if (novemberWeek4TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(novemberWeek4TableView.getSelectionModel().getSelectedItem());
            } else {
                System.out.println("Something went wrong print stack trace");
            }
        }
        else if (decemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null ||
                decemberWeek1TableView.getSelectionModel().getSelectedItem() != null ||
                decemberWeek2TableView.getSelectionModel().getSelectedItem() != null ||
                decemberWeek3TableView.getSelectionModel().getSelectedItem() != null ||
                decemberWeek4TableView.getSelectionModel().getSelectedItem() != null ) {

            if(decemberTabByMonthTableView.getSelectionModel().getSelectedItem() != null){
                deleteAppointment(decemberTabByMonthTableView.getSelectionModel().getSelectedItem());
            }
            else if (decemberWeek1TableView.getSelectionModel().getSelectedItem() != null ) {
                deleteAppointment(decemberWeek1TableView.getSelectionModel().getSelectedItem());
            }
            else if (decemberWeek2TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(decemberWeek2TableView.getSelectionModel().getSelectedItem());
            }
            else if (decemberWeek3TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(decemberWeek3TableView.getSelectionModel().getSelectedItem());
            }
            else if (decemberWeek4TableView.getSelectionModel().getSelectedItem() != null) {
                deleteAppointment(decemberWeek4TableView.getSelectionModel().getSelectedItem());
            } else {
                System.out.println("Something went wrong print stack trace");
            }
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

    // exit customer records method
    @FXML
    public void onExitButtonClick(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage popUp = (Stage) source.getScene().getWindow();
        popUp.close();
        closeConnection();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerTableSetup();
        appointmentTableSetup();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
