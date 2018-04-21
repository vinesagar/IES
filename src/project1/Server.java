/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

/**
 *
 * @author VINAY
 */
import java.net.*;
import java.io.*;
import java.util.Enumeration;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Server extends Thread {
   private static ServerSocket serverSocket;
   public static Boolean stopper=true;
   
   public Server() throws IOException {
       int port;
       Random rand = new Random();
       int min = 49152 ;
       int max= 65535-min;

        port = rand.nextInt(max) + min;
       while(!available(port)){
            port = rand.nextInt(max) + min;
       }
       Comun.port=port;
       serverSocket = new ServerSocket(port);
      //serverSocket.setSoTimeout(100000);
   }

   public void run() {
      while(true&&stopper) {
         try {
            System.out.println("Waiting for client on servername "+getLocalIpAddress()+" port " + 
            serverSocket.getLocalPort() + "...");
           
            Socket server = serverSocket.accept();
            
            System.out.println("Just connected to " + server.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(server.getInputStream());
            
            System.out.println(in.readUTF());
            System.out.println(in.readUTF());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()
               + "\nGoodbye!");
            out.writeUTF("Once again");
            server.close();
            
         } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
            break;
         } catch (IOException e) {
            e.printStackTrace();
            break;
         }
      }
   }
   
   public static boolean available(int port) {
   

    ServerSocket ss = null;
    DatagramSocket ds = null;
    try {
        ss = new ServerSocket(port);
        ss.setReuseAddress(true);
        
        ds = new DatagramSocket(port);
        ds.setReuseAddress(true);
        return true;
    } catch (IOException e) {
    } finally {
        if (ds != null) {
            ds.close();
        }

        if (ss != null) {
            try {
                ss.close();
            } catch (IOException e) {
                /* should not be thrown */
            }
        }
    }

    return false;
}
   
   public void stopper() throws SocketException{
   serverSocket.setSoTimeout(MIN_PRIORITY);
   }
   
   private String getLocalIpAddress() {
   try {
       for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
           NetworkInterface intf = en.nextElement();
           for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
               InetAddress inetAddress = enumIpAddr.nextElement();
               if (!inetAddress.isLoopbackAddress()) {
                   if (inetAddress instanceof Inet4Address) {
                       return ((Inet4Address)inetAddress).getHostAddress().toString();
                   }
               }
           }
       }
   } catch (SocketException ex) {
       System.out.println(ex);
   }
   return null;
}
   /*public static void main(String [] args) {
      int port = 8881;
      try {
         Thread t = new server(port);
         t.start();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }*/
}
