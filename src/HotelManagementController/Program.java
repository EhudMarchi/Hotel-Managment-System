package HotelManagementController;

import HotelManagementUIview.LoginScreen;
import HotelManagementUIview.MainScreen;
import HotelManagementUIview.ReservationCreationScreen;
import HotelManagmentModel.Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class Program {
    public static JFrame baseScreen = new JFrame();
    public static JFrame actionScreen;
    public static JFrame roomsScreen;
    public static JFrame paymentScreen;
    public static void main(String [] args) throws ParseException {
        Hotel myHotel=new Hotel();
        baseScreen = new LoginScreen();
        baseScreen.setVisible(true);
    }
}
