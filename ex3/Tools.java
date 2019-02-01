public class Tools {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private int supplierID;

    public Tools(int id, String name, int quantity, double price, int supplierID) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplierID = supplierID;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int newQ){
        quantity = newQ;
    }

}
