
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
public class ChangeScreen extends JFrame {
    public ChangeScreen() throws IOException {
        initComponents();
    }
    private void backButtonMouseClicked() {
        ActManager.baseScreen.setEnabled(true);
        ActManager.actionScreen.dispose();
    }
    private void confirmButtonMouseClicked() throws IOException {
        ActManager.addChangeRequest(resNumComboBox.getSelectedItem().toString(),propertyComboBox.getSelectedItem().toString(),reasonComboBox.getSelectedItem().toString());
        System.out.println("Request added: " + resNumComboBox.getSelectedItem().toString()+" "+reasonComboBox.getSelectedItem().toString());
        JOptionPane.showMessageDialog(null,"Your request was successfully sent to the manager!",
                "Notice", JOptionPane.WARNING_MESSAGE);
    }
    private void initComponents() throws IOException {
        this.setDefaultCloseOperation(0);
        resNumComboBox = new JComboBox(ActManager.readReservationsNumber(resNumComboBox));
        reservatioLabel = new JLabel();
        String[] reasonsStrings = { "Illness", "Unsatisfied", "Satisfied", "Bad Weather", "Other" };
        reasonComboBox = new JComboBox(reasonsStrings);
        String[] propertyStrings = { "CheckIn Date", "CheckOut Date", "CheckIn+CheckOut Date", "Rooms Description", "Guests Amount" };
        propertyComboBox = new JComboBox(propertyStrings);
        reasonLabel = new JLabel();
        confirmButton = new JButton();
        backButton = new JButton();
        backgroundLabel = new JLabel();

        //======== this ========
        setResizable(false);
        setTitle("Change");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- comboBox1 ----
        resNumComboBox.setBackground(Color.white);
        resNumComboBox.setForeground(Color.black);
        resNumComboBox.setFont(resNumComboBox.getFont().deriveFont(resNumComboBox.getFont().getStyle() | Font.BOLD));
        contentPane.add(resNumComboBox);
        resNumComboBox.setBounds(80, 60, 145, resNumComboBox.getPreferredSize().height);

        //---- reservatioLabel ----
        reservatioLabel.setText("Reservation Number:");
        reservatioLabel.setHorizontalAlignment(SwingConstants.CENTER);
        reservatioLabel.setFont(reservatioLabel.getFont().deriveFont(reservatioLabel.getFont().getStyle() | Font.BOLD));
        reservatioLabel.setForeground(Color.white);
        reservatioLabel.setOpaque(true);
        reservatioLabel.setBackground(Color.black);
        contentPane.add(reservatioLabel);
        reservatioLabel.setBounds(85, 30, 145, 25);

        //---- comboBox2 ----
        reasonComboBox.setBackground(Color.white);
        reasonComboBox.setForeground(Color.black);
        reasonComboBox.setFont(reasonComboBox.getFont().deriveFont(reasonComboBox.getFont().getStyle() | Font.BOLD));
        contentPane.add(reasonComboBox);
        reasonComboBox.setBounds(310, 60, 365, reasonComboBox.getPreferredSize().height);

        //---- comboBox2 ----
        propertyComboBox.setBackground(Color.white);
        propertyComboBox.setForeground(Color.black);
        propertyComboBox.setFont(propertyComboBox.getFont().deriveFont(propertyComboBox.getFont().getStyle() | Font.BOLD));
        contentPane.add(propertyComboBox);
        propertyComboBox.setBounds(310, 100, 365, propertyComboBox.getPreferredSize().height);

        //---- reasonLabel ----
        reasonLabel.setText("Change Reason:");
        reasonLabel.setHorizontalAlignment(SwingConstants.CENTER);
        reasonLabel.setFont(reasonLabel.getFont().deriveFont(reasonLabel.getFont().getStyle() | Font.BOLD));
        reasonLabel.setForeground(Color.white);
        reasonLabel.setOpaque(true);
        reasonLabel.setBackground(Color.black);
        contentPane.add(reasonLabel);
        reasonLabel.setBounds(425, 35, 145, 25);

        //---- confirmButton ----
        confirmButton.setText("Confirm Request");
        confirmButton.setFont(confirmButton.getFont().deriveFont(confirmButton.getFont().getStyle() | Font.BOLD, confirmButton.getFont().getSize() + 7f));
        confirmButton.setForeground(new Color(51, 51, 51));
        contentPane.add(confirmButton);
        confirmButton.setBounds(210, 155, 275, 65);
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
        //---- backButton ----
        backButton.setText("Back");
        backButton.setForeground(new Color(51, 51, 51));
        contentPane.add(backButton);
        backButton.setBounds(new Rectangle(new Point(580, 245), backButton.getPreferredSize()));
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backButtonMouseClicked();
            }
        });
        //---- backgroundLabel ----
        backgroundLabel.setIcon(new ImageIcon(getClass().getResource("/RequestsScreenBackground.png")));
        contentPane.add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 710, 305);

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

    private JComboBox resNumComboBox;
    private JLabel reservatioLabel;
    private JComboBox reasonComboBox;
    private JComboBox propertyComboBox;
    private JLabel reasonLabel;
    private JButton confirmButton;
    private JButton backButton;
    private JLabel backgroundLabel;
}
