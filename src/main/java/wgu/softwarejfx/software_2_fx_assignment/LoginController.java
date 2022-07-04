package wgu.softwarejfx.software_2_fx_assignment;

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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

import static wgu.softwarejfx.software_2_fx_assignment.Users.validateUserInfo;

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
    String errorMessage;
    public Locale currentLocale;
    public static ResourceBundle logInFormText;

    public void localeHandling() throws IOException {
        Locale locale = Locale.getDefault();
        languageTextField.setDisable(true);
        languageTextField.setText(String.valueOf(locale.getDisplayLanguage()));

        currentLocale = new Locale(locale.getLanguage(), locale.getCountry());

        logInFormText = ResourceBundle.getBundle("MessagesBundle", currentLocale);

        welcomeLabel.setText(logInFormText.getString("welcomeLabel"));
        usernameLabel.setText(logInFormText.getString("usernameLabel"));
        passwordLabel.setText(logInFormText.getString("passwordLabel"));
        logInButton.setText(logInFormText.getString("loginButton"));
        currentLocationLabel.setText(logInFormText.getString("location"));
        languageLabel.setText(logInFormText.getString("language"));
        exitButton.setText(logInFormText.getString("exitButton"));
        errorMessage = logInFormText.getString("loginError");

        System.out.println(locale);
    }

    //credential validator with error messages
    public void logInButtonOnClick(MouseEvent event) throws IOException {
        if(validateUserInfo(usernameTextField.getText(), passwordTextField.getText())){
            loginSceneChange(event);
            activityLogger("Success");
        }
        else {
            System.out.println(errorMessage);
            System.out.println("Error: Incorrect username and/or password!");
            usernameTextField.setText("");
            passwordTextField.setText("");
            activityLogger("Failed");
        }

    }


    public void zoneIdHandling(){
        currentLocationTextField.setDisable(true);
        currentLocationTextField.setText(String.valueOf(ZoneId.systemDefault()));

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
    public void activityLogger(String loginStatus){
        try{
            SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());

            File loginActivity = new File("loginActivity.txt");
            if(loginActivity.createNewFile()){
                System.out.println("Login Activity Log Created");
                FileWriter logActivity = new FileWriter("loginActivity.txt");
                logActivity.write("[" + ZoneId.systemDefault() + "][" + dateTimeFormatter.format(date) + "]: "
                        + usernameTextField.getText() + " -- " + loginStatus);
                logActivity.close();
                System.out.println("Login Activity Logged");
            }
            else{
                FileWriter logActivity = new FileWriter("loginActivity.txt");
                logActivity.write("[" + ZoneId.systemDefault() + "][" + dateTimeFormatter.format(date) + "]: "
                        + usernameTextField.getText() + " -- " + loginStatus);
                logActivity.close();
                System.out.println("Login Activity Logged");
            }
        }catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            localeHandling();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        zoneIdHandling();
    }
}
