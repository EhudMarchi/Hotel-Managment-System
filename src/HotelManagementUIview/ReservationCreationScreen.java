/*
 * Created by JFormDesigner on Wed May 20 12:36:57 IDT 2020
 */

package HotelManagementUIview;

import javax.swing.plaf.*;
import HotelManagementController.ActManager;
import HotelManagementController.Program;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.MaskFormatter;

/**
 * @author Ehud
 */
public class ReservationCreationScreen extends JFrame {
    public ReservationCreationScreen(boolean isManager) throws ParseException {
        initComponents();
//        managerMode=isManager;
//        if(managerMode) {
//            modeLabel.setText("Manager");
//        }
    }
    private void viewRoomsAvailabilityButtonMouseClicked() {
//        LocalDate checkOut=new LocalDate(checkIOutYearSpinner.getValue(),checkOutMonthSpinner.getValue(),(Integer)checkIOutDaySpinner.getValue());
//        LocalDate checkIn=new LocalDate((Integer)checkIInYearSpinner3.getValue(),(Integer)checkInMonthSpinner.getValue(),(Integer)checkIInDaySpinner.getValue());

        Program.roomsScreen=new AvailableRoomsScreen(LocalDate.now(),LocalDate.now());
        Program.roomsScreen.setVisible(true);
        Program.actionScreen.setVisible(false);
    }
    private void initComponents() throws ParseException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ehud
        continueToPaymentButton = new JButton();
        Headlinelabel = new JLabel();
        guestNamelabel = new JLabel();
        guestEmaillabel = new JLabel();
        guestPhonelabel = new JLabel();
        phoneTextField = new JFormattedTextField();
        emailTextField = new JFormattedTextField();
        NameTextField = new JFormattedTextField();
        guestsAmountlabel = new JLabel();
        guestsAmountlabel2 = new JLabel();
        roomsNumberSpinner = new JSpinner();
        guestsAmountSpinner2 = new JSpinner();
        checkInLabel = new JLabel();
        checkInLabel2 = new JLabel();
        checkInMonthSpinner = new JSpinner();
        checkIInDaySpinner = new JSpinner();
        checkOutMonthSpinner = new JSpinner();
        checkIOutDaySpinner = new JSpinner();
        checkIInYearSpinner3 = new JSpinner();
        checkIOutYearSpinner = new JSpinner();
        viewRoomsAvailabilityButton = new JButton();
        priceLabel = new JLabel();
        dayLabel = new JLabel();
        yearLabel = new JLabel();
        monthLabel = new JLabel();
        backgroundLabel = new JLabel();

        //======== this ========
        setResizable(false);
        setTitle("MainScreen");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- continueToPaymentButton ----
        continueToPaymentButton.setText("Continue To Payment");
        contentPane.add(continueToPaymentButton);
        continueToPaymentButton.setBounds(250, 370, 295, 30);

        //---- Headlinelabel ----
        Headlinelabel.setText("\"Reservation Creation\"");
        Headlinelabel.setFont(Headlinelabel.getFont().deriveFont(Headlinelabel.getFont().getStyle() | Font.BOLD, Headlinelabel.getFont().getSize() + 19f));
        Headlinelabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(Headlinelabel);
        Headlinelabel.setBounds(195, 25, 385, 65);

        //---- guestNamelabel ----
        guestNamelabel.setText("Guest Name:");
        guestNamelabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        guestNamelabel.setBackground(Color.black);
        guestNamelabel.setOpaque(true);
        guestNamelabel.setForeground(Color.white);
        contentPane.add(guestNamelabel);
        guestNamelabel.setBounds(65, 110, 75, 30);

        //---- guestEmaillabel ----
        guestEmaillabel.setText("Guest Email:");
        guestEmaillabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        guestEmaillabel.setOpaque(true);
        guestEmaillabel.setBackground(Color.black);
        guestEmaillabel.setForeground(Color.white);
        contentPane.add(guestEmaillabel);
        guestEmaillabel.setBounds(65, 130, 75, 30);

        //---- guestPhonelabel ----
        guestPhonelabel.setText("Guest Phone Number:");
        guestPhonelabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        guestPhonelabel.setOpaque(true);
        guestPhonelabel.setBackground(Color.black);
        guestPhonelabel.setForeground(Color.white);
        contentPane.add(guestPhonelabel);
        guestPhonelabel.setBounds(65, 150, 125, 30);

        //---- phoneTextField ----
        phoneTextField.setBackground(Color.black);
        phoneTextField.setForeground(Color.white);
        contentPane.add(phoneTextField);
        phoneTextField.setBounds(245, 155, 290, phoneTextField.getPreferredSize().height);

        //---- emailTextField ----
        emailTextField.setBackground(Color.black);
        emailTextField.setForeground(Color.white);
        emailTextField.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentPane.add(emailTextField);
        emailTextField.setBounds(245, 135, 290, 19);

        //---- NameTextField ----
        NameTextField.setBackground(Color.black);
        NameTextField.setForeground(Color.white);
        NameTextField.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentPane.add(NameTextField);
        NameTextField.setBounds(245, 115, 290, 19);

        //---- guestsAmountlabel ----
        guestsAmountlabel.setText("Guests Amount:");
        guestsAmountlabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        guestsAmountlabel.setOpaque(true);
        guestsAmountlabel.setBackground(Color.black);
        guestsAmountlabel.setForeground(Color.white);
        contentPane.add(guestsAmountlabel);
        guestsAmountlabel.setBounds(65, 185, 95, 30);

        //---- guestsAmountlabel2 ----
        guestsAmountlabel2.setText("Rooms Number:");
        guestsAmountlabel2.setFont(new Font("Segoe UI", Font.BOLD, 12));
        guestsAmountlabel2.setOpaque(true);
        guestsAmountlabel2.setBackground(Color.black);
        guestsAmountlabel2.setForeground(Color.white);
        contentPane.add(guestsAmountlabel2);
        guestsAmountlabel2.setBounds(65, 210, 95, 30);

        //---- roomsNumberSpinner ----
        roomsNumberSpinner.setModel(new SpinnerNumberModel(1, 1, null, 1));
        contentPane.add(roomsNumberSpinner);
        roomsNumberSpinner.setBounds(245, 215, 50, 25);

        //---- guestsAmountSpinner2 ----
        guestsAmountSpinner2.setModel(new SpinnerNumberModel(1, 1, null, 1));
        guestsAmountSpinner2.setBackground(Color.black);
        guestsAmountSpinner2.setForeground(Color.white);
        contentPane.add(guestsAmountSpinner2);
        guestsAmountSpinner2.setBounds(245, 190, 50, 25);

        //---- checkInLabel ----
        checkInLabel.setText("Check In:");
        checkInLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        checkInLabel.setOpaque(true);
        checkInLabel.setBackground(Color.black);
        checkInLabel.setForeground(Color.white);
        contentPane.add(checkInLabel);
        checkInLabel.setBounds(65, 285, 50, 30);

        //---- checkInLabel2 ----
        checkInLabel2.setText("Check Out:");
        checkInLabel2.setFont(new Font("Segoe UI", Font.BOLD, 12));
        checkInLabel2.setOpaque(true);
        checkInLabel2.setBackground(Color.black);
        checkInLabel2.setForeground(Color.white);
        contentPane.add(checkInLabel2);
        checkInLabel2.setBounds(65, 315, 65, 25);

        //---- checkInMonthSpinner ----
        checkInMonthSpinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
        contentPane.add(checkInMonthSpinner);
        checkInMonthSpinner.setBounds(315, 285, 65, 25);

        //---- checkIInDaySpinner ----
        checkIInDaySpinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
        contentPane.add(checkIInDaySpinner);
        checkIInDaySpinner.setBounds(250, 285, 45, 25);

        //---- checkOutMonthSpinner ----
        checkOutMonthSpinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
        contentPane.add(checkOutMonthSpinner);
        checkOutMonthSpinner.setBounds(315, 315, 65, 25);

        //---- checkIOutDaySpinner ----
        checkIOutDaySpinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
        contentPane.add(checkIOutDaySpinner);
        checkIOutDaySpinner.setBounds(250, 315, 45, 25);

        //---- checkIInYearSpinner3 ----
        checkIInYearSpinner3.setModel(new SpinnerNumberModel(20, 20, 99, 1));
        contentPane.add(checkIInYearSpinner3);
        checkIInYearSpinner3.setBounds(400, 285, 60, 25);

        //---- checkIOutYearSpinner ----
        checkIOutYearSpinner.setModel(new SpinnerNumberModel(20, 20, 99, 1));
        contentPane.add(checkIOutYearSpinner);
        checkIOutYearSpinner.setBounds(400, 315, 60, 25);

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
        contentPane.add(priceLabel);
        priceLabel.setBounds(300, 410, 170, priceLabel.getPreferredSize().height);

        //---- dayLabel ----
        dayLabel.setText("Day:");
        dayLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        dayLabel.setOpaque(true);
        dayLabel.setBackground(Color.black);
        dayLabel.setForeground(Color.white);
        contentPane.add(dayLabel);
        dayLabel.setBounds(260, 255, 25, 30);

        //---- yearLabel ----
        yearLabel.setText("Year:");
        yearLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        yearLabel.setOpaque(true);
        yearLabel.setBackground(Color.black);
        yearLabel.setForeground(Color.white);
        contentPane.add(yearLabel);
        yearLabel.setBounds(415, 255, 30, 30);

        //---- monthLabel ----
        monthLabel.setText("Month:");
        monthLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        monthLabel.setOpaque(true);
        monthLabel.setBackground(Color.black);
        monthLabel.setForeground(Color.white);
        contentPane.add(monthLabel);
        monthLabel.setBounds(325, 255, 45, 30);

        //---- backgroundLabel ----
        backgroundLabel.setIcon(new ImageIcon(getClass().getResource("/MainScreenBackground.png")));
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ehud
    private JButton continueToPaymentButton;
    private JLabel Headlinelabel;
    private JLabel guestNamelabel;
    private JLabel guestEmaillabel;
    private JLabel guestPhonelabel;
    private JFormattedTextField phoneTextField;
    private JFormattedTextField emailTextField;
    private JFormattedTextField NameTextField;
    private JLabel guestsAmountlabel;
    private JLabel guestsAmountlabel2;
    private JSpinner roomsNumberSpinner;
    private JSpinner guestsAmountSpinner2;
    private JLabel checkInLabel;
    private JLabel checkInLabel2;
    private JSpinner checkInMonthSpinner;
    private JSpinner checkIInDaySpinner;
    private JSpinner checkOutMonthSpinner;
    private JSpinner checkIOutDaySpinner;
    private JSpinner checkIInYearSpinner3;
    private JSpinner checkIOutYearSpinner;
    private JButton viewRoomsAvailabilityButton;
    private JLabel priceLabel;
    private JLabel dayLabel;
    private JLabel yearLabel;
    private JLabel monthLabel;
    private JLabel backgroundLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
