package de.fherfurt.Campus;

public class Location {

    private String[] Campus = {"SCHLÜTERSTRASSE", "LEIPZIGERSTRASSE", "ALTONAERSTRASSE"};

    private float[] Coordinates;

    public Location(String[] _Campus, float[] _Coordinates) {

        this.Campus=_Campus;
        this.Coordinates=_Coordinates;
    }
}
