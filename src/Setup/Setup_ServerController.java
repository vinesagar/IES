/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Setup;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project1.Comun;
import project1.Server;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class Setup_ServerController implements Initializable {

    @FXML
    private Text stat;
    @FXML
    public Text statTXT;
    
    @FXML
    private JFXButton a;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Comun.mode="Server";
        try {
            Thread t=new Server();
            t.start();
            
        
        } catch (IOException ex) {
            Logger.getLogger(Setup_ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void goOnline(ActionEvent event) {
        
    }
    
}
