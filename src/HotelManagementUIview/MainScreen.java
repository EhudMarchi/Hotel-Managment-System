
package HotelManagementUIview;
import java.awt.event.*;

import HotelManagementController.ActManager;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.TimerTask;
import javax.swing.*;

/**
 * @author Ehud
 */
public class MainScreen extends JFrame {//Singelton Design Pettern
    private static MainScreen single_instance=null;
    TimerTask newsScroller = new TimerTask() {
        int runTimes=0;
        @Override
        public void run() {
            if(ActManager.countOccurences(newsLabel.getText(),'>')>46)
            {
                newsData=ActManager.readLinesFromFile("src\\News")+"<html>";
                if(newsData.length()>10)
                {
                    newsLabel.setText("<html>"+newsData);
                }
                else
                {
                    newsLabel.setText("");
                }
            }
            newsLabel.setText("<html><br>"+newsLabel.getText());
            runTimes++;
            if(runTimes>80)
            {
                try {
                    ActManager.deleteLastNews();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                newsData=ActManager.readLinesFromFile("src\\News")+"<html>";
                newsLabel.setText("<html>"+newsData);
                runTimes=0;
            }
        }
    };
    Timer timer = new Timer(800, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            newsScroller.run();
        }
    });
    public static MainScreen MainScreen(String name,boolean isManager) {
        if (single_instance == null)
        {
            single_instance = new MainScreen(name,isManager);
        }
        return single_instance;
    }
    @Override
    public void dispose()
    {
        timer.stop();
        super.dispose();
        System.out.println("The only main screen has been deleted");
    }

    MainScreen(String name, boolean isManager)
    {

        initComponents();
        recepName = name;
        managerMode=isManager;
        if(managerMode) {
            modeLabel.setText("Manager: ");
            requestsButton.setEnabled(true);
            managerOptionsButton.setEnabled(true);
        }
        modeLabel.setText((modeLabel.getText()+name));
        timer.start();
        System.out.println("A single main screen has been created");
    }
    private void createReservationButtonMouseClicked() throws IOException, ParseException {
        ActManager.actionScreen=new ReservationCreationScreen(recepName);
        ActManager.actionScreen.setVisible(true);
        ActManager.baseScreen.setVisible(false);
    }
    private void requestsButtonMouseClicked() throws IOException {
        if(managerMode)
        {
            this.setVisible(false);
            ActManager.actionScreen=new RequestsScreen();
            ActManager.actionScreen.setVisible(true);
    }
    }
    private void cancelReservationButtonMouseClicked() throws IOException {
        ActManager.baseScreen.setEnabled(false);
        ActManager.actionScreen=new CancelScreen();
        ActManager.actionScreen.setVisible(true);
    }
    private void viewReservationDetailsButtonMouseClicked() throws IOException {
        ActManager.baseScreen.setEnabled(false);
        ActManager.actionScreen=new ViewReservationDetailsScreen();
        ActManager.actionScreen.setVisible(true);
    }
    private void logoutButtonMouseClicked() {
        this.dispose();
        ActManager.baseScreen=new LoginScreen();
        ActManager.baseScreen.setVisible(true);
    }
    private void changeReservationButtonMouseClicked() throws IOException {
        ActManager.baseScreen.setEnabled(false);
        ActManager.actionScreen=new ChangeScreen();
        ActManager.actionScreen.setVisible(true);
    }
    private void managerOptionsMouseClicked() throws IOException {
        if(managerMode)
        {
            this.setVisible(false);
            ActManager.actionScreen=new ManagerOptionsScreen();
            ActManager.actionScreen.setVisible(true);
        }
    }

    private void initComponents() {
        this.setDefaultCloseOperation(0);
        createReservationButton = new JButton();
        changeReservationButton = new JButton();
        cancelReservationButton = new JButton();
        viewReservationDetailsButton = new JButton();
        logoutButton = new JButton();
        modeLabel = new JLabel();
        newsLabel = new JLabel();
        newsHeadLineLabel = new JLabel();
        requestsButton = new JButton();
        label1 = new JLabel();
        backgroundLabel = new JLabel();
        managerOptionsButton =new JButton();

        //======== this ========
        setResizable(false);
        setTitle("MainScreen");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- createReservationButton ----
        createReservationButton.setText("Create Reservation");
        createReservationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    createReservationButtonMouseClicked();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });
        contentPane.add(createReservationButton);
        createReservationButton.setBounds(265, 120, 295, 70);
        createReservationButton.setFont(createReservationButton.getFont().deriveFont(createReservationButton.getFont().getStyle() | Font.BOLD,20));

        //---- changeReservationButton ----
        changeReservationButton.setText("Change Reservation");
        contentPane.add(changeReservationButton);
        changeReservationButton.setBounds(265, 200, 295, 30);
        changeReservationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    changeReservationButtonMouseClicked();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //---- cancelReservationButton ----
        cancelReservationButton.setText("Cancel Reservation");
        contentPane.add(cancelReservationButton);
        cancelReservationButton.setBounds(265, 240, 295, 30);
        cancelReservationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    cancelReservationButtonMouseClicked();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //---- cancelReservationButton2 ----
        viewReservationDetailsButton.setText("View Reservation Details");
        contentPane.add(viewReservationDetailsButton);
        viewReservationDetailsButton.setBounds(265, 285, 295, 30);
        viewReservationDetailsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    viewReservationDetailsButtonMouseClicked();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //---- logoutButton ----
        logoutButton.setText("Logout");
        logoutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logoutButtonMouseClicked();
            }
        });
        contentPane.add(logoutButton);
        logoutButton.setBounds(650, 385, 115, 45);
        //---- managerOptionsButton ----
        managerOptionsButton.setText("Manager Options");
        managerOptionsButton.setFont(managerOptionsButton.getFont().deriveFont(managerOptionsButton.getFont().getStyle(),10));

        managerOptionsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    managerOptionsMouseClicked();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        contentPane.add(managerOptionsButton);
        managerOptionsButton.setBounds(60, 385, 125, 45);
        managerOptionsButton.setEnabled(false);
        //---- modeLabel ----
        modeLabel.setText("Receptionist: ");
        modeLabel.setForeground(Color.blue);
        contentPane.add(modeLabel);
        modeLabel.setBounds(15, 10, 250, 20);
        //---- newsHeadLineLabel ----
        newsHeadLineLabel.setText("News");
        newsHeadLineLabel.setForeground(Color.blue);
        contentPane.add(newsHeadLineLabel);
        newsHeadLineLabel.setBounds(110, 100, 250, 20);
        //---- newsLabel ----
        newsLabel.setFont(newsLabel.getFont().deriveFont(newsLabel.getFont().getStyle(),9));
        newsLabel.setVerticalAlignment(JLabel.TOP);
        newsData=ActManager.readLinesFromFile("src\\News")+"<html>";
        if(newsData.length()>10)
        {
            newsLabel.setText("<html>"+newsData);
        }
        else
        {
            newsLabel.setText("");
        }
        newsLabel.setOpaque(true);
        newsLabel.setForeground(Color.black);
        newsLabel.setBackground(Color.white);
        contentPane.add(newsLabel);
        newsLabel.setBounds(15, 120, 220, 235);
        //---- requestsButton ----
        requestsButton.setText("Requests");
        requestsButton.setEnabled(false);
        contentPane.add(requestsButton);
        requestsButton.setBounds(265, 325, 295, 30);
        requestsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    requestsButtonMouseClicked();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        //---- label1 ----
        label1.setText("\"Hotel Name\"");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 19f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(215, 25, 385, 65);


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
    private JButton createReservationButton;
    private JButton changeReservationButton;
    private JButton cancelReservationButton;
    private JButton viewReservationDetailsButton;
    private JButton logoutButton;
    private JLabel modeLabel;
    private JLabel newsLabel;
    private JLabel newsHeadLineLabel;
    private JButton requestsButton;
    private JButton managerOptionsButton;
    private JLabel label1;
    private JLabel backgroundLabel;
    private String recepName;
    private boolean managerMode;
    private String newsData;

}
