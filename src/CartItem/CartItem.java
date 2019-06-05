package CartItem;

public class CartItem {


  private  String name;
  private   long uID;
  private   double price;
  private   String category;
  private   int stock;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getuID() {
        return uID;
    }

    public void setuID(long uID) {
        this.uID = uID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getStringPrice(){
        return  Double.toString(price);
    }
}
