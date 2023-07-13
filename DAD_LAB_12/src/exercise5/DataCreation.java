package exercise5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * DataCreation: Generate rainfall data and write it to a binary file.
 * @Author Khalid
 */

public class DataCreation {

    /**
     * Main method to generate rainfall data and write it to a binary file.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        double[] rainfallData = {0.0, 4.0, 1.0, 0.0, 6.0, 19.0}; // Rainfall data array
        String fileName = "rainfall_data.bin"; // Name of the binary file

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            for (double rainfall : rainfallData) {
                dataOutputStream.writeDouble(rainfall); // Write each rainfall value to the file
            }
            System.out.println("Data generation was successful..");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the data: " + e.getMessage());
        }
    }
}
