/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jjonesinternetprovider;

import jjonesinternetprovider.Utilities.InputVerification;
import javax.swing.JOptionPane;

/**
 *
 * @author Thema
 */
public class JJonesInternetProvider extends InputVerification{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Initializes the variables for plan A
        int planAHours = 10; // The maximum number of hours before surchage applies
        int planASurcharge = 2; // The amount charges for each extra hour
        
        double planAPrice = 9.95; // The normal charge per month
        double planATotal; // The total price for plan A given the user's hours
        
        // Initalizes the variable for plan B
        int planBHours = 20; // The maximum number of hours before surchage applies
        int planBSurcharge = 1; // The amount charges for each extra hour
        
        double planBPrice = 13.95; // The normal charge per month
        double planBTotal; // The total price for plan B given the user's hours
        
        double planCPrice = 19.95; // The maximum number of hours before surchage applies
        
        // Initalizes the variables that hold information obtained from the user
        double userHours; // How many hours the user has used this month
        
        String planChoice; // Which plan the user wants to use
        String programChoice = "N"; // Whether or not the user wants to continue
        
        // The main loop
        do{
            
            // The message displayed to the user at the beginning of the program
            String introMessage = "Hello there customer! In this program, there are three plans:";
            introMessage += "\nPlan A: Pay $" + planAPrice + " a month to get " + planAHours + " hours, with an additional $" + planASurcharge + " for each additional hour.";
            introMessage += "\nPlan B: Pay $" + planBPrice + " a month to get " + planBHours + " hours, with an additional $" + planBSurcharge + " for each additional hour.";
            introMessage += "\nPlan C: Pay $" + planCPrice + " a month to get unlimited hours, with no surcharge!";

            // Sets up the final message displayed to the user
            String finalMessage = "Thank you for using our program, here are the results:";

            // Displays the first message for the user
            JOptionPane.showMessageDialog(null, introMessage);
            
            // Obtains which plan the user wants to use,
            // and verifies that the input is valid
            planChoice = stringChoiceInput("Now, which plan do you select (A/B/C)?", "A", "B", "C");

            // Obtains how many hours the user has used for the month, 
            // and verifies if it is larger than 0
            userHours = doubleInput("How many hours were you online this month?", 0);

            // Checks if the user exceeds the cap for plan A
            if(userHours > planAHours){
                planATotal = planAPrice + (userHours - planAHours) * planASurcharge;
            } 
            // If the user is under the cap, display the normal price
            else {
                planATotal = planAPrice;
            }
            
            // Checks if the user exceeds the cap for plan AB
            if(userHours > planBHours){
                planBTotal = planBPrice + (userHours - planBHours) * planBSurcharge;
            } 
            // If the user is under the cap, display the normal price
            else {
                planBTotal = planBPrice;
            }

            // Displays different results depending on the choice
            switch (planChoice) {
                case "A":
                    finalMessage += String.format("\nBy choosing plan A, it will cost you $%.2f", planATotal) + ".";
                    
                    // If either plan saved money compared to plan A, display that fact
                    if(planBTotal < planATotal){
                        finalMessage += String.format("\nIf you chose plan B, you would have saved $%.2f", (planATotal - planBTotal)) + ".";
                    }   
                    if(planCPrice < planATotal){
                        finalMessage += String.format("\nIf you chose plan C, you would have saved $%.2f", (planATotal - planCPrice)) + ".";
                    }   
                    break;
                case "B":
                    finalMessage += String.format("\nBy choosing plan B, it will cost you $%.2f", planBTotal) + ".";
                    if(planATotal < planBTotal){
                        finalMessage += String.format("\nIf you chose plan A, you would have saved $%.2f", (planBTotal - planATotal)) + ".";
                    }
                    
                    // If either plan saved money compared to plan A, display that fact
                    if(planCPrice < planBTotal){
                        finalMessage += String.format("\nIf you chose plan C, you would have saved $%.2f", (planBTotal - planCPrice)) + ".";
                    }   
                    break;
                case "C":
                    finalMessage += String.format("\nBy choosing plan C, it will cost you $%.2f", planCPrice) + ".";
                    if(planATotal < planCPrice){
                        finalMessage += String.format("\nIf you chose plan A, you would have saved $%.2f", (planCPrice - planATotal)) + ".";
                    }
                    
                    // If either plan saved money compared to plan A, display that fact
                    if(planBTotal < planCPrice){
                        finalMessage += String.format("\nIf you chose plan B, you would have saved $%.2f", (planCPrice - planBTotal)) + ".";
                    }   
                    break;
                default:
                    break;
            }

            // Displays the final message for the user
            JOptionPane.showMessageDialog(null, finalMessage);
            
            // Obtains wether or not the user wants to continue with the program,
            // and verifies that the input is valid
            programChoice = stringChoiceInput("Would you like to check out our other plans (Y/N)?", "Y", "N");
        } while(programChoice.equals("Y"));
        
        // Thanks the user for using the program, and then exits
        JOptionPane.showMessageDialog(null, "Thank you for using our program, have a nice day!");
        System.exit(0);
    }
}
