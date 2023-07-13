package exercise7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ReDataCreation: Generate rainfall data and write them to a text file.
 * @Author Khalid
 */

public class ReDataCreation {

    public static void main(String[] args) {
        double[] rainfallData = {0.0, 4.0, 1.0, 0.0, 6.0, 19.0}; // Rainfall data values
        String fileName = "rainfall_data.txt"; // Name of the text file

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write rainfall data to the text file
            for (double rainfall : rainfallData) {
                writer.write(String.valueOf(rainfall)); // Write each rainfall data value
                writer.newLine(); // Write a new line
            }

            System.out.println("Data generation was successful.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the data: " + e.getMessage());
        }
    }
}
