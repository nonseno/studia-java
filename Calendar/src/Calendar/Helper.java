package Calendar;

/**
 * Created by nonseno on 2016-01-10.
 */
public class Helper {
    private String taskName;
    private int categoryPosition;
    private int taskPosition;

    Helper(int categoryPosition, String taskName){
        this.categoryPosition=categoryPosition-1;
        this.taskName=taskName;
    }

    Helper(int categoryPosition, int taskPosition){
        this.categoryPosition=categoryPosition-1;
        this.taskPosition=taskPosition-1;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getCategoryPosition() {
        return categoryPosition;
    }

    public int getTaskPosition() {
        return taskPosition;
    }
}
