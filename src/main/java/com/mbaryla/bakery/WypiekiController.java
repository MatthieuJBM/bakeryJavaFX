/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mbaryla.bakery;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author mbaryla
 */
public class WypiekiController {
    
    @FXML private BorderPane bpWypiekiClient;
    
    @FXML
    private void switchToDrozdzowki() {
        loadAMenuItem("client_wypieki_drozdzowki");
    }
    
    @FXML
    private void switchToPaczki() {
        loadAMenuItem("client_wypieki_paczki");
    }
    
    @FXML
    private void switchToPizze() {
        loadAMenuItem("client_wypieki_pizze");
    }
    
    @FXML
    private void switchToCebulaki() {
        loadAMenuItem("client_wypieki_cebulaki");
    }
    
    @FXML
    private void loadAMenuItem(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        bpWypiekiClient.setCenter(root);
        
    } 
    
}
