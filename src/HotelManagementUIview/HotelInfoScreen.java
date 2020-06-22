
package HotelManagementUIview;

import HotelManagementController.ActManager;
import HotelManagementController.Program;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDate;
import javax.swing.*;

/**
 * @author Ehud
 */
public class HotelInfoScreen extends JFrame {
    public HotelInfoScreen() throws IOException {
        initComponents();
    }
    private void backButtonMouseClicked() {
        ActManager.baseScreen.setEnabled(true);
        ActManager.actionScreen.dispose();
    }
    private void initComponents() throws IOException {
        this.setDefaultCloseOperation(0);
        capacityLabel = new JLabel();
        dateLabel = new JLabel();
        capacityValueLabel = new JLabel();
        backButton = new JButton();
        backgroundLabel = new JLabel();
        dateDaySpinner = new JSpinner();
        dateYearSpinner = new JSpinner();
        dateMonthSpinner = new JSpinner();
        //======== this ========
        setResizable(false);
        setTitle("Hotel Info");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- capacityLabel ----
        capacityLabel.setText("Capacity:");
        capacityLabel.setHorizontalAlignment(SwingConstants.CENTER);
        capacityLabel.setFont(capacityLabel.getFont().deriveFont(capacityLabel.getFont().getStyle() | Font.BOLD,35));
        capacityLabel.setForeground(Color.white);
        contentPane.add(capacityLabel);
        capacityLabel.setBounds(85, 50, 200, 45);
        //---- dateLabel ----
        dateLabel.setText("Date:");
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setFont(dateLabel.getFont().deriveFont(dateLabel.getFont().getStyle() | Font.BOLD,35));
        dateLabel.setForeground(Color.white);
        contentPane.add(dateLabel);
        dateLabel.setBounds(415, 50, 145, 45);

        //---- capacityValueLabel ----
        capacityValueLabel.setText(ActManager.getCapacity(LocalDate.now())+"%");
        capacityValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        capacityValueLabel.setFont(capacityValueLabel.getFont().deriveFont(capacityValueLabel.getFont().getStyle() | Font.BOLD,55));
        capacityValueLabel.setForeground(new Color(126, 255, 0));
        contentPane.add(capacityValueLabel);
        capacityValueLabel.setBounds(110, 80, 145, 145);
        //---- dateMonthSpinner ----
        dateMonthSpinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
        contentPane.add(dateMonthSpinner);
        dateMonthSpinner.setBounds(455, 140, 65, 25);

        //---- dateDaySpinner ----
        dateDaySpinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
        contentPane.add(dateDaySpinner);
        dateDaySpinner.setBounds(390, 140, 45, 25);

        //---- checkIInYearSpinner3 ----
        dateYearSpinner.setModel(new SpinnerNumberModel(2020, 2020, 2100, 1));
        contentPane.add(dateYearSpinner);
        dateYearSpinner.setBounds(540, 140, 60, 25);

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

        ActManager.refreshDate(LocalDate.now(),dateDaySpinner,dateMonthSpinner,dateYearSpinner);
        dateYearSpinner.addChangeListener(e -> {
            try {
                dateChange();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        dateDaySpinner.addChangeListener(e -> {
            try {
                dateChange();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        dateMonthSpinner.addChangeListener(e -> {
            try {
                dateChange();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
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

    private void dateChange() throws IOException {
        LocalDate date =LocalDate.of((Integer) dateYearSpinner.getValue(),(Integer)dateMonthSpinner.getValue(),(Integer) dateDaySpinner.getValue());
        capacityValueLabel.setText(ActManager.getCapacity(date) +"%");
        capacityValueLabel.setForeground(new Color(126, 255, 0));
        if(ActManager.getCapacity(date)>=30) {
            capacityValueLabel.setForeground(new Color(255, 230, 0));
            if(ActManager.getCapacity(date)>=50) {
                capacityValueLabel.setForeground(new Color(255, 154, 0));
                if(ActManager.getCapacity(date)>=75) {
                    capacityValueLabel.setForeground(new Color(238, 98, 0));
                        if(ActManager.getCapacity(date)>=90) {
                              capacityValueLabel.setForeground(new Color(255, 0, 0));
                    }
                }
            }
        }
    }

    private JLabel capacityLabel;
    private JLabel dateLabel;
    private JLabel capacityValueLabel;
    private JButton backButton;
    private JLabel backgroundLabel;
    private JSpinner dateMonthSpinner;
    private JSpinner dateDaySpinner;
    private JSpinner dateYearSpinner;
}
