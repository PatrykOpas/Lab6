package pl.lublin.wsei.java.cwiczenia;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import pl.lublin.wsei.java.cwiczenia.samodzielne.Noblista;
import pl.lublin.wsei.java.cwiczenia.samodzielne.NoblistaMain;

import java.io.*;
import java.util.ArrayList;

public class Export {

    public NoblistaMain noblistaMain;
    ArrayList<Noblista> noblistaDoExportu = new ArrayList<Noblista>();

    @FXML
    public TextField textRok;
    public TextField textKraj;
    public TextField textDziedzina;

    public void exportClick(ActionEvent actionEvent) throws IOException, InterruptedException {
        noblistaDoExportu.clear();

        boolean delete = false;
        String TextFilterYear = textRok.getText();
        if(TextFilterYear == null) TextFilterYear = "";
        if(TextFilterYear != ""){
            for (int i = 0; i < noblistaMain.noblista.size(); i++) {
                if(noblistaMain.noblista.get(i).getRok().equals(TextFilterYear)){
                    noblistaDoExportu.add(noblistaMain.noblista.get(i));
                }
            }
            delete = true;
        }


        String TextFilterCountry = textKraj.getText();
        if(TextFilterCountry == null) TextFilterCountry = "";
        if(!TextFilterCountry.equals("")){
            if(noblistaDoExportu.size() > 0 && delete){
                for (int i = 0; i < noblistaDoExportu.size(); i++) {
                    if(!noblistaDoExportu.get(i).getKraj().equals(TextFilterCountry)){
                        noblistaDoExportu.remove(i);
                        i--;
                    }
                }
            }
            else if(noblistaDoExportu.size() <= 0 && !delete){
                for (int i = 0; i < noblistaMain.noblista.size(); i++) {
                    if(noblistaMain.noblista.get(i).getKraj().equals(TextFilterCountry)){
                        noblistaDoExportu.add(noblistaMain.noblista.get(i));
                    }
                }
                delete = false;
            }
        }

        if(noblistaDoExportu.size() > 0){
            delete = true;
        }


        String TextFilterCategory = textDziedzina.getText();
        if(TextFilterCategory == null) TextFilterCategory = "";
        if(!TextFilterCategory.equals("")){
            if(noblistaDoExportu.size() > 0 && delete){
                for (int i = 0; i < noblistaDoExportu.size(); i++) {
                    if(!noblistaDoExportu.get(i).getKategoria().equals(TextFilterCategory)){
                        noblistaDoExportu.remove(i);
                        i--;
                    }
                }
            }
            else if(noblistaDoExportu.size() <= 0 && !delete){
                for (int i = 0; i < noblistaMain.noblista.size(); i++) {
                    if(noblistaMain.noblista.get(i).getKategoria().equals(TextFilterCategory)){
                        noblistaDoExportu.add(noblistaMain.noblista.get(i));
                    }
                }
            }
        }


        if(TextFilterCountry != "" && TextFilterYear != "" && TextFilterCategory != "" && noblistaDoExportu.size() <= 0){
            return;
        }

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT pliki (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File fileSave = fileChooser.showSaveDialog(null);
        String pathToSave = fileSave.getAbsolutePath();

        PrintStream out2 = null;
        try{
            out2 = new PrintStream(new FileOutputStream(pathToSave));
            if(noblistaDoExportu.size() > 0){
                for (int i = 0; i < noblistaDoExportu.size(); i++) {
                    out2.println(noblistaDoExportu.get(i).getDataRow());
                }
            }else{
                for (int i = 0; i < noblistaMain.noblista.size(); i++) {
                    out2.println(noblistaMain.noblista.get(i).getDataRow());
                }
            }
        }catch (IOException e){
            e.getMessage();
        }
        finally {
            out2.close();
        }
    }
}
