/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SteppingStones;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author JohnA
 */
public class Ingredient {

    //Local variables
    private String nameOfIngredient;
    private String unitMeasurement;
    private float ingredientAmount;
    private int numberCaloriesPerUnit;
    private float totalCalories;

    //Constructor without parameters
    public Ingredient() {

        this.nameOfIngredient = "";
        this.unitMeasurement = "";
        this.ingredientAmount = 0.0f;
        this.numberCaloriesPerUnit = 0;
        this.totalCalories = 0.0f;
    }

    //Constructor with input
    public Ingredient(String nameOfIngredient, String unitMeasurement,
            float ingredientAmount, int numberCaloriesPerUnit, float totalCalories) {

        this.nameOfIngredient = nameOfIngredient;
        this.unitMeasurement = unitMeasurement;
        this.ingredientAmount = ingredientAmount;
        this.numberCaloriesPerUnit = numberCaloriesPerUnit;
        this.totalCalories = totalCalories;
    }

    //Return the name of the ingredient
    public String getNameofIngredient() {
        return this.nameOfIngredient;
    }
    //Return the unit of measurement

    public String getUnitMeasurement() {
        return this.unitMeasurement;
    }
    //Return ingredient amount

    public float getIngredientAmount() {
        return this.ingredientAmount;
    }
    //Return number of calories

    public int getNumberCaloriesPerUnit() {
        return this.numberCaloriesPerUnit;
    }
    //Return total calories

    public float getTotalCalories() {
        return this.totalCalories;
    }

    //Set the name of the ingredient
    public void setNameofIngredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }
    //Set the unit of measurement

    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }
    //Set ingredient amount

    public void setIngredientAmount(float ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }
    //Set number of calories

    public void setNumberCaloriesPerUnit(int numberCaloriesPerUnit) {
        this.numberCaloriesPerUnit = numberCaloriesPerUnit;
    }
    //Set total calories

    public void setTotalCalories(float totalCalories) {
        this.totalCalories = totalCalories;
    }

    //Main method
    //public ArrayList<Ingredient> addNewIngredient() {
    public Ingredient addNewIngredient() {

        String tempNameOfIngredient = "";
        String tempUnitMeasurement = "";
        float tempIngredientAmount = 0.0f;
        int tempNumberCaloriesPerUnit = 0;
        float tempTotalCalories = 0.0f;

        final float MAX_AMOUNT = 100.0f;

        Scanner scnr = new Scanner(System.in);
        
        //Create new Ingredient object
        Ingredient new_ingredient = new Ingredient();
                 
        boolean hasExpectedValue = false;

        
            try {

                //Prompt user for name of ingredient
                System.out.println("Please enter the name of the ingredient: ");
                tempNameOfIngredient = scnr.nextLine();

                //validate name of ingredient
                while (tempNameOfIngredient.isEmpty()) {
                    System.out.println("Please enter a valid name for the ingredient: ");
                    tempNameOfIngredient = scnr.nextLine();
                };

                //Prompt user for the ingredient amount
                System.out.println("Please enter the amount of "
                        + tempNameOfIngredient + " we will need: ");

                //validate ingredient amount 
                if (scnr.hasNextFloat()) {

                    tempIngredientAmount = scnr.nextFloat();

                    if (tempIngredientAmount >= 1 && tempIngredientAmount <= MAX_AMOUNT) {

                        System.out.println(tempIngredientAmount + " is a valid amount!");

                    } else {

                        System.out.println(tempIngredientAmount + " is a not valid amount!");
                        System.out.println("Please enter an amount between 1 and 100: ");
                        tempIngredientAmount = scnr.nextInt();

                        if (tempIngredientAmount > 1 && tempIngredientAmount <= MAX_AMOUNT) {

                            System.out.println(tempIngredientAmount + " is a valid amount!");

                        } else if (tempIngredientAmount < 1) {

                            System.out.println(tempIngredientAmount + "is less than 1. Sorry you are out of attempts.");

                        } else {

                            System.out.println(tempIngredientAmount + "is greater than 100. Sorry you are out of attempts.");

                        }
                    }
                } else {

                    System.out.println("Error: That is not a number. Try again.");
                }

                //Prompt user for the unit of measurement
                System.out.println("Please enter the unit of measurement for "
                        + tempNameOfIngredient + ": ");
                tempUnitMeasurement = scnr.next();

                //validate unit of measurement
                while (tempUnitMeasurement.isEmpty()) {
                    System.out.println("Please enter a valid unit of measurement for "
                            + tempNameOfIngredient + ": ");
                    tempUnitMeasurement = scnr.next();
                };

                //validate unit of measurement
                //reset hasExpectedValue
                hasExpectedValue = false;

                while (!hasExpectedValue) {

                    //Prompt user for the number of calories per unit of measurement
                    System.out.println("Please enter the calories per "
                            + tempUnitMeasurement + ": ");

                    if (scnr.hasNextInt()) {
                        
                        hasExpectedValue = true;
                        tempNumberCaloriesPerUnit = scnr.nextInt();
                        
                    } else {
                        
                        hasExpectedValue = false;
                    }
                    //End While
                };

                //Consume and reset newline left-over after calling the nextInt() method above.
                scnr.nextLine();

                //Calculate total calories (number of cups x number of calories per cup)
                tempTotalCalories = tempIngredientAmount * tempNumberCaloriesPerUnit;

                //Set the ingredient                
                new_ingredient = new Ingredient(
                        tempNameOfIngredient,
                        tempUnitMeasurement,
                        tempIngredientAmount,
                        tempNumberCaloriesPerUnit,
                        tempTotalCalories);

                //add new ingredient to list of ingredients
                //ingredientList.add(new_ingredient);

            } catch (InputMismatchException e) {

                //if an unexpected error occurs, catch the error here and 
                //display a friendly error message to user
                System.out.println("An error occured while processing your request. Try again.");
                scnr.nextLine();

            } finally {

            }
 
 
        return new_ingredient;
        //End main 
    }

    //End Class    
}
