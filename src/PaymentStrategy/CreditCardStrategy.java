package PaymentStrategy;

public class CreditCardStrategy implements PaymentStrategy {

    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;


    @Override
    public void pay(double amount) {

        //TODO Card object ca sa putem verifica daca omul care vrea sa plateasca are destui bani pe card / la fel si la PayPal

        System.out.println(amount + " paid with Credit Card");
    }
}
