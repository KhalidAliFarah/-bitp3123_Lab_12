package exercise7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReDataConsumption {
    private double[] rainfallData;
    private double average;

    public void calculateAverage() {
        double sum = 0.0;
        for (double rainfall : rainfallData) {
            sum += rainfall;
        }
        average = sum / rainfallData.length;
    }

    public void displayData() {
        System.out.println("Rainfall Data:");
        for (double rainfall : rainfallData) {
            System.out.println(rainfall);
        }
        System.out.println("Average Rainfall: " + average);
    }

    public static void main(String[] args) {
        String fileName = "rainfall_data.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        	ReDataConsumption rainfallData = new ReDataConsumption();

            int dataSize = 6; // Assuming the data size is known

            rainfallData.rainfallData = new double[dataSize];
            for (int i = 0; i < dataSize; i++) {
                String line = reader.readLine();
                if (line != null) {
                    rainfallData.rainfallData[i] = Double.parseDouble(line);
                }
            }

            rainfallData.calculateAverage();
            rainfallData.displayData();
        } catch (IOException e) {
            System.out.println("An error occurred while consuming the data: " + e.getMessage());
        }
    }
}
