package exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * DataConsumption: Calculate and display average rainfall data.
 * Read data from a binary file and perform calculations.
 * @Author Khalid
 */

public class DataConsumption {
    private double[] rainfallData; // Array to store rainfall data
    private double average; // Average rainfall

    /**
     * Calculate the average rainfall.
     */
    public void calculateAverage() {
        double sum = 0.0;
        for (double rainfall : rainfallData) {
            sum += rainfall;
        }
        average = sum / rainfallData.length;
    }

    /**
     * Display the rainfall data and average.
     */
    public void displayData() {
        System.out.println("Rainfall Data:");
        for (double rainfall : rainfallData) {
            System.out.println(rainfall);
        }
        System.out.println("Average Rainfall: " + average);
    }

    /**
     * Main method to execute the data consumption process.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        String fileName = "rainfall_data.bin";

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fileName))) {
            DataConsumption rainfallData = new DataConsumption();

            int dataSize = 6; // Assuming the data size is known

            rainfallData.rainfallData = new double[dataSize];
            for (int i = 0; i < dataSize; i++) {
                rainfallData.rainfallData[i] = dataInputStream.readDouble();
            }

            rainfallData.calculateAverage();
            rainfallData.displayData();
        } catch (IOException e) {
            System.out.println("An error occurred while consuming the data: " + e.getMessage());
        }
    }
}
