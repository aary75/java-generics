package com.bridgelabz-personalizedMealPlanner;
import java.util.*;


// Generic Meal class
class Meal<T extends MealPlan> {
    private String name;
    private List<String> ingredients;
    private T mealPlanType;
    private int calories;

    public Meal(String name, List<String> ingredients, T mealPlanType, int calories) {
        if (!validateMeal(ingredients, mealPlanType)) {
            throw new IllegalArgumentException("Meal contains restricted ingredients for " + 
                                             mealPlanType.getPlanName() + " plan");
        }
        this.name = name;
        this.ingredients = new ArrayList<>(ingredients);
        this.mealPlanType = mealPlanType;
        this.calories = calories;
    }

    // Generic method to validate meal against plan
    private boolean validateMeal(List<String> ingredients, T mealPlanType) {
        for (String ingredient : ingredients) {
            if (!mealPlanType.isFoodAllowed(ingredient)) {
                System.out.println("Invalid ingredient for " + mealPlanType.getPlanName() + 
                                 ": " + ingredient);
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public T getMealPlanType() {
        return mealPlanType;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return name + " (" + mealPlanType.getPlanName() + ") - " + calories + " cal\n" +
               "Ingredients: " + String.join(", ", ingredients);
    }
}
