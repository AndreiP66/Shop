package Cart;

import CartItem.CartItem;
import com.csvreader.CsvReader;

import java.util.ArrayList;
import java.util.List;

public class CartValidator {

   private    int cartId, customerId;
   private   double totalPrice;
   private boolean wasPaid;
   private List<CartItem> itemsList = new ArrayList<>();



    public Cart validateCartData(String cartId, String customerId, String items, String total, String payment) {

//        if (!cartId.isEmpty()) {
//            this.cartId = Integer.parseInt(cartId);
//        } else System.err.println("Cart Id is Invalid");
//

        check_cartId(cartId);

        check_customerId(customerId);

        check_total(total);

        check_itemsList(items);

        check_payment(payment);

         return new Cart(this.cartId,this.customerId,totalPrice,itemsList, this.wasPaid);

    }

    private void check_cartId(String cartId){
        if (!cartId.isEmpty()) {
            this.cartId = Integer.parseInt(cartId);
        } else System.err.println("Cart Id is Invalid");
    }

    private void check_customerId(String customerId){
        if(!customerId.isEmpty()){
            this.customerId = Integer.parseInt(customerId);
        }
    }

    private void check_total(String total){
        if(!total.isEmpty()){
            this.totalPrice = Double.parseDouble(total);
        }
    }

    private void check_itemsList(String items){
        if(!items.isEmpty()){
            String[] list  = items.trim().split(",");

            for(String string : list){

                if(!string.isEmpty()){
                    long id = Long.parseLong(string.trim());

                    itemsList.add(new CartDBFunctions().get_Item_from_database(id));
                }
            }
        }
    }

    private void check_payment(String payment){
       if(!payment.trim().isEmpty()){
           this.wasPaid = Boolean.valueOf(payment.toLowerCase().trim());
       }

        }
    }










