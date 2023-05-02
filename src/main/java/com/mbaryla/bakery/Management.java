package com.mbaryla.bakery;

import java.io.IOException;
import javafx.fxml.FXML;

public class Management {

    @FXML
    private void switchToMain() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void switchToManagement_products() throws IOException {
        App.setRoot("management_products");
    }
}