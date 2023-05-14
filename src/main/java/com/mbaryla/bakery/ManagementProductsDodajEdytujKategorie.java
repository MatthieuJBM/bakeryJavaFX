/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mbaryla.bakery;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import model.Category;

/**
 *
 * @author mbaryla
 */
public class ManagementProductsDodajEdytujKategorie implements Initializable {
    
    @FXML BorderPane bpMgmtProductsDodajKategorie;
    
    @FXML TableView tableViewCategories;

    public TableView getTableViewCategories() {
        return tableViewCategories;
    }

    public void setTableViewCategories(TableView tableViewCategories) {
        this.tableViewCategories = tableViewCategories;
    }
    
    ObservableList<ObservableList> categories;
    
    /*
    @FXML Button btnCategoryDodaj;
    @FXML Button btnCategoryUsun;
    @FXML Button btnCategoryZmienNazwe;
    */
    
    @FXML private TextField textFieldDodajKategorie;
    @FXML private Button btnDodajKategorie;
    @FXML
    public void dodajKategorie(){
        Category category = new Category();
        category.setName(textFieldDodajKategorie.getText());
        category.addNewCategory();
        textFieldDodajKategorie.setVisible(false);
        textFieldDodajKategorie.clear();
        btnDodajKategorie.setVisible(false);
        allCategoriesShowMethod();
    }  
    @FXML
    public void switchToDodajKategorie(){
        textFieldUsunKategorie.setVisible(false);
        btnUsunKategorie.setVisible(false);
        textFieldDodajKategorie.setVisible(true);
        btnDodajKategorie.setVisible(true);
    }
    
    @FXML private TextField textFieldUsunKategorie;
    @FXML private Button btnUsunKategorie;
    @FXML
    public void usunKategorie(){
        Category category = new Category();
        category.setName(textFieldUsunKategorie.getText());
        category.deleteACategory();
        textFieldUsunKategorie.setVisible(false);
        textFieldUsunKategorie.clear();
        btnUsunKategorie.setVisible(false);
        allCategoriesShowMethod();
    }
    @FXML
    public void switchToUsunKategorie(){
        textFieldDodajKategorie.setVisible(false);
        btnDodajKategorie.setVisible(false);
        textFieldUsunKategorie.setVisible(true);
        btnUsunKategorie.setVisible(true);
    }
    
    @FXML
    public void switchToEdytujKategorie(){
        loadAMenuItem("");
    }
       
    
    public void allCategoriesShowMethod() {
	//The following statement removes the data before so no duplicates appearing
	// after opening the table again.
	tableViewCategories.getColumns().clear();
	/*
	ObservableList<ObservableList> entityData;
	TableView<Entity> tblEntities;
	TableColumn tblClmnEntityId, tblClmnEntityName, tblClmnEntityStreet;
        */
	categories = FXCollections.observableArrayList();
		
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object statement
            Statement myStmt = myConnection.createStatement();
            String sql = "SELECT categoryName FROM categories;";
            //Executing query
            ResultSet rs = myStmt.executeQuery(sql);
            /***************************************************
            * TABLE COLUMN ADDED DYNAMICALLY *
            *********************************************/		
            for(int i=0 ; i<rs.getMetaData().getColumnCount() ; i++) {
            //We are using non property style for making dynamic table
            final int j = i;
            TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>(){
				public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
				return new SimpleStringProperty(param.getValue().get(j).toString());
				}
            });
            tableViewCategories.getColumns().addAll(col);
            }
            /*********************************
            * DATA ADDED TO OBSERVABLELIST *
            *********************************/		
            while(rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount() ; i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
		//System.out.println("Row added " + row );
		categories.add(row);	
            }
			
            tableViewCategories.setItems(categories);		
            rs.close();
            myConnection.close();		
            //Adding scroll
            tableViewCategories.setMaxWidth(241);
            tableViewCategories.setMaxHeight(400);
				
	}catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
	}
    }
    
    @FXML
    private void loadAMenuItem(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        bpMgmtProductsDodajKategorie.setCenter(root);
        
    } 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        allCategoriesShowMethod();
        textFieldDodajKategorie.setVisible(false);
        btnDodajKategorie.setVisible(false);
        textFieldUsunKategorie.setVisible(false);
        btnUsunKategorie.setVisible(false);
        
    }
    
}
