package Cart;

import CartItem.CartItem;
import PaymentStrategy.PayPalStrategy;
import com.itextpdf.text.pdf.AcroFields;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        CartFunctions functions = new CartFunctions();

        //functions.read_csv("C:\\Users\\Bear\\IdeaProjects\\Shop\\Cart.csv");

        CartDBFunctions functionDB = new CartDBFunctions();

       System.out.println(functionDB.get_Item_from_database(1000));



    }






}
