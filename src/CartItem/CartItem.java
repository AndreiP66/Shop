package CartItem;

public class CartItem {


    String name;
    long uID;
    double price;
    String category;
    int stock;

    public CartItem(String name, long uID, double price, String category, int stock) {
        this.name = name;
        this.uID = uID;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "name='" + name + '\'' +
                ", uID=" + uID +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", stock=" + stock +
                '}';
    }
}
