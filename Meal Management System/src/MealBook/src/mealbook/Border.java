/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealbook;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import static mealbook.MealBook.border;

/**
 *
 * @author ajf
 */
public class Border {
    Scene borderScene(){
        Label lb_Date = new Label("Date");
        DatePicker dp = new DatePicker();
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
        gpBorder.add(lb_Date, 0, 0);
        gpBorder.add(dp, 1, 0);
        gpBorder.add(brakefastLb, 0, 1);
        gpBorder.add(brakefastTf, 1, 1);
        gpBorder.add(lunchLb, 0, 2);
        gpBorder.add(lunchTf, 1, 2);
        gpBorder.add(dinerLb, 0, 3);
        gpBorder.add(dinerTf, 1, 3);
        gpBorder.add(submitBtn,1,4);
        
        MealBook.border= new Scene(gpBorder,500,500);
        return MealBook.border;
    }
}
