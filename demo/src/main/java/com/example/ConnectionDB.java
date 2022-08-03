package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



import java.sql.*;
public class ConnectionDB {
    public void selectStatement(){
        Connection conn = null;
        
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?"+
               "user=divij&password=password" );
               System.out.println("Connnection succeded");  

               Statement statement;
               statement = conn.createStatement();
               ResultSet resultSet;
               resultSet = statement.executeQuery(
                   "select * from stockinfo");
                String productname, productprice , stockavailable , retailer;
                
               System.out.println(resultSet);
               while (resultSet.next()) {
                   productname = resultSet.getString("productname");
                   productprice = resultSet.getString("productprice").trim();
                   stockavailable = resultSet.getString("stockavailable");
                   retailer = resultSet.getString("retailer").trim();
                   System.out.println("Product name : " + productname
                                      + " Product price : " + productprice);
               }
               resultSet.close();
               statement.close();
               conn.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    public static void main(String[] args) {
        ConnectionDB db= new ConnectionDB();
        db.selectStatement();
    }
}
