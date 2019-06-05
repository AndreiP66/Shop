package Receipt;

import CartItem.CartItem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReceiptFunctions {

    public static String getCategories(List<CartItem> list){

        Set<String> categories = new HashSet<>();
        String result = "" ;

        for(CartItem item : list){

            categories.add(item.getCategory());
        }

        for(String s : categories){
            result.concat(s);
        }


        if(!result.isEmpty()){
            return result;
        } else throw new NullPointerException("Categories set is null");
    }
}
