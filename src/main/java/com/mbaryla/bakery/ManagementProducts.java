/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mbaryla.bakery;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author mbaryla
 */
public class ManagementProducts {
   
    @FXML
    private void switchToManagement() throws IOException {
        App.setRoot("management");
    }
    
}
