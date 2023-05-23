package com.iv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import static com.iv.Main.scanner;

public class Dealership{
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public ArrayList<Vehicle> getVehiclesByPrice(float min, float max) {
        ArrayList<Vehicle> vehiclesToDisplay = new ArrayList<>();

        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getPrice() > min && vehicle.getPrice() < max) {
                vehiclesToDisplay.add(vehicle);
            }
        }
        return vehiclesToDisplay;
    }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> carMakeModel = new ArrayList<>();

        for(Vehicle vehicle: this.inventory){
            if (vehicle.getMake().equalsIgnoreCase(make) &&
                    vehicle.getModel().equalsIgnoreCase(model)){
                carMakeModel.add(vehicle);
            }
        }
        return carMakeModel;
    }
    public ArrayList<Vehicle> getVehiclesByYear(int year){
        ArrayList<Vehicle> carYear = new ArrayList<>();

        for(Vehicle vehicle: this.inventory){
            if(vehicle.getYear() == year){
                carYear.add(vehicle);
            }
        }
        return carYear;
    }
//    public void getVehiclesByColor(String color){
//        this.inventory;
//    }
//    public void getVehiclesByMileage(float min, float max){
//        this.inventory;
//    }
//    public void getVehiclesByType(String vehicleType){
//        this.inventory;
//    }

    public ArrayList<Vehicle> getAllVehicles(){
       return this.inventory;
    }
    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }
    public void removeVehicle(int vehicleIndex){
//            Vehicle inventory = inventory.remove;
        this.inventory.remove(vehicleIndex);
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}