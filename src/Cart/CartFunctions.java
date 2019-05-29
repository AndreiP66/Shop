package Cart;

import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CartFunctions {

    public void read_csv(String fileName) {
        try {

            CsvReader data = new CsvReader(fileName);

            data.readHeaders();

            while (data.readRecord()) {

                String cartID = data.get("CartId");
                String customerId = data.get("CustomerId");
                String items = data.get("ItemsCode");
                String total = data.get("TotalPrice");
                String payment = data.get("PaymentId");


         //    CartValidator validator = new CartValidator(cartID,customerId,items,total,payment);

                System.out.println(cartID + " " + customerId + " " + items + " " + total + " " + payment);

            }
            data.close();
        } catch (
                FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }


}
