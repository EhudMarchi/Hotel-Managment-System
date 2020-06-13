package HotelManagmentModel;

public class Manager extends Receptionist {
    public Manager(String name, String userName, String password) {
        super(name,userName,password);
    }

    private boolean approveSpecialAct()
    {
        return false;
    }
}
