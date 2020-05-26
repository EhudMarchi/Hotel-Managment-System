package HotelManagementUIview;
import HotelManagementController.ActManager;
import HotelManagementController.Program;

import javax.swing.JOptionPane;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginScreen extends JFrame {

    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JTextField userNameTextField;
    public JButton getLoginButton() {
        return loginButton;
    }
    private JButton loginButton;
    private JPasswordField passwordTextField;
    private JCheckBox managerCheckBox;

    public LoginScreen() {
        userNameLabel = new JLabel();
        passwordLabel = new JLabel();
        userNameTextField = new JTextField();
        loginButton = new JButton();
        passwordTextField = new JPasswordField();
        managerCheckBox = new JCheckBox();
        //======== this ========
        setBackground(Color.darkGray);
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        this.setResizable(false);
        //---- managerCheckBox ----
        managerCheckBox.setText("as manager");
        contentPane.add(managerCheckBox);
        managerCheckBox.setBounds(515, 340, 100, managerCheckBox.getPreferredSize().height);

        //---- userNameLabel ----
        userNameLabel.setText("Username");
        contentPane.add(userNameLabel);
        userNameLabel.setBounds(170, 105, 60, 30);

        //---- passwordLabel ----
        passwordLabel.setText("Password");
        contentPane.add(passwordLabel);
        passwordLabel.setBounds(170, 170, 60, 30);
        contentPane.add(userNameTextField);
        userNameTextField.setBounds(270, 110, 230, userNameTextField.getPreferredSize().height);

        //---- loginButton ----
        loginButton.setText("Login");
        loginButton.setFont(loginButton.getFont().deriveFont(loginButton.getFont().getStyle() | Font.ITALIC));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    loginButtonMouseClicked();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        contentPane.add(loginButton);
        loginButton.setBounds(190, 310, 280, 85);
        contentPane.add(passwordTextField);
        passwordTextField.setBounds(270, 170, 230, passwordTextField.getPreferredSize().height);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
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
        setLocationRelativeTo(null);
    }

    private void loginButtonMouseClicked() throws IOException {
        String name;
        name = ActManager.login(userNameTextField.getText(), passwordTextField.getText(), managerCheckBox.isSelected());
        if (name == "Not Valid") {
            JOptionPane.showMessageDialog(null,
                    "Username and password are not valid, please try again",
                    "Notice",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            Program.baseScreen = new MainScreen(name, managerCheckBox.isSelected());
            Program.baseScreen.setVisible(true);
            this.dispose();
        }
    }

}







