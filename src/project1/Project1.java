/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.sql.ResultSet;
import java.util.Random;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author VINAY
 */
public class Project1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        String rss="/Main/main.fxml";
        if(Comun.mode.equals("NN")){
            rss="/Setup/Setup_Mode.fxml";
        }
        Parent root = FXMLLoader.load(getClass().getResource(rss));
        Scene scene = new Scene(root);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.show();
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
