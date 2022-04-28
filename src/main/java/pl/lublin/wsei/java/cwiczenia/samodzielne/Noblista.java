package pl.lublin.wsei.java.cwiczenia.samodzielne;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Noblista {
    private StringProperty Imie, Nazwisko, Rok, Kategoria, Uzasadnienie, Kraj;
    String DataRow;

    public Noblista(String datarow){
        DataRow = datarow;
        Imie = new SimpleStringProperty("");
        Nazwisko = new SimpleStringProperty("");
        Rok = new SimpleStringProperty("");
        Kategoria = new SimpleStringProperty("");
        Uzasadnienie = new SimpleStringProperty("");
        Kraj = new SimpleStringProperty("");
        Split();
    }

    public String getImie(){
        return this.Imie.get();
    }

    public String getNazwisko(){
        return this.Nazwisko.get();
    }

    public String getRok(){
        return this.Rok.get();
    }

    public String getKategoria(){
        return this.Kategoria.get();
    }

    public String getUzasadnienie(){
        return this.Uzasadnienie.get();
    }

    public String getKraj(){
        return this.Kraj.get();
    }

    public void setImie(String name){
        this.Imie.set(name);
    }

    public void setNazwisko(String surname){
        this.Nazwisko.set(surname);
    }

    public void setRok(String year){
        this.Rok.set(year);
    }

    public void setKategoria(String category){
        this.Kategoria.set(category);
    }

    public void setUzasadnienie(String motivation){
        this.Uzasadnienie.set(motivation);
    }

    public void setKraj(String country){
        this.Kraj.set(country);
    }

    public String getDataRow(){
        return this.DataRow;
    }

    ArrayList<String> ConvertData(String[] textToArray){
        ArrayList<String> columns = new ArrayList<>();
        String item = "";
        for(int i = 0; i < textToArray.length; i++){
            if(textToArray[i].contains("\"") && (textToArray[i].toCharArray()[textToArray[i].toCharArray().length-1]) != '\"') {
                if(item == ""){
                    item += textToArray[i];
                }
                else if (item != ""){
                    item += textToArray[i];
                    columns.add(item);
                    item = "";
                }
            }
            else if(textToArray[i].contains("\"") && (textToArray[i].toCharArray()[textToArray[i].toCharArray().length-1]) == '\"'){
                item += textToArray[i];
                columns.add(item);
                item = "";
            }
            else if(!textToArray[i].contains("\"") && item != ""){
                item += textToArray[i];
            }
            else{
                columns.add(textToArray[i]);
            }
        }
        return columns;
    }

    void Split(){
        String[] textToArray = this.DataRow.split(",");
        ArrayList<String> columns = ConvertData(textToArray);

        for (int i = 0; i < columns.size(); i++){
            switch (i){
                case 1:
                    this.setImie(columns.get(i).replace("\"",""));
                    break;
                case 2:
                    this.setNazwisko(columns.get(i).replace("\"",""));
                    break;
                case 12:
                    this.setRok(columns.get(i).replace("\"",""));
                    break;
                case 13:
                    this.setKategoria(columns.get(i).replace("\"",""));
                    break;
                case 16:
                    this.setUzasadnienie(columns.get(i).replace("\"",""));
                    break;
                case 19:
                    this.setKraj(columns.get(i).replace("\"",""));
                    break;
            }

        }
    }
}
