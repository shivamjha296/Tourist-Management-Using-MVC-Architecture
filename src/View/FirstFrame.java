package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FirstFrame extends JFrame {
    private JButton manageTouristBtn;
    private JButton manageCityBtn;
    private JButton manageBookingBtn;
    private JPanel firstPanel;
    private LoginWindow log;
    private View view;

    public FirstFrame() {
        super("Main Dashboard");
        log = new LoginWindow(this);

        manageTouristBtn = new JButton("Manage Tourist");
        manageCityBtn = new JButton("Manage City");
        manageBookingBtn = new JButton("Manage Booking");

        firstPanel = new JPanel(null); // Use null layout
        JLabel title = new JLabel("G2S2 TOURS AND TRAVELS",SwingConstants.CENTER);
        Border border = BorderFactory.createLineBorder(Color.BLACK,7);
        Border border1 = BorderFactory.createLineBorder(Color.blue,7);
        title.setBorder(border);
        title.setFont(new Font("Times New Roman",Font.BOLD,32));

        // Load and set the background image
        ImageIcon backgroundImage = new ImageIcon("src/View/Photu.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        setContentPane(backgroundLabel);
        manageCityBtn.setFont(new Font("Sans Serif",Font.BOLD,15));
        manageTouristBtn.setFont(new Font("Sans Serif",Font.BOLD,15));
        manageBookingBtn.setFont(new Font("Sans Serif",Font.BOLD,15));
        Color c= new Color(164,246,216);
        // Set bounds for buttons
        title.setBounds(550,50,500,50);
        manageTouristBtn.setBounds(700, 300, 200, 50);
        manageBookingBtn.setBackground(c);
        manageCityBtn.setBounds(700, 400, 200, 50);
        manageTouristBtn.setBackground(c);
        manageBookingBtn.setBounds(700, 500, 200, 50);
        setBackground(Color.decode("16182407"));
        manageCityBtn.setBackground(c);

        add(title);
        // Add buttons to the content pane
        add(manageTouristBtn);
        add(manageCityBtn);
        add(manageBookingBtn);

        pack();
        setSize(500, 600); // Set initial frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Add component listener to resize the background image when frame size changes
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                backgroundLabel.setSize(getWidth(), getHeight());
            }
        });
    }








    public void setFirstPanel(JPanel firstPanel) {
        this.firstPanel = firstPanel;
    }

    public void setManageTouristBtn(JButton manageTouristBtn) {
        this.manageTouristBtn = manageTouristBtn;
    }

    public void setManageCityBtn(JButton manageCityBtn) {
        this.manageCityBtn = manageCityBtn;
    }

    public void setManageBookingBtn(JButton manageBookingBtn) {
        this.manageBookingBtn = manageBookingBtn;
    }

    public JPanel getFirstPanel() {
        return firstPanel;
    }

    public JButton getManageTouristBtn() {
        return manageTouristBtn;
    }

    public JButton getManageCityBtn() {
        return manageCityBtn;
    }
    public void showMainFrame() {
        setVisible(true); // Make the main frame visible after a successful login
    }
    public JButton getManageBookingBtn() {
        return manageBookingBtn;
}
}