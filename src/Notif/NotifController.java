/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Notif;

import project1.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class NotifController implements Initializable {

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
    private MenuBar mb;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void rootChange(javafx.event.ActionEvent e) throws IOException {
        String fxml = "error.fxml";
        if(e.getSource()==homeBtn){fxml = "/Main/main.fxml";}
        else if(e.getSource()==examBtn){fxml = "/Exam/exam.fxml";}
        else if(e.getSource()==mgmtBtn){fxml = "/Mgmt/mgmt.fxml";}
        else if(e.getSource()==notifBtn){fxml = "notif.fxml";}
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Node node=(Node) e.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.show();
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void displatSetup(ActionEvent e) throws IOException {
        String fxml = "/Setup/Setup_Mode.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage stage=(Stage) mb.getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.show();
    }

}
