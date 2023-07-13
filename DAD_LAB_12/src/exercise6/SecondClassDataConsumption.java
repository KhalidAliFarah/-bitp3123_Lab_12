package exercise6;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * SecondClassDataConsumption: Read and process rainfall data from a binary file.
 * @Author Khalid
 */

public class SecondClassDataConsumption {
    public static void main(String[] args) {
        String fileName = "rainfall_data.bin"; // Name of the binary file
        int stationCount = 0; // Counter for the number of stations
        int districtCount = 0; // Counter for the number of districts
        double totalRainfall = 0.0; // Accumulator for the total rainfall

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fileName))) {
            // Read data from the binary file until no more data is available
            while (dataInputStream.available() > 0) {
                int stationId = dataInputStream.readInt(); // Read the station ID
                String stationName = dataInputStream.readUTF(); // Read the station name
                String district = dataInputStream.readUTF(); // Read the district

                // Print station information
                System.out.println("Station ID: " + stationId);
                System.out.println("Station Name: " + stationName);
                System.out.println("District: " + district);

                double[] rainfallData = new double[6]; // Array to store rainfall data (6 values)
                for (int i = 0; i < 6; i++) {
                    rainfallData[i] = dataInputStream.readDouble(); // Read each rainfall data value
                    totalRainfall += rainfallData[i]; // Accumulate the rainfall data
                }

                // Print rainfall data
                System.out.println("Rainfall Data:");
                for (double rainfall : rainfallData) {
                    System.out.println(rainfall);
                }

                stationCount++; // Increment the station count
                districtCount++; // Increment the district count
                System.out.println("**********************************");
            }

            double averageRainfall = totalRainfall / (stationCount * 6); // Calculate the average rainfall
            System.out.println("Number of Stations: " + stationCount);
            System.out.println("Number of Districts: " + districtCount);
            System.out.println("Average Rainfall: " + averageRainfall);
        } catch (IOException e) {
            System.out.println("An error occurred while consuming the data: " + e.getMessage());
        }
    }
}
