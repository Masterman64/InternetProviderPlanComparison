/**
 *
 * @author Jacob Jones
 * @Date 1/16/20
 * This class will help verify inputs from various programs
 */
package jjonesinternetprovider.Utilities;

import javax.swing.JOptionPane;


public class InputVerification {
    
    /**
     * This method verifies that the input is above a given minimum for integer values
     * 
     * @param message The message to be displayed
     * @param min The lower bound for the input
     * @return The verified input
     */
    public static int intInput(String message, int min){
        
        // Holds the input
        int input;
        
        // Verifies that the user put in a valid input
        do{
            // Prints the input for the user
            input = Integer.parseInt(JOptionPane.showInputDialog(null, message));

            // Tells the user to enter a valid input if they sent an invalid input
            if(input < min){
                JOptionPane.showMessageDialog(null, "Please enter a number larger than " + min);
            }
        }while(input < min);
        
        // Resturns the input
        return input;
    }
    
    /**
     * This method will verify that the input is within the given bounds for integer values
     * 
     * @param message The message to be displayed
     * @param min The lower bound for the input
     * @param max The higher bound for the input
     * @return The verified input
     */
    public static int intInput(String message, int min, int max){
        
        // Holds the input
        int input;
        
        // Verifies that the user put in a valid input
        do{
            // Prints the input for the user
            input = Integer.parseInt(JOptionPane.showInputDialog(null, message));

            // Tells the user to enter a valid input if they sent an invalid input
            if(input < min && input > max){
                JOptionPane.showMessageDialog(null, "Please enter a number larger than " + min);
            }
        }while(input < min && input > max);
        
        // Resturns the input
        return input;
    }
    
    /**
     * This method verifies that the input is above a given minimum for double values
     * 
     * @param message The message to be displayed
     * @param min The lower bound for the input
     * @return The verified input
     */
    public static double doubleInput(String message, double min){
        
        // Holds the input
        double input;
        
        // Verifies that the user put in a valid input
        do{
            // Prints the input for the user
            input = Double.parseDouble(JOptionPane.showInputDialog(null, message));

            // Tells the user to enter a valid input if they sent an invalid input
            if(input < min){
                JOptionPane.showMessageDialog(null, "Please enter a number larger than " + min);
            }
        }while(input < min);
        
        // Resturns the input
        return input;
    }
    
    /**
     * This method will verify that the input is within the given bounds for double values
     * 
     * @param message The message to be displayed
     * @param min The lower bound for the input
     * @param max The higher bound for the input
     * @return The verified input
     */
    public static double doubleInput(String message, double min, double max){
        
        // Holds the input
        double input;
        
        // Verifies that the user put in a valid input
        do{
            // Prints the input for the user
            input = Double.parseDouble(JOptionPane.showInputDialog(null, message));

            // Tells the user to enter a valid input if they sent an invalid input
            if(input < min && input > max){
                JOptionPane.showMessageDialog(null, "Please enter a number larger than " + min);
            }
        }while(input < min && input > max);
        
        // Resturns the input
        return input;
    }
    
    /**
     * This method will verify that the input is within the given bounds for String values
     * 
     * @param message The message to be displayed
     * @param choices What the string is allowed to be
     * @return The verified input
     */
    public static String stringInput(String message){
        
        // Holds the input
        String input;
        boolean isValid = false;
        
        // Verifies that the user put in a valid input
        do{
            // Prints the input for the user
            input = JOptionPane.showInputDialog(null, message);
            
            // Tells the user to enter a valid input if they sent an invalid input
            if(input.length() < 1){
                JOptionPane.showMessageDialog(null, "Please enter a valid input");
            }
        }while(input.length() < 1);
        
        // Resturns the input
        return input;
    }
    
    /**
     * This method will verify that the input is within the given bounds for String values
     * 
     * @param message The message to be displayed
     * @param choices What the string is allowed to be
     * @return The verified input
     */
    public static String stringChoiceInput(String message, String... choices){
        
        // Holds the input
        String input;
        boolean isValid = false;
        
        // Verifies that the user put in a valid input
        do{
            // Prints the input for the user
            input = JOptionPane.showInputDialog(null, message);

            // Capitalizes the input to match the choices
            input = input.toUpperCase();
            
            // Goes through each choice and compares the input and the choice
            for(String choice : choices){
                // If the input is the same as the choice, then it is valid
                if(input.equals(choice)){
                    isValid = true;
                }
            }
            // Tells the user to enter a valid input if they sent an invalid input
            if(!isValid){
                JOptionPane.showMessageDialog(null, "Please enter a valid input");
            }
        }while(!isValid);
        
        // Resturns the input
        return input;
    }
}
