package PaymentStrategy;

public class CreditCardStrategy implements PaymentStrategy {

    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;


    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid with Credit Card");
    }
}
