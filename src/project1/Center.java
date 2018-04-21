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
public class Center {
    public int centerID;
    public String centerName,centerAddress;
    public ArrayList<Room> roomList=new ArrayList<>();
    public ArrayList<Coordinator> coOrdinatorList=new ArrayList<>();
    public String centerCode;
    public int port;
    public String HostName;
    
    public void setRoomList(ArrayList<Room> roomList){
        this.roomList=roomList;
        
    }
}
