package test;

import Parser.Config;
import Parser.Person;
import Parser.Saver;
import org.junit.Test;
import org.mockito.Mockito;


import java.io.FileNotFoundException;
import java.rmi.NotBoundException;
import java.util.HashSet;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


/**
 * Created by Admin on 21.11.15.
 */
public class SaverTest {

    @Test (expected = ArithmeticException.class)
    public void testPersonListFileShouldThrowAirthException_1() throws FileNotFoundException {
        Saver saver = new Saver();
        HashSet<Person> list = new HashSet<>();
        saver._hlp = Mockito.mock(Config.class);
        when(saver._hlp.getOutputFilename()).thenReturn("wrong_path.csv");
        saver.personListFile(list);
    }

    @Test (expected = ArithmeticException.class)
    public void testPersonListFileShouldThrowArithException_2() throws FileNotFoundException {
        //cannot divide by 0
        Saver saver = new Saver();
        saver._hlp = Mockito.mock(Config.class);
        when(saver._hlp.getRowsPerFile()).thenReturn(0);
        HashSet<Person> list = new HashSet<>();
        list.add(new Person("1234567901","TAKI","KOD"));
        saver.personListFile(list);

    }


}