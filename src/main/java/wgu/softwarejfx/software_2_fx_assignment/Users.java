package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Users {
    int userId;
    String username;
    String password;

    public static ObservableList<Users> allUsers = FXCollections.observableArrayList();

    public Users(int userId, String username, String password){
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public static Users lookupUser(int userId){
        Users fbiBreakingDownYourFrontDoor = null;
        for(Users nsaBackDoor : allUsers){
            if(nsaBackDoor.getUserId() == userId){
                fbiBreakingDownYourFrontDoor = nsaBackDoor;
            }
        }
        return fbiBreakingDownYourFrontDoor;
    }

    public static boolean validateUserInfo(String username, String password){
        boolean invalidUntilProvenValid = false;
        for(Users validator : allUsers){
            if (validator.getUsername().equals(username) && validator.getPassword().equals(password)) {
                invalidUntilProvenValid = true;
                break;
            }
        }
        return invalidUntilProvenValid;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
