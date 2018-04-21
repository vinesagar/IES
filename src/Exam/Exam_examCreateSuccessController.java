/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import project1.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class Exam_examCreateSuccessController implements Initializable {

    @FXML
    private AnchorPane examSuccessAnchor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewExam(ActionEvent event) throws IOException {
        String s="exam_ViewExams.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(s));
        examSuccessAnchor.getChildren().setAll(v);
    }

    @FXML
    private void createExam(ActionEvent event) throws IOException {
        String s="exam_CreateExam.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(s));
        examSuccessAnchor.getChildren().setAll(v);
    }

    @FXML
    private void viewQuestionBank(ActionEvent event) throws IOException {
        String s="exam_ViewQuestionBank.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(s));
        examSuccessAnchor.getChildren().setAll(v);
    }
    
}
