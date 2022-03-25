package de.fherfurt.campus.utilities;

import de.fherfurt.campus.main.Campus;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Vadim Rodt, vadim.rodt@fh-erfurt.de
 * The Browser class will later be used to navigate users to the Campus that they have chosen on the UI.
 * For now, it gets a user input value between 1 and 3 to navigate to one of the three campuses.
 * Then the main browser of the user is opened with a link to the address of the Campus.
 **/

public class Browser {

    public static void printChooseCampusID() {

        System.out.println("To which Campus do you want to be navigated?");
        System.out.printf("Enter 1 for %s\n", Campus.CampusNames.values()[0]);
        System.out.printf("Enter 2 for %s\n", Campus.CampusNames.values()[1]);
        System.out.printf("Enter 3 for %s\n", Campus.CampusNames.values()[2]);
    }
    public static void printChooseValidId() {

        System.out.println("Please enter a valid number!");
    }
    public static String getLinkAccordingToID() {

        Scanner scanner = new Scanner(System.in);
        String url;
        int campusIdInput = 0;

        while(campusIdInput != 1 && campusIdInput != 2 && campusIdInput != 3) {

            printChooseValidId();
            printChooseCampusID();

            try{campusIdInput = scanner.nextInt();}
            catch(InputMismatchException e){System.out.println("Input must be an Integer!");break;}
        }

            switch(campusIdInput) {

                case (1) -> url = "https://www.google.com/maps/place/Fachhochschule+Erfurt/@50.9853681,11.0156024,15z/data=!4m5!3m4!1s0x47a4729a45e601a1:0x2b531ca1439d5f49!8m2!3d50.9853478!4d11.0243661";
                case (2) -> url = "https://www.google.com/maps/place/Fachhochschule+Erfurt+Fakult%C3%A4t+Landschaftsarchitektur,+Gartenbau+und+Forst/@50.9854684,10.9543179,12z/data=!4m9!1m2!2m1!1sfachhochschule+erfurt+leipziger+stra%C3%9Fe!3m5!1s0x47a46d6626587ca9:0x624e599fe2e47072!8m2!3d50.991596!4d11.05474!15sCidmYWNoaG9jaHNjaHVsZSBlcmZ1cnQgbGVpcHppZ2VyIHN0cmHDn2WSAQdjb2xsZWdl";
                case (3) -> url = "https://www.google.com/maps/place/Fachhochschule+Erfurt/@50.9847913,11.0393064,17z/data=!3m1!4b1!4m5!3m4!1s0x47a472a47d51a0b7:0x16ba89c33fce2610!8m2!3d50.9847913!4d11.0414951";
                default -> url = "https://i.imgflip.com/428sai.jpg";
            }
            return url;
        }
    public static void openBrowserLink() {

        String url = getLinkAccordingToID();

        if(Desktop.isDesktopSupported()){
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }else{
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("xdg-open " + url);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }}

    public static void main(String[] args) {
        openBrowserLink();
    }
}