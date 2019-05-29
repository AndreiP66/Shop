package Cart;

import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartFunctions {

    public void read_csv(String fileName) {

        List<Cart> cartTesting = new ArrayList<Cart>();

        try {

            CsvReader data = new CsvReader(fileName);

            data.readHeaders();

            while (data.readRecord()) {

                String cartID = data.get("CartId");
                String customerId = data.get("CustomerId");
                String items = data.get("ItemsCode");
                String total = data.get("TotalPrice");
                String payment = data.get("PaymentId");

             Cart cart =  new CartValidator().validateCartData(cartID,customerId,items,total,payment);
            cartTesting.add(cart);

             //        System.out.println(cartID + " " + customerId + " " + items + " " + total + " " + payment);

            }
            data.close();
        } catch (
                FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        for(Cart cart : cartTesting){
            System.out.println(cart.toString());
        }

    }


}
