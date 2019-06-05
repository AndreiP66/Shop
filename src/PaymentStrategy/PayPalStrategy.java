package PaymentStrategy;

import com.itextpdf.text.Chunk;

public class PayPalStrategy implements PaymentStrategy {

    private String email;
    private String password;
    private int paymentId;
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
        finalChunk.append("User: " + email);

        return finalChunk;
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
}
