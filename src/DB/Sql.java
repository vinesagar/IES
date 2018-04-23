/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;

/**
 *
 * @author VINAY
 */
public class Sql {
    public static Connection connector() throws ClassNotFoundException{
    try{
        //Class.forName("org.sqlite.JDBC");
        //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        //Connection c = DriverManager.getConnection("jdbc:derby:IESprimary;create=true");
        Connection c=DriverManager.getConnection("jdbc:derby://localhost:1527/IESprimaryDB", "vinay","vinay");
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
    return c;
    }
 
    catch(SQLException e){return null;}
    
    }
    
    
    
    public static Boolean query(String s) throws ClassNotFoundException, SQLException{
        Boolean t;
        Connection c = connector();
        Statement st = c.createStatement();
        try{st.execute(s);return true;}
        catch(SQLException e){System.out.println(e);return false;}
        
    }
    
    public static ResultSet result(String s) throws ClassNotFoundException, SQLException{
        ResultSet r = null;
        Connection c = connector();
        Statement st = c.createStatement();
        try{
            r=st.executeQuery(s);
            return r;
        }
        catch(SQLException e){System.out.println(e);return r;}
    }
    
}
