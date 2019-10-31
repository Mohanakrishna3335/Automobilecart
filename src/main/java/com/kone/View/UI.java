package com.kone.View;
import java.util.List;
import java.util.Scanner;
import com.kone.Implementation.Cart;
import com.kone.console.Console;
import com.kone.model.Vehicle;
import com.kone.settings.Vehicles;

/*
 * UI class contains the methods which are responsible to display in screen/console.
 */
public class UI {

    Cart cart = new Cart();
    private int ch = 0;
    Console logger=new Console();
    
    public UI () {  
        menu();
    }
    
    public void startScreen () {
    	//logger.writeInfo(message);
    	logger.writeInfo("   "+"Hello user please enter your choice!!!"+"  ");
    	logger.writeInfo("  ");
        logger.writeInfo("1. Display Showroom vehicles");
        logger.writeInfo("2. Display Vehicles in Cart");
        logger.writeInfo("0. Exit");
    }
    
    public void storeVehiclesDetails() {
        logger.writeInfo("1.Add Vehicle to Cart");
        logger.writeInfo("2.Remove Vehicles From Cart");
        logger.writeInfo("0. Exit");
    }
    
    public void menu () {
        do {
            startScreen();
            getUserInput();
            //Implemented single responsibility in SOLID principles.
            switch (ch) {
                case 1: 
                	columnHeader();
                    displayStoreVehicles();
                    userIndication();
                    storeVehiclesDetails();
                    getUserInput();
                    innerChoice();
                    break;
                case 2:
                    showCart();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    
                    break;
            }
        } while (ch != 0);
    }
// inner choice method is used to add or remove vehicle from the vehicle cart.
    private void innerChoice() {
        switch (ch) {
            case 1:
                addVehicleToCart();
                showCart();
                break;
            case 2:
                removeVehicleFromCart();
                break;
            default:
                
                break;
        }
    }
    
   
    private int getUserInput()  {
        try{
    	Scanner in = new Scanner (System.in);
        ch = Integer.parseInt(in.nextLine());
        }
        catch(Exception e){
        	logger.writeError("please enter a valid value");
        	getUserInput();
        	//System.exit(0);
  
        }
       
        return ch;
      
   
    }
    private void columnHeader(){
    	logger.writeInfo("VehicleType"+" "+"price"+" "+"stock");
    	logger.writeInfo("-------------------------------------");
    }
     private void userIndication(){
    	  logger.writeInfo("   ");
          logger.writeInfo("first choose add or remove option followed by select vechile");
          logger.writeInfo("   ");
    }
//This method is used to display the vehicles present in showRoom.
    private void displayStoreVehicles() {
        List<Vehicle> vehicles = new Vehicles().getVehicles();
        for (Vehicle vech: vehicles) {
            logger.writeInfo(vech.getvid() + "- " +vech.getName() + " " +vech.getPrice() + " " +vech.getStock());
        }
    }

    private void addVehicleToCart() {
        int vid = getUserInput();
        cart.addVehicleToCartByVID(vid);      
    }

    private void showCart() {
        cart.printCartItems();
    }

    private void removeVehicleFromCart() {
        int vid = getUserInput();
        cart.removeVehicleByVID(vid);
    }
}



