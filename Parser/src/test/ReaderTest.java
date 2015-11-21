package test;

import Parser.Config;
import Parser.Reader;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Admin on 21.11.15.
 */
public class ReaderTest {

    @Test (expected = FileNotFoundException.class)
    public void testOpenFile() throws FileNotFoundException {
        Reader reader = new Reader();
        reader.con = Mockito.mock(Config.class);
        when(reader.con.getFilename()).thenReturn("wrong_path.csv");
        reader.openFile();

    }

}