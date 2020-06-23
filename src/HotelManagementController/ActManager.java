package HotelManagementController;

import HotelManagementUIview.LoginScreen;
import HotelManagmentModel.*;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ActManager {
    public static JFrame baseScreen = new JFrame();
    public static JFrame actionScreen;
    public static JFrame roomsScreen;
    public static JFrame paymentScreen;
    private static Hotel myHotel;
    public static void runHotelManagementSystem() throws IOException {
        myHotel=new Hotel();
        baseScreen = new LoginScreen();
        baseScreen.setVisible(true);
    }
    public static int calculatePriceOffer(LocalDate checkIn, LocalDate checkOut, JLabel roomsLabel) {
        int price=0;
        int days=0;
        if(checkIn.getYear()==checkOut.getYear()) {
            days = checkOut.getDayOfYear() - checkIn.getDayOfYear();
        }
        else
        {
            days= checkOut.getDayOfYear()+365*(checkOut.getYear()- checkIn.getYear())- checkIn.getDayOfYear();;
        }
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
        return price*days;
    }
    public static int getCapacity(LocalDate date) throws IOException {
        List<String> lines = new ArrayList<String>();
        int capacity=0;
        File dateFile = new File("src\\" + date.toString()+".txt");
        if (!dateFile.exists())
        {
        }
        else {
            lines = readLinesFromFile("src\\" + date.toString() + ".txt");
            for (int i = 0; i < lines.size(); i++) {
                capacity += Integer.parseInt(lines.get(i));
            }
            capacity=100-(int)((double)capacity/myHotel.getRoomsAmount()*100);
        }
        return capacity;
    }
    public static void deleteOldAvailabilityFiles(LocalDate date) {
        if (date.isBefore(LocalDate.now())) {
            for (LocalDate i = date;i.isAfter(date.minusMonths(2)); i = i.minusDays(1)) {
                File dateFile = new File("src\\" + i.toString() + ".txt");
                if (dateFile.exists()) {
                    dateFile.delete();
                }
            }
        }
    }
    public static int countOccurences(String someString, char searchedChar) {
        int count=0;
        for(int i=0;i<someString.length();i++)
        {
         if(someString.charAt(i)==searchedChar)
            {
             count++;
            }
        }
        return count;
    }
    public static Reservation createReservation(int reservationNumber,String details,LocalDate checkIn,LocalDate checkOut,JLabel rooms) throws IOException {
        Guest currentGuest= new Guest();
        checkIn.plusYears(2000);
        checkOut.plusYears(2000);
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
//        details=" Guest Name: "+gName+"Guest Email: "+gEmail+" Guest Phone Number: "+gPhone+" Guests Amount: "+gAmount+" Guest Rooms: "+gRooms+" Check In Date: "+checkIn.toString()+" Check out Date: "+checkOut.toString()+" Receptionist Name: "+receptionistName;
        details="<br> Guest Name: "+gName+"<br>Guest Email: "+gEmail+"<br>"+"Guest Phone Number: "+gPhone+"<br>Guests Amount: "+gAmount+"<br>Guest Rooms: "+gRooms+"<br>Check In Date: "+checkIn.getDayOfMonth()+"/"+checkIn.getMonthValue()+"/"+checkIn.getYear()+"<br>Check Out Date: "+checkOut.getDayOfMonth()+"/"+checkOut.getMonthValue()+"/"+checkOut.getYear()+"<br>Receptionist Name: "+receptionistName+"<html>";
        return details;
    }
    public static String createReservationDetails(String gName,String gEmail,String gPhone,String gAmount,String gRooms,LocalDate checkIn,LocalDate checkOut,String receptionistName) {
        String details="";
        details="<html>Guest Name: "+gName+"<br>Guest Email: "+gEmail+"<br>"+"Guest Phone Number: "+gPhone+"<br>Guests Amount: "+gAmount+"<br>Guest Rooms: "+gRooms+"<br>Check In Date: "+checkIn.getDayOfMonth()+"/"+checkIn.getMonthValue()+"/"+checkIn.getYear()+"<br>Check Out Date: "+checkOut.getDayOfMonth()+"/"+checkOut.getMonthValue()+"/"+checkOut.getYear()+"<br>Receptionist Name: "+receptionistName+"<html>";
        return details;
    }
    public static String[] getUsers(boolean asManager)
    {
        List<String> lines = new ArrayList<String>();
        if (asManager) {
        lines = readLinesFromFile("src\\ManagerLoginData");
    } else {
        lines = readLinesFromFile("src\\ReceptionistLoginData");
    }
         String[] users = new String[lines.size()/3];
         for (int i = 0,j=0; i < lines.size(); i += 3,j++) {
        users[j]=lines.get(i+2)+" User Name:"+lines.get(i)+" Password:"+lines.get(i+1);
    }
         return users;
    }
    public static boolean isUserExist(String userName,boolean asManager)
    {
        boolean isExists=false;
        List<String> lines = new ArrayList<String>();
        if (asManager) {
            lines = readLinesFromFile("src\\ManagerLoginData");
        } else {
            lines = readLinesFromFile("src\\ReceptionistLoginData");
        }
        for (int i = 0; i < lines.size(); i += 3)
        {
            if(lines.get(i).equals(userName))
                isExists=true;
        }

        return isExists;
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
    public static List<Receptionist> readReceptionists() throws IOException {
        List<String> lines = new ArrayList<String>();
        List<Receptionist> receptionists = new ArrayList<Receptionist>();
        lines = readLinesFromFile("src\\ReceptionistLoginData");
        String name="",userName="",password="";
        for (int i = 0; i < lines.size()-3; i += 3)
        {
            userName = lines.get(i);
            password = lines.get(i+1);
            name = lines.get(i + 2);
            receptionists.add(new Receptionist(name,userName,password));
            System.out.println("Receptionist: "+name);
        }

        return receptionists;
    }
    public static List<Manager> readManagers() throws IOException {
        List<String> lines = new ArrayList<String>();
        List<Manager> receptionists = new ArrayList<Manager>();
        lines = readLinesFromFile("src\\ManagerLoginData");
        String name="",userName="",password="";
        for (int i = 0; i < lines.size(); i += 3)
        {
            userName = lines.get(i);
            password = lines.get(i+1);
            name = lines.get(i + 2);
            receptionists.add(new Manager(name,userName,password));
            System.out.println("Manager: "+name);
        }

        return receptionists;
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
    public static void addNewEmployee(boolean isManager,String name,String userName,String password) throws IOException {
        List<String> lines = new ArrayList<String>();
        String pathName="src\\ReceptionistLoginData";
        lines.add(userName);
        lines.add(password);
        lines.add(name);
        if(isManager)
            pathName="src\\ManagerLoginData";
        FileWriter myWriter = new FileWriter(pathName,true);
        for (int i = 0; i < lines.size(); i ++)
        {
            myWriter.write(lines.get(i)+"\n");
        }
        myWriter.close();
    }
    public static void addNews(String newsLine) throws IOException {
        String pathName="src\\News";
        FileWriter myWriter = new FileWriter(pathName,true);
        myWriter.write(newsLine+" <br><br>\n");
        myWriter.close();
    }
    public static String readReservationLineFromFile(String reservationNumber, String pathName) throws IOException {
        List<String> lines = new ArrayList<String>();
        String details="";
        lines = readLinesFromFile(pathName);
        for (int i = 0; i < lines.size(); i ++) {
            if (lines.get(i).startsWith(reservationNumber)) {
                details += lines.get(i);
            }
        }

        return details;
    }
    public static void deleteLineFromFile(String reservationNumber, String pathName) throws IOException {
        List<String> lines = new ArrayList<String>();
        lines = readLinesFromFile(pathName);
        File file =new File(pathName);
        file.delete();
        FileWriter myWriter = new FileWriter(pathName,true);
        for (int i = 0; i < lines.size(); i ++)
        {
            if(lines.get(i).startsWith(reservationNumber))
            {
                lines.remove(i);
                i--;
            }
            else
            {
                myWriter.write(lines.get(i)+"\n");
            }
        }
        myWriter.close();
    }
    public static void deleteLastNews() throws IOException {
        List<String> lines = new ArrayList<String>();
        lines = readLinesFromFile("src\\News");
        File file =new File("src\\News");
        file.delete();
        FileWriter myWriter = new FileWriter("src\\News",true);
        for (int i = 1; i < lines.size(); i ++)
        {
                myWriter.write(lines.get(i)+"\n");
        }
        myWriter.close();
    }
    public static String getUserNameSubString(String userString)
    {
        char[] validation=userString.toCharArray();
        String userName="";
        for(int i=0;i<userString.length();i++)
        {
            if(validation[i]==':')
            {
                for(int j=i+1;j<userString.length();j++) {
                    if (validation[j] != ' ')
                        userName += validation[j];
                    else
                        return userName;
                }
            }
        }
        return userName;
        }
    public static String getReservationNumberSubString(String userString)
    {
        char[] validation=userString.toCharArray();
        String reservationNumber="";
        for(int i=0;i<userString.length();i++)
        {
            if (validation[i] != '-')
            {
                reservationNumber += validation[i];
            }
            else
            {
                return reservationNumber;
            }
        }
        return reservationNumber;
    }
    public static void deleteUserFromFile(String username, boolean isManager) throws IOException {
        List<String> lines = new ArrayList<String>();
        String pathName = "src\\ReceptionistLoginData" ;
        if (isManager)
            pathName = "src\\ManagerLoginData" ;
        lines = readLinesFromFile(pathName);
        File file = new File(pathName);
        file.delete();
        FileWriter myWriter = new FileWriter(pathName, true);
        for (int i = 0; i < lines.size(); i++)
        {
            if (!lines.get(i).startsWith(username))
                {
                    myWriter.write(lines.get(i) + "\n");
                }
                else
                {
                    i+=2;
                }
        }
        myWriter.close();
    }
    public static void deleteReservationFromFile(String reservationNumber) throws IOException {
        List<String> lines = new ArrayList<String>();
        String pathName = "src\\ReservationsData" ;
        lines = readLinesFromFile(pathName);
        File file = new File(pathName);
        file.delete();
        FileWriter myWriter = new FileWriter(pathName, true);
        for (int i = 0; i < lines.size(); i++)
        {
            if (!lines.get(i).startsWith(reservationNumber))
            {
                myWriter.write(lines.get(i) + "\n");
            }
        }
        myWriter.close();
    }
    public static void changeRoomsAmount(String roomType, int amount) throws IOException {
    List<String> lines = new ArrayList<String>();
    String pathName="src\\HotelData";
    lines=readLinesFromFile(pathName);
    File file =new File(pathName);
    file.delete();
int value=0;
    if(roomType=="Twin")
    {
        value=Integer.parseInt(lines.get(0));
        value+=amount;
        lines.set(0,String.valueOf(value));
    }
    if(roomType=="Family")
    {
        value=Integer.parseInt(lines.get(1));
        value+=amount;
        lines.set(1,String.valueOf(value));
    }
    if(roomType=="Deluxe")
    {
        value=Integer.parseInt(lines.get(2));
        value+=amount;
        lines.set(2,String.valueOf(value));
    }
    if(roomType=="Premium")
    {
        value=Integer.parseInt(lines.get(3));
        value+=amount;
        lines.set(3,String.valueOf(value));
    }
    if(roomType=="Suite")
    {
        value=Integer.parseInt(lines.get(4));
        value+=amount;
        lines.set(4,String.valueOf(value));
    }
    FileWriter myWriter = new FileWriter(pathName,true);
    for (int i = 0; i < lines.size(); i ++)
    {
        myWriter.write(lines.get(i)+"\n");
    }
    myWriter.close();

}
    public static void addCancelRequest(String reservationNumber, String cancelReason) throws IOException {
        FileWriter myWriter = new FileWriter("src\\Requests",true);
        myWriter.write(reservationNumber+"- Cancel Reason: "+cancelReason+"\n");
        myWriter.close();
    }
    public static void addChangeRequest(String reservationNumber, String change, String cancelReason) throws IOException {
        FileWriter myWriter = new FileWriter("src\\Requests",true);
        myWriter.write(reservationNumber+"- Change wanted:" + change+", Change Reason: "+cancelReason+"\n");
        myWriter.close();
    }
    public static String[] readReservationsNumber(JComboBox reservations) throws IOException {
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
    public static void changeLastResNumber(int lastRes) throws IOException {
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
    public static void refreshDate(LocalDate date, JSpinner Day, JSpinner Month, JSpinner Year)
{
    Day.setValue(date.getDayOfMonth());
    Month.setValue(date.getMonthValue());
    Year.setValue(date.getYear());
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

    public static List<String> showAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        List<String> lines = new ArrayList<String>();
        int[] minimuns = {Hotel.twinAmount, Hotel.familyAmount, Hotel.deluxeAmount, Hotel.premiumAmount, Hotel.suiteAmount};
        for (LocalDate i = checkIn; i.equals(checkOut) || i.isBefore(checkOut); i=i.plusDays(1))
        {
            File dateFile = new File("src\\" + i.toString()+".txt");
            if (dateFile.exists()) {
                lines = readLinesFromFile("src\\" + i.toString()+".txt");
                for (int j = 0; j < lines.size(); j++) {
                    minimuns[j] = getMin(minimuns[j], Integer.parseInt(lines.get(j)));
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

    private static int getMin(int left, int right) {
        if (left > right) {
            left = right;
        }
        return left;
    }
}

