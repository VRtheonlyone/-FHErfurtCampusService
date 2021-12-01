package de.fherfurt.Campus;

public class Building {
        public boolean accessibility;
        public String[] buildingType={"MENSA", "SPORTHALLE", "LEHRGEBÄUDE", "BIBLIOTHEK"};

    public Building(boolean _accessibility, String[] _buildingType) {

        this.accessibility=_accessibility;
        this.buildingType=_buildingType;
    }
}
