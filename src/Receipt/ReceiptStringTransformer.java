package Receipt;

import CartItem.CartItem;
import PaymentStrategy.PaymentStrategy;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptStringTransformer {

    public static final Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

    public static Chunk getDateString(Receipt receipt){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = receipt.getCartDate().format(formatter);
        Chunk chunk = new Chunk(date,font);

        return chunk;
    }

    public static void insertItems(List<CartItem> itemsList, PdfPTable table){
        for(CartItem item : itemsList){
            table.addCell(new PdfPCell(new Paragraph(item.getName())));
            table.addCell(new PdfPCell(new Paragraph(item.getStringPrice())));
        }
    }

    public static Chunk totalPrice(Double price){
        Font font2 = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        String receiptTotalString = Double.toString(price);
        Chunk receiptTotal = new Chunk(receiptTotalString,font2);
        return receiptTotal;
    }

    public static Chunk numberOfItems(List<CartItem> itemsList){
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        String items = Integer.toString(itemsList.size());
        Chunk numberOfItems = new Chunk(items,font);
        return numberOfItems;
    }
}
