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
        loadAMenuItem("drozdzowki");
    }
    
    @FXML
    private void switchToPaczki() {
        loadAMenuItem("paczki");
    }
    
    @FXML
    private void switchToPizze() {
        loadAMenuItem("pizze");
    }
    
    @FXML
    private void switchToCebulaki() {
        loadAMenuItem("cebulaki");
    }
    /*
    @FXML
    private void switchToDrozdzowkaZCzekolada() {
        loadAMenuItem("drozdzowkaZCzekolada");
    }*/
    
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
