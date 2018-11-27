/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SteppingStones;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author jaghadiuno
 */
public class SteppingStone2_IngredientCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       /* Create and initalize variables we shall be using */
       String nameOfIngredient = "";
       double numberCups = 0.0;
       int numberCaloriesPerCup = 0;
       double totalCalories = 0.0;
       DecimalFormat dec = new DecimalFormat("#0.0");
        
       /* Get input from user */
       Scanner scnr = new Scanner(System.in);
       
       /* Print out to console, requesting name of ingredient */
       System.out.println("Please enter the name of the ingredient: ");
       
       /* Get name of ingredient from user input and assign value to variable */
       nameOfIngredient = scnr.next();
       
       /* Print out to console, requesting number of cups */
       System.out.println("Please enter the number of cups of " 
        + nameOfIngredient + " we'll need: ");
       numberCups = scnr.nextFloat();
       
       /* Print out to console, requesting number of calories per cup */
       System.out.println("Please enter the number of calories per cup: ");
       numberCaloriesPerCup = scnr.nextInt();
       
       /* 
        * Multiplies the number of cups 
        * by the Calories per cup.
        * Assign this value to totalCalories
        */
       totalCalories = (numberCups * numberCaloriesPerCup);
       
       
       /* Print out message with name of ingredient, including number of cups and total calories.
        * Because of the way Java handles decimals and number of decimal places, 
        * we will need to format the values we are printing to make it more readable 
        * by setting its precision to 1 decimal place.
        */
       System.out.println(nameOfIngredient + " uses " + dec.format(numberCups) 
       + " cups and has " + dec.format(totalCalories) + " calories.");
       
    }
    
}

/**
 * 
 * Final Project
 *
 *For your Final Project:
 *
 * 1. Create a new java class named Ingredient
 * 
 * 2. Adapt the code from this SteppingStone to include the following changes:
 *
 *   a. Rename the variable, numberCups, to represent the more general 
 *      ingredientAmount;
 *
 *   b. Add a new text variable, unitMeasurement to store unit of measurement
 *      for the ingredient amount (e.g. cups, oz., etc.);
 *
 *   c. Prompt the user to input the measurement unit;
 * 
 **/
