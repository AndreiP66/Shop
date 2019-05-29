package Cart;

import CartItem.CartItem;
import com.csvreader.CsvReader;

import java.util.ArrayList;
import java.util.List;

public class CartValidator {

    int cartId, customerId;
    double totalPrice;
    List<CartItem> itemsList = new ArrayList<>();



   public Cart validateCartData(String cartId, String customerId, String items, String total, String payment) {

        if (!cartId.isEmpty()) {
            this.cartId = Integer.parseInt(cartId);
        } else System.err.println("Cart Id is Invalid");


        if(!customerId.isEmpty()){
            this.customerId = Integer.parseInt(customerId);
        }


        if(!total.isEmpty()){
            this.totalPrice = Double.parseDouble(total);
        }

        if(!items.isEmpty()){
            String[] list  = items.trim().split(",");

            for(int i=0; i<list.length;i++){

                if(!list[i].isEmpty()){
                    long id = Long.parseLong(list[i]);

        itemsList.add(new CartDBFunctions().get_Item_from_database(id));
                }
            }
        }

         Cart cart = new Cart(this.cartId,this.customerId,totalPrice,itemsList);

        return  cart;

    }






    }






