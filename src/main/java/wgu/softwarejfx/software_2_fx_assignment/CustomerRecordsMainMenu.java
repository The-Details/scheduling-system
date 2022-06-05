package wgu.softwarejfx.software_2_fx_assignment;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDateTime;

public class CustomerRecordsMainMenu {

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
    TableView<Appointments> januaryTableView;
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


    // setting up customer cols

    // setting up appoint cols

    //customers data method

    // add appointment method

    // add customer method

    // modify customer method

    // delete customer method

    // appointments searchbar methods

    // customer searchbar methods

    // jan appointment data method

    // feb appointment data method

    // mar appointment data method

    // apr appointment data method

    // may appointment data method

    // jun appointment data method

    // jul appointment data method

    // aug appointment data method

    // sep appointment data method

    // oct appointment data method

    // nov appointment data method

    // dec appointment data method

    // view switching method

    // modify appointment method

    // delete appointment method

    // exit customer records method
}
