package test;

import org.junit.Test;
import org.mockito.Mockito;
import java.io.*;

/**
 * Created by Admin on 27.12.15.
 */
public class FileSenderTest {


    @Test(expected=IOException.class)
    public void ShouldThrowIOException() throws IOException {
        OutputStream mock=Mockito.mock(OutputStream.class);
        OutputStreamWriter osw=new OutputStreamWriter(mock);
        Mockito.doThrow(new IOException()).when(mock).close();
        osw.close();
    }

}