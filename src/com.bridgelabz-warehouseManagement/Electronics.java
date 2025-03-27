package com.bridgelabz.warehouseManagement;
import java.util.*;

class Electronics extends WarehouseItem{
    private int warrantyMonths;
    
    pubilc Electronics(String name, double price,int warrantyMonths){
        super(name, price);
        this.warrantyMonts = warrantyMonths;
    }
    
    public int getWarrantyMonths(){
        return warrantyMonths;
    }
    
    @Override
    public String toString(){
        return super.toString() + " [Warranty: " + warrantyMonths + " months]";
    
    }
}
