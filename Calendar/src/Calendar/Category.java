package Calendar;

import java.util.ArrayList;

/**
 * Created by Admin on 24.10.15.
 */
public class Category {
    public String name;
    public Priority pro;
    public ArrayList<Task> tasks;

    public Category(String name, Priority pro)
    {
        this.name=name;
        this.pro=pro;
        tasks= new ArrayList<>();
    }

}
