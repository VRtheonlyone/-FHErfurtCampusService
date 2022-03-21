package de.fherfurt.campus.main;
import java.util.*;

import static de.fherfurt.campus.constants.Constants.*;


public class Campus{

    public enum CampusNames {
        SCHLUETER {
            public String toString() {return "Schlüterstrasse";}
        },
        LEIPZIGER {
            public String toString() {return "Leipziger Strasse";}
             },
        ALTONAER {
            public String toString() {return "Altonaer Strasse";}
            };

        public String getGeoLocation (CampusNames CampusName)
        {
            String geoLocation = null;
            switch (CampusName)
            {
                case ALTONAER -> geoLocation = "50.98519525217564, 11.042288954127";
                case LEIPZIGER -> geoLocation = "50.991562842099846, 11.054766412935898";
                case SCHLUETER -> geoLocation = "50.98546658637294, 11.024502423668306";
            }
            return geoLocation;
        }
        public String getGoogleMapsLink (CampusNames CampusName)
        {
            String googleMapsLink = null;
            switch (CampusName)
            {
                case ALTONAER -> googleMapsLink = "https://www.google.com/maps/place/Fachhochschule+Erfurt/@50.9847913,11.0393064,17z/data=!3m1!4b1!4m5!3m4!1s0x47a472a47d51a0b7:0x16ba89c33fce2610!8m2!3d50.9847913!4d11.0414951";
                case LEIPZIGER -> googleMapsLink = "https://www.google.com/maps/place/Fachhochschule+Erfurt+Fakult%C3%A4t+Landschaftsarchitektur,+Gartenbau+und+Forst/@50.9854684,10.9543179,12z/data=!4m9!1m2!2m1!1sfachhochschule+erfurt+leipziger+stra%C3%9Fe!3m5!1s0x47a46d6626587ca9:0x624e599fe2e47072!8m2!3d50.991596!4d11.05474!15sCidmYWNoaG9jaHNjaHVsZSBlcmZ1cnQgbGVpcHppZ2VyIHN0cmHDn2WSAQdjb2xsZWdl";
                case SCHLUETER -> googleMapsLink = "https://www.google.com/maps/place/Fachhochschule+Erfurt/@50.9853681,11.0156024,15z/data=!4m5!3m4!1s0x47a4729a45e601a1:0x2b531ca1439d5f49!8m2!3d50.9853478!4d11.0243661";
            }
            return googleMapsLink;
        }

    }

    private Integer campusID;
    private String campusGeoLocation;
    private String campusTitle;
    private String googleMapsLink;
    private List<Building> campusBuildings;
    private Map<String, List<String>> allCampusData = new HashMap<>();

    private static Integer campusCounter = 0;
    private static final int CampusInstancesLimit = 3;
    private static final Campus dummyCampus = new Campus();
    private static final List<Building> dummyBuildingList = new ArrayList<>();

    private Campus(){};
    private Campus(CampusNames campusTitle, String campusGeoLocation, String googleMapsLink) {
        campusCounter += 1;
        setIdForCampus(campusCounter);
        setTitleForCampus(campusTitle.toString());
        setGeographicalCoordinatesForCampus(campusGeoLocation);
        setGoogleMapsLink(googleMapsLink);
    }


    public static synchronized Campus getInstance() {
        if(campusCounter < CampusInstancesLimit){
            CampusNames createdCampusName = CampusNames.values()[campusCounter];
            return new Campus(createdCampusName, createdCampusName.getGeoLocation(createdCampusName), createdCampusName.getGoogleMapsLink(createdCampusName));
        }

        return dummyCampus;
    }

    public void setIdForCampus (Integer campusID) {

        this.campusID = campusID;
        List<String> IDs = new ArrayList<>();
        IDs.add(String.valueOf(campusID));

        this.allCampusData.put(ID, IDs);
        updateCampusDataHashmap();
    }
    public void setGeographicalCoordinatesForCampus (String campusGeoLocation) {

        this.campusGeoLocation = campusGeoLocation;
        List<String> GeoLocation = new ArrayList<>();
        GeoLocation.add(campusGeoLocation);

        this.allCampusData.put(GEOLOCATION, GeoLocation);
        DataCollector.getCampusData().put(campusGeoLocation, this.allCampusData);
    }
    public void setGoogleMapsLink(String googleMapsLink) {
        this.googleMapsLink = googleMapsLink;
    }
    public void setTitleForCampus (String campusTitle) {

        this.campusTitle = campusTitle;
        List<String> campusTitles = new ArrayList<>();
        campusTitles.add(campusTitle);

        this.allCampusData.put(TITLE, campusTitles);
        updateCampusDataHashmap();
    }
    public void setBuildingsForCampus (List<Building> campusBuildings) {

        this.campusBuildings = campusBuildings;
        List<String> campusBuildingTitles = new ArrayList<>();

        for (Building building : campusBuildings) {
            campusBuildingTitles.add(building.getTitle());
        }

        this.allCampusData.put(BUILDING, campusBuildingTitles);
        updateCampusDataHashmap();
    }

    public String getGoogleMapsLink() {return Objects.requireNonNullElse(this.googleMapsLink, "");}
    public Integer getCampusID() {return Objects.requireNonNullElse(this.campusID, 0);}
    public String getCampusGeoLocation() {return Objects.requireNonNullElse(this.campusGeoLocation, "");}
    public String getCampusTitle () {return Objects.requireNonNullElse(this.campusTitle, "");}
    public List<Building> getCampusBuildings () {return Objects.requireNonNullElse(this.campusBuildings, initializeAndGetDummyCampusBuildings());}

    public List<Building> initializeAndGetDummyCampusBuildings() {

        dummyBuildingList.add(Building.dummyBuilding);
        return dummyBuildingList;
    }
    public void deleteBuildingFromCampus(Building _building) {

        if(this.campusBuildings.remove(_building)) {
            List<String> buildingList = new ArrayList<>();

            for (Building building : campusBuildings) {
                buildingList.add(building.getTitle());
            }
            this.allCampusData.put(BUILDING, buildingList);
            updateCampusDataHashmap();
        }
    }
    public void addBuildingToCampus(Building _building) {

        this.campusBuildings.add(_building);
        List<String> buildingList = new ArrayList<>();

        for (Building building : campusBuildings) {
            buildingList.add(building.getTitle());
        }
        this.allCampusData.put(BUILDING, buildingList);
        updateCampusDataHashmap();
    }
    public void updateCampusDataHashmap() {

        Map<String, Map<String, List<String>>> UpdatedCampusData = DataCollector.getCampusData();
        UpdatedCampusData.put(this.campusTitle,this.allCampusData);
        DataCollector.setCampusData(UpdatedCampusData);
    }
}
