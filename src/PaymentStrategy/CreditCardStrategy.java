package PaymentStrategy;

import com.itextpdf.text.Chunk;

public class CreditCardStrategy implements PaymentStrategy {

    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    private int paymentId =100;
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
    public Chunk getChunk() {
        Chunk finalChunk = new Chunk();

        finalChunk.append("Paid with CreditCart" + "\n");
        finalChunk.append("Date of Exp: "+ dateOfExpiry + "\n");
        finalChunk.append("Payment Id: " + paymentId + "\n");
        finalChunk.append("Cart Id: " + cartId + "\n");

        return  finalChunk;
    }

    @Override
    public String getPaymentType(){
        return "Credit Card";
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
        return "CreditCardStrategy{" +
                "paymentId=" + paymentId +
                ", cartId=" + cartId +
                ", customerName='" + customerName + '\'' +
                '}';
    }


}
