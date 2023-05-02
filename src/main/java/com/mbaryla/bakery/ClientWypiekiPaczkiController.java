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
public class ClientWypiekiPaczkiController {
    
    @FXML private BorderPane bpClientWypiekiPaczki;
    
    /*
    paczekZDzemem
    paczekZCzekolada
    donut
    donutAmerykanski
    donutBelgijski
    paczekZFarszemBigosowym
    */
    
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
