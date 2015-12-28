package test;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by Admin on 27.12.15.
 */
public class FileListenerTest {

    @Test
    public void ShouldBeSame(){
       Path path = Paths.get("no such a path");
        assertEquals(path.toString(), "no such a path");
    }

}