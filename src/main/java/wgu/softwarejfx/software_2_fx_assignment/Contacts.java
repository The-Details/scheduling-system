package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

public class Contacts {
    
    int contactId;
    String contactName;
    String email;

    public static ObservableList<Contacts> allContacts = FXCollections.observableArrayList();
    public static ObservableList<MenuItem> contactMenuItems = FXCollections.observableArrayList();
    
    public Contacts(int contactId, String contactName, String email){
     this.contactId = contactId;
     this.contactName = contactName;
     this.email = email;
    }

    public static Contacts newContact(String contactName, String email){
        Contacts contactInfo = new Contacts(allContacts.size() + 1, contactName, email);
        allContacts.add(contactInfo);
        contactMenuItems.add(new MenuItem(contactInfo.getContactName()));
        return contactInfo;
    }

    /**
     *
     * @param id
     */
    private void setContactId(int id){
       this.contactId = id;
    }

    /**
     *
     * @param name
     */
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
