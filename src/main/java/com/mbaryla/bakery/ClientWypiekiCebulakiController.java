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
public class ClientWypiekiCebulakiController {
    
    @FXML private BorderPane bpClientWypiekiCebulaki;
    
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
