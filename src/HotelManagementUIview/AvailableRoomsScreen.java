/*
 * Created by JFormDesigner on Tue May 26 19:39:13 IDT 2020
 */

package HotelManagementUIview;
import java.awt.event.*;
import HotelManagementController.ActManager;
import HotelManagementController.Program;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;

/**
 * @author Ehud
 */
public class AvailableRoomsScreen extends JFrame {
    public JLabel labelchanger;
    public AvailableRoomsScreen( LocalDate checkIn, LocalDate checkOut,JLabel rooms) {
        initComponents();
        labelchanger=rooms;
        List<String> availableRooms= ActManager.ShowAvailableRooms(checkIn,checkOut);
        dateslabel.setText("Check In: "+checkIn.toString()+"      Check Out: "+ checkOut.toString());
        twinLabel.setText("Available Twin Rooms:" +availableRooms.get(0));
        familyLabel.setText("Available Family Rooms:"+availableRooms.get(1));
        deluxeLabel.setText("Available Deluxe Rooms:"+availableRooms.get(2));
        premiumLabel.setText("Available Premium Rooms:"+availableRooms.get(3));
        suiteLabel.setText("Available Suite Rooms:"+availableRooms.get(4));
<<<<<<< HEAD

=======
        SpinnerNumberModel twinModel = new SpinnerNumberModel(0,0,Integer.parseInt(availableRooms.get(0)),1);
        twinSpinner.setModel(twinModel);
        SpinnerNumberModel familyModel = new SpinnerNumberModel(0,0,Integer.parseInt(availableRooms.get(1)),1);
        familySpinner.setModel(familyModel);
        SpinnerNumberModel deluxeModel = new SpinnerNumberModel(0,0,Integer.parseInt(availableRooms.get(2)),1);
        deluxeSpinner.setModel(deluxeModel);
        SpinnerNumberModel premiumModel = new SpinnerNumberModel(0,0,Integer.parseInt(availableRooms.get(3)),1);
        premiumSpinner.setModel(premiumModel);
        SpinnerNumberModel suiteModel = new SpinnerNumberModel(0,0,Integer.parseInt(availableRooms.get(4)),1);
        suiteSpinner.setModel(suiteModel);
>>>>>>> c59a6f1... Payement Screen added
    }

    @Override
    public void dispose() {
        ChangeRoomsDescription(labelchanger);
        super.dispose();
    }

    public void ChangeRoomsDescription(JLabel r)
{
    String text="";
    if(Integer.parseInt(twinSpinner.getValue().toString())!=0)
    {
        text+=twinSpinner.getValue().toString()+" Twin rooms ";
    }
    if(Integer.parseInt(familySpinner.getValue().toString())!=0)
    {
        text+=familySpinner.getValue().toString()+" Family rooms ";
    }
    if(Integer.parseInt(deluxeSpinner.getValue().toString())!=0)
    {
        text+=deluxeSpinner.getValue().toString()+" Deluxe rooms ";
    }
    if(Integer.parseInt(premiumSpinner.getValue().toString())!=0)
    {
        text+=premiumSpinner.getValue().toString()+" Premium rooms ";
    }
    if(Integer.parseInt(suiteSpinner.getValue().toString())!=0)
    {
        text+=suiteSpinner.getValue().toString()+" Suite rooms ";
    }
    r.setText(text);
}
    public AvailableRoomsScreen() {
    }

    private void backButtonMouseClicked() {
        Program.actionScreen.setVisible(true);
        Program.roomsScreen.dispose();
    }

    public void selectButtonMouseClicked() throws ParseException {
        Program.actionScreen.setVisible(true);
        Program.roomsScreen.dispose();
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
        contentPane.add(dateslabel);
        dateslabel.setBounds(250, 20, 270, 25);

        //---- twinLabel ----
        twinLabel.setText("Available Twin Rooms:");
        twinLabel.setOpaque(true);
        twinLabel.setBackground(Color.black);
        contentPane.add(twinLabel);
        twinLabel.setBounds(190, 75, 195, 35);

        //---- familyLabel ----
        familyLabel.setText("Available Family Rooms:");
        familyLabel.setOpaque(true);
        familyLabel.setBackground(Color.black);
        contentPane.add(familyLabel);
        familyLabel.setBounds(190, 115, 195, 35);

        //---- deluxeLabel ----
        deluxeLabel.setText("Available Deluxe Rooms:");
        deluxeLabel.setOpaque(true);
        deluxeLabel.setBackground(Color.black);
        deluxeLabel.setForeground(Color.white);
        contentPane.add(deluxeLabel);
        deluxeLabel.setBounds(190, 155, 195, 35);

        //---- premiumLabel ----
        premiumLabel.setText("Available Premium Rooms:");
        premiumLabel.setOpaque(true);
        premiumLabel.setBackground(Color.black);
        premiumLabel.setForeground(Color.white);
        contentPane.add(premiumLabel);
        premiumLabel.setBounds(190, 195, 195, 35);

        //---- suiteLabel ----
        suiteLabel.setText("Available Suite Rooms:");
        suiteLabel.setOpaque(true);
        suiteLabel.setBackground(Color.black);
        suiteLabel.setForeground(Color.white);
        contentPane.add(suiteLabel);
        suiteLabel.setBounds(190, 235, 195, 35);
        contentPane.add(twinSpinner);
        twinSpinner.setBounds(515, 75, 50, 35);
        contentPane.add(familySpinner);
        familySpinner.setBounds(515, 115, 50, 35);
        contentPane.add(deluxeSpinner);
        deluxeSpinner.setBounds(515, 155, 50, 35);
        contentPane.add(premiumSpinner);
        premiumSpinner.setBounds(515, 195, 50, 35);
        contentPane.add(suiteSpinner);
        suiteSpinner.setBounds(515, 235, 50, 35);

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
