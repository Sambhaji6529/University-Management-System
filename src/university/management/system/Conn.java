
package university.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s; /*Creating Statement*/

    
    Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Register jdbc //
            c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem", "root","123456"); // connect to mysql //
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







