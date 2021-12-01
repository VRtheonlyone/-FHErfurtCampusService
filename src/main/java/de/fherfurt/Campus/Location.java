package de.fherfurt.Campus;

public class Location {

    private String[] Campus= {"SCHLÜTERSTRAßE", "LEIPZIGERSTR", "ALTONAERSTRAßE"};


    private float[] Coordinates;


    public Location(String[] _Campus, float[] _Coordinates) {

        this.Campus=_Campus;
        this.Coordinates=_Coordinates;
    }
}
