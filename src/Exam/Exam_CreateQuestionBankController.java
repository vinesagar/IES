/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import DB.Sql;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import project1.Category;
import project1.Exam;
import project1.Help;
import project1.Question;

/**
 * FXML Controller class
 *
 * @author VINAY
 */
public class Exam_CreateQuestionBankController implements Initializable {

    @FXML
    private JFXComboBox<String> categoryCB;
    @FXML
    private JFXTextField categoryTF;
    @FXML
    private TextArea questionTA;
    @FXML
    private JFXTextField option1TF;
    @FXML
    private JFXTextField option2TF;
    @FXML
    private JFXTextField option3TF;
    @FXML
    private JFXTextField option4TF;
    @FXML
    private JFXTextField rightOptionTF;
    @FXML
    private AnchorPane createQuestionBankAnchor;
    @FXML
    private Text stat;
    @FXML
    private JFXButton adCatbtn;
    @FXML
    private Text stattxt;
    @FXML
    private JFXTextField toughnessTF;
    @FXML
    private Text numQuesTXT;
    @FXML
    private Text avgToughTXT;
    Exam exam;
    String sn; 
    //Category categ;
    Boolean update=false;
    Map<String,Category> categs=new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        exam=Help.exam;
        sn=exam.spNum;
        update=Help.updateExam;
        String s="select ctg_name from CTG"+sn;
        try {
            ResultSet rs=Sql.result(s);
            while(rs.next()){
                Category c = new Category();
                String sn=rs.getString("ctg_name");
                categoryCB.getItems().add(sn);
                c.catName=sn;
                categs.put(sn, c);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        for(Category cc: categs.values()){
        s="select * from qb"+sn+" where CATEGORY= '"+cc.catName+"'";
            try {
                ResultSet rss=Sql.result(s);
                while(rss.next()){
                    Question a=new Question();
                    a.qId=rss.getInt("Q_ID");
                    a.right=rss.getInt("RIGHTOP");
                    a.toughness=rss.getInt("TOUGHNESS");
                    a.option1=rss.getString("OP1");
                    a.option2=rss.getString("OP2");
                    a.option3=rss.getString("OP3");
                    a.option4=rss.getString("OP4");
                    a.question=rss.getString("QUESTION");
                    cc.ques.add(a);
                }
                categs.put(cc.catName, cc);
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex);
            }
            
        }
        
    }
    
    
    @FXML
    private void submitQuestionBank(ActionEvent event) throws IOException {
        System.out.println(categs);
        System.out.println(exam.qp.category);
        exam.qp.category=categs;
        System.out.println(categs);
        //exam.qp.category;
        Help.exam=exam;
        String s="exam_CreateQuestionPaper.fxml";
        AnchorPane v = FXMLLoader.load(getClass().getResource(s));
        createQuestionBankAnchor.getChildren().setAll(v);
    }

    @FXML
    private void addCategory(ActionEvent event) {
        if("".equals(categoryTF.getText())){
            stattxt.setText("Empty Category");
        }
        else{
            Category c=new Category();
            String cat=categoryTF.getText();
            categoryTF.setText("");
            c.catName=cat;
            categoryCB.getItems().add(cat);
            categoryCB.setValue(cat);
            categs.put(cat, c);
            
            String query="insert into CTG"+sn+"(ctg_name)"
                    + "values('"+cat+"')";
            try {
                Sql.query(query);
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    @FXML
    private void addQuestion(ActionEvent event) {
        String c=categoryCB.getValue();
        Question q= getQuestion(c);
        Category ce= categs.get(c);
        System.out.println("befor adding"+categs.get(c).ques.size());
        try{ce.ques.add(q);
        categs.put(c, ce);
        }
        catch(Exception e){System.out.print(e);}
        System.out.println("after adding"+categs.get(c).ques.size());
        System.out.println(ce);
        for(Map.Entry e:categs.entrySet()){
            System.out.println("Key:"+e.getKey()+" value:"+e.getValue());
        }
        clear();
    }

    public Question getQuestion(String cat){
        String ques=questionTA.getText();
        String op1=option1TF.getText();
        String op2=option2TF.getText();
        String op3=option3TF.getText();
        String op4=option4TF.getText();
        int rigTF=0;//Integer.parseInt(rightOptionTF.getText());
        int toughTF=Integer.parseInt(toughnessTF.getText());
        Question qu =new Question();
        qu.setQuestion(ques);
        qu.setOption1(op1);
        qu.setOption2(op2);
        qu.setOption3(op3);
        qu.setOption4(op4);
        qu.setRight(rigTF);
        qu.setToughness(toughTF);
        String query="insert into QB"+sn+"(question,category,op1,op2,op3,op4,rightop,toughness)"
                    + "values('"+ques+"','"+cat+"','"+op1+"','"+op2+"','"+op3+"','"+op4+"',"+rigTF+","+toughTF+")";
        try {
            Sql.query(query);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return qu;
    }
    
    void clear(){
        categoryTF.setText("");
        questionTA.setText("");
        option1TF.setText("");
        option2TF.setText("");
        option3TF.setText("");
        option4TF.setText("");
        rightOptionTF.setText("");
        toughnessTF.setText("");
    }
    
}