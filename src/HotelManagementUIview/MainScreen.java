
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
public class MainScreen extends JFrame {//Singelton Design Pettern
    public MainScreen() {
        initComponents();
    }
    public MainScreen(String name,boolean isManager)
    {
        initComponents();
        recepName = name;
        managerMode=isManager;
        if(managerMode) {
            modeLabel.setText("Manager");
            requestsButton.setEnabled(true);
        }
    }
    private void requestsButtonMouseClicked() throws IOException {
        if(managerMode)
        {
        this.setVisible(false);
        Program.actionScreen=new RequestsScreen();
        Program.actionScreen.setVisible(true);
    }
    }
    private void cancelReservationButtonMouseClicked() throws IOException {
        Program.baseScreen.setEnabled(false);
        Program.actionScreen=new CancelScreen();
        Program.actionScreen.setVisible(true);
    }
    private void logoutButtonMouseClicked() {
        this.dispose();
        Program.baseScreen=new LoginScreen();
        Program.baseScreen.setVisible(true);
    }
    private void changeReservationButtonMouseClicked() throws IOException {
        Program.baseScreen.setEnabled(false);
        Program.actionScreen=new ChangeScreen();
        Program.actionScreen.setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ehud
        createReservationButton = new JButton();
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
        createReservationButton.setBounds(265, 120, 295, 70);
        createReservationButton.setFont(createReservationButton.getFont().deriveFont(createReservationButton.getFont().getStyle() | Font.BOLD,20));

        //---- changeReservationButton ----
        changeReservationButton.setText("Change Reservation");
        contentPane.add(changeReservationButton);
        changeReservationButton.setBounds(265, 200, 295, 30);
        changeReservationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    changeReservationButtonMouseClicked();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //---- cancelReservationButton ----
        cancelReservationButton.setText("Cancel Reservation");
        contentPane.add(cancelReservationButton);
        cancelReservationButton.setBounds(265, 240, 295, 30);
        cancelReservationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    cancelReservationButtonMouseClicked();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //---- cancelReservationButton2 ----
        cancelReservationButton2.setText("View Guest Information");
        contentPane.add(cancelReservationButton2);
        cancelReservationButton2.setBounds(265, 285, 295, 30);

        //---- logoutButton ----
        logoutButton.setText("Logout");
        logoutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logoutButtonMouseClicked();
            }
        });
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
        requestsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    requestsButtonMouseClicked();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        //---- label1 ----
        label1.setText("\"Hotel Name\"");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 19f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(215, 25, 385, 65);


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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private void createReservationButtonMouseClicked() throws IOException, ParseException {
//        Reservation currentReservation = new Reservation();

        Program.actionScreen=new ReservationCreationScreen(recepName);
        Program.actionScreen.setVisible(true);
        Program.baseScreen.setVisible(false);
//        this.dispose();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ehud
    private JButton createReservationButton;
    private JButton changeReservationButton;
    private JButton cancelReservationButton;
    private JButton cancelReservationButton2;
    private JButton logoutButton;
    private JLabel modeLabel;
    private JButton requestsButton;
    private JLabel label1;
    private JLabel backgroundLabel;
    private String recepName;
    private boolean managerMode;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
