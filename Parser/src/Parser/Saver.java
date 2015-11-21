package Parser;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Admin on 16.11.15.
 */
public class Saver {

    public Config _hlp = new Config();

    public Saver()
    {
        _hlp.loadProperties();
    }

    public void personListFile(HashSet<Person> list) throws FileNotFoundException
    {
        Iterator iter = list.iterator();
        int tempRows = _hlp.getRowsPerFile();
        for(int i=0; i<(list.size()/_hlp.getRowsPerFile())+1; i++)
        {
            if(i==(list.size()/_hlp.getRowsPerFile()))
                tempRows=list.size()-i*tempRows;
            PrintWriter save = new PrintWriter(_hlp.getOutputFilename()+"_"+(i+1)+"_"+tempRows+".csv");
            for(int j=0; j<tempRows; j++)
                save.println(iter.next());
            save.close();
        }


    }


    public void errorsFile(ArrayList<Person> errors) throws FileNotFoundException
    {
        PrintWriter save = new PrintWriter(_hlp.getErrorsFilename()+"_"+errors.size()+".csv");
        for( Person o: errors)
            save.println(o.toString());
        save.close();
    }
}
