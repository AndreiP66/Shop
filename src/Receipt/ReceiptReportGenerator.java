package Receipt;

import CartItem.CartItem;
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

    public static void generateSingleReceipt(Receipt receipt) {

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Receipt.pdf"));

            document.open();

            String receiptId = Long.toString(receipt.getReceiptId());
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk(receiptId, font);
            document.add(chunk);

            PdfPTable table = new PdfPTable(2);

            insertItems(receipt.getItemsList());


            document.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

    public static void insertItems(List<CartItem> itemsList){
        for(CartItem item : itemsList){

            new PdfPCell(new Paragraph(item.getName()));
            new PdfPCell(new Paragraph(item.getStringPrice()));
        }
    }

}
