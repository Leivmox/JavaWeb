package conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao2 {

    Connection con = null;

    public Connection connection() {
//===================
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myweb", "root", "123456");

            this.con = con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //=================
        return con;
    }
}
