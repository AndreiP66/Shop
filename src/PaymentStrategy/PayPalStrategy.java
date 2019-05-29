package PaymentStrategy;

public class PayPalStrategy implements PaymentStrategy {

    private String email;
    private String password;

    @Override
    public void pay(double amount) {
        System.out.println(amount + " successfully paid using Paypal");
    }
}
