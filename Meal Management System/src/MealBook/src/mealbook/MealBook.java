/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealbook;

import com.jfoenix.controls.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.stage.Stage;

/**
 *
 * @author ajf
 */
public class MealBook extends Application {
    
    static Stage window;
    static Scene home, manager,border,deposite,meal,bazar,editBorder,report;
    
     public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        //***************home****************
        Label userIdLb = new Label("User ID");
        JFXTextField userIdTf = new JFXTextField();
        Label passLb = new Label("PassWord");
        JFXPasswordField passTf = new JFXPasswordField();
        JFXButton loginBtn = new JFXButton("Login");
        
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
          public void handle(ActionEvent event) {
                if(userIdTf.getText().isEmpty() || passTf.getText().isEmpty()){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setHeaderText("Email or password must not be empty!");
                    alert.showAndWait();
                }
                else {
                    if(DBCheck.check(userIdTf.getText(), passTf.getText()).equals("border")){
                        
                            window.setScene(new Border().borderScene());
                    }
                    if(DBCheck.check(userIdTf.getText(), passTf.getText()).equals("manager")){
                        
                            window.setScene(new Manager().managerScene());
                    }
                    
                }
            }
        });
        


        GridPane gpHome = new GridPane();
        gpHome.setAlignment(Pos.CENTER);
        gpHome.setHgap(7);
        gpHome.setVgap(6);
        gpHome.add(userIdLb,0,1);
        gpHome.add(userIdTf,1,1);
        gpHome.add(passLb,0,2);
        gpHome.add(passTf,1,2);
        gpHome.add(loginBtn, 1, 3);
        
        
        home = new Scene(gpHome, 500, 500);
        
        //****************manager**********************
//        Button bazarcostBtn = new Button("Bazar Cost");
//        Button editBorderBtn = new Button("Edit Border");
//        
//        
//        VBox vb = new VBox(20); 
//        vb.getChildren().addAll(bazarcostBtn, editBorderBtn);
//        GridPane gp = new GridPane();
//        gp.setPadding(new Insets(51,52,51,5));
//        gp.add(vb,0,0);
//        manager = new Scene(gp, 500,300);
        
        
        
        //**********************border******************************
        Label brakefastLb = new Label("Break Fast");
        Label lunchLb = new Label("Lunch");
        Label dinerLb = new Label("Diner");
        TextField brakefastTf = new TextField();
        TextField lunchTf = new TextField();
        TextField dinerTf = new TextField();
        Button submitBtn = new Button("Submit");
        
        GridPane gpBorder = new GridPane();
        gpBorder.setAlignment(Pos.CENTER);
        gpBorder.setVgap(5);
        gpBorder.setHgap(5);
        gpBorder.add(brakefastLb, 0, 1);
        gpBorder.add(brakefastTf, 1, 1);
        gpBorder.add(lunchLb, 0, 2);
        gpBorder.add(lunchTf, 1, 2);
        gpBorder.add(dinerLb, 0, 3);
        gpBorder.add(dinerTf, 1, 3);
        gpBorder.add(submitBtn,1,4);
        
        border= new Scene(gpBorder,500,300);
        
        
        window.setScene(home);
        window.setTitle("MealBook");
        window.show();
        
      
    }

  
    
}
