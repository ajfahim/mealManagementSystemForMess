/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealbook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author faculty
 */
public class DBCheck {
    static public void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");
        alert.setHeaderText("Results:");
        alert.setContentText(s);
        alert.showAndWait();
    }
    public static String check(String UserName, String pass){
        Connection c;
        try {
            c = DBConnection.connect();
            
            String SQL = "select * from User where User_Name='"+UserName+"' and pass = '"+pass+"'";
            //ResultSet  
            ResultSet rs = c.createStatement().executeQuery(SQL);
            if(rs.next()){
                String type = rs.getString("Type");
                //showAlert("Login Successful");
                return type;
            }
            else {
                showAlert("Email or password do not match");
                return "false";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            System.out.println("Error on Building Data");
        }
      return "false";  
    }
}
