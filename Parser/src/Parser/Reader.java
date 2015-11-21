package Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Admin on 14.11.15.
 */
public class Reader{
    public Config con = new Config();
    private BufferedReader bfr;
    private FileReader fr;
    private String line;
    private ArrayList<String> list= new ArrayList<>();

    public Reader()
    {fr=null;}

    public void openFile() throws FileNotFoundException
    {
        con.loadProperties();
        fr= new FileReader(con.getFilename());
        bfr= new BufferedReader(fr);
    }

    public ArrayList<String> loadFile() throws IOException {
        openFile();
        while((line=bfr.readLine())!= null)
        {
            list.add(line);
        }
        return list;
    }

}
