/*
 * Created by JFormDesigner on Tue May 19 18:27:21 IDT 2020
 */

package HotelManagementUIview;

import java.awt.event.*;
import HotelManagementController.ActManager;
import HotelManagementController.Program;
import HotelManagmentModel.Guest;
import HotelManagmentModel.Reservation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import javax.swing.*;

/**
 * @author Ehud
 */
public class MainScreen extends JFrame {
    public MainScreen() {
        initComponents();
    }
    public MainScreen(String name, boolean isManager)
    {
        initComponents();
        managerMode=isManager;
        if(managerMode) {
            modeLabel.setText("Manager");
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ehud
        createReservationButton = new JButton();
        viewRoomsAvailabilityButton = new JButton();
        changeReservationButton = new JButton();
        cancelReservationButton = new JButton();
        cancelReservationButton2 = new JButton();
        logoutButton = new JButton();
        modeLabel = new JLabel();
        requestsButton = new JButton();
        label1 = new JLabel();
        backgroundLabel = new JLabel();

        //======== this ========
        setResizable(false);
        setTitle("MainScreen");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- createReservationButton ----
        createReservationButton.setText("Create Reservation");
        createReservationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    createReservationButtonMouseClicked();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });
        contentPane.add(createReservationButton);
        createReservationButton.setBounds(265, 110, 295, 30);

        //---- viewRoomsAvailabilityButton ----
        viewRoomsAvailabilityButton.setText("View Rooms Availability");
        contentPane.add(viewRoomsAvailabilityButton);
        viewRoomsAvailabilityButton.setBounds(265, 155, 295, 30);

        //---- changeReservationButton ----
        changeReservationButton.setText("Change Reservation");
        contentPane.add(changeReservationButton);
        changeReservationButton.setBounds(265, 200, 295, 30);

        //---- cancelReservationButton ----
        cancelReservationButton.setText("Cancel Reservation");
        contentPane.add(cancelReservationButton);
        cancelReservationButton.setBounds(265, 240, 295, 30);

        //---- cancelReservationButton2 ----
        cancelReservationButton2.setText("View Guest Information");
        contentPane.add(cancelReservationButton2);
        cancelReservationButton2.setBounds(265, 285, 295, 30);

        //---- logoutButton ----
        logoutButton.setText("Logout");
        contentPane.add(logoutButton);
        logoutButton.setBounds(650, 385, 115, 45);

        //---- modeLabel ----
        modeLabel.setText("Receptionist");
        modeLabel.setForeground(Color.blue);
        contentPane.add(modeLabel);
        modeLabel.setBounds(new Rectangle(new Point(15, 10), modeLabel.getPreferredSize()));

        //---- requestsButton ----
        requestsButton.setText("Requests");
        requestsButton.setEnabled(false);
        contentPane.add(requestsButton);
        requestsButton.setBounds(265, 325, 295, 30);

        //---- label1 ----
        label1.setText("\"Hotel Name\"");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 19f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(215, 25, 385, 65);
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
    private void createReservationButtonMouseClicked() throws IOException, ParseException {
//        Reservation currentReservation = new Reservation();
        Program.actionScreen=new ReservationCreationScreen(managerMode);
        Program.actionScreen.setVisible(true);
        Program.baseScreen.setVisible(false);
//        this.dispose();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ehud
    private JButton createReservationButton;
    private JButton viewRoomsAvailabilityButton;
    private JButton changeReservationButton;
    private JButton cancelReservationButton;
    private JButton cancelReservationButton2;
    private JButton logoutButton;
    private JLabel modeLabel;
    private JButton requestsButton;
    private JLabel label1;
    private JLabel backgroundLabel;
    private boolean managerMode;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
