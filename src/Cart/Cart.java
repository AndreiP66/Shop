package Cart;

import CartItem.CartItem;
import PaymentStrategy.PaymentStrategy;
import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    int cartId, customerId;
    double totalPrice;
    List<CartItem> itemsList = new ArrayList<>();

    public Cart(int cartId, int customerId, double totalPrice, List<CartItem> itemsList) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.itemsList = itemsList;
    }

    //TODO another constructor without totalPrice as parameter - gen pentru cand folosim metodele addItem / removeItem

    public void addItem(CartItem item){}

    public void removeItem(CartItem item){}

    public double calculateTotalPrice(){
        return this.totalPrice;
    }

    //TODO mai avem nevoie de alte metode?

    public void pay(PaymentStrategy paymentMethod){
        double amount = calculateTotalPrice();
        paymentMethod.pay(amount);

    }


    }

