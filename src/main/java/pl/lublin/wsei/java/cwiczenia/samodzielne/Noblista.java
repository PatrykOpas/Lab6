package pl.lublin.wsei.java.cwiczenia.samodzielne;
import java.util.ArrayList;

public class Noblista {
    String Imie, Nazwisko, Rok, Kategoria, Uzasadnienie, Kraj, DataRow;

    public Noblista(String datarow){
        DataRow = datarow;
        Split();
    }

    public String getName(){
        return (this.Imie + " " +this.Nazwisko);
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
                    this.Imie = columns.get(i).replace("\"","");
                    break;
                case 2:
                    this.Nazwisko = columns.get(i).replace("\"","");
                    break;
                case 12:
                    this.Rok = columns.get(i).replace("\"","");
                    break;
                case 13:
                    this.Kategoria = columns.get(i).replace("\"","");
                    break;
                case 16:
                    this.Uzasadnienie = columns.get(i).replace("\"","");
                    break;
                case 19:
                    this.Kraj = columns.get(i).replace("\"","");
                    break;
            }

        }
    }
}
