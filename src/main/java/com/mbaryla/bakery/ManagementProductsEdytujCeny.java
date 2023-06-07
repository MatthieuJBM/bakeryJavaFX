/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mbaryla.bakery;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.ProductsPrice;

/**
 *
 * @author mbaryla
 */
public class ManagementProductsEdytujCeny implements Initializable{
    
    @FXML TableView tableViewCeny;
    ObservableList<ObservableList> prices;
    
    @FXML TextField textFieldProduktNazwa;
    
    @FXML private Spinner<Double> spinnerCena;
    SpinnerValueFactory<Double> spinnerValueFactory;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        allProductsShowMethod();
        
        spinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.00, 500.00);
        spinnerValueFactory.setValue(5.00);
        spinnerCena.setValueFactory(spinnerValueFactory);
        
        
    }
    
    @FXML
    public void dodajCene(){
        ProductsPrice productsPrice = new ProductsPrice();
        productsPrice.setProductId(productsPrice.getProductId(textFieldProduktNazwa.getText()));
        productsPrice.setProductPrice(spinnerCena.getValue());
        productsPrice.addPrice();
        textFieldProduktNazwa.clear();
        spinnerValueFactory.setValue(5.00);
        allProductsShowMethod();
        
        
    }
    
    
    
    
    
    @FXML
    public void getSelectedProduct(){
        String productName = tableViewCeny.getSelectionModel().getSelectedItem().toString();
        productName = firstElement(removeBrackets(productName));
        //productName = removeBrackets(productName);
        textFieldProduktNazwa.setText(productName);
        
    }
    
    
    public String removeBrackets(String str) {
        str = str.replace("[", "").replace("]", "");
        return str;
    }
    
    public String firstElement(String str) {
        int index = str.indexOf(",");
        str = str.substring(0, index).trim();
        return str;
    }
    
    
    private void allProductsShowMethod() {
        //The following statement removes the data before so no duplicates appearing
	// after opening the table again.
	tableViewCeny.getColumns().clear();
	
	prices = FXCollections.observableArrayList();
		
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object statement
            Statement myStmt = myConnection.createStatement();
            String sql = "SELECT products.productName, prices.productPrice FROM products LEFT JOIN prices ON products.productId=prices.productId;";
            //String sql = "SELECT productName FROM products;";
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
                                    Object value = param.getValue().get(j);
                                    String cellValue = (value != null) ? value.toString() : "";
				//return new SimpleStringProperty(param.getValue().get(j).toString());
                                return new SimpleStringProperty(cellValue);
				}
            });
            tableViewCeny.getColumns().addAll(col);
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
		prices.add(row);	
            }
			
            tableViewCeny.setItems(prices);		
            rs.close();
            myConnection.close();		
            //Adding scroll
            tableViewCeny.setMaxWidth(241);
            tableViewCeny.setMaxHeight(400);
				
	}catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
	}
    }
    
    
}
