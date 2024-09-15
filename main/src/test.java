
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;


public class test {
    public static void main(String[] args) {
   test1();
          }
    public static void test1()
    {
        System.out.println(DBO.check_customer(33896579));
//        try {
//            
//           
//            Connection connection =  DatabaseConnection.getconnect();
//           // DBO.Connect();
//            String query="SELECT date FROM travel_group";
//            //Statement stmt =null;
//            
//            PreparedStatement pre = connection.prepareStatement(query);
//            ResultSet l = pre.executeQuery();
//            // Date date = new Date();
//            while(l.next())
//            {
//                Timestamp timestamp = l.getTimestamp("date");
//                //date;
//                System.out.println(timestamp.toString());
//            }   } catch (ClassNotFoundException ex) {
//            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}

