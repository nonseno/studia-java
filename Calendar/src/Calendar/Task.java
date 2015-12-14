package Calendar;

/**
 * Created by Admin on 24.10.15.
 */
public class Task {
    protected String Name;
    protected boolean IsDone;


    public Task(String Name)
    {
        this.Name=Name;
        this.IsDone=false;
    }

    public boolean SetIsDone() {this.IsDone=true; return true;}

}
