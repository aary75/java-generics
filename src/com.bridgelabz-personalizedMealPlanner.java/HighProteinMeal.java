package com.bridgelabz-personalizedMealPlanner;
import java.util.*;


class HighProteinMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "High-Protein";
    }

    @Override
    public List<String> getAllowedFoodGroups() {
        return List.of("Meat", "Poultry", "Fish", "Seafood", "Eggs", "Dairy", 
                      "Legumes", "Protein Powders", "Nuts", "Seeds");
    }

    @Override
    public List<String> getRestrictedFoodGroups() {
        return List.of("Refined Carbs", "Sugary Foods");
    }

    @Override
    public boolean isFoodAllowed(String food) {
        return !getRestrictedFoodGroups().contains(food);
    }
}
