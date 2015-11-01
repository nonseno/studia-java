package zad; /**
 * Created by Admin on 08.10.15.
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class PageReader {
    private String file;
    private String line;
    private BufferedReader bfr;
    private FileReader fr;

    public PageReader(String file) {
        fr = null;
        line = "";
        this.file=file;
    }

    public void Open(String plik) throws FileNotFoundException {
        fr = new FileReader(plik);
        bfr = new BufferedReader(fr);
    }


    public ArrayList<String> read() throws IOException {
        Open(file);
        ArrayList<String> lines= new ArrayList<String>();
            while ((line = bfr.readLine()) != null) {
               lines.add(line);
            }
            close();
        return lines;
        }

    public void close() throws IOException {
        bfr.close();
    }

}


