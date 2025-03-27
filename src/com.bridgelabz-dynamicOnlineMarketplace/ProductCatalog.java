package com.bridgelabz-dynamicOnlineMarketplace;
import java.util.*;

// Product Catalog class
class ProductCatalog {
    private List<Product<? extends ProductCategory>> products = new ArrayList<>();

    // Generic method to add any type of product
    public <T extends ProductCategory> void addProduct(Product<T> product) {
        products.add(product);
        System.out.println("Added: " + product);
    }

    // Generic method to apply discount
    public <T extends ProductCategory> void applyDiscount(Product<T> product, double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        
        double newPrice = product.getPrice() * (1 - percentage/100);
        // Ensure discounted price stays within category bounds
        newPrice = Math.max(newPrice, product.getCategory().getMinPrice());
        product.setPrice(newPrice);
        
        System.out.printf("Applied %.1f%% discount to %s. New price: $%.2f%n",
                percentage, product.getName(), newPrice);
    }

    public void displayAllProducts() {
        System.out.println("\n=== Product Catalog ===");
        if (products.isEmpty()) {
            System.out.println("Catalog is empty.");
        } else {
            products.forEach(System.out::println);
        }
        System.out.println("======================\n");
    }

    // Method to get products by category type
    public <T extends ProductCategory> List<Product<T>> getProductsByCategory(Class<T> categoryClass) {
        return products.stream()
                .filter(p -> categoryClass.isInstance(p.getCategory()))
                .map(p -> (Product<T>) p)
                .toList();
    }
}
