package test;

import Parser.Person;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Admin on 20.11.15.
 */
public class PersonTest {

    private Person person_1;
    private Person person_2;

    @Test
    public void testEqualsShouldBeEqual(){
         person_1 = new Person("85412618438","WROBEL","ANTONI");
         person_2 = new Person("85412618438","Nowy","Tester");
         assertTrue(person_1.equals(person_2));
    }

    @Test
    public void testEqualsShouldNotBeEqual(){
        person_1 = new Person("85412618438","WROBEL","ANTONI");
        person_2 = new Person("33290457577","PAWLAK","JAKUB");
        assertNotSame(person_1,person_2);

    }

    @Test
    public void testToStringShouldReturnTrue(){
        person_1 = new Person("33290457577","PAWLAK","JAKUB");
        assertEquals(person_1.toString(),"33290457577;PAWLAK;JAKUB");
    }



}