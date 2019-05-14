/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealbook;

import com.jfoenix.controls.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 *
 * @author ajf
 */
public class Manager  {
    Scene managerScene(){
        JFXButton btn_deposite = new JFXButton("Deposite");
        
        btn_deposite.setMaxSize(100, 100);
        btn_deposite.setMinSize(100, 100);
        
        btn_deposite.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    
                    
                    MealBook.window.setScene(new Deposite().depositeScene());
                } catch (SQLException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
        });
        
        JFXButton btn_meal = new JFXButton("Meal");
        btn_meal.setMaxSize(100, 100);
        btn_meal.setMinSize(100, 100);
        
        btn_meal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hhh");
             
                try {
                    MealBook.window.setScene(new Meal().mealScene());
                } catch (SQLException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
        });
        
        JFXButton btn_bazar = new JFXButton("Bazar");
        btn_bazar.setMaxSize(100, 100);
        btn_bazar.setMinSize(100, 100);
        
        btn_bazar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hhh");
             
                try {
                    MealBook.window.setScene(new Bazar().bazarScene());
                } catch (SQLException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
        });
        
        JFXButton btn_editBorder = new JFXButton("Border");
        btn_editBorder.setMaxSize(100, 100);
        btn_editBorder.setMinSize(100, 100);
        
        btn_editBorder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hhh");
             
                MealBook.window.setScene(new Edit_Border().editBorderScene());
              
            }
        });
        JFXButton btn_Logout = new JFXButton("LogOut");
        
        btn_Logout.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                try {
                    DBUtil.dbDisconnect();
                } catch (SQLException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
       JFXButton report_Btn = new JFXButton("Report");
       report_Btn.setMaxSize(100, 100);
       report_Btn.setMinSize(100, 100);
       report_Btn.setOnAction(new EventHandler<ActionEvent>(){
           public void handle(ActionEvent event){
               try {
                   MealBook.window.setScene(new Report().reportScene());
               } catch (SQLException ex) {
                   Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
//        BorderPane bp = new BorderPane();
//        bp.setRight(btn_Logout);
        GridPane managerGp = new GridPane();
        managerGp.setAlignment(Pos.CENTER);
        managerGp.setVgap(30);
        managerGp.setHgap(40);
        managerGp.addRow(0,btn_deposite,btn_meal);
        managerGp.addRow(3,btn_bazar,btn_editBorder);
        managerGp.addRow(4,report_Btn);
        
        //managerGp.getChildren().addAll(managerGp,bp);
        MealBook.manager= new Scene(managerGp,500,500); 
        
        return MealBook.manager;
    }
    
}
