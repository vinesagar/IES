/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mgmt;

import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class Mgmt_RoomDetailsController implements Initializable {

    @FXML
    private Text roomName;
    @FXML
    private Text noSeats;
    @FXML
    private Text pattern;
    @FXML
    private JFXListView<?> roomsLV;
    @FXML
    private Text dltRoomName;
    @FXML
    private Text dltNoSeats;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addRoom(ActionEvent event) {
    }

    @FXML
    private void updateRoom(ActionEvent event) {
    }

    @FXML
    private void deleteRoom(ActionEvent event) {
    }
    
}
