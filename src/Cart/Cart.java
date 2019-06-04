package Cart;

import CartItem.CartItem;
import PaymentStrategy.PaymentStrategy;
import Receipt.GenerateReceipt;
import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart {



  private  int cartId, customerId;
   private double totalPrice;
   private boolean wasPaid;
   private LocalDate dateofTransaction;
   private List<CartItem> itemsList = new ArrayList<>();
   private List<PaymentStrategy> payments = new ArrayList<>();

   // Map contains Item as key, and an Integer that represents the number of times the item was added into cart
//  (e.g. you can cart the same phone twice in the same cart)
//    private List<Map<CartItem, Integer>> itemsList = new ArrayList<>();

    //Partial constructor - only has CartId;
    public Cart(int cartId){
        this.cartId = cartId;
    }

   //Partial constructor used for testing - lipseste CustomerId

    public Cart(int cartId, List<CartItem> itemsList){
        this.cartId=cartId;
        this.itemsList=itemsList;
    }


    //FULL CONSTRUCTORS -
    public Cart(int cartId, int customerId, double totalPrice, List<CartItem> itemsList, boolean wasPaid, LocalDate dateofTransaction) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.itemsList = itemsList;
        this.wasPaid = wasPaid;
        this.dateofTransaction = dateofTransaction;
    }

    //Partial Consturctor - Total Price is changing everytime we add or remove and item
    public Cart(int cartId, int customerId, List<CartItem> itemsList){
        this.cartId = cartId;
        this.customerId = customerId;

    }




    public void addItem(CartItem item){


        this.itemsList.add(item);

//        this.totalPrice += item.getPrice();
    }

    public void removeItem(CartItem item){

   //     this.totalPrice -= item.getPrice();

    }

    public double calculateTotalPrice(){
        return this.totalPrice;
    }



    public void pay(PaymentStrategy paymentMethod){
        double amount = calculateTotalPrice();
        paymentMethod.pay(amount);
        payments.add(paymentMethod);
        this.wasPaid = true;
        this.dateofTransaction = LocalDate.now();

        new GenerateReceipt().generateReceiptMethod(Cart.this);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", customerId=" + customerId +
                ", totalPrice=" + totalPrice +
                ", itemsList=" + itemsList +
                ", was paid=" + wasPaid +
                ", date=" + dateofTransaction +
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
//
//    public List<Map<CartItem, Integer>> getItemsList() {
//        return itemsList;
//    }
//
//    public void setItemsList(List<Map<CartItem, Integer>> itemsList) {
//        this.itemsList = itemsList;
//    }
}

