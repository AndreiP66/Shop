package PaymentStrategy;

public class PaymentValidator {

  private  int paymentId, cartId;
  private  double amount;

    public PaymentStrategy validatePayment(String paymentId, String cartId, String amount, String type, String customer){

        PaymentStrategy payment;

        if(!paymentId.trim().isEmpty()){
            this.paymentId = Integer.parseInt(paymentId);
        }else {
            System.err.println("Payment Id is invalid");
        }

        if(!cartId.trim().isEmpty()){
            this.cartId = Integer.parseInt(cartId);
        }else {
            System.err.println("Cart Id is invalid");
        }

        if(!amount.trim().isEmpty()){
            this.amount = Double.parseDouble(amount);
        }else{
            System.err.println("Amount is invalid");
        }

        if(this.amount < 0 ) {
            System.err.println("Paid ammount cannot be less than 0");
        }

        switch (type){
            case "Paypal": payment= new PayPalStrategy(customer,this.paymentId,this.cartId,this.amount);
                break;
            case "Credit": payment = new CreditCardStrategy(customer,this.paymentId,this.cartId);
                break;
            default: payment = new CashStrategy(this.amount, this.paymentId, this.cartId);

        }

        return  payment;

            }

}
