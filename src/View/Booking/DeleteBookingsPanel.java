package View.Booking;

import javax.swing.*;
import java.awt.*;

public class DeleteBookingsPanel extends JPanel {

    JTextField txt_del_booking_id;
    JButton deleteBookingBtn;

    public DeleteBookingsPanel()
    {

        txt_del_booking_id = new JTextField();
        deleteBookingBtn = new JButton("Delete Booking");

        txt_del_booking_id.setText("Booking Id to Delete");
        Color color1 = new Color(181,128,242);
        deleteBookingBtn.setBackground(color1);

        add(txt_del_booking_id);
        add(deleteBookingBtn);
    }

    public JButton getDeleteBookingBtn() {
        return deleteBookingBtn;
    }

    public JTextField getTxt_del_booking_id() {
        return txt_del_booking_id;
    }

    public void setDeleteBookingBtn(JButton deleteBookingBtn) {
        this.deleteBookingBtn = deleteBookingBtn;
    }

    public void setTxt_del_booking_id(JTextField txt_del_booking_id) {
        this.txt_del_booking_id = txt_del_booking_id;
    }
}
