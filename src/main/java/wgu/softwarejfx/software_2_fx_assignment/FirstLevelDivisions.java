package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

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

    public static void firstDivisionFilter(){

        for (FirstLevelDivisions region : allFirstLevelDivisions){
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

    public static FirstLevelDivisions firstDivisionLookup(String stateProvinceName){
        FirstLevelDivisions stateProvinceData = null;

        for (FirstLevelDivisions stateProvincePigeonHole : allFirstLevelDivisions){
            if(stateProvincePigeonHole.divisionName.equals(stateProvinceName)){
                stateProvinceData = stateProvincePigeonHole;
            }
        }
        return stateProvinceData;
    }

    public void addFirstLevelDivisions(FirstLevelDivisions newDivision){
        allFirstLevelDivisions.add(newDivision);
    }

    public ObservableList<FirstLevelDivisions> getAllFirstLevelDivisions() {
        return allFirstLevelDivisions;
    }

    public static ObservableList<String> getAllStateNames(){
        for (FirstLevelDivisions stateCage : allUnitedStates){
            allStateNames.add(stateCage.divisionName);
        }

        return allStateNames;
    }

    public static ObservableList<String> getAllCanadianProvinceNames(){
        for (FirstLevelDivisions provinceCage : allCanadianProvinces){
            allCanadianProvinceNames.add(provinceCage.divisionName);
        }
        return allCanadianProvinceNames;
    }

    public static ObservableList<String> getAllUKRegionNames(){
        for (FirstLevelDivisions regionCage : allUnitedKingdomRegions){
            allUKRegionNames.add(regionCage.divisionName);
        }
        return allUKRegionNames;
    }

}
