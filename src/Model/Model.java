package Model;

import Model.Bookings.manageBookings;
import Model.City.manageCities;
import Model.Tourist.manageTourists;
/**
 * Identification comments:
 *   Name: Shivam Jha D2B 22
 *   Experiment Title: Java Mini Project
 *   Experiment Date: 01/04/24
 *   @version 1.0
 * Beginning comments:
 * Filename: Model.java
 * @author:  Shivam Jha
 * Overview: This is the Model class which Manages the data related to tourists, cities, and bookings.
 * - It handles reading from and writing to JSON files, as well as providing methods for accessing and modifying the data.
 * - Objects mt,mc,mb have been created for manageTourists, manageCities and manageBookings
 * - Setters ad getters have been created for mt, mc and mb.
 *
 */

public class Model {
    manageTourists mt;
    manageCities mc;
    manageBookings mb;

    public Model() {
        mt = new manageTourists();
        mc = new manageCities();
        mb = new manageBookings();
    }

    public manageTourists getMt() {
        return mt;
    }

    public manageCities getMc() {
        return mc;
    }

    public manageBookings getMb() {
        return mb;
    }

    public void setMt(manageTourists mt) {
        this.mt = mt;
    }

    public void setMc(manageCities mc) {
        this.mc = mc;
    }

    public void setMb(manageBookings mb) {
        this.mb = mb;
    }
}
