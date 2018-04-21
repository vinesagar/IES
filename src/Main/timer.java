/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.text.Text;

/**
 *
 * @author VINAY
 */
public class timer extends Thread {
    boolean stopper=false;
    Text t;
    Timer timer = new Timer();
    int hr;
    int min;
    int sec;
    int lev;
    @Override
    public void run(){
        
        timer.scheduleAtFixedRate(new TimerTask() {
            //MainController m = new MainController();
            //Text t =m.recentExamTimeRem;
            @Override
            public void run() {
                if(!stopper){
                    
                    if(lev==2)
                        t.setText(String.valueOf(sec));
                    else
                        t.setText(String.valueOf(sec));
                    sec++;
                    if (sec< 0){
                        sec=59;
                    min=min-1;}
                    if(min <0){
                        min=59;
                        hr=hr-1;
                    }
                    if(hr<0){
                        timer.cancel();
                    }
                }
                else{
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }
    public void ready(Text t,int hr,int min,int sec,int lev){
        this.t=t;
        this.hr=hr;
        this.min=min;
        this.sec=sec;
        this.lev=lev;
        this.start();
    }
    
    public void stopper(){
        this.stopper=true;
    }
    
    
    
}
