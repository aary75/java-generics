package com.bridgelabz-personalizedMealPlanner;
import java.util.*;


// Demo class
public class PersonalizedMealPlanner {
    public static void main(String[] args) {
        MealPlanGenerator generator = new MealPlanGenerator();
        
        // Create different meal plans
        VegetarianMeal vegetarian = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        HighProteinMeal highProtein = new HighProteinMeal();
        
        // Generate sample meals for each plan
        System.out.println("=== Sample Meals ===");
        System.out.println(generator.generateRandomMeal(vegetarian, "Vegetarian Sample"));
        System.out.println("\n" + generator.generateRandomMeal(vegan, "Vegan Sample"));
        System.out.println("\n" + generator.generateRandomMeal(keto, "Keto Sample"));
        System.out.println("\n" + generator.generateRandomMeal(highProtein, "High-Protein Sample"));
        
        // Generate a weekly vegetarian plan
        System.out.println("\n=== Weekly Vegetarian Plan ===");
        List<List<Meal<VegetarianMeal>>> vegWeeklyPlan = generator.generateWeeklyPlan(vegetarian);
        printWeeklyPlan(vegWeeklyPlan);
        
        // Try to create an invalid meal (should throw exception)
        try {
            Meal<VegetarianMeal> invalidMeal = new Meal<>("Invalid Meal", 
                List.of("Chicken Breast", "Broccoli"), vegetarian, 500);
        } catch (IllegalArgumentException e) {
            System.out.println("\nCaught invalid meal: " + e.getMessage());
        }
    }
    
    private static <T extends MealPlan> void printWeeklyPlan(List<List<Meal<T>>> weeklyPlan) {
        for (int day = 0; day < weeklyPlan.size(); day++) {
            System.out.println("\nDay " + (day + 1) + ":");
            for (Meal<T> meal : weeklyPlan.get(day)) {
                System.out.println("  " + meal);
            }
        }
    }
}
