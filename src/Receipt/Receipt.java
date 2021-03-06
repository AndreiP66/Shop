package Receipt;

import CartItem.CartItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private long receiptId = 100;
    private int cartId;
    private List<CartItem> itemsList = new ArrayList<>();
    private double cartTotalPrice;
    private LocalDate cartDate;

    private double itemPrice;
    private String itemCategory;


    public Receipt(List<CartItem> list, LocalDate date, double totalPrice, int cartId){
        this.itemsList.addAll(list);
        this.cartDate = date;
        this.cartTotalPrice = totalPrice;
        this.cartId = cartId;
        this.receiptId += 1;
    }

    public Receipt(long receiptId, List<CartItem> itemsList, double cartTotalPrice, LocalDate cartDate, double itemPrice, String itemCategory) {
        this.receiptId += 1;
        this.itemsList = itemsList;
        this.cartTotalPrice = cartTotalPrice;
        this.cartDate = cartDate;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
    }

    public int getCartId() {
        return cartId;
    }

    public long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(long receiptId) {
        this.receiptId = receiptId;
    }

    public List<CartItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<CartItem> itemsList) {
        this.itemsList = itemsList;
    }

    public double getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(double cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public LocalDate getCartDate() {
        return cartDate;
    }

    public void setCartDate(LocalDate cartDate) {
        this.cartDate = cartDate;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }
}
