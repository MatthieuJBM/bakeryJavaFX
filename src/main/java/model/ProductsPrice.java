/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author mbaryla
 */
public class ProductsPrice {
    
    /*
    CREATE TABLE prices(
    productId int, 
    productPrice numeric(8,2),
    FOREIGN KEY(productId) REFERENCES products(productId)
    );
    */
    
    private Integer productId;
    private double productPrice;
    
    
    public void addPrice() {
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object statement
            Statement myStmt = myConnection.createStatement();
            //String sql = "INSERT INTO ingredients(ingredientName, manufacturer, price) VALUES('" + this.ingredientName + "','" + this.manufacturer + "'," + this.price + ");";
            String sql = "INSERT INTO prices(productId, productPrice) VALUES(" + this.productId + "," + this.productPrice + ");";
            //Executing query
            myStmt.executeUpdate(sql);
            myConnection.close();		
	}catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
	}
    }
    
    public Integer getProductId(String productName) {
        Integer productId = null;
        try{
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            Statement myStmt = myConnection.createStatement();
            String sql = "SELECT productId FROM products WHERE productName = '" + productName + "';";
            //myStmt.executeUpdate(sql);
            ResultSet rs = myStmt.executeQuery(sql);
            if(rs.next()) {
                productId = rs.getInt("productId");
            }
            
            rs.close();
            myStmt.close();
            myConnection.close();
        }catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return productId;
    }
    
    
    
    
    
    
    
    
    

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    
    
    
    
}
