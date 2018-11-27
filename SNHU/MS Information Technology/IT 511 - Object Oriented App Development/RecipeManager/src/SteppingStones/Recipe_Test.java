/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SteppingStones;

import java.util.ArrayList;

/**
 *
 * @author snhu.edu
 */
public class Recipe_Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create two recipe objects first

        Recipe myFirstRecipe = new Recipe();
        ArrayList<Ingredient> recipeIngredients = new ArrayList();
        ArrayList<Ingredient> recipeIngredientsTwo = new ArrayList();

        String ingredientName = "Anchovies";
        Ingredient tempIngredient = new Ingredient();
        tempIngredient.setNameofIngredient(ingredientName);
        recipeIngredients.add(tempIngredient);

        Recipe mySecondRecipe = new Recipe("Pizza", 2, recipeIngredients, 300);

        // Initialize first recipe
        String ingredientNameTwo = "Noodles";
        Ingredient tempIngredientTwo = new Ingredient();
        tempIngredientTwo.setNameofIngredient(ingredientNameTwo);
        recipeIngredientsTwo.add(tempIngredientTwo);

        myFirstRecipe.setRecipeName("Ramen");
        myFirstRecipe.setServings(2);
        myFirstRecipe.setRecipeIngredients(recipeIngredientsTwo);
        myFirstRecipe.setTotalRecipeCalories(150);

        //Invokes the createNewRecipe() method to accept user input
       Recipe myThirdRecipe = new Recipe().createNewRecipe(); 
       
       
        // Print details of all recipes
        myFirstRecipe.printRecipe();
        mySecondRecipe.printRecipe();
        myThirdRecipe.printRecipe();
    }

}
