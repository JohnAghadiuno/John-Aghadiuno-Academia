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
 * @author snhu.edu
 */

public class SteppingStone5_Recipe { 
    
    private String recipeName;     
    private int servings; 
    private ArrayList<Ingredient> recipeIngredients;  
    private float totalRecipeCalories; 
     
    
    public SteppingStone5_Recipe() {
        this.recipeName = "";
        this.servings = 0;  
        this.recipeIngredients = new ArrayList();  
        this.totalRecipeCalories = 0.0f;        
    }
    
    public SteppingStone5_Recipe(String recipeName, int servings, 
            ArrayList<Ingredient> recipeIngredients, float totalRecipeCalories) 
    {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    public void printRecipe() {
        
        float singleServingCalories = 0.0f;
        singleServingCalories = (getTotalRecipeCalories()/getServings());
           
        System.out.println("Recipe: " + getRecipeName());
        System.out.println("Serves: " + getServings());
        System.out.println("Ingredients:");
         
        for (int i = 0; i < getRecipeIngredients().size(); i++) { 
                Ingredient new_ingredient = getRecipeIngredients().get(i);
                //Display ingredient attributes
                System.out.println(new_ingredient.getNameofIngredient());
            }   
        
        System.out.println("Each serving has " 
                + singleServingCalories + " Calories."); 
    }
        
    //public static void main(String[] args) { 
    public void addRecipe() {       
        
        float totalRecipeCalories = 0.0f;
        ArrayList<Ingredient> recipeIngredients = new ArrayList();
        boolean addMoreIngredients = true;
        
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Please enter the recipe name: ");
        String recipeName = scnr.nextLine();
        
        System.out.println("Please enter the number of servings: "); 
        int servings =  scnr.nextInt();
        
                
        do { 
            System.out.println("Please enter the ingredient name "
                    + "or type end if you are finished entering ingredients: ");
            String ingredientName = scnr.next();
            
            if (ingredientName.toLowerCase().equals("end")) {
                addMoreIngredients = false;
            } else { 
                
                System.out.println("Please enter the ingredient amount: ");
                float ingredientAmount = scnr.nextFloat();                 
            
                System.out.println("Please enter the ingredient Calories: ");
                int ingredientCalories = scnr.nextInt();
                 
                totalRecipeCalories = (ingredientCalories * ingredientAmount);
                //add new ingredient to list of ingredients
                Ingredient new_ingredient = new Ingredient();                
                new_ingredient.setNameofIngredient(ingredientName);
                new_ingredient.setIngredientAmount(ingredientAmount);
                new_ingredient.setNumberCaloriesPerUnit(ingredientCalories); 
                
                recipeIngredients.add(new_ingredient);
            }
           
       } while (!addMoreIngredients == false);
        
        SteppingStone5_Recipe recipe1 = new SteppingStone5_Recipe(recipeName, 
            servings, recipeIngredients, totalRecipeCalories);
        
        
        recipe1.printRecipe();
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
 * 1. Modify this code to develop a Recipe class:
 *	a. change the void main method createNewRecipe() that returns a Recipe 
 * 	 
 * 2. FOR FINAL SUBMISSION ONLY:Change the ArrayList type to an 
 *		Ingredient object.  When a user adds an ingredient to the recipe, 
 * 		instead of adding just the ingredient name, you will be adding the 
 *		actual ingredient including name, amount, measurement type, calories.
 *	For the Milestone Two submission, the recipeIngredients ArrayList can
 *	remain as a String type.
 *
 * 3. Adapt the printRecipe() method to print the amount and measurement
 * 	type as well as the ingredient name.
 *
 * 4. Create a custom method in the Recipe class. 
 *      Choose one of the following options:
 *
 * 	a. print out a recipe with amounts adjusted for a different 
 * 		number of servings
 * 
 * 	b. create an additional list or ArrayList that allow users to 
 * 		insert step-by-step recipe instructions
 *
 * 	c. conversion of ingredient amounts from 
 * 		English to metric (or vice versa)
 *
 * 	d. calculate select nutritional information 
 *
 * 	e. calculate recipe cost
 * 
 *      f. propose a suitable alternative to your instructor
 * 
 */ 

