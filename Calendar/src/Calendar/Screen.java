package Calendar;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Admin on 24.10.15.
 */
public class Screen{
    protected ArrayList<Category> Calendar;
   // private Scanner In;
    private Priority urgent;
    private Priority normal;
    private Priority low;


    public Screen()
    {
        Calendar= new ArrayList<Category>();
        //In= new Scanner(System.in);
        urgent = Priority.URGENT;
        normal = Priority.NORMAL;
        low = Priority.LOW;
    }


    public void open () throws Exception
    {
        Menu ctr= new Menu();
        int choice=0;
        while(choice!=8) {
            choice=ctr.ShowMenu();
            switch(choice)
            {
                case 1:
                    AddCategory();
                    break;
                case 2:
                    AddTask();
                    break;
                case 3:
                    ctr.ShowCategories();
                    break;
                case 4:
                    ctr.ShowCategoriesPriority();
                    break;
                case 5:
                    DeleteTask();
                    break;
                case 6:
                    MarkTask();
                    break;
                case 7:
                    ctr.ShowUndoneTasks();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    public void AddCategory() throws Exception {
        Menu ctr= new Menu();
        ctr.clean();
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

    public void AddTask() {Menu ctr= new Menu();Calendar.get(ctr.CategoryAsk("Do ktorej kategori chcesz dodac zadanie? Podaj numer: ")-1).Add();}

    public void DeleteTask() {
        Menu ctr= new Menu();
        ctr.clean();
        int choice=ctr.CategoryAsk("Z ktorej kategori chcesz usunac zadanie? Podaj numer: ");
        String Removal=ctr.TaskAsk(choice,"Ktore zadanie chcesz usunac? Podaj nazwe: ");
        Calendar.get(choice-1).Tasks.remove(Removal);
    }

    public void MarkTask() throws Exception
    {
        Menu ctr= new Menu();
        ctr.clean();
        int choice=ctr.CategoryAsk("Z ktorej kategori chcesz oznaczyc zadnie jako wykonane? Podaj numer: ");
        String Marked=ctr.TaskAsk(choice,"Ktore zadanie chcesz oznaczyc jako wykonane? Podaj nazwe: ");
        if(Calendar.get(choice-1).Tasks.get(Calendar.get(choice-1).Tasks.indexOf(Marked)).MarkAsDone()==false)
            throw new Exception("Nie mozna bylo oznaczyc zadania jako wykonanego");


    }


}
