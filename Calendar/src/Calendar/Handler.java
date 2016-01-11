package Calendar;

/**
 * Created by Admin on 15.11.15.
 */
public class Handler {
    private MenuPrinter menuPrinter;
    private Worker worker;

    public Handler(Worker worker)
    {
        menuPrinter = new MenuPrinter();
        this.worker=worker;
    }

    public void HandleCategory() throws Exception {
        String categoryName=menuPrinter.questionString("Podaj nazwe nowej kategori: ");
        String categoryPriority=menuPrinter.questionString("Podaj priorytet kategori (URGENT,NORMAL,LOW): ");
        categoryPriority=categoryPriority.toLowerCase();
        worker.addCategory(new Category(categoryName,Priority.valueOf(categoryPriority)));
    }

    public void HandleTask() {
       int categoryPosition = menuPrinter.categoryAsk("Do ktorej kategori chcesz dodac zadanie? Podaj numer: ",worker);
       String taskName=menuPrinter.questionString("Podaj nazwe zadania: ");
        worker.addTask(categoryPosition,taskName);
    }

    public void HandleRemove() {
        int categoryPosition=menuPrinter.categoryAsk("Z ktorej kategori chcesz usunac zadanie? Podaj numer: ",worker);
        int taskPosition=menuPrinter.taskAsk(categoryPosition,"Ktore zadanie chcesz usunac? Podaj numer: ", worker);
        worker.removeTask(categoryPosition,taskPosition);
    }

    public void HandleMark() throws Exception
    {
        int categoryPosition=menuPrinter.categoryAsk("Z ktorej kategori chcesz oznaczyc zadanie jako wykonane? Podaj numer: ",worker);
        int taskPosition=menuPrinter.taskAsk(categoryPosition,"Ktore zadanie chcesz oznaczyc jako wykonane? Podaj numer: ",worker);
        worker.markTask(categoryPosition,taskPosition);
    }
}
