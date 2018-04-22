/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import Main.MainController;
import java.util.Timer;

/**
 *
 * @author VINAY
 */
public class Countdown extends Thread {
    int hr=0,min=0,sec=0,choice=0;
    MainController m;
    Timer timer = new Timer();
    public Countdown(int h,int m,int s,int c){
        this.hr=h;
        this.min=m;
        this.sec=s;
        choice=c;
    }
    @Override
    public void run(){
        while(Help.threadStopper==false){
            switch (choice){
                case 0:
                    m.setT1(hr+":"+min+":"+sec);
                    break;
                case 1:
                    m.setT2(hr+":"+min+":"+sec);
                    break;
            }
            
            sec=sec-1;
            if(sec==0){
                min=min-1;
                sec=60;
            }
            if(min==0){
                hr=hr-1;
                min=60;
            }
            if(hr<0)
            {
                 switch (choice){
                    case 0:
                        m.setT1("timer ended");
                        break;
                    case 1:
                        m.setT2("timer ended");
                        break;
                }
                break;
            }
        }
    }
}
