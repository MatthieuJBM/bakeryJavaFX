module com.mbaryla.bakery {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.sql;
    requires java.logging;
    requires net.bytebuddy;
    requires java.xml.bind;

    opens com.mbaryla.bakery to javafx.fxml, org.hibernate.orm.core;
    //opens com.mbaryla.bakery.subClientItemsController to javafx.base;
    //opens com.mbaryla.bakery to org.hibernate.orm.core;
    opens model to javafx.base;
    exports com.mbaryla.bakery;
    
    uses javax.persistence.spi.PersistenceProvider;
}
