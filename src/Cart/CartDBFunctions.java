package Cart;

import CartItem.CartItem;
import CartItem.CartItemValidator;

import java.awt.*;
import java.sql.*;

public class CartDBFunctions {

    public static final String SQL_getItems = "SELECT * FROM cartItems where id=?";


    public CartItem get_Item_from_database(long itemCode){

  //      Connection con = null;
        ResultSet result = null;
        CartItem item = null;



       // try
        //( // Connection con = TODO we need a connection pool?
             //

     //        PreparedStatement preparedStatement = con.prepareStatement(SQL_getItems))
      try  {

          String dbURL = "jdbc:mysql://159.69.118.199:3306/wantsome_java?useSSL=false";

          Connection  con = DriverManager.getConnection(dbURL, "wantsomeJava", "r8m4Jb4~");

        System.out.println("Databse connection created");

        PreparedStatement preparedStatement = con.prepareStatement(SQL_getItems);
            preparedStatement.setLong(1,itemCode);

            result = preparedStatement.executeQuery();

            while(result.next()){
                String name = result.getString("Name");
                String price = result.getString("Price");
                String category = result.getString("Category");
                String stock = result.getString("Stock");

                item = new CartItem(name,itemCode, new CartItemValidator().validatePrice(price), category, new CartItemValidator().validateStock(stock));

            }


        }catch (SQLException exception ){
            System.err.println(exception.getMessage());
        }

        return item; //TODO check if this item is null or not.
    }

}