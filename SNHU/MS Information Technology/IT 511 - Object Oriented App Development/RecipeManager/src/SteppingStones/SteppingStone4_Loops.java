package SteppingStones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author snhu.edu
 */
public class SteppingStone4_Loops {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String recipeName = "";
        ArrayList<String> ingredientList = new ArrayList();

        boolean addMoreIngredients = true;

        /* Prompt user to enter recipe name and assign to variable recipe Name*/
        System.out.println("Please enter the recipe name: ");
        recipeName = scnr.nextLine();

        /* Code will check
             * the reply: "y" --> prompt for the ingredient and add it to the
             * ingredient list; "n" --> break out of the loop*/
       do {
            System.out.println("Would you like to enter an ingredient: (y or n)");
            String reply = scnr.next().toLowerCase();

            if (reply.equals("n")) {

                addMoreIngredients = false;
                break;
            }
            
            //Consume newline left-over after calling the next() method above.
            scnr.nextLine();
            
            //Prompt user to enter an ingredient
            System.out.println("Please enter an ingredient: ");
            String newIngredient = scnr.nextLine();

            /* Add ingredient to list of ingredients */
            ingredientList.add(newIngredient);

        } while (addMoreIngredients); 

        /* If the list of ingredients is not empty, display it to user*/
        if (ingredientList.size() > 0) {

            System.out.println("List of ingredients for "+ recipeName +": ");
            /*Print out each ingredient in the list of ingredients*/
            String ingredient = "";
            for (int i = 0; i < ingredientList.size(); i++) {
                /**
                 * Get the item i from the ingredient list and assigning it to
                 * the String ingredient for printing
                 */

                ingredient = ingredientList.get(i);
                System.out.println(ingredient);
            }
        }
    }
}
