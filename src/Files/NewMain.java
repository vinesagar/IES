/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author VINAY
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        // TODO code application logic here
        try{
            //Class.forName(string)
        Connection c=DriverManager.getConnection("jdbc:derby://localhost:1527/IESprimaryDB", "vinay","vinay");
        System.out.println("success");
        String q="create table c (id int)";
        Statement s=c.createStatement();
        s.execute(q);
        System.out.println("created table");
        
        }
        catch(SQLException e){
        System.out.println(e);
        }
    }
    
}
