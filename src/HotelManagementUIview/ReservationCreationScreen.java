/*
 * Created by JFormDesigner on Wed May 20 12:36:57 IDT 2020
 */

package HotelManagementUIview;

import java.awt.*;
import java.text.ParseException;
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

    private void initComponents() throws ParseException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ehud
        createReservationButton = new JButton();
        modeLabel = new JLabel();
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
        roomsNumberSpinner2 = new JSpinner();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setResizable(false);
        setTitle("MainScreen");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- createReservationButton ----
        createReservationButton.setText("Create Reservation");
        contentPane.add(createReservationButton);
        createReservationButton.setBounds(245, 340, 295, 30);

        //---- modeLabel ----
        modeLabel.setText("Receptionist");
        modeLabel.setForeground(Color.blue);
        contentPane.add(modeLabel);
        modeLabel.setBounds(new Rectangle(new Point(15, 10), modeLabel.getPreferredSize()));

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

        //---- guestEmaillabel ----
        guestEmaillabel.setText("Guest Email:");
        contentPane.add(guestEmaillabel);
        guestEmaillabel.setBounds(65, 130, 75, 30);

        //---- guestPhonelabel ----
        guestPhonelabel.setText("Guest Phone Number:");
        contentPane.add(guestPhonelabel);
        guestPhonelabel.setBounds(65, 150, 190, 30);
        contentPane.add(phoneTextField);
        phoneTextField.setBounds(245, 155, 290, phoneTextField.getPreferredSize().height);
        contentPane.add(emailTextField);
        emailTextField.setBounds(245, 135, 290, 19);
        contentPane.add(NameTextField);
        NameTextField.setBounds(245, 115, 290, 19);

        //---- guestsAmountlabel ----
        guestsAmountlabel.setText("Guests Amount:");
        contentPane.add(guestsAmountlabel);
        guestsAmountlabel.setBounds(65, 185, 190, 30);

        //---- guestsAmountlabel2 ----
        guestsAmountlabel2.setText("Rooms Number:");
        contentPane.add(guestsAmountlabel2);
        guestsAmountlabel2.setBounds(65, 210, 190, 30);

        //---- roomsNumberSpinner ----
        roomsNumberSpinner.setModel(new SpinnerNumberModel(1, 1, null, 1));
        contentPane.add(roomsNumberSpinner);
        roomsNumberSpinner.setBounds(245, 215, 35, 25);

        //---- guestsAmountSpinner2 ----
        guestsAmountSpinner2.setModel(new SpinnerNumberModel(1, 1, null, 1));
        contentPane.add(guestsAmountSpinner2);
        guestsAmountSpinner2.setBounds(245, 190, 35, 25);

        //---- checkInLabel ----
        checkInLabel.setText("Check In:");
        contentPane.add(checkInLabel);
        checkInLabel.setBounds(65, 245, 165, 30);

        //---- checkInLabel2 ----
        checkInLabel2.setText("Check Out:");
        contentPane.add(checkInLabel2);
        checkInLabel2.setBounds(65, 270, 165, 30);

        //---- roomsNumberSpinner2 ----
        roomsNumberSpinner2.setModel(new SpinnerDateModel(new java.util.Date((System.currentTimeMillis()/60000)*60000), new java.util.Date((System.currentTimeMillis()/60000)*60000), null, java.util.Calendar.DAY_OF_MONTH));
        contentPane.add(roomsNumberSpinner2);
        roomsNumberSpinner2.setBounds(240, 245, 190, 25);
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(435, 185), scrollPane1.getPreferredSize()));

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
    private JButton createReservationButton;
    private JLabel modeLabel;
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
    private JSpinner roomsNumberSpinner2;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
