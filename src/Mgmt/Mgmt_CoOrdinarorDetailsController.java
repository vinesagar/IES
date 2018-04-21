/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mgmt;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class Mgmt_CoOrdinarorDetailsController implements Initializable {

    @FXML
    private Text crName;
    @FXML
    private Text crUsername;
    @FXML
    private Text crPassword;
    @FXML
    private JFXListView<String> crListLV;
    @FXML
    private ComboBox<String> updtCrList;
    @FXML
    private JFXTextField updtCrNameTF;
    @FXML
    private ComboBox<String> updtCrGenderCB;
    @FXML
    private ComboBox<?> dltCrList;
    @FXML
    private Text dltCrNameTXT;
    @FXML
    private Text dltCrGenderTXT;
    @FXML
    private ComboBox<String> crListCB;
    @FXML
    private JFXTextField addCrNameTF;
    @FXML
    private ComboBox<String> addCrGenderCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<String> genders=new ArrayList<>();
        genders.add("male");
        genders.add("female");
        updtCrGenderCB.getItems().addAll(genders);
        addCrGenderCB.getItems().addAll(genders);
    }    

    @FXML
    private void viewRooms(ActionEvent event) {
    }

    @FXML
    private void updtCr(ActionEvent event) {
    }

    @FXML
    private void dltCr(ActionEvent event) {
    }

    @FXML
    private void showCr(ActionEvent event) {
    }

    @FXML
    private void addCr(ActionEvent event) {
    }
    
}
