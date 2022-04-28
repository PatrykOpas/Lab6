package pl.lublin.wsei.java.cwiczenia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pl.lublin.wsei.java.cwiczenia.samodzielne.Noblista;
import pl.lublin.wsei.java.cwiczenia.samodzielne.NoblistaMain;

import java.io.File;
import java.io.IOException;

public class Controller {
    public NoblistaMain noblistaMain = new NoblistaMain();

    @FXML
    public Label textFile;
    public TableColumn colName = new TableColumn("Imie");
    public TableColumn colSurname = new TableColumn("Nazwisko");
    public TableColumn colYear = new TableColumn("Rok");
    public TableColumn colCategory = new TableColumn("Kategoria");
    public TableColumn colMotivation = new TableColumn("Uzasadnienie");
    public TableColumn colCountry = new TableColumn("Kraj");
    public TableView<Noblista> tableNoblista = new TableView<>();

    public void LoadFile(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter xmlFilter = new FileChooser.ExtensionFilter("Pliki XML (*.xml)", "*.xml");

        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            textFile.setText(file.getAbsolutePath());
            noblistaMain.LoadFile(file.getAbsolutePath());
            doTable();
        }else{
            textFile.setText("Nie wybrano Pliku...");
        }
    }

    private final ObservableList<Noblista> data = FXCollections.observableArrayList();

    void doTable(){
        data.clear();
        tableNoblista.setItems(data);

        colName.setCellValueFactory(
                new PropertyValueFactory<Noblista, String>("Imie")
        );

        colSurname.setCellValueFactory(
                new PropertyValueFactory<Noblista, String>("Nazwisko")
        );

        colYear.setCellValueFactory(
                new PropertyValueFactory<Noblista, String>("Rok")
        );

        colCategory.setCellValueFactory(
                new PropertyValueFactory<Noblista, String>("Kategoria")
        );

        colMotivation.setCellValueFactory(
                new PropertyValueFactory<Noblista, String>("Uzasadnienie")
        );

        colCountry.setCellValueFactory(
                new PropertyValueFactory<Noblista, String>("Kraj")
        );


        for(int i = 0; i < noblistaMain.noblista.size(); i++){
            data.add(noblistaMain.noblista.get(i));
        }

    }


    public void SaveFile(ActionEvent actionEvent) {
        if(noblistaMain.noblista.size() <= 0){
            return;
        }
        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("export.fxml"));
            Parent root = loader.load();
            (loader.<Export>getController()).noblistaMain = noblistaMain;
            Stage stage = new Stage();
            stage.setTitle("Eksport Plikow");
            stage.setScene(new Scene(root, 250, 150));
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}