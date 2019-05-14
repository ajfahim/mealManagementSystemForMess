/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealbook;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;

/**
 *
 * @author ajf
 */
public class DBUtil {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    private static Connection connection = null; 
    
    private static final String connStr = "jdbc:mysql://localhost:3306/Demo";
    
    public static void dbConnect() throws SQLException,ClassNotFoundException{
        try{
           Class.forName(JDBC_DRIVER);
        }
        catch(ClassNotFoundException e){
            System.out.println("Where is your mysql driver?");
            throw e;
        }
        
        System.out.println("JDBC Driver has been registered!");
        
        try{
            connection = DriverManager.getConnection(connStr,"fahim","fire");
        }
        catch(SQLException e){
            System.out.println("Connection Failed!"+e);
            throw e;
        }
    }
    
    public static void dbDisconnect()throws SQLException{
        try{
          if(connection != null && !connection.isClosed()){
              connection.close();
          }  
        }
        catch(SQLException e){
            throw e;
        }
    }
    
    public static void dbExecuteQuery(String sqlStmt)throws SQLException,ClassNotFoundException{
        Statement stmt = null;
        try{
          dbConnect();
          stmt = connection.createStatement();
          stmt.executeUpdate(sqlStmt);
          
        }
        catch(SQLException e){
            System.out.println("Problem occured at dbExecuteQuery operation"+ e);
            throw e;
        }
        finally{
            if(stmt != null){
                stmt.close();
            }
            dbDisconnect();
        }
    } 
    
    public static ResultSet dbExecute(String sqlQuery) throws SQLException,ClassNotFoundException{
        Statement stmt = null;
        ResultSet rs = null;
        CachedRowSetImpl crs = null;
        try{
            dbConnect();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            crs = new CachedRowSetImpl();
            crs.populate(rs);
        }
        catch(SQLException e){
            System.out.println("Error occured in dbExecute operation" + e);
            throw e;
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            dbDisconnect();
        }
        return crs;
    }
}


























