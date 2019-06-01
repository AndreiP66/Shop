package Cart;

import CartItem.CartItem;
import PaymentStrategy.PaymentStrategy;
import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    //TESTING COMMIT

  private  int cartId, customerId;
   private double totalPrice;
   private List<CartItem> itemsList = new ArrayList<>();

   //Partial constructor used for testing - lipseste CustomerId

    public Cart(int cartId, List<CartItem> itemsList){
        this.cartId=cartId;
        this.itemsList=itemsList;
    }


    //FULL CONSTRUCTORS -
    public Cart(int cartId, int customerId, double totalPrice, List<CartItem> itemsList) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.itemsList = itemsList;
    }

    //Partial Consturctor - Total Price is changing everytime we add or remove and item
    public Cart(int cartId, int customerId, List<CartItem> itemsList){
        this.cartId = cartId;
        this.customerId = customerId;


    }




    public void addItem(CartItem item){

        this.itemsList.add(item);

        //this.totalPrice += item.getPrice();
    }

    public void removeItem(CartItem item){

   //     this.totalPrice -= item.getPrice();

    }

    public double calculateTotalPrice(){
        return this.totalPrice;
    }

    //TODO mai avem nevoie de alte metode?

    public void pay(PaymentStrategy paymentMethod){
        double amount = calculateTotalPrice();
        paymentMethod.pay(amount);

    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", customerId=" + customerId +
                ", totalPrice=" + totalPrice +
                ", itemsList=" + itemsList +
                '}';
    }

    public void printCartItems(List<CartItem> itemsList){
        for(CartItem item : itemsList){
            System.out.println(item.toString());
        }
    }


    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<CartItem> itemsList) {
        this.itemsList = itemsList;
    }
}

