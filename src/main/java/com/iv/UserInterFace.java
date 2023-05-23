package com.iv;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserInterFace {
    private Dealership dealership;

    private static Scanner scanner = new Scanner(System.in);

    private DealershipFileManager dealershipFileManager = new DealershipFileManager();


    private void init() {
        // Load dealership and inventory from a file
        this.dealership = dealershipFileManager.getDealership();
//        this.dealership = new Dealership("Izzy's", "123 Fourth Ave", "128-459-9274");
    }

    public void display() {
        init();
        System.out.println("Current Dealership: " + this.dealership.getName() + " " + this.dealership.getAddress() + " " +  this.dealership.getPhone());
        String input;

        do {
            System.out.println("Please enter a command: ");
            System.out.println("\t1: Get all vehicles");
            System.out.println("\t2: Get all vehicles by price");
            System.out.println("\t3: Get all vehicles by Make/Model");
            System.out.println("\t4: Get all vehicles Year Range");
            System.out.println("\t5: Get all vehicles color");
            System.out.println("\t6: Get all vehicles mileage");
            System.out.println("\t7: Get all vehicles by vehicle type");
            System.out.println("\t8: Add vehicle");
            System.out.println("\t9: Remove vehicle");
            System.out.println("\t99: EXIT");

            System.out.println("Command ");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    processGetAllVehicle();
                    break;
                case "2":
                    processGetVehicleByPriceRequest();
                    break;
                case "3":
                    processGetVehicleByMakeModelRequest();
                    break;
                case "4":
                    processGetVehicleByYearRangeRequest();
                    break;
                case "5":
                    processGetVehicleByColorRequest();
                    break;
                case "6":
                    processGetVehicleByMileageRequest();
                    break;
                case "7":
                    processGetVehicleByCarTypeRequest();
                    break;
                case "8":
                    addVehicle();
                    break;
                case "9":
                    removeVehicle();
                    break;
                case "99":
                    System.out.println("Thanks for coming, see you never.");
                    break;
                default:
                    System.out.println("c'mon now, wrong answer loser.");
            }

        }  while (!input.equalsIgnoreCase("99")) ;
        // display menu
        // read userInput
        //
    }
    public void processGetAllVehicle(){
        System.out.println(dealership.getAllVehicles());

        ArrayList<Vehicle> allVehicles = this.dealership.getAllVehicles();
        for(int i=0;i<allVehicles.size();i++){
            System.out.println(allVehicles.get(i));
        }
    }
    public void processGetVehicleByPriceRequest(){
        System.out.println("please give me min");
        float minValue = scanner.nextFloat();
        System.out.println("please give max");
        float maxValue = scanner.nextFloat();


        ArrayList<Vehicle> vehiclesByPrice = this.dealership.getVehiclesByPrice(minValue, maxValue);
        for(Vehicle vehicle: vehiclesByPrice){
            System.out.println(vehicle);
        }
    }
    public void processGetVehicleByMakeModelRequest(){
        System.out.println("Would you mind droppin' the vehicle make?");
        String makeValue = scanner.nextLine();
        System.out.println("now could ya maybe lemme peep in on that model?");
        String modelValue = scanner.nextLine();

        ArrayList<Vehicle> vehiclesByMakeModel = this.dealership.getVehiclesByMakeModel(makeValue, modelValue);
        for (Vehicle vehicle: vehiclesByMakeModel){
            System.out.println(vehicle);
        }
    }
    public void processGetVehicleByYearRangeRequest(){
        System.out.println("AYO dawg, when didya get that car tho?");
        int yearValue = scanner.nextInt();

        ArrayList<Vehicle> vehiclesByYear = this.dealership.getVehiclesByYear(yearValue);
        for(Vehicle vehicle: vehiclesByYear){
            System.out.println(vehicle);
        }
    }
    public void processGetVehicleByColorRequest(){

    }
    public void processGetVehicleByMileageRequest(){

    }
    public void processGetVehicleByCarTypeRequest(){

    }
    public void removeVehicle() {

        System.out.println("Please enter the vehicle number to remove: ");

        ArrayList<Vehicle> allVehicles = this.dealership.getAllVehicles();
        for (int i = 0; i < allVehicles.size(); i++) {
            System.out.println((i + 1) + " " + allVehicles.get(i).toString());
        }
        int chosenVehicle = scanner.nextInt();

        this.dealership.removeVehicle(chosenVehicle - 1);

        dealershipFileManager.saveDealership(this.dealership);

        System.out.println("Successfully removed vehicle. :(");
        scanner.nextLine();
    }
    public void addVehicle(){
//        int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price
        System.out.println("please provide the following");

        System.out.println("Vin :");
        int vin = scanner.nextInt();
        System.out.println("Year :");
        int year = scanner.nextInt();
        // cleared the scanner
        scanner.nextLine();

        System.out.println("Make :");
        String make = scanner.nextLine();
        System.out.println("Model :");
        String model = scanner.nextLine();
        System.out.println("Type :");
        String type = scanner.nextLine();
        System.out.println("Color :");
        String color = scanner.nextLine();
        System.out.println("Mileage :");
        int mileage = scanner.nextInt();
        System.out.println("Price :");
        float price = scanner.nextFloat();

        this.dealership.addVehicle(new Vehicle(vin, year, make, model, type, color, mileage, price));

        dealershipFileManager.saveDealership(this.dealership);

        System.out.println("Vehicle added Successfully");
        // Clearing the Scanner

        scanner.nextLine();
    }
}
