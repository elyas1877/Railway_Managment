
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getconnect() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/railway_","root","");
        return con;
    }
    
    
}
