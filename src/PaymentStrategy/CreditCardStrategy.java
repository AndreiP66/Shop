package PaymentStrategy;

public class CreditCardStrategy implements PaymentStrategy {

    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    private int paymentId;
    private int cartId;
    private String customerName;


    public CreditCardStrategy(String cardNumber, String cvv, String dateOfExpiry) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    public CreditCardStrategy(String customerName,int paymentId, int cartId) {
        this.paymentId = paymentId;
        this.cartId = cartId;
        this.customerName = customerName;
    }

    @Override
    public void pay(double amount) {

        //TODO -daca omul care vrea sa plateasca are destui bani pe card - verificarea asta ar trebui facuta de programul bancii la care e cardul respectiv, nu?


        //TODO - method to check if card is available - gen sa nu fie expirat
        System.out.println(amount + " successfully paid using Credit Card");
    }


    @Override
    public String toString() {
        return "CreditCardStrategy{" +
                "paymentId=" + paymentId +
                ", cartId=" + cartId +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
