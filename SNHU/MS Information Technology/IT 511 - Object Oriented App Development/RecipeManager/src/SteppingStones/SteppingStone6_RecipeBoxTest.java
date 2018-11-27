/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SteppingStones;

import java.util.Scanner;

/**
 *
 * @author snhu.edu
 */
public class SteppingStone6_RecipeBoxTest {

    private static SteppingStone5_Recipe myRecipeBox;

    public static void main(String[] args) {
        // Create a Recipe Box

        SteppingStone6_RecipeBox myRecipesBox = new SteppingStone6_RecipeBox();

        Scanner menuScnr = new Scanner(System.in);

        /**
         * Print a menu for the user to select one of the three options:
         *
         */
        System.out.println("Menu\n" + "1. Add Recipe\n"
                + "2. Print All Recipe Details\n"
                + "3. Print All Recipe Names\n"
                + "\nPlease select a menu item:");

        while (menuScnr.hasNextInt() || menuScnr.hasNextLine()) {
            System.out.println("Menu\n" + "1. Add Recipe\n"
                    + "2. Print All Recipe Details\n"
                    + "3. Print All Recipe Names\n"
                    + "\nPlease select a menu item:");

            int input = menuScnr.nextInt();

            switch (input) {
                case 1:
                    myRecipeBox.addRecipe();
                    break;
                case 2:
                    System.out.println("Which recipe?\n");
                    String selectedRecipeName = menuScnr.next();
                    myRecipesBox.printAllRecipeDetails(selectedRecipeName);
                    break;
                case 3:
                    for (int j = 0; j
                            < myRecipesBox.getListOfRecipes().size(); j++) {
                        System.out.println((j
                                + 1)
                                + ": " + myRecipesBox.getListOfRecipes().get(j).getRecipeName());
                    }   break;
                default:
                    System.out.println("\nMenu\n" + "1. Add Recipe\n"
                            + "2. Print Recipe\n "
                            + "3. Adjust Recipe Servings\n "
                            + "\nPlease select a menu item:");
                    break;
            }

            System.out.println("Menu\n" + "1. Add Recipe\n"
                    + "2. Print All Recipe Details\n"
                    + "3. Print All Recipe Names\n"
                    + "\nPlease select a menu item:");
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
