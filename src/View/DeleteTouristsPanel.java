package View;

import javax.swing.*;
import java.awt.*;

public class DeleteTouristsPanel extends JPanel {

    JTextField txt_del_tourist_id;
    JButton deleteTouristBtn;

    public DeleteTouristsPanel()
    {

        txt_del_tourist_id = new JTextField();
        deleteTouristBtn = new JButton("Delete Tourist");
        Color color1 = new Color(181,128,242);
        deleteTouristBtn.setBackground(color1);

        txt_del_tourist_id.setText("Tourist Id to Delete");

        add(txt_del_tourist_id);
        add(deleteTouristBtn);
    }

    public JButton getDeleteTouristBtn() {
        return deleteTouristBtn;
    }

    public JTextField getTxt_del_tourist_id() {
        return txt_del_tourist_id;
    }

    public void setDeleteTouristBtn(JButton deleteTouristBtn) {
        this.deleteTouristBtn = deleteTouristBtn;
    }

    public void setTxt_del_tourist_id(JTextField txt_del_tourist_id) {
        this.txt_del_tourist_id = txt_del_tourist_id;
    }
}
