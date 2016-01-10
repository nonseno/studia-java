package Calendar;

import java.util.ArrayList;

/**
 * Created by Admin on 24.10.15.
 */
public class Category {
    private String name;
    private Priority pro;
    private ArrayList<Task> tasks;

    public Category(String name, Priority pro)
    {
        this.name=name;
        this.pro=pro;
        tasks= new ArrayList<>();
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeTask(int position){
        tasks.remove(position);
    }

    public Task getTask(int position) {
        return tasks.get(position);
    }

    public int getSize() {
        return tasks.size();
    }

    public Priority getPro() {
        return pro;
    }
}
