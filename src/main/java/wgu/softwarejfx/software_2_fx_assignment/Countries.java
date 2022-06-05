package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

public class Countries {

    int countryId;
    String country;
    LocalDateTime createDate;
    String createdBy;
    LocalDateTime lastUpdate;
    String lastUpdateBy;
    public static ObservableList<Countries> allCountries = FXCollections.observableArrayList();

    public Countries(int countryId, String countryName, LocalDateTime createDate, String createdBy, LocalDateTime lastUpdate, String lastUpdateBy){
        this.countryId = countryId;
        this.country = countryName;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }

    public void addCountry(Countries newCountry){
        allCountries.add(newCountry);
    }

    public ObservableList<Countries> getAllCountries(){
        return allCountries;
    }

}
