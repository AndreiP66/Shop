package PaymentStrategy;

public class CreditCardStrategy implements PaymentStrategy {

    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardStrategy(String cardNumber, String cvv, String dateOfExpiry) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(double amount) {

        //TODO -daca omul care vrea sa plateasca are destui bani pe card - verificarea asta ar trebui facuta de programul bancii la care e cardul respectiv, nu?

        System.out.println(amount + " successfully paid using Credit Card");
    }
}
