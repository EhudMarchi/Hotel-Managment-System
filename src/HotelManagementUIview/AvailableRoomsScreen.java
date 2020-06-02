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
        backgroundLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- dateslabel ----
        dateslabel.setText("Dates:");
        dateslabel.setForeground(Color.white);
        dateslabel.setBackground(Color.black);
        dateslabel.setOpaque(true);
        contentPane.add(dateslabel);
        dateslabel.setBounds(250, 20, 270, 25);

        //---- twinLabel ----
        twinLabel.setText("Available Twin Rooms:");
        twinLabel.setOpaque(true);
        twinLabel.setBackground(Color.black);
        contentPane.add(twinLabel);
        twinLabel.setBounds(190, 75, 385, 35);

        //---- familyLabel ----
        familyLabel.setText("Available Family Rooms:");
        familyLabel.setOpaque(true);
        familyLabel.setBackground(Color.black);
        contentPane.add(familyLabel);
        familyLabel.setBounds(190, 115, 385, 35);

        //---- deluxeLabel ----
        deluxeLabel.setText("Available Deluxe Rooms:");
        deluxeLabel.setOpaque(true);
        deluxeLabel.setBackground(Color.black);
        contentPane.add(deluxeLabel);
        deluxeLabel.setBounds(190, 155, 385, 35);

        //---- premiumLabel ----
        premiumLabel.setText("Available Premium Rooms:");
        premiumLabel.setOpaque(true);
        premiumLabel.setBackground(Color.black);
        contentPane.add(premiumLabel);
        premiumLabel.setBounds(190, 195, 385, 35);

        //---- suiteLabel ----
        suiteLabel.setText("Available Suite Rooms:");
        suiteLabel.setOpaque(true);
        suiteLabel.setBackground(Color.black);
        contentPane.add(suiteLabel);
        suiteLabel.setBounds(190, 235, 385, 35);

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
    private JLabel backgroundLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
