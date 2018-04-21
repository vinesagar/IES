/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import project1.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author VINAY
 */
public class Exam {
    public int id;
    public String examName;
    public String date;
    public String time;
    public String spNum;
    public Map<Integer,Applicant> applicants= new HashMap<>();
    public ArrayList<Center> centers= new ArrayList<>();
    public ArrayList<Question> questionBank= new ArrayList<>();
    public QuestionPaper qp=new QuestionPaper();
    
    

    
 
    public String getExamName() {
        return examName;
    }
    public void setExamName(String fName) {
        this.examName=fName;
    }
        
    public String getDate() {
        return date;
    }
    public void setDate(String fName) {
        date=fName;
    }
    
    public String getTime() {
        return time;
    }
    public void setTime(String fName) {
        time=fName;
    }
    
    public String getSpNum() {
        return this.spNum;
    }
    
    public void setSpNum(String spNum) {
        this.spNum=spNum;
    }
    
}
    

