/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mbaryla.bakery;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author mbaryla
 */
public class ClientWypiekiPizzeController {
    
    @FXML private BorderPane bpClientWypiekiPizze;
    
    
    @FXML
    private void switchToPizzaZKielbasa() {
        loadAMenuItem("client_wypieki_pizze_pizzaZKielbasa");
    }
    @FXML
    private void switchToPizzaZSzynka() {
        loadAMenuItem("client_wypieki_pizze_pizzaZSzynka");
    }
    @FXML
    private void switchToPizzaZPieczarkami() {
        loadAMenuItem("client_wypieki_pizze_pizzaZPieczarkami");
    }
    @FXML
    private void switchToPizzaSerowa() {
        loadAMenuItem("client_wypieki_pizze_pizzaSerowa");
    }
    
    @FXML
    private void loadAMenuItem(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        bpClientWypiekiPizze.setCenter(root);
        
    } 
    
}
