package Calendar;

/**
 * Created by Admin on 24.10.15.
 */
public class Task {
    public String name;
    public boolean isDone;


    public Task(String name)
    {
        this.name=name;
        this.isDone=false;
    }

    public boolean SetIsDone() {this.isDone=true; return true;}

}
