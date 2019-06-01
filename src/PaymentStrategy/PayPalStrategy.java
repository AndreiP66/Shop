package PaymentStrategy;

public class PayPalStrategy implements PaymentStrategy {

    private String email;
    private String password;

    public PayPalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }



    @Override
    public void pay(double amount) {
        System.out.println(amount + " successfully paid using Paypal");
    }
}
