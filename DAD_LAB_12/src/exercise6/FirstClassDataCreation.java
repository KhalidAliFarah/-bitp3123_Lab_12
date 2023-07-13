package exercise6;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FirstClassDataCreation: Generate rainfall data for multiple stations and write them to a binary file.
 * @Author Khalid
 */

public class FirstClassDataCreation {
    public static void main(String[] args) {
        String fileName = "rainfall_data.bin"; // Name of the binary file

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            // Station 1: Simpang Ampat, Alor Gajah
            int stationId1 = 2421003; // Station ID for Simpang Ampat
            String stationName1 = "Simpang Ampat"; // Station name
            String district1 = "Alor Gajah"; // District name
            double[] rainfallData1 = {0.0, 4.0, 1.0, 0.0, 6.0, 19.0}; // Rainfall data for Station 1

            // Write station information for Station 1
            dataOutputStream.writeInt(stationId1); // Write the station ID
            dataOutputStream.writeUTF(stationName1); // Write the station name
            dataOutputStream.writeUTF(district1); // Write the district name

            // Write rainfall data for Station 1
            for (double rainfall : rainfallData1) {
                dataOutputStream.writeDouble(rainfall); // Write each rainfall data value
            }

            // Station 2: Another Station, Another District
            int stationId2 = 2125002; // Station ID for Another Station
            String stationName2 = "Telok Rimba"; // Station name
            String district2 = "Jasin"; // District name
            double[] rainfallData2 = {0.0, 0.0, 1.0, 1.0, 69.0, 53.0}; // Rainfall data for Station 2

            // Write station information for Station 2
            dataOutputStream.writeInt(stationId2); // Write the station ID
            dataOutputStream.writeUTF(stationName2); // Write the station name
            dataOutputStream.writeUTF(district2); // Write the district name

            // Write rainfall data for Station 2
            for (double rainfall : rainfallData2) {
                dataOutputStream.writeDouble(rainfall); // Write each rainfall data value
            }

            System.out.println("Data creation completed successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the data: " + e.getMessage());
        }
    }
}
