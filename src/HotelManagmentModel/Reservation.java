package HotelManagmentModel;

import java.time.LocalDate;

public class Reservation {
    private Guest guest;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int roomsNumber;
    private int guestAmount;
    private int creditCardNumber;
    private String reservationNumber;
    private int price;
    private  String receptionistName;

    public Reservation() {

    }
    public Reservation(Guest guest,LocalDate checkInDate,LocalDate checkOutDate , int roomsNumber, int guestAmount, int creditCardNumber,String receptionistName)
    {
        this.guest=guest;
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;
        this.roomsNumber=roomsNumber;
        this.guestAmount=guestAmount;
        this.creditCardNumber=creditCardNumber;
        this.receptionistName=receptionistName;
    }
    public Guest getGuest() {
        return guest;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public int getGuestAmount() {
        return guestAmount;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public int getPrice() {
        return price;
    }

    public String getReceptionistName() {
        return receptionistName;
    }
}
