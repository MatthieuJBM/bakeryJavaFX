package com.mbaryla.bakery;

import databaseInstallationPackage.BakeryJavaFXDataBaseInstallationClass;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 700, 480);
        stage.setScene(scene);
        stage.show();
        
        //Installation of DataBase on the computer
	try {
            //Checking if database already exists
            ArrayList<String> list = new ArrayList<String>();
            String data_base_name = "BakeryJavaFX";
            Connection myConnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "1234");
            System.out.println("Conexion establecida");
            DatabaseMetaData dbm = myConnect.getMetaData();
            ResultSet rs = dbm.getCatalogs();
            while(rs.next()) {
		String listOfDatabases = rs.getString("TABLE_CAT");
		list.add(listOfDatabases);
            }
            if(list.contains(data_base_name)) {
		System.out.println("Database already exists");
            }else {
		//Creating Database and tables
		BakeryJavaFXDataBaseInstallationClass install_data_base = new BakeryJavaFXDataBaseInstallationClass();
		install_data_base.createDataBase();
		install_data_base.createTables();
            }
            rs.close();
            myConnect.close();
	}catch(Exception e) {
            e.printStackTrace();
	}
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        //launch();
       
        
        launch();
    }

}