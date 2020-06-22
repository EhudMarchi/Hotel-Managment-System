package HotelManagmentModel;

import java.util.ArrayList;
import java.util.List;

public class Receptionist {
    protected  String receptionistName;
    protected  String userName;
    protected  String password;
    protected List<String> requests;

    public Receptionist() {
    }
    public Receptionist(String receptionistName,String userName,String password) {
        this.receptionistName= receptionistName;
        this.userName=userName;
        this.password=password;
        requests= new ArrayList<>() ;
    }
    public String getReceptionistName() {
        return receptionistName;
    }
}