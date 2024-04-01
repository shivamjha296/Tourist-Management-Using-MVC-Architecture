package View.Cities;

import javax.swing.*;
import java.awt.*;

public class AddCitiesPanel extends JPanel {

    JTextField txt_city_id;
    JTextField txt_city_name;
    JTextField txt_city_language;
    JTextField txt_city_currency;
    JTextField txt_city_country;
    JButton addCityBtn;

    public AddCitiesPanel()
    {

        txt_city_id = new JTextField();
        txt_city_name = new JTextField();
        txt_city_language = new JTextField();
        txt_city_currency = new JTextField();
        txt_city_country = new JTextField();
        addCityBtn = new JButton("Add City");


        txt_city_id.setText("City Id");
        txt_city_name.setText("City Name");
        txt_city_country.setText("City Country");
        txt_city_language.setText("City Language");
        txt_city_currency.setText("City Currency");
        Color color1 = new Color(181,128,242);
        addCityBtn.setBackground(color1);

        add(txt_city_id);
        add(txt_city_name);
        add(txt_city_country);
        add(txt_city_language);
        add(txt_city_currency);

        add(addCityBtn);
    }

    public JTextField getTxt_city_id() {
        return txt_city_id;
    }

    public JTextField getTxt_city_name() {
        return txt_city_name;
    }

    public JTextField getTxt_city_language() {
        return txt_city_language;
    }

    public JTextField getTxt_city_currency() {
        return txt_city_currency;
    }
    public JTextField getTxt_city_country(){
        return txt_city_country;
    }

    public JButton getAddCityBtn() {
        return addCityBtn;
    }

    public void setTxt_city_id(JTextField txt_city_id) {
        this.txt_city_id = txt_city_id;
    }

    public void setTxt_city_name(JTextField txt_city_name) {
        this.txt_city_name = txt_city_name;
    }

    public void setTxt_city_language(JTextField txt_city_language) {
        this.txt_city_language = txt_city_language;
    }

    public void setTxt_city_currency(JTextField txt_city_currency) {
        this.txt_city_currency = txt_city_currency;
    }

    public void setTxt_city_country(JTextField txt_city_country) {
        this.txt_city_country = txt_city_country;
    }

    public void setAddCityBtn(JButton addCityBtn) {
        this.addCityBtn = addCityBtn;
    }
}
