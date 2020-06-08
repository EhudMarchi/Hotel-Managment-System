package HotelManagmentModel;

import java.util.List;

public class Guest {
    private String guestName;
    private String phoneNumber;
    private String emailAddress;
    private List<Reservation> reservations;

    public Guest() {
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
    public void deleteReservation(Reservation reservation)
    {
        reservations.remove(reservation);
    }
    public void addReservation(Reservation reservation)
    {
        reservations.add(reservation);
    }
}
