package Parser;

import java.io.*;
import java.util.Properties;

/**
 * Created by Admin on 15.11.15.
 */
public class Config {
    private static final File f= new File("properties.properties");
    private Properties properties = new Properties();

    public void loadProperties()
    {
        InputStream is;
        try{
            is= new FileInputStream(f);
            properties.load(is);
        } catch (FileNotFoundException e)
        {e.printStackTrace();}
        catch(IOException e)
        {e.printStackTrace();}
    }

    public String getFilename() {return properties.getProperty("filename");}
    public String getOutputFilename() {return properties.getProperty("outputFilename");}
    public String getErrorsFilename() {return properties.getProperty("errorsFilename");}
    public int getRowsPerFile() {return Integer.parseInt(properties.getProperty("rowsPerFile"));}

}
