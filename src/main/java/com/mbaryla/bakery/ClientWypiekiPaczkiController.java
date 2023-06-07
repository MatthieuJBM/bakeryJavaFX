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
public class ClientWypiekiPaczkiController {
    
    @FXML private BorderPane bpClientWypiekiPaczki;
    
    @FXML private Label lblPaczekZCzekolada;
    @FXML private Label lblPaczekZDzemem;
    
    
    /*
    paczekZDzemem
    paczekZCzekolada
    donut
    donutAmerykanski
    donutBelgijski
    paczekZFarszemBigosowym
    */
    
    
    @FXML
    public void pokazCenePaczekZCzekolada(){
        Double productPrice = null;
        try{
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            Statement myStmt = myConnection.createStatement();
            //String sql = "SELECT productPrice FROM products WHERE productName = '" + productName + "';";
            String sql = "SELECT productPrice FROM prices JOIN products ON prices.productId=products.productId WHERE products.productName='Pączek z Czekoladą';";
            //myStmt.executeUpdate(sql);
            ResultSet rs = myStmt.executeQuery(sql);
            if(rs.next()) {
                //productId = rs.getInt("productId");
                productPrice = rs.getDouble("productPrice");
                lblPaczekZCzekolada.setText(Double.toString(productPrice) + "zł");
            }
            
            rs.close();
            myStmt.close();
            myConnection.close();
        }catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    @FXML
    public void pokazCenePaczekZDzemem(){
        Double productPrice = null;
        try{
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            Statement myStmt = myConnection.createStatement();
            //String sql = "SELECT productPrice FROM products WHERE productName = '" + productName + "';";
            String sql = "SELECT productPrice FROM prices JOIN products ON prices.productId=products.productId WHERE products.productName='Pączek z Dżemem';";
            //myStmt.executeUpdate(sql);
            ResultSet rs = myStmt.executeQuery(sql);
            if(rs.next()) {
                //productId = rs.getInt("productId");
                productPrice = rs.getDouble("productPrice");
                lblPaczekZDzemem.setText(Double.toString(productPrice) + "zł");
            }
            
            rs.close();
            myStmt.close();
            myConnection.close();
        }catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    
    @FXML
    private void switchToPaczekZDzemem() {
        loadAMenuItem("client_wypieki_paczki_paczekZDzemem");
    }
    @FXML
    private void switchToPaczekZCzekolada() {
        loadAMenuItem("client_wypieki_paczki_paczekZCzekolada");
    }
    @FXML
    private void switchToDonut() {
        loadAMenuItem("client_wypieki_paczki_donut");
    }
    @FXML
    private void switchToDonutAmerykanski() {
        loadAMenuItem("client_wypieki_paczki_donutAmerykanski");
    }
    @FXML
    private void switchToDonutBelgijski() {
        loadAMenuItem("client_wypieki_paczki_donutBelgijski");
    }
    @FXML
    private void switchToZFarszemBigosowym() {
        loadAMenuItem("client_wypieki_paczki_paczekZFarszemBigosowym");
    }
    
    
    @FXML
    private void loadAMenuItem(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        bpClientWypiekiPaczki.setCenter(root);
        
    } 
}
