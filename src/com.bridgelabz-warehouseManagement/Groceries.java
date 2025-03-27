package com.bridgelabz-warehouseManagement;
import java.util.*;

class Groceries extends WarehouseItem {
    private String expiryDate;
    
    public Groceries(String name, double weight, String id, String expiryDate){
        super(name, weight, id);
        this.expiryDate = expiryDate;
    }
    
    @Override
    public String toString(){
        retrn super.toString() + ", expires=" + expiryDate;
    }
}
