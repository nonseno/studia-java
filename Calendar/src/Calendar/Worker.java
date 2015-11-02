package Calendar;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Admin on 24.10.15.
 */
public class Worker{
    MenuPrinter ctr= new MenuPrinter();
    protected ArrayList<Category> Calendar;
    private Priority urgent;
    private Priority normal;
    private Priority low;


    public Worker()
    {
        Calendar= new ArrayList<>();
        urgent = Priority.URGENT;
        normal = Priority.NORMAL;
        low = Priority.LOW;
    }



    public void AddCategory() throws Exception {
        String NameTemp=ctr.QuestionString("Podaj nazwe nowej kategori: ");
        String PrioTemp=ctr.QuestionString("Podaj priorytet kategori (URGENT,NORMAL,LOW): ");
        PrioTemp=PrioTemp.toLowerCase();
        if(PrioTemp.matches(urgent.name().toLowerCase()))
        {
            Calendar.add(new Category(NameTemp,urgent));
        }
        else if(PrioTemp.matches(normal.name().toLowerCase()))
        {
            Calendar.add(new Category(NameTemp,normal));
        }
        else if(PrioTemp.matches(low.name().toLowerCase()))
        {
            Calendar.add(new Category(NameTemp,low));
        }
        else
        {
            throw new Exception("Podano zla kategorie");
        }
    }

    public void AddTask() {
        int choice=ctr.CategoryAsk("Do ktorej kategori chcesz dodac zadanie? Podaj numer: ", this);
        String adder=ctr.QuestionString("Podaj nazwe zadania: ");
        Calendar.get(choice-1).Tasks.add(new Task(adder));
    }




    public void DeleteTask() {
        int choice=ctr.CategoryAsk("Z ktorej kategori chcesz usunac zadanie? Podaj numer: ",this);
       int indexOfRemoval=ctr.TaskAsk(choice,"Ktore zadanie chcesz usunac? Podaj numer: ", this);
        Calendar.get(choice-1).Tasks.remove(indexOfRemoval);
    }

    public void MarkTask() throws Exception
    {
        int choice=ctr.CategoryAsk("Z ktorej kategori chcesz oznaczyc zadanie jako wykonane? Podaj numer: ",this);
        CheckIfTask(choice);
        int marked=ctr.TaskAsk(choice,"Ktore zadanie chcesz oznaczyc jako wykonane? Podaj numer: ",this);
        if(Calendar.get(choice-1).Tasks.get(marked).SetIsDone()==false)
            throw new Exception("Nie mozna bylo oznaczyc zadania jako wykonanego");


    }


    public void CheckIfTask(int choice) throws Exception
    {
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
        Calendar.add(new Category("za tydzien",urgent));
        Calendar.add(new Category("na jutro",normal));
        Calendar.add(new Category("na piatek",low));
        Calendar.get(0).Tasks.add(new Task("arytmetyka"));
        Calendar.get(0).Tasks.add(new Task("wizyta u lekarza"));
        Calendar.get(2).Tasks.add(new Task("sprawozdzanie z luca"));
        Calendar.get(0).Tasks.add(new Task("oplata za kredyt"));
    }

}
