package Controller;

import Model.Model;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;

/**
 * Identification comments:
 *   Name: Shivam Jha D2B 22
 *   Experiment Title: Java Mini Project
 *   Experiment Date: 01/04/24
 *   @version 1.0
 * Beginning comments:
 * Filename: Controller.java
 * @author:  Shivam Jha
 * Overview: This is the Controller class which serves as a intermediary between the user interface (View) and the underlying data and logic (Model). In this file we have achieved the following:
 * - It initializes with references to the model (Model) and view (View) instances to facilitate communication between them.
 * - The controller Class appears to handle the scrollable functionality within the application’s user interface.
 * - It sets up event listeners for user actions, such as button clicks, in the view components.
 * - Action listeners for buttons like "Add City", "Get City Details", "Edit City", "Delete City" (similar actions exist for Booking and Tourist frames) interact with the model to perform CRUD (Create, Read, Update, Delete) operations on the data.
 * - When user actions occur, it responds by invoking appropriate methods from the model to update the data and then updating the view to reflect those changes.
 * - It manages the visibility of different view components based on user actions or application state, ensuring a smooth user experience.
 *
 */

public class Controller {
    Model model;
    View view;

    public Controller(Model m, View v)
    {
        model = m;
        view = v;

        view.getFf().getManageCityBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("City Button Clicked");
                view.getFf().setVisible(false);
                view.getMcf().setVisible(true);
            }
        });

        view.getMcf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });

        model.getMc().setLinesBeingDisplayed(20);
        view.centerInitialSetupCity(model.getMc().getLinesBeingDisplayed(),model.getMc().getHeaders().size());

        model.getMc().setFirstLineToDisplay(0);
        view.centerUpdateCity(model.getMc().getLines(model.getMc().getFirstLineToDisplay(),model.getMc().getLastLineToDisplay()),model.getMc().getHeaders());


        view.getMcf().getCity_ip().getCtp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMc().getFirstLineToDisplay();
                int current_last_line = model.getMc().getLastLineToDisplay();
                int no_of_cities = model.getMc().getTable().size();
                int no_of_display_lines = model.getMc().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMc().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMc().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_cities-1)
                {
                    model.getMc().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_cities-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_cities - no_of_display_lines)
                    {
                        new_first_line = no_of_cities-no_of_display_lines;
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateCity(model.getMc().getLines(model.getMc().getFirstLineToDisplay(), model.getMc().getLastLineToDisplay()), model.getMc().getHeaders());
            }
        });
        view.getMcf().getCity_ip().getAcp().getAddCityBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add City Button Clicked");
                String txt_city_id = view.getMcf().getCity_ip().getAcp().getTxt_city_id().getText();
                String txt_city_name = view.getMcf().getCity_ip().getAcp().getTxt_city_name().getText();
                String txt_city_country = view.getMcf().getCity_ip().getAcp().getTxt_city_country().getText();
                String txt_city_language = view.getMcf().getCity_ip().getAcp().getTxt_city_language().getText();
                String txt_city_currency = view.getMcf().getCity_ip().getAcp().getTxt_city_currency().getText();
                try {
                    model.getMc().addNewCity(Integer.valueOf(txt_city_id),txt_city_name,txt_city_country,txt_city_language,txt_city_currency);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMcf().getCity_ip().getEcp().getGetCityBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get City Details Clicked");
                String txt_city_idx = view.getMcf().getCity_ip().getEcp().getTxt_get_city_idx().getText();
                model.getMc().readCitiesJsonFile("src/Model/City/Cities.json");
                int city_id = model.getMc().getTable().get(Integer.valueOf(txt_city_idx)).getct_id();
                String city_name = model.getMc().getTable().get(Integer.valueOf(txt_city_idx)).getct_name();
                String city_country = model.getMc().getTable().get(Integer.valueOf(txt_city_idx)).getct_country();
                String city_language = model.getMc().getTable().get(Integer.valueOf(txt_city_idx)).getct_lang();
                String city_currency = model.getMc().getTable().get(Integer.valueOf(txt_city_idx)).getct_currency();
                view.getMcf().getCity_ip().getEcp().getTxt_city_id().setText(String.valueOf(city_id));
                view.getMcf().getCity_ip().getEcp().getTxt_city_name().setText(city_name);
                view.getMcf().getCity_ip().getEcp().getTxt_city_country().setText(city_country);
                view.getMcf().getCity_ip().getEcp().getTxt_city_language().setText(city_language);
                view.getMcf().getCity_ip().getEcp().getTxt_city_currency().setText(city_currency);

            }
        });

        view.getMcf().getCity_ip().getEcp().getEditCityBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit City Button Clicked");
                String txt_city_idx = view.getMcf().getCity_ip().getEcp().getTxt_get_city_idx().getText();
                String txt_city_id = view.getMcf().getCity_ip().getEcp().getTxt_city_id().getText();
                String txt_city_name = view.getMcf().getCity_ip().getEcp().getTxt_city_name().getText();
                String txt_city_country = view.getMcf().getCity_ip().getEcp().getTxt_city_country().getText();
                String txt_city_language = view.getMcf().getCity_ip().getEcp().getTxt_city_language().getText();
                String txt_city_currency = view.getMcf().getCity_ip().getEcp().getTxt_city_currency().getText();
                try {
                    model.getMc().editNewCity(Integer.valueOf(txt_city_idx),Integer.valueOf(txt_city_id),txt_city_name,txt_city_country,txt_city_language,txt_city_currency);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMcf().getCity_ip().getDcp().getDeleteCityBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete City Button Clicked");
                String txt_city_idx = view.getMcf().getCity_ip().getDcp().getTxt_del_city_id().getText();
                try {
                    int id = model.getMc().deleteCity(Integer.valueOf(txt_city_idx));
                    model.getMb().deleteif(id);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        view.getFf().getManageBookingBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Booking Button Clicked");
                view.getFf().setVisible(false);
                view.getMbf().setVisible(true);
            }
        });
        view.getMbf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });


        model.getMb().setLinesBeingDisplayed(20);
        view.centerInitialSetupBooking(model.getMb().getLinesBeingDisplayed(),model.getMb().getHeaders().size());
        model.getMb().setFirstLineToDisplay(0);
        view.centerUpdateBooking(model.getMb().getLines(model.getMb().getFirstLineToDisplay(),model.getMb().getLastLineToDisplay()),model.getMb().getHeaders());

        view.getMbf().getBooking_ip().getBtp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMb().getFirstLineToDisplay();
                int current_last_line = model.getMb().getLastLineToDisplay();
                int no_of_bookings = model.getMb().getTable().size();
                int no_of_display_lines = model.getMb().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMb().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMb().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMb().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_bookings-1)
                {
                    model.getMb().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_bookings-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_bookings - no_of_display_lines)
                    {
                        new_first_line = no_of_bookings-no_of_display_lines;
                        model.getMb().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMb().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateBooking(model.getMb().getLines(model.getMb().getFirstLineToDisplay(), model.getMb().getLastLineToDisplay()), model.getMb().getHeaders());
            }
        });

        view.getMbf().getBooking_ip().getApb().getAddBookingBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Booking Button Clicked");
                String txt_booking_t_id = view.getMbf().getBooking_ip().getApb().getTxt_t_temp().getText();
                String txt_booking_c_id = view.getMbf().getBooking_ip().getApb().getTxt_c_temp().getText();
                String txt_booking_date = view.getMbf().getBooking_ip().getApb().getTxt_booking_date().getText();
                String txt_booking_time = view.getMbf().getBooking_ip().getApb().getTxt_booking_time().getText();
                String txt_booking_fees = view.getMbf().getBooking_ip().getApb().getTxt_Booking_fees().getText();
                try {
                    model.getMb().addNewBooking(Integer.valueOf(txt_booking_t_id),Integer.valueOf(txt_booking_c_id),txt_booking_date,txt_booking_time,Integer.valueOf(txt_booking_fees));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMbf().getBooking_ip().getEbp().getGetBookingBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Booking Details Clicked");
                String txt_booking_idx = view.getMbf().getBooking_ip().getEbp().getTxt_get_booking_idx().getText();
                model.getMb().readBookingsJsonFile("src/Model/Bookings/Bookings.json");

                int booking_t_id = model.getMb().getTable().get(Integer.valueOf(txt_booking_idx)).getT_temp().gettr_id();
                int booking_c_id = model.getMb().getTable().get(Integer.valueOf(txt_booking_idx)).getC_temp().getct_id();
                String booking_date = model.getMb().getTable().get(Integer.valueOf(txt_booking_idx)).getBooking_date();
                String booking_time = model.getMb().getTable().get(Integer.valueOf(txt_booking_idx)).getBooking_time();
                int booking_fees = model.getMb().getTable().get(Integer.valueOf(txt_booking_idx)).getBooking_fees();


                view.getMbf().getBooking_ip().getEbp().getTxt_booking_t_id().setText(String.valueOf(booking_t_id));
                view.getMbf().getBooking_ip().getEbp().getTxt_booking_c_id().setText(String.valueOf(booking_c_id));
                view.getMbf().getBooking_ip().getEbp().getTxt_booking_date().setText(booking_date);
                view.getMbf().getBooking_ip().getEbp().getTxt_booking_time().setText(booking_time);
                view.getMbf().getBooking_ip().getEbp().getTxt_booking_fees().setText(String.valueOf(booking_fees));
            }
        });

        view.getMbf().getBooking_ip().getEbp().getEditBookingBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Booking Button Clicked");
                String txt_booking_idx = view.getMbf().getBooking_ip().getEbp().getTxt_get_booking_idx().getText();
                String txt_booking_t_id = view.getMbf().getBooking_ip().getEbp().getTxt_booking_t_id().getText();
                String txt_booking_c_id = view.getMbf().getBooking_ip().getEbp().getTxt_booking_c_id().getText();
                String txt_booking_date = view.getMbf().getBooking_ip().getEbp().getTxt_booking_date().getText();
                String txt_booking_time = view.getMbf().getBooking_ip().getEbp().getTxt_booking_time().getText();
                String txt_booking_fees = view.getMbf().getBooking_ip().getEbp().getTxt_booking_fees().getText();

                try {
                    model.getMb().editNewBooking(Integer.valueOf(txt_booking_idx),Integer.valueOf(txt_booking_t_id),Integer.valueOf(txt_booking_c_id),txt_booking_date,txt_booking_time,Integer.valueOf(txt_booking_fees));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMbf().getBooking_ip().getDbp().getDeleteBookingBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.getMb().deleteBooking(Integer.parseInt(view.getMbf().getBooking_ip().getDbp().getTxt_del_booking_id().getText()));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMtf().getTourist_ip().getDtp().getDeleteTouristBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Tourist Button Clicked");
                String txt_tourist_idx = view.getMtf().getTourist_ip().getDtp().getTxt_del_tourist_id().getText();
                try {
                    int id = model.getMt().deleteTourist(Integer.valueOf(txt_tourist_idx));
                    model.getMb().deleteif(id);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        view.getFf().getManageTouristBtn().addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              view.getFf().setVisible(false);
              view.getMtf().setVisible(true);
          }
        });
        view.getMtf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });


        view.getMtf().getTourist_ip().getCpt().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMt().getFirstLineToDisplay();
                int current_last_line = model.getMt().getLastLineToDisplay();
                int no_of_tourists = model.getMt().getTable().size();
                int no_of_display_lines = model.getMt().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMt().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMt().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMt().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_tourists-1)
                {
                    model.getMt().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_tourists-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_tourists - no_of_display_lines)
                    {
                        new_first_line = no_of_tourists-no_of_display_lines;
                        model.getMt().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMt().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateTourist(model.getMt().getLines(model.getMt().getFirstLineToDisplay(), model.getMt().getLastLineToDisplay()), model.getMt().getHeaders());
            }
        });

        view.getMtf().getTourist_ip().getApt().getAddTouristBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Tourist Button Clicked");
                String txt_tourist_id = view.getMtf().getTourist_ip().getApt().getTxt_t_id().getText();
                String txt_tourist_f_name = view.getMtf().getTourist_ip().getApt().getTxt_fname().getText();
                String txt_tourist_l_name = view.getMtf().getTourist_ip().getApt().getTxt_lname().getText();
                String txt_tourist_gender = view.getMtf().getTourist_ip().getApt().getTxt_gender().getText();
                String txt_tourist_age = view.getMtf().getTourist_ip().getApt().getTxt_age().getText();
                String txt_tourist_mob = view.getMtf().getTourist_ip().getApt().getTxt_mobile().getText();
                try {
                    model.getMt().addNewTourist(Integer.valueOf(txt_tourist_id),txt_tourist_f_name,txt_tourist_l_name,txt_tourist_gender,Integer.valueOf(txt_tourist_age),txt_tourist_mob);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        view.getMtf().getTourist_ip().getEtp().getGetTouristBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Tourist Details Clicked");
                String txt_tourist_idx = view.getMtf().getTourist_ip().getEtp().getTxt_get_Tourist_idx().getText();
                model.getMt().readTouristsJsonFile("src/Model/Tourist/Tourists.json");
                int tourist_id = model.getMt().getTable().get(Integer.valueOf(txt_tourist_idx)).gettr_id();
                String tourist_f_name = model.getMt().getTable().get(Integer.valueOf(txt_tourist_idx)).getFname();
                String tourist_l_name = model.getMt().getTable().get(Integer.valueOf(txt_tourist_idx)).getLname();
                String tourist_gender = model.getMt().getTable().get(Integer.valueOf(txt_tourist_idx)).getgender();
                int tourist_age = model.getMt().getTable().get(Integer.valueOf(txt_tourist_idx)).getage();
                String tourist_mob = model.getMt().getTable().get(Integer.valueOf(txt_tourist_idx)).gettr_mob();

                view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_id().setText(String.valueOf(tourist_id));
                view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_f_name().setText(tourist_f_name);
                view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_l_name().setText(tourist_l_name);
                view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_gender().setText(tourist_gender);
                view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_age().setText(String.valueOf(tourist_age));
                view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_mobile().setText(tourist_mob);
            }
        });

        view.getMtf().getTourist_ip().getEtp().getEditTouristBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Tourist Button Clicked");
                String txt_tourist_idx = view.getMtf().getTourist_ip().getEtp().getTxt_get_Tourist_idx().getText();
                String txt_tourist_id = view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_id().getText();
                String txt_tourist_f_name = view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_f_name().getText();
                String txt_tourist_l_name = view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_l_name().getText();
                String txt_tourist_gender = view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_gender().getText();
                String txt_tourist_age = view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_age().getText();
                String txt_tourist_mob = view.getMtf().getTourist_ip().getEtp().getTxt_Tourist_mobile().getText();
                try {
                    model.getMt().editNewTourist(Integer.valueOf(txt_tourist_idx),Integer.valueOf(txt_tourist_id),txt_tourist_f_name,txt_tourist_l_name,txt_tourist_gender,Integer.valueOf(txt_tourist_age),txt_tourist_mob);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



        model.getMt().setLinesBeingDisplayed(20);
        view.centerInitialSetupTourist(model.getMt().getLinesBeingDisplayed(),model.getMt().getHeaders().size());
        model.getMt().setFirstLineToDisplay(0);
        view.centerUpdateTourist(model.getMt().getLines(model.getMt().getFirstLineToDisplay(),model.getMt().getLastLineToDisplay()),model.getMt().getHeaders());}}

