package HotelManagmentModel;

public class Receptionist {
    protected  String receptionistName;
    protected  String userName;
    protected  String password;

    public Receptionist() {
    }
    public Receptionist(String receptionistName,String userName,String password) {
        this.receptionistName= receptionistName;
        this.userName=userName;
        this.password=password;
    }
    public String getReceptionistName() {
        return receptionistName;
    }
}