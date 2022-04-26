package pl.lublin.wsei.java.cwiczenia.samodzielne;
import java.util.ArrayList;

public class Noblista {
    String Imie, Nazwisko, Rok, Kategoria, Uzasadnienie, Kraj, DataRow;

    public Noblista(String datarow){
        DataRow = datarow;
        Split();
    }
    void Split(){
        ArrayList<String> columns = new ArrayList<>();

        int TextStart = 0;
        int TextEnd = 0;
        char[] textToArray = this.DataRow.toCharArray();

        for(int i = 0; i < textToArray.length; i++){
            TextEnd++;

            /*
           if(i == textToArray.length-1){
                columns.add(new String());
            }
            */

        }

        for (int i = 0; i < columns.size(); i++){
            switch (i){
                case 1:
                    this.Imie = columns.get(i);
                    break;
                case 2:
                    this.Nazwisko = columns.get(i);
                    break;
                case 12:
                    this.Rok = columns.get(i);
                    break;
                case 13:
                    this.Kategoria = columns.get(i);
                    break;
            }
        }
    }
}
