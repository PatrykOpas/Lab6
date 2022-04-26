package pl.lublin.wsei.java.cwiczenia.console;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestNioCopy {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        Path Oryginal = Paths.get("sample_1920×1280.tiff");
        Path Kopia = Paths.get("img_copy.tiff");

        Files.copy(Oryginal, Kopia, StandardCopyOption.REPLACE_EXISTING);

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Czas wykonania w nanosekundach = " + timeElapsed);
        System.out.println("Czas wykonania w milisekundach = " + timeElapsed / 1000000);

        //Podejscie 3:
        //Czas wykonania w nanosekundach = 16856500
        //Czas wykonania w milisekundach = 16

        /*
        Exception in thread "main" java.nio.file.FileAlreadyExistsException: img_copy.tiff
        at java.base/sun.nio.fs.WindowsFileCopy.copy(WindowsFileCopy.java:124)
        at java.base/sun.nio.fs.WindowsFileSystemProvider.copy(WindowsFileSystemProvider.java:284)
        at java.base/java.nio.file.Files.copy(Files.java:1305)
        at com.example.lab6/pl.lublin.wsei.java.cwiczenia.console.TestNioCopy.main(TestNioCopy.java:15)
        */
    }
}
