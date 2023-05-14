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
    private void loadAMenuItem(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        bpManagementProducts.setCenter(root);
        
    } 
    
    /*
    @FXML
    private TextField txtName;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnRemove;
    @FXML
    private ListView<Worker> lsvWorkers;
    private final ObservableList<Worker> workersList = FXCollections.observableArrayList();
    private final WorkerDAO workerDAO = new WorkerDAO();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lsvWorkers.setItems(workersList);
        workersList.addAll(workerDAO.getAllWorkers());
        lsvWorkers.setCellFactory(new Callback<ListView<Worker>, ListCell<Worker>>() {
            @Override
            public ListCell<Worker> call(ListView<Worker> param) {
                ListCell<Worker> listCell = new ListCell() {
                    @Override
                    protected void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        if(item!=null){
                            Worker worker = (Worker) item;
                            setText(worker.getName());
                        }else{
                            setText("");
                        }
                    }
                };
                return listCell;
            }
        });
    }
    */
    
    
    @FXML
    private void switchToManagement() throws IOException {
        App.setRoot("management");
    }
    
}
