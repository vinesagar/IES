/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import DB.Sql;
import Main.MainController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author VINAY
 */
public class Help {
    public static boolean mode;
    public static String sn;
    public static Exam exam;
    public static Center center;
    public static int port;
    static Map<String,Exam> allExams=new HashMap<>();
    public static Boolean updateExam=false;
    public static Boolean threadStopper=false;
    public static int t1=0,t2=0;
    
    
    
    

    
    
    public static Map<String,Exam> allExams(){
        try {
            String query = "select * from Exam";
            
            ResultSet rs= Sql.result(query);
            
            //ObservableList<Exam> elist = FXCollections.observableArrayList();
            
            while(rs.next()){
                Exam e=new Exam();
                e.id=rs.getInt("EXAM_ID");
                e.examName=rs.getString("EXAM_NAME");
                e.date=rs.getString("EXAM_DATE");
                e.time=rs.getString("EXAM_TIME");
                e.spNum=rs.getString("EXAM_SN");
                allExams.put(rs.getString("EXAM_NAME"), e);
                //elist.add(e);
                //selectExamCB.getItems().add(rs.getString("EXAM_NAME"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return allExams;
    }
    
    /*public Exam examMaker(int id){
        Exam result=new Exam();
        String query="select * from Exam where EXAM_ID = "+id;
        try {
            ResultSet rs =Sql.result(query);
            
                result.spNum=rs.getString("EXAM_SN");
                ArrayList<Applicant> applicants=new ArrayList<>();
                query="select * from apl"+result.spNum;
                ResultSet r1=Sql.result(query);
                while(r1.next()){
                    Applicant apl=new Applicant();
                    apl.appID=r1.getInt("APL_ID");
                    apl.applName=r1.getString("APL_NAME");
                    apl.applPassword=r1.getString("APL_PASSWORD");
                    apl.applUsername=r1.getString("APL_USERNAME");
                    apl.center=r1.getString("APL_CTR");
                    apl.coordinator=r1.getString("APL_CORD");
                    String[] qidSA=r1.getString("").split(":");
                    ArrayList<Integer> qidAL=new ArrayList<>();
                    for(String qIdS: qidSA){
                        qidAL.add(Integer.parseInt(qIdS));
                    }
                    apl.qID=qidAL;
                    apl.rollno=r1.getString("APL_ROLLNO");
                    apl.room=r1.getString("APL_ROOM");
                    applicants.add(apl);
                }
                result.applicants=applicants;
                ArrayList<Center> centers=new ArrayList<>();
                query="select * from ctr"+result.spNum;
                ResultSet r2 = Sql.result(query);
                while(r2.next()){
                    Center center=new Center();
                    center.HostName=r2.getString("");
                    center.centerName=r2.getString("");
                    center.centerAddress=r2.getString("");
                    
                }
                result.centers=centers;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Help.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
