package Parser;

/**
 * Created by Admin on 14.11.15.
 */
public class Person {
    String pesel;
    String surname;
    String name;

    public Person(String pesel, String surname, String name)
    {
        this.pesel=pesel;
        this.surname=surname;
        this.name=name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return pesel.equals(person.pesel);

    }

    @Override
    public int hashCode() {
        return pesel.hashCode();
    }

    @Override
    public String toString() {
        return pesel + ';' + surname + ';' + name;
    }
}
