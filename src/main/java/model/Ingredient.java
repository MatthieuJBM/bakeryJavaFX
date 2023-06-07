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
public class Ingredient {
    
    /*
    "CREATE TABLE ingredients( "
    "ingredientId int auto_increment, "
    "ingredientName varchar(60), "
    "manufacturer varchar(30), "
    "price numeric(3,2), "
    "PRIMARY KEY(ingredientId)"
    ");";
    */
    
    private Integer ingredientId;
    private String ingredientName;
    private String manufacturer;
    private double price;
    
    
    public void addNewIngredient() {
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object statement
            Statement myStmt = myConnection.createStatement();
            //String sql = "INSERT INTO products(productName, subcategoryId) VALUES('" + this.productName + "'," + this.subcategoryId + ");";
            String sql = "INSERT INTO ingredients(ingredientName, manufacturer, price) VALUES('" + this.ingredientName + "','" + this.manufacturer + "'," + this.price + ");";
            //Executing query
            myStmt.executeUpdate(sql);
            myConnection.close();		
	}catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
	}
    }
    
    public void deleteIngredient() {
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object statement
            Statement myStmt = myConnection.createStatement();
            //String sql = "DELETE FROM products WHERE products.productName = '" + this.productName + "' AND products.subcategoryId = " + this.subcategoryId + ";";
            String sql = "DELETE FROM ingredients WHERE ingredients.ingredientId = " + this.ingredientId + ";";
            //Executing query
            myStmt.executeUpdate(sql);
            myStmt.close();
            myConnection.close();		
	}catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
	}
    }
    
    
    public Integer getIngredientId(String ingredientName) {
        Integer ingredientId = null;
        try{
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            Statement myStmt = myConnection.createStatement();
            String sql = "SELECT ingredientId FROM ingredients WHERE ingredientName = '" + ingredientName + "';";
            //myStmt.executeUpdate(sql);
            ResultSet rs = myStmt.executeQuery(sql);
            if(rs.next()) {
                ingredientId = rs.getInt("ingredientId");
            }
            
            rs.close();
            myStmt.close();
            myConnection.close();
        }catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return ingredientId;
    }
    
    
    
    
    
    
    
    
    
    
    
    

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
