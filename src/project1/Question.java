/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.util.ArrayList;

/**
 *
 * @author VINAY
 */
public class Question {
    public int qId;
    //String category;
    public String question;
    //ArrayList<String> questionImage;
    public String option1;
    //String op1img;
    public String option2;
    //String op2img;
    public String option3;
    //String op3img;
    public String option4;
    //String op4img;
    public int right;
    public int toughness;
    
    
    
   
    
    public String getQuestion(){
    return question;
    }
    
    public String getOption1(){
    return option1;
    }
    
    public String getOption2(){
    return option2;
    }
    
    public String getOption3(){
    return option3;
    }
    
    public String getOption4(){
    return option4;
    }
    
    public Integer getRight(){
    return right;
    }
    
    public Integer getToughness(){
    return right;
    }
    
   
    
    public void setQuestion(String question){
    this.question=question;
    }
    
    public void setOption1(String option1){
    this.option1=option1;
    }
    
    public void setOption2(String option2){
    this.option2=option2;
    }
    
    public void setOption3(String option3){
    this.option3=option3;
    }
    
    public void setOption4(String option4){
    this.option4=option4;
    }
    
    public void setRight(int right){
    this.right=right;
    }
    
    public void setToughness(int toughness){
    this.toughness=toughness;
    }
    
}
