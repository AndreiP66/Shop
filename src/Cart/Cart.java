package Cart;

import CartItem.CartItem;
import PaymentStrategy.PaymentStrategy;
import Receipt.Receipt;
import Receipt.ReceiptBuilder;
import Receipt.ReceiptReportGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cart {



  private  int cartId, customerId;
   private double totalPrice;
   private boolean wasPaid;
   private LocalDate dateofTransaction;
   private List<CartItem> itemsList = new ArrayList<>();
   private List<PaymentStrategy> payments = new ArrayList<>();


    //Partial constructor - only has CartId;
    public Cart(int cartId){
        this.cartId = cartId;
    }


    //Partial Constructor - Total Price is changing everytime we add or remove and item
    public Cart(int cartId, int customerId, List<CartItem> itemsList){
        this.cartId = cartId;
        this.customerId = customerId;

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





    public void addItem(CartItem item){


        this.itemsList.add(item);

    this.totalPrice += item.getPrice();
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
        payments.add(paymentMethod);

        paymentMethod.setCartId(this.cartId);
        paymentMethod.setPaymentId();

        Receipt receipt = new ReceiptBuilder()
                            .cartIdBuilder(this.cartId)
                            .itemsListBuild(itemsList)
                            .date(dateofTransaction)
                            .totalPrice(this.totalPrice)
                            .buildReceipt();



        ReceiptReportGenerator.generateSingleReceipt(receipt, paymentMethod);

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

}

