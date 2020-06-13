package Tests;

import HotelManagementUIview.ReservationCreationScreen;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationCreationScreenTest {
    private static ReservationCreationScreen screen=null;

    public ReservationCreationScreenTest() throws ParseException {
        screen =new ReservationCreationScreen("Tester");
    }

    @Test
    public void nameValidationTest() throws ParseException {
        assertEquals("Your name is not valid, please enter only letters",screen.nameValidation(""));
        assertEquals("",screen.nameValidation("Yossi"));
        assertEquals("",screen.nameValidation("יוסי"));
        assertEquals("Your name is not valid, please enter only letters",screen.nameValidation(". 55o@#%!"));
        assertEquals("Your name is not valid, please enter only letters",screen.nameValidation("51513"));
    }
    @Test
    public void phoneValidationTest(){
        assertEquals(true,screen.phoneValidation("052-2665731"));
        assertEquals(false,screen.phoneValidation("05-62665731"));
        assertEquals(false,screen.phoneValidation("3**%^-*#6^$1"));
        assertEquals(false,screen.phoneValidation(""));
        assertEquals(false,screen.phoneValidation("ase-fafnir"));
        assertEquals(false,screen.phoneValidation("11111111111"));
        assertEquals(false,screen.phoneValidation("0523"));
    }
    @Test
    public void emailValidationTest() {
        assertEquals(true,screen.emailValidation("example@example.com"));
        assertEquals(false,screen.emailValidation("235235@32532532"));
        assertEquals(false,screen.emailValidation("@rorokds.com"));
        assertEquals(false,screen.emailValidation("@"));
        assertEquals(false,screen.emailValidation("."));
        assertEquals(false,screen.emailValidation(""));
        assertEquals(false,screen.emailValidation("orokds.com@"));
        assertEquals(false,screen.emailValidation("215351351"));
        assertEquals(false,screen.emailValidation("letters"));
        assertEquals(false,screen.emailValidation(".yosi@gmail.com"));
        assertEquals(false,screen.emailValidation("yosi@gmail."));
    }
    @AfterEach
    void tearDown() {
//        System.out.println("Test passed");
    }
}