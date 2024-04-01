package View;

import javax.swing.*;
import java.awt.*;

public class EditTouristsPanel extends JPanel{

        JTextField txt_get_Tourist_idx;
        JButton getTouristBtn;
        JTextField txt_Tourist_id;
        JTextField txt_Tourist_f_name;
        JTextField txt_Tourist_l_name;
        JTextField txt_Tourist_gender;
        JTextField txt_Tourist_age;
        JTextField txt_Tourist_mobile;
        JButton editTouristBtn;

        public EditTouristsPanel()
        {

            txt_Tourist_id = new JTextField();
            txt_Tourist_f_name = new JTextField();
            txt_Tourist_l_name = new JTextField();
            txt_Tourist_gender = new JTextField();
            txt_Tourist_age = new JTextField();
            txt_Tourist_mobile= new JTextField();
            editTouristBtn = new JButton("Edit Tourist");
            txt_get_Tourist_idx = new JTextField();

            getTouristBtn = new JButton("Get Tourist to Edit");

            txt_Tourist_id.setText("Tourist Id");
            txt_Tourist_f_name.setText("Tourist First name");
            txt_Tourist_l_name.setText("Tourist Last name");
            txt_Tourist_gender.setText("Tourist Gender");
            txt_Tourist_age.setText("Tourist Age");
            txt_Tourist_mobile.setText("Tourist Mobile No.");
            txt_get_Tourist_idx.setText("Tourist Id to get");
            Color color1 = new Color(181,128,242);
            getTouristBtn.setBackground(color1);
            editTouristBtn.setBackground(color1);


            add(txt_get_Tourist_idx);
            add(getTouristBtn);

            add(txt_Tourist_id);
            add(txt_Tourist_f_name);
            add(txt_Tourist_l_name);
            add(txt_Tourist_gender);
            add(txt_Tourist_age);
            add(txt_Tourist_mobile);
            add(editTouristBtn);
        }

        public JTextField getTxt_Tourist_id() {
            return txt_Tourist_id;
        }

        public JTextField getTxt_Tourist_f_name() {
            return txt_Tourist_f_name;
        }

    public void setTxt_Tourist_l_name(JTextField txt_Tourist_l_name) {
        this.txt_Tourist_l_name = txt_Tourist_l_name;
    }

    public JTextField getTxt_Tourist_age() {
        return txt_Tourist_age;
    }

    public JTextField getTxt_Tourist_mobile() {
            return txt_Tourist_mobile;
        }

        public JTextField getTxt_Tourist_gender() {
            return txt_Tourist_gender;
        }

        public JButton getEditTouristBtn() {
            return editTouristBtn;
        }

        public JTextField getTxt_get_Tourist_idx() {
            return txt_get_Tourist_idx;
        }
        public JButton getGetTouristBtn() {
            return getTouristBtn;
        }
        public void setTxt_Tourist_id(JTextField txt_Tourist_id) {
            this.txt_Tourist_id = txt_Tourist_id;
        }

        public void setTxt_Tourist_f_name(JTextField txt_Tourist_f_name) {
            this.txt_Tourist_f_name = txt_Tourist_f_name;
        }

    public JTextField getTxt_Tourist_l_name() {
        return txt_Tourist_l_name;
    }

    public void setTxt_Tourist_mobile(JTextField txt_Tourist_mobile) {
            this.txt_Tourist_mobile= txt_Tourist_mobile;
        }

    public void setTxt_Tourist_age(JTextField txt_Tourist_age) {
        this.txt_Tourist_age = txt_Tourist_age;
    }

    public void setTxt_Tourist_gender(JTextField txt_Tourist_gender) {
            this.txt_Tourist_gender = txt_Tourist_gender;
        }

        public void setEditTouristBtn(JButton editTouristBtn) {
            this.editTouristBtn = editTouristBtn;
        }

        public void setTxt_get_Tourist_idx(JTextField txt_get_Tourist_idx) {
            this.txt_get_Tourist_idx = txt_get_Tourist_idx;
        }

        public void setGetTouristBtn(JButton getTouristBtn) {
            this.getTouristBtn = getTouristBtn;
        }
    }


