package Calendar;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Admin on 24.10.15.
 */
public class Worker{
    public static ArrayList<Category> Calendar = new ArrayList<>();

    static{
        Calendar.add(new Category("za tydzien",Priority.URGENT));
        Calendar.add(new Category("na jutro",Priority.NORMAL));
        Calendar.add(new Category("na piatek",Priority.LOW));
        Calendar.add(new Category("na wczoraj",Priority.URGENT));
        Calendar.get(0).Tasks.add(new Task("arytmetyka"));
        Calendar.get(0).Tasks.add(new Task("wizyta u lekarza"));
        Calendar.get(2).Tasks.add(new Task("sprawozdzanie z luca"));
        Calendar.get(0).Tasks.add(new Task("oplata za kredyt"));
        Calendar.get(3).Tasks.add(new Task("sprawozdanie z fizyki"));
        Calendar.get(3).Tasks.add(new Task("skonczyc program"));
        Calendar.get(0).Tasks.get(2).SetIsDone();
        Calendar.get(3).Tasks.get(1).SetIsDone();
    }



    public void AddCategory(Category cat){
        Calendar.add(cat);
    }
    public void AddTask(String[] CategoryTaskIndex) {
        if(!(CategoryTaskIndex[1].equals("")))
            Calendar.get(Integer.parseInt(CategoryTaskIndex[0])).Tasks.add(new Task(CategoryTaskIndex[1]));
    }
    public void MarkTask(int[] CategoryTaskIndex)
    {
        Calendar.get(CategoryTaskIndex[0]).Tasks.get(CategoryTaskIndex[1]).SetIsDone();
    }
    public Task getUndoneTasks(int i, int j)
    {
        return Calendar.get(i).Tasks.get(j);
    }
    public void DeleteTask(int[] CategoryTaskIndex) {Calendar.get(CategoryTaskIndex[0]).Tasks.remove(CategoryTaskIndex[1]);}


    public int[] returnNumberofDoneUndone()
    {
        int[] numberOfDoneUndone = new int [2];
        for(Category x : Calendar)
        {
            for(Task y : x.Tasks)
            {
                if(y.IsDone)
                    numberOfDoneUndone[0]++;
                else
                    numberOfDoneUndone[1]++;
            }
        }
        return numberOfDoneUndone;
    }

}
