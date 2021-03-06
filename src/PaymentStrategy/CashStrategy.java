package PaymentStrategy;

import com.itextpdf.text.Chunk;

public class CashStrategy implements PaymentStrategy{

    private double amountPaid;
    private int paymentId = 0;
    private int cartId;

    //PARTIAL CONSTRUCTOR
    public CashStrategy(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public CashStrategy(double amountPaid, int paymentId, int cartId){
        this.amountPaid = amountPaid;
        this.paymentId = paymentId;
        this.cartId = cartId;
    }

    @Override
    public void pay(double amount) {

    }

    public Chunk getChunk(){

        Chunk finalChunk = new Chunk();

        finalChunk.append("Paid using Cash" + "\n");
        finalChunk.append("Amount paid: " + amountPaid + "\n");
        finalChunk.append("Payment Id: " + paymentId + "\n");
        finalChunk.append("Cart Id is: " + cartId + "\n");

        return finalChunk;
    }

    @Override
    public String toString() {
        return "CashStrategy{" +
                "amountPaid=" + amountPaid +
                ", paymentId=" + paymentId +
                ", cartId=" + cartId +
                '}';
    }

    @Override
    public String getPaymentType(){
        return "Cash";
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId() {
        this.paymentId += 1;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
