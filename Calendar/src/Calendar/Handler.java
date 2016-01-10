package Calendar;

/**
 * Created by Admin on 15.11.15.
 */
public class Handler {
    MenuPrinter menuPrinter;
    String[] arrayHandler ;
    Worker worker;

    public Handler(Worker worker)
    {
        menuPrinter = new MenuPrinter();
        arrayHandler = new String[2];
        this.worker=worker;
    }

    public Category HandleCategory() throws Exception {
        String categoryName=menuPrinter.QuestionString("Podaj nazwe nowej kategori: ");
        String categoryPriority=menuPrinter.QuestionString("Podaj priorytet kategori (URGENT,NORMAL,LOW): ");
        categoryPriority=categoryPriority.toLowerCase();
        return new Category(categoryName,Priority.valueOf(categoryPriority));
    }

    public Helper HandleTask() {
        int categoryPosition=menuPrinter.CategoryAsk("Do ktorej kategori chcesz dodac zadanie? Podaj numer: ", worker);
        String taskName=menuPrinter.QuestionString("Podaj nazwe zadania: ");
        return new Helper(categoryPosition,taskName);
    }

    public Helper HandleRemove() {
        int categoryPosition=menuPrinter.CategoryAsk("Z ktorej kategori chcesz usunac zadanie? Podaj numer: ",worker);
        int taskPosition=menuPrinter.TaskAsk(arrayHandler[0],"Ktore zadanie chcesz usunac? Podaj numer: ", worker);
        return new Helper(categoryPosition,taskPosition);
    }

    public Helper HandleMark() throws Exception
    {
        int categoryPosition=menuPrinter.CategoryAsk("Z ktorej kategori chcesz oznaczyc zadanie jako wykonane? Podaj numer: ",worker);
        worker.CheckIfThereAreUndoneTasks(categoryPosition);
        int taskPosition=menuPrinter.TaskAsk(arrayHandler[0],"Ktore zadanie chcesz oznaczyc jako wykonane? Podaj numer: ",worker);
        return new Helper(categoryPosition,taskPosition);
    }

}
