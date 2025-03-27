package com.bridgelabz-personalizedMealPlanner;
import java.util.*;


class KetoMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Keto";
    }

    @Override
    public List<String> getAllowedFoodGroups() {
        return List.of("Meat", "Poultry", "Fish", "Seafood", "Eggs", "Low-carb Vegetables", 
                      "High-fat Dairy", "Nuts", "Seeds", "Healthy Oils");
    }

    @Override
    public List<String> getRestrictedFoodGroups() {
        return List.of("Grains", "Sugary Fruits", "Legumes", "Processed Foods", "Sugar");
    }

    @Override
    public boolean isFoodAllowed(String food) {
        return !getRestrictedFoodGroups().contains(food);
    }
}
