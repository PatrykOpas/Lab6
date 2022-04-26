package pl.lublin.wsei.java.cwiczenia.console;

import java.io.*;

public class TestBufferedBinCopy {
    public static void main(String[] args) throws IOException{
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        long startTime = System.nanoTime();

        try{
            in = new BufferedInputStream(new FileInputStream("sample_1920×1280.tiff"));
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
        //Czas wykonania w nanosekundach = 108870400
        //Czas wykonania w milisekundach = 108


        /* Czy pojawił się błąd i czy został obsłużony – proszę wykazać, że tak:
        java.io.FileNotFoundException: sample_192 0×1280.tiff (Nie można odnaleźć określonego pliku)
        at java.base/java.io.FileInputStream.open0(Native Method)
        at java.base/java.io.FileInputStream.open(FileInputStream.java:216)
        at java.base/java.io.FileInputStream.<init>(FileInputStream.java:157)
        at java.base/java.io.FileInputStream.<init>(FileInputStream.java:111)
        at com.example.lab6/pl.lublin.wsei.java.cwiczenia.console.TestBufferedBinCopy.main(TestBufferedBinCopy.java:13)
        */

    }
}
