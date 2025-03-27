package com.bridgelabz-dynamicOnlineMarketplace
import java.util.*;


enum GadgetCategory implements ProductCategory {
    SMARTPHONE("Smartphone", 99.99, 1499.99),
    LAPTOP("Laptop", 299.99, 3999.99),
    ACCESSORY("Accessory", 4.99, 199.99);

    private final String name;
    private final double minPrice;
    private final double maxPrice;

    GadgetCategory(String name, double minPrice, double maxPrice) {
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
