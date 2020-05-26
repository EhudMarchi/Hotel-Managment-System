package HotelManagementController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import HotelManagmentModel.Guest;
import HotelManagmentModel.Receptionist;
import HotelManagmentModel.Reservation;
import java.nio.charset.*;
import java.util.Scanner;

import java.util.*;

import java.time.LocalDate;

import static java.nio.file.Files.*;

public class ActManager {
    public static int calculatePriceOffer(LocalDate checkIn,LocalDate checkOut, int roomsNumber, int guestAmount)
    {
return 0;
    }

    public static void changeReservation(String reservationNumber)
    {

    }

    public static void cancelReservation(String reservationNumber)
    {

    }

    public static int showAvailableRooms(LocalDate checkIn,LocalDate checkOut)
    {
return 0;
    }

    public static Reservation createReservation(String receptionistName)
    {
        return new Reservation();
    }

    public static Guest getGuestInfo(String guestEmail)
    {
return new Guest();
    }

    public static String login(String userName, String password,boolean asManager) throws IOException {
        List <String> lines=new ArrayList<String>() ;
        if (asManager)
            {
                lines = readLinesFromFile("C:\\Users\\march\\Desktop\\Computer Science\\הנדסת תוכנה (java)\\Hotel Manager\\src\\ManagerLoginData");
            }
        else
            {
                    lines = readLinesFromFile("C:\\Users\\march\\Desktop\\Computer Science\\הנדסת תוכנה (java)\\Hotel Manager\\src\\ReceptionistLoginData");
            }
        for(int i=0;i< lines.size();i+=3)
        {
            if(userName.equals((lines.get(i))))
            {
              if(password.equals((lines.get(i+1))))
              {
                  return (lines.get(i + 2).toString());
              }
            }
        }
        return "Not Valid";
    }
    public static void logout(String userName, String password)
    {

    }

    public static boolean specialAct()
    {
        return false;
    }

    public static  Reservation getReservationInfo(String reservationNumber)
    {
return new Reservation();
    }
    public static List<String> readLinesFromFile(String fileName)
    {
        List<String> lines=new ArrayList<String>();
        try {
            File file = new File(fileName);
            Scanner s= new Scanner(file);
            while(s.hasNext())
            {
                lines.add(s.nextLine());
            }
            s.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
}
