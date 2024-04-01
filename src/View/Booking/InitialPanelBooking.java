package View.Booking;

import javax.swing.*;

public class InitialPanelBooking extends JPanel {

    private BookingTablePanel btp;
    private AddPanelBooking apb;
    private EditBookingPanel ebp;
    private DeleteBookingsPanel dbp;

    public InitialPanelBooking() {
        super();
        btp = new BookingTablePanel();


        add(btp);
        apb = new AddPanelBooking();
        apb.setOpaque(false);
        add(apb);
        ebp =new EditBookingPanel();
        ebp.setOpaque(false);
        add(ebp);
        dbp = new DeleteBookingsPanel();
        dbp.setOpaque(false);

        add(dbp);
    }

    public void setBtp(BookingTablePanel btp) {
        this.btp = btp;
    }

    public BookingTablePanel getBtp() {
        return btp;
    }


    public void setApb(AddPanelBooking apb) {
        this.apb = apb;
    }

    public AddPanelBooking getApb() {
        return apb;
    }

    public void setEbp(EditBookingPanel ebp) {
        this.ebp = ebp;
    }

    public EditBookingPanel getEbp() {
        return ebp;
    }
    public DeleteBookingsPanel getDbp() {
        return dbp;
    }
    public void setDbp(DeleteBookingsPanel dcp) {
        this.dbp = dbp;
    }
    }

