package Cart;

import CartItem.CartItem;
import PaymentStrategy.CashStrategy;
import PaymentStrategy.CreditCardStrategy;
import PaymentStrategy.PayPalStrategy;
import com.itextpdf.text.pdf.AcroFields;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Simulations {

    public static void main(String[] args) {

        CartFunctions functions = new CartFunctions();

     functions.read_csv("C:\\Users\\Bear\\IdeaProjects\\Shop\\Cart.csv");

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

        Cart cart2 = new Cart(206);
        cart2.addItem(item);
        cart2.addItem(item2);

        Cart cart3 = new Cart(207);
        cart3.addItem(item);
        cart3.addItem(item1);


         cart.pay(new CashStrategy(12));

        cart2.pay(new CreditCardStrategy("123456", "123", "20/06/2019"));

        cart3.pay(new PayPalStrategy("example@example.com", "***"));

        System.out.println(cart.toString());

    }











}
