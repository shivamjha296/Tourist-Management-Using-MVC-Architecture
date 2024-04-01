package Model.Bookings;
/**
 * Identification comments:
 *   Name: Shivam Jha D2B 22
 *   Experiment Title: Java Mini Project
 *   Experiment Date: 01/04/24
 *   @version 1.0
 * Beginning comments:
 * Filename: Bookings.java
 * @author:  Shivam Jha
 * Overview: This is the Bookings class. In this file we have achieved the following
 * - Created Attributes
 * --- Tourists t_temp
 * --- Cities c_temp
 * --- String booking_date
 * --- String booking_time
 * --- int Booking_fees
 *
 * - Created Setters and Getters
 * - Created constructor for Bookings
 * - Created setters and getters
 *
 */

import Model.City.Cities;
import Model.Tourist.Tourists;

public class Bookings {
    Tourists t_temp;
    Cities c_temp;
    String booking_date;
    int booking_fees;
    String booking_time;

    public Bookings(Tourists s, Cities c, String c_date,String booking_time, int fees)
    {
        setT_temp(s);
        setC_temp(c);
        setBooking_date(c_date);
        setBooking_time(booking_time);
        setBooking_fees(fees);

    }

    public void setT_temp(Tourists t_temp) {
        this.t_temp = t_temp;
    }

    public void setC_temp(Cities c_temp) {
        this.c_temp = c_temp;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    public void setBooking_fees(int Booking_fees) {
        this.booking_fees = Booking_fees;
    }

    public Tourists getT_temp() {
        return t_temp;
    }

    public Cities getC_temp() {
        return c_temp;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public int getBooking_fees() {
        return booking_fees;
    }

    public String getBooking_time() {
        return booking_time;
    }

    public void setBooking_time(String booking_time) {
        this.booking_time = booking_time;
    }
}
