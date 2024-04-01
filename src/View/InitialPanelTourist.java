package View;
import javax.swing.*;
import java.awt.*;

public class InitialPanelTourist extends JPanel {

    private CenterPanelTourist cp;
    private AddPanelTourist apt;
    private EditTouristsPanel etp;
    private DeleteTouristsPanel dtp;

    public InitialPanelTourist() {
        super();
        setBackground(Color.decode("14336757"));
        cp = new CenterPanelTourist();
        add(cp);
        apt = new AddPanelTourist();
        apt.setOpaque(false);
        add(apt);
        etp =new EditTouristsPanel();
        etp.setOpaque(false);
        add(etp);
        dtp = new DeleteTouristsPanel();
        dtp.setOpaque(false);
        add(dtp);
    }

    public CenterPanelTourist getCpt() {
        return cp;
    }



    public void setCpt(CenterPanelTourist cp) {
        this.cp = cp;
    }

    public void setApt(AddPanelTourist apt) {
        this.apt = apt;
    }

    public AddPanelTourist getApt() {
        return apt;
    }


    public EditTouristsPanel getEtp() {
        return etp;
    }

    public void setEtp(EditTouristsPanel etp) {
        this.etp = etp;
    }

    public void setDtp(DeleteTouristsPanel dtp) {
        this.dtp = dtp;
    }
    public DeleteTouristsPanel getDtp(){
        return dtp;
    }
}
