/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealbook;


import com.jfoenix.controls.*;
import java.sql.Connection;
import java.sql.ResultSet;
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
public class Deposite extends Manager {
    Scene depositeScene() throws SQLException{
        Label lb_Border = new Label("Border");
        JFXComboBox cb_Border = new JFXComboBox();
        ResultSet rs = DBConnection.connect().createStatement().executeQuery("select User_Name from User");
        rs.last();
        
        int i = rs.getRow();
        String[] name = new String[i];
        i=0;
        //System.out.println(rs.getString("User_Name"));
        rs = DBConnection.connect().createStatement().executeQuery("select User_Name from User");
        while(rs.next()) {
            name[i] = rs.getString("User_Name");
            i++;
        }
        cb_Border.setMinSize(150, 50);
        
        cb_Border.getItems().addAll(name);
        
        Label lb_Date = new Label("Date");
        JFXDatePicker dp = new JFXDatePicker();
        Label lb_Amount = new Label("Amount");
        JFXTextField tf_Amount = new JFXTextField();
        JFXButton btn_Submit = new JFXButton("Submit");
        
        btn_Submit.setOnAction((ActionEvent event) -> {
            try {
                ResultSet rs1 = DBConnection.connect().createStatement().executeQuery("select User_Id from User Where User_Name = '"+cb_Border.getValue()+"'");
                String id=null;
                while(rs1.next()){
                    id=rs1.getString(1);
                }
                DBUtil.dbExecuteQuery("INSERT INTO Deposite (Amount,Date,User) VALUES ('"+Integer.parseInt(tf_Amount.getText())+"','"+dp.getValue()+"','"+Integer.parseInt(id)+"')");
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

        GridPane depositeGp = new GridPane();
       
        depositeGp.setAlignment(Pos.CENTER);
        depositeGp.setVgap(5);
        depositeGp.setHgap(5);
        depositeGp.addRow(0,lb_Border,cb_Border);
        depositeGp.addRow(1,lb_Date,dp);
        depositeGp.addRow(2,lb_Amount,tf_Amount);
        depositeGp.addColumn(1,btn_Submit);
        depositeGp.add(goBack_btn,3,3);

        MealBook.deposite = new Scene(depositeGp,500,500);
        return MealBook.deposite;
    }
    
    
    
    
}
