package HotelManagementUIview;

import HotelManagementController.ActManager;
import HotelManagementController.Program;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.*;

/**
 * @author Ehud
 */
public class ManagerOptionsScreen extends JFrame {

    public ManagerOptionsScreen() throws IOException {
        initComponents();
        List<String> availableRooms= ActManager.readLinesFromFile("src\\HotelData");
        SpinnerNumberModel twinModel = new SpinnerNumberModel(0,0,Integer.parseInt(availableRooms.get(0)),1);
        roomsSpinner.setModel(twinModel);
    }
    private void backButtonMouseClicked() {
        ActManager.baseScreen.setVisible(true);
        ActManager.actionScreen.dispose();
    }
    private void confirmButtonMouseClicked() throws IOException {
        if(optionsComboBox.getSelectedItem().toString().contains("Add Receptionist"))
        {
           ActManager.addNewEmployee(false,NameTextField.getText(),userNameTextField.getText(),passwordTextField.getText());
           JOptionPane.showMessageDialog(null, "New receptionist has been added", "Notice", JOptionPane.WARNING_MESSAGE);
            ActManager.addNews("New receptionist has been added: "+NameTextField.getText());
        }
        else if (optionsComboBox.getSelectedItem().toString().contains("Add Manager"))
        {
            ActManager.addNewEmployee(true,NameTextField.getText(),userNameTextField.getText(),passwordTextField.getText());
            JOptionPane.showMessageDialog(null, "New manager has been added", "Notice", JOptionPane.WARNING_MESSAGE);
            ActManager.addNews("New manager has been added: "+NameTextField.getText());
        }
        else if(optionsComboBox.getSelectedItem().toString().contains("Remove Receptionist")) {
            ActManager.deleteUserFromFile(ActManager.getUserNameSubString(recepComboBox.getSelectedItem().toString()),false);
            JOptionPane.showMessageDialog(null, "Receptionist has been removed", "Notice", JOptionPane.WARNING_MESSAGE);
        }
        else if(optionsComboBox.getSelectedItem().toString().contains("Remove Manager")) {
            ActManager.deleteUserFromFile(ActManager.getUserNameSubString(managerComboBox.getSelectedItem().toString()),true);
            JOptionPane.showMessageDialog(null, "Manager has been removed", "Notice", JOptionPane.WARNING_MESSAGE);
        }
        else if(optionsComboBox.getSelectedItem().toString().contains("Add Rooms"))
        {
            int roomsAmount=(Integer) roomsSpinner.getValue();
            String roomType=roomTypeComboBox.getSelectedItem().toString();
            ActManager.changeRoomsAmount(roomType, roomsAmount);
            JOptionPane.showMessageDialog(null, roomsAmount+" "+roomType+" rooms has been added", "Notice", JOptionPane.WARNING_MESSAGE);
            ActManager.addNews(roomsAmount+" "+roomType+" rooms has been added");

        }
        else if(optionsComboBox.getSelectedItem().toString().contains("Remove Rooms"))
        {
            int roomsAmount=((Integer) roomsSpinner.getValue())*(-1);
            String roomType=roomTypeComboBox.getSelectedItem().toString();
            ActManager.changeRoomsAmount(roomType, roomsAmount);
            roomsAmount*=(-1);
            JOptionPane.showMessageDialog(null, roomsAmount+" "+roomType+" rooms has been removed", "Notice", JOptionPane.WARNING_MESSAGE);
        }
        ActManager.actionScreen.dispose();
        ActManager.actionScreen=new ManagerOptionsScreen();
        ActManager.actionScreen.setVisible(true);
    }
    private void optionsComboBoxactionPerformed() throws IOException {
        setVislbeComponents();
    }
    private void roomTypeComboBoxactionPerformed() {
        setVislbeComponents();
    }
    private int  getMax(String roomType)
    {
        int max=0;
        List<String> availableRooms= ActManager.readLinesFromFile("src\\HotelData");
        if(roomTypeComboBox.getSelectedItem().toString().contains("Twin")) {
            max=Integer.parseInt(availableRooms.get(0));
        }
        else if(roomTypeComboBox.getSelectedItem().toString().contains("Family")) {
            max=Integer.parseInt(availableRooms.get(1));
        }
        else if(roomTypeComboBox.getSelectedItem().toString().contains("Deluxe")) {
            max=Integer.parseInt(availableRooms.get(2));
        }
        else if(roomTypeComboBox.getSelectedItem().toString().contains("Premium")) {
            max=Integer.parseInt(availableRooms.get(3));
        }
        else if(roomTypeComboBox.getSelectedItem().toString().contains("Suite")) {
            max=Integer.parseInt(availableRooms.get(4));
        }

        return max;
    }
    private void setVislbeComponents() {
        if(optionsComboBox.getSelectedItem().toString().contains("Receptionist")||optionsComboBox.getSelectedItem().toString().contains("Manager")) {
            roomTypeComboBox.setVisible(false);
            roomsSpinner.setVisible(false);
            if(optionsComboBox.getSelectedItem().toString().contains("Remove"))
            {
                receptionistNameLabel.setVisible(false);
                NameTextField.setVisible(false);
                receptionistUserNameLabel.setVisible(false);
                userNameTextField.setVisible(false);
                receptionistPasswordLabel.setVisible(false);
                passwordTextField.setVisible(false);
                if(optionsComboBox.getSelectedItem().toString().contains("Manager")) {
                    recepComboBox.setVisible((false));
                    managerComboBox.setVisible(true);
                }
                else
                {
                    managerComboBox.setVisible(false);
                    recepComboBox.setVisible((true));
                }
            }
            else
            {
            receptionistNameLabel.setVisible(true);
            NameTextField.setVisible(true);
            receptionistUserNameLabel.setVisible(true);
            userNameTextField.setVisible(true);
            receptionistPasswordLabel.setVisible(true);
            passwordTextField.setVisible(true);
            managerComboBox.setVisible(false);
            recepComboBox.setVisible((false));
            }
        }
        else
        {
            SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0,0,null,1);
            roomsSpinner.setModel(spinnerModel);
            if(optionsComboBox.getSelectedItem().toString().contains("Remove"))
            {
                spinnerModel.setMaximum(getMax(roomTypeComboBox.getSelectedItem().toString()));
                roomsSpinner.setModel(spinnerModel);
            }
            receptionistNameLabel.setVisible(false);
            NameTextField.setVisible(false);
            receptionistUserNameLabel.setVisible(false);
            userNameTextField.setVisible(false);
            receptionistPasswordLabel.setVisible(false);
            passwordTextField.setVisible(false);
            roomTypeComboBox.setVisible(true);
            roomsSpinner.setVisible(true);
            managerComboBox.setVisible(false);
            recepComboBox.setVisible((false));
        }
    }
    private void initComponents() throws IOException {
        this.setDefaultCloseOperation(0);
        String[] optionsString = { "Choose:","Add Receptionist", "Remove Receptionist","Add Manager", "Remove Manager", "Add Rooms", "Remove Rooms"};
        optionsComboBox = new JComboBox(optionsString);
        String[] roomsString = { "Twin","Family", "Deluxe", "Premium", "Suite"};
        roomTypeComboBox =new JComboBox(roomsString);
        String[] managersString = ActManager.getUsers(true);
        managerComboBox =new JComboBox(managersString);
        String[] receptionistsString = ActManager.getUsers(false);
        recepComboBox =new JComboBox(receptionistsString);
        managerOptionsLabel = new JLabel();
        backButton = new JButton();
        confirmButton = new JButton();
        backgroundLabel = new JLabel();
        receptionistNameLabel=new JLabel();
        receptionistUserNameLabel=new JLabel();
        receptionistPasswordLabel =new JLabel();
        NameTextField = new JFormattedTextField();
        userNameTextField=new JFormattedTextField();
        passwordTextField=new JFormattedTextField();
        roomsSpinner = new JSpinner();
        //======== this ========
        setResizable(false);
        setTitle("Manager Options");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- optionsComboBox ----
        optionsComboBox.setBackground(Color.white);
        optionsComboBox.setForeground(Color.black);
        optionsComboBox.setFont(optionsComboBox.getFont().deriveFont(optionsComboBox.getFont().getStyle() | Font.BOLD));
        contentPane.add(optionsComboBox);
        optionsComboBox.setBounds(180, 140, 480, 30);
        optionsComboBox.addActionListener(e -> {
            try {
                optionsComboBoxactionPerformed();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        //---- roomTypeComboBox ----
        roomTypeComboBox.setBackground(Color.white);
        roomTypeComboBox.setForeground(Color.black);
        roomTypeComboBox.setFont(roomTypeComboBox.getFont().deriveFont(roomTypeComboBox.getFont().getStyle() | Font.BOLD));
        contentPane.add(roomTypeComboBox);
        roomTypeComboBox.setBounds(225, 225, 150, 30);
        roomTypeComboBox.setVisible(false);
        roomTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomTypeComboBoxactionPerformed();
            }
        });
        //---- managerComboBox ----
        managerComboBox.setBackground(Color.white);
        managerComboBox.setForeground(Color.black);
        managerComboBox.setFont(managerComboBox.getFont().deriveFont(managerComboBox.getFont().getStyle() | Font.BOLD));
        contentPane.add(managerComboBox);
        managerComboBox.setBounds(165, 225, 500, 30);
        managerComboBox.setVisible(false);
        managerComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomTypeComboBoxactionPerformed();
            }
        });
        //---- managerComboBox ----
        recepComboBox.setBackground(Color.white);
        recepComboBox.setForeground(Color.black);
        recepComboBox.setFont(recepComboBox.getFont().deriveFont(recepComboBox.getFont().getStyle() | Font.BOLD));
        contentPane.add(recepComboBox);
        recepComboBox.setBounds(165, 225, 500, 30);
        recepComboBox.setVisible(false);
        recepComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomTypeComboBoxactionPerformed();
            }
        });
        //---- roomsSpinner ----
        contentPane.add(roomsSpinner);
        roomsSpinner.setBounds(455, 225, 50, 30);
        roomsSpinner.setVisible(false);
        //---- managerOptionsLabel ----
        managerOptionsLabel.setText("Manager Options:");
        managerOptionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        managerOptionsLabel.setFont(managerOptionsLabel.getFont().deriveFont(managerOptionsLabel.getFont().getStyle() | Font.BOLD, managerOptionsLabel.getFont().getSize() + 25f));
        managerOptionsLabel.setForeground(Color.white);
        contentPane.add(managerOptionsLabel);
        managerOptionsLabel.setBounds(235, 60, 355, 50);

        //---- backButton ----
        backButton.setText("Back");
        contentPane.add(backButton);
        backButton.setBounds(new Rectangle(new Point(705, 415), backButton.getPreferredSize()));
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backButtonMouseClicked();
            }
        });

        //---- confirmButton ----
        confirmButton.setText("Confirm");
        confirmButton.setFont(confirmButton.getFont().deriveFont(confirmButton.getFont().getStyle() | Font.BOLD, confirmButton.getFont().getSize() + 7f));
        confirmButton.setForeground(new Color(0, 180, 80));
        contentPane.add(confirmButton);
        confirmButton.setBounds(320, 330, 165, 55);
        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    confirmButtonMouseClicked();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //---- receptionistNameLabel ----
        receptionistNameLabel.setText("Name:");
        contentPane.add(receptionistNameLabel);
        receptionistNameLabel.setBounds(200, 190, 50, 30);
        receptionistNameLabel.setOpaque(true);
        receptionistNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        receptionistNameLabel.setForeground(Color.white);
        receptionistNameLabel.setBackground(Color.black);
        receptionistNameLabel.setVisible(false);
        //---- NameTextField ----
        contentPane.add(NameTextField);
        NameTextField.setBounds(335, 190, 250, 30);
        NameTextField.setOpaque(true);
        NameTextField.setFont(new Font("Segoe UI", Font.BOLD, 12));
        NameTextField.setVisible(false);

        //---- receptionistUserNameLabel ----
        receptionistUserNameLabel.setText("User Name:");
        contentPane.add(receptionistUserNameLabel);
        receptionistUserNameLabel.setBounds(200, 225, 75, 30);
        receptionistUserNameLabel.setOpaque(true);
        receptionistUserNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        receptionistUserNameLabel.setForeground(Color.white);
        receptionistUserNameLabel.setBackground(Color.black);
        receptionistUserNameLabel.setVisible(false);

        //---- userNameTextField ----
        contentPane.add(userNameTextField);
        userNameTextField.setBounds(335, 225, 250, 30);
        userNameTextField.setOpaque(true);
        userNameTextField.setFont(new Font("Segoe UI", Font.BOLD, 12));
        userNameTextField.setVisible(false);

        //---- receptionistPasswordLabel ----
        receptionistPasswordLabel.setText("User Password:");
        contentPane.add(receptionistPasswordLabel);
        receptionistPasswordLabel.setBounds(200, 260, 90, 30);
        receptionistPasswordLabel.setOpaque(true);
        receptionistPasswordLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        receptionistPasswordLabel.setForeground(Color.white);
        receptionistPasswordLabel.setBackground(Color.black);
        receptionistPasswordLabel.setVisible(false);

        //---- passwordTextField ----
        contentPane.add(passwordTextField);
        passwordTextField.setBounds(335, 260, 250, 30);
        passwordTextField.setOpaque(true);
        passwordTextField.setFont(new Font("Segoe UI", Font.BOLD, 12));
        passwordTextField.setVisible(false);

        //---- backgroundLabel ----
        backgroundLabel.setText("text");
        backgroundLabel.setIcon(new ImageIcon(getClass().getResource("/RequestsScreenBackground.png")));
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

    private JComboBox optionsComboBox;
    private JComboBox roomTypeComboBox;
    private JComboBox managerComboBox;
    private JComboBox recepComboBox;
    private JLabel managerOptionsLabel;
    private JButton backButton;
    private JButton confirmButton;
    private JLabel backgroundLabel;
    private JLabel receptionistNameLabel;
    private JLabel receptionistUserNameLabel;
    private JLabel receptionistPasswordLabel;
    private JFormattedTextField NameTextField;
    private JFormattedTextField userNameTextField;
    private JFormattedTextField passwordTextField;
    private JSpinner roomsSpinner;
}
