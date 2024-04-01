package View.Booking;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BookingTablePanel extends JPanel {

    ArrayList<JButton> booking_buttons = new ArrayList<>();

    public BookingTablePanel()
    {
        super();
    }

    public void createButtons(int count)
    {
        for (int i = 1; i <= count; i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.decode("9936379"));
            b.setForeground(Color.decode("0"));

            b.setSize(500,60);

            booking_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }

    }

    public void setButtonText(int button_no, String button_text) {
        booking_buttons.get(button_no).setText(button_text);
    }

    public ArrayList<JButton> getAllButtons()
    {
        return booking_buttons;
    }

}
