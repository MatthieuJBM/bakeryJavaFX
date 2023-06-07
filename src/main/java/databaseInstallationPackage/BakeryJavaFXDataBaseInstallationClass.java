/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseInstallationPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author mbaryla
 */
public class BakeryJavaFXDataBaseInstallationClass {
    
    public void createDataBase() {
	String sqlCreateDatabase = "CREATE DATABASE BakeryJavaFX;";
	try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "1234");
            //Creating object Statement
            Statement myStmt = myConnection.createStatement();
            //Executing query
            myStmt.executeUpdate(sqlCreateDatabase);
            myConnection.close();
	} catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
	}
		
    }
    public void createTables() {
        String sqlUseCommend = "USE BakeryJavaFX";
            
        /***********************************************************
        TABLES FOR PRODUCTS MANAGEMENT
        ***********************************************************/      
        
        String sqlCreateTableAllergens = "CREATE TABLE allergens( "
                                    + "allergenId int auto_increment, "
                                    + "allergenName varchar(30), "
                                    + "PRIMARY KEY(allergenId)"
                                    + ");";
        String sqlCreateTableIngredients = "CREATE TABLE ingredients( "
                                    + "ingredientId int auto_increment, "
                                    + "ingredientName varchar(60), "
                                    + "manufacturer varchar(30), "
                                    + "price numeric(3,2), "
                                    + "PRIMARY KEY(ingredientId)"
                                    + ");";
        String sqlCreateTableAllergensConnectorToIngredients = "CREATE TABLE allergensConnectorToIngredients( "
                                    + "ingredientId int, "
                                    + "allergenId int, "
                                    + "PRIMARY KEY(ingredientId, allergenId)"
                                    + ");";
        String sqlCreateTableNourishmentTable = "CREATE TABLE nourishmentTable( "
                                    + "nourishmentId int auto_increment, "
                                    + "ingredientId int UNIQUE, "
                                    + "calories numeric(3,2), "
                                    + "protein numeric(3,2), "
                                    + "fat numeric(3,2), "
                                    + "sugar numeric(3,2), "
                                    + "salt numeric(3,2), "
                                    + "PRIMARY KEY(nourishmentId), "
                                    + "FOREIGN KEY(ingredientId) REFERENCES ingredients(ingredientId)"
                                    + ");";
        
        String sqlCreateTableBasicIngredients = "CREATE TABLE basicIngredients( "
                                    + "basicIngredientId int auto_increment, "
                                    + "basicIngredientName varchar(60), "
                                    + "PRIMARY KEY(basicIngredientId)"
                                    + ");";
        
        String sqlCreateTableBasicIngredientsConnectorToIngredients = "CREATE TABLE basicIngredientsConnectorToIngredients( "
                                    + "ingredientId int, "
                                    + "basicIngredientId int, "
                                    + "PRIMARY KEY(ingredientId, basicIngredientId)"
                                    + ");";
        
        String sqlCreateTableIngredientsWeight = "CREATE TABLE ingredientsWeight( "
                                    + "ingredientId int, "
                                    + "ingredientWeight numeric(5,2), "
                                    + "FOREIGN KEY(ingredientId) REFERENCES ingredients(ingredientId)"
                                    + ");";
        
        String sqlCreateTableCategories = "CREATE TABLE categories( "
                                    + "categoryId int auto_increment, "
                                    + "categoryName varchar(30), "
                                    + "PRIMARY KEY(categoryId)"
                                    + ");";
        
        String sqlCreateTableSubcategories = "CREATE TABLE subcategories( "
                                    + "subcategoryId int auto_increment, "
                                    + "subcategoryName varchar(30), "
                                    + "categoryId int, "
                                    + "PRIMARY KEY(subcategoryId), "
                                    + "FOREIGN KEY(categoryId) REFERENCES categories(categoryId)"
                                    + ");";
        
        String sqlCreateTableProducts = "CREATE TABLE products( "
                                    + "productId int auto_increment, "
                                    + "productName varchar(30), "
                                    + "subcategoryId int, "
                                    + "PRIMARY KEY(productId), "
                                    + "FOREIGN KEY(subcategoryId) REFERENCES subcategories(subcategoryId)"
                                    + ");";
        
        String sqlCreateTableComponents = "CREATE TABLE components( "
                                    + "	productId int, "
                                    + "ingredientId int, "
                                    + "FOREIGN KEY(productId) REFERENCES products(productId), "
                                    + "FOREIGN KEY(ingredientId) REFERENCES ingredientsWeight(ingredientId)"
                                    + ");";
        
        
        String sqlCreateTableCategory = "CREATE TABLE categories( "
                                    + "categoryId int, "
                                    + "categoryName varchar(30), "
                                    + "PRIMARY KEY(categoryId)"
                                    + ");";
        
        String sqlCreateTableProductsAndPrices = "CREATE TABLE prices( "
                                    + "productId int, "
                                    + "productPrice numeric(8,2), "
                                    + "FOREIGN KEY(productId) REFERENCES products(productId)"
                                    + ");";
            
            
            
        /***********************************************************
        TABLES FOR WORKERS MANAGEMENT
        ***********************************************************/    
            
        String sqlCreateTableEntities = "CREATE TABLE Entities( "
                                    + "entity_id varchar(10), "
                                    + "entity_name varchar(30), "
                                    + "city varchar(40), "
                                    + "street varchar(40), "
                                    + "street_number varchar(10), "
                                    + "zip_code varchar(10),"
                                    + "PRIMARY KEY (entity_id) "
                                    + ");";
        String sqlCreateTablePositions = "CREATE TABLE Positions( "
                                    + "position_name varchar(30), "
                                    + "entity_id varchar(10) REFERENCES Entities(entity_id) "
                                    + ");";
        String sqlCreateTableEntities_costs = "CREATE TABLE Entities_costs( "
                                    + "entity_id varchar(10) REFERENCES Entities(entity_id), "
                                    + "rental numeric(8,2), "
                                    + "utilities numeric(8,2), "
                                    + "employees_salaries_sum numeric(8,2), "
                                    + "income numeric(8,2), "
                                    + "profit numeric(8,2),"
                                    + "month varchar(2),"
                                    + "year varchar(4) "
                                    + ");";
        String sqlCreateTableEmployees = "CREATE TABLE Employees( "
                                    + "empl_id varchar(10), "
                                    + "first_name varchar(30), "
                                    + "last_name varchar(30), "
                                    + "salary numeric(8,2), "
                                    + "start_date date, "
                                    + "end_date date, "
                                    + "entity_id varchar(10) REFERENCES Entities(entity_id), "
                                    + "PRIMARY KEY (empl_id) "
                                    + ");";
        String sqlCreateTableEmployees_contact_info = "CREATE TABLE Employees_contact_info( "
                                    + "empl_id varchar(10) REFERENCES Employees(empl_id), "
                                    + "email varchar(40), "
                                    + "phone varchar(20), "
                                    + "city varchar(40), "
                                    + "street varchar(40), "
                                    + "street_number varchar(10), "
                                    + "zip_code varchar(10) "
                                    + ");";
        String sqlCreateTableEmergency_contact = "CREATE TABLE Emergency_contact( "
                                    + "empl_id varchar(10) REFERENCES Employees(empl_id), "
                                    + "phone varchar(20), "
                                    + "city varchar(40), "
                                    + "street varchar(40), "
                                    + "street_number varchar(10), "
                                    + "zip_code varchar(10) "
                                    + ");";
        String sqlAddingDeleteOnCascadeConstraintToContactInfo = "ALTER TABLE Employees_contact_info ADD CONSTRAINT fk_empl_id FOREIGN KEY (empl_id)"
                                    + " REFERENCES Employees(empl_id) ON DELETE CASCADE ON UPDATE NO ACTION;";
		
		
        try {
            //Creating connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BakeryJavaFX", "root", "1234");
            //Creating object Statement
            Statement myStmt = myConnection.createStatement();
            //Executing query
            myStmt.executeUpdate(sqlUseCommend);
            //Tables for workers management
            myStmt.executeUpdate(sqlCreateTableEntities);
            myStmt.executeUpdate(sqlCreateTablePositions);
            myStmt.executeUpdate(sqlCreateTableEntities_costs);
            myStmt.executeUpdate(sqlCreateTableEmployees);
            myStmt.executeUpdate(sqlCreateTableEmployees_contact_info);
            myStmt.executeUpdate(sqlCreateTableEmergency_contact);
            myStmt.executeUpdate(sqlAddingDeleteOnCascadeConstraintToContactInfo);
            //Tables for products management
            myStmt.executeUpdate(sqlCreateTableAllergens);
            myStmt.executeUpdate(sqlCreateTableIngredients);
            myStmt.executeUpdate(sqlCreateTableAllergensConnectorToIngredients);
            myStmt.executeUpdate(sqlCreateTableNourishmentTable);
            myStmt.executeUpdate(sqlCreateTableBasicIngredients);
            myStmt.executeUpdate(sqlCreateTableBasicIngredientsConnectorToIngredients);
            myStmt.executeUpdate(sqlCreateTableIngredientsWeight);
            myStmt.executeUpdate(sqlCreateTableCategories);
            myStmt.executeUpdate(sqlCreateTableSubcategories);
            myStmt.executeUpdate(sqlCreateTableProducts);
            myStmt.executeUpdate(sqlCreateTableComponents);
            myStmt.executeUpdate(sqlCreateTableCategory);
			
            myConnection.close();
	} catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
	}
    }
    
    public void initializeWithData() {
        String sqlInsertCategories = "INSERT INTO categories(categoryName) VALUES(\"Wypieki\"); "
                                + "INSERT INTO categories(categoryName) VALUES(\"Ciasta\"); "
                                + "INSERT INTO categories(categoryName) VALUES(\"Torty\"); "
                                + "INSERT INTO categories(categoryName) VALUES(\"Dekoracje\"); "
                                + "INSERT INTO categories(categoryName) VALUES(\"Napoje\");";
        String sqlInsertSubCategories = "INSERT INTO subcategories(subcategoryName, categoryId) VALUES(\"Drożdżówki\", 1); "
                                + "INSERT INTO subcategories(subcategoryName, categoryId) VALUES(\"Pączki\", 1); "
                                + "INSERT INTO subcategories(subcategoryName, categoryId) VALUES(\"Pizze\", 1); "
                                + "INSERT INTO subcategories(subcategoryName, categoryId) VALUES(\"Cebulaki\", 1);";
        String sqlInsertProducts = "INSERT INTO products(productName, subCategoryId, price) VALUES(\"Drożdżówka z Czekoladą\", 1, 3.50); "
                                + "INSERT INTO products(productName, subCategoryId, price) VALUES(\"Drożdżówka z Serem\", 1, 4.00); "
                                + "INSERT INTO products(productName, subCategoryId, price) VALUES(\"Drożdżówka z Marmeladą\", 1, 3.50); "
                                + "INSERT INTO products(productName, subCategoryId, price) VALUES(\"Rogal z Bitą Śmietaną\", 1, 5.00);";
        
        
    }

        
}
