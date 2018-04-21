/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import DB.Sql;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import project1.Category;
import project1.Exam;
import project1.Help;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class Exam_CreateQuestionPaperController implements Initializable {

    @FXML
    private JFXTextArea instructionsTA;
    @FXML
    private ComboBox<String> catCB;
    @FXML
    private JFXTextField quesNumCB;
    @FXML
    private Text totalQuesTXT;
    @FXML
    private TableView<Category> catQTV;
    @FXML
    private TableColumn<Category, String> catC;
    @FXML
    private TableColumn<Category, Integer> nQC;
    @FXML
    private JFXTextField toughnessTF;
    @FXML
    private AnchorPane main;
    @FXML
    private JFXTextField durationTF;
    
    Exam exam;
    int totalQ=0;
    String qb;
    Boolean update;
    @FXML
    private JFXTextField markCatTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        exam=Help.exam;
        qb=exam.spNum;
        update=Help.updateExam;
        
        String s="select ctg_name from CTG"+qb;
        try {
            ResultSet rs=Sql.result(s);
            while(rs.next()){
                Category c = new Category();
                String sn=rs.getString("ctg_name");
                System.out.println("db1"+sn);
                catCB.getItems().add(sn);
               
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        
        
        if(update){
            
        }
    }    

    @FXML
    private void setQuesNum(ActionEvent event) {
        String cat=catCB.getValue();
        //ArrayList<Category> na= new ArrayList<>();
System.out.println("cat found"+cat);
        Category c=exam.qp.category.get(cat);
        System.out.println("gotten category"+c);
        c.numQuestion=Integer.parseInt(quesNumCB.getText());
        exam.qp.category.put(cat, c);
        String query="update CTG"+qb+" set ctg_no_ques= '"+quesNumCB.getText()+"',"
                + "ctg_mark= '"+markCatTF.getText()+"' where ctg_name='"+cat+"'";
        //na.add(c);
        try {
            Sql.query(query);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        quesNumCB.setText("");
        markCatTF.setText("");
            }
            
         


    @FXML
    private void doneExam(ActionEvent event) throws IOException {
        String ins=instructionsTA.getText();
        exam.qp.instructions=ins;
        String tough =toughnessTF.getText();
        String query="Insert into QP"+qb+"(instruction,duration,toughness) values('"+ins+"','"+durationTF.getText()+"','"+tough+"')";
        
        try {
            Sql.query(query);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        String fxml="exam_examCreateSuccess.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(fxml));
        main.getChildren().setAll(v);
    }
    
}
