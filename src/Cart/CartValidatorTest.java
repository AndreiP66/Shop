package Cart;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartValidatorTest {


    @Test
    public void check_date(){

        CartValidator cart = new CartValidator();

        cart.check_date("04/06/2019");
    }
}