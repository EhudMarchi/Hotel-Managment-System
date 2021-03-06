package HotelManagementUIview;
import java.awt.event.*;
import HotelManagementController.ActManager;
import HotelManagementController.Program;

import java.text.ParseException;
import java.time.LocalDate;
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

        List<String> availableRooms= ActManager.showAvailableRooms(checkIn,checkOut);
        dateslabel.setText("Check In: "+checkIn.toString()+"      Check Out: "+ checkOut.toString());
        twinLabel.setText("Available Twin Rooms:" +availableRooms.get(0));
        familyLabel.setText("Available Family Rooms:"+availableRooms.get(1));
        deluxeLabel.setText("Available Deluxe Rooms:"+availableRooms.get(2));
        premiumLabel.setText("Available Premium Rooms:"+availableRooms.get(3));
        suiteLabel.setText("Available Suite Rooms:"+availableRooms.get(4));
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
    }

    @Override
    public void dispose() {
        changeRoomsDescription(labelchanger);
        super.dispose();
    }

    public void changeRoomsDescription(JLabel r)
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
    private void backButtonMouseClicked() {
        ActManager.actionScreen.setVisible(true);
        ActManager.roomsScreen.dispose();
    }

    public void selectButtonMouseClicked() throws ParseException {
        if(ActManager.baseScreen.isVisible())
        {
            ActManager.baseScreen.setVisible(false);
        }
        ActManager.actionScreen.setVisible(true);
        ActManager.roomsScreen.dispose();
    }

    private void initComponents() {
        this.setDefaultCloseOperation(0);
        this.setResizable(false);
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
        backButton = new JButton();
        selectButton = new JButton();
        backgroundLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        setTitle("Available Rooms");
        //---- dateslabel ----
        dateslabel.setText("Dates:");
        dateslabel.setForeground(Color.white);
        dateslabel.setBackground(Color.black);
        dateslabel.setOpaque(true);
        dateslabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentPane.add(dateslabel);
        dateslabel.setBounds(250, 20, 290, 25);

        //---- twinLabel ----
        twinLabel.setText("Available Twin Rooms:");
        twinLabel.setOpaque(true);
        twinLabel.setBackground(Color.black);
        twinLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        twinLabel.setForeground(Color.white);
        contentPane.add(twinLabel);
        twinLabel.setBounds(190, 75, 195, 35);

        //---- familyLabel ----
        familyLabel.setText("Available Family Rooms:");
        familyLabel.setOpaque(true);
        familyLabel.setBackground(Color.black);
        familyLabel.setForeground(Color.white);
        familyLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentPane.add(familyLabel);
        familyLabel.setBounds(190, 115, 195, 35);

        //---- deluxeLabel ----
        deluxeLabel.setText("Available Deluxe Rooms:");
        deluxeLabel.setOpaque(true);
        deluxeLabel.setBackground(Color.black);
        deluxeLabel.setForeground(Color.white);
        deluxeLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentPane.add(deluxeLabel);
        deluxeLabel.setBounds(190, 155, 195, 35);

        //---- premiumLabel ----
        premiumLabel.setText("Available Premium Rooms:");
        premiumLabel.setOpaque(true);
        premiumLabel.setBackground(Color.black);
        premiumLabel.setForeground(Color.white);
        premiumLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentPane.add(premiumLabel);
        premiumLabel.setBounds(190, 195, 195, 35);

        //---- suiteLabel ----
        suiteLabel.setText("Available Suite Rooms:");
        suiteLabel.setOpaque(true);
        suiteLabel.setBackground(Color.black);
        suiteLabel.setForeground(Color.white);
        suiteLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
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

        //---- backButton ----
        backButton.setText("Back");
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backButtonMouseClicked();
            }
        });
        contentPane.add(backButton);
        backButton.setBounds(645, 365, 100, 30);

        //---- selectButton ----
        selectButton.setText("Select");
        selectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    selectButtonMouseClicked();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });
        contentPane.add(selectButton);
        selectButton.setBounds(590, 140, 85, 30);

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
    private JButton backButton;
    private JButton selectButton;
    private JLabel backgroundLabel;
}
