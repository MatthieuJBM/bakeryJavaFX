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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import model.Category;
import model.Subcategory;

/**
 *
 * @author mbaryla
 */
public class ManagementProductsEdytujPodkategorie implements Initializable{
    @FXML BorderPane bpMgmtProductsEdytujPodkategorie;
    
    @FXML TableView tableViewCategories;
    @FXML TableView tableViewSubcategories;
    
    ObservableList<ObservableList> subcategories;
    ObservableList<ObservableList> categories;
    //Buttons
    @FXML private Button btnDodajPodkategorie;
    @FXML private Button btnUsunPodkategorie;
    //TextFields
    @FXML private TextField textFieldDodajPodkategorie;
    @FXML private TextField textFieldUsunPodkategorie;
    @FXML private TextField wybranaKategoria;
    
    @FXML
    public void dodajPodkategorie(){
        Subcategory subcategory = new Subcategory();
        subcategory.setSubcategoryName(textFieldDodajPodkategorie.getText());
        Category category = new Category();
        subcategory.setCategoryId(category.getCategoryId(wybranaKategoria.getText()));
        subcategory.addNewSubcategory();
        textFieldDodajPodkategorie.setVisible(false);
        textFieldDodajPodkategorie.clear();
        btnDodajPodkategorie.setVisible(false);
        allCategoriesShowMethod();
        allSubcategoriesShowMethod();
        wybranaKategoria.clear();
    }  
    @FXML
    public void switchToDodajPodkategorie(){
        textFieldUsunPodkategorie.setVisible(false);
        btnUsunPodkategorie.setVisible(false);
        textFieldDodajPodkategorie.setVisible(true);
        btnDodajPodkategorie.setVisible(true);
    }
    

    @FXML
    public void usunPodkategorie(){
        Subcategory subcategory = new Subcategory();
        subcategory.setSubcategoryName(textFieldUsunPodkategorie.getText());
        Category category = new Category();
        subcategory.setCategoryId(category.getCategoryId(wybranaKategoria.getText()));
        subcategory.deleteASubcategory();
        textFieldUsunPodkategorie.setVisible(false);
        textFieldUsunPodkategorie.clear();
        btnUsunPodkategorie.setVisible(false);
        allCategoriesShowMethod();
        allSubcategoriesShowMethod();
        wybranaKategoria.clear();
    }
    @FXML
    public void switchToUsunPodkategorie(){
        textFieldDodajPodkategorie.setVisible(false);
        btnDodajPodkategorie.setVisible(false);
        textFieldUsunPodkategorie.setVisible(true);
        btnUsunPodkategorie.setVisible(true);
    }
    
    @FXML
    public void switchToEdytujPodkategorie(){
        loadAMenuItem("");
    }
    
    public void getSelectedCategory() {
        //tableViewCategories.getSelectionModel();
        String categoryName = tableViewCategories.getSelectionModel().getSelectedItem().toString();//.substring(1, 3);
        System.out.println(categoryName);
        categoryName = removeBrackets(categoryName);
        wybranaKategoria.setText(categoryName);
        selectedSubcategoriesShowMethod();
    }
    
    public void getSelectedSubCategoryId() {
        wybranaKategoria.getText();
        
        
    }
    
    public String removeBrackets(String str) {
        str = str.replace("[", "").replace("]", "");
        return str;
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
            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>(){
				public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
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
    
    public void allSubcategoriesShowMethod() {
	//The following statement removes the data before so no duplicates appearing
	// after opening the table again.
	tableViewSubcategories.getColumns().clear();
	/*
	ObservableList<ObservableList> entityData;
	TableView<Entity> tblEntities;
	TableColumn tblClmnEntityId, tblClmnEntityName, tblClmnEntityStreet;
        */
	subcategories = FXCollections.observableArrayList();
		
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object statement
            Statement myStmt = myConnection.createStatement();
            String sql = "SELECT subcategoryName FROM subcategories;";
            //Executing query
            ResultSet rs = myStmt.executeQuery(sql);
            /***************************************************
            * TABLE COLUMN ADDED DYNAMICALLY *
            *********************************************/		
            for(int i=0 ; i<rs.getMetaData().getColumnCount() ; i++) {
            //We are using non property style for making dynamic table
            final int j = i;
            TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>(){
				public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
				return new SimpleStringProperty(param.getValue().get(j).toString());
				}
            });
            tableViewSubcategories.getColumns().addAll(col);
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
		subcategories.add(row);	
            }
			
            tableViewSubcategories.setItems(subcategories);		
            rs.close();
            myConnection.close();		
            //Adding scroll
            tableViewSubcategories.setMaxWidth(241);
            tableViewSubcategories.setMaxHeight(400);
				
	}catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
	}
    }
    
    public void selectedSubcategoriesShowMethod() {
	//The following statement removes the data before so no duplicates appearing
	// after opening the table again.
	tableViewSubcategories.getColumns().clear();
	/*
	ObservableList<ObservableList> entityData;
	TableView<Entity> tblEntities;
	TableColumn tblClmnEntityId, tblClmnEntityName, tblClmnEntityStreet;
        */
	subcategories = FXCollections.observableArrayList();
		
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object statement
            Statement myStmt = myConnection.createStatement();
            String sql = "SELECT subcategoryName FROM subcategories JOIN categories ON subcategories.categoryId=categories.categoryId WHERE categories.categoryName='"+ wybranaKategoria.getText() +"';";
            //Executing query
            ResultSet rs = myStmt.executeQuery(sql);
            /***************************************************
            * TABLE COLUMN ADDED DYNAMICALLY *
            *********************************************/		
            for(int i=0 ; i<rs.getMetaData().getColumnCount() ; i++) {
            //We are using non property style for making dynamic table
            final int j = i;
            TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>(){
				public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
				return new SimpleStringProperty(param.getValue().get(j).toString());
				}
            });
            tableViewSubcategories.getColumns().addAll(col);
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
		subcategories.add(row);	
            }
			
            tableViewSubcategories.setItems(subcategories);		
            rs.close();
            myConnection.close();		
            //Adding scroll
            tableViewSubcategories.setMaxWidth(241);
            tableViewSubcategories.setMaxHeight(400);
				
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
        
        bpMgmtProductsEdytujPodkategorie.setCenter(root);
        
    } 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        allCategoriesShowMethod();
        allSubcategoriesShowMethod();
        textFieldDodajPodkategorie.setVisible(false);
        btnDodajPodkategorie.setVisible(false);
        textFieldUsunPodkategorie.setVisible(false);
        btnUsunPodkategorie.setVisible(false);
        
    }
}
