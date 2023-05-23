package com.iv;

import java.io.*;
import java.util.regex.Pattern;

public class DealershipFileManager {
    String dealershipFileLocation = "./src/main/java/com/iv/dealership.txt";

    public Dealership getDealership() {
        try {
            FileReader dealershipDataFile = new FileReader(dealershipFileLocation);
            BufferedReader bufferedReader = new BufferedReader(dealershipDataFile);

            String input;
            String dealershipInfo = bufferedReader.readLine();
            String[] split = dealershipInfo.split(Pattern.quote("|"));

//            Dealership initialDealership = new Dealership(split[0], split[1], split[2]);

            String dealershipName = split[0];
            String dealershipAddress = split[1];
            String dealershipPhone = split[2];

            Dealership dealership = new Dealership(dealershipName, dealershipAddress, dealershipPhone);

//            dealership.addVehicle(); /// not right spot but is used in this method!!!!

            while ((input = bufferedReader.readLine()) != null) {

                String[] vehicleInfo = input.split(Pattern.quote("|"));

                int vinInput = Integer.parseInt(vehicleInfo[0]);
                int yearInput = Integer.parseInt(vehicleInfo[1]);
                String makeInput = vehicleInfo[2];
                String modelInput = vehicleInfo[3];
                String vehicleTypeInput = vehicleInfo[4];
                String colorInput = vehicleInfo[5];
                int odometerInput = Integer.parseInt(vehicleInfo[6]);
                float priceInput = Float.parseFloat(vehicleInfo[7]);

                Vehicle currentVehicle = new Vehicle(  vinInput  ,
                          yearInput ,
                          makeInput ,
                          modelInput ,
                          vehicleTypeInput ,
                          colorInput ,
                          odometerInput ,
                          priceInput);

                dealership.addVehicle(currentVehicle);
//                System.out.printf("VIN: %d, Year: %d, Make: %s, Model: %s, Vehicle Type: %s, Color: %s, Odometer: %d, Price: $%.2\n");
            }
            bufferedReader.close();
            return dealership;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveDealership(Dealership dealership) {
        try {
            FileWriter fileWriter = new FileWriter(dealershipFileLocation);

//            Izzy's|123 Fourth Ave|128-459-9274
//            10112|1993|Ford|Explorer|SUV|Red|525123|995.00

            fileWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");

            for(Vehicle vehicle: dealership.getAllVehicles()){
                fileWriter.write(
                        vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice() + "\n"
                        );
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}