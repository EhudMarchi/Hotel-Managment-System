/*
 * Created by JFormDesigner on Tue Jun 02 18:37:42 IDT 2020
 */

package HotelManagementUIview;

import HotelManagementController.Program;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Ehud
 */
public class PaymentScreen extends JFrame {
    public PaymentScreen() {
        initComponents();
    }

    private void backButtonMouseClicked() {
        Program.actionScreen.setVisible(true);
        Program.paymentScreen.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ehud
        textField1 = new JTextField();
        descriptionLabel = new JLabel();
        creditCardLabel = new JLabel();
        confirmLabel = new JButton();
        backButton = new JButton();
        priceLabel = new JLabel();
        backgroundLabel = new JLabel();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(textField1);
        textField1.setBounds(395, 335, 170, 35);

        //---- descriptionLabel ----
        descriptionLabel.setOpaque(true);
        descriptionLabel.setBackground(Color.black);
        descriptionLabel.setForeground(Color.white);
        descriptionLabel.setFont(descriptionLabel.getFont().deriveFont(descriptionLabel.getFont().getStyle() | Font.BOLD));
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

        //---- confirmLabel ----
        confirmLabel.setText("Confirm Puschase");
        confirmLabel.setFont(confirmLabel.getFont().deriveFont(confirmLabel.getFont().getStyle() | Font.BOLD));
        contentPane.add(confirmLabel);
        confirmLabel.setBounds(320, 385, 195, 45);

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
    private JTextField textField1;
    private JLabel descriptionLabel;
    private JLabel creditCardLabel;
    private JButton confirmLabel;
    private JButton backButton;
    private JLabel priceLabel;
    private JLabel backgroundLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
