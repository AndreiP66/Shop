package Receipt;

import PaymentStrategy.PaymentStrategy;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReceiptStringTransformer {

    public static final Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

    public static Chunk getDateString(Receipt receipt){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = receipt.getCartDate().format(formatter);
        Chunk chunk = new Chunk(date,font);

        return chunk;
    }

//    public static Chunk paymentString(PaymentStrategy payment){
//
//    }
}
