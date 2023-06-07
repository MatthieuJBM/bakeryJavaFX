/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mbaryla.bakery;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author mbaryla
 */
public class ClientWypiekiCebulakiController {
    
    @FXML private BorderPane bpClientWypiekiCebulaki;
    
    @FXML private Label lblCebulak;
    @FXML private Label lblCebulakZCzerwonejCebuli;
    
    @FXML
    public void pokazCeneCebulak(){
        Double productPrice = null;
        try{
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            Statement myStmt = myConnection.createStatement();
            //String sql = "SELECT productPrice FROM products WHERE productName = '" + productName + "';";
            String sql = "SELECT productPrice FROM prices JOIN products ON prices.productId=products.productId WHERE products.productName='Cebulak';";
            //myStmt.executeUpdate(sql);
            ResultSet rs = myStmt.executeQuery(sql);
            if(rs.next()) {
                //productId = rs.getInt("productId");
                productPrice = rs.getDouble("productPrice");
                lblCebulak.setText(Double.toString(productPrice) + "zł");
            }
            
            rs.close();
            myStmt.close();
            myConnection.close();
        }catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    @FXML
    public void pokazCeneCebulakZCzerwonejCebuli(){
        Double productPrice = null;
        try{
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            Statement myStmt = myConnection.createStatement();
            //String sql = "SELECT productPrice FROM products WHERE productName = '" + productName + "';";
            String sql = "SELECT productPrice FROM prices JOIN products ON prices.productId=products.productId WHERE products.productName='Cebulak z Czerwonej Cebuli';";
            //myStmt.executeUpdate(sql);
            ResultSet rs = myStmt.executeQuery(sql);
            if(rs.next()) {
                //productId = rs.getInt("productId");
                productPrice = rs.getDouble("productPrice");
                lblCebulakZCzerwonejCebuli.setText(Double.toString(productPrice) + "zł");
            }
            
            rs.close();
            myStmt.close();
            myConnection.close();
        }catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    
    @FXML
    private void switchToCebulak() {
        loadAMenuItem("client_wypieki_cebulaki_cebulak");
    }
    @FXML
    private void switchToCebulakZCzerwonejCebuli() {
        loadAMenuItem("client_wypieki_cebulaki_cebulakZCzerwonejCebuli");
    }
    
    @FXML
    private void loadAMenuItem(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        bpClientWypiekiCebulaki.setCenter(root);
        
    } 
    
}
