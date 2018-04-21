
package project1;
import java.net.InetAddress;



/**
 *
 * @author VINAY
 */
public class Connectionlocal {

     
    /**
     * Method for get System Name
     * @return  Host name
     */
    public String getSystemName(){  
        try{
            InetAddress inetaddress=InetAddress.getLocalHost(); //Get LocalHost refrence
            String name = inetaddress.getHostName();   //Get Host Name
            return name;   //return Host Name
        }
        catch(Exception E){
            E.printStackTrace();  //print Exception StackTrace
            return null;
        }
    }
     
    /**
     * method to get Host IP
     * @return Host IP Address
     */
    public String getIPAddress(){
         try{
            InetAddress inetaddress=InetAddress.getLocalHost();  //Get LocalHost refrence
            String ip = inetaddress.getHostAddress();  // Get Host IP Address
            return ip;   // return IP Address
        }
        catch(Exception E){
            E.printStackTrace();  //print Exception StackTrace
            return null;
        }
         
    }}
     
   