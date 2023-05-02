package com.mbaryla.bakery;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToManagement() throws IOException {
        App.setRoot("management");
    }
    
    @FXML
    private void switchToClient() throws IOException {
        App.setRoot("client");
    }
}
