


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBO {

    private static Connection connection;

    public static void Connect() throws ClassNotFoundException, SQLException {

        connection = DatabaseConnection.getconnect();
        //throw new ClassNotFoundException("SomeThing");
    }

    public static void disconnect() throws ClassNotFoundException, SQLException {
        connection.close();
    }

    public static Customer Search_Customer(int code) throws ClassNotFoundException, SQLException {
        Connect();
        String query = "{call railway_.search_customer(?)}";
        ResultSet rel;
        Customer cus;
        try (PreparedStatement pre = connection.prepareStatement(query)) {
            pre.setInt(1, code);
            rel = pre.executeQuery();
            cus = new Customer();
            while (rel.next()) {
                cus.setCustomer_id(rel.getInt("customer_id"));
                cus.setCustomr_name(rel.getString("customer_name"));
                cus.setCustomer_lname(rel.getString("customer_lname"));
                cus.setCustomer_phone(rel.getString("phone"));
            }
        }
        rel.close();
        disconnect();
        return cus;
    }

    public static void Add_customer(Customer cus) throws ClassNotFoundException, SQLException {
        Connect();
        String query = "call railway_.add_customer(?,?,?,?)";
        try (PreparedStatement pre = connection.prepareStatement(query)) {
            pre.setString(1, cus.getCustomr_name());
            pre.setString(2, cus.getCustomer_lname());
            pre.setInt(3, cus.getCustomer_id());
            pre.setString(4, cus.getCustomer_phone());
            pre.executeQuery();
        }
        disconnect();

    }

    public static void edit_customer(String name, String lname, int code, String phone) throws ClassNotFoundException, SQLException {
        Connect();
        String query = "call railway_.edit_customer(?,?,?,?)";
        PreparedStatement pre = connection.prepareStatement(query);
        pre.setString(1, name);
        pre.setString(2, lname);
        pre.setString(3, phone);
        pre.setInt(4, code);
        pre.executeQuery();
        disconnect();
    }

    public static Company Search_company(int code) throws ClassNotFoundException, SQLException {
        Connect();
        String query = "call railway_.search_company(?)";
        ResultSet rel;
        Company com;
        try (PreparedStatement pre = connection.prepareStatement(query)) {
            pre.setInt(1, code);
            rel = pre.executeQuery();
            com = new Company();
            while (rel.next()) {
                com.setId(rel.getInt("company_id"));
                com.setName(rel.getString("co_name"));
            }
            rel.close();
            pre.close();
            disconnect();
            return com;

        }
    }

    public static void add_company(Company co) throws ClassNotFoundException, SQLException {
        Connect();
        String query = "call railway_.add_company(?,?)";
        PreparedStatement pre = connection.prepareStatement(query);
        pre.setString(1, co.getName());
        pre.setInt(2, co.getId());

        pre.executeQuery();
        pre.close();
        disconnect();
    }

    public static void edit_company(String name, int id) throws ClassNotFoundException, SQLException {
        Connect();
        String query = "call railway_.add_company(?,?)";
        PreparedStatement pre = connection.prepareStatement(query);
        pre.setInt(1, id);
        pre.setString(2, name);
        pre.executeQuery();
        disconnect();
    }

    public static Train Search_train(int code) throws ClassNotFoundException, SQLException {
        Connect();
        String query = "{call railway_.search_train(?)}";
        ResultSet rel;
        Train cus;
        try (PreparedStatement pre = connection.prepareStatement(query)) {
            pre.setInt(1, code);
            rel = pre.executeQuery();
            cus = new Train();
            while (rel.next()) {
                cus.setName(rel.getString("train_name"));
                cus.setClass_id(rel.getInt("class_id"));
                cus.setId(rel.getInt("train_id"));
                cus.setId_co(rel.getInt("co_id"));
                cus.setWagons(rel.getInt("wagons"));
            }
        }
        rel.close();
        disconnect();
        return cus;
    }

    public static void add_train(Train cus) throws ClassNotFoundException, SQLException {
        Connect();
        String query = "call railway_.add_train(?,?,?,?,?)";
        try (PreparedStatement pre = connection.prepareStatement(query)) {
            pre.setInt(1, cus.getId());
            pre.setString(2, cus.getName());
            pre.setInt(3, cus.getId_co());
            pre.setInt(4, cus.getClass_id());
            pre.setInt(5, cus.getWagons());
            pre.executeQuery();
        }
        disconnect();
    }

    public static void edit_train(String name, int id, int co_id, int wagon, int class_id) throws ClassNotFoundException, SQLException {
        Connect();
        String query = "call railway_.edit_train(?,?,?,?,?)";
        PreparedStatement pre = connection.prepareStatement(query);
        pre.setInt(1, id);
        pre.setString(2, name);
        pre.setInt(3, wagon);
        pre.setInt(4, class_id);
        pre.setInt(5, co_id);
        pre.executeQuery();
        disconnect();
    }

    public static Destinations Search_des_byID(int code) throws ClassNotFoundException, SQLException {
        Connect();
        String query = "{call railway_.search_destination_by_id(?)}";
        ResultSet rel;
        Destinations cus;
        try (PreparedStatement pre = connection.prepareStatement(query)) {
            pre.setInt(1, code);
            rel = pre.executeQuery();
            cus = new Destinations();
            while (rel.next()) {
                cus.setDestination_id(rel.getInt("destination_id"));
                cus.setDestination_name(rel.getString("destination_name"));
                cus.setDestination_price(rel.getInt("destination_price"));

            }
        }
        rel.close();
        disconnect();
        return cus;
    }

    public static Destinations Search_des_byname(String name) throws ClassNotFoundException, SQLException {
        Connect();
        String query = "{call railway_.search_des_by_name(?)}";
        ResultSet rel;
        Destinations cus;
        try (PreparedStatement pre = connection.prepareStatement(query)) {
            pre.setString(1, name);
            rel = pre.executeQuery();
            cus = new Destinations();
            while (rel.next()) {
                cus.setDestination_id(rel.getInt("destination_id"));
                cus.setDestination_name(rel.getString("destination_name"));
                cus.setDestination_price(rel.getInt("destination_price"));

            }
        }
        rel.close();
        disconnect();
        return cus;

    }

    public static void add_destination(Destinations des) throws ClassNotFoundException, SQLException {
        Connect();
        String query = "call railway_.add_destination(?,?,?)";
        try (PreparedStatement pre = connection.prepareStatement(query)) {
            pre.setInt(1, des.getDestination_id());
            pre.setString(2, des.getDestination_name());
            pre.setInt(3, des.getDestination_price());

            pre.executeQuery();
        }
        disconnect();
    }

    public static void edit_destination(int price, int id) throws ClassNotFoundException, SQLException {
        Connect();
        String query = "call railway_.edit_destination(?,?)";
        PreparedStatement pre = connection.prepareStatement(query);
        pre.setInt(1, price);
        pre.setInt(2, id);
        pre.executeQuery();
        disconnect();
    }

    public static Locomotive_driver Search_loco(int code) throws ClassNotFoundException, SQLException {

        Connect();
        String query = "{call railway_.search_driver(?)}";
        ResultSet rel;
        Locomotive_driver cus;
        try (PreparedStatement pre = connection.prepareStatement(query)) {
            pre.setInt(1, code);
            rel = pre.executeQuery();
            cus = new Locomotive_driver();
            while (rel.next()) {
                cus.setName(rel.getString("locomotive_driver_name"));
                cus.setLname(rel.getString("locomotive_driver_lname"));
                cus.setPhone(rel.getString("locomotive_driver_phone"));
                cus.setId(rel.getInt("locomotive_driver_id"));
                cus.setCo_id(rel.getInt("locomotive_driver_co"));
            }
        }
        rel.close();
        disconnect();
        return cus;
    }

    public static void add_loco(Locomotive_driver loco) throws ClassNotFoundException, SQLException {

        Connect();
        String query = "call railway_.add_driver (?,?,?,?,?)";
        try (PreparedStatement pre = connection.prepareStatement(query)) {
            pre.setString(1, loco.getName());
            pre.setString(2, loco.getLname());
            pre.setInt(4, loco.getId());
            pre.setString(3, loco.getPhone());
            pre.setInt(5, loco.getCo_id());
            pre.executeQuery();
            pre.close();
        }
        disconnect();
    }

    public static void edit_loco(String name, String lname, int co_id, String phone, int id) throws ClassNotFoundException, SQLException {
        Connect();
        String query = "call railway_.edit_driver(?,?,?,?,?)";
        PreparedStatement pre = connection.prepareStatement(query);
        pre.setInt(1, id);
        pre.setString(1, name);
        pre.setString(2, lname);
        pre.setString(3, phone);
        pre.setInt(4, co_id);
        pre.executeQuery();
        disconnect();
    }

    public static boolean check_customer(int id) {
        boolean check = true;
        try {

            Customer cus = Search_Customer(id);
            if (cus.getCustomer_id() != 0) {
                check = false;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return check;
    }
    public static boolean check_train(int id) {
        boolean check = true;
        try {

            Train cus = Search_train(id);
            if (cus.getId() != 0) {
                check = false;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    
    public static boolean check_company(int id) {
        boolean check = true;
        try {

            Company cus = Search_company(id);
            if (cus.getId() != 0) {
                check = false;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return check;
    }
    public static boolean check_loco(int id) {
        boolean check = true;
        try {

            Locomotive_driver cus = Search_loco(id);
            if (cus.getId() != 0) {
                check = false;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return check;
    }
    public static boolean check_dest_id(int id) {
        boolean check = true;
        try {

           Destinations cus = Search_des_byID(id);
            if (cus.getDestination_id() != 0) {
                check = false;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return check;
    }
    public static boolean check_dest_name(String id) {
        boolean check = false;
        try {

           Destinations cus = Search_des_byname(id);
            if (cus.getDestination_name().equals(null)) {
                check = true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return check;
    }

    public static Classes search_classes(int code) {
        Classes cls = new Classes();
        try {
            Connect();
            String query = "call railway_.search_class(?)";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setInt(1, code);
            ResultSet rel = pre.executeQuery();

            while (rel.next()) {
                cls.setClasses_chairs(rel.getInt("chairs"));
                cls.setClasses_id(code);
                cls.setClasses_name(rel.getString("class_name"));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cls;

    }

    public static void add_travel_group(Train tri, Locomotive_driver loco, Timestamp datetime) {
        try {
            Connect();
            String query = "call railway_.add_travel_group(?,?,?)";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setInt(1, tri.getId());
            pre.setInt(2, loco.getId());
            pre.setTimestamp(3, datetime);
            pre.executeQuery();
            pre.close();
            disconnect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void edit_travel_group(Train tri, Locomotive_driver loco, Timestamp datetime) {
        try {
            Connect();
            String query = "call railway_.edit_travel_group(?,?,?)";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setInt(1, tri.getId());
            pre.setInt(2, loco.getId());
            pre.setTimestamp(3, datetime);
            pre.executeQuery();
            pre.close();
            disconnect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Travel_group search_travel_group(Timestamp datetime) {
        Travel_group trgp = new Travel_group();
        try {
            Connect();
            String query = "call railway_.search_travel_group(?)";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setTimestamp(1, datetime);
            ResultSet rel = pre.executeQuery();
            Train tri = new Train();
            Locomotive_driver loco = new Locomotive_driver();
            while (rel.next()) {
                trgp.setDatetime(datetime);
                tri.setId(rel.getInt("train_id"));
                tri.setName(rel.getString("train_name"));
                loco.setId(rel.getInt("locomotive_driver_id"));
                loco.setLname(rel.getString("locomotive_driver_lname"));
                loco.setName(rel.getString("locomotive_driver_name"));
                trgp.setTri(tri);
                trgp.setDri(loco);
            }
            pre.close();
            rel.close();
            disconnect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trgp;
    }

    public static void add_travel(Train tri, Locomotive_driver loco, Destinations des, Timestamp datetime) {
        try {
            Connect();
            String query = "call railway_.add_travel(?,?,?,?)";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setInt(1, tri.getId());
            pre.setInt(2, loco.getId());
            pre.setTimestamp(3, datetime);
            pre.setInt(4, des.getDestination_id());
            pre.executeQuery();
            pre.close();

            disconnect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void edit_travel(Train tri, Locomotive_driver loco, Destinations des, Timestamp datetime) {
        try {
            Connect();
            String query = "call railway_.edit_travel(?,?,?,?)";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setInt(3, tri.getId());
            pre.setInt(2, loco.getId());
            pre.setTimestamp(1, datetime);
            pre.setInt(4, des.getDestination_id());
            pre.executeQuery();
            pre.close();

            disconnect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Travel search_travel(Timestamp datetime, int destination) {
        Travel tra = new Travel();
        try {
            Connect();
            String query = "call railway_.search_travel(?,?)";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setTimestamp(1, datetime);
            pre.setInt(2, destination);
            Train tri = new Train();
            Locomotive_driver loco = new Locomotive_driver();
            Travel_group trgp = new Travel_group();
            Destinations des = new Destinations();
            ResultSet rel = pre.executeQuery();
            while (rel.next()) {
                tri.setId(rel.getInt("train_id"));
                tri.setName(rel.getString("train_name"));
                loco.setName(rel.getString("locomotive_driver_name"));
                loco.setLname(rel.getString("locomotive_driver_lname"));
                loco.setId(rel.getInt("locomotive_driver_id"));
                trgp.setDri(loco);
                trgp.setTri(tri);
                des.setDestination_id(rel.getInt("destination_id"));
                des.setDestination_name(rel.getString("destination_name"));
                tra.setDis(des);
                tra.setTrg(trgp);
                tra.setCode(rel.getInt("travel_id"));
            }
            pre.close();
            rel.close();
            disconnect();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tra;
    }

    public static void add_ticket(Ticket tik) {
        try {
            Connect();
            String query = "call railway_.add_ticket(?,?,?,?)";
            PreparedStatement pre = connection.prepareStatement(query);
            // tra
            pre.setInt(1, tik.getCus().getCustomer_id());
            pre.setInt(2, tik.getTra().getCode());
            pre.setInt(3, tik.getChair());
            pre.setInt(4, tik.getWagon());
            pre.executeQuery();
            pre.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void add_ticket_(Customer cus, Travel tra) {
        try {
            Connect();
            String query = "call railway_.check_if_cancel(?)";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setTimestamp(1, tra.getTrg().getDatetime());
            ResultSet rel = pre.executeQuery();
            Travel_group trv = new Travel_group();
            Destinations dis = new Destinations();
            Ticket tik = null;
            while (rel.next()) {
               tik = new Ticket();
                trv.setDatetime(rel.getTimestamp("date"));
                dis.setDestination_id(rel.getInt("ticket_serial"));
                cus.setCustomer_id(rel.getInt("customer_id"));
                tra.setCode(rel.getInt("travel_id"));
                tra.setTrg(trv);
                tra.setDis(dis);
                tik.setChair(rel.getInt("chair_id"));
                tik.setWagon(rel.getInt("wagon_id"));
                tik.setStatus(rel.getBoolean("status"));
                tik.setTra(tra);
                tik.setCus(cus);
                add_ticket(tik);
            }
            if (tik == null) {
                String query_1 = "call railway_.search_num_ticket(?)";
                PreparedStatement pre1 = connection.prepareStatement(query_1);
                ResultSet rel1 = pre1.executeQuery();
                Travel_group trv1 = new Travel_group();
                Destinations dis1 = new Destinations();
                Train tri = new Train();
                Customer cus1 = new Customer();
                Travel tra1 = new Travel();
                Classes cls = new Classes();
                Ticket tik1 = null;
                while (rel1.next()) {
                   tik1 = new Ticket();
                    trv1.setDatetime(rel1.getTimestamp("date"));
                    dis1.setDestination_id(rel1.getInt("ticket_serial"));
                    cus1.setCustomer_id(rel1.getInt("customer_id"));
                    tra1.setCode(rel1.getInt("travel_id"));
                    tra1.setTrg(trv1);
                    tra1.setDis(dis1);
                    tri = Search_train(rel1.getInt("train_id"));
                    cls = search_classes(tri.getClass_id());
                    if (tik1.getWagon() <= tri.getWagons()) {
                        if (tik1.getChair() == 10 * cls.getClasses_chairs()) {
                            tik1.setChair(1);
                            tik1.setWagon(rel1.getInt("wagon_id") + 1);
                            
                        } else {
                            tik1.setChair(rel1.getInt("chair_id") + 1);
                            tik1.setWagon(rel1.getInt("wagon_id"));
                        }
                    }
                    add_ticket(tik1);
                    //tik1.setChair(rel1.getInt("chair_id"));
                    // tik1.setWagon(rel1.getInt("wagon_id"));
                    tik1.setTra(tra);
                    tik1.setCus(cus);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static ArrayList<Customer> list_customer()
    {
        ArrayList<Customer> list = new ArrayList<Customer>();
        try {
            Connect();
            String query = "SELECT * FROM railway_.customer";
            PreparedStatement pre = connection.prepareStatement(query);
            ResultSet rel = pre.executeQuery();
            Customer cus = null;
            while(rel.next())
            {
               cus = new Customer();
              cus.setCustomer_id(rel.getInt("customer_id"));
              cus.setCustomer_lname(rel.getString("customer_lname"));
              cus.setCustomer_phone(rel.getString("phone"));
              cus.setCustomr_name(rel.getString("customer_name"));
              list.add(cus);
            }
            pre.close();
            disconnect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static ArrayList<Company> list_company()
    {
        ArrayList<Company> list = new ArrayList<>();
        try {
            Connect();
            String query = "SELECT * FROM railway_.company";
            PreparedStatement pre = connection.prepareStatement(query);
            ResultSet rel = pre.executeQuery();
            Company cus = null;
            while(rel.next())
            {
               cus = new Company();
              cus.setId(rel.getInt("company_id"));
                cus.setName(rel.getString("co_name"));
              list.add(cus);
            }
            pre.close();
            disconnect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static ArrayList<Classes> list_classes()
    {
        ArrayList<Classes> list = new ArrayList<>();
        try {
            Connect();
            String query = "SELECT * FROM railway_.class";
            PreparedStatement pre = connection.prepareStatement(query);
            ResultSet rel = pre.executeQuery();
            Classes cus = null;
            while(rel.next())
            {
               cus = new Classes();
              cus.setClasses_id(rel.getInt("class_id"));
                cus.setClasses_name(rel.getString("class_name"));
                cus.setClasses_chairs(rel.getInt("chairs"));
              list.add(cus);
            }
            pre.close();
            disconnect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static ArrayList<Train> list_train()
    {
                ArrayList<Train> list = new ArrayList<>();  
        try {
            Connect();
            String query = "SELECT * FROM railway_.train";
            PreparedStatement pre = connection.prepareStatement(query);
            ResultSet rel = pre.executeQuery();
            Train cus = null;
            while(rel.next())
            {
                
                cus = new Train();
                cus.setName(rel.getString("train_name"));
                cus.setClass_id(rel.getInt("class_id"));
                cus.setId(rel.getInt("train_id"));
                cus.setId_co(rel.getInt("co_id"));
                cus.setWagons(rel.getInt("wagons"));
                list.add(cus);
                
            }
            pre.close();
            disconnect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;     
    }
    
    
}
