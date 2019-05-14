/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealbook;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.scene.control.Alert;

/**
 *
 * @author faculty
 */
public class DBConnection {
    static Connection con;
    
    static Connection connect()
    {
        try
        {  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","fahim","fire");  
        }
        catch(Exception e)
        { 
            System.out.println(e);
        }
        return con;
    }
}
