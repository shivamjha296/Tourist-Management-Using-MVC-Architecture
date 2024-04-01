package View.Cities;

import javax.swing.*;

public class InitialPanelCities extends JPanel {

    private CitiesTablePanel ctp;
    private AddCitiesPanel acp;
    private EditCitiesPanel ecp;
    private DeleteCitiesPanel dcp;
    public InitialPanelCities() {
        super();
        ctp = new CitiesTablePanel();
        ctp.setOpaque(false);
        add(ctp);
        acp = new AddCitiesPanel();
        acp.setOpaque(false);
        add(acp);
        ecp =new EditCitiesPanel();
        ecp.setOpaque(false);
        add(ecp);
        dcp = new DeleteCitiesPanel();
        dcp.setOpaque(false);
        add(dcp);
    }

    public void setCtp(CitiesTablePanel ctp) {
        this.ctp = ctp;
    }

    public CitiesTablePanel getCtp() {
        return ctp;
    }


    public void setAcp(AddCitiesPanel acp) {
        this.acp = acp;
    }

    public AddCitiesPanel getAcp() {
        return acp;
    }

    public void setEcp(EditCitiesPanel ecp) {
        this.ecp = ecp;
    }

    public EditCitiesPanel getEcp() {
        return ecp;
    }
    public DeleteCitiesPanel getDcp() {
        return dcp;
    }
    public void setDcp(DeleteCitiesPanel dcp) {
        this.dcp = dcp;
    }

}
