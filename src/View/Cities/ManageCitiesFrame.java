package View.Cities;

import javax.swing.*;
import java.awt.*;

public class ManageCitiesFrame extends JFrame {
    InitialPanelCities city_ip;

    public ManageCitiesFrame()
    {
        super("Manage City DashBoard");
        city_ip = new InitialPanelCities();
        city_ip.setBackground(Color.decode("14336757"));
        add(city_ip);
        pack();
        setSize(500, 600);
    }

    public void setCity_ip(InitialPanelCities city_ip) {
        this.city_ip = city_ip;
    }

    public InitialPanelCities getCity_ip() {
        return city_ip;
    }
}
