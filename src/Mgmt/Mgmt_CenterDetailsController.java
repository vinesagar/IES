/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mgmt;

import DB.Sql;
import project1.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.*;
import java.net.*;

import java.sql.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class Mgmt_CenterDetailsController implements Initializable {

    @FXML
    private JFXTextField centerName;
    @FXML
    private JFXTextArea centerAddress;
    @FXML
    private JFXTextField centerCodeTF;
    private ComboBox<String> chooseCenterCB;
    //private ComboBox<String> updateChooseCenterCB;
    @FXML
    private JFXTextField updtCenterNameTF;
    @FXML
    private JFXTextArea updtCenterAddressTA;
    @FXML
    private JFXTextField updtCenterCodeTF;
    //private ComboBox<String> deltChooseCenterCB;
    @FXML
    private Text dltCenterNameTXT;
    @FXML
    private Text dltCenterAddressTXT;
    @FXML
    private Text centerNameTXT;
    @FXML
    private Text centerAddressTXT;
    @FXML
    private Text centerCodeTXT;
    @FXML
    private JFXListView<String> allCentersLV;
    @FXML
    private JFXButton fileChooser;
    @FXML
    private AnchorPane main;

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            
        centerName.setText(Help.center.centerName);
        centerAddress.setText(Help.center.centerAddress);
        centerCodeTF.setText(Help.center.centerCode);
        updtCenterNameTF.setText(Help.center.centerName);
        updtCenterAddressTA.setText(Help.center.centerAddress);
        updtCenterCodeTF.setText(Help.center.centerCode);
        dltCenterNameTXT.setText(Help.center.centerName);
        dltCenterAddressTXT.setText(Help.center.centerAddress);}
        catch(Exception e){
            System.out.println(e);
        }
        ArrayList<String> al=new ArrayList<>();
        try{
            
            String query="select * from ctr"+Help.exam.spNum;
            ResultSet rs=Sql.result(query);
            while(rs.next()){
                al.add(rs.getString("CTR_NAME"));
            }
        }catch(Exception e){
            
        }
        allCentersLV.getItems().addAll(al);
    }    


    @FXML
    private void addCenter(ActionEvent event) {
        String cn =centerName.getText();
        String ca = centerAddress.getText();
        String cc=centerCodeTF.getText();
        String query="insert into ctr"+Help.exam.spNum+"(CTR_NAME,CTR_ADDRESS,CTR_CODE) values("
                + "'"+cn+"','"+ca+"','"+cc+"')";
        try {
            Sql.query(query);
                chooseCenterCB.getItems().add(cn);
                //updateChooseCenterCB.getItems().add(cn);
                //deltChooseCenterCB.getItems().add(cn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Mgmt_CenterDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          try {
              String serverName = InetAddress.getLocalHost().getHostAddress();
               int port = Integer.parseInt(cc);
              System.out.println("Connecting to " + serverName + " on port " + port);
            try (Socket client = new Socket(serverName, port)) {
                System.out.println("Just connected to " + client.getRemoteSocketAddress());
                OutputStream outToServer = client.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToServer);
                
                //out.writeUTF("Hello from " + client.getLocalSocketAddress());
                out.writeUTF("primary");
                out.writeUTF("details");
                InputStream inFromServer = client.getInputStream();
                ObjectInputStream a=new ObjectInputStream(inFromServer);
                //DataInputStream in = new DataInputStream(inFromServer);
                CenterDetails cd=(CenterDetails)a.readObject();
                query="select CTR_ID from ctr"+Help.exam.spNum+" where CTR_CODE='"+cc+"'";
                ResultSet rs = Sql.result(query);
                int ctID=rs.getInt("CTR_ID");
                query="create table RM"+Help.exam.spNum+ctID + "("
                        + "rm_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                        + "rm_name varchar(500),"
                        + "rm_no_seats integer,"
                        + "rm_pattern varchar(10))";
                Sql.query(query);
                
                for(Map.Entry<String, Room> rr: cd.rooms.entrySet()){
                    Room r=rr.getValue();
                    
                    query="insert into RM"+Help.exam.spNum+ctID+" (rm_name,rm_no_seats,rm_pattern) "
                            + "values ('"+r.roomName+"',"+r.noSeats+",'"+r.pattern+"')";
                    Sql.query(query);
                }
            }
          
          } catch (ClassNotFoundException | IOException | SQLException ex) {
                Logger.getLogger(Mgmt_CenterDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
      
    }

    @FXML
    private void viewCoordinators(ActionEvent event) throws IOException {
        String s="mgmt_CoOrdinarorDetails.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(s));
        main.getChildren().setAll(v);
    }

    @FXML
    private void viewRooms(ActionEvent event) throws IOException {
        String s="mgmt_RoomDetails.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(s));
        main.getChildren().setAll(v);
    }

    @FXML
    private void chooseExcelFile(ActionEvent event) {
    }

    @FXML
    private void updateCenter(ActionEvent event) {
        String un=updtCenterNameTF.getText();
        String ua=updtCenterAddressTA.getText();
        String uc=updtCenterCodeTF.getText();
        String query="update ctr"+Help.exam.spNum+" set "
                + "CTR_NAME='"+un+"',CTR_ADDRESS='"+ua+"',CTR_CODE='"+uc+"' where CTR_ID="+Help.center.centerID;
        try {
            Sql.query(query);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            
        }
    }

    @FXML
    private void deleteCenter(ActionEvent event) {
    }

    
}
