package com.mbaryla.bakery;

/**
 *
 * @author mbaryla
 */

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Client {
 
    @FXML private ImageView clientReturnButton;
    
    @FXML private BorderPane bpClient;
    
    @FXML private AnchorPane wypiekiAp;
    @FXML private AnchorPane ciastaAp;
    @FXML private AnchorPane tortyAp;
    @FXML private AnchorPane dekoracjeAp;
    @FXML private AnchorPane napojeAp;
    
    
    @FXML
    private void switchToMain() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void switchToWypieki() {
        loadAMenuItem("wypieki");
    }
    
    @FXML
    private void switchToCiasta() {
        loadAMenuItem("ciasta");
    }
    
    @FXML
    private void switchToTorty() {
        loadAMenuItem("torty");
    }
    
    @FXML
    private void switchToDekoracje() {
        loadAMenuItem("dekoracje");
    }
    
    @FXML
    private void switchToNapoje() {
        loadAMenuItem("napoje");
    }
    
    @FXML
    private void loadAMenuItem(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        bpClient.setCenter(root);
        
    } 
    
}
