package wgu.softwarejfx.software_2_fx_assignment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_2_fx_assignment.SchedulingSystem.closeConnection;
import static wgu.softwarejfx.software_2_fx_assignment.Users.lookupUserByName;
import static wgu.softwarejfx.software_2_fx_assignment.Users.validateUserInfo;

/**
 * This class manipulates incoming user data
 *
 * FUTURE ENHANCEMENTS: make the event action based in order to interact keyboard actions as well as mouse clicks
 */
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

    public static String currentUser;
    public static int currentUserId;

    /**
     * This method login text language conversion with the help of a message bundle
     * @throws IOException
     */
    public void localeHandling() throws IOException {
        try{
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
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     *
     * @param event
     * This method is responsible for checking the validity of the user credentials
     */
    //credential validator with error messages
    public void logInButtonOnClick(MouseEvent event){
        try {
            if(validateUserInfo(usernameTextField.getText(), passwordTextField.getText())){
                loginSceneChange(event);
                activityLogger("Success");
                currentUser = usernameTextField.getText();
                currentUserId = lookupUserByName(usernameTextField.getText()).getUserId();
            }
            else {
                System.out.println(errorMessage);
                usernameTextField.setText("");
                passwordTextField.setText("");
                activityLogger("Failed");

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text(errorMessage);
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


    /**
     * This method sets the zone Id textfield
     */
    public void zoneIdHandling(){
        try {
            currentLocationTextField.setDisable(true);
            currentLocationTextField.setText(String.valueOf(ZoneId.systemDefault()));

            System.out.println(ZoneId.systemDefault());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param event
     * This takes a mouse event called event when the exit button is click to close the login form
     */
    @FXML
    protected void onExitButtonClick(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage popUp = (Stage) source.getScene().getWindow();
        popUp.close();
        closeConnection();
    }

    public void loginSceneChange(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(CustomerRecordsMainMenu.class.getResource("customer-records-main-menu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * @param loginStatus
     * This method logs the information generated when logging or the failure to tdo so
     */
    //login activity logging file
    public void activityLogger(String loginStatus){
        int attemptCount = 1;

        try{
            SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());

            File loginActivity = new File("login_activity.txt");
            if(loginActivity.createNewFile()){
                System.out.println("Login Activity Log Created");
                FileWriter logActivity = new FileWriter("login_activity.txt");
                logActivity.write("[" + ZoneId.systemDefault() + "][" + dateTimeFormatter.format(date) + "]: "
                        + usernameTextField.getText() + " -- " + loginStatus + " - Attempts: " + attemptCount);
                logActivity.close();
                System.out.println("Login Activity Logged");
            }
            else{
                FileWriter logActivity = new FileWriter("login_activity.txt");
                logActivity.write("[" + ZoneId.systemDefault() + "][" + dateTimeFormatter.format(date) + "]: "
                        + usernameTextField.getText() + " -- " + loginStatus + " - Attempts: " + attemptCount);
                logActivity.close();
                System.out.println("Login Activity Logged");
            }
        }catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        attemptCount++;
    }

    /**
     *
     * @param url
     * @param resourceBundle
     * This method is run at the start of the program to collect any information needed
     */
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
