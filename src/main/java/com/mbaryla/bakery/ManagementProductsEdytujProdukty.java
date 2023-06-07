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
import model.Product;
import model.Subcategory;

/**
 *
 * @author mbaryla
 */
public class ManagementProductsEdytujProdukty implements Initializable{
    @FXML BorderPane bpMgmtProductsEdytujProdukty;
    
    @FXML TableView tableViewCategories;
    @FXML TableView tableViewSubcategories;
    @FXML TableView tableViewProducts;
    
    ObservableList<ObservableList> subcategories;
    ObservableList<ObservableList> categories;
    ObservableList<ObservableList> products;
    //Buttons
    @FXML private Button btnDodajProdukt;
    @FXML private Button btnUsunProdukt;
    //TextFields
    @FXML private TextField textFieldDodajProdukt;
    @FXML private TextField textFieldUsunProdukt;
    @FXML private TextField wybranaKategoria;
    @FXML private TextField wybranaPodkategoria;
    
    @FXML
    public void dodajProdukt(){
        Product product = new Product();
        Subcategory subcategory = new Subcategory();
        //Category category = new Category();
        
        product.setProductName(textFieldDodajProdukt.getText());
        product.setSubcategoryId(subcategory.getSubcategoryId(wybranaPodkategoria.getText()));
        product.addNewProduct();
        textFieldDodajProdukt.setVisible(false);
        textFieldDodajProdukt.clear();
        btnDodajProdukt.setVisible(false);
        wybranaKategoria.clear();
        wybranaPodkategoria.clear();
        allCategoriesShowMethod();
        allSubcategoriesShowMethod();
    }  
    @FXML
    public void switchToDodajProdukt(){
        textFieldUsunProdukt.setVisible(false);
        btnUsunProdukt.setVisible(false);
        textFieldDodajProdukt.setVisible(true);
        btnDodajProdukt.setVisible(true);
    }
    

    @FXML
    public void usunProdukt(){
        Product product = new Product();
        Subcategory subcategory = new Subcategory();
        
        product.setProductName(textFieldUsunProdukt.getText());
        product.setSubcategoryId(subcategory.getSubcategoryId(wybranaPodkategoria.getText()));
        product.deleteProduct();
        textFieldUsunProdukt.setVisible(false);
        textFieldUsunProdukt.clear();
        btnUsunProdukt.setVisible(false);
        allCategoriesShowMethod();
        allSubcategoriesShowMethod();
        wybranaKategoria.clear();
    }
    @FXML
    public void switchToUsunProdukt(){
        textFieldDodajProdukt.setVisible(false);
        btnDodajProdukt.setVisible(false);
        textFieldUsunProdukt.setVisible(true);
        btnUsunProdukt.setVisible(true);
    }
    
    @FXML
    public void switchToEdytujPodkategorie(){
        loadAMenuItem("");
    }
    
    public void getSelectedCategory() {
        //tableViewCategories.getSelectionModel();
        String categoryName = tableViewCategories.getSelectionModel().getSelectedItem().toString();
        System.out.println(categoryName);
        categoryName = removeBrackets(categoryName);
        wybranaKategoria.setText(categoryName);
        selectedSubcategoriesShowMethod();
    }
    
    public void getSelectedSubCategoryId() {
        wybranaKategoria.getText();   
    }
    
    public void getSelectedSubcategory() {
        String subcategoryName = tableViewSubcategories.getSelectionModel().getSelectedItem().toString();
        System.out.println(subcategoryName);
        subcategoryName = removeBrackets(subcategoryName);
        wybranaPodkategoria.setText(subcategoryName);
        selectedProductShowMethod();
    }
    
    public String removeBrackets(String str) {
        str = str.replace("[", "").replace("]", "");
        return str;
    }
    
    
    public void allCategoriesShowMethod() {
	//The following statement removes the data before so no duplicates appearing
	// after opening the table again.
	tableViewCategories.getColumns().clear();
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
    
    private void allProductsShowMethod() {
        //The following statement removes the data before so no duplicates appearing
	// after opening the table again.
	tableViewProducts.getColumns().clear();
	
	products = FXCollections.observableArrayList();
		
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object statement
            Statement myStmt = myConnection.createStatement();
            String sql = "SELECT productName FROM products;";
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
            tableViewProducts.getColumns().addAll(col);
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
		products.add(row);	
            }
			
            tableViewProducts.setItems(products);		
            rs.close();
            myConnection.close();		
            //Adding scroll
            tableViewProducts.setMaxWidth(241);
            tableViewProducts.setMaxHeight(400);
				
	}catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
	}
    }
    
    private void selectedProductShowMethod() {
        //The following statement removes the data before so no duplicates appearing
	// after opening the table again.
	tableViewProducts.getColumns().clear();

	products = FXCollections.observableArrayList();
		
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object statement
            Statement myStmt = myConnection.createStatement();
            //String sql = "SELECT subcategoryName FROM subcategories JOIN categories ON subcategories.categoryId=categories.categoryId WHERE categories.categoryName='"+ wybranaKategoria.getText() +"';";
            String sql = "SELECT productName FROM products JOIN subcategories ON products.subcategoryId=subcategories.subcategoryId WHERE subcategories.subcategoryName='"+ wybranaPodkategoria.getText() +"';";
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
            tableViewProducts.getColumns().addAll(col);
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
		products.add(row);	
            }
			
            tableViewProducts.setItems(products);		
            rs.close();
            myConnection.close();		
            //Adding scroll
            tableViewProducts.setMaxWidth(241);
            tableViewProducts.setMaxHeight(400);
				
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
        
        bpMgmtProductsEdytujProdukty.setCenter(root);
        
    } 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        allCategoriesShowMethod();
        allSubcategoriesShowMethod();
        allProductsShowMethod();
        textFieldDodajProdukt.setVisible(false);
        btnDodajProdukt.setVisible(false);
        textFieldUsunProdukt.setVisible(false);
        btnUsunProdukt.setVisible(false);
        
    }
}
