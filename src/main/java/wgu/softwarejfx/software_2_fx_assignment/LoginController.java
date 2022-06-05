package wgu.softwarejfx.software_2_fx_assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

//future enhancement make the event action based in order to interact keyboard actions as well as mouse clicks
public class LoginController implements Initializable {

    @FXML
    Label welcomeLabel;
    @FXML
    Label usernameLabel;
    @FXML
    Label passwordLabel;
    @FXML
    Label currentLocationLabel;
    @FXML
    Label languageLabel;
    @FXML
    TextField usernameTextField;
    @FXML
    TextField passwordTextField;
    @FXML
    TextField currentLocationTextField;
    @FXML
    TextField languageTextField;
    @FXML
    Button logInButton;
    @FXML
    Button exitButton;

    public void localeHandling(){
        Locale locale = Locale.getDefault();
        System.out.println(locale);
    }

    //credential validator with error messages

    public void zoneIdHandling(){
        System.out.println(ZoneId.systemDefault());
    }

    @FXML
    protected void onExitButtonClick(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage popUp = (Stage) source.getScene().getWindow();
        popUp.close();
        //Add connection killer here
    }

    public void loginSceneChange(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(CustomerRecordsMainMenu.class.getResource("customer-records-main-menu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //login activity logging file
    public void activityLogger(){
        Logger.getLogger("testTxt");
        LogRecord x = "Dook";
        Logger.getLogger("testTxt").log("Dook");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        localeHandling();
        zoneIdHandling();
    }
}
