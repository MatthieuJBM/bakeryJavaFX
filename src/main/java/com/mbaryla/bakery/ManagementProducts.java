/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mbaryla.bakery;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

/**
 *
 * @author mbaryla
 */
public class ManagementProducts {//implements Initializable{
   
    @FXML BorderPane bpManagementProducts;
    
    @FXML
    private void switchToDodajEdytujKategorie() {
        loadAMenuItem("ManagementProductsDodajEdytujKategorie");
        //ManagementProductsDodajEdytujKategorie showCategories = new ManagementProductsDodajEdytujKategorie();
        //showCategories.allCategoriesShowMethod();
        
    }
    
    @FXML
    private void switchToEdytujPodkategorie() {
        loadAMenuItem("ManagementProductsEdytujPodkategorie");
    }
    
    @FXML
    private void switchToEdytujProdukty() {
        loadAMenuItem("ManagementProductsEdytujProdukty");
    }
    
    @FXML
    private void switchToEdytujSkladniki() {
        loadAMenuItem("ManagementProductsEdytujSkladniki");
    }
    
    @FXML
    private void switchToEdytujCeny() {
        loadAMenuItem("ManagementProductsEdytujCeny");
    }
    
    
    
    @FXML
    private void loadAMenuItem(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        bpManagementProducts.setCenter(root);
        
    }
    
    
    @FXML
    private void switchToManagement() throws IOException {
        App.setRoot("management");
    }
    
}
