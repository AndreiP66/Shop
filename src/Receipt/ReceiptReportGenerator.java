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
            PdfWriter.getInstance(document, new FileOutputStream("Receipt" + receipt.getReceiptId() + ".pdf"));

            //formatting metdata?
            document.addTitle("Receipt: " + receipt.getReceiptId());

            document.open();

            String receiptId = Long.toString(receipt.getReceiptId());
            Font font = FontFactory.getFont(FontFactory.COURIER, 20, BaseColor.BLACK);
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

            for(CartItem item : receipt.getItemsList()){

                table.addCell(new PdfPCell(new Paragraph(item.getName())));
                table.addCell(new PdfPCell(new Paragraph(item.getStringPrice())));
            }
            document.add(table);

           // insertItems(receipt.getItemsList());


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
