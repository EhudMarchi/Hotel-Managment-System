package HotelManagmentModel;

public class Room {
    private int number;
    private RoomType roomType;
    private int capacity=2;
    enum RoomType
    {
        Twin,
        Family,
        Deluxe,
        Premium,
        Suite
    }
}
