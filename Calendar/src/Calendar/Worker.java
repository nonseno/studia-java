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

    public void addTask(Handler handler) {
        calendar.get(handler.getCategoryPosition()).addTask(new Task(handler.getTaskName()));
    }


    public void removeTask(Handler handler) {
        calendar.get(handler.getCategoryPosition()).removeTask(handler.getTaskPosition());
    }

    public void markTask(Handler handler) throws Exception
    {
     if(!(calendar.get(handler.getCategoryPosition()).getTask(handler.getTaskPosition()).setIsDone()))
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
