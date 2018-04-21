/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DB.Sql;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project1.Comun;
import project1.Server;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class MainController implements Initializable {
    
    @FXML
    private AnchorPane main;
    
    @FXML
    private Button homeBtn;
    
    @FXML
    private Button examBtn;
        
    @FXML
    private Button mgmtBtn;
    @FXML
    private Button notifBtn;
    @FXML
    private AnchorPane mainContent;
    @FXML
    private ListView<String> examsLV;
    @FXML
    private MenuItem exitOption;
    @FXML
    public Text recentExamTimeRem;
    @FXML
    public Text recentExamKeyTimer;
    @FXML
    private Text recentExamName;
    @FXML
    private Text recentExamQuestionsStatus;
    @FXML
    private Text recentExamCenterStatus;
    //timer t=new timer();
    //timer t1=new timer();
    @FXML
    private MenuBar mb;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //t.ready(recentExamTimeRem, 2, 0, 1, 3);
            //t1.ready(recentExamKeyTimer, 0, 30, 10, 2);
            String sql="CREATE TABLE Exam " +
                        "(Exam_id  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " + 
                        " Exam_name varchar(500)   , " +
                        " Exam_date varchar(500)    , " +
                        " Exam_time varchar(500)    , " +
                        " Exam_sN VARchar(500))";
              
        try {
            Sql.query(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
            ArrayList<String> elements= new ArrayList<>();
            ResultSet rs= Sql.result("select exam_name from exam");
            while(rs.next()){
                elements.add(rs.getString("exam_name"));
            }
            examsLV.getItems().addAll(elements);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void rootChange(javafx.event.ActionEvent e) throws IOException {
        //t.stopper();
        //t1.stopper();
        String fxml = "error.fxml";
        if(e.getSource()==homeBtn){fxml = "main.fxml";}
        else if(e.getSource()==examBtn){fxml = "/Exam/exam.fxml";}
        else if(e.getSource()==mgmtBtn){fxml = "/Mgmt/mgmt.fxml";}
        else if(e.getSource()==notifBtn){fxml = "/Notif/notif.fxml";}
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Node node=(Node) e.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.show();
    }

    /*private void anchorChange(javafx.event.ActionEvent event) throws IOException {
        AnchorPane v = FXMLLoader.load(getClass().getResource("test1.fxml"));
        a1.getChildren().setAll(v);
    }*/

    @FXML
    private void exit(javafx.event.ActionEvent event) {
        //t.stopper();
        //t1.stopper();
        Server.stopper=false;
        Platform.exit();
    }

    @FXML
    private void displatSetup(ActionEvent  e) throws IOException {
        String fxml = "/Setup/Setup_Mode.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        //Node node=(Node) e.getSource();
        Stage stage=(Stage) mb.getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.show();
    }

    private void displatSetup() throws IOException {
        String fxml = "/Setup/Setup_Mode.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        //Node node=(Node) e.getSource();
        Stage stage=(Stage) mb.getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.show();
    }
    
}
