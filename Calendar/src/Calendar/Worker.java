package Calendar;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Admin on 24.10.15.
 */
public class Worker{
    public ArrayList<Category> Calendar;


    public Worker()
    {
        Calendar= new ArrayList<>();
    }



    public void AddCategory(Category cat) throws Exception {
        Calendar.add(cat);
    }

    public void AddTask(String[] tab) {
        System.out.println(tab[0] +","+ tab[1]);
        Calendar.get(Integer.parseInt(tab[0])-1).Tasks.add(new Task(tab[1]));
    }


    public void RemoveTask(String[] tab) {
        Calendar.get(Integer.parseInt(tab[0])-1).Tasks.remove(Integer.parseInt(tab[1]) - 1);
    }

    public void MarkTask(String[] tab) throws Exception
    {
        if(Calendar.get(Integer.parseInt(tab[0])-1).Tasks.get(Integer.parseInt(tab[1])).SetIsDone()==false)
            throw new Exception("Nie mozna bylo oznaczyc zadania jako wykonanego");
    }

    public Task getUndoneTasks(int i, int j)
    {
        return Calendar.get(i).Tasks.get(j);
    }


    public void CheckIfTask(String choic) throws Exception
    {
        int choice=Integer.parseInt(choic);
        if(Calendar.get(choice-1).Tasks.isEmpty())
            throw new Exception("W kategori nie ma zadnych zadan");
        int j=0;
        for(int i=0; i<Calendar.get(choice-1).Tasks.size(); i++)
        {
            if(Calendar.get(choice-1).Tasks.get(i).IsDone==false)
                j++;
        }
        if(j==0)
            throw new Exception("Wszystkie zadania zostaly juz wykonane");

    }


    public void AddFewCategoriesStacks()
    {
        Calendar.add(new Category("za tydzien",Priority.URGENT));
        Calendar.add(new Category("na jutro",Priority.NORMAL));
        Calendar.add(new Category("na piatek",Priority.LOW));
        Calendar.get(0).Tasks.add(new Task("arytmetyka"));
        Calendar.get(0).Tasks.add(new Task("wizyta u lekarza"));
        Calendar.get(2).Tasks.add(new Task("sprawozdzanie z luca"));
        Calendar.get(0).Tasks.add(new Task("oplata za kredyt"));
    }

}
