package View;

import javax.swing.*;

public class ManageTouristFrame extends JFrame {
    InitialPanelTourist ip;

    public ManageTouristFrame()
    {
        super("Manage Tourist DashBoard");
        ip = new InitialPanelTourist();
        add(ip);
        pack();
        setSize(500, 600);
    }

    public void setIp(InitialPanelTourist ip) {
        this.ip = ip;
    }

    public InitialPanelTourist getTourist_ip() {
        return ip;
    }
}
