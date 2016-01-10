package Calendar;

/**
 * Created by Admin on 15.11.15.
 */
public class Handler {
    MenuPrinter menuPrinter;
    Worker worker;

    private int categoryPosition;
    private int taskPosition;
    private String taskName;

    public Handler(Worker worker)
    {
        menuPrinter = new MenuPrinter();
        this.worker=worker;
    }


    public Category HandleCategory() throws Exception {
        String categoryName=menuPrinter.questionString("Podaj nazwe nowej kategori: ");
        String categoryPriority=menuPrinter.questionString("Podaj priorytet kategori (URGENT,NORMAL,LOW): ");
        categoryPriority=categoryPriority.toLowerCase();
        return new Category(categoryName,Priority.valueOf(categoryPriority));
    }

    public Handler HandleTask() {
        categoryPosition = menuPrinter.categoryAsk("Do ktorej kategori chcesz dodac zadanie? Podaj numer: ",worker);
         taskName=menuPrinter.questionString("Podaj nazwe zadania: ");
        return this;
    }

    public Handler HandleRemove() {
        categoryPosition=menuPrinter.categoryAsk("Z ktorej kategori chcesz usunac zadanie? Podaj numer: ",worker);
        taskPosition=menuPrinter.taskAsk(categoryPosition,"Ktore zadanie chcesz usunac? Podaj numer: ", worker);
        return this;
    }

    public Handler HandleMark() throws Exception
    {
        categoryPosition=menuPrinter.categoryAsk("Z ktorej kategori chcesz oznaczyc zadanie jako wykonane? Podaj numer: ",worker);
        taskPosition=menuPrinter.taskAsk(categoryPosition,"Ktore zadanie chcesz oznaczyc jako wykonane? Podaj numer: ",worker);
        return this;
    }


    public int getCategoryPosition() {
        return categoryPosition;
    }

    public int getTaskPosition() {
        return taskPosition;
    }

    public String getTaskName() {
        return taskName;
    }
}
