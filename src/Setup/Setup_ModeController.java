/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Setup;

import DB.Sql;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project1.Comun;
import project1.Id;
import project1.Server;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class Setup_ModeController implements Initializable {

    @FXML
    private AnchorPane setupAP;
    @FXML
    private JFXTextField id;
    @FXML
    private Text newTXT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id.setText(""+Id.id);
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
    }    

    @FXML
    private void setOnline(ActionEvent event) throws IOException {
        String s="Setup_Online.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(s));
        setupAP.getChildren().setAll(v);
    }

    @FXML
    private void setServer(ActionEvent event) throws IOException {
        Comun.mode="Server";
        //try {
            //Thread t=new Server();
            //t.start();
        //} catch (IOException ex) {
        //    Logger.getLogger(Setup_ServerController.class.getName()).log(Level.SEVERE, null, ex);
        //}
        String fxml = "/Main/main.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        //Node node=(Node) .getSource();
        Stage stage=(Stage) id.getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.show();
    }

    @FXML
    private void home(ActionEvent e) throws IOException {
        String fxml = "/Main/main.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Node node=(Node) e.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.show();
    }

    @FXML
    private void setID(ActionEvent event) {
        Id.id=Integer.parseInt(id.getText());
    }

    @FXML
    private void newBTNFUNC(ActionEvent event) {
    }
    
}
