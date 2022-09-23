import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ShoppingCartTest1 {
    @Test
    void testComputeTotalPrice_ShouldReturnCorrectPrice()throws InvalidPriceException{
        //given
        Product product1 = new Product("lapte",10);
        Product product2 = new Product("oua",20);
        Product product3 = new Product("miere",35);
        Product[] product = new Product[]{product1,product2,product3};
        ShoppingCart shoppingCart = new ShoppingCart(product);
        //when
        int result = shoppingCart.computeTotalPrice();
        //then
        assertEquals(65,result);
    }
    @Test
    void testComputeTotalPrice_ShouldThrowException(){
        //given
        Product product1 = new Product("lapte",-12);
        Product product2 = new Product("oua",20);
        Product product3 = new Product("miere",35);
        Product[] product = new Product[]{product1,product2,product3};
        ShoppingCart shoppingCart = new ShoppingCart(product);
        //when
        try{
            shoppingCart.computeTotalPrice();
            fail("Exception not throw");
        }
        catch (InvalidPriceException e){
            assertEquals("Price is negative",e.getMessage());
        }
        //then
    }

}
