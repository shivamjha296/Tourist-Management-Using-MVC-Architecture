package Model.Tourist;

import java.io.IOException;
import java.util.ArrayList;
/**
 * Identification comments:
 *   Name: Shivam Jha D2B 22
 *   Experiment Title: Java Mini Project
 *   Experiment Date: 01/04/24
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: FileHandlingCities.java
 * @author:  Shivam Jha
 * Overview: This is the FileHandlingTourists Abstract class. In this file we have achieved the following
 *
 * - Created protected Abstract Methods for Array List of Tourists by passing parameters
 * - Methods created for the abstract class read and write the Tourists.json file
 */
public abstract class FileHandlingTourists {
    protected abstract ArrayList<Tourists> readTouristsJsonFile(String file_path);
    protected abstract void writeTouristsJsonFile(String file_path, ArrayList<Tourists> tourists) throws IOException;
}
