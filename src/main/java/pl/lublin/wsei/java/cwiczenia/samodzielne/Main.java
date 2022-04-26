package pl.lublin.wsei.java.cwiczenia.samodzielne;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        ArrayList<Noblista> noblista = new ArrayList<>();

        try{
            in = new BufferedReader(new FileReader("nobel_prize_by_winner.csv"));
            String line;
            boolean firstLoop = true;
            while ((line = in.readLine()) != null){
                if(firstLoop){
                    firstLoop = false;
                    continue;
                }
                Noblista nob = new Noblista(line);
                noblista.add(nob);
            }
        }
        catch (IOException e){
            System.out.println("IOException" + e.getMessage());
            e.printStackTrace();
        }
        finally {
            if(in != null){
                in.close();
            }
        }
    }
}
