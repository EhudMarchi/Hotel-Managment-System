package HotelManagementController;

import HotelManagementUIview.AvailableRoomsScreen;
import HotelManagmentModel.Guest;
import HotelManagmentModel.Hotel;
import HotelManagmentModel.Reservation;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActManager {
    public static int calculatePriceOffer(LocalDate checkIn, LocalDate checkOut, JLabel roomsLabel) {
        int price=0;
        int days=checkOut.compareTo(checkIn);
        int years=checkOut.minusYears(checkIn.getYear()).getYear();
        int months=checkOut.getMonthValue()-checkIn.getMonthValue();
        days+=(months*30)+(years*365);
        if(days<=30) {
            char[] validation = roomsLabel.getText().toCharArray();
            for (int i = 0; i < validation.length - 4; i++) {
                if (Character.isDigit(validation[i])) {
                    int roomsAmount=0;
                    if (Character.isDigit(validation[i+1])) {
                        i++;
                        roomsAmount += Integer.parseInt(String.valueOf(validation[i-1]))*10;
                    }
                    roomsAmount+=Integer.parseInt(String.valueOf(validation[i]));
                    if (validation[i + 2] == 'T') {
                        price += (500 * roomsAmount);
                    } else if (validation[i + 2] == 'F') {
                        price += (600 * roomsAmount);
                    } else if (validation[i + 2] == 'D') {
                        price += (700 * roomsAmount);
                    } else if (validation[i + 2] == 'P') {
                        price += (850 * roomsAmount);
                    } else if (validation[i + 2] == 'S') {
                        price += (1000 * roomsAmount);
                    }
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Cannot order more than 30 straight days in our hotel",
                    "Notice", JOptionPane.WARNING_MESSAGE);
        }
        return price*days;
    }

    public static void changeReservation(String reservationNumber,String request) {
        try
        {
            File requestsFile = new File("../Requests");
            if (requestsFile.createNewFile())
            {
                System.out.println("File created: " + requestsFile.getName());
            }
            FileWriter myWriter = new FileWriter("../Requests");
            myWriter.write("Reservation Number: "+reservationNumber+" Change request: "+request);
            myWriter.close();
        }
        catch (Exception e)
        {
        e.printStackTrace();
        }
    }


//    public static int showAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
//        return 0;
//    }


    public static Reservation createReservation(int reservationNumber,String details,LocalDate checkIn,LocalDate checkOut,JLabel rooms) throws IOException {
        Reservation newRes=new Reservation();
        int[] orderedRooms={0,0,0,0,0};
        int[] available=new int[5];
        char[] availabilityChanger = rooms.getText().toCharArray();
        for (int i = 0; i < availabilityChanger.length - 4; i++) {
            if (Character.isDigit(availabilityChanger[i])) {
                int roomsAmount=0;
                if (Character.isDigit(availabilityChanger[i+1])) {
                    i++;
                    roomsAmount += Integer.parseInt(String.valueOf(availabilityChanger[i-1]))*10;
                }
                roomsAmount+=Integer.parseInt(String.valueOf(availabilityChanger[i]));
                if (availabilityChanger[i + 2] == 'T') {
                    orderedRooms[0] += roomsAmount;
                } else if (availabilityChanger[i + 2] == 'F') {
                    orderedRooms[1] += roomsAmount;
                } else if (availabilityChanger[i + 2] == 'D') {
                    orderedRooms[2] += roomsAmount;
                } else if (availabilityChanger[i + 2] == 'P') {
                    orderedRooms[3] += roomsAmount;
                } else if (availabilityChanger[i + 2] == 'S') {
                    orderedRooms[4] += roomsAmount;
                }
            }
        }
        for (LocalDate i = checkIn; i.equals(checkOut) || i.isBefore(checkOut); i=i.plusDays(1))
        {
            File dateFile = new File("src\\" + i.toString()+".txt");
            if (dateFile.createNewFile())
            {
                available= new int[]{Hotel.twinAmount - orderedRooms[0], Hotel.familyAmount - orderedRooms[1], Hotel.deluxeAmount - orderedRooms[2], Hotel.premiumAmount - orderedRooms[3], Hotel.suiteAmount - orderedRooms[4]};
                System.out.println("File created: " + dateFile.getName());
            }
            else
            {
                List<String> lines = new ArrayList<String>();
                lines = readLinesFromFile("src\\" + i.toString()+".txt");
                for (int j = 0; j < lines.size(); j ++)
                {
                    available[j]=Integer.parseInt(lines.get(j))-orderedRooms[j];
                }
            }
            File file =new File("src\\" + i.toString() + ".txt");
            file.delete();
            for(int j=0;j<available.length;j++) {
                FileWriter myWriter = new FileWriter("src\\" + i.toString() + ".txt", true);
                myWriter.write(available[j] + "\n");
                myWriter.close();
            }
        }
        FileWriter myWriter = new FileWriter("src\\ReservationsData",true);
        myWriter.write(reservationNumber+" "+details+"\n");
        myWriter.close();
        return newRes;
    }
    public static String createReservationLine(String gName,String gEmail,String gPhone,String gAmount,String gRooms,LocalDate checkIn,LocalDate checkOut,String receptionistName) {
        String details="";
        details="Guest Name: "+gName+"Guest Email: "+gEmail+" Guest Phone Number: "+gPhone+" Guests Amount: "+gAmount+" Guest Rooms: "+gRooms+" Check In Date: "+checkIn.toString()+" Check out Date: "+checkOut.toString()+" Receptionist Name: "+receptionistName;
        return details;
    }
    public static String createReservationDetails(String gName,String gEmail,String gPhone,String gAmount,String gRooms,LocalDate checkIn,LocalDate checkOut,String receptionistName) {
        String details="";
        details="<html>Guest Name: "+gName+"<br>Guest Email: "+gEmail+"<br>"+"Guest Phone Number: "+gPhone+"<br>Guests Amount: "+gAmount+"<br>Guest Rooms: "+gRooms+"<br>Check In Date: "+checkIn.getDayOfMonth()+"/"+checkIn.getMonthValue()+"/"+checkIn.getYear()+"<br>Check Out Date: "+checkOut.getDayOfMonth()+"/"+checkOut.getMonthValue()+"/"+checkOut.getYear()+"<br>Receptionist Name: "+receptionistName+"<html>";
        return details;
    }
    public static Guest getGuestInfo(String guestEmail) {
        return new Guest();
    }

    public static String login(String userName, String password, boolean asManager) throws IOException {
        List<String> lines = new ArrayList<String>();
        if (asManager) {
            lines = readLinesFromFile("src\\ManagerLoginData");
        } else {
            lines = readLinesFromFile("src\\ReceptionistLoginData");
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
    public static String[] ReadRequests(JComboBox requests) throws IOException {
        List<String> lines = new ArrayList<String>();
        lines = readLinesFromFile("src\\Requests");
        String [] requestsItems=new String[lines.size()];
        for (int i = 0; i < lines.size(); i ++)
        {
            requestsItems[i]=lines.get(i);
        }
        return requestsItems;
    }

    public static void AddCancelRequest(String reservationNumber,String cancelReason) throws IOException {
        FileWriter myWriter = new FileWriter("src\\Requests",true);
        myWriter.write("\n"+ reservationNumber+"- Cancel Reason: "+cancelReason);
        myWriter.close();
    }
    public static void AddChangeRequest(String reservationNumber,String change,String cancelReason) throws IOException {
        FileWriter myWriter = new FileWriter("src\\Requests",true);
        myWriter.write("\n"+ reservationNumber+"- Change wanted:" + change+", Change Reason: "+cancelReason);
        myWriter.close();
    }
    public static String[] ReadReservationsNumber(JComboBox reservations) throws IOException {
        List<String> lines = new ArrayList<String>();
        lines = readLinesFromFile("src\\ReservationsData");
        String [] reservationsNumbers=new String[lines.size()];
        String added="";
        for (int i = 0; i < lines.size(); i ++)
        {
            String sub = lines.get(i);
            for(int j=0;sub.charAt(j)!=' ';j++)
            {
                    added +=sub.charAt(j);
            }
                reservationsNumbers[i]=added;
            added="";
        }
        return reservationsNumbers;
    }
public static void ChangeLastResNumber(int lastRes) throws IOException {
    List<String> lines = new ArrayList<String>();
    lines = readLinesFromFile("src\\HotelData");
    File file =new File("src\\HotelData");
    file.delete();
    FileWriter myWriter = new FileWriter("src\\HotelData",true);
    for(int i=0;i<lines.size()-1;i++)
    {
        myWriter.write(lines.get(i)+"\n");
    }
    myWriter.write(Integer.toString(lastRes));
    myWriter.close();
}
public static void RefreshDate(LocalDate date, JSpinner Day,JSpinner Month,JSpinner Year)
{
    Day.setValue(date.getDayOfMonth());
    Month.setValue(date.getMonthValue());
    Year.setValue(date.getYear());
}
    public static boolean specialAct() {
        return false;
    }

    public static Reservation getReservationInfo(String reservationNumber) throws IOException {
        return new Reservation();
    }
    public static boolean CreditCardValidation(String cardNumber) {
        boolean isValid=true;
        if(cardNumber.length()!=16)
        {
            isValid = false;
        }
        return isValid;
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
            File dateFile = new File("src\\" + i.toString()+".txt");
            if (dateFile.exists()) {
                lines = readLinesFromFile("src\\" + i.toString()+".txt");
                for (int j = 0; j < lines.size(); j++) {
                    minimuns[j] = GetMin(minimuns[j], Integer.parseInt(lines.get(j)));
                }
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

