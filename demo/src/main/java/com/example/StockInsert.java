package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.collections.ObservableList;

import java.sql.*;
public class StockInsert {
    public void stockListView(ObservableList<FileData> data){
        Connection conn = null;
        data.clear();
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?"+
               "user=root&password=divijak-47" );
               System.out.println("Connnection succeded");

               Statement statement;
               statement = conn.createStatement();
               ResultSet resultSet;
               resultSet = statement.executeQuery(
                   "select * from stockinfo");
                String productname, productprice , stockavailable , retailer;
               
               System.out.println(resultSet);
               while (resultSet.next()) {
                   productname = resultSet.getString("stockname");
                   productprice = resultSet.getString("price").trim();
                   stockavailable = resultSet.getString("stockavailable");
                   retailer = resultSet.getString("retailer").trim();
                   data.add(new FileData(productname, productprice, stockavailable, retailer));
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
