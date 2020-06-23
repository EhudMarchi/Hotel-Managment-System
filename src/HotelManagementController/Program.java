package HotelManagementController;

import HotelManagementUIview.LoginScreen;
import HotelManagementUIview.MainScreen;
import HotelManagementUIview.ReservationCreationScreen;
import HotelManagmentModel.Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

public class Program {

    public static void main(String [] args) throws ParseException, IOException {
        ActManager.runHotelManagementSystem();
    }
}
