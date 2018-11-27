/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SteppingStones;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author snhu.edu
 */
public class SteppingStone6_RecipeBox {

    /**
     * Declare instance variables: a private ArrayList of the type
     * SteppingStone5_Recipe named listOfRecipes
     *
     */
    private ArrayList<SteppingStone5_Recipe> listOfRecipes;

    /**
     * Add constructors for the SteppingStone6_RecipeBox()
     *
     */
    //Default constructor
    public void SteppingStone6_RecipeBox() {
        this.listOfRecipes = new ArrayList<>();
    }

    public void SteppingStone6_RecipeBox(ArrayList<SteppingStone5_Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }

    /**
     * Add accessors and mutator for listOfRecipes
     *
     */
    //Return List of Recipes
    public ArrayList<SteppingStone5_Recipe> getListOfRecipes() {
        return this.listOfRecipes;
    }

    public void setListOfRecipes(ArrayList<SteppingStone5_Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }

    /**
     *
     *
     * //addNewRecipe(SteppingStone5_Recipe tmpRecipe) <-- This method should
     * use the SteppingStone5_Recipe.addRecipe() method to add a new
     * SteppingStone5_Recipe to the listOfRecipes
     *
     * @param selectedRecipe
     */
    public void printAllRecipeDetails(String selectedRecipe) {

        SteppingStone5_Recipe new_ingredient = new SteppingStone5_Recipe();

        for (int i = 0; i < getListOfRecipes().size(); i++) {

            if (getListOfRecipes().get(i).getRecipeName().equals(selectedRecipe)) {

                new_ingredient = getListOfRecipes().get(i);
                break;
            }
        }

        new_ingredient.printRecipe();
    }

    public void printAllRecipeNames() {

        for (int i = 0; i < getListOfRecipes().size(); i++) {
            SteppingStone5_Recipe new_ingredient = getListOfRecipes().get(i);
            //Display ingredient name
            System.out.println(new_ingredient.getRecipeName());
        }
    }

    public void addNewRecipe(SteppingStone5_Recipe tmpRecipe) {

        tmpRecipe.addRecipe();
    }

    /**
     * A variation of following menu method should be used as the actual main
     * once you are ready to submit your final application. For this submission
     * and for using it to do stand-alone tests, replace the public void menu()
     * with the standard public static main(String[] args) method
     *
     */
    public void menu() {
        // Create a Recipe Box

        //SteppingStone6_RecipeBox myRecipeBox = new SteppingStone6_RecipeBox(); //Uncomment for main method
        Scanner menuScnr = new Scanner(System.in);

        /**
         * Print a menu for the user to select one of the three options:
         *
         */
        System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "\nPlease select a menu item:");
        while (menuScnr.hasNextInt() || menuScnr.hasNextLine()) {
            System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "\nPlease select a menu item:");
            int input = menuScnr.nextInt();

            /**
             * The code below has two variations: 1. Code used with the
             * SteppingStone6_RecipeBox_tester. 2. Code used with the public
             * static main() method
             *
             * One of the sections should be commented out depending on the use.
             */
            /**
             * This could should remain uncommented when using the
             * SteppingStone6_RecipeBox_tester.
             *
             * Comment out this section when using the public static main()
             * method
             */
            //If user wants to add new recipe, show them the add form
            //If they wish to pirnt a;; recipe details, show the print details options
            //If they wish to print just names, give the options to print names only
            //otherwise default to adding a new reipe
            switch (input) {
                case 1:
                    new SteppingStone5_Recipe().addRecipe();
                    break;
                case 2:
                    System.out.println("Which recipe?\n");
                    String selectedRecipeName = menuScnr.next();
                    printAllRecipeDetails(selectedRecipeName);
                    break;
                case 3:
                    for (int j = 0; j < listOfRecipes.size(); j++) {
                        System.out.println((j + 1) + ": " + listOfRecipes.get(j).getRecipeName());
                    }
                    break;
                default:
                    System.out.println("\nMenu\n" + "1. Add Recipe\n" + "2. Print Recipe\n" + "3. Adjust Recipe Servings\n" + "\nPlease select a menu item:");
                    break;
            }

            System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "\nPlease select a menu item:");
        }

    }

}

/**
 *
 * Final Project Details:
 *
 * For your final project submission, you should add a menu item and a method to
 * access the custom method you developed for the Recipe class based on the
 * Stepping Stone 5 Lab.
 *
 */
