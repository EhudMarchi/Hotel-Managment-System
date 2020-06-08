package HotelManagementUIview;
import HotelManagementController.ActManager;
import HotelManagementController.Program;
import HotelManagmentModel.Hotel;

import javax.swing.JOptionPane;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginScreen extends JFrame {
    private JButton exitButton;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JTextField userNameTextField;

    public JButton getLoginButton() {
        return loginButton;
    }
    private void exitButtonMouseClicked() {
        System.exit(0);
    }


    private JButton loginButton;
    private JPasswordField passwordTextField;
    private JCheckBox managerCheckBox;
    private JLabel loginLabel;

    public LoginScreen() {
        userNameLabel = new JLabel();
        passwordLabel = new JLabel();
        userNameTextField = new JTextField();
        loginButton = new JButton();
        passwordTextField = new JPasswordField();
        managerCheckBox = new JCheckBox();
        loginLabel = new JLabel();
        exitButton = new JButton();
        //======== this ========
        setBackground(Color.darkGray);
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        this.setResizable(false);
        //---- exitButton ----
        exitButton.setText("Exit");
        exitButton.setFont(exitButton.getFont().deriveFont(exitButton.getFont().getStyle() | Font.BOLD));
        contentPane.add(exitButton);
        exitButton.setBounds(new Rectangle(new Point(15, 350), exitButton.getPreferredSize()));
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exitButtonMouseClicked();
            }
        });
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
        //----LoginLabel-----
        loginLabel.setText("Login Label");
        loginLabel.setFont(loginLabel.getFont().deriveFont(loginLabel.getFont().getStyle() | Font.BOLD, loginLabel.getFont().getSize() + 19f));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(loginLabel);
        loginLabel.setBounds(135, 25, 385, 65);
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
            preferredSize.width += insets.right+20;
            preferredSize.height += insets.bottom+20;
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



