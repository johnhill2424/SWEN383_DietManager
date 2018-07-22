package Model;

/**
 * Food is in interface for the basic foods and recipe classes.
 *
 * @author John Hill, Iris, Tim Endersby
 * @version 3/26/18
 */


public interface Food {

    /**
     * Returns an array of totals for calories, fats, carbs, proteins
     *
     * @return Array of totals for food nutritional values double[calories, fats, carbs, proteins]
     */
    public double[] getTotal();

    /**
     * Gets name of food object
     *
     * @return name string
     */
    public String getName();

    /**
     * Sets the number of servings for a food object
     * Used when food is contained in another recipe
     *
     * @param _servings Number of servings
     */
    public void setServings(double _servings);

    /**
     * Gets the number of servings for a food object
     * Used when food is contained in another recipe
     *
     * @return Number of servings
     */
    public double getServings();

}