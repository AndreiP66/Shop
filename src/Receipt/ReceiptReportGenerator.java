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
          ReceiptStringTransformer.insertItems(receipt.getItemsList(), table);
            document.add(table);

            //adding total price
            document.add(new Paragraph("Total price is: " + ReceiptStringTransformer.totalPrice(receipt.getCartTotalPrice())));

            //number of items
            document.add(new Paragraph("Number Of Items: " + ReceiptStringTransformer.numberOfItems(receipt.getItemsList())));

            //TODO add customer details -> Like customer's first name ONLY


            //payment Details
            document.add(new Paragraph(paymentMethod.getChunk()));

            //Adding Date
            document.add(new Paragraph("Date: " + ReceiptStringTransformer.getDateString(receipt)));

            document.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }



}
