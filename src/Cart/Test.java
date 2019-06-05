package Cart;

import CartItem.CartItem;
import PaymentStrategy.CashStrategy;
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

//       functions.read_csv("C:\\Users\\Bear\\IdeaProjects\\Shop\\Cart.csv");

        CartDBFunctions functionDB = new CartDBFunctions();

       System.out.println(functionDB.get_Item_from_database(1000));

        List<CartItem> list = new ArrayList<CartItem>();
        CartItem item = new CartItem("name", 123, 12,"test",1);
        CartItem item1 = new CartItem("Pencil", 123, 13.6,"Accessories",1);
        CartItem item2 = new CartItem("Book", 123, 14,"Education",1);
        CartItem item3 = new CartItem("Computer", 123, 1400,"Electronics",1);
        CartItem item4 = new CartItem("Sword", 123, 6500,"Weapons",1);


        Cart cart = new Cart(205);
        cart.addItem(item);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.addItem(item4);

        cart.pay(new CashStrategy(12, 1,205));

        System.out.println(cart.toString());

    }











}
