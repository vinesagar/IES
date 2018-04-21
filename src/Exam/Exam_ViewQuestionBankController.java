/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import project1.*;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class Exam_ViewQuestionBankController implements Initializable {

    @FXML
    private AnchorPane viewQuestionBankAnchor;
    @FXML
    private TableView<Question> questionBank;
    @FXML
    private TableColumn<Question, String> category;
    @FXML
    private TableColumn<Question, String> question;
    @FXML
    private TableColumn<Question, String> option1;
    @FXML
    private TableColumn<Question, String> option2;
    @FXML
    private TableColumn<Question, String> option3;
    @FXML
    private TableColumn<Question, String> option4;
    @FXML
    private TableColumn<Question, String> right;
    @FXML
    private TableColumn<Question, String> edit;
    @FXML
    private TableColumn<Question, String> delete;
    @FXML
    private JFXButton addQuestionBTN;
    public ArrayList<Question> ql = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        questionBank.getItems().addAll(ql);
        //category.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getCategory()));
        question.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getQuestion()));
        option1.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getOption1()));
        option2.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getOption2()));
        option3.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getOption3()));
        option4.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getOption4()));
        right.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getRight().toString()));
        edit.setCellValueFactory(c-> new SimpleStringProperty("Edit"));
        delete.setCellValueFactory(c-> new SimpleStringProperty("Delete"));
    }    

    @FXML
    private void addQuestions(ActionEvent event) throws IOException {
        String s="exam_CreateQuestionBank.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(s));
        viewQuestionBankAnchor.getChildren().setAll(v);
    }
    
}
