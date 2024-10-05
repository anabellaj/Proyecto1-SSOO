/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Companies.Company;
import Interfaz.Menu;

/**
 * Class that defines the variables for the entire project 
 * @author ani
 */
public class CommonVariables {
    
    // Length of one day inside the simultation for each company 
    public static int dayLengthApple;
    public static int dayLengthDell;
    
    // Stores the data of each company
    private static Company apple;
    private static Company dell;
    
    private static Menu mainMenu;

    public CommonVariables(Menu mainMenu) {
        this.mainMenu = mainMenu;
    }

    /**
     * Gets the length of one day inside the Apple simulation
     * @return the length of the day 
     */
    public static int getDayLengthApple() {
        return dayLengthApple;
    }

    /**
     * Sets the length of one day inside the Apple simulation
     * @param dayLengthApple the length to set 
     */
    public static void setDayLengthApple(int dayLengthApple) {
        CommonVariables.dayLengthApple = dayLengthApple;
    }

    /**
     * Gets the length of one day inside the Dell simulation
     * @return the length of the day 
     */
    public static int getDayLengthDell() {
        return dayLengthDell;
    }

    /**
     * Sets the length of one day inside the Apple simulation
     * @param dayLengthDell the length to set 
     */
    public static void setDayLengthDell(int dayLengthDell) {
        CommonVariables.dayLengthDell = dayLengthDell;
    }

    /**
     * Gets the object Company corresponding to Apple
     * @return object Company 
     */
    public static Company getApple() {
        return apple;
    }

    /**
     * Sets the object Company corresponding to Apple
     * @param apple object Company to set 
     */
    public static void setApple(Company apple) {
        CommonVariables.apple = apple;
    }

    /**
     * Gets the object Company corresponding to Dell
     * @return object Company
     */
    public static Company getDell() {
        return dell;
    }

    /**
     * Sets the object Company corresponding to Dell
     * @param dell object Company to set 
     */
    public static void setDell(Company dell) {
        CommonVariables.dell = dell;
    }

    /**
     * Gets the main menu window
     * @return the main menu window
     */
    public static Menu getMainMenu() {
        return mainMenu;
    }

    /**
     * Sets the main menu window
     * @param mainMenu window to set 
     */
    public static void setMainMenu(Menu mainMenu) {
        CommonVariables.mainMenu = mainMenu;
    }


    
    
}
