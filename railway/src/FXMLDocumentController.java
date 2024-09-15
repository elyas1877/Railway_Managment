/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes_.Company;
import Classes_.DBO;
import Classes_.Locomotive_driver;
import Classes_.Train;
import Classes_.Classes;
import Classes_.Customer;
import Classes_.Destinations;
import Classes_.Ticket;
import Classes_.Travel;
import Classes_.Travel_group;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author Elyas-PC
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private TextField loco_codetxt;
    @FXML
    private TextField loco_nametxt;
    @FXML
    private TextField loco_familytxt;
    @FXML
    private TextField loco_phonetxt;
    @FXML
    private ComboBox<Company> loco_companycombo;
    @FXML
    private TextField train_codetxt;
    @FXML
    private TextField train_nametxt;
    @FXML
    private ComboBox<Company> train_companycombo;
    @FXML
    private ComboBox<Classes> train_classescombo;
    @FXML
    private Spinner<Integer> trainwagontxt;
    @FXML
    private TextField company_codetxt;
    @FXML
    private TextField company_nametxt;
    @FXML
    private TextField cus_codetxt;
    @FXML
    private TextField cus_nametxt;
    @FXML
    private TextField cus_familytxt;
    @FXML
    private TextField cus_phonetxt;
    @FXML
    private TextField dest_codetxt;
    @FXML
    private TextField dest_nametxt;
    @FXML
    private TextField dest_pricetxt;
    @FXML
    private TextField edit_loco_codtxt;
    @FXML
    private TextField edit_loco_nametxt;
    @FXML
    private TextField edit_loco_familytxt;
    @FXML
    private TextField edit_loco_phonetxt;
    @FXML
    private ComboBox<Company> edit_loco_companycombo;
    @FXML
    private TableView<Locomotive_driver> edit_loco_table;
    @FXML
    private TableColumn<Integer, Locomotive_driver> edit_loco_codetable;
    @FXML
    private TableColumn<String, Locomotive_driver> edit_loco_nametable;
    @FXML
    private TableColumn<String, Locomotive_driver> edit_loco_lnametable;
    @FXML
    private TableColumn<String, Locomotive_driver> edit_loco_phonetable;
    @FXML
    private TableColumn<Integer, Locomotive_driver> edit_loco_companytable;
    @FXML
    private TextField edit_traincodetxt;
    @FXML
    private TextField edit_trainnametxt;
    @FXML
    private ComboBox<Company> edit_train_co_combo;
    @FXML
    private ComboBox<Classes> edit_train_class_combo;
    @FXML
    private Spinner<Integer> edit_wagon_spinner;
    @FXML
    private TableView<Train> edit_train_table;
    @FXML
    private TableColumn<Integer, Train> edit_train_cod_table;
    @FXML
    private TableColumn<String, Train> edit_train_name_table;
    @FXML
    private TableColumn<Integer, Train> edit_train_wagon_table;
    @FXML
    private TableColumn<Integer, Train> edit_train_class_table;
    @FXML
    private TableColumn<Integer, Train> edit_train_company_table;
    @FXML
    private TextField edit_company_codetxt;
    @FXML
    private TextField edit_company_nametxt;
    @FXML
    private TableView<Company> edit_company_table;
    @FXML
    private TableColumn<Integer, Company> edit_company_table_code;
    @FXML
    private TableColumn<String, Company> edit_company_table_name;
    @FXML
    private TextField edit_customer_n_codetxt;
    @FXML
    private TextField edit_customer_nametxt;
    @FXML
    private TextField edit_customer_familytxt;
    @FXML
    private TextField edit_customer_phonetxt;
    @FXML
    private TableView<Customer> edit_customer_table;
    @FXML
    private TableColumn<Integer, Customer> edit_customer_nid_table;
    @FXML
    private TableColumn<String, Customer> edit_customer_name_table;
    @FXML
    private TableColumn<String, Customer> edit_customer_lname_table;
    @FXML
    private TableColumn<String, Customer> edit_customer_phone_table;
    @FXML
    private TextField edit_destination_codetxt;
    @FXML
    private TextField edit_destination_pricetxt;
    @FXML
    private TableView<Destinations> edit_destination_table;
    @FXML
    private TableColumn<Integer, Destinations> edit_destination_code_table;
    @FXML
    private TableColumn<String, Destinations> edit_destination_name_table;
    @FXML
    private TableColumn<Integer, Destinations> edit_destination_price_table;
    @FXML
    private TextField edit_destination_nametxt;
    @FXML
    private TextField loco_searchtxt;
    @FXML
    private TableView<Locomotive_driver> loco_search_table;
    @FXML
    private TableColumn<Integer, Locomotive_driver> loco_search_table_code;
    @FXML
    private TableColumn<String, Locomotive_driver> loco_search_table_name;
    @FXML
    private TableColumn<String, Locomotive_driver> loco_search_table_lname;
    @FXML
    private TableColumn<String, Locomotive_driver> loco_search_table_phone;
    @FXML
    private TableColumn<Integer, Locomotive_driver> loco_search_table_company;
    @FXML
    private TextField train_searchtxt;
    @FXML
    private TableView<Train> train_search_table;
    @FXML
    private TableColumn<Integer, Train> train_search_table_code;
    @FXML
    private TableColumn<String, Train> train_search_table_name;
    @FXML
    private TableColumn<Integer, Train> train_search_table_wagon;
    @FXML
    private TableColumn<Integer, Train> train_search_table_class;
    @FXML
    private TableColumn<Integer, Train> train_search_table_company;
    @FXML
    private TextField company_searchtxt;
    @FXML
    private TableView<Company> company_search_table;
    @FXML
    private TableColumn<Integer, Company> company_search_table_code;
    @FXML
    private TableColumn<String, Company> company_search_table_name;
    @FXML
    private TextField customer_searchtxt;
    @FXML
    private TableView<Customer> customer_search_table;
    @FXML
    private TableColumn<Integer, Customer> customer_search_table_idn;
    @FXML
    private TableColumn<String, Customer> customer_search_table_name;
    @FXML
    private TableColumn<String, Customer> customer_search_table_lname;
    @FXML
    private TableColumn<String, Customer> customer_search_table_phone;
    @FXML
    private Tab des_serachtxt;
    @FXML
    private TableView<Destinations> des_serach_table;
    @FXML
    private TableColumn<Integer, Destinations> des_serach_table_code;
    @FXML
    private TableColumn<String, Destinations> des_serach_table_name;
    @FXML
    private TableColumn<Integer, Destinations> des_serach_table_price;
    @FXML
    private TextField destination_search_txt;
    @FXML
    private ComboBox<Train> travel_group_train_combo;
    @FXML
    private ComboBox<Locomotive_driver> travel_group_train_loco;
    @FXML
    private JFXDatePicker travel_group_train_date;
    @FXML
    private JFXTimePicker travel_group_train_time;
    @FXML
    private Tab Travel_group_date_list;
    @FXML
    private TableView<Travel_group> Travel_group_table_list;
    @FXML
    private TableColumn<Integer, Travel_group> Travel_group_traincode_list;
    @FXML
    private TableColumn<String, Travel_group> Travel_group_trainname_list;
    @FXML
    private TableColumn<Integer, Travel_group> Travel_group_lococode_list;
    @FXML
    private TableColumn<String, Travel_group> Travel_group_loconame_list;
    @FXML
    private TableColumn<String, Travel_group> Travel_group_locolname_list;
    @FXML
    private TableColumn<String, Travel_group> Travel_group_tabledate_list;
    @FXML
    private JFXDatePicker travel_group_list_datetxt;
    @FXML
    private ComboBox<Destinations> add_travel_combo_destination;
    @FXML
    private ComboBox<Travel_group> add_travel_travelgroup_destination;
    @FXML
    private TextField cancel_tickettxt;
    @FXML
    private TextField add_tickettxt;
    @FXML
    private ComboBox<Travel> travel_combo;
    @FXML
    private TableView<Travel> list_travel_table;
    @FXML
    private TableColumn<Integer, Travel> list_travel_table_traincode;
    @FXML
    private TableColumn<String, Travel> list_travel_table_trainname;
    @FXML
    private TableColumn<Integer, Travel> list_travel_table_lococode;
    @FXML
    private TableColumn<String, Travel> list_travel_table_loconame;
    @FXML
    private TableColumn<String, Travel> list_travel_table_locolname;
    @FXML
    private TableColumn<String, Travel> list_travel_table_destination;
    @FXML
    private TableColumn<Integer, Travel> list_travel_table_travelcode;
    @FXML
    private TableColumn<String, Travel> list_travel_table_datetravel;
    @FXML
    private TextField tick_search_txt;
    @FXML
    private TableView<Ticket> ticket_table;
    @FXML
    private TableColumn<String, Ticket> ticket_table_name;
    @FXML
    private TableColumn<String, Ticket> ticket_table_lname;
    @FXML
    private TableColumn<Integer, Ticket> ticket_table_chair;
    @FXML
    private TableColumn<Integer, Ticket> ticket_table_wagon;
    @FXML
    private TableColumn<Integer, Ticket> ticket_table_code;
    @FXML
    private TableColumn<String, Ticket> ticket_table_dest;
    @FXML
    private TableColumn<String, Ticket> ticket_table_date;
    @FXML
    private TableColumn<Integer, Ticket> ticket_table_nid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            initialize_combobox();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        initialize_locotable();
        initialize_traintable();
        initialize_companytable();
        initialize_customertable();
        initialize_destinationtable();
        initialize_loco_search();
        initialize_train_search();
        initialize_company_search();
        initialize_customer_search();
        initialize_destination_search();
        initialize_travel_group_table();
        initialize_travel_table();
        initialize_ticket_table();
    }

    private void initialize_locotable() {
        ArrayList<Locomotive_driver> list = DBO.list_loco();
        edit_loco_table.getItems().clear();
        edit_loco_codetable.setCellValueFactory(new PropertyValueFactory("id"));
        edit_loco_nametable.setCellValueFactory(new PropertyValueFactory("name"));
        edit_loco_lnametable.setCellValueFactory(new PropertyValueFactory("lname"));
        edit_loco_phonetable.setCellValueFactory(new PropertyValueFactory("phone"));
        edit_loco_companytable.setCellValueFactory(new PropertyValueFactory("co_id"));
        for (Locomotive_driver L : list) {
            edit_loco_table.getItems().add(L);
        }
    }

    private void initialize_ticket_table() {
        try {
            ArrayList<Ticket> list = DBO.list_ticket();
            ticket_table.getItems().clear();
            ticket_table_name.setCellValueFactory(new PropertyValueFactory("Cus_name"));
            ticket_table_nid.setCellValueFactory(new PropertyValueFactory("Cus_id"));
            ticket_table_lname.setCellValueFactory(new PropertyValueFactory("Cus_lname"));
            ticket_table_chair.setCellValueFactory(new PropertyValueFactory("Chair"));
            ticket_table_wagon.setCellValueFactory(new PropertyValueFactory("Wagon"));
            ticket_table_code.setCellValueFactory(new PropertyValueFactory("Traid"));
            ticket_table_dest.setCellValueFactory(new PropertyValueFactory("Dest"));
            ticket_table_date.setCellValueFactory(new PropertyValueFactory("Date"));
            for(Ticket T:list)
            {
             ticket_table.getItems().add(T);
            }
                
                } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initialize_travel_table() {
        ArrayList<Travel> list;
        try {
            list = DBO.list_travel();

            list_travel_table.getItems().clear();
            list_travel_table_traincode.setCellValueFactory(new PropertyValueFactory("Tricode"));
            list_travel_table_trainname.setCellValueFactory(new PropertyValueFactory("Triname"));
            list_travel_table_lococode.setCellValueFactory(new PropertyValueFactory("Lococode"));
            list_travel_table_loconame.setCellValueFactory(new PropertyValueFactory("Loconame"));
            list_travel_table_locolname.setCellValueFactory(new PropertyValueFactory("Locolname"));
            list_travel_table_destination.setCellValueFactory(new PropertyValueFactory("Dest_name"));
            list_travel_table_travelcode.setCellValueFactory(new PropertyValueFactory("Code"));
            list_travel_table_datetravel.setCellValueFactory(new PropertyValueFactory("Date"));
            for (Travel T : list) {
                list_travel_table.getItems().add(T);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initialize_travel_group_table() {
        try {
            ArrayList<Travel_group> list = DBO.list_tavel_group();
            Travel_group_table_list.getItems().clear();
            Travel_group_traincode_list.setCellValueFactory(new PropertyValueFactory("Tri_id"));
            Travel_group_trainname_list.setCellValueFactory(new PropertyValueFactory("Tri_name"));
            Travel_group_lococode_list.setCellValueFactory(new PropertyValueFactory("Dri_id"));
            Travel_group_loconame_list.setCellValueFactory(new PropertyValueFactory("Dri_name"));
            Travel_group_locolname_list.setCellValueFactory(new PropertyValueFactory("Dri_lname"));
            Travel_group_tabledate_list.setCellValueFactory(new PropertyValueFactory("Date"));
            for (Travel_group T : list) {
                Travel_group_table_list.getItems().add(T);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initialize_company_search() {
        ArrayList<Company> list = DBO.list_company();
        company_search_table.getItems().clear();
        company_search_table_code.setCellValueFactory(new PropertyValueFactory("Id"));
        company_search_table_name.setCellValueFactory(new PropertyValueFactory("Name"));

        for (Company C : list) {
            company_search_table.getItems().add(C);
        }

    }

    private void initialize_loco_search() {
        ArrayList<Locomotive_driver> list = DBO.list_loco();
        loco_search_table.getItems().clear();
        loco_search_table_code.setCellValueFactory(new PropertyValueFactory("id"));
        loco_search_table_name.setCellValueFactory(new PropertyValueFactory("name"));
        loco_search_table_lname.setCellValueFactory(new PropertyValueFactory("lname"));
        loco_search_table_phone.setCellValueFactory(new PropertyValueFactory("phone"));
        loco_search_table_company.setCellValueFactory(new PropertyValueFactory("co_id"));
        for (Locomotive_driver L : list) {
            loco_search_table.getItems().add(L);
        }

    }

    private void initialize_train_search() {
        ArrayList<Train> list = DBO.list_train();
        train_search_table.getItems().clear();
        train_search_table_code.setCellValueFactory(new PropertyValueFactory("Id"));
        train_search_table_name.setCellValueFactory(new PropertyValueFactory("Name"));
        train_search_table_wagon.setCellValueFactory(new PropertyValueFactory("wagons"));
        train_search_table_class.setCellValueFactory(new PropertyValueFactory("class_id"));
        train_search_table_company.setCellValueFactory(new PropertyValueFactory("id_co"));
        for (Train L : list) {
            train_search_table.getItems().add(L);
        }

    }

    private void initialize_destinationtable() {
        ArrayList<Destinations> list = DBO.list_Desti();
        edit_destination_table.getItems().clear();
        edit_destination_code_table.setCellValueFactory(new PropertyValueFactory("Destination_id"));
        edit_destination_name_table.setCellValueFactory(new PropertyValueFactory("Destination_name"));
        edit_destination_price_table.setCellValueFactory(new PropertyValueFactory("Destination_price"));
        for (Destinations D : list) {
            edit_destination_table.getItems().add(D);
        }
    }

    private void initialize_destination_search() {
        ArrayList<Destinations> list = DBO.list_Desti();
        des_serach_table.getItems().clear();
        des_serach_table_code.setCellValueFactory(new PropertyValueFactory("Destination_id"));
        des_serach_table_name.setCellValueFactory(new PropertyValueFactory("Destination_name"));
        des_serach_table_price.setCellValueFactory(new PropertyValueFactory("Destination_price"));
        for (Destinations D : list) {
            des_serach_table.getItems().add(D);
        }
    }

    private void initialize_traintable() {
        ArrayList<Train> list = DBO.list_train();
        edit_train_table.getItems().clear();
        edit_train_cod_table.setCellValueFactory(new PropertyValueFactory("Id"));
        edit_train_name_table.setCellValueFactory(new PropertyValueFactory("Name"));
        edit_train_company_table.setCellValueFactory(new PropertyValueFactory("id_co"));
        edit_train_wagon_table.setCellValueFactory(new PropertyValueFactory("wagons"));
        edit_train_class_table.setCellValueFactory(new PropertyValueFactory("class_id"));
        for (Train T : list) {
            edit_train_table.getItems().add(T);

        }

    }

    private void initialize_companytable() {
        ArrayList<Company> list = DBO.list_company();
        edit_company_table.getItems().clear();
        edit_company_table_code.setCellValueFactory(new PropertyValueFactory("Id"));
        edit_company_table_name.setCellValueFactory(new PropertyValueFactory("Name"));
        for (Company C : list) {
            edit_company_table.getItems().add(C);
        }
    }

    private void initialize_customertable() {
        ArrayList<Customer> list = DBO.list_customer();
        edit_customer_table.getItems().clear();
        edit_customer_nid_table.setCellValueFactory(new PropertyValueFactory("Customer_id"));
        edit_customer_name_table.setCellValueFactory(new PropertyValueFactory("Customr_name"));
        edit_customer_lname_table.setCellValueFactory(new PropertyValueFactory("Customer_lname"));
        edit_customer_phone_table.setCellValueFactory(new PropertyValueFactory("Customer_phone"));
        for (Customer C : list) {
            edit_customer_table.getItems().add(C);
        }
    }

    private void initialize_customer_search() {
        ArrayList<Customer> list = DBO.list_customer();
        customer_search_table.getItems().clear();
        customer_search_table_idn.setCellValueFactory(new PropertyValueFactory("Customer_id"));
        customer_search_table_name.setCellValueFactory(new PropertyValueFactory("Customr_name"));
        customer_search_table_lname.setCellValueFactory(new PropertyValueFactory("Customer_lname"));
        customer_search_table_phone.setCellValueFactory(new PropertyValueFactory("Customer_phone"));
        for (Customer C : list) {
            customer_search_table.getItems().add(C);
        }

    }

    private void initialize_combobox() throws ClassNotFoundException, SQLException {
        ArrayList<Company> list = DBO.list_company();
        loco_companycombo.getItems().clear();
        for (Company C : list) {
            loco_companycombo.getItems().add(C);
            train_companycombo.getItems().add(C);
            edit_loco_companycombo.getItems().add(C);
            edit_train_co_combo.getItems().add(C);
            System.out.println(C);
        }
        list.clear();
        ArrayList<Classes> list1 = DBO.list_classes();
        train_classescombo.getItems().clear();
        list1 = DBO.list_classes();
        for (Classes cls : list1) {
            train_classescombo.getItems().add(cls);
            edit_train_class_combo.getItems().add(cls);
        }
        list1.clear();
        
        ArrayList<Train> list2 = DBO.list_train();
        travel_group_train_combo.getItems().clear();
        for (Train T : list2) {
            travel_group_train_combo.getItems().add(T);
        }
            list2.clear();
            
        ArrayList<Locomotive_driver> list3 = DBO.list_loco();
        travel_group_train_loco.getItems().clear();
        for (Locomotive_driver L : list3) {
            travel_group_train_loco.getItems().add(L);
        }
        list3.clear();
        
        ArrayList<Destinations> list4 = DBO.list_Desti();
        add_travel_combo_destination.getItems().clear();
        for (Destinations D : list4) {
            add_travel_combo_destination.getItems().add(D);
        }
        list4.clear();
        ArrayList<Travel_group> list5 = DBO.list_tavel_group();
        add_travel_travelgroup_destination.getItems().clear();
        for (Travel_group T : list5) {
            add_travel_travelgroup_destination.getItems().add(T);
        }
        list5.clear();
        ArrayList<Travel> list6 = DBO.list_travel();
        travel_combo.getItems().clear();
        for (Travel T : list6) {
            travel_combo.getItems().add(T);
        }
        list6.clear();
    }

    @FXML
    private void loco_addbtn(MouseEvent event) {
        if (DBO.check_loco(Integer.parseInt(loco_codetxt.getText()))) {
            try {
                //String[] sp = loco_companycombo.getSelectionModel().getSelectedItem().split("-");
                Locomotive_driver loco = new Locomotive_driver(Integer.parseInt(loco_codetxt.getText()), loco_nametxt.getText(), loco_familytxt.getText(), loco_phonetxt.getText(), loco_companycombo.getSelectionModel().getSelectedItem().getId());
                DBO.add_loco(loco);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFO");
                alert.setHeaderText(null);
                alert.setContentText("Added Sucsesfully...");
                alert.show();
                initialize(null, null);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Already Exist...");
            alert.show();

        }
    }

    @FXML
    private void train_addbtn(MouseEvent event) {
        if (DBO.check_train(Integer.parseInt(train_codetxt.getText()))) {
            try {
                Train tra = new Train(Integer.parseInt(train_codetxt.getText()), train_nametxt.getText(), train_companycombo.getSelectionModel().getSelectedItem().getId(), trainwagontxt.getValue(), train_classescombo.getSelectionModel().getSelectedItem().getClasses_id());
                DBO.add_train(tra);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFO");
                alert.setHeaderText(null);
                alert.setContentText("Added Sucsesfully...");
                alert.show();
                initialize(null, null);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Already Exist...");
            alert.show();
        }

    }

    @FXML
    private void company_addbtn(MouseEvent event) {
        if (DBO.check_company(Integer.parseInt(company_codetxt.getText()))) {
            Company com = new Company(company_nametxt.getText(), Integer.parseInt(company_codetxt.getText()));
            try {
                DBO.add_company(com);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFO");
                alert.setHeaderText(null);
                alert.setContentText("Added Sucsesfully...");
                alert.show();
                initialize(null, null);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Already Exist...");
            alert.show();
        }
    }

    @FXML
    private void cus_addbtn(MouseEvent event) {
        if (DBO.check_customer(Integer.parseInt(cus_codetxt.getText()))) {
            Customer cus = new Customer(Integer.parseInt(cus_codetxt.getText()), cus_nametxt.getText(), cus_familytxt.getText(), cus_phonetxt.getText());
            try {
                DBO.Add_customer(cus);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFO");
                alert.setHeaderText(null);
                alert.setContentText("Added Sucsesfully...");
                alert.show();
                initialize(null, null);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Already Exist...");
            alert.show();
        }
    }

    @FXML
    private void dest_addbtn(MouseEvent event) {
        if (DBO.check_dest_id(Integer.parseInt(dest_codetxt.getText()))) {
            try {
                Destinations des = new Destinations(Integer.parseInt(dest_codetxt.getText()), dest_nametxt.getText(), Integer.parseInt(dest_pricetxt.getText()));
                DBO.add_destination(des);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFO");
                alert.setHeaderText(null);
                alert.setContentText("Added Sucsesfully...");
                alert.show();
                initialize(null, null);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Already Exist...");
            alert.show();
        }
    }

    @FXML
    private void edit_loco_btn(MouseEvent event) {

        try {
            DBO.edit_loco(edit_loco_nametxt.getText(),
                    edit_loco_familytxt.getText(),
                    edit_loco_companycombo.getSelectionModel().getSelectedItem().getId(),
                    edit_loco_phonetxt.getText(),
                    Integer.parseInt(edit_loco_codtxt.getText()));
            initialize_locotable();
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("INFO");
//                alert.setHeaderText(null);
//                alert.setContentText("Edited Sucsesfully...");
//                alert.show();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void loco_edit_table_select(MouseEvent event) {
        try {
            Locomotive_driver loco = edit_loco_table.getSelectionModel().getSelectedItem();
            edit_loco_codtxt.setText(String.valueOf(loco.getId()));
            edit_loco_nametxt.setText(loco.getName());
            edit_loco_familytxt.setText(loco.getLname());
            edit_loco_phonetxt.setText(loco.getPhone());
            edit_loco_companycombo.getSelectionModel().select(DBO.Search_company(loco.getCo_id()));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void edit_train_btn(MouseEvent event) {
        try {
            DBO.edit_train(edit_trainnametxt.getText(), Integer.parseInt(edit_traincodetxt.getText()),
                    edit_train_co_combo.getSelectionModel().getSelectedItem().getId(),
                    edit_wagon_spinner.getValue(),
                    edit_train_class_combo.getSelectionModel().getSelectedItem().getClasses_id());
            initialize_traintable();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void edit_train_table_select(MouseEvent event) {
        try {
            Train tri = edit_train_table.getSelectionModel().getSelectedItem();
            edit_traincodetxt.setText(String.valueOf(tri.getId()));
            edit_trainnametxt.setText(tri.getName());
            edit_train_co_combo.getSelectionModel().select(DBO.Search_company(tri.getId_co()));
            edit_train_class_combo.getSelectionModel().select(DBO.search_classes(tri.getClass_id()));
            edit_wagon_spinner.getValueFactory().setValue(tri.getWagons());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void edit_company_table_select(MouseEvent event) {
        Company com = edit_company_table.getSelectionModel().getSelectedItem();
        edit_company_codetxt.setText(String.valueOf(com.getId()));
        edit_company_nametxt.setText(com.getName());

    }

    @FXML
    private void edit_comany_btn(MouseEvent event) {
        try {
            DBO.edit_company(edit_company_nametxt.getText(), Integer.parseInt(edit_company_codetxt.getText()));
            initialize_companytable();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void edit_customer_btn(MouseEvent event) {
        try {

            DBO.edit_customer(edit_customer_nametxt.getText(), edit_customer_familytxt.getText(), Integer.parseInt(edit_customer_n_codetxt.getText()), edit_customer_phonetxt.getText());
            initialize_customertable();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void edit_customer_table_select(MouseEvent event) {
        Customer cus = edit_customer_table.getSelectionModel().getSelectedItem();
        edit_customer_n_codetxt.setText(String.valueOf(cus.getCustomer_id()));
        edit_customer_nametxt.setText(cus.getCustomr_name());
        edit_customer_familytxt.setText(cus.getCustomer_lname());
        edit_customer_phonetxt.setText(cus.getCustomer_phone());
    }

    @FXML
    private void edit_destination_btn(MouseEvent event) {
        try {
            DBO.edit_destination(Integer.parseInt(edit_destination_pricetxt.getText()),
                    Integer.parseInt(edit_destination_codetxt.getText()));
            initialize_destinationtable();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void edit_destination_table_select(MouseEvent event) {
        Destinations des = edit_destination_table.getSelectionModel().getSelectedItem();
        //String name = edit_destination_table.getSelectionModel().getSelectedItem().getDestination_name();
        //int privce = edit_destination_table.getSelectionModel().getSelectedItem().getDestination_price();
        //int id = edit_destination_table.getSelectionModel().getSelectedItem().getDestination_id();
        edit_destination_codetxt.setText(String.valueOf(des.getDestination_id()));
        edit_destination_pricetxt.setText(String.valueOf(des.getDestination_price()));
        edit_destination_nametxt.setText(des.getDestination_name());
    }

    @FXML
    private void loco_search_btn(MouseEvent event) {
        if (loco_searchtxt.getText().isEmpty()) {
            initialize_loco_search();
        } else {
            try {
                Locomotive_driver loco = DBO.Search_loco(Integer.parseInt(loco_searchtxt.getText()));
                loco_search_table.getItems().clear();
                loco_search_table_code.setCellValueFactory(new PropertyValueFactory("id"));
                loco_search_table_name.setCellValueFactory(new PropertyValueFactory("name"));
                loco_search_table_lname.setCellValueFactory(new PropertyValueFactory("lname"));
                loco_search_table_phone.setCellValueFactory(new PropertyValueFactory("phone"));
                loco_search_table_company.setCellValueFactory(new PropertyValueFactory("co_id"));
                loco_search_table.getItems().add(loco);

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void train_search_btn(MouseEvent event) {
        if (train_searchtxt.getText().isEmpty()) {
            initialize_train_search();
        } else {
            try {
                Train tri = DBO.Search_train(Integer.parseInt(train_searchtxt.getText()));
                train_search_table.getItems().clear();
                train_search_table_code.setCellValueFactory(new PropertyValueFactory("Id"));
                train_search_table_name.setCellValueFactory(new PropertyValueFactory("Name"));
                train_search_table_wagon.setCellValueFactory(new PropertyValueFactory("wagons"));
                train_search_table_class.setCellValueFactory(new PropertyValueFactory("class_id"));
                train_search_table_company.setCellValueFactory(new PropertyValueFactory("id_co"));
                train_search_table.getItems().add(tri);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void company_search_btn(MouseEvent event) {
        if (company_searchtxt.getText().isEmpty()) {
            initialize_company_search();
        } else {
            try {
                Company com = DBO.Search_company(Integer.parseInt(company_searchtxt.getText()));
                company_search_table.getItems().clear();
                company_search_table_code.setCellValueFactory(new PropertyValueFactory("Id"));
                company_search_table_name.setCellValueFactory(new PropertyValueFactory("Name"));
                company_search_table.getItems().add(com);

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void customer_search_btn(MouseEvent event) {
        if (customer_searchtxt.getText().isEmpty()) {
            initialize_customer_search();
        } else {
            try {
                Customer cus = DBO.Search_Customer(Integer.parseInt(customer_searchtxt.getText()));
                customer_search_table.getItems().clear();
                customer_search_table_idn.setCellValueFactory(new PropertyValueFactory("Customer_id"));
                customer_search_table_name.setCellValueFactory(new PropertyValueFactory("Customr_name"));
                customer_search_table_lname.setCellValueFactory(new PropertyValueFactory("Customer_lname"));
                customer_search_table_phone.setCellValueFactory(new PropertyValueFactory("Customer_phone"));
                customer_search_table.getItems().add(cus);

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void des_serach_btn(MouseEvent event) {
        if (destination_search_txt.getText().isEmpty()) {
            initialize_destination_search();
        } else {
            try {
                Destinations des = DBO.Search_des_byID(Integer.parseInt(destination_search_txt.getText()));
                des_serach_table.getItems().clear();
                des_serach_table_code.setCellValueFactory(new PropertyValueFactory("Destination_id"));
                des_serach_table_name.setCellValueFactory(new PropertyValueFactory("Destination_name"));
                des_serach_table_price.setCellValueFactory(new PropertyValueFactory("Destination_price"));
                des_serach_table.getItems().add(des);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void travel_group_train_btn(MouseEvent event) {
        try {
            String date = String.valueOf(travel_group_train_date.getValue());
            String time = String.valueOf(travel_group_train_time.getValue());
            Train tri = travel_group_train_combo.getSelectionModel().getSelectedItem();
            Locomotive_driver loco = travel_group_train_loco.getSelectionModel().getSelectedItem();
//        SimpleDateFormat txt = ;
            Timestamp stp = Timestamp.valueOf(date + " " + time + ":00");
            DBO.add_travel_group(tri, loco, stp);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFO");
            alert.setHeaderText(null);
            alert.setContentText("Added Sucsesfully...");
            alert.show();
//String S =new SimpleDateFormat("yyyy-MM-dd HH:mm").format(stp);
//System.out.println(S);
        } catch (Exception ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            showerror(ex);

        }

    }

    private void showerror(Exception ex) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("Look, an Exception Dialog");
        alert.setContentText("Could not find file blabla.txt!");

//Exception ex = new FileNotFoundException("Could not find file blabla.txt");
// Create expandable Exception.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

// Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

    @FXML
    private void travel_group_date_action(ActionEvent event) {
//        System.out.println(String.valueOf(travel_group_list_datetxt.getValue()));

        if (String.valueOf(travel_group_list_datetxt.getValue()).equals("null")) {
            initialize_travel_group_table();
        } else {
            try {
                String date = String.valueOf(travel_group_list_datetxt.getValue());
                Date d = Date.valueOf(date);
                ArrayList<Travel_group> list = DBO.search_tavel_group(d);
                Travel_group_table_list.getItems().clear();
                Travel_group_traincode_list.setCellValueFactory(new PropertyValueFactory("Tri_id"));
                Travel_group_trainname_list.setCellValueFactory(new PropertyValueFactory("Tri_name"));
                Travel_group_lococode_list.setCellValueFactory(new PropertyValueFactory("Dri_id"));
                Travel_group_loconame_list.setCellValueFactory(new PropertyValueFactory("Dri_name"));
                Travel_group_locolname_list.setCellValueFactory(new PropertyValueFactory("Dri_lname"));
                Travel_group_tabledate_list.setCellValueFactory(new PropertyValueFactory("Date"));
                for (Travel_group T : list) {
                    Travel_group_table_list.getItems().add(T);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void add_travel_btn(MouseEvent event) {
        try {
            Destinations des = add_travel_combo_destination.getSelectionModel().getSelectedItem();
            Travel_group trgp = add_travel_travelgroup_destination.getSelectionModel().getSelectedItem();
            DBO.add_travel(des, trgp);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFO");
            alert.setHeaderText(null);
            alert.setContentText("Added Sucsesfully...");
            alert.show();
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            showerror(ex);
        }
    }

    @FXML
    private void cancel_ticket_btn(MouseEvent event) {
        try {
            DBO.cancel_ticket(Integer.parseInt(cancel_tickettxt.getText()));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFO");
            alert.setHeaderText(null);
            alert.setContentText("Canceled Sucsesfully...");
            alert.show();
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            showerror(ex);
        }
    }

    @FXML
    private void add_ticket_btn(MouseEvent event) {
        try {
            String s = add_tickettxt.getText();
            Customer cus = DBO.Search_Customer(Integer.parseInt(s));
            Travel tra = travel_combo.getSelectionModel().getSelectedItem();
            DBO.add_ticket_(cus, tra);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFO");
            alert.setHeaderText(null);
            alert.setContentText("Added Sucsesfully...");
            alert.show();
        } catch (Exception ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            showerror(ex);
        }
    }

    @FXML
    private void list_travel_datetxt(ActionEvent event) {
    }

    @FXML
    private void search_ticket_txt(ActionEvent event) {
        if(tick_search_txt.getText().isEmpty())
        {
            initialize_ticket_table();
        }
        else{
            try {
                //  System.out.println("haaaaaa");
                Ticket tik = DBO.search_ticket(Integer.parseInt(tick_search_txt.getText()));
                
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
