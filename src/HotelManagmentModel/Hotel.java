package HotelManagmentModel;

import HotelManagementController.ActManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    public static  int twinAmount ;//1-40
    public static  int familyAmount;//101-140
    public static  int deluxeAmount;//201-222
    public static  int premiumAmount;//301-315
    public static  int suiteAmount;//401-410
    public int capacity=0;
    public static List<Receptionist> receptionistsList;
    public static List<Manager> managersList;
    public Hotel() throws IOException {
        List<String> lines = new ArrayList<String>();
        lines = ActManager.readLinesFromFile("src\\HotelData");
        twinAmount=Integer.parseInt(lines.get(0));
        familyAmount=Integer.parseInt(lines.get(1));
        deluxeAmount=Integer.parseInt(lines.get(2));
        premiumAmount=Integer.parseInt(lines.get(3));
        suiteAmount=Integer.parseInt(lines.get(4));
        numOfReservations=Integer.parseInt(lines.get(5));
        receptionistsList=ActManager.readReceptionists();
        managersList=ActManager.readManagers();
    }

    public static int getNumOfReservations() {
        return numOfReservations;
    }
    public int getRoomsAmount()
    {
        return twinAmount+familyAmount+deluxeAmount+premiumAmount+suiteAmount;
    }
    public static int numOfReservations;
}
