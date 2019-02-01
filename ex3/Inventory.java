import java.util.ArrayList;

public class Inventory {
    private ArrayList<Tools> items;

    public void addItem(int id, String name, int quantity, double price, int supplierID){
        Tools tool = new Tools(id, name, quantity, price, supplierID);
        items.add(id, tool);
    }

    public void deleteItem(int id){
        items.remove(id);
    }

    public Tools searchInventory(int id){
        return items.get(id);
    }

    public Tools searchInventory(String name){
        for(Tools t: items){
            if(name == t.getName())
                return t;
        }
        return null;
    }

}
