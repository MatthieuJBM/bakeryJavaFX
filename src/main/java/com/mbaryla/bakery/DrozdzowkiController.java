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
public class DrozdzowkiController {
    
    @FXML private BorderPane bpWypiekiDrozdzowkiClient;
    
    @FXML private Button btnDrozdzowkaZCzekolada;
    
    @FXML
    private void switchToDrozdzowkaZCzekolada() {
        loadAMenuItem("drozdzowkaZCzekolada");
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
