class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    
    public void addItem(T item){
        items.add(item);
        System.out.println("Added: "+ item);
    }
    
    public T getItem(String id){
        for(T item: item){
            if(item:getId().equals(id)){
                return item;
            }
        }
        
        return null;
    }
    
    public List<T> getAllItem(){
        return new ArrayList<>(items);
    }
    
    public static void displayAllItems(List<? extends WarehouseItem> items){
       if(items.isEmpty()) {
           Sstem.out.print("Storage is empty.");
       }
       else{
           for(WarehouseItem item: items){
               System.out.println(item);
           }
       }
       System.out.println("Total items: " + items.size()+ "\n");
    }
}
