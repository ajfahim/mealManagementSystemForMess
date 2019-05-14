/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealbook;

import com.jfoenix.controls.JFXTextField;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author ajf
 */
public class Report {
    Scene reportScene() throws SQLException{
        Label totalMeal_lb = new Label("Total Meal :");
        Label totalCost_lb = new Label("Total Cost :");
        Label mealRate_lb = new Label("Meal Rate :");
        JFXTextField totalMeal_tf = new JFXTextField();
        totalMeal_tf.setEditable(false);
        
        double breakfast= 0;
        double lunch = 0;
        double diner = 0;
        
        try{
            //adding breakfast values
            ResultSet rs = DBConnection.connect().createStatement().executeQuery("select * from Meal");
        rs.last();
        int a = rs.getRow();
        Integer[] bf = new Integer[a];
        a=0;
        rs = DBConnection.connect().createStatement().executeQuery("select * from Meal");
        while(rs.next()) {
            bf[a] = Integer.parseInt(rs.getString("BreakFast"));
            a++;
        }
        try{
                for(int i =a; i>=0;i--){
                    
                breakfast = breakfast + bf[a-1];
                
                a--;
                }
            }
            catch(Exception e){
                System.out.println("in bf"+e);
            }
        //adding lunch values
        ResultSet rs2 = DBConnection.connect().createStatement().executeQuery("select * from Meal");
        rs2.last();
        int b = rs2.getRow();
        Integer[] l = new Integer[b];
        b=0;
        rs2 = DBConnection.connect().createStatement().executeQuery("select * from Meal");
        while(rs2.next()) {
            l[b] = Integer.parseInt(rs2.getString("Lunch"));
            b++;
        }
        try{
                for(int i =b; i>=0;i--){
                    
                lunch = lunch + l[b-1];
                
                b--;
                }
            }
            catch(Exception e){
                System.out.println("in bf"+e);
            }
        //adding dinner value
        ResultSet rs3= DBConnection.connect().createStatement().executeQuery("select * from Meal");
        rs3.last();
        int c = rs3.getRow();
        Integer[] d = new Integer[c];
        c=0;
        rs3 = DBConnection.connect().createStatement().executeQuery("select * from Meal");
        while(rs3.next()) {
            d[c] = Integer.parseInt(rs3.getString("Dinner"));
            c++;
        }
        try{
                for(int i =c; i>=0;i--){
                    
                diner = diner + d[c-1];
                
                c--;
                }
            }
            catch(Exception e){
                System.out.println("in bf"+e);
            }
       
        }
        catch(SQLException e){
            System.out.println(e);
        }
        totalMeal_tf.setText(Double.toString(diner+lunch+breakfast));
        
        JFXTextField totalCost_tf = new JFXTextField();
        totalCost_tf.setEditable(false);
        //adding total cost
        double totalCost = 0;
        try{
            ResultSet rs4= DBConnection.connect().createStatement().executeQuery("select * from Bazar");
        rs4.last();
        int m = rs4.getRow();
        Integer[] cost = new Integer[m];
        m=0;
        rs4 = DBConnection.connect().createStatement().executeQuery("select * from Bazar");
        while(rs4.next()) {
            cost[m] = Integer.parseInt(rs4.getString("Cost"));
            m++;
        }
        try{
                for(int i =m; i>=0;i--){
                    
                totalCost = totalCost + cost[m-1];
                
                m--;
                }
            }
            catch(Exception e){
                System.out.println("in bf"+e);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        totalCost_tf.setText(Double.toString(totalCost));
        
        JFXTextField mealRate_tf = new JFXTextField();
        mealRate_tf.setEditable(false);
        mealRate_tf.setText(Double.toString(totalCost/(diner+lunch+breakfast)));
        
//        totalMeal_txt.setJFXTextField("0");
//        totalCost_txt.setJFXTextField("0");
//        mealRate_txt.setJFXTextField("0");
        
        Label border_lb = new Label("Border");
        Label numOfMeal_lb = new Label("Number of Meal");
        Label balance_lb = new Label("Balance");
        
        JFXComboBox cb_border = new JFXComboBox();
        ResultSet rs1 = DBConnection.connect().createStatement().executeQuery("select User_Name from User");
        rs1.last();
        int i = rs1.getRow();
        String[] name = new String[i];
        i=0;
        rs1 = DBConnection.connect().createStatement().executeQuery("select User_Name from User");
        while(rs1.next()) {
            name[i] = rs1.getString("User_Name");
            i++;
        }
        
        cb_border.getItems().addAll(name);
        JFXTextField numOfMeal_tf = new JFXTextField();
        numOfMeal_tf.setEditable(false);
        Label deposit_lb = new Label("Deposit");
        JFXTextField deposit_tf = new JFXTextField();
        deposit_tf.setEditable(false);
        JFXTextField balance_tf = new JFXTextField();
        balance_tf.setEditable(false);
        JFXButton view_btn = new JFXButton("view");
        view_btn.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                //adding number of meal per person
        //breakfast
        double nombreakfast=0;
        double nomdiner = 0;
        double nomlunch = 0;
        double deposit = 0;
        try {
                ResultSet rs5 = DBConnection.connect().createStatement().executeQuery("select User_Id from User Where User_Name = '"+cb_border.getValue()+"'");
                String id=null;
                while(rs5.next()){
                    id=rs5.getString(1);
                }
                
              ResultSet rs6= DBConnection.connect().createStatement().executeQuery("select * from Meal where User_Id='"+id+"'");
        rs6.last();
        int n = rs6.getRow();
        Integer[] nombf = new Integer[n];
        n=0;
        rs6 = DBConnection.connect().createStatement().executeQuery("select * from Meal where User_Id ='"+id+"'");
        while(rs6.next()) {
            nombf[n] = Integer.parseInt(rs6.getString("BreakFast"));
            n++;
        }
        try{
                for (int j = n; j>=0;j--){
                    
                nombreakfast = nombreakfast + nombf[n-1];
                
                n--;
                }
            }
            catch(Exception e){
                System.out.println("in bf per person"+e);
            }
        
        
        
        //lunch
        
        ResultSet rs7= DBConnection.connect().createStatement().executeQuery("select * from Meal where User_Id='"+id+"'");
        rs7.last();
        int o = rs7.getRow();
        Integer[] noml = new Integer[o];
        o=0;
        rs7 = DBConnection.connect().createStatement().executeQuery("select * from Meal where User_Id ='"+id+"'");
        while(rs7.next()) {
            noml[o] = Integer.parseInt(rs7.getString("Lunch"));
            o++;
        }
        try{
                for (int j = o; j>=0;j--){
                    
                nomlunch = nomlunch + noml[o-1];
                
                o--;
                }
            }
            catch(Exception e){
                System.out.println("in lunch per person"+e);
            }
        
        
        //diner
        
        ResultSet rs8= DBConnection.connect().createStatement().executeQuery("select * from Meal where User_Id='"+id+"'");
        rs8.last();
        int p = rs8.getRow();
        Integer[] nomd = new Integer[p];
        p=0;
        rs8 = DBConnection.connect().createStatement().executeQuery("select * from Meal where User_Id ='"+id+"'");
        while(rs8.next()) {
            nomd[p] = Integer.parseInt(rs8.getString("Dinner"));
            p++;
        }
        try{
                for (int j = p; j>=0;j--){
                    
                nomdiner = nomdiner + nomd[p-1];
                
                p--;
                }
            }
            catch(Exception e){
                System.out.println("in Diner per person"+e);
            }
        
        
        //Adding deposit per person
        ResultSet rs9= DBConnection.connect().createStatement().executeQuery("select * from Deposite where User='"+id+"'");
        rs9.last();
        int q = rs9.getRow();
        Integer[] dep = new Integer[q];
        q=0;
        rs9 = DBConnection.connect().createStatement().executeQuery("select * from Deposite where User ='"+id+"'");
        while(rs9.next()) {
            dep[q] = Integer.parseInt(rs9.getString("Amount"));
            q++;
        }
        try{
                for (int j = q; j>=0;j--){
                    
                deposit = deposit + dep[q-1];
                
                q--;
                }
            }
            catch(Exception e){
                System.out.println("in deposit per person"+e);
            }
          
                
        }catch(Exception e){
            System.out.println(e);
        }
        numOfMeal_tf.setText(Double.toString(nomdiner+nomlunch+nombreakfast));
        deposit_tf.setText(Double.toString(deposit));
        double getDeposit = Double.parseDouble(deposit_tf.getText());
        double getTotalMealPerPerson = Double.parseDouble(numOfMeal_tf.getText());
        double getMealRate = Double.parseDouble(mealRate_tf.getText());
        balance_tf.setText(Double.toString(getDeposit-(getMealRate*getTotalMealPerPerson)));
            }
        });
        
        
        
        
        
        JFXButton goBack_btn = new JFXButton("Go Back");
        goBack_btn.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                MealBook.window.setScene(new Manager().managerScene());
            }
        });
        
        HBox hb = new HBox();
        hb.getChildren().addAll(cb_border,view_btn);
        
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(5);
        gp.setHgap(5);
        gp.addColumn(3,border_lb,numOfMeal_lb,deposit_lb,balance_lb);
        gp.addColumn(4,hb,numOfMeal_tf,deposit_tf,balance_tf);
        
        
        
        
        GridPane reportGp = new GridPane();
        reportGp.setAlignment(Pos.CENTER);
        reportGp.setVgap(5);
        reportGp.setHgap(5);
        reportGp.addColumn(1, totalMeal_lb,totalCost_lb,mealRate_lb);
        reportGp.addColumn(2, totalMeal_tf,totalCost_tf,mealRate_tf);
       
        VBox vb = new VBox();
        vb.setSpacing(50);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(reportGp,gp,goBack_btn);
        
        MealBook.report = new Scene(vb,500,500);
        return MealBook.report;
        
    }
}
