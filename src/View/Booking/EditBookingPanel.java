package View.Booking;

import javax.swing.*;
import java.awt.*;

public class EditBookingPanel extends JPanel{

        JTextField txt_get_booking_idx;
        JButton getBookingBtn;
        JTextField txt_booking_c_id;
        JTextField txt_booking_t_id;
        JTextField txt_booking_date;
        JTextField txt_booking_time;
        JTextField txt_booking_fees;
        JButton editBookingBtn;

        public EditBookingPanel()
        {

            txt_booking_c_id = new JTextField();
            txt_booking_t_id = new JTextField();
            txt_booking_date = new JTextField();
            txt_booking_time = new JTextField();
            txt_booking_fees = new JTextField();

            editBookingBtn = new JButton("Edit Booking");
            txt_get_booking_idx = new JTextField();

            getBookingBtn = new JButton("Get Booking to Edit");

            txt_booking_c_id.setText("Tourist Id");
            txt_booking_t_id.setText("City Id");
            txt_booking_date.setText("Booking Date");
            txt_booking_time.setText("Booking Time");
            txt_booking_fees.setText("Booking Fees");
            txt_get_booking_idx.setText("Booking Id to get");
            Color color1 = new Color(181,128,242);
            getBookingBtn.setBackground(color1);
            editBookingBtn.setBackground(color1);

            add(txt_get_booking_idx);
            add(getBookingBtn);

            add(txt_booking_t_id);
            add(txt_booking_c_id);
            add(txt_booking_date);
            add(txt_booking_time);
            add(txt_booking_fees);
            add(editBookingBtn);
            txt_booking_c_id.setEditable(false);
            txt_booking_t_id.setEditable(false);
        }

        public JTextField getTxt_booking_c_id() {
            return txt_booking_c_id;
        }

        public JTextField getTxt_booking_t_id() {
            return txt_booking_t_id;
        }

        public JTextField getTxt_booking_fees() {
        return txt_booking_fees;
    }
        public JTextField getTxt_booking_date() {
            return txt_booking_date;
        }

    public JTextField getTxt_booking_time() {
        return txt_booking_time;
    }

    public void setTxt_booking_time(JTextField txt_booking_time) {
        this.txt_booking_time = txt_booking_time;
    }

    public JButton getEditbookingBtn() {
            return editBookingBtn;
        }

        public JTextField getTxt_get_booking_idx() {
            return txt_get_booking_idx;
        }
        public JButton getGetbookingBtn() {
            return getBookingBtn;
        }
        public void setTxt_booking_id(JTextField txt_booking_c_id) {
            this.txt_booking_c_id = txt_booking_c_id;
        }

        public void setTxt_booking_t_id(JTextField txt_booking_t_id) {
            this.txt_booking_t_id = txt_booking_t_id;
        }


    public void setTxt_booking_fees(JTextField txt_booking_fees) {
        this.txt_booking_fees = txt_booking_fees;
    }

    public void setTxt_booking_date(JTextField txt_booking_date) {
            this.txt_booking_date = txt_booking_date;
        }

        public void setEditbookingBtn(JButton editbookingBtn) {
            this.editBookingBtn = editbookingBtn;
        }

    public JButton getEditBookingBtn() {
        return editBookingBtn;
    }

    public void setTxt_get_booking_idx(JTextField txt_get_booking_idx) {
            this.txt_get_booking_idx = txt_get_booking_idx;
        }

        public void setGetBookingBtn(JButton getbookingBtn) {
            this.getBookingBtn = getbookingBtn;
        }

    public JButton getGetBookingBtn() {
        return getBookingBtn;
    }
}


