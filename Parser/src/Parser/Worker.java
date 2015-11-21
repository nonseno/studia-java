package Parser;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Admin on 15.11.15.
 */
public class Worker {
    ArrayList<String> list=new ArrayList<>();
    ArrayList<Person> errors = new ArrayList<>();
    HashSet<Person> personList = new HashSet<>();
    Checker check= new Checker();

    public Worker(ArrayList<String> list)
    {this.list=list;}

    public void setPerson()
    {
        for(String s : list)
            {
                String[] tab=s.split(";");
                check.Length(tab);
                if(!(check.Pesel(tab)))
                    errors.add(new Person(tab[0], tab[1], tab[2]));
                personList.add(new Person(tab[0],tab[1],tab[2]));
            }
    }

    public HashSet<Person> getPersonList() {return personList;}
    public ArrayList<Person> getErrors() {return errors;}
}
