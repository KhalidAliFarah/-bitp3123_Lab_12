package exercise5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataCreation {

    public static void main(String[] args) {
        double[] rainfallData = {0.0, 4.0, 1.0, 0.0, 6.0, 19.0};
        String fileName = "rainfall_data.bin";

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            for (double rainfall : rainfallData) {
                dataOutputStream.writeDouble(rainfall);
            }
            System.out.println("Data generation was successful..");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the data: " + e.getMessage());
        }
    }
}