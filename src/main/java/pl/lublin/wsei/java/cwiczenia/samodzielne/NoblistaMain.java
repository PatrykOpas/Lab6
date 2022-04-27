package pl.lublin.wsei.java.cwiczenia.samodzielne;
import java.io.*;
import java.util.ArrayList;

public class NoblistaMain {
    public ArrayList<Noblista> noblista = new ArrayList<>();
    public void LoadFile(String fileDict) throws IOException {
        noblista.clear();
        BufferedReader in = null;
        try{
            in = new BufferedReader(new FileReader(fileDict));
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
