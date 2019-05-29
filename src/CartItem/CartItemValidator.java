package CartItem;

public class CartItemValidator {

    public double validatePrice(String price){

        double itemPrice = 0;

        if(!price.trim().isEmpty()){
             itemPrice = Double.parseDouble(price);
        } else {}


         if (itemPrice > 0) {
             return itemPrice;
         } else throw new ArithmeticException("Price is less than 0");
    }


    public int validateStock(String stock){

        int itemStock = 0;

        if(!stock.trim().isEmpty()){
            itemStock = Integer.parseInt(stock);
        }else {}

        if(itemStock >= 0){
            return  itemStock;
        }else throw new ArithmeticException("Stock is less than 0");
    }

}
