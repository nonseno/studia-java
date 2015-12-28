package Calendar;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Admin on 24.10.15.
 */
public class Category {
    protected String Name;
    protected Priority Pro;
    protected ArrayList<Task> Tasks;

    public Category(String Name, Priority Pro)
    {
        this.Name=Name;
        this.Pro=Pro;
        Tasks= new ArrayList<>();
    }

}
