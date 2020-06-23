
package HotelManagementUIview;

import HotelManagementController.ActManager;
import HotelManagementController.Program;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.text.MaskFormatter;


/**
 * @author Ehud
 */
public class ReservationCreationScreen extends JFrame {


    public ReservationCreationScreen(String name) throws ParseException {
        initComponents();
        recepName=name;
        ActManager.refreshDate(checkIn,checkInDaySpinner,checkInMonthSpinner,checkInYearSpinner);
        ActManager.refreshDate(checkIn.plusDays(1),checkOutDaySpinner,checkOutMonthSpinner,checkOutYearSpinner);
    }
    private void CheckInChange() {

        checkIn=LocalDate.of((Integer) checkInYearSpinner.getValue(),(Integer)checkInMonthSpinner.getValue(),(Integer) checkInDaySpinner.getValue());
        checkOut= LocalDate.of(Integer.parseInt(checkOutYearSpinner.getValue().toString()), (Integer) checkOutMonthSpinner.getValue(),(Integer) checkOutDaySpinner.getValue());
        if(DateValidation(checkIn,checkOut))
        {
            if(checkIn.isBefore(checkOut))
        {
            priceLabel.setText("Price: "+ActManager.calculatePriceOffer(checkIn,checkOut,roomsLabel)+"₪");
        }
        else
        {
            checkOut=checkIn.plusDays(1);
        }
            ActManager.refreshDate(checkIn,checkInDaySpinner,checkInMonthSpinner,checkInYearSpinner);
            ActManager.refreshDate(checkOut,checkOutDaySpinner,checkOutMonthSpinner,checkOutYearSpinner);
    }
    }
    private void CheckOutChange() {

            checkIn = LocalDate.of((Integer) checkInYearSpinner.getValue(), (Integer) checkInMonthSpinner.getValue(), (Integer) checkInDaySpinner.getValue());
            checkOut = LocalDate.of(Integer.parseInt(checkOutYearSpinner.getValue().toString()), (Integer) checkOutMonthSpinner.getValue(), (Integer) checkOutDaySpinner.getValue());
        if(DateValidation(checkIn,checkOut)) {
            if (checkIn.isBefore(checkOut)) {
                priceLabel.setText("Price: " + ActManager.calculatePriceOffer(checkIn, checkOut, roomsLabel) + "₪");
            }
            else
            {
                checkOut=checkIn.plusDays(1);
            }
            ActManager.refreshDate(checkIn,checkInDaySpinner,checkInMonthSpinner,checkInYearSpinner);
            ActManager.refreshDate(checkOut,checkOutDaySpinner,checkOutMonthSpinner,checkOutYearSpinner);
        }

    }
    private void roomsLabelPropertyChange() {
        LocalDate checkOut= LocalDate.of(Integer.parseInt(checkOutYearSpinner.getValue().toString()), (Integer) checkOutMonthSpinner.getValue(),(Integer) checkOutDaySpinner.getValue());
        LocalDate checkIn=LocalDate.of((Integer) checkInYearSpinner.getValue(),(Integer)checkInMonthSpinner.getValue(),(Integer) checkInDaySpinner.getValue());
        if (roomsLabel.getText() != "Rooms Number:") {
            continueToPaymentButton.setEnabled(true);
            priceLabel.setText("Price: "+ActManager.calculatePriceOffer(checkIn,checkOut,roomsLabel)+"₪");
        }
    }
    protected boolean DateValidation(LocalDate checkin,LocalDate checkout)
    {
        if(checkin.isEqual(checkout)||checkin.isAfter(checkout)||checkin.isBefore(LocalDate.now()))
        {
            return false;
        }
        return true;
    }
    public String nameValidation(String Name)
    {
        char[] validation=Name.toCharArray();
        boolean error=false;
        String errorText="";
        if(Name.length()==0)
        {
            error=true;
        }
            for (int i = 0; i < Name.length(); i++) {
                if (!Character.isLetter(validation[i])) {
                    error = true;
                }
            }
        if (error)
            errorText = "Your name is not valid, please enter only letters";
        return errorText;
    }
    public boolean phoneValidation(String phone) {
        boolean isValid=true;
        char[] validation=phone.toCharArray();
        if((phone.length()!=11)||(phone.contains("_")))
        {
            isValid=false;
        }
        if(phone.length()>3)
        {
        if(validation[3]!='-')
            isValid = false;
        else {
            for (int i = 0; i < phone.length(); i++) {
                if (!Character.isDigit(validation[i]) && (i != 3)) {
                    isValid = false;
                    break;
                }
            }
        }
        }
        else
            isValid=false;

        return  isValid;
    }
    public boolean emailValidation(String email) {
        boolean isValid=true;
        if((ActManager.countOccurences(email,'.')<1)||(ActManager.countOccurences(email,'@')!=1)||(email.startsWith("@"))||(email.endsWith("@"))||(email.endsWith("."))||(email.startsWith(".")))
        {
            isValid=false;
        }
        return  isValid;
    }

    protected String guestsAmountValidation(String chosenRooms) {
        int capacity=0;
        char[] validation=chosenRooms.toCharArray();
        String errorText="";
        for(int i=0;i<validation.length-4;i++)
        {
            if (Character.isDigit(validation[i]))
            {
                int roomsAmount = Integer.parseInt(String.valueOf(validation[i]));
                if(validation[i+2]=='F'||validation[i+3]=='F')
                {
                    capacity+=(4* roomsAmount);
                }
                else
                {
                    capacity+=(2* roomsAmount);
                }
            }
        }
        if(Integer.parseInt(guestsAmountSpinner.getValue().toString())>capacity)
            errorText="Too many guests for the chosen rooms";

        return errorText;
    }


    private void viewRoomsAvailabilityButtonMouseClicked() {
        LocalDate checkOut= LocalDate.of(Integer.parseInt(checkOutYearSpinner.getValue().toString()), (Integer) checkOutMonthSpinner.getValue(),(Integer) checkOutDaySpinner.getValue());
        LocalDate checkIn=LocalDate.of((Integer) checkInYearSpinner.getValue(),(Integer)checkInMonthSpinner.getValue(),(Integer) checkInDaySpinner.getValue());
        JLabel roomsDescription=roomsLabel;
        ActManager.roomsScreen=new AvailableRoomsScreen(checkIn,checkOut,roomsDescription);
        ActManager.roomsScreen.setVisible(true);
        ActManager.actionScreen.setVisible(false);
    }

    private void backButtonMouseClicked() {
        ActManager.baseScreen.setVisible(true);
        ActManager.actionScreen.dispose();
    }

    private void continueToPaymentButtonMouseClicked() {
        if(continueToPaymentButton.isEnabled()) {
            boolean valid=true;
            if ((nameValidation(NameTextField.getText()) != "")) {
                JOptionPane.showMessageDialog(null, nameValidation(NameTextField.toString()),
                        "Notice", JOptionPane.WARNING_MESSAGE);
                valid=false;
            }
            if (guestsAmountValidation(roomsLabel.getText()) != "") {
                JOptionPane.showMessageDialog(null, guestsAmountValidation(guestsAmountSpinner.getValue().toString()),
                        "Notice", JOptionPane.WARNING_MESSAGE);
                valid=false;
            }
            if (!DateValidation(checkIn,checkOut)) {
                JOptionPane.showMessageDialog(null, "Invalid Dates",
                        "Notice", JOptionPane.WARNING_MESSAGE);
                valid=false;
            }
            if (!phoneValidation(phoneTextField.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid Phone Number",
                        "Notice", JOptionPane.WARNING_MESSAGE);
                valid=false;
            }
            if (!emailValidation(emailTextField.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid Email",
                        "Notice", JOptionPane.WARNING_MESSAGE);
                valid=false;
            }
            if(valid)
            {
                String detailsLine=ActManager.createReservationLine(NameTextField.getText(),emailTextField.getText(),phoneTextField.getText(),guestsAmountSpinner.getValue().toString(),roomsLabel.getText(),checkIn,checkOut,recepName);
                String details=ActManager.createReservationDetails(NameTextField.getText(),emailTextField.getText(),phoneTextField.getText(),guestsAmountSpinner.getValue().toString(),roomsLabel.getText(),checkIn,checkOut,recepName);
                ActManager.paymentScreen = new PaymentScreen(details,detailsLine,checkIn,checkOut,priceLabel.getText(),roomsLabel);//values
                ActManager.paymentScreen.setVisible(true);
                ActManager.actionScreen.setVisible(false);
            }
        }
    }
    private void initComponents() throws ParseException {
        this.setDefaultCloseOperation(0);
        continueToPaymentButton = new JButton();
        Headlinelabel = new JLabel();
        guestNamelabel = new JLabel();
        guestEmaillabel = new JLabel();
        guestPhonelabel = new JLabel();
        MaskFormatter phoneFormat = new MaskFormatter("###-#######");
        phoneFormat.setPlaceholderCharacter('_');
        phoneTextField = new JFormattedTextField(phoneFormat);
        emailTextField = new JFormattedTextField();
        NameTextField = new JFormattedTextField();
        guestsAmountlabel = new JLabel();
        roomsLabel = new JLabel();
        guestsAmountSpinner = new JSpinner();
        checkInLabel = new JLabel();
        checkOutLabel = new JLabel();
        checkInMonthSpinner = new JSpinner();
        checkInDaySpinner = new JSpinner();
        checkOutMonthSpinner = new JSpinner();
        checkOutDaySpinner = new JSpinner();
        checkInYearSpinner = new JSpinner();
        checkOutYearSpinner = new JSpinner();
        viewRoomsAvailabilityButton = new JButton();
        priceLabel = new JLabel();
        backButton = new JButton();
        backgroundLabel = new JLabel();

        //======== this ========
        setResizable(false);
        setTitle("Reservation Creation");
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        checkIn=LocalDate.now();
        checkOut=LocalDate.now().plusDays(1);;
        //---- continueToPaymentButton ----
        continueToPaymentButton.setText("Continue To Payment");
        continueToPaymentButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                continueToPaymentButtonMouseClicked();
            }
        });
        contentPane.add(continueToPaymentButton);
        continueToPaymentButton.setBounds(250, 370, 295, 30);
        continueToPaymentButton.setEnabled(false);

        //---- Headlinelabel ----
        Headlinelabel.setText("\"Reservation Creation\"");
        Headlinelabel.setFont(Headlinelabel.getFont().deriveFont(Headlinelabel.getFont().getStyle() | Font.BOLD, Headlinelabel.getFont().getSize() + 19f));
        Headlinelabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(Headlinelabel);
        Headlinelabel.setBounds(195, 25, 385, 65);

        //---- guestNamelabel ----
        guestNamelabel.setText("Guest Name:");
        contentPane.add(guestNamelabel);
        guestNamelabel.setBounds(65, 110, 75, 30);
        guestNamelabel.setOpaque(true);
        guestNamelabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        guestNamelabel.setForeground(Color.white);
        guestNamelabel.setBackground(Color.black);

        //---- guestEmaillabel ----
        guestEmaillabel.setText("Guest Email:");
        contentPane.add(guestEmaillabel);
        guestEmaillabel.setBounds(65, 130, 75, 30);
        guestEmaillabel.setOpaque(true);
        guestEmaillabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        guestEmaillabel.setForeground(Color.white);
        guestEmaillabel.setBackground(Color.black);

        //---- guestPhonelabel ----
        guestPhonelabel.setText("Guest Phone Number:");
        contentPane.add(guestPhonelabel);
        guestPhonelabel.setBounds(65, 150, 135, 30);
        contentPane.add(phoneTextField);
        phoneTextField.setBounds(245, 155, 290, phoneTextField.getPreferredSize().height);
        contentPane.add(emailTextField);
        emailTextField.setBounds(245, 135, 290, 19);
        emailTextField.setText("example@example.com");
        contentPane.add(NameTextField);
        NameTextField.setBounds(245, 115, 290, 19);
        guestPhonelabel.setOpaque(true);
        guestPhonelabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        guestPhonelabel.setForeground(Color.white);
        guestPhonelabel.setBackground(Color.black);

        //---- guestsAmountlabel ----
        guestsAmountlabel.setText("Guests Amount:");
        contentPane.add(guestsAmountlabel);
        guestsAmountlabel.setBounds(65, 185, 100, 30);
        guestsAmountlabel.setOpaque(true);
        guestsAmountlabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        guestsAmountlabel.setForeground(Color.white);
        guestsAmountlabel.setBackground(Color.black);
        //---- guestsAmountlabel2 ----
        roomsLabel.setText("Rooms Description:");
        roomsLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        roomsLabel.setOpaque(true);
        roomsLabel.setBackground(Color.black);
        roomsLabel.setForeground(Color.white);
        contentPane.add(roomsLabel);
        roomsLabel.setBounds(65, 225, 470, 45);
        roomsLabel.addPropertyChangeListener(e -> roomsLabelPropertyChange());

        //---- guestsAmountSpinner2 ----
        guestsAmountSpinner.setModel(new SpinnerNumberModel(1, 1, null, 1));
        contentPane.add(guestsAmountSpinner);
        guestsAmountSpinner.setBounds(245, 190, 50, 25);

        //---- checkInLabel ----
        checkInLabel.setText("Check In:");
        contentPane.add(checkInLabel);
        checkInLabel.setBounds(65, 285, 75, 30);
        checkInLabel.setOpaque(true);
        checkInLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        checkInLabel.setForeground(Color.white);
        checkInLabel.setBackground(Color.black);

        //---- checkInLabel2 ----
        checkOutLabel.setText("Check Out:");
        contentPane.add(checkOutLabel);
        checkOutLabel.setBounds(65, 310, 75, 30);
        checkOutLabel.setOpaque(true);
        checkOutLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        checkOutLabel.setForeground(Color.white);
        checkOutLabel.setBackground(Color.black);

        //---- checkInMonthSpinner ----
        checkInMonthSpinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
        contentPane.add(checkInMonthSpinner);
        checkInMonthSpinner.setBounds(315, 285, 65, 25);
        checkInMonthSpinner.addChangeListener(e -> CheckInChange());
        //---- checkIInDaySpinner ----
        checkInDaySpinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
        contentPane.add(checkInDaySpinner);
        checkInDaySpinner.setBounds(250, 285, 45, 25);
        checkInDaySpinner.addChangeListener(e -> CheckInChange());
        //---- checkIInYearSpinner3 ----
        checkInYearSpinner.setModel(new SpinnerNumberModel(2020, 2020, 2100, 1));
        contentPane.add(checkInYearSpinner);
        checkInYearSpinner.setBounds(400, 285, 60, 25);
        checkInYearSpinner.addChangeListener(e -> CheckInChange());

        //---- checkOutMonthSpinner ----
        checkOutMonthSpinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
        contentPane.add(checkOutMonthSpinner);
        checkOutMonthSpinner.setBounds(315, 315, 65, 25);
        checkOutMonthSpinner.addChangeListener(e -> CheckOutChange());

        //---- checkIOutDaySpinner ----
        checkOutDaySpinner.setModel(new SpinnerNumberModel(2, 1, 31, 1));
        contentPane.add(checkOutDaySpinner);
        checkOutDaySpinner.setBounds(250, 315, 45, 25);
        checkOutDaySpinner.addChangeListener(e -> CheckOutChange());

        //---- checkIOutYearSpinner ----
        checkOutYearSpinner.setModel(new SpinnerNumberModel(2020, 2020, 2100, 1));
        contentPane.add(checkOutYearSpinner);
        checkOutYearSpinner.setBounds(400, 315, 60, 25);
        checkOutYearSpinner.addChangeListener(e -> CheckOutChange());
        //---- viewRoomsAvailabilityButton ----
        viewRoomsAvailabilityButton.setText("View Rooms Availability");
        viewRoomsAvailabilityButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewRoomsAvailabilityButtonMouseClicked();
            }
        });
        contentPane.add(viewRoomsAvailabilityButton);
        viewRoomsAvailabilityButton.setBounds(510, 300, 175, 30);

        //---- priceLabel ----
        priceLabel.setText("Price: ");
        priceLabel.setOpaque(true);
        contentPane.add(priceLabel);
        priceLabel.setBounds(300, 410, 170, 30);
        priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        priceLabel.setForeground(Color.green);
        priceLabel.setBackground(Color.black);

        //---- backButton ----
        backButton.setText("Back");
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backButtonMouseClicked();
            }
        });
        contentPane.add(backButton);
        backButton.setBounds(670, 425, 100, 30);

        //---- backgroundLabel ----
        backgroundLabel.setIcon(new ImageIcon(getClass().getResource("../MainScreenBackground.png")));
        contentPane.add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 805, 475);
        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
    }
    private JButton continueToPaymentButton;
    private JLabel Headlinelabel;
    private JLabel guestNamelabel;
    private JLabel guestEmaillabel;
    private JLabel guestPhonelabel;
    private JFormattedTextField phoneTextField;
    private JFormattedTextField emailTextField;
    private JFormattedTextField NameTextField;
    private JLabel guestsAmountlabel;
    private JLabel roomsLabel;
    private JSpinner guestsAmountSpinner;
    private JLabel checkInLabel;
    private JLabel checkOutLabel;
    private JSpinner checkInMonthSpinner;
    private JSpinner checkInDaySpinner;
    private JSpinner checkOutMonthSpinner;
    private JSpinner checkOutDaySpinner;
    private JSpinner checkInYearSpinner;
    private JSpinner checkOutYearSpinner;
    private JButton viewRoomsAvailabilityButton;
    private JLabel priceLabel;
    private JButton backButton;
    private JLabel backgroundLabel;
    private String recepName;
    private  LocalDate checkIn;
    private  LocalDate checkOut;
}
