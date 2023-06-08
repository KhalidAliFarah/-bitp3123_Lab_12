package exercise7;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReDataCreation {

    public static void main(String[] args) {
        double[] rainfallData = {0.0, 4.0, 1.0, 0.0, 6.0, 19.0};
        String fileName = "rainfall_data.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (double rainfall : rainfallData) {
                writer.write(String.valueOf(rainfall));
                writer.newLine();
            }
            System.out.println("Data generation was successful..");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the data: " + e.getMessage());
        }
    }
}