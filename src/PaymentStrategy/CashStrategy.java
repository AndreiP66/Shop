package PaymentStrategy;

public class CashStrategy implements PaymentStrategy{

    private double amountPaid;
    private int paymentId;
    private int cartId;


    public CashStrategy(double amountPaid, int paymentId, int cartId) {
        this.amountPaid = amountPaid;
        this.paymentId = paymentId;
        this.cartId = cartId;
    }

    @Override
    public void pay(double amount) {

    }

    @Override
    public String toString() {
        return "CashStrategy{" +
                "amountPaid=" + amountPaid +
                ", paymentId=" + paymentId +
                ", cartId=" + cartId +
                '}';
    }
}
