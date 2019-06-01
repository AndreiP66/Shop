package Cart;

import CartItem.CartItem;
import CartItem.CartItemValidator;

import java.awt.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CartDBFunctions {

    public static final String SQL_getItems = "SELECT * FROM Manuel_Shop_Items where uID=?";
    public static final String dbURL = "jdbc:mysql://159.69.118.199:3306/wantsome_java?useSSL=false";

    public CartItem get_Item_from_database(long itemCode){

  //      Connection con = null;
        ResultSet result = null;
        CartItem item = null;



      try (Connection  con = DriverManager.getConnection(dbURL, "wantsomeJava", "r8m4Jb4~");) {

        System.out.println("Database connection created");

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
