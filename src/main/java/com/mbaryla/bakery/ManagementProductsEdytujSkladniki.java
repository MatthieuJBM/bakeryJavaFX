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
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import model.Ingredient;

/**
 *
 * @author mbaryla
 */
public class ManagementProductsEdytujSkladniki implements Initializable {
    
    @FXML private BorderPane bpMgmtProductsEdytujSkladniki;
    
    @FXML private Button btnEdytujSkladnik;
    @FXML private Button btnDodajSkladnik;
    @FXML private Button btnUsunSkladnik;
    
    @FXML private TableView tableViewSkladniki;
    ObservableList<ObservableList> components;
    
    @FXML private TextField textFieldDodajSkladnikNazwa;
    @FXML private TextField textFieldUsunSkladnik;
    @FXML private TextField textFieldDodajSkladnikProducent;
    //@FXML private TextField textFieldDodajSkladnikCena;
    
    @FXML private Spinner<Double> spinnerCena;
    SpinnerValueFactory<Double> spinnerValueFactory;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        allIngredientsShowMethod();
        textFieldDodajSkladnikNazwa.setVisible(false);
        textFieldDodajSkladnikProducent.setVisible(false);
        //textFieldDodajSkladnikCena.setVisible(false);
        spinnerCena.setVisible(false);
        
        btnDodajSkladnik.setVisible(false);
        textFieldUsunSkladnik.setVisible(false);
        btnUsunSkladnik.setVisible(false);
        
        spinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.00, 500.00);
        spinnerValueFactory.setValue(5.00);
        spinnerCena.setValueFactory(spinnerValueFactory);
        
        
    }
    
    @FXML
    public void switchToDodajSkladnik(){
        textFieldUsunSkladnik.setVisible(false);
        btnUsunSkladnik.setVisible(false);
        textFieldDodajSkladnikNazwa.setVisible(true);
        textFieldDodajSkladnikProducent.setVisible(true);
        //textFieldDodajSkladnikCena.setVisible(true);
        spinnerCena.setVisible(true);
        btnDodajSkladnik.setVisible(true);
        allIngredientsShowMethod();
    }
    
    @FXML
    public void switchToUsunSkladnik(){
        textFieldUsunSkladnik.setVisible(true);
        btnUsunSkladnik.setVisible(true);
        textFieldDodajSkladnikNazwa.setVisible(false);
        textFieldDodajSkladnikProducent.setVisible(false);
        //textFieldDodajSkladnikCena.setVisible(false);
        spinnerCena.setVisible(false);
        btnDodajSkladnik.setVisible(false);
        allIngredientsShowMethod();
    }
    
    @FXML
    public void switchToEdytujSkladnik(){
        textFieldUsunSkladnik.setVisible(false);
        btnUsunSkladnik.setVisible(false);
        textFieldDodajSkladnikNazwa.setVisible(true);
        textFieldDodajSkladnikProducent.setVisible(true);
        //textFieldDodajSkladnikCena.setVisible(true);
        spinnerCena.setVisible(true);
        btnDodajSkladnik.setVisible(true);
        allIngredientsShowMethod();
        
    }
    
    @FXML
    public void dodajSkladnik(){
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(textFieldDodajSkladnikNazwa.getText());
        ingredient.setManufacturer(textFieldDodajSkladnikProducent.getText());
        ingredient.setPrice(spinnerCena.getValue());
        ingredient.addNewIngredient();
        textFieldDodajSkladnikNazwa.clear();
        textFieldDodajSkladnikProducent.clear();
        spinnerValueFactory.setValue(5.00);
        switchToDodajSkladnik();
    }
    
    @FXML void usunSkladnik(){
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(ingredient.getIngredientId(textFieldUsunSkladnik.getText()));
        ingredient.deleteIngredient();
        textFieldUsunSkladnik.clear();
        allIngredientsShowMethod();
    }
    
    
    
    @FXML
    public void getSelectedComponentForDelete(){
        String componentName = tableViewSkladniki.getSelectionModel().getSelectedItem().toString();
        //componentName = removeBrackets(componentName);
        componentName = firstElement(removeBrackets(componentName));
        textFieldUsunSkladnik.setText(componentName);
        
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
    
    
    //TableView
    public void allIngredientsShowMethod() {
	//The following statement removes the data before so no duplicates appearing
	// after opening the table again.
	tableViewSkladniki.getColumns().clear();
	components = FXCollections.observableArrayList();
		
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object statement
            Statement myStmt = myConnection.createStatement();
            String sql = "SELECT ingredientName, manufacturer, price FROM ingredients;";
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
            tableViewSkladniki.getColumns().addAll(col);
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
		components.add(row);	
            }
			
            tableViewSkladniki.setItems(components);		
            rs.close();
            myConnection.close();		
            //Adding scroll
            tableViewSkladniki.setMaxWidth(241);
            tableViewSkladniki.setMaxHeight(400);
				
	}catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
	}
    }
    
    
    
    
}
