package com.kone.Implementation;

import java.util.ArrayList;
import java.util.List;

import com.kone.console.Console;
import com.kone.model.Vehicle;
import com.kone.settings.Vehicles;


public class Cart {
    Console logger = new Console();
    List<Vehicle> cartItems = new ArrayList<Vehicle>();
    
    public void addVehicleToCartByVID(int vid) {
       Vehicle vehicle = getVehicleByVehicleID(vid);
        addToCart(vehicle);
    }

    private Vehicle getVehicleByVehicleID(int vid) {
    	 Vehicle vehicle = null;
        List<Vehicle> vehicles = new Vehicles().getVehicles();
        for (Vehicle vech: vehicles) {
            if (vech.getvid() == vid) {
                vehicle = vech;
                break;
            }
        }
        return vehicle;
    }

    private void addToCart(Vehicle vehicle) {
        cartItems.add(vehicle);
    }

    public void removeVehicleByVID(int vid) {
        Vehicle vech = getVehicleByVehicleID(vid);
        cartItems.remove(vech);
    }

    public void printCartItems() {
        for (Vehicle vech: cartItems) {
            logger.writeInfo(vech.getName()+"  "+vech.getPrice());
        }
    }
}





