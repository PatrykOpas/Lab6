package pl.lublin.wsei.java.cwiczenia.console;

import java.io.*;
import java.net.URL;

public class CopyFromURL{
    public static void main(String[] args) throws IOException {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        long startTime = System.nanoTime();
        URL url = new URL("https://filesamples.com/samples/image/tiff/sample_1920%C3%971280.tiff");

        try{
            in = new BufferedInputStream(url.openStream());
            out = new BufferedOutputStream(new FileOutputStream("img_copy.tiff"));
            int c;

            while ((c = in.read()) != 1){
                out.write(c);
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
            if (out != null){
                out.close();
            }
        }

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("Czas wykonania w nanosekundach = " + timeElapsed);
        System.out.println("Czas wykonania w milisekundach = " + timeElapsed / 1000000);

        //Podejscie 2:
        //Czas wykonania w nanosekundach = 854806300
        //Czas wykonania w milisekundach = 854

    }
}
