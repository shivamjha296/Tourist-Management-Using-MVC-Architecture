/**
 * Identification comments:
 *   Name: Shivam Jha D2B 22
 *   Experiment Title: Java Mini Project
 *   Experiment Date: 01/04/24
 *   @version 1.0
 * Beginning comments:
 * Filename: View.java
 * @author:  Shivam Jha
 * Overview: The View class represents the user interface of an application, and it is responsible for presenting data to the
 *           user and receiving input from them. It is typically used in the Model-View-Controller (MVC) architectural pattern,
 *           where the View is the part of the application that interacts with the user and displays information.
 *The class provides methods for setting up initial layouts for tourist, city, and enrollment panels, as well as updating the display with new data. Specifically:
 * - centerInitialSetupTourist(linesBeingDisplayed, size): Sets up the initial layout for the tourist panel.
 * - centerInitialSetupEnroll(linesBeingDisplayed, size): Sets up the initial layout for the enrollment panel.
 * - centerInitialSetupCity(linesBeingDisplayed, size): Sets up the initial layout for the city panel.
 * - centerUpdateCity(lines, headers): Updates the city panel with new data.
 * - centerUpdateTourist(lines, headers): Updates the tourist panel with new data.
 * - centerUpdateEnroll(lines, headers): Updates the enrollment panel with new data.
 * It also provides getter and setter methods for accessing and modifying the frames and panels within the application.
 */


package View;

import View.Booking.ManageBookingFrame;
import View.Cities.ManageCitiesFrame;

import java.awt.*;
import java.util.ArrayList;

public class View {
    FirstFrame ff;
    ManageTouristFrame mtf;
    ManageCitiesFrame mcf;
    ManageBookingFrame mbf;


    public View() {
        ff = new FirstFrame();
        mtf = new ManageTouristFrame();
        mcf = new ManageCitiesFrame();
        mbf = new ManageBookingFrame();

    }

    public void centerInitialSetupTourist(int linesBeingDisplayed, int size) {
        mtf.getTourist_ip().getCpt().setLayout(new GridLayout(linesBeingDisplayed + 1, size));
        mtf.getTourist_ip().getCpt().createButtons((linesBeingDisplayed + 1) * size);
    }
    public void centerInitialSetupBooking(int linesBeingDisplayed, int size) {
        mbf.getBooking_ip().getBtp().setLayout(new GridLayout(linesBeingDisplayed + 1, size));
        mbf.getBooking_ip().getBtp().createButtons((linesBeingDisplayed + 1) * size);
    }

    public void centerInitialSetupCity(int linesBeingDisplayed, int size) {
        mcf.getCity_ip().getCtp().setLayout(new GridLayout(linesBeingDisplayed + 1, size));
        mcf.getCity_ip().getCtp().createButtons((linesBeingDisplayed + 1) * size);
    }

    public void centerUpdateCity(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++) {
            mcf.getCity_ip().getCtp().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int course_row_no = 0; course_row_no < lines.size(); course_row_no++) {
            for (int course_col_no = 0; course_col_no < headers.size(); course_col_no++) {
                int button_no = course_row_no * headers.size() + headers.size() + course_col_no;
                String button_txt = lines.get(course_row_no).get(course_col_no);

                mcf.getCity_ip().getCtp().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public void centerUpdateTourist(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++) {
            mtf.getTourist_ip().getCpt().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int course_row_no = 0; course_row_no < lines.size(); course_row_no++) {
            for (int course_col_no = 0; course_col_no < headers.size(); course_col_no++) {
                int button_no = course_row_no * headers.size() + headers.size() + course_col_no;
                String button_txt = lines.get(course_row_no).get(course_col_no);

                mtf.getTourist_ip().getCpt().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public void centerUpdateBooking(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++) {
            mbf.getBooking_ip().getBtp().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int booking_row_no = 0; booking_row_no < lines.size(); booking_row_no++) {
            for (int booking_col_no = 0; booking_col_no < headers.size(); booking_col_no++) {
                int button_no = booking_row_no * headers.size() + headers.size() + booking_col_no;
                String button_txt = lines.get(booking_row_no).get(booking_col_no);

                mbf.getBooking_ip().getBtp().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public void setFf(FirstFrame ff) {
        this.ff = ff;
    }

    public FirstFrame getFf() {
        return ff;
    }

     public void setMtf(ManageTouristFrame mtf) {
     this.mtf = mtf;
    }

      public ManageTouristFrame getMtf() {
     return mtf;
 }

    public void setMcf(ManageCitiesFrame mcf) {
        this.mcf = mcf;
    }

    public ManageCitiesFrame getMcf() {
        return mcf;
    }

    public void setMbf(ManageBookingFrame mbf) {
        this.mbf = mbf;
    }

    public ManageBookingFrame getMbf() {
        return mbf;
    }

}

