module com.example.lab6 {
    requires javafx.controls;
    requires javafx.fxml;

    opens pl.lublin.wsei.java.cwiczenia.samodzielne;
    opens pl.lublin.wsei.java.cwiczenia to javafx.fxml;
    exports pl.lublin.wsei.java.cwiczenia;
}