package View;

import javax.swing.*;
import java.awt.*;

public class AddPanelTourist extends JPanel {
    JTextField txt_fname;
    JTextField txt_lname;
    JTextField txt_gender;
    JTextField txt_age;
    JTextField txt_mobile;
    JTextField txt_id;
    JButton addTouristBtn;

    public AddPanelTourist()
    {
        txt_fname = new JTextField();
        txt_lname = new JTextField();
        txt_gender = new JTextField();
        txt_age = new JTextField();
        txt_mobile = new JTextField();
        txt_id = new JTextField();
        addTouristBtn = new JButton("Add Tourist");
        Color color1 = new Color(181,128,242);


        txt_fname.setText("First name");
        txt_lname.setText("Last name");
        txt_gender.setText("Gender");
        txt_age.setText("Age");
        txt_mobile.setText("Mobile");
        txt_id.setText("Tourist Id");
        addTouristBtn.setBackground(color1);


        add(txt_id);
        add(txt_fname);
        add(txt_lname);
        add(txt_gender);
        add(txt_age);
        add(txt_mobile);
        add(addTouristBtn);
    }

    public void setAddTouristBtn(JButton addTouristBtn) {
        this.addTouristBtn = addTouristBtn;
    }

    public void setTxt_age(JTextField txt_age) {
        this.txt_age = txt_age;
    }

    public void setTxt_fname(JTextField txt_fname) {
        this.txt_fname = txt_fname;
    }

    public void setTxt_gender(JTextField txt_gender) {
        this.txt_gender = txt_gender;
    }

    public void setTxt_id(JTextField txt_id) {
        this.txt_id = txt_id;
    }

    public void setTxt_lname(JTextField txt_lname) {
        this.txt_lname = txt_lname;
    }

    public void setTxt_mobile(JTextField txt_mobile) {
        this.txt_mobile = txt_mobile;
    }

    public JTextField getTxt_fname() {
        return txt_fname;
    }

    public JTextField getTxt_lname() {
        return txt_lname;
    }

    public JTextField getTxt_gender() {
        return txt_gender;
    }

    public JTextField getTxt_mobile() {
        return txt_mobile;
    }

    public JTextField getTxt_age() {
        return txt_age;
    }

    public JTextField getTxt_t_id() {
        return txt_id;
    }

    public JButton getAddTouristBtn() {
        return addTouristBtn;
    }
}
