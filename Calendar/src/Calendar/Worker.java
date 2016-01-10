package Calendar;


import java.util.ArrayList;

/**
 * Created by Admin on 24.10.15.
 */
public class Worker{
    public  ArrayList<Category> Calendar = new ArrayList<>();


    public void AddCategory(Category cat) throws Exception {
        Calendar.add(cat);
    }

    public void AddTask(Helper helper) {
        Calendar.get(helper.getCategoryPosition()).tasks.add(new Task(helper.getTaskName()));
    }


    public void RemoveTask(Helper helper) {
        Calendar.get(helper.getCategoryPosition()).tasks.remove(helper.getTaskPosition());
    }

    public void MarkTask(Helper helper) throws Exception
    {
        if(!(Calendar.get(helper.getCategoryPosition()).tasks.get(helper.getTaskPosition()).SetIsDone()))
            throw new Exception("Nie mozna bylo oznaczyc zadania jako wykonanego");
    }

    public Task getUndoneTasks(int i, int j)
    {
        return Calendar.get(i).tasks.get(j);
    }


    public void CheckIfThereAreUndoneTasks(int choice) throws Exception
    {
        if(Calendar.get(choice-1).tasks.isEmpty())
            throw new Exception("W kategori nie ma zadnych zadan");
        int j=0;
        for(int i=0; i<Calendar.get(choice-1).tasks.size(); i++)
        {
            if(!(Calendar.get(choice-1).tasks.get(i).isDone))
                j++;
        }
        if(j==0)
            throw new Exception("Wszystkie zadania zostaly juz wykonane");
    }

}
