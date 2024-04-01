package View.Booking;

import javax.swing.*;
import java.awt.*;

public class AddPanelBooking extends JPanel {
    JTextField txt_t_temp;
    JTextField txt_c_temp;
    JTextField txt_booking_date;
    JTextField txt_booking_time;
    JTextField txt_Booking_fees;
    JButton addBookingBtn;

    public AddPanelBooking()
    {
        txt_t_temp = new JTextField();
        txt_c_temp = new JTextField();
        txt_booking_date = new JTextField();
        txt_booking_time = new JTextField();

        txt_Booking_fees = new JTextField();

        addBookingBtn = new JButton("Add Booking");

        txt_t_temp.setText("Tourist Id");
        txt_c_temp.setText("City Id");
        txt_booking_date.setText("Booking Date");
        txt_booking_time.setText("Booking Time");
        txt_Booking_fees.setText("Booking Fees");
        Color color1 = new Color(181,128,242);
        addBookingBtn.setBackground(color1);


        add(txt_t_temp);
        add(txt_c_temp);
        add(txt_booking_date);
        add(txt_booking_time);
        add(txt_Booking_fees);

        add(addBookingBtn);
    }

    public void setAddBookingBtn(JButton addBookingBtn) {
        this.addBookingBtn = addBookingBtn;
    }

    public void setTxt_Booking_fees(JTextField txt_Booking_fees) {
        this.txt_Booking_fees = txt_Booking_fees;
    }

    public void setTxt_t_temp(JTextField txt_t_temp) {
        this.txt_t_temp = txt_t_temp;
    }

    public void setTxt_booking_date(JTextField txt_booking_date) {
        this.txt_booking_date = txt_booking_date;
    }

    public void setTxt_booking_time(JTextField txt_booking_time) {
        this.txt_booking_time = txt_booking_time;
    }

    public JTextField getTxt_booking_time() {
        return txt_booking_time;
    }

    public void setTxt_c_temp(JTextField txt_c_temp ){
        this.txt_c_temp = txt_c_temp;
    }


    public JTextField getTxt_t_temp() {
        return txt_t_temp;
    }

    public JTextField getTxt_c_temp() {
        return txt_c_temp;
    }

    public JTextField getTxt_booking_date() {
        return txt_booking_date;
    }

    public JTextField getTxt_Booking_fees() {
        return txt_Booking_fees;
    }

    public JButton getAddBookingBtn() {
        return addBookingBtn;
    }
}
