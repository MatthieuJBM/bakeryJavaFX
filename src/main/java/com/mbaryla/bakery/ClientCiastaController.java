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
import javafx.scene.layout.GridPane;

/**
 *
 * @author mbaryla
 */
public class ClientCiastaController {
    
    @FXML private BorderPane bpClientCiasta;
    @FXML private BorderPane bpClientCiastaMain;
    
    @FXML private GridPane gpClientCiastaMain;
    
    @FXML private Button ciasto1;
    @FXML private Button ciasto2;
    @FXML private Button ciasto3;
    @FXML private Button ciasto4;
    @FXML private Button ciasto5;
    @FXML private Button ciasto6;
    
    
    @FXML
    private void switchToCiastaMain() {
        loadAMenuItem("client_ciasta_ciastaMain");
    }
    
    @FXML
    private void switchToCiastaMokre() {
        loadAMenuItem("client_ciasta_ciastaMokre");
    }
    @FXML
    private void switchToCiastaKruche() {
        loadAMenuItem("client_ciasta_ciastaKruche");
    }
    @FXML
    private void switchToCiastaNaWage() {
        loadAMenuItem("client_ciasta_ciastaNaWage");
    }
    
    @FXML
    private void loadAMenuItem(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        bpClientCiasta.setCenter(root);
        
    } 
    
    
    /*
    Changing the properties using the code.
    This way it should be modifiable later using the management part of the app.
    */
    @FXML
    public void changeButtonNameProperty(Button btn, String name) {
        btn.setText(name);
    }
    
    @FXML
    public void setNameForCiasto1() {
        changeButtonNameProperty(ciasto2, "Wuzetka");
    }
    
    @FXML
    public void exampleMethod() {
        //gpClientCiastaMain.
    }
    
    /*
    public Button getCiasto1() {
        return ciasto1;
    }
    
    public void setCiasto1NameProperty(String name) {
        changeButtonNameProperty(ciasto1, name);
    }

    public Button getCiasto2() {
        return ciasto2;
    }

    public void setCiasto2(Button ciasto2) {
        this.ciasto2 = ciasto2;
    }

    public Button getCiasto3() {
        return ciasto3;
    }

    public void setCiasto3(Button ciasto3) {
        this.ciasto3 = ciasto3;
    }

    public Button getCiasto4() {
        return ciasto4;
    }

    public void setCiasto4(Button ciasto4) {
        this.ciasto4 = ciasto4;
    }

    public Button getCiasto5() {
        return ciasto5;
    }

    public void setCiasto5(Button ciasto5) {
        this.ciasto5 = ciasto5;
    }

    public Button getCiasto6() {
        return ciasto6;
    }

    public void setCiasto6(Button ciasto6) {
        this.ciasto6 = ciasto6;
    }
    */
    
}
