package com.bridgelabz-warehouseManagement;
import java.util.*;

public class WarehouseSystem {
    public static void main(String[] args){
        
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();
        
        electronicsStorage.addItem(new Electrical("Laptop", 2.5, "E001", 24));
        electronicsStorage.addItem(new Electrical("Smartphone", 0.3, "E002", 12));
        
        groceriesStorage.addItem(new Groceries("Apples", 5.0, "G001", "2023-12-31"));
        groceriesStorage.addItem(new Groceries("Milk", 1.0, "G002", "2023-11-15"));
        
        furnitureStorage.addItem(new Furniture("Desk", 15.0, "F001", "Wood"));
        furnitureStorage.addItem(new Furniture("Chair", 7.5, "F002", "Metal"));
        
        Electronics laptop = electronicsStorage.getItem("E001");
        System.out.println("\nRetrieved: "+ laptop);
        
        Storage.displayAllItems(electronicsStorage.getAllItems());
        Storage.displayAllItems(groceriesStorage.getAllItems());
        Storage.displayAllItems(furnitureStorage.getAllItems());
        
        List<WarehouseItem> allItems = new ArrayList<>();
        allItems.addAll(electronicsStorage.getAllItems());
        allItems.addAll(groceriesStorage.getAllItems());
        allItems.addAll(furnitureStorage.getAllItems());
        Storage.displayAllItems(allItems);
    }
}
