package PaymentStrategy;

import com.itextpdf.text.Chunk;

public class PayPalStrategy implements PaymentStrategy {

    private String email;
    private String password;
    private int paymentId = 200;
    private int cartId;
    private double amount;  // is this necessary?


    public PayPalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public PayPalStrategy(String email, int paymentId, int cartId, double amount) {
        this.email = email;
        this.paymentId = paymentId;
        this.cartId = cartId;
        this.amount = amount;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " successfully paid using Paypal");
    }

    @Override
    public Chunk getChunk() {
        Chunk finalChunk = new Chunk();

        finalChunk.append("Paid using Paypal" + "\n");
        finalChunk.append("User: " + email + "\n");
        finalChunk.append("Payment Id: " + paymentId + "\n");
        finalChunk.append("Cart Id: " + cartId + "\n");


        return finalChunk;
    }

    @Override
    public void setCartId(int cartId) {
        this.cartId = cartId;

    }

    @Override
    public void setPaymentId() {
        this.paymentId += 1;

    }

    @Override
    public String toString() {
        return "PayPalStrategy{" +
                "email='" + email + '\'' +
                ", paymentId=" + paymentId +
                ", cartId=" + cartId +
                ", amount=" + amount +
                '}';
    }

    @Override
    public String getPaymentType(){
        return "Paypal";
    }
}
