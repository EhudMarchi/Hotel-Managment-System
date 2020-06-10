package HotelManagementUIview;

import HotelManagementController.ActManager;
import HotelManagementController.Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ViewReservationDetailsScreen extends JFrame {

    public ViewReservationDetailsScreen() throws IOException {
        initComponents();
    }
    private void backButtonMouseClicked() {
        Program.baseScreen.setEnabled(true);
        Program.actionScreen.dispose();
    }
    private void resNumComboBoxactionPerformed() throws IOException {
        descriptionLabel.setText("<html>"+ActManager.ReadReservationLineFromFile(resNumComboBox.getSelectedItem().toString(),"src\\ReservationsData"));
    }
    private void initComponents() throws IOException {
        resNumComboBox = new JComboBox(ActManager.ReadReservationsNumber(resNumComboBox));
        reservatioLabel = new JLabel();
        backButton = new JButton();
        descriptionLabel = new JLabel();
        backgroundLabel = new JLabel();

        //======== this ========
        setResizable(false);
        setTitle("View Reservation Details");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- comboBox1 ----
        resNumComboBox.setBackground(Color.white);
        resNumComboBox.setForeground(Color.black);
        resNumComboBox.setFont(resNumComboBox.getFont().deriveFont(resNumComboBox.getFont().getStyle() | Font.BOLD));
        contentPane.add(resNumComboBox);
        resNumComboBox.setBounds(70, 120, 145, resNumComboBox.getPreferredSize().height);
        resNumComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    resNumComboBoxactionPerformed();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //---- reservatioLabel ----
        reservatioLabel.setText("Reservation Number:");
        reservatioLabel.setHorizontalAlignment(SwingConstants.CENTER);
        reservatioLabel.setFont(reservatioLabel.getFont().deriveFont(reservatioLabel.getFont().getStyle() | Font.BOLD));
        reservatioLabel.setForeground(Color.white);
        reservatioLabel.setOpaque(true);
        reservatioLabel.setBackground(Color.black);
        contentPane.add(reservatioLabel);
        reservatioLabel.setBounds(75, 90, 145, 25);
        //--------descriptionLabel--------
        descriptionLabel.setOpaque(true);
        descriptionLabel.setBackground(Color.black);
        descriptionLabel.setForeground(Color.white);
        descriptionLabel.setFont(descriptionLabel.getFont().deriveFont(descriptionLabel.getFont().getStyle() | Font.BOLD,14));
        contentPane.add(descriptionLabel);
        descriptionLabel.setBounds(250, 30, 430, 190);

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
    private JButton backButton;
    private JLabel backgroundLabel;
    private JLabel descriptionLabel;
}
