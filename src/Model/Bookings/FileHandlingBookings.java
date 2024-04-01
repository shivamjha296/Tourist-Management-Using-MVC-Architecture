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
 * Filename: FileHandlingBookings.java
 * @author:  Shivam Jha
 * Overview: This is the FileHandlingBookings Abstract class. In this file we have achieved the following
 *
 * - Created protected Abstract Methods for Array List of Bookings by passing parameters
 * - Methods created for the abstract class read and write the Bookings.json file
 */
import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingBookings {
    protected abstract ArrayList<Bookings> readBookingsJsonFile(String file_path);
    protected abstract void writeBookingsJsonFile(String file_path, ArrayList<Bookings> enrolls) throws IOException;
}
