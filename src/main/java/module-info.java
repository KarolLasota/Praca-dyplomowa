module com.lasota.praca_dyplomowa {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.lasota.praca_dyplomowa to javafx.fxml;
    exports com.lasota.praca_dyplomowa;
    exports com.lasota.praca_dyplomowa.classes;
    opens com.lasota.praca_dyplomowa.classes to javafx.fxml;



}