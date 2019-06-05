package PaymentStrategy;

import com.itextpdf.text.Chunk;

public interface PaymentStrategy {

    public void pay(double amount);

    public Chunk getChunk();



}
