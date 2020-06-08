package HotelManagmentModel;

public class Receptionist {
    protected  String receptionistName;
    /*protected  String userName;
    protected  String password;*/

    public Receptionist() {
    }
    public Receptionist(String i_receptionistName) {
        receptionistName= i_receptionistName;
    }
    public String getReceptionistName() {
        return receptionistName;
    }
}