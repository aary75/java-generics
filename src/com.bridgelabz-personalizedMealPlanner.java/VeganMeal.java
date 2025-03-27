package com.bridgelabz-personalizedMealPlanner;
import java.util.*;


class VeganMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Vegan";
    }

    @Override
    public List<String> getAllowedFoodGroups() {
        return List.of("Vegetables", "Fruits", "Grains", "Legumes", "Nuts", "Seeds");
    }

    @Override
    public List<String> getRestrictedFoodGroups() {
        return List.of("Meat", "Poultry", "Fish", "Seafood", "Dairy", "Eggs");
    }

    @Override
    public boolean isFoodAllowed(String food) {
        return !getRestrictedFoodGroups().contains(food);
    }
}
