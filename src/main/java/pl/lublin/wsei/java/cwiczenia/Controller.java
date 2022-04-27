package pl.lublin.wsei.java.cwiczenia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import pl.lublin.wsei.java.cwiczenia.samodzielne.NoblistaMain;

import java.io.File;
import java.io.IOException;

public class Controller {

    @FXML
    public Label textFile;
    public TableColumn colName;
    public TableColumn colSurname;
    public TableColumn colYear;
    public TableColumn colCategory;
    public TableColumn colMotivation;
    public TableColumn colCountry;
    public TableView tableNoblista;

    NoblistaMain main = new NoblistaMain();
    public void LoadFile(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter xmlFilter = new FileChooser.ExtensionFilter("Pliki XML (*.xml)", "*.xml");

        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            textFile.setText(file.getAbsolutePath());
            main.LoadFile(file.getAbsolutePath());
        }else{
            textFile.setText("Nie wybrano Pliku...");
        }
    }

    void doTable(){

    }


    public void SaveFile(ActionEvent actionEvent) {

    }
}