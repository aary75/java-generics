package com.bridgelabz-personalizedMealPlanner;
import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// MealPlan interface and implementations
interface MealPlan {
    String getPlanName();
    List<String> getAllowedFoodGroups();
    List<String> getRestrictedFoodGroups();
    boolean isFoodAllowed(String food);
}
