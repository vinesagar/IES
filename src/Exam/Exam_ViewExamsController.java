/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

//import project1.Exam;
import DB.Sql;
import java.io.IOException;
import project1.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class Exam_ViewExamsController implements Initializable {

    @FXML
    private TableColumn<Exam, String> examName;
    @FXML
    private TableColumn<Exam, String> date;
    @FXML
    private TableColumn<Exam, String> time;
    @FXML
    private TableView<Exam> examsTV;
    @FXML
    private Text enameTXT;
    @FXML
    private ComboBox<String> selectExamCB;
    Exam exam;
    Map<String,Exam> examsList=new HashMap<>();
    @FXML
    private AnchorPane main;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            String query = "select * from Exam";            
            ResultSet rs= Sql.result(query);            
            ObservableList<Exam> elist = FXCollections.observableArrayList();            
            while(rs.next()){
            Exam e=new Exam();
            e.examName=rs.getString("EXAM_NAME");
            e.date=rs.getString("EXAM_DATE");
            e.time=rs.getString("EXAM_TIME");
            e.spNum=rs.getString("EXAM_SN");            //exams
            elist.add(e);
            selectExamCB.getItems().add(rs.getString("EXAM_NAME"));            }
                        examName.setCellValueFactory(
                    new PropertyValueFactory<>("examName"));
            date.setCellValueFactory(
                    new PropertyValueFactory<>("date"));
            time.setCellValueFactory(
                    new PropertyValueFactory<>("time"));
            examsTV.setItems(elist);
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);            
        }
    }    

    @FXML
    private void editExamDetails(ActionEvent event) throws IOException {
        Help.updateExam=true;
        String fxml="exam_CreateExam.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(fxml));
        main.getChildren().setAll(v);
    }

    @FXML
    private void deleteExam(ActionEvent event) {
    }

    @FXML
    private void editQuestionBank(ActionEvent event) throws IOException {
        Help.updateExam=true;
        String fxml="exam_ViewQuestionBank.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(fxml));
        main.getChildren().setAll(v);
    }

    @FXML
    private void editQuesPaper(ActionEvent event) throws IOException {
        Help.updateExam=true;
        String fxml="exam_CreateQuestionPaper.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(fxml));
        main.getChildren().setAll(v);
    }

    @FXML
    private void examChoosen(ActionEvent event) {
        examsList=Help.allExams();
        String ex=selectExamCB.getValue();
        exam=examsList.get(ex);
        Help.exam=exam;
        enameTXT.setText(ex);
    }

    



    
}
