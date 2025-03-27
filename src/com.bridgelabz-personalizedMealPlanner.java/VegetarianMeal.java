package com.bridgelabz-personalizedMealPlanner;
import java.util.*;

class VegetarianMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Vegetarian";
    }

    @Override
    public List<String> getAllowedFoodGroups() {
        return List.of("Vegetables", "Fruits", "Grains", "Dairy", "Eggs", "Legumes");
    }

    @Override
    public List<String> getRestrictedFoodGroups() {
        return List.of("Meat", "Poultry", "Fish", "Seafood");
    }

    @Override
    public boolean isFoodAllowed(String food) {
        return !getRestrictedFoodGroups().contains(food);
    }
}
