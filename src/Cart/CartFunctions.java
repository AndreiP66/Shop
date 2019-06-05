package Cart;

import CartItem.CartItem;
import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                String payment = data.get("WasPaid");
                String date = data.get("Date");

             Cart cart =  new CartValidator().validateCartData(cartID,customerId,items,total,payment, date);
            cartTesting.add(cart);

   //     System.out.println(cartID + " " + customerId + " " + items + " " + total + " " + payment + " " + date);

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

    public Set<String> get_unique_categories(List<CartItem> list){

        Set<String> categories = new HashSet<>();

        for(CartItem item : list){
            categories.add(item.getCategory());
        }

        return categories;
    }


}
