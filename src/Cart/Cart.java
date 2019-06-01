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


    public Cart(int cartId, int customerId, double totalPrice, List<CartItem> itemsList) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.itemsList = itemsList;
    }

    public Cart(int cartId, int customerId, List<CartItem> itemsList){
        this.cartId = cartId;
        this.customerId = customerId;


    }




    public void addItem(CartItem item){


        this.itemsList.add(item);
    }

    public void removeItem(CartItem item){}

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

}

