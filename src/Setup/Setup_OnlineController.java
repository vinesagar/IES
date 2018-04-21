/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Setup;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project1.Comun;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class Setup_OnlineController implements Initializable {

    @FXML
    private JFXTextField urlTF;
    @FXML
    private Text statusTXT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setOnline(ActionEvent event) throws IOException {
        String url = urlTF.getText();
        Comun.mode="Online";
        Comun.url=url;
        statusTXT.setText("Done");
        String fxml = "/Main/main.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        //Node node=(Node) .getSource();
        Stage stage=(Stage) urlTF.getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.show();
    }
    
}
