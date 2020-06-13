package HotelManagementUIview;

import HotelManagementController.ActManager;
import HotelManagementController.Program;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.*;

/**
 * @author Ehud
 */
public class RequestsScreen extends JFrame {
    public RequestsScreen() throws IOException {
        initComponents();
    }
    private void backButtonMouseClicked() {
        ActManager.baseScreen.setVisible(true);
        ActManager.actionScreen.dispose();
    }
    private void declineButtonMouseClicked() throws IOException {
        if (!requestsComboBox.getSelectedItem().toString().equals("")){
            ActManager.deleteLineFromFile(requestsComboBox.getSelectedItem().toString(), "src\\Requests");
        JOptionPane.showMessageDialog(null, "You declined request!",
                "Notice", JOptionPane.WARNING_MESSAGE);
        ActManager.addNews("Request: "+requestsComboBox.getSelectedItem().toString()+" -<small>Declined</small>");
    }
    }
    private void confirmButtonMouseClicked() throws IOException {
        if (!requestsComboBox.getSelectedItem().toString().equals("")) {
            ActManager.deleteLineFromFile(requestsComboBox.getSelectedItem().toString(), "src\\Requests");
            JOptionPane.showMessageDialog(null, "You confirmed request!",
                    "Notice", JOptionPane.WARNING_MESSAGE);
            if (requestsComboBox.getSelectedItem().toString().contains("Cancel")) {
                ActManager.deleteReservationFromFile(ActManager.getReservationNumberSubString(requestsComboBox.getSelectedItem().toString()));
                JOptionPane.showMessageDialog(null, "Reservation cancelled!",
                        "Notice", JOptionPane.WARNING_MESSAGE);
            } else {
                //change reservation
            }
            ActManager.addNews("Request: "+requestsComboBox.getSelectedItem().toString()+" -<small>Confirmed</small>");
        }
    }

    private void initComponents() throws IOException {
        this.setDefaultCloseOperation(0);
        requestsComboBox = new JComboBox(ActManager.ReadRequests(requestsComboBox));
        requestsLabel = new JLabel();
        backButton = new JButton();
        confirmButton = new JButton();
        declineButton = new JButton();
        backgroundLabel = new JLabel();

        //======== this ========
        setResizable(false);
        setTitle("Requests");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- requestsComboBox ----
        requestsComboBox.setBackground(Color.white);
        requestsComboBox.setForeground(Color.black);
        requestsComboBox.setFont(requestsComboBox.getFont().deriveFont(requestsComboBox.getFont().getStyle() | Font.BOLD));
        contentPane.add(requestsComboBox);
        requestsComboBox.setBounds(180, 175, 480, 30);

        //---- requestsLabel ----
        requestsLabel.setText("Requests:");
        requestsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        requestsLabel.setFont(requestsLabel.getFont().deriveFont(requestsLabel.getFont().getStyle() | Font.BOLD, requestsLabel.getFont().getSize() + 25f));
        requestsLabel.setForeground(Color.white);
        contentPane.add(requestsLabel);
        requestsLabel.setBounds(235, 60, 355, 50);

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
        confirmButton.setBounds(225, 310, 165, 55);
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
        //---- declineButton ----
        declineButton.setText("Decline");
        declineButton.setFont(declineButton.getFont().deriveFont(declineButton.getFont().getStyle() | Font.BOLD, declineButton.getFont().getSize() + 7f));
        declineButton.setForeground(new Color(200, 0, 0));
        contentPane.add(declineButton);
        declineButton.setBounds(455, 310, 165, 55);
        declineButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    declineButtonMouseClicked();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

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
    private JComboBox requestsComboBox;
    private JLabel requestsLabel;
    private JButton backButton;
    private JButton confirmButton;
    private JButton declineButton;
    private JLabel backgroundLabel;
}
