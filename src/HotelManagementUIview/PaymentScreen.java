package HotelManagementUIview;

import HotelManagementController.ActManager;
import HotelManagementController.Program;
import HotelManagmentModel.Hotel;
import HotelManagmentModel.Reservation;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.LocalDate;
import javax.swing.*;

/**
 * @author Ehud
 */
public class PaymentScreen extends JFrame {
    public PaymentScreen(String reservationDetails,String detailsLine,LocalDate ci,LocalDate co,String price,JLabel rooms) {
        initComponents();
        roomsDescription=rooms;
        dLine=detailsLine;
        checkin=ci;
        checkout=co;
        descriptionLabel.setText(reservationDetails);
        priceLabel.setText(price);
    }
    private void confirmButtonMouseClicked() throws IOException {
        if(ActManager.CreditCardValidation(CreditNumber.getText()))
        {
            ActManager.createReservation(Hotel.numOfReservations,dLine,checkin,checkout,roomsDescription);
            this.dispose();
            Program.actionScreen.dispose();
            Program.baseScreen.setVisible(true);
            JOptionPane.showMessageDialog(null,"Your reservation was successfully added!",
                    "Notice", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid Credit Card!",
                    "Notice", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void backButtonMouseClicked() {
        Program.actionScreen.setVisible(true);
        Program.paymentScreen.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ehud
        CreditNumber = new JTextField();
        descriptionLabel = new JLabel();
        creditCardLabel = new JLabel();
        confirmButton = new JButton();
        backButton = new JButton();
        priceLabel = new JLabel();
        backgroundLabel = new JLabel();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(CreditNumber);
        CreditNumber.setBounds(395, 335, 170, 35);
        setTitle("Payment");
        //---- descriptionLabel ----
        descriptionLabel.setOpaque(true);
        descriptionLabel.setBackground(Color.black);
        descriptionLabel.setForeground(Color.white);
        descriptionLabel.setFont(descriptionLabel.getFont().deriveFont(descriptionLabel.getFont().getStyle() | Font.BOLD,20));
        contentPane.add(descriptionLabel);
        descriptionLabel.setBounds(110, 15, 575, 310);

        //---- creditCardLabel ----
        creditCardLabel.setText("Credit Card:");
        creditCardLabel.setOpaque(true);
        creditCardLabel.setBackground(Color.black);
        creditCardLabel.setFont(creditCardLabel.getFont().deriveFont(creditCardLabel.getFont().getStyle() | Font.BOLD));
        creditCardLabel.setForeground(Color.white);
        contentPane.add(creditCardLabel);
        creditCardLabel.setBounds(310, 335, 70, 40);

        //---- confirmButton ----
        confirmButton.setText("Confirm Puschase");
        confirmButton.setFont(confirmButton.getFont().deriveFont(confirmButton.getFont().getStyle() | Font.BOLD));
        contentPane.add(confirmButton);
        confirmButton.setBounds(320, 385, 195, 45);
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
        backButton.setFont(backButton.getFont().deriveFont(backButton.getFont().getStyle() | Font.BOLD));
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backButtonMouseClicked();
            }
        });
        contentPane.add(backButton);
        backButton.setBounds(675, 425, 100, 30);

        //---- priceLabel ----
        priceLabel.setText("Price: ");
        priceLabel.setOpaque(true);
        priceLabel.setBackground(Color.black);
        priceLabel.setFont(priceLabel.getFont().deriveFont(priceLabel.getFont().getStyle() | Font.BOLD));
        priceLabel.setForeground(Color.green);
        contentPane.add(priceLabel);
        priceLabel.setBounds(320, 435, 195, 26);

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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ehud
    private JTextField CreditNumber;
    private JLabel descriptionLabel;
    private JLabel creditCardLabel;
    private JButton confirmButton;
    private JButton backButton;
    private JLabel priceLabel;
    private JLabel backgroundLabel;
    private  String dLine;
    private LocalDate checkin;
    private LocalDate checkout;
    private JLabel roomsDescription;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
