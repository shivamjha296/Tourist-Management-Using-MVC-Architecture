package Model.Bookings;
/**
 * Identification comments:
 *   Name: Shivam Jha D2B 22
 *   Experiment Title: Java Mini Project
 *   Experiment Date: 01/04/24
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: manageBookings.java
 * @author:  Shivam Jha
 * Overview: This is the manageBookings class. In this file we have achieved the following
 * - Created Attributes
 * --- ArrayLists tourists, cities,booking_data for Tourists Cities and Bookings respectively
 * --- private int linesBeingDisplayed;
 * --- private int firstLineIndex;
 * --- int lastLineIndex;
 * --- int highlightedLine;
 *
 * - manageBookings Class extends abstract class FileHandlingBookings and implements Interface Displayable
 * - Created constructors based on no. of parameters
 * - Created getHeaders for getting the Headers for Bookings
 * - Created method body for the Displayable Interface
 * - The class reads and writes into the Bookings.json file by reading and writing it.
 * - Code has been written for getting a single line as well as multiple lines.
 * - Created Table for Bookings
 * - Created methods for adding, editing and deleting a booking
 */

import Model.City.Cities;
import Model.City.manageCities;
import Model.Displayable;
import Model.Tourist.Tourists;
import Model.Tourist.manageTourists;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class manageBookings extends FileHandlingBookings implements Displayable {
    ArrayList<Tourists> tourists = new ArrayList<Tourists>();

    ArrayList<Cities> cities = new ArrayList<Cities>();

    ArrayList<Bookings> booking_data = new ArrayList<Bookings>();
    ArrayList<Map<String, Object>> handle_data = new ArrayList<>();


    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    Tourists temp_obj = null;
    Cities t_temp_obj = null;

    public manageBookings(){
        manageTourists ms1 = new manageTourists();
        tourists = ms1.readTouristsJsonFile("src/Model/Tourist/Tourists.json");
        manageCities mc1 = new manageCities();
        cities = mc1.readCitiesJsonFile("src/Model/City/Cities.json");
        readBookingsJsonFile("src/Model/Bookings/Bookings.json");
    }

    @Override
    public ArrayList<Bookings> readBookingsJsonFile(String file_path) {
        try {
            booking_data.clear();
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for(JsonNode node : rootNode){

                    int temp = node.get("t_temp").asInt();
                    for (Tourists tourists1 : tourists) {
                        if (temp == tourists1.gettr_id()) {
                           temp_obj = tourists1;
                        }
                    }
                    int t_temp = node.get("c_temp").asInt();

                    for (Cities cities1 : cities) {
                        if (t_temp == cities1.getct_id()) {
                            t_temp_obj = cities1;
                        }
                    }
                    String booking_date = node.get("booking_date").asText();
                    String booking_time = node.get("booking_time").asText();
                    int booking_fees= node.get("booking_fees").asInt();
                    booking_data.add(new Bookings(temp_obj,t_temp_obj,booking_date,booking_time,booking_fees));}
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return booking_data;
    }

    @Override
    public void writeBookingsJsonFile(String file_path, ArrayList<Bookings> booking_al) throws IOException {

        ArrayList<Map<String, Object>> booking_to_be_written = new ArrayList<>();

        for(int i = 0; i < booking_al.size(); i++)
        {
            HashMap <String, Object> row = new HashMap<>();

            row.put("t_temp", booking_data.get(i).getT_temp().gettr_id());
            row.put("c_temp", booking_data.get(i).getC_temp().getct_id());
            row.put("booking_date", booking_data.get(i).getBooking_date());
            row.put("booking_time", booking_data.get(i).getBooking_time());

            row.put("booking_fees", booking_data.get(i).getBooking_fees());


            booking_to_be_written.add(row);
        }

        objectMapper.writeValue(Paths.get(file_path).toFile(), booking_to_be_written);
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();

        headers.add("Tourist ID");
        headers.add("City Id");
        headers.add("Booking date");
        headers.add("Booking time");
        headers.add("Booking fees");

        return headers;
    }
    public void Display(){
        for(int i=0; i<booking_data.size(); i++){
            System.out.print("\nTourist ID: ");
            System.out.print(booking_data.get(i).getT_temp().gettr_id());
            System.out.print("\nCity ID: ");
            System.out.print(booking_data.get(i).getC_temp().getct_id());
            System.out.print("\nBooking Date ");
            System.out.print(booking_data.get(i).getBooking_date());
            System.out.print("\nBooking Time ");
            System.out.print(booking_data.get(i).getBooking_time());
            System.out.print("\nBooking Tour package: ");
            System.out.print(booking_data.get(i).getBooking_fees());
            System.out.print("\n-----------------------------------------------------");
        }
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> booking_details = new ArrayList<String>();
        booking_details.add(String.valueOf(booking_data.get(line).getT_temp().gettr_id()));
        booking_details.add(String.valueOf(booking_data.get(line).getC_temp().getct_id()));
        booking_details.add(booking_data.get(line).getBooking_date());
        booking_details.add(booking_data.get(line).getBooking_time());
        booking_details.add(String.valueOf(booking_data.get(line).getBooking_fees()));
        return booking_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> Bookings_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            Bookings_subset.add(getLine(i));
        }
        return Bookings_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {

        setLastLineToDisplay(getFirstLineToDisplay()+getLinesBeingDisplayed()-1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
            this.firstLineIndex=firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
            this.highlightedLine=highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex=lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed=numberOfLines;
    }

    public ArrayList<Bookings> getTable() {
        return booking_data;
    }

    public void addNewBooking( int booking_t_id,int booking_c_id, String booking_date,String booking_time,int booking_fees) throws IOException {
        readBookingsJsonFile("src/Model/Bookings/Bookings.json");
        tourists = new manageTourists().readTouristsJsonFile("src/Model/Tourist/Tourists.json");
        cities = new manageCities().readCitiesJsonFile("src/Model/City/Cities.json");
        Bookings temp_booking = new Bookings(tourists.get(booking_t_id),cities.get(booking_c_id), booking_date,booking_time, booking_fees);
        booking_data.add(temp_booking);
        writeBookingsJsonFile("src/Model/Bookings/Bookings.json",booking_data);

    }

    public void editNewBooking(int edit_booking_idx,  int booking_t_id,int booking_c_id, String booking_date,String booking_time,int booking_fees) throws IOException {
        readBookingsJsonFile("src/Model/Bookings/Bookings.json");
        tourists = new manageTourists().readTouristsJsonFile("src/Model/Tourist/Tourists.json");
        cities = new manageCities().readCitiesJsonFile("src/Model/City/Cities.json");

        booking_data.get(edit_booking_idx).setT_temp(tourists.get(booking_t_id));
        booking_data.get(edit_booking_idx).setC_temp(cities.get(booking_c_id));
        booking_data.get(edit_booking_idx).setBooking_date(booking_date);
        booking_data.get(edit_booking_idx).setBooking_time(booking_time);
        booking_data.get(edit_booking_idx).setBooking_fees(booking_fees);
        writeBookingsJsonFile("src/Model/Bookings/Bookings.json",booking_data);
    }

    public void deleteBooking(int edit_booking_idx) throws IOException {
        readBookingsJsonFile("src/Model/Bookings/Bookings.json");
        tourists = new manageTourists().readTouristsJsonFile("src/Model/Tourist/Tourists.json");
        cities = new manageCities().readCitiesJsonFile("src/Model/City/Cities.json");
        booking_data.remove(edit_booking_idx);
        writeBookingsJsonFile("src/Model/Bookings/Bookings.json",booking_data);
    }
    public void deleteif(int id){
        readBookingsJsonFile("src/Model/Bookings/Bookings.json");
        tourists = new manageTourists().readTouristsJsonFile("src/Model/Tourist/Tourists.json");
        cities = new manageCities().readCitiesJsonFile("src/Model/City/Cities.json");
        for (int i = 0; i < booking_data.size(); i++){
            if (id == booking_data.get(i).getC_temp().getct_id() || id == booking_data.get(i).getT_temp().gettr_id()){
                booking_data.remove(i);
            }
        }
        try {
            writeBookingsJsonFile("src/Model/Bookings/Bookings.json", booking_data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


