import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserTest {
    User user;
    @Mock
    ShoppingCart shoppingCart;

    public UserTest() {
        System.out.println("Apelul constructorului");
    }

    @BeforeEach
    void createUser() {
        System.out.println("inaintea fiecarei metode");
//        Product product1 = new Product("lapte", 10);
//        Product product2 = new Product("paine", 7);
//        Product[] products = new Product[]{product1, product2};
//        ShoppingCart shoppingCart = new ShoppingCart(products);
        user = new User("Alin", "asdfghitgk", shoppingCart);
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("inainte de toate metodele");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("dupa toate metodele");
    }

    @AfterEach
    void afterEach() {
        System.out.println("dupa fiecare metoda");
    }

    @Test
    void testUserPassword_ShouldBeStrong() {
        System.out.println("test1");
        //given
        //when
        boolean result = user.hasStrongPassword();
        //then
        assertTrue(result);
    }

    @Test
    void testUserName_ShouldBeValid() {
        System.out.println("test2");
        //given
        //when
        boolean result = user.hasValidUserName();
        //then
        assertTrue(result);
    }

    @Test
    void testUser_ShouldBeValid() {
        System.out.println("test3");
        //given
        //when
        boolean result = user.isValid();
        //then
        assertTrue(result);
    }


    @Test
    void testGenerateInvoice_ShouldReturnInvoiceTest() throws InvalidPriceException {
        when(shoppingCart.computeTotalPrice()).thenReturn(50);
        String result = user.generateInvoice();
        assertEquals("Alin has paid 50",result);
    }

    @Test
    void testGenerateInvoice_ShouldReturnInvoiceText() throws InvalidPriceException {
        when(shoppingCart.computeTotalPrice()).thenThrow(new InvalidPriceException("price is negative"));
        try {
           user.generateInvoice();
            fail("Exception is not thrown");
        } catch (InvalidPriceException e) {
            assertEquals("price is negative", e.getMessage());
        }


    }

}
