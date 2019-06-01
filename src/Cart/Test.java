package Cart;

import CartItem.CartItem;
import PaymentStrategy.PayPalStrategy;
import com.itextpdf.text.pdf.AcroFields;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        CartFunctions functions = new CartFunctions();

        functions.read_csv("C:\\Users\\Bear\\IdeaProjects\\Shop\\Cart.csv");

//        CartItem item  = new CartItem("blue pen", 1003,12,"Category",2);
//
//        List<CartItem> list = new ArrayList<>();
//
//        list.add(item);
//
//        Cart cart = new Cart(100,list);
//
//        cart.setTotalPrice(12);
//
//        System.out.println(cart);
//
//        cart.pay(new PayPalStrategy("example@example.com","pwd"));



    }
}
