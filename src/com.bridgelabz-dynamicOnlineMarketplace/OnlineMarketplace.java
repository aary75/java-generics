package com.bridgelabz-dynamicOnlineMarketplace;
import java.util.*;

// Demo class
public class OnlineMarketplace {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        // Create products of different categories
        Product<BookCategory> book = new Product<>("B001", "The Great Gatsby", 
                BookCategory.FICTION, 12.99);
        Product<ClothingCategory> shirt = new Product<>("C001", "Cotton T-Shirt", 
                ClothingCategory.MEN, 19.99);
        Product<GadgetCategory> phone = new Product<>("G001", "Smartphone X", 
                GadgetCategory.SMARTPHONE, 999.99);

        // Add products to catalog
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        // Apply discounts
        catalog.applyDiscount(book, 15); // 15% off book
        catalog.applyDiscount(phone, 10); // 10% off phone

        // Display all products
        catalog.displayAllProducts();

        // Get products by specific category
        List<Product<BookCategory>> books = catalog.getProductsByCategory(BookCategory.class);
        System.out.println("\nBooks in catalog:");
        books.forEach(System.out::println);
    }
}
