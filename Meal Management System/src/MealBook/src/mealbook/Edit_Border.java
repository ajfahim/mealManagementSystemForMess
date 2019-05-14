/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealbook;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

/**
 *
 * @author ajf
 */
public class Edit_Border {
    Scene editBorderScene(){
        Label name_lb = new Label("Name");
        Label pass_lb = new Label("Pass Word");
        Label contactNum_lb = new Label("Contact Number");
        Label type_lb = new Label("Type");
        
        
        JFXTextField name_tf = new JFXTextField();
        JFXTextField pass_tf = new JFXTextField();
        JFXTextField contactNum_tf = new JFXTextField();
        JFXComboBox type_tf = new JFXComboBox();
        type_tf.getItems().addAll("manager","border");
        
        
        JFXButton submit_btn = new JFXButton("Submit");
        
        submit_btn.setOnAction((ActionEvent event) -> {
            try {
                DBUtil.dbExecuteQuery("INSERT INTO User(User_Name,Pass,ContactNum,Type) VALUES ('"+name_tf.getText()+"','"+pass_tf.getText()+"','"+contactNum_tf.getText()+"','"+type_tf.getValue()+"')");
                DBCheck.showAlert("Done");
            } catch (SQLException ex) {
                Logger.getLogger(Deposite.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
                Logger.getLogger(Deposite.class.getName()).log(Level.SEVERE, null, ex);
            }
  
        });
        
        JFXButton goBack_btn = new JFXButton("Go Back");
        goBack_btn.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                MealBook.window.setScene(new Manager().managerScene());
            }
        });
       
        
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(5);
        gp.setVgap(5);
        gp.addColumn(1,name_lb,pass_lb,contactNum_lb,type_lb);
        gp.addColumn(2,name_tf,pass_tf,contactNum_tf,type_tf,submit_btn);
        gp.addRow(4,goBack_btn);
        MealBook.editBorder = new Scene(gp,500,500);
        return MealBook.editBorder;
    }
}
