package Calendar;

/**
 * Created by Admin on 24.10.15.
 */
public class Task {
    private String name;
    private boolean isDone;


    public Task(String name)
    {
        this.name=name;
        this.isDone=false;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return isDone;
    }

    public boolean setIsDone() {this.isDone=true; return true;}

}
