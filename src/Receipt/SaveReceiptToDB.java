package Receipt;

import PaymentStrategy.PaymentStrategy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveReceiptToDB {

}
    private static final String dbURL = "jdbc:mysql://159.69.118.199:3306/wantsome_java?useSSL=false";
    public static final String SQL_UPDATE = "INSERT INTO Andrei_Receipt (CartId, PaymentType, ItemCategories, NoOfItems, TotalPrice, Receipt)" +
            " Values(?,?,?,?,?,?)";


    public static final int cartIdIDX = 1;
    public static final int paymentIDX = 2;
    public static final int categoriesIDX = 3;
    public static final int noOfItemsIDX = 4;
    public static final int totalPriceIDX = 5;
    public static final int receiptIDX = 6;


    public static void saveToDB(Receipt receipt, PaymentStrategy paymentStrategy) {

        try (Connection con = DriverManager.getConnection(dbURL, "wantsomeJava", "r8m4Jb4~")) {

            System.out.println("Database connection created");

            PreparedStatement ptsmt = con.prepareStatement(SQL_UPDATE);

            ptsmt.setInt(cartIdIDX, receipt.getCartId());
            ptsmt.setString(paymentIDX, paymentStrategy.getPaymentType());
            ptsmt.setString(categoriesIDX, ReceiptFunctions.getCategories(receipt.getItemsList()));
            ptsmt.setInt(noOfItemsIDX, receipt.getItemsList().size());
            ptsmt.setDouble(totalPriceIDX, receipt.getCartTotalPrice());
            ptsmt





        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

}
