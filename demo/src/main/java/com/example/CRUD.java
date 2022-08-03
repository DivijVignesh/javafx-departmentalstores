package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class CRUD {
    public void StockCreate(){
        Connection conn = null;
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?"+
               "user=divij&password=password" );
               System.out.println("Connnection succeded");

            Statement statement;
            statement = conn.createStatement();
            
            statement.executeUpdate(
                "create table IF NOT EXISTS stockinfo( id int PRIMARY KEY, productname nvarchar(50), productprice nvarchar(50), stockavailable nvarchar(50), retailer nvarchar(50));");
            
            statement.close();
            conn.close();
            System.out.println("Table Created");
            
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
    }
    public void insertStockUpdate(String productname, String productprice , String stockavailable , String retailer){
        Connection conn = null;
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?"+
               "user=divij&password=password" );
               System.out.println("Connnection succeded");

            Statement statement;
            statement = conn.createStatement();
            
            statement.executeUpdate(
                "Insert into stockinfo(`productname`, `productprice`, `stockavailable`, `retailer`)  values ('"+productname+"','"+productprice+"','"+stockavailable+"','"+retailer+"')");
            
            statement.close();
            conn.close();
            System.out.println("Insertion completed");
            
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
    }
    public void StockUpdate(String productname ,String newname){
        Connection conn = null;
        
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?"+
               "user=divij&password=password" );
               System.out.println("Connnection succeded");

            Statement statement;
            statement = conn.createStatement();
            
            statement.executeUpdate(
                "update stockinfo set productname= '"+newname+"' where productname='"+productname+"' ;");
            
            statement.close();
            conn.close();
            System.out.println("Updated the value to "+newname);
            
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
    }
    public static void main(String args[]){
        CRUD obj = new CRUD();
        obj.StockCreate();
        obj.insertStockUpdate("oreo", "99", "100", "me");
        obj.StockUpdate("oreo", "Oreo");
    }
}
