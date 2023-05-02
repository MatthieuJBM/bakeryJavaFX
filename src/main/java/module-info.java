module com.mbaryla.bakery {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mbaryla.bakery to javafx.fxml;
    //opens com.mbaryla.bakery.subClientItemsController to javafx.base;
    exports com.mbaryla.bakery;
}
