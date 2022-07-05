package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class StockInsert {
    public String insertStockUpdate(String productname, String productprice , String stockavailable , String retailer){
        Connection conn = null;
        String result="";
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?"+
               "user=root&password=divijak-47" );
               System.out.println("Connnection succeded");

            Statement statement;
            statement = conn.createStatement();
            
            statement.executeUpdate(
                "Insert into stockinfo(`stockname`, `price`, `stockavailable`, `retailer`)  values ('"+productname+"','"+productprice+"','"+stockavailable+"','"+retailer+"')");
            
            statement.close();
            conn.close();
            result="Success";
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return result;
    }
    public static void main(String args[]){
        //  insertStockUpdate("Sample", "productprice", "stockavailable", "retailer");
    }
}
