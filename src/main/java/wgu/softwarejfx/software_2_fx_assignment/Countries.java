package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

public class Countries {

    int countryId;
    String countryName;
    LocalDateTime createDate;
    String createdBy;
    LocalDateTime lastUpdate;
    String lastUpdateBy;
    public static ObservableList<Countries> allCountries = FXCollections.observableArrayList();
    public static ObservableList<String> allCountryNames = FXCollections.observableArrayList();

    public Countries(int countryId, String countryName, LocalDateTime createDate, String createdBy, LocalDateTime lastUpdate, String lastUpdateBy){
        this.countryId = countryId;
        this.countryName = countryName;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }

    public static Countries countryLookupByName(String countryToBeFound){
        Countries countryFound = null;

        for (Countries countriesExamination : allCountries){
            if(countriesExamination.countryName.equals(countryToBeFound)){
                countryFound = countriesExamination;
            }
        }

        return countryFound;
    }

    public static void addCountry(Countries newCountry){
        allCountries.add(newCountry);
    }

    public static ObservableList<Countries> getAllCountries(){
        return allCountries;
    }

    public static ObservableList<String> getAllCountryNames(){

        for (Countries countryCage : allCountries){
            allCountryNames.add(countryCage.countryName);
        }

        return allCountryNames;
    }

}
