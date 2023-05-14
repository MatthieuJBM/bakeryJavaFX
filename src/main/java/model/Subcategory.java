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
public class Subcategory {
    private Integer subcategoryId;
    private String subcategoryName;
    private Integer categoryId;
    
    public void addNewSubcategory() {
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object statement
            Statement myStmt = myConnection.createStatement();
            String sql = "INSERT INTO subcategories(categoryName) VALUES(\""+ this.subcategoryName + "\");";
            //Executing query
            myStmt.executeUpdate(sql);
            myConnection.close();		
	}catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
	}
    }
    
    public void deleteASubcategory() {
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object statement
            Statement myStmt = myConnection.createStatement();
            String sql = "DELETE FROM categories WHERE categories.categoryName = \"" + this.subcategoryName + "\";";
            //String sql2 = "INSERT INTO categories(categoryName) VALUES(\""+ this.subcategoryName + "\");";
            //Executing query
            myStmt.executeUpdate(sql);
            myConnection.close();		
	}catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
	}
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    
    
    
    
    
}
