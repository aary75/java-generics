package com.bridgelabz.warehouseManagement;
import java.util.*;

class Furniture extends WarehouseItem{
    private String material;
    
    public Furniture(String name, double weight, String id, String material){
        super(name, weight, id);
        this.material = material;
    }
    
    @Override
    public String toString(){
        return super.toString() + ", material" + material;
    }
}
