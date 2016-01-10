package Calendar;


import java.util.ArrayList;

/**
 * Created by Admin on 24.10.15.
 */
public class Worker{
    private  ArrayList<Category> calendar = new ArrayList<>();
    MenuPrinter menuPrinter = new MenuPrinter();

    public int getSize()
    {
        return calendar.size();
    }

    public ArrayList<Category> getCalendar() {
        return calendar;
    }

    public void addCategory() throws Exception {
        String categoryName=menuPrinter.questionString("Podaj nazwe nowej kategori: ");
        String categoryPriority=menuPrinter.questionString("Podaj priorytet kategori (URGENT,NORMAL,LOW): ");
        categoryPriority=categoryPriority.toLowerCase();
        calendar.add(new Category(categoryName,Priority.valueOf(categoryPriority)));
    }

    public void addTask() {
        int categoryPosition = menuPrinter.categoryAsk("Do ktorej kategori chcesz dodac zadanie? Podaj numer: ",this);
        String taskName=menuPrinter.questionString("Podaj nazwe zadania: ");
       calendar.get(categoryPosition).addTask(new Task(taskName));
    }


    public void removeTask() {
        int categoryPosition=menuPrinter.categoryAsk("Z ktorej kategori chcesz usunac zadanie? Podaj numer: ",this);
        int taskPosition=menuPrinter.taskAsk(categoryPosition,"Ktore zadanie chcesz usunac? Podaj numer: ", this);
        calendar.get(categoryPosition).removeTask(taskPosition);
    }

    public void markTask() throws Exception
    {
        int categoryPosition=menuPrinter.categoryAsk("Z ktorej kategori chcesz oznaczyc zadanie jako wykonane? Podaj numer: ",this);
        int taskPosition=menuPrinter.taskAsk(categoryPosition,"Ktore zadanie chcesz oznaczyc jako wykonane? Podaj numer: ",this);
        if(!(calendar.get(categoryPosition).getTask(taskPosition).setIsDone()))
            throw new Exception("Nie mozna bylo oznaczyc zadania jako wykonanego");
    }

    public Task getDoneTasks(int i, int j)
    {
        return calendar.get(i).getTask(j);
    }


}
