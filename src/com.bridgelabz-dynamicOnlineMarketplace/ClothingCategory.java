package com.bridgelabz-dynamicOnlineMarketplace;
import java.util.*;


enum ClothingCategory implements ProductCategory {
    MEN("Men's Clothing", 9.99, 199.99),
    WOMEN("Women's Clothing", 9.99, 249.99),
    KIDS("Kids' Clothing", 4.99, 99.99);

    private final String name;
    private final double minPrice;
    private final double maxPrice;

    ClothingCategory(String name, double minPrice, double maxPrice) {
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
