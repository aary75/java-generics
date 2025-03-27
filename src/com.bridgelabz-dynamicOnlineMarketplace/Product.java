package com.bridgelabz-dynamicOnlineMarketplace
import java.util.*;


// Generic Product class
class Product<T extends ProductCategory> {
    private String id;
    private String name;
    private T category;
    private double price;

    public Product(String id, String name, T category, double price) {
        if (price < category.getMinPrice() || price > category.getMaxPrice()) {
            throw new IllegalArgumentException("Price must be between " + 
                category.getMinPrice() + " and " + category.getMaxPrice() + 
                " for category " + category.getCategoryName());
        }
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public T getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < category.getMinPrice() || price > category.getMaxPrice()) {
            throw new IllegalArgumentException("Price must be between " + 
                category.getMinPrice() + " and " + category.getMaxPrice());
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category.getCategoryName() +
                ", price=$" + String.format("%.2f", price) +
                '}';
    }
}
