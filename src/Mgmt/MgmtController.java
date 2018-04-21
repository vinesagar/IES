/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mgmt;

import DB.Sql;
import project1.*;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class MgmtController implements Initializable {

    @FXML
    private Button homeBtn;
    
    @FXML
    private Button examBtn;
        
    @FXML
    private Button mgmtBtn;
    @FXML
    private Button notifBtn;
    @FXML
    private AnchorPane main;
    @FXML
    private AnchorPane mgmtAnchor;
    @FXML
    private JFXComboBox<String> choosenExam;
    @FXML
    private MenuBar mb;
    @FXML
    private Text choosenExamTXT;
    @FXML
    private JFXComboBox<String> choosenCenter;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String query="select * from exam";
        try {
            ResultSet rs=Sql.result(query);
            while(rs.next()){
                Exam e=new Exam();
                e.examName=rs.getString("EXAM_NAME");
                e.date=rs.getString("EXAM_DATE");
                e.time=rs.getString("EXAM_TIME");
                e.spNum=rs.getString("EXAM_SN");
                choosenExam.getItems().add(e.examName);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }    


    @FXML
    private void rootChange(javafx.event.ActionEvent e) throws IOException {
        String fxml = "error.fxml";
        if(e.getSource()==homeBtn){fxml = "/Main/main.fxml";}
        else if(e.getSource()==examBtn){fxml = "/Exam/exam.fxml";}
        else if(e.getSource()==mgmtBtn){fxml = "mgmt.fxml";}
        else if(e.getSource()==notifBtn){fxml = "/Notif/notif.fxml";}
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Node node=(Node) e.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.show();
    
    }

    @FXML
    private void applicantDetails(ActionEvent event) throws IOException {
        String s="mgmt_ApplicantDetails.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(s));
        mgmtAnchor.getChildren().setAll(v);
    }

    @FXML
    private void coordinatorsDetails(ActionEvent event) {
    }

    @FXML
    private void SeatingDetails(ActionEvent event) {
    }

    @FXML
    private void examChoosed(ActionEvent event) {
        String query="select * from exam where EXAM_NAME='"+choosenExam.getValue()+"'";
        try {
            ResultSet rs=Sql.result(query);
            //while(rs.next()){
                Exam e=new Exam();
                e.id=rs.getInt("EXAM_ID");
                e.examName=rs.getString("EXAM_NAME");
                e.date=rs.getString("EXAM_DATE");
                e.time=rs.getString("EXAM_TIME");
                e.spNum=rs.getString("EXAM_SN");
                Help.exam=e;
                String ea="select * from ctr"+Help.exam.spNum;
        try {
            ResultSet rsa=Sql.result(ea);
            while(rsa.next()){
                ea=rsa.getString("CTR_NAME");
                choosenCenter.getItems().add(ea);
                //updateChooseCenterCB.getItems().add(e);
                //deltChooseCenterCB.getItems().add(e);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Mgmt_CenterDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
            //}
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void centerDetails(ActionEvent event) throws IOException {
        String s="mgmt_CenterDetails.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(s));
        mgmtAnchor.getChildren().setAll(v);
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void diasplaySetup(ActionEvent  e) throws IOException {
        String fxml = "/Setup/Setup_Mode.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage stage=(Stage) mb.getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.show();
    }

    @FXML
    private void centerChoosed(ActionEvent event) {
        String val=choosenCenter.getValue();
        String query="select * from ctr"+Help.exam.spNum+" where CTR_NAME='"+val+"'";
        try {
            ResultSet rs= Sql.result(query);
            Help.center.centerID=rs.getInt("CTR_ID");
            Help.center.centerName=rs.getString("CTR_NAME");
            Help.center.centerCode=rs.getString("CTR_CODE");
            Help.center.centerAddress=rs.getString("CTR_ADDRESS");
            
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

}
