package com.bridgelabz-personalizedMealPlanner;
import java.util.*;

// Meal Generator class
class MealPlanGenerator {
    private static final Random random = new Random();
    
    // Database of potential foods by category
    private static final List<String> VEGETABLES = List.of("Spinach", "Broccoli", "Kale", "Bell Peppers", "Zucchini");
    private static final List<String> FRUITS = List.of("Apple", "Banana", "Blueberries", "Strawberries", "Avocado");
    private static final List<String> GRAINS = List.of("Quinoa", "Brown Rice", "Oats", "Whole Wheat Bread");
    private static final List<String> DAIRY = List.of("Greek Yogurt", "Cheddar Cheese", "Milk", "Cottage Cheese");
    private static final List<String> MEATS = List.of("Chicken Breast", "Salmon", "Lean Beef", "Turkey");
    private static final List<String> LEGUMES = List.of("Lentils", "Black Beans", "Chickpeas", "Tofu");
    private static final List<String> NUTS = List.of("Almonds", "Walnuts", "Peanuts", "Cashews");
    
    // Generic method to generate a random meal for any plan
    public <T extends MealPlan> Meal<T> generateRandomMeal(T mealPlan, String mealName) {
        List<String> allowedFoods = getAllAllowedFoods(mealPlan);
        List<String> ingredients = new ArrayList<>();
        
        // Generate 3-5 random ingredients
        int ingredientCount = 3 + random.nextInt(3);
        for (int i = 0; i < ingredientCount; i++) {
            ingredients.add(allowedFoods.get(random.nextInt(allowedFoods.size())));
        }
        
        // Calculate random calories (300-800 range)
        int calories = 300 + random.nextInt(500);
        
        return new Meal<>(mealName, ingredients, mealPlan, calories);
    }
    
    // Helper method to get all allowed foods for a plan
    private <T extends MealPlan> List<String> getAllAllowedFoods(T mealPlan) {
        List<String> allowedFoods = new ArrayList<>();
        
        if (mealPlan.isFoodAllowed("Vegetables")) allowedFoods.addAll(VEGETABLES);
        if (mealPlan.isFoodAllowed("Fruits")) allowedFoods.addAll(FRUITS);
        if (mealPlan.isFoodAllowed("Grains")) allowedFoods.addAll(GRAINS);
        if (mealPlan.isFoodAllowed("Dairy")) allowedFoods.addAll(DAIRY);
        if (mealPlan.isFoodAllowed("Meat") || mealPlan.isFoodAllowed("Poultry")) 
            allowedFoods.addAll(MEATS);
        if (mealPlan.isFoodAllowed("Legumes")) allowedFoods.addAll(LEGUMES);
        if (mealPlan.isFoodAllowed("Nuts")) allowedFoods.addAll(NUTS);
        
        return allowedFoods;
    }
    
    // Generate a full day's meal plan
    public <T extends MealPlan> List<Meal<T>> generateDailyPlan(T mealPlan, int day) {
        List<Meal<T>> dailyMeals = new ArrayList<>();
        
        dailyMeals.add(generateRandomMeal(mealPlan, "Day " + day + " Breakfast"));
        dailyMeals.add(generateRandomMeal(mealPlan, "Day " + day + " Lunch"));
        dailyMeals.add(generateRandomMeal(mealPlan, "Day " + day + " Dinner"));
        dailyMeals.add(generateRandomMeal(mealPlan, "Day " + day + " Snack"));
        
        return dailyMeals;
    }
    
    // Generate a weekly meal plan
    public <T extends MealPlan> List<List<Meal<T>>> generateWeeklyPlan(T mealPlan) {
        List<List<Meal<T>>> weeklyPlan = new ArrayList<>();
        
        for (int day = 1; day <= 7; day++) {
            weeklyPlan.add(generateDailyPlan(mealPlan, day));
        }
        
        return weeklyPlan;
    }
}
