package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class serves as a basis for manipulating user data
 */
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

    /**
     *
     * @param userId
     * This method is used find a user using the associated user Id
     * @return
     * A user is returned
     */
    public static Users lookupUserById(int userId){
        Users fbiBreakingDownYourFrontDoor = null;
        for(Users nsaBackDoor : allUsers){
            if(nsaBackDoor.getUserId() == userId){
                fbiBreakingDownYourFrontDoor = nsaBackDoor;
            }
        }
        return fbiBreakingDownYourFrontDoor;
    }

    /**
     *
     * @param username
     * This method is used find a user using the associated username
     * @return
     * A user is returned
     */
    public static Users lookupUserByName(String username){
        Users fbiBreakingDownYourFrontDoor = null;
        for(Users nsaBackDoor : allUsers){
            if(nsaBackDoor.getUsername().equals(username)){
                fbiBreakingDownYourFrontDoor = nsaBackDoor;
            }
        }
        return fbiBreakingDownYourFrontDoor;
    }

    /**
     *
     * @param username
     * The username is used to locate any matching users with that name
     * @param password
     * The password is used to verify that username
     * @return
     * True or False is returned
     */
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
