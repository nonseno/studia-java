package Calendar;


import java.util.ArrayList;

/**
 * Created by Admin on 24.10.15.
 */
public class Worker{
    private  ArrayList<Category> calendar = new ArrayList<>();



    public ArrayList<Category> getCalendar() {
        return calendar;
    }

    public void addCategory(Category category) throws Exception {
        calendar.add(category);
    }

    public void addTask(int categoryPosition, String taskName) {
        calendar.get(categoryPosition).addTask(new Task(taskName));
    }


    public void removeTask(int categoryPosition, int taskPosition) {
        calendar.get(categoryPosition).removeTask(taskPosition);
    }

    public void markTask(int categoryPosition, int taskPosition) throws Exception
    {
     if(!(calendar.get(categoryPosition).getTask(taskPosition).setIsDone()))
            throw new Exception("Nie mozna bylo oznaczyc zadania jako wykonanego");
    }

    public Task getDoneTasks(int i, int j)
    {
        return calendar.get(i).getTask(j);
    }

    public int getSize()
    {
        return calendar.size();
    }


}
