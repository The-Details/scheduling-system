package wgu.softwarejfx.software_2_fx_assignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

public class FirstLevelDivisions {

    int divisionId;
    String division;
    LocalDateTime createDate;
    String createdBy;
    LocalDateTime lastUpdate;
    String lastUpdateBy;
    int countryId;

    public static ObservableList<FirstLevelDivisions> allFirstLevelDivisions = FXCollections.observableArrayList();

    public FirstLevelDivisions(int divisionId, String divisionName, LocalDateTime createDate, String createdBy,LocalDateTime lastUpdate, String lastUpdateBy, int countryId){
        this.divisionId = divisionId;
        this.division = divisionName;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
        this.countryId = countryId;
    }

    public void addFirstLevelDivisions(FirstLevelDivisions newDivision){
        allFirstLevelDivisions.add(newDivision);
    }

    public ObservableList<FirstLevelDivisions> getAllFirstLevelDivisions() {
        return allFirstLevelDivisions;
    }
}
