package Model;

import java.util.*;

/**
 * Recipe is the component of the composite design pattern.
 * Provides the means for creating a recipe object.
 * It implements the food interface
 *
 * @author John Hill, Iris, Tim Endersby
 * @version 3/26/18
 */


public class Recipe implements Food {

    private String recipeName; //Name of Recipe
    private ArrayList<Food> recipeIngredients; //Ingredients (Basic food or recipes)
    private double servings; //Number of servings portion (used when inside another recipe)

    /**
     * Constructor for a recipe
     *
     * @param _recipeName        Name of the Recipe
     * @param _recipeIngredients Arraylist of SubRecipes
     */
    public Recipe(String _recipeName, ArrayList<Food> _recipeIngredients) {
        recipeName = _recipeName;
        recipeIngredients = _recipeIngredients;
        servings = 1;
        getTotal();
    }

    /**
     * Calculates total nutritional values of the recipe
     * @return Array of totals for recipe nutritional values double[calories, fats, carbs, proteins]
     */
    public double[] getTotal() {
        //Initialise variables
        double calories = 0;
        double carbs = 0;
        double fats = 0;
        double proteins = 0;

        //Add up totals of all the recipe ingredients
        for (Food f : recipeIngredients) {
            double[] totals = f.getTotal();
            double subServings = f.getServings();
            calories += totals[0] * subServings;
            fats += totals[1] * subServings;
            carbs += totals[2] * subServings;
            proteins += totals[3] * subServings;
        }

        //Print for testing
        //System.out.println("Food: " + recipeName + " Calories:" + calories + " Fats:" + fats + " Carbs:" + carbs + " Proteins:" + proteins);
        return new double[]{calories, fats, carbs, proteins};
    }

    /**
     * Gets name of recipe
     *
     * @return name string
     */
    public String getName() {
        return recipeName;
    }

    /**
     * Sets the number of servings for a basic food
     * Used when food is contained in another recipe
     *
     * @param _servings Number of servings
     */
    public void setServings(double _servings) {
        servings = _servings;
    }

    /**
     * Gets the number of servings for a recipe
     * Used when recipe is contained in another recipe
     *
     * @return Number of servings
     */
    public double getServings() {
        return servings;
    }
}