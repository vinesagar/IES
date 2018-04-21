/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import DB.Sql;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import project1.Comun;
import project1.Exam;
import project1.Help;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class Exam_CreateExamController implements Initializable {

    @FXML
    private JFXTextField examName;
    
    @FXML
    private AnchorPane createExamAnchor;
    @FXML
    private JFXDatePicker datetf;
    @FXML
    private JFXTimePicker timetf;
    @FXML
    private Text CENotif;
    public ArrayList<String> al;
    Exam e;
    Boolean update=false;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        update=Help.updateExam;
        Help.updateExam=false;
        if(update){
            examName.setText(Help.exam.examName);
            
            datetf.setValue(LocalDate.parse(Help.exam.date));
            timetf.setValue(LocalTime.parse(Help.exam.time));
        }
    }    

    @FXML
    private void createExam(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        
        String eName= examName.getText();
        
        
        String date="";
        if(datetf.getValue()!=null)
        date= datetf.getValue().toString();
        String time= "";
        if(timetf.getValue()!=null)
        time= timetf.getValue().toString();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYYMMddmmss");
	LocalDateTime now = LocalDateTime.now();
        String qb=dtf.format(now);
	//System.out.println(dtf.format(now));
        
        if(eName.equals("")||date.equals("")||time.equals(""))
        CENotif.setText("Something is missing!");
        else{
        if(Comun.mode.equals("Online")){
            //for online method
        }
        else if(Comun.mode.equals("Server")){
            //for server method
            if(update){
                String query="update exam set EXAM_NAME='"+eName+"',EXAM_DATE='"+date+"',EXAM_TIME='"+time+"',EXAM_SN='"+qb+"')"
                    + "values(,,,)";
            Sql.query(query);
            String s="exam_CreateQuestionBank.fxml";
            AnchorPane v =FXMLLoader.load(getClass().getResource(s));
            createExamAnchor.getChildren().setAll(v);
            }
            else{
            String query="insert into exam(EXAM_NAME,EXAM_DATE,EXAM_TIME,EXAM_SN)"
                    + "values('"+eName+"','"+date+"','"+time+"','"+qb+"')";
            Sql.query(query);
            System.out.println("1");
            //Help.sn=Integer.parseInt(qb);
            System.out.println("2");
            query="create table "+"QB"+qb+" ("
                    + "q_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "question varchar(5000),"
                    + "category varchar(500),"
                    + "op1 varchar(5000),"
                    + "op2 varchar(5000),"
                    + "op3 varchar(5000),"
                    + "op4 varchar(5000),"
                    + "rightop int,"
                    + "toughness int)";
            Sql.query(query);
            query="create table "+"CTR"+qb+" ("
                    + "Ctr_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "ctr_name varchar(5000),"
                    + "ctr_address varchar(500),"
                    + "ctr_code varchar(5000))";
            Sql.query(query);
            query="create table "+"APL"+qb+" ("
                    + "apl_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "apl_name varchar(5000),"
                    + "apl_rollno varchar(5000),"
                    + "apl_username varchar(500),"
                    + "apl_password varchar(500),"
                    + "apl_ctr varchar(5000),"
                    + "apl_cord varchar(5000),"
                    + "apl_ques varchar(5000),"
                    + "apl_room varchar(5000))";
            Sql.query(query);
            query="create table "+"QP"+qb+" ("
                    + "instruction varchar(5000),"
                    + "toughness varchar(500),"
                    + "duration varchar(500))";
            Sql.query(query);
            query="create table "+"CTG"+qb+" ("
                    + "ctg_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "ctg_name varchar(500),"
                    + "ctg_toughness varchar(500),"
                    + "ctg_mark varchar(500),"
                    + "ctg_no_ques varchar(500))";
            Sql.query(query);
            System.out.println("3");
            System.out.println("4");
            Exam ex=new Exam();
            ex.setDate(date);
            
            ex.setSpNum(qb);
            ex.setTime(time);
            ex.setExamName(eName);
            Help.exam=ex;
            String s="exam_CreateQuestionBank.fxml";
            AnchorPane v =FXMLLoader.load(getClass().getResource(s));
            createExamAnchor.getChildren().setAll(v);
        }}
        }
       
            
        /*}
        }
        }*/
        
    }
    
    
    
}
