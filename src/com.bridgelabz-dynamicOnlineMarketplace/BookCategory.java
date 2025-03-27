package com.bridgelabz-dynamicOnlineMarketplace
import java.util.*;


// Specific category implementations
enum BookCategory implements ProductCategory {
    FICTION("Fiction", 5.99, 29.99),
    NON_FICTION("Non-Fiction", 7.99, 49.99),
    TEXTBOOK("Textbook", 19.99, 199.99);

    private final String name;
    private final double minPrice;
    private final double maxPrice;

    BookCategory(String name, double minPrice, double maxPrice) {
        this.name = name;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public String getCategoryName() {
        return name;
    }

    @Override
    public double getMinPrice() {
        return minPrice;
    }

    @Override
    public double getMaxPrice() {
        return maxPrice;
    }
}
