/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealbook;

import com.jfoenix.controls.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author ajf
 */
public class Bazar {
    Scene bazarScene() throws SQLException{
        Label lb_Border = new Label("Border");
        JFXComboBox cb_Border = new JFXComboBox();
        ResultSet rs = DBConnection.connect().createStatement().executeQuery("select User_Name from User");
        rs.last();
        
        int i = rs.getRow();
        String[] name = new String[i];
        i=0;
        //System.out.println(rs.getString("User_Name"));
        rs = DBConnection.connect().createStatement().executeQuery("select * from User");
        while(rs.next()) {
            name[i] = rs.getString("User_Name");
            i++;
        }
        cb_Border.setMinSize(150, 50);
        
        cb_Border.getItems().addAll(name);

        Label lb_Date = new Label("Date");
        JFXDatePicker dp = new JFXDatePicker();
        Label lb_Cost = new Label("Cost");
        TextField tf_Cost = new TextField();
        JFXButton btn_Submit = new JFXButton("Submit");
        
        btn_Submit.setOnAction((ActionEvent event) -> {
            try {
                ResultSet rs1 = DBConnection.connect().createStatement().executeQuery("select User_Id from User Where User_Name = '"+cb_Border.getValue()+"'");
                String id=null;
                while(rs1.next()){
                    id=rs1.getString(1);
                }
                DBUtil.dbExecuteQuery("INSERT INTO Bazar (User_Id,Date,Cost) VALUES ('"+Integer.parseInt(id)+"','"+dp.getValue()+"','"+Double.parseDouble(tf_Cost.getText())+"')");
                DBCheck.showAlert("submitted");
            } catch (SQLException ex) {
                Logger.getLogger(Deposite.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Meal.class.getName()).log(Level.SEVERE, null, ex);
            }
  
        });
        
        JFXButton goBack_btn = new JFXButton("Go Back");
        goBack_btn.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                MealBook.window.setScene(new Manager().managerScene());
            }
        });

        GridPane bazarGp = new GridPane();
        
        bazarGp.setAlignment(Pos.CENTER);
        bazarGp.setVgap(5);
        bazarGp.setHgap(5);
        
        bazarGp.addColumn(1, lb_Border,lb_Date,lb_Cost);
        bazarGp.addColumn(2,cb_Border,dp,tf_Cost,btn_Submit);
        bazarGp.add(goBack_btn,3,3);
        
        MealBook.bazar= new Scene(bazarGp,500,500);
        return MealBook.bazar;
    }
    }

