package test;

import Parser.Checker;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 20.11.15.
 */
public class CheckerTest {

    private String[] tab = new String[1];
    private Checker checker;


    @Test
    public void testPeselShouldBeEqual(){
        checker = new Checker();
        tab[0]="78292232472";
        assertTrue(checker.Pesel(tab));
    }

    @Test
    public void testPeselShouldReturnFalse(){
        checker = new Checker();
        tab[0]="12345678901";
        assertFalse(checker.Pesel(tab));
    }

    @Test
    public void testLengthShouldBeEqual()
    {
        checker = new Checker();
        tab[0]="4021941111";
        tab = checker.Length(tab);
        assertEquals("04021941111",tab[0]);
    }

    @Test
    public void testLengthShouldReturnFalse()
    {
        checker = new Checker();
        tab[0]="9101577138";
        tab = checker.Length(tab);
        assertNotEquals("009101577138",tab[0]);
    }

}