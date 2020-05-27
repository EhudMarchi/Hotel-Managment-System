/*
 * Created by JFormDesigner on Tue May 26 19:39:13 IDT 2020
 */

package HotelManagementUIview;
import HotelManagementController.ActManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;

/**
 * @author Ehud
 */
public class AvailableRoomsScreen extends JFrame {
    public AvailableRoomsScreen( LocalDate checkIn, LocalDate checkOut) {
        initComponents();
        List<String> availableRooms= ActManager.ShowAvailableRooms(checkIn,checkOut);
        dateslabel.setText("Check In: "+checkIn.toString()+"       Check Out: "+ checkOut.toString());
        twinLabel.setText("Available Twin Rooms:" +availableRooms.get(0));
        familyLabel.setText("Available Family Rooms:"+availableRooms.get(1));
        deluxeLabel.setText("Available Deluxe Rooms:"+availableRooms.get(2));
        premiumLabel.setText("Available Premium Rooms:"+availableRooms.get(3));
        suiteLabel.setText("Available Suite Rooms:"+availableRooms.get(4));
    }

    public AvailableRoomsScreen() {
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ehud
        dateslabel = new JLabel();
        twinLabel = new JLabel();
        familyLabel = new JLabel();
        deluxeLabel = new JLabel();
        premiumLabel = new JLabel();
        suiteLabel = new JLabel();
        twinSpinner = new JSpinner();
        familySpinner = new JSpinner();
        deluxeSpinner = new JSpinner();
        premiumSpinner = new JSpinner();
        suiteSpinner = new JSpinner();
        backgroundLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- dateslabel ----
        dateslabel.setText("Dates:");
        dateslabel.setForeground(Color.white);
        dateslabel.setBackground(Color.black);
        dateslabel.setOpaque(true);
        dateslabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentPane.add(dateslabel);
        dateslabel.setBounds(260, 80, 290, 25);

        //---- twinLabel ----
        twinLabel.setText("Available Twin Rooms:");
        twinLabel.setOpaque(true);
        twinLabel.setBackground(Color.black);
        twinLabel.setForeground(Color.white);
        twinLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentPane.add(twinLabel);
        twinLabel.setBounds(200, 135, 225, 35);

        //---- familyLabel ----
        familyLabel.setText("Available Family Rooms:");
        familyLabel.setOpaque(true);
        familyLabel.setBackground(Color.black);
        familyLabel.setForeground(Color.white);
        familyLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentPane.add(familyLabel);
        familyLabel.setBounds(200, 175, 225, 35);

        //---- deluxeLabel ----
        deluxeLabel.setText("Available Deluxe Rooms:");
        deluxeLabel.setOpaque(true);
        deluxeLabel.setBackground(Color.black);
        deluxeLabel.setForeground(Color.white);
        deluxeLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentPane.add(deluxeLabel);
        deluxeLabel.setBounds(200, 215, 225, 35);

        //---- premiumLabel ----
        premiumLabel.setText("Available Premium Rooms:");
        premiumLabel.setOpaque(true);
        premiumLabel.setBackground(Color.black);
        premiumLabel.setForeground(Color.white);
        premiumLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentPane.add(premiumLabel);
        premiumLabel.setBounds(200, 255, 225, 35);

        //---- suiteLabel ----
        suiteLabel.setText("Available Suite Rooms:");
        suiteLabel.setOpaque(true);
        suiteLabel.setBackground(Color.black);
        suiteLabel.setForeground(Color.white);
        suiteLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentPane.add(suiteLabel);
        suiteLabel.setBounds(200, 295, 225, 35);

        //---- twinSpinner ----
        twinSpinner.setBackground(Color.black);
        twinSpinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
        twinSpinner.setFont(twinSpinner.getFont().deriveFont(twinSpinner.getFont().getStyle() | Font.BOLD));
        contentPane.add(twinSpinner);
        twinSpinner.setBounds(510, 135, 50, 35);

        //---- familySpinner ----
        familySpinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
        familySpinner.setFont(familySpinner.getFont().deriveFont(familySpinner.getFont().getStyle() | Font.BOLD));
        contentPane.add(familySpinner);
        familySpinner.setBounds(510, 175, 50, 35);

        //---- deluxeSpinner ----
        deluxeSpinner.setFont(deluxeSpinner.getFont().deriveFont(deluxeSpinner.getFont().getStyle() | Font.BOLD));
        deluxeSpinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
        contentPane.add(deluxeSpinner);
        deluxeSpinner.setBounds(510, 215, 50, 35);

        //---- premiumSpinner ----
        premiumSpinner.setFont(premiumSpinner.getFont().deriveFont(premiumSpinner.getFont().getStyle() | Font.BOLD));
        premiumSpinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
        contentPane.add(premiumSpinner);
        premiumSpinner.setBounds(510, 255, 50, 35);

        //---- suiteSpinner ----
        suiteSpinner.setFont(suiteSpinner.getFont().deriveFont(suiteSpinner.getFont().getStyle() | Font.BOLD));
        suiteSpinner.setModel(new SpinnerNumberModel(0, 0, null, 1));
        contentPane.add(suiteSpinner);
        suiteSpinner.setBounds(510, 295, 50, 35);

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
    private JLabel dateslabel;
    private JLabel twinLabel;
    private JLabel familyLabel;
    private JLabel deluxeLabel;
    private JLabel premiumLabel;
    private JLabel suiteLabel;
    private JSpinner twinSpinner;
    private JSpinner familySpinner;
    private JSpinner deluxeSpinner;
    private JSpinner premiumSpinner;
    private JSpinner suiteSpinner;
    private JLabel backgroundLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
