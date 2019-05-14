/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealbook;

import com.jfoenix.controls.JFXButton;
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
import static mealbook.MealBook.border;

/**
 *
 * @author ajf
 */
public class Meal {
    Scene mealScene() throws SQLException{
        Label lb_Border = new Label("Border");
        ComboBox cb_Border = new ComboBox();
        
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
        DatePicker dp = new DatePicker();
        Label brakefastLb = new Label("Break Fast");
        Label lunchLb = new Label("Lunch");
        Label dinerLb = new Label("Diner");
        TextField brakefastTf = new TextField();
        TextField lunchTf = new TextField();
        TextField dinerTf = new TextField();
        Button submitBtn = new Button("Submit");
        
        submitBtn.setOnAction((ActionEvent event) -> {
            try {
                ResultSet rs1 = DBConnection.connect().createStatement().executeQuery("select User_Id from User Where User_Name = '"+cb_Border.getValue()+"'");
                String id=null;
                while(rs1.next()){
                    id=rs1.getString(1);
                }
                DBUtil.dbExecuteQuery("INSERT INTO Meal (User_Id,Date,BreakFast,Lunch,Dinner) VALUES ('"+Integer.parseInt(id)+"','"+dp.getValue()+"','"+Integer.parseInt(brakefastTf.getText())+"','"+Integer.parseInt(lunchTf.getText())+"','"+Integer.parseInt(dinerTf.getText())+"')");
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
        
        GridPane gpBorder = new GridPane();
        gpBorder.setAlignment(Pos.CENTER);
        gpBorder.setVgap(5);
        gpBorder.setHgap(5);
        gpBorder.addColumn(1, lb_Border,lb_Date,brakefastLb,dinerLb,lunchLb);
        gpBorder.addColumn(2,cb_Border,dp,brakefastTf,lunchTf,dinerTf,submitBtn );
        gpBorder.add(goBack_btn,3,5);
        
        MealBook.meal= new Scene(gpBorder,500,500);
        return MealBook.meal;
    }
}
