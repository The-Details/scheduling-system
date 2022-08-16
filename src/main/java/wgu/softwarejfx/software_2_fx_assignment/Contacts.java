package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class serves as a basis for manipulating contact data
 */
public class Contacts {
    
    int contactId;
    String contactName;
    String email;
    static Statement insertContactStmt;
    static String insertContact;
    static int insertContactResultSet;

    public static ObservableList<Contacts> allContacts = FXCollections.observableArrayList();
    public static ObservableList<MenuItem> contactMenuItems = FXCollections.observableArrayList();
    
    public Contacts(int contactId, String contactName, String email){
     this.contactId = contactId;
     this.contactName = contactName;
     this.email = email;
    }

    /**
     *
     * @param contactName
     * A string of the contact name is collect from an add customer form textfield
     * @param email
     * A string of the contact email is collect from an add customer form textfield
     * @return
     * The data collect is used to make a new contact
     */
    public static Contacts newContact(String contactName, String email) throws SQLException {
        Contacts contactInfo = new Contacts(allContacts.size() + 1, contactName, email);
        allContacts.add(contactInfo);
        contactMenuItems.add(new MenuItem(contactInfo.getContactName()));

        insertContactStmt = SchedulingSystem.connection.createStatement();
        insertContact = "Insert INTO contacts (contact_id, contact_name, email) "
                + "values('" + contactInfo.contactId
                + "', '" + contactInfo.contactName + "', '" + contactInfo.email + "')";
        insertContactResultSet = insertContactStmt.executeUpdate(insertContact);

        return contactInfo;
    }

    /**
     *
     * @param contactId
     * This method is used find a contact using the associated contact id
     * @return
     * A contact is returned
     */
    public static Contacts lookupContactById(int contactId){
        Contacts foundContact = null;
        for(Contacts contactCage: allContacts){
            if (contactCage.contactId == contactId){
                foundContact = contactCage;
            }
        }
        return foundContact;
    }

    /**
     *
     * @param contactName
     * This method is used find a contact using the associated contact name
     * @return
     * A contact is returned
     */
    public static Contacts lookupContactByName(String contactName){
        Contacts foundContact = null;
        for(Contacts contactCage: allContacts){
            if (contactCage.contactName.equals(contactName)){
                foundContact = contactCage;
            }
        }
        return foundContact;
    }

    public static Contacts contactExistenceChecker(String contactName, String contactEmail) throws SQLException {
        Contacts contact = null;

        if (lookupContactByName(contactName) != null) {
            for (Contacts findTheContact : allContacts) {
                if (findTheContact.contactName.equals(contactName) && findTheContact.email.equals(contactEmail)) {
                    contact = findTheContact;
                }
            }
        }
        else {
            contact = newContact(contactName, contactEmail);
        }


        return contact;
    }

    /**
     *
     * @param id
     */
    private void setContactId(int id){
       this.contactId = id;
    }


    private void setContactName(String name){
        this.contactName = name;
    }

    /**
     *
     * @param email
     */
    private void setEmail(String email){
        this.email = email;
    }

    /**
     *
     * @return
     */
    private int getContactId(){
        return contactId;
    }

    /**
     *
     * @return
     */
    private String getContactName(){
        return contactName;
    }

    /**
     *
     * @return
     */
    private String getEmail(){
        return email;
    }

}
