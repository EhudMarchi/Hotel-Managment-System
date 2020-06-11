package Tests;

import HotelManagementUIview.PaymentScreen;
import HotelManagementUIview.ReservationCreationScreen;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentScreenTest {
    private static PaymentScreen screen=null;
    public PaymentScreenTest() throws ParseException {
        screen =new PaymentScreen();
    }
    @Test
    public void creditCardValidationTest(){
        assertEquals(true, screen.creditCardValidation("1234567896542522"));
        assertEquals(false, screen.creditCardValidation(""));
        assertEquals(false, screen.creditCardValidation("efDSAFSD"));
        assertEquals(false, screen.creditCardValidation("%2345&78965$2-22"));
        assertEquals(false, screen.creditCardValidation("1234"));
        assertEquals(false, screen.creditCardValidation("1234567896542522161612"));
    }
    @AfterEach
    void tearDown() {
//        System.out.println("Test passed");
    }
}