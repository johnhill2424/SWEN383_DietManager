package Model;

/**
 * Basic food is a class that is the leaf of the composite pattern.
 * It implements the food interface and provides the means
 * for creating a Basic food object, along with accessors for all the
 * attributes.
 *
 * @author John Hill, Iris, Tim Endersby
 * @version 3/26/18
 */
public class Basic implements Food {

    private String foodName;
    private double calories;
    private double fat;
    private double carbs;
    private double protein;
    private double servings;

    /**
     * Basic food constructor
     *
     * @param foodName_ Name of food
     * @param calories_ Number of calories
     * @param fats_     Amount of fats
     * @param carbs_    Amount of carbs
     * @param proteins_ Amount of protein
     */
    public Basic(String foodName_, double calories_, double fat_, double carbs_, double protein_) {
        foodName = foodName_;
        calories = calories_;
        fat = fat_;
        carbs = carbs_;
        protein = protein_;
        servings = 1;
    }

    /**
     * Gets name of basic food object
     *
     * @return name string
     */
    public String getName() {
        return foodName;
    }
    
    public double getFat(){
      return fat;
    }
    
    public double getCalories(){
      return calories;
    }
    
    public double getProtein(){
      return protein;
    }
    
    public double getCarbs(){
      return carbs;  
    }

    /**
     * Returns array of totals for food nutritional values
     *
     * @return double[calories, fats, carbs, proteins]
     */
    public double[] getTotal() {
        double[] total = new double[]{calories, fat, carbs, protein};
        return total;
    }

    /**
     * Gets the number of servings for a basic food
     * Used when food is contained in another recipe
     *
     * @return Number of servings
     */
    public double getServings() {
        return servings;
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
}