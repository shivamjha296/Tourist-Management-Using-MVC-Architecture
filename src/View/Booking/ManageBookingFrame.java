package View.Booking;

import javax.swing.*;
import java.awt.*;

public class ManageBookingFrame extends JFrame {
    InitialPanelBooking booking_ip;



    public ManageBookingFrame()
    {
        super("Manage Booking DashBoard");



        booking_ip = new InitialPanelBooking();

        booking_ip.setSize(1000,1000);
        booking_ip.setBackground(Color.decode("14336757"));;



        add(booking_ip);
        pack();
        setSize(500, 600);

    }

    public void setBookingIp(InitialPanelBooking booking_ip) {
        this.booking_ip = booking_ip;
    }

    public InitialPanelBooking getBooking_ip() {
        return booking_ip;
    }
}
