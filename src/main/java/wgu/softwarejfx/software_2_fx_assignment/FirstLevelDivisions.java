package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

/**
 * This class serves as a basis for manipulating FirstLevelDivisions data
 */
public class FirstLevelDivisions {

    int divisionId;
    String divisionName;
    LocalDateTime createDate;
    String createdBy;
    LocalDateTime lastUpdate;
    String lastUpdateBy;
    int countryId;

    public static ObservableList<FirstLevelDivisions> allFirstLevelDivisions = FXCollections.observableArrayList();
    public static ObservableList<FirstLevelDivisions> allUnitedStates = FXCollections.observableArrayList();
    public static ObservableList<FirstLevelDivisions> allCanadianProvinces = FXCollections.observableArrayList();
    public static ObservableList<FirstLevelDivisions> allUnitedKingdomRegions = FXCollections.observableArrayList();
    public static ObservableList<String> allBoroughs = FXCollections.observableArrayList();
    public static ObservableList<String> allStateNames = FXCollections.observableArrayList();
    public static ObservableList<String> allCanadianProvinceNames = FXCollections.observableArrayList();
    public static ObservableList<String> allUKRegionNames = FXCollections.observableArrayList();


    public FirstLevelDivisions(int divisionId, String divisionName, LocalDateTime createDate, String createdBy,LocalDateTime lastUpdate, String lastUpdateBy, int countryId){
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
        this.countryId = countryId;
    }

    /**
     * This method add United Kingdom borough strings to an array for customer manipulation.
     */
    public static void setAllBoroughs(){
        allBoroughs.addAll(
                "Barking and Dagenham",
                "Barnet",
                "Bexley",
                "Brent",
                "Bromley",
                "Camden",
                "Croydon",
                "Ealing",
                "Enfield",
                "Greenwich",
                "Hackney",
                "Hammersmith and Fulham",
                "Haringey",
                "Harrow",
                "Havering",
                "Hillingdon",
                "Hounslow",
                "Islington",
                "Kensington and Chelsea",
                "Kingston upon Thames",
                "Lambeth",
                "Lewisham",
                "Merton",
                "Newham",
                "Redbridge",
                "Richmond upon Thames",
                "Southwark",
                "Sutton",
                "Tower Hamlets",
                "Waltham Forest",
                "Wandsworth",
                "Westminster",
                "City of London"
        );
    }

    /**
     * This method filters country's first division data into corresponding arrays
     */
    public static void firstDivisionFilter(){

        for (FirstLevelDivisions region : getAllFirstLevelDivisions()){
            if(region.countryId == 1){
                allUnitedStates.add(region);
            }
            else if(region.countryId == 2){
                allUnitedKingdomRegions.add(region);
            }
            else if(region.countryId == 3){
                allCanadianProvinces.add(region);
            }
        }
    }

    /**
     *
     * @param stateProvinceName
     * This method is used find first division data by using the associated state or province name
     * @return
     * The data for that first division is returned
     */
    public static FirstLevelDivisions firstDivisionLookupName(String stateProvinceName){
        FirstLevelDivisions stateProvinceData = null;

        for (FirstLevelDivisions stateProvincePigeonHole : allFirstLevelDivisions){
            if(stateProvincePigeonHole.divisionName.equals(stateProvinceName)){
                stateProvinceData = stateProvincePigeonHole;
            }
        }
        return stateProvinceData;
    }

    /**
     *
     * @param divisionId
     * This method is used find first division data using the associated division id
     * @return
     * The data for that first division is returned
     */
    public static FirstLevelDivisions firstDivisionLookupById(int divisionId){
        FirstLevelDivisions stateProvinceData = null;

        for (FirstLevelDivisions stateProvincePigeonHole : getAllFirstLevelDivisions()){
            if(stateProvincePigeonHole.divisionId == divisionId){
                stateProvinceData = stateProvincePigeonHole;
            }
        }
        return stateProvinceData;
    }

    public void addFirstLevelDivisions(FirstLevelDivisions newDivision){
        getAllFirstLevelDivisions().add(newDivision);
    }

    public static ObservableList<FirstLevelDivisions> getAllFirstLevelDivisions() {
        return allFirstLevelDivisions;
    }

    /**
     * This method get all United States names and returns them
     * @return
     * An array of stringed state names are returned
     */
    public static ObservableList<String> getAllStateNames(){
        for (FirstLevelDivisions stateCage : allUnitedStates){
            allStateNames.add(stateCage.divisionName);
        }

        return allStateNames;
    }

    /**
     * This method get all Canadian province names and returns them
     * @return
     *  An array of stringed province names are returned
     */
    public static ObservableList<String> getAllCanadianProvinceNames(){
        for (FirstLevelDivisions provinceCage : allCanadianProvinces){
            allCanadianProvinceNames.add(provinceCage.divisionName);
        }
        return allCanadianProvinceNames;
    }

    /**
     * This method get all United Kingdom region names and returns them
     * @return
     *  An array of stringed region names are returned
     */
    public static ObservableList<String> getAllUKRegionNames(){
        for (FirstLevelDivisions regionCage : allUnitedKingdomRegions){
            allUKRegionNames.add(regionCage.divisionName);
        }
        return allUKRegionNames;
    }

}
