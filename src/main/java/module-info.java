module wgu.softwarejfx.software_2_fx_assignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens wgu.softwarejfx.software_2_fx_assignment to javafx.fxml;
    exports wgu.softwarejfx.software_2_fx_assignment;
}