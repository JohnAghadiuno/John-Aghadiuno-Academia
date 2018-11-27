/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SteppingStones;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author JohnA
 */
public class Recipe {

    //Local variables
    private String recipeName;
    private int servings;
    private ArrayList<Ingredient> recipeIngredients;
    private ArrayList<String> recipeInstructions;
    private float totalRecipeCalories;

    //Constructor without parameters
    public Recipe() {
        this.recipeName = "";
        this.servings = 0;
        this.recipeIngredients = new ArrayList();
        this.recipeInstructions = new ArrayList();
        this.totalRecipeCalories = 0.0f;
    }

    //Constructor with input parameters
    public Recipe(String recipeName, int servings,
            ArrayList<Ingredient> recipeIngredients,
            ArrayList<String> recipeInstructions, float totalRecipeCalories) {

        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstructions = recipeInstructions;
        this.totalRecipeCalories = totalRecipeCalories;
    }

    Recipe(String recipeName, int servings,
            ArrayList<Ingredient> recipeIngredients, float totalRecipeCalories) {

    }

    //Print method
    public void printRecipe() {

        float singleServingCalories = 0.0f;
        singleServingCalories = (getTotalRecipeCalories() / getServings());

        System.out.println("Recipe: " + getRecipeName());
        System.out.println("Serves: " + getServings());
        System.out.println("Ingredients:");

        /*
            For each ingredient in the recipe ingredient list 
                print out the ingredient attributes 
         */
        for (int i = 0; i < getRecipeIngredients().size(); i++) {
            Ingredient new_ingredient = getRecipeIngredients().get(i);
            //Display ingredient information
            System.out.println(new_ingredient.getNameofIngredient() + " uses "
                    + new_ingredient.getIngredientAmount() + " "
                    + new_ingredient.getUnitMeasurement() + " and has "
                    + new_ingredient.getTotalCalories() + " calories.");
        }

        System.out.println("Each serving has "
                + singleServingCalories + " Calories.");

        System.out.println("Step by step instructions:");

        /*
            For each instruction in the recipe instructions list 
                print out instruction 
         */
        for (int i = 0; i < getRecipeInstructions().size(); i++) {
            //Display instruction information
            System.out.println(getRecipeInstructions().get(i));
        }
    }

    //Custom method
    public ArrayList<String> createRecipeInstructions() {
        /*
          Create an empty temporary list to store list of instructions

             Ask user for a list of step by step instruction
                 Stop and exit if they enter "No" to indicate they are finished

                 If input box is empty, ask them to enter valid instruction
                 and keep asking until they enter an instruction

             For every instruction that is entered, save it to our temporary list
             When user is finished, return our list of instructions
         */
        String tempInstructions = "";
        Scanner scnr = new Scanner(System.in);

        //Create an array to store list of instructions
        ArrayList<String> listInstructions = new ArrayList();
        //Boolean value to evalute if user wants to add more instructions or not
        boolean addMoreInstructions = true;
        int instructionCount = 0;

        System.out.println("Would you like to enter step by step "
                + "instructions: (yes or no)");

        String reply = scnr.nextLine().toLowerCase();
        if (reply.equals("yes")) {

            do {

                if (instructionCount == 0) {
                    System.out.println("Please enter recipe instruction. Type 'no' anytime to exit.");
                } else {
                    System.out.println("Please enter next instruction or type 'no' to exit.");
                }

                tempInstructions = scnr.nextLine().toLowerCase();

                if (tempInstructions.equals("no")) {
                    addMoreInstructions = false;
                    break;
                }

                //validate instructions
                while (tempInstructions.isEmpty()) {
                    System.out.println("Instructions cannot be empty. Please try again: ");
                    tempInstructions = scnr.nextLine();
                };

                listInstructions.add(tempInstructions);
                instructionCount++;

            } while (addMoreInstructions);

        }

        return listInstructions;

    }

    public Recipe createNewRecipe() {

        //Create an array to store list of ingredients
        ArrayList<Ingredient> ingredientList = new ArrayList();
        Ingredient ingredient = new Ingredient();
        //Boolean value to evalute if user wants to add more ingredients or not
        boolean addIngredient = true;
        boolean hasExpectedValue = false;

        float totalRecipeCalories = 0.0f;

        //Create an array to store list of ingredients
        ArrayList<Ingredient> recipeIngredients = new ArrayList();
        Scanner scnr = new Scanner(System.in);

        //Prompt user for name of recipe
        System.out.println("Please enter the recipe name: ");
        String recipeName = scnr.nextLine();

        //Prompt user for number of servings
        System.out.println("Please enter the number of servings: ");
        int servings = scnr.nextInt();

        while (addIngredient) {
            System.out.println("Would you like to enter an ingredient: (yes or no)");
            String reply = scnr.nextLine().toLowerCase();

            if (reply.equals("no")) {
                addIngredient = false;
                break;
            }
            //Invoke the addNewIngredient method in our ingredient class
            ingredient = new Ingredient().addNewIngredient();
            ingredientList.add(ingredient);

        };

        //Invoke the createRecipeInstructions for a list of instructions
        ArrayList<String> recipeInstructions = createRecipeInstructions();

        //compute total calories of all ingredients if the array has items
        /*
            if the recipe has at least 1 ingredient then 
                get the total calories 
                    and add to total repipe calories 
         */
        if (recipeIngredients.size() > 0) {

            for (int i = 0; i < recipeIngredients.size(); i++) {

                Ingredient new_ingredient = recipeIngredients.get(i);

                //Increment total recipe calories                 
                totalRecipeCalories += new_ingredient.getTotalCalories();
            }
        }

        Recipe recipe = new Recipe(recipeName,
                servings, recipeIngredients, recipeInstructions, totalRecipeCalories);

        recipe.printRecipe();
        return recipe;
    }

    /**
     * @return the recipeName
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * @param recipeName the recipeName to set
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * @return the servings
     */
    public int getServings() {
        return servings;
    }

    /**
     * @param servings the servings to set
     */
    public void setServings(int servings) {
        this.servings = servings;
    }

    /**
     * @return the recipeIngredients
     */
    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    /**
     * @param recipeIngredients the recipeIngredients to set
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    /**
     * @return the recipeInstructions
     */
    public ArrayList<String> getRecipeInstructions() {
        return recipeInstructions;
    }

    /**
     * @param recipeInstructions the recipeInstructions to set
     */
    public void setRecipeInstructions(ArrayList<String> recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    /**
     * @return the totalRecipeCalories
     */
    public float getTotalRecipeCalories() {
        return totalRecipeCalories;
    }

    /**
     * @param totalRecipeCalories the totalRecipeCalories to set
     */
    public void setTotalRecipeCalories(float totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }
}

/**
 * Final Project
 *
 * For your Final Project:
 *
 * 1. Modify this code to develop a Recipe class: a. change the void main method
 * createNewRecipe() that returns a Recipe
 *
 * 2. FOR FINAL SUBMISSION ONLY:Change the ArrayList type to an Ingredient
 * object. When a user adds an ingredient to the recipe, instead of adding just
 * the ingredient name, you will be adding the actual ingredient including name,
 * amount, measurement type, calories. For the Milestone Two submission, the
 * recipeIngredients ArrayList can remain as a String type.
 *
 * 3. Adapt the printRecipe() method to print the amount and measurement type as
 * well as the ingredient name.
 *
 * 4. Create a custom method in the Recipe class. Choose one of the following
 * options:
 *
 * a. print out a recipe with amounts adjusted for a different number of
 * servings
 *
 * b. create an additional list or ArrayList that allow users to insert
 * step-by-step recipe instructions
 *
 * c. conversion of ingredient amounts from English to metric (or vice versa)
 *
 * d. calculate select nutritional information
 *
 * e. calculate recipe cost
 *
 * f. propose a suitable alternative to your instructor
 *
 */
