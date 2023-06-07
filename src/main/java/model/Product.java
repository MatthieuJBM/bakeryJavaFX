/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author mbaryla
 */
public class Product {
    
    /*
    String sqlCreateTableProducts = "CREATE TABLE products( "
                        + "productId int auto_increment, "
                        + "productName varchar(30), "
                        + "subcategoryId int, "
                        + "PRIMARY KEY(productId), "
                        + "FOREIGN KEY(subcategoryId) REFERENCES subcategories(subcategoryId)"
                        + ");";
    */
    
    private Integer productId;
    private String productName;
    private Integer subcategoryId;
    
    public void addNewProduct() {
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object statement
            Statement myStmt = myConnection.createStatement();
            //String sql = "INSERT INTO subcategories(subcategoryName, categoryId) VALUES('" + this.subcategoryName + "'," + this.categoryId + ");";
            String sql = "INSERT INTO products(productName, subcategoryId) VALUES('" + this.productName + "'," + this.subcategoryId + ");";
            //Executing query
            myStmt.executeUpdate(sql);
            myConnection.close();		
	}catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
	}
    }
    
    public void deleteProduct() {
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object statement
            Statement myStmt = myConnection.createStatement();
            //String sql = "DELETE FROM subcategories WHERE subcategories.subcategoryName = '" + this.subcategoryName + "' AND subcategories.categoryId = " + this.categoryId + ";";
            //String sql2 = "DELETE FROM subcategories JOIN categories ON subcategories.categoryId=categories.categoryId WHERE subcategories.subcategoryName = '" + this.subcategoryName + "' AND categories.categoryId = " + this.categoryId + ";";
            String sql = "DELETE FROM products WHERE products.productName = '" + this.productName + "' AND products.subcategoryId = " + this.subcategoryId + ";";
            //Executing query
            myStmt.executeUpdate(sql);
            myStmt.close();
            myConnection.close();		
	}catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
	}
    }
    
    

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }
    
    
    
    
    
    
}
