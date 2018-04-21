/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import DB.Sql;
import project1.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class ExamController implements Initializable {
    
    @FXML
    private Button homeBtn;
    @FXML
    private Button examBtn;
    @FXML
    private Button mgmtBtn;
    @FXML
    private Button notifBtn;
    @FXML
    private AnchorPane examAnchor;
    @FXML
    private AnchorPane main;
    public ArrayList<String> al;
    @FXML
    private MenuBar mb;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String sql="CREATE TABLE Exam " +
                        "(Exam_id  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " + 
                        " Exam_name varchar(500)   , " +
                        " Exam_date varchar(500)    , " +
                        " Exam_time varchar(500)    , " +
                        " Exam_sN int)";
              
        try {
            Sql.query(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }    


    @FXML
    private void rootChange(javafx.event.ActionEvent e) throws IOException {
        String fxml = "error.fxml";
        if(e.getSource()==homeBtn){fxml = "/Main/main.fxml";}
        else if(e.getSource()==examBtn){fxml = "exam.fxml";}
        else if(e.getSource()==mgmtBtn){fxml = "/Mgmt/mgmt.fxml";}
        else if(e.getSource()==notifBtn){fxml = "/Notif/notif.fxml";}
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Node node=(Node) e.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.show();
    }

    @FXML
    private void createExam(ActionEvent event) throws IOException {
        String s="exam_CreateExam.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(s));
        examAnchor.getChildren().setAll(v);
    }

    @FXML
    private void viewExams(ActionEvent event) throws IOException {
        String s="exam_ViewExams.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(s));
        examAnchor.getChildren().setAll(v);
    }

    @FXML
    private void getExams(ActionEvent event) throws IOException {
        String s="exam_getExam.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(s));
        examAnchor.getChildren().setAll(v);
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
       
    }

    @FXML
    private void displaySetup(ActionEvent e) throws IOException {
        String fxml = "/Setup/Setup_Mode.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage stage=(Stage) mb.getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.show();
    }

}
