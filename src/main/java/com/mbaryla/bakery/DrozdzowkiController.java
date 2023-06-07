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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author mbaryla
 */
public class DrozdzowkiController {
    
    @FXML private BorderPane bpWypiekiDrozdzowkiClient;
    
    @FXML private Label lblDrozdzowkaZCzekoladaPrice;
    @FXML private Label lblDrozdzowkaZSeremPrice;
    @FXML private Label lblDrozdzowkaZMarmeladaPrice;
    @FXML private Label lblRogalZBitaSmietanaPrice;
    @FXML private Label lblDrozdzowkaUniwersalna;
    @FXML private Label lblDrozdzowkaNiespodzianka;
    
    
    
    @FXML
    public void pokazCeneDrozdzowkaZCzekolada(){
        Double productPrice = null;
        try{
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            Statement myStmt = myConnection.createStatement();
            //String sql = "SELECT productPrice FROM products WHERE productName = '" + productName + "';";
            String sql = "SELECT productPrice FROM prices JOIN products ON prices.productId=products.productId WHERE products.productName='Drożdżówka z Czekoladą';";
            //myStmt.executeUpdate(sql);
            ResultSet rs = myStmt.executeQuery(sql);
            if(rs.next()) {
                //productId = rs.getInt("productId");
                productPrice = rs.getDouble("productPrice");
                lblDrozdzowkaZCzekoladaPrice.setText(Double.toString(productPrice) + "zł");
            }
            
            rs.close();
            myStmt.close();
            myConnection.close();
        }catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    @FXML
    public void pokazCeneDrozdzowkaZSerem(){
        Double productPrice = null;
        try{
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            Statement myStmt = myConnection.createStatement();
            //String sql = "SELECT productPrice FROM products WHERE productName = '" + productName + "';";
            String sql = "SELECT productPrice FROM prices JOIN products ON prices.productId=products.productId WHERE products.productName='Drożdżówka z Serem';";
            //myStmt.executeUpdate(sql);
            ResultSet rs = myStmt.executeQuery(sql);
            if(rs.next()) {
                //productId = rs.getInt("productId");
                productPrice = rs.getDouble("productPrice");
                lblDrozdzowkaZSeremPrice.setText(Double.toString(productPrice) + "zł");
            }
            
            rs.close();
            myStmt.close();
            myConnection.close();
        }catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    @FXML
    public void pokazCeneDrozdzowkaZMarmelada(){
        Double productPrice = null;
        try{
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            Statement myStmt = myConnection.createStatement();
            //String sql = "SELECT productPrice FROM products WHERE productName = '" + productName + "';";
            String sql = "SELECT productPrice FROM prices JOIN products ON prices.productId=products.productId WHERE products.productName='Drożdżówka z Marmeladą';";
            //myStmt.executeUpdate(sql);
            ResultSet rs = myStmt.executeQuery(sql);
            if(rs.next()) {
                //productId = rs.getInt("productId");
                productPrice = rs.getDouble("productPrice");
                lblDrozdzowkaZMarmeladaPrice.setText(Double.toString(productPrice) + "zł");
            }
            
            rs.close();
            myStmt.close();
            myConnection.close();
        }catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    @FXML
    public void pokazCeneRogalZBitaSmietana(){
        Double productPrice = null;
        try{
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            Statement myStmt = myConnection.createStatement();
            //String sql = "SELECT productPrice FROM products WHERE productName = '" + productName + "';";
            String sql = "SELECT productPrice FROM prices JOIN products ON prices.productId=products.productId WHERE products.productName='Rogal z Bitą Śmietaną';";
            //myStmt.executeUpdate(sql);
            ResultSet rs = myStmt.executeQuery(sql);
            if(rs.next()) {
                //productId = rs.getInt("productId");
                productPrice = rs.getDouble("productPrice");
                lblRogalZBitaSmietanaPrice.setText(Double.toString(productPrice) + "zł");
            }
            
            rs.close();
            myStmt.close();
            myConnection.close();
        }catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    @FXML
    public void pokazCeneDrozdzowkaUniwersalna(){
        Double productPrice = null;
        try{
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            Statement myStmt = myConnection.createStatement();
            //String sql = "SELECT productPrice FROM products WHERE productName = '" + productName + "';";
            String sql = "SELECT productPrice FROM prices JOIN products ON prices.productId=products.productId WHERE products.productName='Drożdżówka Uniwersalna';";
            //myStmt.executeUpdate(sql);
            ResultSet rs = myStmt.executeQuery(sql);
            if(rs.next()) {
                //productId = rs.getInt("productId");
                productPrice = rs.getDouble("productPrice");
                lblDrozdzowkaUniwersalna.setText(Double.toString(productPrice) + "zł");
            }
            
            rs.close();
            myStmt.close();
            myConnection.close();
        }catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    @FXML
    public void pokazCeneDrozdzowkaNiespodzianka(){
        Double productPrice = null;
        try{
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            Statement myStmt = myConnection.createStatement();
            //String sql = "SELECT productPrice FROM products WHERE productName = '" + productName + "';";
            String sql = "SELECT productPrice FROM prices JOIN products ON prices.productId=products.productId WHERE products.productName='Drożdżówka Niespodzianka';";
            //myStmt.executeUpdate(sql);
            ResultSet rs = myStmt.executeQuery(sql);
            if(rs.next()) {
                //productId = rs.getInt("productId");
                productPrice = rs.getDouble("productPrice");
                lblDrozdzowkaNiespodzianka.setText(Double.toString(productPrice) + "zł");
            }
            
            rs.close();
            myStmt.close();
            myConnection.close();
        }catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    
    //@FXML private Button btnDrozdzowkaZCzekolada;
    
    @FXML
    private void switchToDrozdzowkaZCzekolada() {
        loadAMenuItem("drozdzowkaZCzekolada");
        //pokazCeneDrozdzowkaZCzekolada();
    }
    @FXML
    private void switchToDrozdzowkaZSerem() {
        loadAMenuItem("drozdzowkaZSerem");
    }
    @FXML
    private void switchToDrozdzowkaZMarmelada() {
        loadAMenuItem("drozdzowkaZMarmelada");
    }
    @FXML
    private void switchToRogalZBitaSmietana() {
        loadAMenuItem("rogalZBitaSmietana");
    }
    @FXML
    private void switchToDrozdzowkaUniwersalna() {
        loadAMenuItem("drozdzowkaUniwersalna");
    }
    @FXML
    private void switchToDrozdzowkaNiespodzianka() {
        loadAMenuItem("drozdzowkaNiespodzianka");
    }
    
    @FXML
    private void loadAMenuItem(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        bpWypiekiDrozdzowkiClient.setCenter(root);
        
    } 
    
}
