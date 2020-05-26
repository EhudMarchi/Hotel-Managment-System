package HotelManagementController;

import HotelManagmentModel.Guest;
import HotelManagmentModel.Hotel;
import HotelManagmentModel.Reservation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActManager {
    public static int calculatePriceOffer(LocalDate checkIn, LocalDate checkOut, int roomsNumber, int guestAmount) {
        return 0;
    }

    public static void changeReservation(String reservationNumber) {

    }

    public static void cancelReservation(String reservationNumber) {

    }

    public static int showAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        return 0;
    }

    public static Reservation createReservation(String receptionistName) {
        return new Reservation();
    }

    public static Guest getGuestInfo(String guestEmail) {
        return new Guest();
    }

    public static String login(String userName, String password, boolean asManager) throws IOException {
        List<String> lines = new ArrayList<String>();
        if (asManager) {
            lines = readLinesFromFile("C:\\Users\\march\\Desktop\\Computer Science\\הנדסת תוכנה (java)\\Hotel Manager\\src\\ManagerLoginData");
        } else {
            lines = readLinesFromFile("C:\\Users\\march\\Desktop\\Computer Science\\הנדסת תוכנה (java)\\Hotel Manager\\src\\ReceptionistLoginData");
        }
        for (int i = 0; i < lines.size(); i += 3) {
            if (userName.equals((lines.get(i)))) {
                if (password.equals((lines.get(i + 1)))) {
                    return (lines.get(i + 2).toString());
                }
            }
        }
        return "Not Valid";
    }

    public static void logout(String userName, String password) {

    }

    public static boolean specialAct() {
        return false;
    }

    public static Reservation getReservationInfo(String reservationNumber) {
        return new Reservation();
    }

    public static List<String> readLinesFromFile(String fileName) {
        List<String> lines = new ArrayList<String>();
        try {
            File file = new File(fileName);
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                lines.add(s.nextLine());
            }
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<String> ShowAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        List<String> lines = new ArrayList<String>();
        int[] minimuns = {Hotel.twinAmount, Hotel.familyAmount, Hotel.deluxeAmount, Hotel.premiumAmount, Hotel.suiteAmount};
        for (LocalDate i = checkIn; i.equals(checkOut) || i.isBefore(checkOut); i=i.plusDays(1))
        {
            File dateFile = new File("C:\\Users\\march\\Desktop\\Computer Science\\הנדסת תוכנה (java)\\Hotel Manager\\src\\" + i.toString());
            if (dateFile.exists()) {
                lines = readLinesFromFile("C:\\Users\\march\\Desktop\\Computer Science\\הנדסת תוכנה (java)\\Hotel Manager\\src\\" + i.toString());
                for (int j = 0; j < lines.size(); j++) {
                    minimuns[j] = GetMin(minimuns[j], Integer.parseInt(lines.get(j)));
                }
                ;
            }
        }
        lines.clear();
        for (int j = 0; j < 5; j++) {
            lines.add(j, String.valueOf(minimuns[j]));
        }
        ;

        return lines;
    }

    private static int GetMin(int left, int right) {
        if (left > right) {
            left = right;
        }
        return left;
    }
}


