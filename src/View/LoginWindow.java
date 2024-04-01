package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private FirstFrame parentFrame;

    public LoginWindow(FirstFrame parentFrame) {
        super("Login");

        this.parentFrame = parentFrame;

        // Initialize components
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);

        loginButton.setSize(50,20);

        // Set layout
        JPanel loginPanel = new JPanel();
       // loginPanel.setLayout(new GridLayout(3, 1));
        loginPanel.setBackground(Color.decode("9940975"));
        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginButton.setBackground(Color.decode("9952239"));
        loginButton.setForeground(Color.BLACK);
        loginPanel.add(loginButton);

        // Add action listener to login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());

                // For demonstration, let's assume login is successful if username and password are not empty
                if (("".equals(username) && "".equals(password))||"richard".equals(username)&& "joseph".equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    parentFrame.showMainFrame(); // Show the main frame after successful login
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                }
            }
        });

        // Add login panel to the frame
        add(loginPanel);

        // Set frame properties
        pack();
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
}
}