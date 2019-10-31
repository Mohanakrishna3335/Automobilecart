package com.kone.settings;
import com.kone.model.Vehicle;
import java.util.ArrayList;
import java.util.List;
/*
 *  provides information about our showRoom vehicles  cart.
 */

public class Vehicles {
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();

    public Vehicles () {
        this.initStoreItems();
    }
    
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    
    public void initStoreItems() {
    	
        String [] vehicleNames = {"Volkswagen", "kia seltos", "BMW","verna"};
        Double [] vehiclePrice = {8.82d, 9.69d, 41.d, 14.3d};
        Integer [] stock = {10, 16, 12, 13};
        
        for (int i=0; i < vehicleNames.length; i++) {
            this.vehicles.add(new Vehicle(i+1, vehicleNames[i], vehiclePrice[i], stock[i]));
        }
    }
}

