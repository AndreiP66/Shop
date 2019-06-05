package Receipt;

import CartItem.CartItem;
import PaymentStrategy.PaymentFunctions;
import PaymentStrategy.PaymentStrategy;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.lang.annotation.Documented;
import java.util.List;

public class ReceiptReportGenerator {

    public ReceiptReportGenerator() {
    }

    public static void generateSingleReceipt(Receipt receipt, PaymentStrategy paymentMethod) {

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("Receipt" + receipt.getReceiptId() + ".pdf"));

            //formatting metdata?
            document.addTitle("Receipt: " + receipt.getReceiptId());

            document.open();

            String receiptId = Long.toString(receipt.getReceiptId());
            Font font = FontFactory.getFont(FontFactory.COURIER, 22, BaseColor.BLACK);
            Chunk chunk = new Chunk(receiptId, font);
            document.add(new Paragraph("Receipt Id: " + chunk));

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(105);
            table.setSpacingBefore(11f);
            table.setSpacingAfter(11f);

            float[] colWidth={2f,2f};
            table.setWidths(colWidth);
             table.addCell(new PdfPCell(new Paragraph("Item")));
             table.addCell(new PdfPCell(new Paragraph("Price")));



            //adding cart items table
            insertItems(receipt.getItemsList(), table);
            document.add(table);

            //adding total price
            document.add(new Paragraph("Total price is: " + totalPrice(receipt.getCartTotalPrice())));

            //number of items
            document.add(new Paragraph("Number Of Items: " + numberOfItems(receipt.getItemsList())));

            //TODO add customer details -> Like customer's first name ONLY


            //TODO add payment details -> e.g. Credit Card, credit card number: ******43
            document.add(new Paragraph(paymentMethod.getChunk()));

            //Adding Date
            document.add(new Paragraph("Date: " + ReceiptStringTransformer.getDateString(receipt)));

            document.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

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
